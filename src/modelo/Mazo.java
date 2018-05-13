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
    
    
    /* Recibo un parametro por que ahora son cartas pero puedo llegar a querer reemplazar una*/
    public List<Carta> repartir(int cantidad)
    {
        List<Carta> result = new ArrayList();
        
        for (int i=0; i<cantidad;i++)
        {
            /*Obtengo la carta, sienmpre es la cero porque una vez que la doy la elimino del mazo
            y la siguiente carta es la del top*/
            Carta c = cartas.get(0);
            /*La agrego al resultado*/
            result.add(c);
            /* La quito del mazo */
            cartas.remove(c);
            
        }
        
        return result;
    }
    
    
    
    
}
