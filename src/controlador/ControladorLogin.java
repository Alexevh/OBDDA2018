/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Administrador;
import modelo.Fachada;
import modelo.Jugador;

/**
 *
 * @author alex
 */
public class ControladorLogin {
    
    private Fachada fachada =  Fachada.getInstancia();
    private VistaLogin vista;
    
      public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
   
          public void loginAdmin(String u, String p)
    {
        Administrador a = fachada.loginAdmin(u, p);
        
        if (a==null)
        {
            vista.errorLoginIncorrecto();
            
        } else {
            vista.ingresar(a);
        }
        
    }
          
         public void loginJugador(String u, String p)
    {
        Jugador j = fachada.loginJugador(u, p);
        
        if (j==null)
        {
            vista.errorLoginIncorrecto();
            
        } else {
            vista.ingresar(j);
        }
        
    }     
      
}
