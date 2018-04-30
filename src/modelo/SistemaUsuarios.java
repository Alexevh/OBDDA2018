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
    
    private List<Usuario> listaAdministradores= new ArrayList();
private List<Usuario> ListaJugadores= new ArrayList();

    public List<Usuario> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Usuario> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Usuario> getListaJugadores() {
        return ListaJugadores;
    }

    public void setListaJugadores(List<Usuario> ListaJugadores) {
        this.ListaJugadores = ListaJugadores;
    }
    
    public void agregarAdministrador(Administrador a)
    {
        if (!this.listaAdministradores.contains(a))
        {
            this.listaAdministradores.add(a);
        }
        
    }
    
     public void agregarJugador(Jugador j)
    {
         if (!this.ListaJugadores.contains(j))
        {
            this.ListaJugadores.add(j);
        }
    }


    
    /*  No castear, usar 2 listas una para admin y otra para jugadores */
    public Usuario loginAdmin(String login, String password)
    {
        for (Usuario a: listaAdministradores)
        {
            if (a.getNombreUsuario().equalsIgnoreCase(login) && a.getPassword().equals(password))
            {
                return a;
            }
        }
        
        return null;
        
    }
}
