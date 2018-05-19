/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Apuesta;
import modelo.Fachada;
import modelo.Juego;
import modelo.Jugador;
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
            vista.actualizarMano(p.getCartasMano());

        } else {
            vista.mostrarParticipantes(getFaltantes());
            vista.actualizarMesa(this.juego.getActivos());
            vista.actualizarPozo(juego.getPozo());
        }

        /* Esto hay que hacerlo en el login asi el sistema sabe si hay un juego nuevo*/
        //this.juego.agregarJugador(j);
    }

    public void desregistrarControlador() {
        juego.deleteObserver(this);

    }

    /* Agregue este metodo por que como saque la segunda lista de jugadores por indicacion del docente, si dejaba en
    el constructor el agregar participante entonces en el inicio de la vista el constructor no habia acabado, entonces estaba en null
    y cuando se disparaba el evento daba una excepcion
    
    Es por eso que ahora la clase mesajuego primero crea el controlador y recien luego agrega al participante, hay que pensar y de ultima
    consultar al docente si eso esta bien, si esta bien que la vista llame a ese metodo del controlador o si deberiamos solucionar toda la
    linea en el mismo metodo del controlador.
     */
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
        return this.juego.getCantidadJugadores() - this.juego.getListaParticipantes().size();
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
                vista.mostrarParticipantes(getFaltantes());
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());
                break;

            case inicioJuego:
                vista.inicioJuego(this.juego.getListaParticipantes());
                vista.actualizarPozo(this.juego.getPozo());
                vista.actualizarMesa(juego.getActivos());

                break;
            case seEliminaParticipante:
                vista.mostrarParticipantes(getFaltantes());
                vista.actualizarMesa(juego.getActivos());
                break;
            case nuevaMano:
                vista.inicioNuevaMano();
                vista.actualizarMesa(juego.getActivos());
                vista.actualizarMano(p.getCartasMano());
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
                vista.mostrarGanador(juego.getUltimoGanador().getJugador().getNombreCompleto(), juego.getUltimoGanador().getCartasMano().get(0).toString());
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
        //vista.pagarApuesta(this.p, juego.getManoActual().getApuesta());
        juego.pagarApuesta(p, juego.getManoActual().getApuesta());
    }

    public void registrarDesicionParticipantes(Participante p, boolean desicion) {
        juego.registrarDesicionParticipantes(p, desicion);
    }

    public void juegoSiguienteMano(boolean desicion) {

        registrarDesicionParticipantes(p, desicion);

    }

}
