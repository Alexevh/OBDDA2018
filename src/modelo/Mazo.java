/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Carta.Palo;

/**
 *
 * @author alex
 */
public class Mazo {
 
    private List<Carta> cartas;

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Mazo() {
        
        this.cartas = new ArrayList();
        
        for (Palo p: Carta.Palo.values())
        {
            for (int i=2; i<15; i++)
            {
                Carta c = new Carta(p, i);
                
                this.cartas.add(c);
            }
            
        }
        
    }
    
    
    public  void barajar(){
        
        Collections.shuffle(cartas);
    }
    
    
    
    
    
    
}
