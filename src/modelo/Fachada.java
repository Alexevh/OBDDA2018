/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;

/**
 *
 * @author alex
 */
public class Fachada extends Observable{
    
    private SistemaJuegos sisJuegos = new SistemaJuegos();
    private SistemaUsuarios sisUsuarios = new SistemaUsuarios();
    
    /* Enum con la lista de eventos que reportamos */
     public enum Eventos{
        inicioJuego;
    }
     
    /*El metodo que avisa a los observadores*/ 
    protected void avisar(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    
    
    
    
    /* Singleton */
     private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }
    
    
    public void agregarAdmin(Administrador a)
    {
        sisUsuarios.agregarAdministrador(a);
    }
    
    
     public void agregarJugador(Jugador j)
    {
        sisUsuarios.agregarJugador(j);
    }
    
    public Administrador loginAdmin(String nombre, String password)
    {
       return sisUsuarios.loginAdmin(nombre, password);
    }
}
