/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mapeadores.MapeadorJuego;
import persistencia.Mapeador;
import persistencia.Persistencia;


public class SistemaJuegos extends Observable {
    
    private List<Juego> listaJuegos = new ArrayList();
    private List<Juego> listaJuegosTerminados = new ArrayList();
    private List<FiguraMano> listaFiguras = new ArrayList();
    
    private int maxJugadores = 2;
    private int luz = 1;
    /* Esto es para calcular el saldo antes de dejar entrar al jugador, si el saldo del jugador es menor a este numero X luz entonces no entra*/
    private int minimasApuestas = 3;
    private List<Jugador> listaJugadores = new ArrayList();
    private List<Administrador> listaAdmins = new ArrayList();
    private Juego proximoJuego = new Juego(luz, maxJugadores);

   
    
    public enum Eventos {
        seAgregoUnNuevoJuego;
    }

    
    
    public SistemaJuegos() {
        
        poblarListaFiguras();
    }

    public List<Juego> getListaJuegosTerminados() {
        /* Cragar la lista de partidas finalizadas */
        Juego j = new Juego();

       Mapeador m = new MapeadorJuego(j);
       this.listaJuegosTerminados = Persistencia.getInstancia().todosJuegos(m);
        return listaJuegosTerminados;
    }

    public void setListaJuegosTerminados(List<Juego> listaJuegosTerminados) {
        this.listaJuegosTerminados = listaJuegosTerminados;
    }
    
    
    private boolean jugadorEstaEnPartidaEnCurso(Participante p)
    {
        boolean resultado = false;
        
        for (Juego j: listaJuegos)
        {
            if (j.getActivos().contains(p) && j!=proximoJuego ){
                return true;
            }
        }
        
        
        return resultado;
    }
    
    
    
    /* por experto */
    public void agregarJugadorAproximoJuego(Participante j) throws PokerExcepciones 
    {
        /*
        if (jugadorEstaEnPartidaEnCurso(j))
        {
            throw new PokerExcepciones("El jugador esta en una partida activa");
        }*/
        this.proximoJuego.agregarJugador(j);
        if (proximoJuego.getCantidadJugadores()==proximoJuego.getListaParticipantes().size())
        {
            this.listaJuegos.add(proximoJuego);
            this.proximoJuego = new Juego(luz, maxJugadores);
            Fachada.getInstancia().avisar(Fachada.Eventos.seAgregoUnNuevoJuego);
        }
    }

     /* Metodo que avisa a los observadores*/
    private void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public List<FiguraMano> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<FiguraMano> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }
  
  
    

    public int getMinimasApuestas() {
        return minimasApuestas;
    }

    public void setMinimasApuestas(int minimasApuestas) {
        this.minimasApuestas = minimasApuestas;
    }
    
    
    public List<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(List<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }

    public Juego getProximoJuego() {
        return proximoJuego;
    }

    public void setProximoJuego(Juego proximoJuego) {
        this.proximoJuego = proximoJuego;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public List<Administrador> getListaAdmins() {
        return listaAdmins;
    }

    public void setListaAdmins(List<Administrador> listaAdmins) {
        this.listaAdmins = listaAdmins;
    }
    
    
    
    
    
    public void actualizarLuz(int valor) throws PokerExcepciones
    {
        if (validarLuz(valor))
        {
            /* El valor de la luz en el cambio siempre cambia */
            this.luz = valor;
            
            /* Si el juego siguiente no arranco y tampoco hay nadie en espera entonces le actualizamos la luz*/
            if (!proximoJuego.isIniciado() && proximoJuego.getListaParticipantes().isEmpty())
            {
                proximoJuego.setLuz(luz);
            }
            
        } else 
        {
            throw new PokerExcepciones("Valor de la luz inválido, debe ser mayor a cero");
        }
    }
    
    
   public void actualizarMaximoJugadores(int numero) throws PokerExcepciones
   {
       if (numero >=2 & numero <6)
       {
           /*Paso 1, actualizamos el valor*/
           maxJugadores = numero;
           
           if (proximoJuego.getListaParticipantes().size()<numero)
           {
               proximoJuego.setCantidadJugadores(maxJugadores);
               
               
           } else if (proximoJuego.getListaParticipantes().size()==numero)
           {
               proximoJuego.setCantidadJugadores(maxJugadores);
               proximoJuego.iniciarJuego();
           }
           
           
           
           
       } else {
           throw new PokerExcepciones("La cantidad de jugadores por partida debe ser mayor o igual a 2 y menor a 6");
       }
   }
    
    
    public boolean validarLuz(int valor)
    {
        boolean result = false;
        
        if (valor>0)
        {
            result=true;
        }
        
        return result;
        
    }
    
    
    public List<Juego> obtenerJuegosActivos()
    {
      List<Juego> partidas = new ArrayList();
      
      for (Juego j: listaJuegos)
      {
          /* Is iniciado nos devuelve true siempre que el juego haya iniciado y ademas este activo, si el juego termina da false*/
          if (j.isIniciado())
          {
              partidas.add(j);
          }
      }
      
      
      return partidas;
    }
    
    
   private void poblarListaFiguras() {
       
       FiguraMano par = new FiguraPar();
       FiguraMano doblepar = new FiguraDoblePar();
       FiguraMano color = new FiguraColor();
       FiguraMano vacia = new FiguraVacia();
       this.listaFiguras.add(par);
       this.listaFiguras.add(doblepar);
       this.listaFiguras.add(color);
       this.listaFiguras.add(vacia);
       Collections.sort(this.listaFiguras, Collections.reverseOrder());
       
    }
   
     /* Esto quizas vaya a sistemJuegos */
   public FiguraMano figuraEnLaMano(List<Carta> lista) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException
   {
       FiguraMano figura = new FiguraVacia();
       
       for (FiguraMano fig: Fachada.getInstancia().getListaFiguras())
       {
           if (fig.tiene(lista)==true)
           {
              FiguraMano f = fig.getClass().getDeclaredConstructor(List.class).newInstance(lista);
              return f;
           
           }
       }
       
       
       return figura;
   }
    
    
}
