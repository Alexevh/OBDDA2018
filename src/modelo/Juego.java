/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
    private int contadorRespuestas;
    private int contadorRespuestasObtenidas;
    private Participante ultimoGanador;
    private Date fechaInicio;
   
    private Mazo mazo;
    /*Preguntar al docente*/
    private boolean iniciado;

    SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
    

    public enum Eventos {
        inicioJuego, ingresaNuevoParticipante, seEliminaParticipante, nuevaMano, nuevaApuesta, nuevaPagaoPasa, hayGanador, finJuego, manoNuevaSiNo, huboEmpate, expulsarParticipante;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    
    
    public Participante getUltimoGanador() {
        return ultimoGanador;
    }

    public void setUltimoGanador(Participante ultimoGanador) {
        this.ultimoGanador = ultimoGanador;
    }

    public int getContadorRespuestas() {
        return contadorRespuestas;
    }

    public void setContadorRespuestas(int contadorRespuestas) {
        this.contadorRespuestas = contadorRespuestas;
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
        avisar(Eventos.ingresaNuevoParticipante);
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
            /*Luego de descontarle la luz registramos el saldo inicial*/
            j.setSaldoInicial(j.getJugador().getSaldo());
            j.setTotalApostado(j.getTotalApostado()+luz);
            
            this.pozo = pozo + luz;
            this.listaParticipantes.add(j);
            /* Aviso el cambio */
            avisar(Eventos.ingresaNuevoParticipante);
        }

        if (this.cantidadJugadores == listaParticipantes.size()) {

            j.setActivo(true);
            iniciarJuego();

        }

    }

    public void iniciarJuego()  {
        this.iniciado = true;
        this.fechaInicio = new Date();
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
        
        if (getActivos().size()==1)
        {
            getActivos().get(0).getJugador().sumarAlSaldo(pozo);
            this.setIniciado(false);
           avisar(Eventos.finJuego);
            
        } else {
            avisar(Eventos.seEliminaParticipante);
        }
        
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
        this.listaManos.add(m);

        
        /* Genero un nuevo mazo y lo barajo */
        this.mazo = new Mazo();
        this.mazo.barajar();

        /*Agrego a los participantes activos a la mano*/
        for (Participante p : listaParticipantes) {
            if (p.isActivo()) {
                m.getListaParticipantesMano().add(p);
                /* Le doy 5 cartas nuevas */
                p.setCartasMano(mazo.repartir(5));
                
                /*Registro que participo en esta mano*/
                p.setCantidadManosJugadas(p.getCantidadManosJugadas()+1);
                Collections.sort(p.getCartasMano(), Collections.reverseOrder());
                
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

        if (p.getJugador().getSaldo() >= valor && valor <= obtenerApuestaMaxima() && valor>0) {
            valida = true;
        }

        return valida;
    }

    public void registrarApuesta(Participante p, int valor) throws PokerExcepciones  {

        if (validarApuesta(p, valor)) {
            Apuesta a = new Apuesta();
            a.setDueno(p);
            a.setValor(valor);
            p.setTotalApostado(p.getTotalApostado()+valor);
            getManoActual().setApuesta(a);
            pozo = pozo + valor;
            /*Quitamos del saldo al jugador*/
            p.getJugador().restarAlSaldo(valor);

            /* Hay que vaciar la lista de los que ya pasaron*/
            a.getListaPasan().clear();

            avisar(Eventos.nuevaApuesta);
        } else {
            throw new PokerExcepciones("Error, el monto de la apuesta no es valido, debe ser mayor que cero y menor a :"+obtenerApuestaMaxima());
        }

    }

    public void pagarApuesta(Participante p, Apuesta a) {

        /* Consultar al docente por que, si cuando el jugador va a apostar tiene menos saldo que el */
        if (JugadorTieneSaldo(p.getJugador())) {
            a.getListaPagan().add(p);
            p.getJugador().restarAlSaldo(a.getValor());
            p.setTotalApostado(p.getTotalApostado()+a.getValor());
            this.pozo = this.pozo + a.getValor();
        } else {
            /* Si en el medio el jugador tiene menos de lo necesario para pagar, pasa automaticamente*/
            a.getListaPasan().add(p);
        }

        /* Hay que avisar si alguien paso??*/
        if (hayDecision(a)) {
            resolverGanador(getManoActual());
        } else {
            avisar(Eventos.nuevaPagaoPasa);
        }
    }

    /*  Esto es cuando no quiero pagar */
    public void pasarApuesta(Participante p, Apuesta a) {
        a.getListaPasan().add(p);
        System.out.println("El participante "+p.getJugador().getNombreCompleto()+" paso");
      
        /* Hay que avisar si alguien paso??*/
        if (hayDecision(a)) {
           
            resolverGanador(getManoActual());
        } else {
            avisar(Eventos.nuevaPagaoPasa);
        }
    }

    /*  Este metodo lo que hace es calcular si todos los que podian tomar una 
    decision en la mano actual lo hicieron, si lo hacen devuelve true*/
    public boolean hayDecision(Apuesta a) {
        boolean result = false;
        int pagaron = a.getListaPagan().size();
        int pasaron = a.getListaPasan().size();
        
      

        if (todosPasaron(a)) {
            result = true;
        } 
        
        
        else  if (pasaron + pagaron + 1 == this.getActivos().size() && a.getDueno()!=null) {
            result = true;
        }

        return result;

    }

    public boolean todosPasaron(Apuesta a) {
        boolean resultado = false;

        int pasaron = a.getListaPasan().size();

        if (pasaron == this.getActivos().size()) {
            resultado = true;
        }

        return resultado;
    }

    private void resolverGanador(Mano m) {

        
        if (m.getApuesta().getDueno()==null || todosPasaron(m.getApuesta())) {
            
          
           m.setManoActual(false);
           
           contadorRespuestasObtenidas =0;
           contadorRespuestas = getActivos().size();
           
           /* Todos los jugadores con saldo 0 o sea menor o igual a la luz actual       
           La letra dice solo saldo cero, preguntar al docente
           */
           expulsarPobres();
           avisar(Eventos.huboEmpate);
           
           

        } else {
            
            
            /*Mientras resolvemos el algoritmo de ganador, el due;o siempre gana*/
            m.setGanador(obtenerGanador(m));

            /*Pagamos la apuesta*/
            m.getGanador().getJugador().sumarAlSaldo(pozo);
            
            /* Registramos lo que va ganando */
            m.getGanador().setTotalGanado(m.getGanador().getTotalGanado()+pozo);
            
            /*Reiniciar el pozo*/
            pozo = 0;
            /* Si damos por terminada la mano, ya no es la actual*/
            m.setManoActual(false);

            /* Registrar la cantidad de jugadores activos para saber cuantas respuestas necitamos*/
            contadorRespuestas = getActivos().size();
            /* Refrescamos el ultio ganador*/
            this.ultimoGanador = m.getGanador();
         
            expulsarPobres();
            /* Avisamos que hay ganador, preguntar al docente, si la expulsion no la debriamos hacer aca tamien*/
            avisar(Eventos.hayGanador);
          
            
        }

    }
    
    
    public Participante obtenerGanador(Mano m)
    {
        Participante ganador = m.getApuesta().getDueno();
        Carta ganadora =m.getApuesta().getDueno().getCartasMano().get(0);
        
        if (m.getApuesta().getListaPagan().isEmpty())
        {
            return ganador;
        }
        
        
        for (Participante p: m.getApuesta().getListaPagan())
        {
          
          if (p.getCartasMano().get(0).compareTo(ganadora)==1)
            {
                ganadora = p.getCartasMano().get(0);
                ganador = p;
            }
        }
        
        return ganador;
    }
    

    public Mano getManoActual() {
        for (Mano m : listaManos) {
            if (m.isManoActual()) {
                return m;
            }
        }

        return null;
    }

    public void registrarDesicionParticipantes(Participante p, boolean decicion) {
        if (!decicion) {
            p.setActivo(false);
            contadorRespuestasObtenidas++;
            avisar(Eventos.manoNuevaSiNo);
        } else {

            pozo = pozo + luz;
            p.getJugador().restarAlSaldo(luz);
            p.setTotalApostado(p.getTotalApostado()+luz);
            contadorRespuestasObtenidas++;
            avisar(Eventos.manoNuevaSiNo);
        }

        if (contadorRespuestasObtenidas == contadorRespuestas) {
            if (getActivos().size() <= 1) {
                this.setIniciado(false);
                
                avisar(Eventos.finJuego);
            } else {
                vaciarContadores();
                generarNuevaMano();
                
            }

        }

    }

    private void vaciarContadores() {
        contadorRespuestas = 0;
        contadorRespuestasObtenidas = 0;
    }
    
    private void expulsarPobres() {
        
        for (Participante p: getActivos())
        {
            if (p.getJugador().getSaldo()<=luz)
            {
                p.setActivo(false);
                avisar(Eventos.expulsarParticipante);
            }
        }
    }
    
    public boolean participanteTieneSaldo(Participante p)
    {
        if (p.getJugador().getSaldo()<=luz)
        {
            return false;
        } else {
            return true;
        }
    }
    
    
    @Override
    public String toString()
    {
        return "Juego :"+this.dt1.format(fechaInicio)+"- Cantidad de manos = "+this.listaManos.size()+ " Apuestas $:"+obtenerTotalApuestas();
    }
    
    public int obtenerTotalApuestas()
    {
        int total =0;
        
        for (Participante p : this.listaParticipantes)
        {
            total =+ p.getTotalApostado();
        }
        
        return total;
        
    }
    
    
    /*El juego si puede ir directo a la fachada y pedir que avise a sus observadores */

}
