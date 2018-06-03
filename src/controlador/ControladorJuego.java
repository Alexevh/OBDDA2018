/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import java.util.Observable;
import java.util.Observer;
import modelo.Apuesta;
import modelo.Fachada;
import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author alex
 */
public class ControladorJuego implements Observer {

    private Juego juego;
    private VistaJuego vista;
    private Participante p;

    public Participante getP() {
        return p;
    }

    public void setP(Participante p) {
        this.p = p;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public VistaJuego getVista() {
        return vista;
    }

    public void setVista(VistaJuego vista) {
        this.vista = vista;
    }

    /* Cambiar jugador por particpante, */
    public ControladorJuego(Juego juego, VistaJuego vista, Participante j) {
        this.juego = juego;
        this.p = j;
        this.vista = vista;
        juego.addObserver(this);

        if (juego.isIniciado()) {
            vista.inicioJuego(this.juego.getListaParticipantes());
            vista.actualizarMesa(this.juego.getActivos());
            vista.actualizarPozo(juego.getPozo());
            vista.inicioNuevaMano();
            vista.actualizarMano(p.getCartasMano(), this.juego.obtenerFigura(p.getCartasMano()).toString());

        } else {
            vista.mostrarParticipantes(getFaltantes());
            vista.actualizarMesa(this.juego.getActivos());
            vista.actualizarPozo(juego.getPozo());
        }

      
    }

    public void desregistrarControlador() {
        juego.deleteObserver(this);

    }

  
    public void agregarParticipante(Participante j) {
        try {
            Fachada.getInstancia().agregarJugadorSiguienteJuego(j);
        } catch (PokerExcepciones ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void eliminarParticipante(Participante p) {
        juego.eliminarParticipante(p);
    }

    public void registrarApuesta(Participante p, int valor) throws PokerExcepciones {
        juego.registrarApuesta(p, valor);
    }

    public int getFaltantes() {
        return this.juego.obtenerFaltantes();
    }

    public void pagarApuesta(Participante p, Apuesta a) {
        juego.pagarApuesta(p, a);
    }

    public void pasarApuesta() {
        juego.pasarApuesta(this.p, this.juego.getManoActual().getApuesta());
    }

    public boolean participanteTieneSaldo(Participante p) {
        return juego.participanteTieneSaldo(p);
    }

    /* Metodo que escucha al juego y hace los cambios*/
    @Override
    public void update(Observable o, Object evento) {

        switch ((Juego.Eventos) evento) {
            case ingresaNuevoParticipante:
                
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());
                vista.mostrarParticipantes(getFaltantes());
                break;

            case inicioJuego:
                
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());
                vista.inicioJuego(this.juego.getListaParticipantes());
                break;
            case seEliminaParticipante:
                vista.mostrarParticipantes(getFaltantes());
                vista.actualizarMesa(juego.getActivos());
                break;
            case nuevaMano:
                vista.inicioNuevaMano();
                vista.actualizarMesa(juego.getActivos());
                vista.actualizarMano(p.getCartasMano(), this.juego.obtenerFigura(p.getCartasMano()).toString());
                break;
            case nuevaApuesta:
                vista.inicioNuevaApuesta(juego.getManoActual().getApuesta().getDueno().getJugador().getNombreCompleto(), juego.getManoActual().getApuesta().getValor());
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());
                break;
            case nuevaPagaoPasa:
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());
                vista.actualizarPagan(juego.getManoActual().getApuesta().getListaPagan());
                break;
            case hayGanador:
                vista.mostrarGanador(juego.getUltimoGanador().getJugador().getNombreCompleto(), this.juego.obtenerFigura(juego.getUltimoGanador().getCartasMano()).toString(), juego.getUltimoGanador().getCartasMano());
                vista.seguirJugando();
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());

                break;
            case manoNuevaSiNo:
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());

                break;
            case huboEmpate:

                vista.seguirJugando();
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());

                break;
            case expulsarParticipante:
                if (!p.isActivo()) {
                    vista.fuiExpulsado();
                }
                vista.mostrarParticipantes(getFaltantes());
                vista.actualizarMesa(juego.getActivos());

                break;

            case finJuego:

                vista.salirJuego();
                break;
        }

    }

    public void pagar() {
        
        juego.pagarApuesta(p, juego.getManoActual().getApuesta());
    }

    public void registrarDesicionParticipantes(Participante p, boolean desicion) {
        juego.registrarDesicionParticipantes(p, desicion);
    }

    public void juegoSiguienteMano(boolean desicion) {

        registrarDesicionParticipantes(p, desicion);

    }

}
