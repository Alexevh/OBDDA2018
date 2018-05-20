/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author alex
 */
public class Fachada extends Observable{
    
    private SistemaJuegos sisJuegos = new SistemaJuegos();
    private SistemaUsuarios sisUsuarios = new SistemaUsuarios();
    
    /* Enum con la lista de eventos que reportamos */
     public enum Eventos{
        inicioJuego;
    }
     
    /*El metodo que avisa a los observadores*/ 
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    
    
    
    /* Singleton */
     private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
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
    
    
    
    
}
