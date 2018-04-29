/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class SistemaUsuarios {
    
    private List<Usuario> listaUsuarios = new ArrayList();

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void agregarUsuario (Usuario u)
    {
        this.listaUsuarios.add(u);
    }
    
    public Usuario loginAdmin(String login, String password)
    {
        for (Usuario a: listaUsuarios)
        {
            if (a.getClass().equals(Administrador.class) && a.getNombreUsuario().equalsIgnoreCase(login) && a.getPassword().equals(password))
            {
                return a;
            }
        }
        
        return null;
        
    }
}
