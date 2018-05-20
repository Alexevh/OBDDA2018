/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Juego;

/**
 *
 * @author alex
 */
public class ControladorAdministracion implements Observer {
    
    private VistaAdministrador vista;
    private Administrador usuario;
    

    public VistaAdministrador getVista() {
        return vista;
    }

    public void setVista(VistaAdministrador vista) {
        this.vista = vista;
    }

    public Administrador getUsuario() {
        return usuario;
    }

    public void setUsuario(Administrador usuario) {
        this.usuario = usuario;
    }

    public ControladorAdministracion(VistaAdministrador vista, Administrador usuario) {
        this.vista = vista;
        this.usuario = usuario;
    }
    
    public void actualizarLuz(int valor) throws PokerExcepciones
    {
        Fachada.getInstancia().actualizarLuz(valor);
    }
    
    public void actualizarMaxJugadores(int numero) throws PokerExcepciones
    {
        Fachada.getInstancia().actualizarMaximoJugadores(numero);
    }
    
    public List<Juego> obtenerJuegosActivos()
    {
        return Fachada.getInstancia().obtenerJuegosActivos();
    }
    
    public void actualizarPartidas(){
        vista.actualizarPartidasActivas(Fachada.getInstancia().obtenerJuegosActivos());
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
