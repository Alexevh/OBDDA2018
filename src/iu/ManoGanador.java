/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.util.List;
import javax.swing.ImageIcon;
import modelo.Carta;

/**
 *
 * @author alex
 */
public class ManoGanador extends javax.swing.JFrame {

    /**
     * Creates new form ManoGanador
     */
    public ManoGanador(String ganador, String figura, List<Carta> cartas) {
        initComponents();
       pintarResultado(ganador, figura, cartas);
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
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txtInformacion.setText("Gano : fulano con figura");
        getContentPane().add(txtInformacion);
        txtInformacion.setBounds(40, 30, 390, 20);

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/Invertida.gif"))); // NOI18N
        c1.setText("Card 1");
        getContentPane().add(c1);
        c1.setBounds(40, 120, 110, 150);

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/Invertida.gif"))); // NOI18N
        c2.setText("Card2");
        getContentPane().add(c2);
        c2.setBounds(150, 120, 110, 150);

        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/Invertida.gif"))); // NOI18N
        c3.setText("Card3");
        getContentPane().add(c3);
        c3.setBounds(260, 120, 100, 150);

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/Invertida.gif"))); // NOI18N
        c4.setText("Card4");
        getContentPane().add(c4);
        c4.setBounds(360, 120, 110, 150);

        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cartas/Invertida.gif"))); // NOI18N
        c5.setText("Card5");
        getContentPane().add(c5);
        c5.setBounds(470, 120, 110, 150);

        setBounds(0, 0, 705, 330);
    }// </editor-fold>//GEN-END:initComponents

  
    
      private void pintarResultado(String ganador, String figura, List<Carta> cartas) {
        txtInformacion.setText("El ganador fue "+ganador+" con "+figura);
        
        ImageIcon carta1 = new ImageIcon(new ImageIcon("src/imagenes/cartas/" + cartas.get(0).getImagen()).getImage());
        // ImageIcon carta1 = new ImageIcon(new ImageIcon("src/imagenes/cartas/10c.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        c1.setIcon(carta1);
        c2.setIcon(new ImageIcon(new ImageIcon("src/imagenes/cartas/" + cartas.get(1).getImagen()).getImage()));
        c3.setIcon(new ImageIcon(new ImageIcon("src/imagenes/cartas/" + cartas.get(2).getImagen()).getImage()));
        c4.setIcon(new ImageIcon(new ImageIcon("src/imagenes/cartas/" + cartas.get(3).getImagen()).getImage()));
        c5.setIcon(new ImageIcon(new ImageIcon("src/imagenes/cartas/" + cartas.get(4).getImagen()).getImage()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel txtInformacion;
    // End of variables declaration//GEN-END:variables
}



