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
public class Mano {
    
    private boolean manoActual;
    private List<Participante> listaParticipantesMano = new ArrayList();
    private int apuesta;

    public boolean isManoActual() {
        return manoActual;
    }

    public void setManoActual(boolean manoActual) {
        this.manoActual = manoActual;
    }

    public List<Participante> getListaParticipantesMano() {
        return listaParticipantesMano;
    }

    public void setListaParticipantesMano(List<Participante> listaParticipantesMano) {
        this.listaParticipantesMano = listaParticipantesMano;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    
    
    
}
