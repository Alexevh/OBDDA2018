/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazoTests;

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
    
}
