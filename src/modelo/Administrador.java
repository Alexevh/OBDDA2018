/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alex
 */
public class Administrador  extends Usuario{

    public Administrador(String nombreCompleto, String login, String pass) {
        
        super.setNombreCompleto(nombreCompleto);
        super.setNombreUsuario(login);
        super.setPassword(pass);
    }
    
    
}
