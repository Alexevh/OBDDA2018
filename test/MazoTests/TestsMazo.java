/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazoTests;

import java.util.List;
import junit.framework.Assert;
import modelo.Carta;
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
    
    
}
