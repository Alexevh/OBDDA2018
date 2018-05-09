/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Participante;

/**
 *
 * @author alex
 */
public class ControladorLogin {
    
    private Fachada fachada = Fachada.getInstancia();
    private VistaLoginParticipante vista;

    public VistaLoginParticipante getVista() {
        return vista;
    }

    public void setVista(VistaLoginParticipante vista) {
        this.vista = vista;
    }
    
    
    
    public ControladorLogin(VistaLoginParticipante vista)
    {
        this.vista = vista;
    }
    
  
    /*
   public void loginAdmin(String u, String p)throws PokerExcepciones  {
       
       try {
           Administrador a = fachada.loginAdmin(u, p);
       vista.ingresar(a);
       } catch (PokerExcepciones ex)
       {
           vista.errorLoginIncorrecto(ex.getMessage());
       }
       
   
        
    }
*/
    
   
    
    public void loginJugador(String u, String p) throws PokerExcepciones {
        
        try {
            Participante pa = fachada.loginJugador(u, p);
           
            vista.ingresar(pa);
        } catch (PokerExcepciones e) {
            vista.errorLoginIncorrecto(e.getMessage());
        }
        
    }    
    
}
