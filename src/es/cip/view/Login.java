/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.LoginBL;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Cte;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author Elideth
 */
public class Login extends javax.swing.JFrame {

    private LoginBL bL = new LoginBL();
    public RegistroPersona registro;
    private boolean val = false;
    private JFRegistroPersona JFRegistroPersona;

    /**
     * Creates new form Inicio
     */
    public Login() throws Exception {

        this.setTitle(Cte.Titulo_Login);
        initComponents();
        JFRegistroPersona = new JFRegistroPersona();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        etContrasenia = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        jTextFieldContrasenia = new javax.swing.JPasswordField();
        jButtonCancelar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jLabelImagTorre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(391, 332));
        setName("Control Cursos Capacitación"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        etUsuario.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        etUsuario.setText("Usuario");

        jTextFieldUsuario.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyReleased(evt);
            }
        });

        etContrasenia.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        etContrasenia.setText("Contraseña");

        jButtonAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check_ok_accept_apply_1582.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        btnCrearUsuario.setBackground(new java.awt.Color(204, 204, 255));
        btnCrearUsuario.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(0, 0, 153));
        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregarUsuario.png"))); // NOI18N
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setSelected(true);
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseExited(evt);
            }
        });
        btnCrearUsuario.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnCrearUsuarioComponentShown(evt);
            }
        });
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        jTextFieldContrasenia.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jTextFieldContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldContraseniaKeyReleased(evt);
            }
        });

        jButtonCancelar1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButtonCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        jButtonCancelar1.setText("Cancelar");
        jButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 1, 18)); // NOI18N
        jLabel1.setText("CONTROL INTEGRADOR DE PROYECTOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("UNIVERSIDAD POLITECNICA DE TULANCINGO");

        jLabelImagTorre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagTorre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/upt.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonAceptar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCancelar1))
                                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etUsuario)
                                        .addComponent(etContrasenia))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldUsuario)
                                        .addComponent(jTextFieldContrasenia))))
                            .addComponent(jLabel1))))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelImagTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabelImagTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etContrasenia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        val = bL.validarUsuario(jTextFieldUsuario.getText(), jTextFieldContrasenia.getText());
        this.setVisible(!val);
        jTextFieldContrasenia.setText("");
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        //formWindowClosing();

        // TODO add your handling code here:

    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void jTextFieldUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldUsuarioKeyReleased

    private void jTextFieldContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldContraseniaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldContraseniaKeyReleased

    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
//      Login lo;
//        try {
////            lo = new  Login();
////             lo.disable();
//
//        } catch (Exception ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
    formWindowClosing();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    private void btnCrearUsuarioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnCrearUsuarioComponentShown
        // TODO add your handling code here:
        registro = new RegistroPersona();
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearUsuarioComponentShown

    private void btnCrearUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseClicked
        // TODO add your handling code here:
        this.toBack();
        JFRegistroPersona.setVisible(true);
        JFRegistroPersona.toFront();
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearUsuarioMouseClicked

    private void btnCrearUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseEntered
        // TODO add your handling code here:
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCrearUsuarioMouseEntered

    private void btnCrearUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseExited
        // TODO add your handling code here:
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnCrearUsuarioMouseExited
    public Integer getIdUsuario() {
        return this.bL.getIdUsuario();
    }

    public Integer getIdTipoUsuario() {
        return this.bL.getIdTipoUsuario();
    }

    public boolean isVal() {
        return val;
    }

    public Usuario getUsuario() {
        return this.bL.getUsuario();
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Login().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel etContrasenia;
    private javax.swing.JLabel etUsuario;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelImagTorre;
    private javax.swing.JPasswordField jTextFieldContrasenia;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private void cerrar() {

        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "En realidad desea realizar cerrar la aplicacion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }

    private void formWindowClosing() {
        cerrar();
    }

}
