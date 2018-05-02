/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Juego;
import modelo.Jugador;

/**
 *
 * @author alex
 */
public class ControladorJuego implements Observer{
    
    private Juego juego;
    private VistaJuego vista;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public VistaJuego getVista() {
        return vista;
    }

    public void setVista(VistaJuego vista) {
        this.vista = vista;
    }

    /* Cambiar jugador por particpante, */
    public ControladorJuego(Juego juego, VistaJuego vista, Jugador j) {
        this.juego = juego;
        this.vista = vista;      
        juego.addObserver(this);
        /* Esto hay que hacerlo en el login asi el sistema sabe si hay un juego nuevo*/
        this.juego.agregarJugador(j);
    }
    
    
    
    
    
    /* Metodo que escucha al juego y hace los cambios*/
    @Override
    public void update(Observable o, Object evento) {
        
         if(evento.equals(Juego.Eventos.ingresaNuevoParticipante)){
           vista.mostrarParticipantes();
       }
        
    }
    
    
    
    
}
