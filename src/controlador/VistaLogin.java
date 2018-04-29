/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author alex
 */
public interface VistaLogin {
    
     public void errorLoginIncorrecto();

    public void ingresar(Usuario u);
}
