/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author alex
 */
public class Juego extends Observable {

    private int pozo;
    private int luz;
    private int cantidadJugadores;
    private List<Mano> listaManos = new ArrayList();
    private List<Participante> listaParticipantes = new ArrayList();

    private Mazo mazo;
    /*Preguntar al docente*/
    private boolean iniciado;

   

    public enum Eventos {
        inicioJuego, ingresaNuevoParticipante, seEliminaParticipante, nuevaMano, nuevaApuesta, nuevaPagaoPasa;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    public List<Mano> getListaManos() {
        return listaManos;
    }

    public void setListaManos(List<Mano> listaManos) {
        this.listaManos = listaManos;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    /* Cuando se construye un juego nuevo necesitamos saber la cantidad de jugadores y la luz
    Inicializamos las listas vacias   
     */
    public Juego(int luz, int cantidadJugadores) {
        this.luz = luz;
        this.cantidadJugadores = cantidadJugadores;
        //this.listaManos = new ArrayList();
        //this.listaParticipantes = new ArrayList();
        this.mazo = new Mazo();

    }
    
  

    /* esto retrun a participante*/
    public void agregarJugador(Participante j) throws PokerExcepciones {
        /*Validar saldo y no este*/
        // Participante p = new Participante();

        /* Lo primero antes de agregar un jugador es verificar que haya lugar */
        if (!JugadorTieneSaldo(j.getJugador())) {
            throw new PokerExcepciones("El jugador no tiene el saldo suficiente");
        }

        if (jugadorYaEstaEnPartida(j)) {
            throw new PokerExcepciones("El jugador ya esta en la partida a iniciarse");
        }

        if (this.listaParticipantes.size() < this.cantidadJugadores) {

            j.setActivo(true);

            j.getJugador().setSaldo(j.getJugador().getSaldo() - this.luz);
            this.pozo = pozo + luz;
            this.listaParticipantes.add(j);
            /* Aviso el cambio */
            avisar(Eventos.ingresaNuevoParticipante);
        }

        if (this.cantidadJugadores == listaParticipantes.size()) {

            iniciarJuego();

        }

    }
    
    public void iniciarJuego()
    {
        this.iniciado = true;
        avisar(Eventos.inicioJuego);
        generarNuevaMano();
    }

    public void eliminarParticipante(Participante p) {
        /*Si el juego ya inicio, el participante no se le devuelve lo que haya puesto*/
        if (iniciado) {
            p.setActivo(false);

        } else {
            /* Si el juego no empezo, entonces le devolvemos el dinero y actualizamos el pozo*/
            p.getJugador().setSaldo(p.getJugador().getSaldo() + luz);
            pozo = pozo - luz;
            this.listaParticipantes.remove(p);

        }
        avisar(Eventos.seEliminaParticipante);
    }

    /* Metodo que avisa a los observadores*/
    private void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    private boolean JugadorTieneSaldo(Jugador j) {

        if (j.getSaldo() >= Fachada.getInstancia().getSiguienteJuego().getLuz() * Fachada.getInstancia().getSiguienteJuego().getCantidadJugadores()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean jugadorYaEstaEnPartida(Participante j) {
        if (Fachada.getInstancia().getSiguienteJuego().getListaParticipantes().contains(j)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Participante> getActivos() {
        List<Participante> resultado = new ArrayList();
        for (Participante p : listaParticipantes) {
            if (p.isActivo()) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public void generarNuevaMano() {
        Mano m = new Mano();
        m.setManoActual(true);

        /* Genero un nuevo mazo y lo barajo */
 
        this.mazo = new Mazo();
        this.mazo.barajar();

        /*Agrego a los participantes activos a la mano*/
        for (Participante p : listaParticipantes) {
            if (p.isActivo()) {
                m.getListaParticipantesMano().add(p);
                /* Le doy 5 cartas nuevas */
                p.setCartasMano(mazo.repartir(5));

            }
        }

        avisar(Eventos.nuevaMano);
    }

    /* Con esto vemos cual es la apuesta maxima*/
    public int obtenerApuestaMaxima() {
        int resultado = Integer.MAX_VALUE;

        for (Participante p : listaParticipantes) {
            if (p.getJugador().getSaldo() < resultado && p.isActivo()) {
                resultado = p.getJugador().getSaldo();
            }
        }

        return resultado;
    }

    public boolean validarApuesta(Participante p, int valor) {
        boolean valida = false;

        if (p.getJugador().getSaldo() >= valor && valor <= obtenerApuestaMaxima()) {
            valida = true;
        }

        return valida;
    }

    public void registrarApuesta(Participante p, int valor) {

        if (validarApuesta(p, valor)) {
            Apuesta a = new Apuesta();
            a.setDueno(p);
            a.setValor(valor);
            pozo = pozo + valor;
            /*Quitamos del saldo al jugador*/
            p.getJugador().restarAlSaldo(valor);
            avisar(Eventos.nuevaApuesta);
        }

    }
    
    public void pagarApuesta(Participante p, Apuesta a)
    {
        
        /* Consultar al docente por que, si cuando el jugador va a apostar tiene menos saldo que el */
        if (JugadorTieneSaldo(p.getJugador()))
        {
          a.getListaPagan().add(p);
          p.getJugador().restarAlSaldo(a.getValor());
          this.pozo = this.pozo+a.getValor();
        } else {
            /* Si en el medio el jugador tiene menos de lo necesario para pagar, pasa automaticamente*/
            a.getListaPasan().add(p);
        }
            
        /* Hay que avisar si alguien paso??*/
        if (hayDecision(a))
        {
            resolverGanador();
        } else {
            avisar(Eventos.nuevaPagaoPasa);
        }
    }
    
    /*  Esto es cuando no quiero pagar */
    public void pasarApuesta(Participante p, Apuesta a)
    {
        a.getListaPasan().add(p);
        /* Hay que avisar si alguien paso??*/
        if (hayDecision(a))
        {
            resolverGanador();
        } else {
            avisar(Eventos.nuevaPagaoPasa);
        }
    }
    
    
   /*  Este metodo lo que hace es calcular si todos los que podian tomar una 
    decision en la mano actual lo hicieron, si lo hacen devuelve true*/
    public boolean hayDecision(Apuesta a)
    {
        boolean result = false;
        
        int pagaron = a.getListaPagan().size();
        int pasaron = a.getListaPasan().size();
        if (pasaron+pagaron+1==this.getActivos().size())
        {
            result=true;
        }
        
        return result;
        
    }
    
     private void resolverGanador() {
        
    }

}
