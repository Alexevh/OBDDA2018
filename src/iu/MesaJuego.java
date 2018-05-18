/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import controlador.ControladorJuego;
import controlador.VistaJuego;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Apuesta;
import modelo.Juego;
import modelo.Participante;

public class MesaJuego extends javax.swing.JFrame implements VistaJuego {

    /* JUgador o participante aca???*/
    Participante j;

    ControladorJuego controlador;

    public ControladorJuego getControlador() {
        return controlador;
    }

    public void setControlador(ControladorJuego controlador) {
        this.controlador = controlador;
    }

    public Participante getJ() {
        return j;
    }

    public void setJ(Participante j) {
        this.j = j;
    }

  

    /**
     * Creates new form MesaJuego
     */
    public MesaJuego(Participante j, Juego juego)  {
        initComponents();
        this.j = j;
         pintarMesa();
        /* El juego no se almacena en la vista, solo en el controlador*/
        controlador = new ControladorJuego(juego, this, j);
        
      
        this.setTitle(j.getJugador().getNombreCompleto());
       
        
        
        
        
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
        imgSaldo = new javax.swing.JLabel();
        imgPozo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaParticipantes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        txtMontoApuesta = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        txtInformacion.setForeground(new java.awt.Color(253, 251, 251));
        txtInformacion.setText("Cantidad de participantes");
        getContentPane().add(txtInformacion);
        txtInformacion.setBounds(260, 20, 260, 17);

        imgSaldo.setForeground(new java.awt.Color(254, 247, 247));
        imgSaldo.setText("Mi saldo");
        getContentPane().add(imgSaldo);
        imgSaldo.setBounds(30, 400, 160, 40);

        imgPozo.setForeground(new java.awt.Color(254, 254, 254));
        imgPozo.setText("Pozo actual  $: ");
        getContentPane().add(imgPozo);
        imgPozo.setBounds(340, 170, 260, 100);

        jScrollPane1.setViewportView(listaParticipantes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 90, 140);

        jLabel1.setForeground(new java.awt.Color(255, 250, 250));
        jLabel1.setText("Participantes:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 70, 100, 17);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(692, 400, 100, 29);

        btnApostar.setText("Apostar");
        btnApostar.setEnabled(false);
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApostar);
        btnApostar.setBounds(260, 400, 72, 29);

        txtMontoApuesta.setText("0");
        txtMontoApuesta.setEnabled(false);
        getContentPane().add(txtMontoApuesta);
        txtMontoApuesta.setBounds(340, 400, 70, 27);

        btnPagar.setText("Pagar");
        btnPagar.setEnabled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar);
        btnPagar.setBounds(420, 400, 72, 29);

        btnPasar.setText("Pasar");
        btnPasar.setEnabled(false);
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPasar);
        btnPasar.setBounds(500, 400, 50, 29);

        setBounds(0, 0, 818, 472);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
       apostar();
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        controlador.pagar();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
       pasar();
        
    }//GEN-LAST:event_btnPasarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel imgPozo;
    private javax.swing.JLabel imgSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaParticipantes;
    private javax.swing.JLabel txtInformacion;
    private javax.swing.JTextField txtMontoApuesta;
    // End of variables declaration//GEN-END:variables

    /* OJO la vista jamas debe conocer nada del modelo, solo trabaja mediante el controlador*/
    @Override
    public void mostrarParticipantes(int cantidadFaltante) {

        this.txtInformacion.setText("Hay un nuevo participante, faltan : " + cantidadFaltante);      
        
        
    }
    
    

    private void pintarMesa() {

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("src/imagenes/pkt2.jpg"));

        add(background);
        background.setLayout(new FlowLayout());
        
     
    }

    private void salir() {

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Seguro quieres salir", "Salir del juego", dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
            
            
            controlador.eliminarParticipante(j);
            dispose();
        }

    }

    @Override
    public void inicioJuego(List<Participante> lista) {
        
        this.txtInformacion.setText("Inicio el juego!!!");
        listaParticipantes.setListData(lista.toArray());
        
    }

    @Override
    public void mostrarError(String mensaje) {
               
        JOptionPane.showMessageDialog(this, mensaje);      
        
    }
    
    @Override
    public void actualizarMesa( List<Participante> lista)
    {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/imagenes/saldo.png").getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT));
        imgSaldo.setIcon(imageIcon);
        imgSaldo.setText("Saldo : " + j.getJugador().getSaldo());

        listaParticipantes.setListData(lista.toArray());
    }

    @Override
    public void inicioNuevaMano() {
        
        /* Aca lo que hacemos es, vemos que cartas tiene en la mano el participante y las mostramos
        en imagenes*/
        
        btnApostar.setEnabled(true);
        btnPasar.setEnabled(true);
        txtMontoApuesta.setEnabled(true);
        
    }

    @Override
    public void inicioNuevaApuesta() {
        
        btnApostar.setEnabled(false);
        txtMontoApuesta.setEnabled(false);
        deshabilitarHabilitarOpciones(true);
        
        
        
    }

    private void apostar() {
        controlador.registrarApuesta(j, Integer.parseInt(txtMontoApuesta.getText()));
        deshabilitarHabilitarOpciones(false);
        btnApostar.setEnabled(false);
        
    }
    
    public void deshabilitarHabilitarOpciones(boolean opcion)
    {
        btnPagar.setEnabled(opcion);
        btnPasar.setEnabled(opcion);
    }
    
    @Override
    public void actualizarPozo(int valor)
    {
        ImageIcon pozo = new ImageIcon(new ImageIcon("src/imagenes/pozo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imgPozo.setIcon(pozo);
        imgPozo.setText("Pozo : $ " + valor);
    }

    @Override
    public void seguirJugando() {
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Vas a jugar otra mano", "Otra mano?"+j.getJugador().getNombreCompleto(), dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
            
         
            controlador.juegoSiguienteMano(true);
            btnApostar.setEnabled(true);
            btnPagar.setEnabled(false);
            btnPasar.setEnabled(true);
            
        } else {
            controlador.juegoSiguienteMano(false);
            controlador.eliminarParticipante(j);
            controlador.desregistrarControlador();
            controlador=null;
            this.dispose();
        }
    }

    @Override
    public void salirJuego() {
        JOptionPane.showMessageDialog(this, "El jueo termino, gracias por dejar tu dinero con nosotros");
        this.dispose();
                
    }

    private void pasar() {
        deshabilitarHabilitarOpciones(false);
        btnApostar.setEnabled(false);
        controlador.pasarApuesta();
       
        
    }

    @Override
    public void mostrarGanador(String nombre, String carta) {
         JOptionPane.showMessageDialog(this, "El ganador de la ultima mano fue "+nombre+" y gano con "+carta);
    }

   

   
}
