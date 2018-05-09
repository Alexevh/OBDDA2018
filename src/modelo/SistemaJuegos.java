/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.util.ArrayList;
import java.util.List;


public class SistemaJuegos {
    
    private List<Juego> listaJuegos = new ArrayList();
    
    private int maxJugadores = 2;
    private int luz = 10;
    /* Esto es para calcular el saldo antes de dejar entrar al jugador, si el saldo del jugador es menor a este numero X luz entonces no entra*/
    private int minimasApuestas = 3;
    private List<Jugador> listaJugadores = new ArrayList();
    private List<Administrador> listaAdmins = new ArrayList();
    private Juego proximoJuego = new Juego(luz, maxJugadores);
    

    public SistemaJuegos() {
        
        /* Consultar al docente si cargamos el juego a la lista o no antes de iniciarse
        Consultar si conviene o no tener lista de participantes en el sistema de juegos
        
        */
        //this.listaJuegos.add(proximoJuego);
    }
    
    /* por experto */
    public void agregarJugadorAproximoJuego(Participante j) throws PokerExcepciones 
    {
        this.proximoJuego.agregarJugador(j);
        if (proximoJuego.getCantidadJugadores()==proximoJuego.getListaParticipantes().size())
        {
            this.listaJuegos.add(proximoJuego);
            this.proximoJuego = new Juego(luz, maxJugadores);
            System.out.println("sss");
        }
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
    
    
    
}
