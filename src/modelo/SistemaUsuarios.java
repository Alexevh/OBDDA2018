/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.PokerExcepciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class SistemaUsuarios {
    
    private List<Administrador> listaAdministradores= new ArrayList();
private List<Jugador> listaJugadores= new ArrayList();

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> ListaJugadores) {
        this.listaJugadores = ListaJugadores;
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
         if (!this.listaJugadores.contains(j))
        {
            this.listaJugadores.add(j);
        }
    }


    
    /*  No castear, usar 2 listas una para admin y otra para jugadores */
    public Administrador loginAdmin(String login, String password)
    {
        for (Administrador a: listaAdministradores)
        {
            if (a.getNombreUsuario().equalsIgnoreCase(login) && a.getPassword().equals(password))
            {
                return a;
            }
        }
        
        return null;
        
    }
    
    /*  Es el sistema que levanta la excepcion?*/
       public Jugador loginJugador(String login, String password) throws PokerExcepciones
    {
        boolean encontre = false;
        Jugador encontrado = null;
        Participante p= null;
        
        for (Jugador j: listaJugadores)
        {
            if (j.getNombreUsuario().equalsIgnoreCase(login) && j.getPassword().equals(password))
            {
                encontre = true;
                p = new Participante();
                p.setJugador(j);
                encontrado=j;
                
            }
        } 
        
        if (encontre)
        {
            if (!JugadorTieneSaldo(encontrado))
            {
                throw new PokerExcepciones("El jugador no tiene el saldo suficiente para ingresar a la partida siguiente");
            } else if(jugadorYaEstaEnPartida(p))
            {
                throw new PokerExcepciones("El jugador ya esta como participante en el siguiente juego a iniciarse");
            }
 
            else {
                return encontrado;
            }
        }
       
        
        
        
        throw new PokerExcepciones("No existe el usuario");
        
    }
       
    private boolean JugadorTieneSaldo(Jugador j){
        
        if (j.getSaldo() >=  Fachada.getInstancia().getSiguienteJuego().getLuz()* Fachada.getInstancia().getMinimasApuestas())
        {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean jugadorYaEstaEnPartida(Participante j)
    {
        if (Fachada.getInstancia().getSiguienteJuego().getListaParticipantes().contains(j))
        {
            return true;
        } else {
            return false;
        }
    }
    
}
