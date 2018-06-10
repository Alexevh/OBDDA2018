/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDTests;

import mapeadores.MapeadorJugador;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import mapeadores.MapeadorJuego;
import modelo.Juego;
import modelo.Jugador;
import org.junit.Test;
import persistencia.BaseDatos;
import persistencia.Mapeador;
import persistencia.Persistencia;

/**
 *
 * @author alex
 */
public class TestsBDConexion {
    
    
    @Test
    public void probarConexion(){
        
        BaseDatos.getInstancia().conectar("pokerGame", "root", "root");
    }
    
     @Test
    public void probarInsertarJugador(){
       
       Jugador j = new Jugador("Amanda A", "amanda", "password", 1000);
       
        
       Mapeador m = new MapeadorJugador(j);
       Persistencia.getInstancia().guardar(m);
        
    }
    
      @Test
    public void probarModificarJugador(){
       
       Jugador j = new Jugador("Peter P", "peter", "password", 400);
       j.setOid(4);
       
        
       Mapeador m = new MapeadorJugador(j);
       Persistencia.getInstancia().guardar(m);
        
    }
    
       @Test
    public void probarBuscarJugadores(){
       
       Jugador j = new Jugador("Peter P", "peter", "password", 400);

       Mapeador m = new MapeadorJugador(j);
       
       ArrayList<Jugador> lista = Persistencia.getInstancia().todos(m);
       System.out.println("La lista tiene "+lista.size()+" elementos");
        
    }
    
       @Test
    public void probarBuscarPartidas(){
       
       Juego j = new Juego();

       Mapeador m = new MapeadorJuego(j);
       
       ArrayList<Juego> lista = Persistencia.getInstancia().todosJuegos(m);
       System.out.println("La lista tiene "+lista.size()+" elementos");
        
    }
    
    
}
