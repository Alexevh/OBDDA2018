/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import controlador.ControladorJuego;
import controlador.VistaJuego;
import modelo.Juego;
import modelo.Jugador;


public class MesaJuego extends javax.swing.JFrame  implements VistaJuego{
    
Jugador j;
Juego juego;
ControladorJuego controlador;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public ControladorJuego getControlador() {
        return controlador;
    }

    public void setControlador(ControladorJuego controlador) {
        this.controlador = controlador;
    }



    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }
    

    /**
     * Creates new form MesaJuego
     */
    public MesaJuego(Jugador j, Juego juego) {
        initComponents();
        this.j=j;
        this.juego = juego;
        controlador = new ControladorJuego(juego, this, j);
        
        //txtInformacion.setText("Paricipantes :"+this.juego.getCantidadJugadores());
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtInformacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtInformacion.setText("Cantidad de participantes");
        getContentPane().add(txtInformacion);
        txtInformacion.setBounds(30, 20, 260, 17);

        setBounds(0, 0, 628, 339);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtInformacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarParticipantes() {
        this.txtInformacion.setText("Hay un nuevo participante, faltan : "+(this.juego.getCantidadJugadores()-this.juego.getListaJugadores().size()));
    }
}
