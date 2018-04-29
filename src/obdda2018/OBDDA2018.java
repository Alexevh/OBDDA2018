/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obdda2018;

import com.sun.prism.impl.BaseMesh;
import modelo.Administrador;
import modelo.Fachada;
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
       
        
        
    }

    private static void generarUsuarios() {
       
        /* Agrego a dos administradores */
        Administrador a1 = new Administrador("Jack Bauer", "jack", "password");  
        Administrador a2 = new Administrador("Peter Parker", "peter", "password");
        Fachada.getInstancia().agregarUsuario(a1);
        Fachada.getInstancia().agregarUsuario(a2);
        
        /* Agrego a tres jugadores */
        Jugador j1 = new Jugador("Mario B", "mario", "password", 500); 
        Jugador j2 = new Jugador("Luigi B", "luigi", "password", 500); 
        Jugador j3 = new Jugador("Amanda A", "amanda", "password", 500); 
        
        Fachada.getInstancia().agregarUsuario(j1);
        Fachada.getInstancia().agregarUsuario(j2);
        Fachada.getInstancia().agregarUsuario(j3);
        
        new MenuInicial().setVisible(true);
      
    }

   
    
}
