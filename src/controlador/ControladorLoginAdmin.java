/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import modelo.Administrador;
import modelo.Fachada;

/**
 *
 * @author alex
 */
public class ControladorLoginAdmin {
 
        
    private Fachada fachada = Fachada.getInstancia();
    private VistaLogin vista;

    public ControladorLoginAdmin(VistaLogin vista) {
        this.vista = vista;
    }
    
    
    
    
      
   public void loginAdmin(String u, String p)throws PokerExcepciones  {
       
       try {
           Administrador a = fachada.loginAdmin(u, p);
       vista.ingresar(a);
       } catch (PokerExcepciones ex)
       {
           vista.errorLoginIncorrecto(ex.getMessage());
       }
       
   
        
    }


}
