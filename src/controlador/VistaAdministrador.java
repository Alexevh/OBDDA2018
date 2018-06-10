/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Juego;

/**
 *
 * @author alex
 */
public interface  VistaAdministrador {
    
    public void actualizarPartidasActivas(List<Juego> lista);
   
     public void actualizarPartidasFinalizadas(List<Juego> lista);
}
