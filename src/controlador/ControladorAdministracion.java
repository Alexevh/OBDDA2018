/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.PokerExcepciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Juego;
import modelo.SistemaJuegos;

/**
 *
 * @author alex
 */
public class ControladorAdministracion implements Observer {
    
    private VistaAdministrador vista;
    private Administrador usuario;
    /*tener copia de listajuegos*/
    
    private List<Juego> listaLocal;

    public List<Juego> getListaLocal() {
        return listaLocal;
    }

    public void setListaLocal(List<Juego> listaLocal) {
        this.listaLocal = listaLocal;
    }
    

    
    
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
        Fachada.getInstancia().registrarObservador(this);
        listaLocal = obtenerJuegosActivos();
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
        return new ArrayList(Fachada.getInstancia().obtenerJuegosActivos());
    }
    
    public void actualizarPartidas(){
        vista.actualizarPartidasActivas(Fachada.getInstancia().obtenerJuegosActivos());
    }

    @Override
    public void update(Observable o, Object evento) {
        
          switch ((SistemaJuegos.Eventos) evento) {
            case seAgregoUnNuevoJuego:
                
                vista.actualizarPartidasActivas(Fachada.getInstancia().obtenerJuegosActivos());
                listaLocal = obtenerJuegosActivos();
                break;
    }
          
    }
    
    
    public void desRegistrar()
    {
        Fachada.getInstancia().eliminarObservador(this);
    }
    
    public int getValorluz()
    {
        return Fachada.getInstancia().getLuz();
    }
    
    public int getMaximoJugadores()
    {
       return Fachada.getInstancia().getMaxJugadores();
    }

    public Juego obtenerJuegoPorIndice(int indice) {
        return this.listaLocal.get(indice);
    }
}
