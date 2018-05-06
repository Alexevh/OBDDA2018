/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obdda2018;

import com.sun.prism.impl.BaseMesh;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Juego;
import modelo.Jugador;
import modelo.SistemaUsuarios;

/**
 *
 * @author alex
 */
public class OBDDA2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        generarUsuarios();
        generarJuego();
        new MenuInicial().setVisible(true);
        
        
    }

    private static void generarUsuarios() {
       
        /* Agrego a dos administradores */
        Administrador a1 = new Administrador("Jack Bauer", "jack", "password");  
        Administrador a2 = new Administrador("Peter Parker", "peter", "password");
        Fachada.getInstancia().agregarAdmin(a1);
        Fachada.getInstancia().agregarAdmin(a2);
        
        /* Agrego a tres jugadores */
        Jugador j1 = new Jugador("Mario B", "mario", "password", 500); 
        Jugador j2 = new Jugador("Luigi B", "luigi", "password", 400); 
        Jugador j3 = new Jugador("Amanda A", "amanda", "password", 20); 
        
        Fachada.getInstancia().agregarJugador(j1);
        Fachada.getInstancia().agregarJugador(j2);
        Fachada.getInstancia().agregarJugador(j3);
        
        
      
    }

    private static void generarJuego() {
        
        
        
    }

   
    
}
