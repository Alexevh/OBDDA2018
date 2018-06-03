/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazoTests;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import modelo.Carta;
import modelo.FiguraDoblePar;
import modelo.FiguraMano;
import modelo.FiguraPar;
import modelo.Juego;
import modelo.Mazo;
import org.junit.Test;

/**
 *
 * @author alex
 * Necesitamos las librerias HAMBCREST y JUNIT
 */
public class TestsMazo {
    
    @Test
    public void obtenerMazo()
    {
        Mazo m = new Mazo();
        int cartasEsperadas = 52;
        int cartasRecibidas = m.getCartas().size();
        Assert.assertEquals(cartasRecibidas, cartasEsperadas);
        
    }
    
     @Test
    public void barajarMazo()
    {
        Mazo m = new Mazo();
        m.barajar();
        int cartasEsperadas = 52;
        int cartasRecibidas = m.getCartas().size();
        Assert.assertEquals(cartasRecibidas, cartasEsperadas);
    }
    
     @Test
    public void compararCartas()
    {
      
    }
    
     @Test
    public void reparit5()
    {
       Mazo m = new Mazo();
       m.barajar();
       
       List<Carta> lista1 = m.repartir(5);
       List<Carta> lista2 = m.repartir(5);
       
       Assert.assertNotSame(lista1, lista2);
       
    }
    
      @Test
    public void obtenerImagenCartas()
    {
       Mazo m = new Mazo();
       m.barajar();
       
       List<Carta> lista1 = m.repartir(5);
       
       System.out.println(lista1.get(0).obtenerImagen());
       System.out.println(lista1.get(1).obtenerImagen());
       System.out.println(lista1.get(2).obtenerImagen());
       
       
    }
    
     @Test
    public void saberSihAYpAR()
    {
       Mazo m = new Mazo();
       m.barajar();
       
       Carta c1 = new Carta(Carta.Palo.CORAZON, 4);
       Carta c2 = new Carta(Carta.Palo.DIAMANTE, 1);
       Carta c3 = new Carta(Carta.Palo.TREBOL, 3);
       Carta c4 = new Carta(Carta.Palo.DIAMANTE, 2);
       Carta c5= new Carta(Carta.Palo.PIQUE, 7);
       
       
       
       List<Carta> lista1 = new ArrayList();
       lista1.add(c1);
       lista1.add(c2);
       lista1.add(c3);
       lista1.add(c4);
       lista1.add(c5);
 
       boolean par = Juego.tienePar(lista1);
       
       System.out.println(lista1.get(0).obtenerImagen());
       
       
    }
    
    
      @Test
    public void CompararPares()
    {
       Mazo m = new Mazo();
       m.barajar();
       
       Carta c1 = new Carta(Carta.Palo.CORAZON, 4);
       Carta c2 = new Carta(Carta.Palo.DIAMANTE, 4);
       Carta c3 = new Carta(Carta.Palo.TREBOL, 1);
       Carta c4 = new Carta(Carta.Palo.DIAMANTE, 2);
       Carta c5= new Carta(Carta.Palo.PIQUE, 3);
       
       Carta c6 = new Carta(Carta.Palo.PIQUE, 4);
       Carta c7= new Carta(Carta.Palo.TREBOL, 4);
       Carta c8 = new Carta(Carta.Palo.TREBOL, 8);
       Carta c9 = new Carta(Carta.Palo.DIAMANTE, 7);
       Carta c10= new Carta(Carta.Palo.PIQUE, 3);
       
       
       
       List<Carta> lista1 = new ArrayList();
       lista1.add(c1);
       lista1.add(c2);
       lista1.add(c3);
       lista1.add(c4);
       lista1.add(c5);
       
       List<Carta> lista2 = new ArrayList();
        lista2.add(c6);
       lista2.add(c7);
       lista2.add(c8);
       lista2.add(c9);
       lista2.add(c10);
       
       FiguraPar m1 = new FiguraPar(lista1);
       FiguraPar m2 = new FiguraPar(lista2);
       
       Assert.assertTrue(m1.compareTo(m2)==1);
      
       
       
    }
    
      @Test
    public void CompararDoblePares()
    {
       Mazo m = new Mazo();
       m.barajar();
       
       Carta c1 = new Carta(Carta.Palo.PIQUE, 4);
       Carta c2 = new Carta(Carta.Palo.DIAMANTE, 4);
       Carta c3 = new Carta(Carta.Palo.TREBOL, 10);
       Carta c4 = new Carta(Carta.Palo.CORAZON, 10);
       Carta c5= new Carta(Carta.Palo.PIQUE, 3);
       
       Carta c6 = new Carta(Carta.Palo.DIAMANTE, 4);
       Carta c7= new Carta(Carta.Palo.TREBOL, 4);
       Carta c8 = new Carta(Carta.Palo.PIQUE, 8);
       Carta c9 = new Carta(Carta.Palo.DIAMANTE, 8);
       Carta c10= new Carta(Carta.Palo.PIQUE, 4);
       
       
       
       List<Carta> lista1 = new ArrayList();
       lista1.add(c1);
       lista1.add(c2);
       lista1.add(c3);
       lista1.add(c4);
       lista1.add(c5);
       
       List<Carta> lista2 = new ArrayList();
        lista2.add(c6);
       lista2.add(c7);
       lista2.add(c8);
       lista2.add(c9);
       lista2.add(c10);
       
       FiguraDoblePar m1 = new FiguraDoblePar(lista1);
       FiguraDoblePar m2 = new FiguraDoblePar(lista2);
       
       Assert.assertTrue(m1.compareTo(m2)==1);
      
       
       
    }
    
    
    
}
