/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class Juego {
    
    private int pozo;
    private int luz;
    private int cantidadJugadores;
    private List<Mano> listaManos;
    private List<Participante> listaParticipantes;
    private List<Jugador> listaJugadores;
    private Mazo mazo;

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

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    

    /* Cuando se construye un juego nuevo necesitamos saber la cantidad de jugadores y la luz
    Inicializamos las listas vacias   
    */
    public Juego(int luz, int cantidadJugadores) {
        this.luz = luz;
        this.cantidadJugadores = cantidadJugadores;
        this.listaManos = new ArrayList();
        this.listaParticipantes = new ArrayList();
        this.mazo = new Mazo();
        this.listaJugadores = new ArrayList();
        
    }
    
    
    
}
