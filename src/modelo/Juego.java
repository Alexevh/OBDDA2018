/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author alex
 */
public class Juego extends Observable{
    
    private int pozo;
    private int luz;
    private int cantidadJugadores;
    private List<Mano> listaManos;
    private List<Participante> listaParticipantes;
    private List<Jugador> listaJugadores;
    private Mazo mazo;
    /*Preguntar al docente*/
    private boolean iniciado;
    
    public enum Eventos {
        inicioJuego, ingresaNuevoParticipante;
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
    
    /* preguntar si se agrega a ambas listas  devolver al particpante*/
    public void agregarJugador(Jugador j)
    {
        /* Lo primero antes de agregar un jugador es verificar que haya lugar */
        if (this.listaJugadores.size() < this.cantidadJugadores)
        {
            this.listaJugadores.add(j);
            Participante p = new Participante();
            p.setActivo(true);
            p.setJugador(j);
            this.listaParticipantes.add(p);
            /* Aviso el cambio */
            avisar(Eventos.ingresaNuevoParticipante);
        }
    }
    
    /* Metodo que avisa a los observadores*/
      private void avisar(Eventos evento) {
        setChanged();
        notifyObservers(evento);
    }
    
    
}
