/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author alex
 */
public class Apuesta {
    
    /* En nuestro UML las listas son de jugadores, mi duda es si se necesitaba por algo de la letra*/
    private int valor;
    private Jugador dueno;
    private List<Jugador> listaPagan;
    private List<Jugador> listaPasan;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Jugador getDueno() {
        return dueno;
    }

    public void setDueno(Jugador dueno) {
        this.dueno = dueno;
    }

    public List<Jugador> getListaPagan() {
        return listaPagan;
    }

    public void setListaPagan(List<Jugador> listaPagan) {
        this.listaPagan = listaPagan;
    }

    public List<Jugador> getListaPasan() {
        return listaPasan;
    }

    public void setListaPasan(List<Jugador> listaPasan) {
        this.listaPasan = listaPasan;
    }

    
    
}
