/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Fachada extends Observable{
    
    private SistemaJuegos sisJuegos = new SistemaJuegos();
    private SistemaUsuarios sisUsuarios = new SistemaUsuarios();
    

    
    /* Singleton */
     private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }

    
    
     public enum Eventos {
        seAgregoUnNuevoJuego, nuevaMano;
    }
    
    public void agregarAdmin(Administrador a)
    {
        sisUsuarios.agregarAdministrador(a);
    }
    
    
     public void agregarJugador(Jugador j)
    {
        sisUsuarios.agregarJugador(j);
    }
    
    public Administrador loginAdmin(String nombre, String password) throws PokerExcepciones
    {
       return sisUsuarios.loginAdmin(nombre, password);
    }
    
  
    public Juego getSiguienteJuego(){
        return sisJuegos.getProximoJuego();
    }
    
    public void agregarJugadorSiguienteJuego(Participante j) throws PokerExcepciones 
    {
        sisJuegos.agregarJugadorAproximoJuego(j);
    }

    public int getMinimasApuestas() {
        return sisJuegos.getMinimasApuestas();
    }

    public Participante loginJugador(String login, String password) throws PokerExcepciones {
        return sisUsuarios.loginJugador(login, password);
    }

    public int getLuz() {
        return sisJuegos.getLuz();
    }

    public void actualizarLuz(int valor) throws PokerExcepciones {
        sisJuegos.actualizarLuz(valor);
    }

    public int getMaxJugadores() {
        return sisJuegos.getMaxJugadores();
    }

    public void actualizarMaximoJugadores(int numero) throws PokerExcepciones {
        sisJuegos.actualizarMaximoJugadores(numero);
    }

    public List<Juego> obtenerJuegosActivos() {
        return sisJuegos.obtenerJuegosActivos();
    }
    
    public List<Juego>  obtenerJuegosFinalizados() {
       return sisJuegos.getListaJuegosTerminados();
    }
    
    
    
      /* Metodo que avisa a los observadores*/
    public void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }

    public List<Juego> getListaJuegosTerminados() {
        return sisJuegos.getListaJuegosTerminados();
    }

    public List<FiguraMano> getListaFiguras() {
        return sisJuegos.getListaFiguras();
    }

    public FiguraMano figuraEnLaMano(List<Carta> lista) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        return sisJuegos.figuraEnLaMano(lista);
    }

   
    
  
    
}
