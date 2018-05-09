/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fachada;
import modelo.Juego;
import modelo.Jugador;
import modelo.Participante;

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
    public ControladorJuego(Juego juego, VistaJuego vista, Participante j) {
        this.juego = juego;
        this.vista = vista;      
        juego.addObserver(this);
        /* Esto hay que hacerlo en el login asi el sistema sabe si hay un juego nuevo*/
        //this.juego.agregarJugador(j);
    }
    
    /* Agregue este metodo por que como saque la segunda lista de jugadores por indicacion del docente, si dejaba en
    el constructor el agregar participante entonces en el inicio de la vista el constructor no habia acabado, entonces estaba en null
    y cuando se disparaba el evento daba una excepcion
    
    Es por eso que ahora la clase mesajuego primero crea el controlador y recien luego agrega al participante, hay que pensar y de ultima
    consultar al docente si eso esta bien, si esta bien que la vista llame a ese metodo del controlador o si deberiamos solucionar toda la
    linea en el mismo metodo del controlador.
    */
    public void agregarParticipante(Participante j) {
        try {
            Fachada.getInstancia().agregarJugadorSiguienteJuego(j);
        } catch (PokerExcepciones ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
    
    
    
    
    
    /* Metodo que escucha al juego y hace los cambios*/
    @Override
    public void update(Observable o, Object evento) {
        
         switch ((Juego.Eventos)evento) {
             case 
             ingresaNuevoParticipante:
             vista.mostrarParticipantes();
             break;
             
             case 
             inicioJuego:
             vista.inicioJuego();
             break;
       
        
    }
    
    
    } 
    
}
