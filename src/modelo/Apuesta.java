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
public class Apuesta {
    
    /* En nuestro UML las listas son de jugadores, mi duda es si se necesitaba por algo de la letra*/
    private int valor;
    private Participante dueno;
    private List<Participante> listaPagan = new ArrayList();
    private List<Participante> listaPasan = new ArrayList();
   
    
    

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Participante getDueno() {
        return dueno;
    }

    public void setDueno(Participante dueno) {
        this.dueno = dueno;
    }

    public List<Participante> getListaPagan() {
        return listaPagan;
    }

    public void setListaPagan(List<Participante> listaPagan) {
        this.listaPagan = listaPagan;
    }

    public List<Participante> getListaPasan() {
        return listaPasan;
    }

    public void setListaPasan(List<Participante> listaPasan) {
        this.listaPasan = listaPasan;
    }





    
    
}
