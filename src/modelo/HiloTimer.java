/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.Random;
import modelo.Fachada.Eventos;

/**
 *
 * @author alex
 */
public class HiloTimer extends Thread{
    
    private Juego j;

    public Juego getJ() {
        return j;
    }

    public void setJ(Juego j) {
        this.j = j;
    }
    
    
    
     public HiloTimer(String name, Juego j) {
        super(name);
        this.j = j;
    }
    
    @Override
    public void run(){
        
        for(int x=1;x<=30;x++){
            try {
                /* ACtualziamos el timer */
                j.aumentarTimer(x);
                
                
                sleep(1000);
                
                x++;
                
            } catch (InterruptedException ex) { }
            System.out.println(getName() + ":" + x);
        }
        
        //j.avisar(Juego.Eventos.timerApuesta);
        
        
    }
}
