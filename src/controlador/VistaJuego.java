/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Carta;
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

    public void inicioNuevaApuesta(String jugadorNombre, int monto);


    public void actualizarMesa(List<Participante> activos);

    public void actualizarPozo(int pozo);
    
    public void actualizarPagan(List<Participante> pagan);

    public void seguirJugando();

    public void salirJuego();

    public void mostrarGanador(String nombre, String carta);

    public void fuiExpulsado();

    public void actualizarMano(List<Carta> cartasMano);
    
 

}
