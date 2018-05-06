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

/**
 *
 * @author alex
 */
public class ControladorLogin {
    
    private Fachada fachada = Fachada.getInstancia();
    private VistaLogin vista;
    
    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void loginAdmin(String u, String p) {
        Administrador a = fachada.loginAdmin(u, p);
        vista.ingresar(a);
        
        if (a == null) {
            vista.errorLoginIncorrecto("Incorrecto");
            
        } else {
            
        }
        
    }
    
    public void loginJugador(String u, String p) throws PokerExcepciones {
        
        try {
            Jugador j = fachada.loginJugador(u, p);
            vista.ingresar(j);
        } catch (PokerExcepciones e) {
            vista.errorLoginIncorrecto(e.getMessage());
        }
        
    }    
    
}
