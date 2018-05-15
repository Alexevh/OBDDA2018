/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Participante;

/**
 *
 * @author alex
 */
public interface VistaJuego {
    
    public void mostrarParticipantes(int cantidadFaltante);
    
    public void inicioJuego(List<Participante> lista);

    public void mostrarError(String mensaje);

    public void inicioNuevaMano();

    public void inicioNuevaApuesta();

   // public void actualizarMesa(int saldo, int pozo, List<Participante> lista);
}
