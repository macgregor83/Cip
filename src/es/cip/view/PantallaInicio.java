/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author hp
 */
public class PantallaInicio extends javax.swing.JFrame {

    private RegistroPersona RegistroPersona;

    /**
     * Creates new form PantallaInicio
     */
    public PantallaInicio() {
        initComponents();
        
        this.setLayout(new FlowLayout());
        //this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
     
        
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabelImagTorre = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(230, 30, 0, 0));
        setName("framePantallaInicio"); // NOI18N
        getContentPane().setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1320, 90);

        jSeparator1.setPreferredSize(new java.awt.Dimension(1324, 10));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(30, 90, 1270, 10);

        jLabelImagTorre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagTorre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/upt.png"))); // NOI18N
        getContentPane().add(jLabelImagTorre);
        jLabelImagTorre.setBounds(440, 250, 150, 190);

        jMenu1.setText("Menú");

        jMenu3.setText("Alta Usuario");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Personal");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        
        jLabelImagTorre.setVisible(false);
        this.clearjPanel();/*
        pantallaAltaMAterial = new PantallaAltaMAterial();
        this.add(pantallaAltaMAterial, BorderLayout.CENTER);
        this.pack();*/
              
         
       RegistroPersona=new RegistroPersona(); 
       
        this.add(RegistroPersona, BorderLayout.CENTER);
        this.pack();
        this.setExtendedState(MAXIMIZED_BOTH);
        
             
    }//GEN-LAST:event_jMenu3MouseClicked

    private void clearjPanel(){
      
         try{
             this.remove(RegistroPersona);
         }
         catch(Exception e){
             
         }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagTorre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
                
}
