/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import Excepciones.PokerExcepciones;
import controlador.ControladorAdministracion;
import controlador.VistaAdministrador;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Juego;
import modelo.Participante;

/**
 *
 * @author alex
 */
public class MenuAdministrador extends javax.swing.JFrame implements VistaAdministrador{

    /**
     * Creates new form MenuAdministrador
     */
    private Administrador a;
    
    private ControladorAdministracion controlador;

    public ControladorAdministracion getControlador() {
        return controlador;
    }

    public void setControlador(ControladorAdministracion controlador) {
        this.controlador = controlador;
    }
    

    
    public Administrador getA() {
        return a;
    }

    public void setA(Administrador a) {
        this.a = a;
    }
    
    
    
    public MenuAdministrador(Administrador a) {
        initComponents();
        this.a = a;
        /* El juego no se almacena en la vista, solo en el controlador*/
        controlador = new ControladorAdministracion(this, a);
        actualizarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtValorActualLuz = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorNuevoLuz = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCantidadJugadores = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        valorJugadoresPartida = new javax.swing.JTextField();
        btnActualizarJugadores = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPartidasActivas = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtVerDetalles = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnVerDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor luz"));
        jPanel1.setLayout(null);

        txtValorActualLuz.setText("Valor");
        jPanel1.add(txtValorActualLuz);
        txtValorActualLuz.setBounds(30, 30, 280, 17);

        jLabel3.setText("Nuevo valor");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 70, 90, 17);

        valorNuevoLuz.setText("1");
        jPanel1.add(valorNuevoLuz);
        valorNuevoLuz.setBounds(140, 60, 80, 30);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(240, 100, 90, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 40, 350, 140);

        jLabel1.setText("Menu del admin");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 10, 270, 17);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(1030, 590, 72, 29);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugadores"));
        jPanel2.setLayout(null);

        txtCantidadJugadores.setText("Cantidad por partida ");
        jPanel2.add(txtCantidadJugadores);
        txtCantidadJugadores.setBounds(20, 30, 280, 20);

        jLabel4.setText("Nuevo valor");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 70, 140, 17);

        valorJugadoresPartida.setText("1");
        jPanel2.add(valorJugadoresPartida);
        valorJugadoresPartida.setBounds(140, 70, 86, 27);

        btnActualizarJugadores.setText("Actualizar");
        btnActualizarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarJugadoresActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizarJugadores);
        btnActualizarJugadores.setBounds(270, 90, 100, 29);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(510, 40, 380, 140);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(30, 200, 730, 0);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidas"));
        jPanel3.setLayout(null);

        listaPartidasActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPartidasActivasMouseClicked(evt);
            }
        });
        listaPartidasActivas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPartidasActivasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPartidasActivas);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 640, 360);

        jLabel2.setText("Activas");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 20, 130, 17);

        txtVerDetalles.setColumns(20);
        txtVerDetalles.setRows(5);
        jScrollPane2.setViewportView(txtVerDetalles);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(680, 40, 300, 330);

        jLabel5.setText("Detalles");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(680, 20, 210, 20);

        btnVerDetalles.setText("Ver ");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerDetalles);
        btnVerDetalles.setBounds(680, 380, 100, 29);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 190, 1000, 420);

        setBounds(0, 0, 1117, 658);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actualizarLuz();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarJugadoresActionPerformed
        actualizarMaximoJugadores();
    }//GEN-LAST:event_btnActualizarJugadoresActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        verDatosPartidaSeleccionada();
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void listaPartidasActivasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPartidasActivasValueChanged
      
    }//GEN-LAST:event_listaPartidasActivasValueChanged

    private void listaPartidasActivasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPartidasActivasMouseClicked
       verDatosPartidaSeleccionada();
    }//GEN-LAST:event_listaPartidasActivasMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarJugadores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listaPartidasActivas;
    private javax.swing.JLabel txtCantidadJugadores;
    private javax.swing.JLabel txtValorActualLuz;
    private javax.swing.JTextArea txtVerDetalles;
    private javax.swing.JTextField valorJugadoresPartida;
    private javax.swing.JTextField valorNuevoLuz;
    // End of variables declaration//GEN-END:variables

    private void actualizarDatos() {
        
        /* Consultar al docente si podemos acceder directamente a la fachada o lo hacemos por el controlador*/
       txtValorActualLuz.setText("Valor actual $:"+Fachada.getInstancia().getLuz());
       txtCantidadJugadores.setText("Cantidad maxima de jugadores :"+Fachada.getInstancia().getMaxJugadores());
       controlador.actualizarPartidas();
       
       
       
    }

    private void actualizarLuz() {
        
        try {
            controlador.actualizarLuz(Integer.valueOf(valorNuevoLuz.getText()));
            actualizarDatos();
        } catch (PokerExcepciones ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }  catch (NumberFormatException numberex)
        {
            JOptionPane.showMessageDialog(this, "El valor de la luz debe ser un numero");
        }
    }

    private void actualizarMaximoJugadores() {
          try {
            controlador.actualizarMaxJugadores(Integer.valueOf(valorJugadoresPartida.getText()));
            actualizarDatos();
        } catch (PokerExcepciones ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }  catch (NumberFormatException numberex)
        {
            JOptionPane.showMessageDialog(this, "El valor de jugadores debe ser numerico");
        }
    }

    
    @Override
    public void actualizarPartidasActivas(List<Juego> lista) {
        
        listaPartidasActivas.setListData(lista.toArray());
        
        
    }
    
    public void verDatosPartidaSeleccionada()
    {
        Juego j = (Juego)listaPartidasActivas.getSelectedValue();
        String info = "Informacion del juego \n _____________________";
        
        for (Participante p: j.getListaParticipantes())
        {
            info = info + "\n"+"Nombre:"+p.getJugador().getNombreCompleto()+"\n"+"Total apostado $:"+p.getTotalApostado()+"\n"
                    +"Total Ganado $:"+(p.getTotalGanado()-p.getTotalApostado())+"\n"+"Saldo inicial $:"+p.getSaldoInicial()+"\n _____________________";
        }
        
        
        
        txtVerDetalles.setText(info);
    }

    private void salir() {
      JOptionPane.showMessageDialog(this, "Chau");
        controlador.desRegistrar();
        controlador=null;
        this.dispose();
    }
    
    
}
