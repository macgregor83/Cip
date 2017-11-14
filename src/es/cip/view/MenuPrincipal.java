/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.util.cte.Cte;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Vero
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private RegistroPersona registroPersona;
    private RegistroProyecto registroProyecto;
    private AvancesProyecto avancesProyecto;
    private EstadoProyecto estadoProyecto;
    private SeccionPublica SeccionPublica;
    private Login login;

    /**
     * Creates new form JMenuPrincipal
     */
    public MenuPrincipal() {
        jTabbedPane = new JTabbedPane();
        initComponents();
        getContentPane().add(jTabbedPane, BorderLayout.CENTER);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        //this.setAlwaysOnTop(true);

        jButtonCerrar.setContentAreaFilled(false);
        int size = 20;
        jButtonCerrar.setPreferredSize(new Dimension(size, size));
        jButtonCerrar.setToolTipText("Cerrar Pestaña");

        //tabButton.setText("...");
        //jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("../Imagenes/boton_cerrar.gif")));
        try {
            login = new Login();
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            SeccionPublica = new SeccionPublica();
            pestana(SeccionPublica, Cte.Seccion_Publica);
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCerrar = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuIniciarSesion = new javax.swing.JMenuItem();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();
        jMenuRegUsua = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuProyecto = new javax.swing.JMenu();
        jMenuItemCrearProy = new javax.swing.JMenuItem();
        jMenuItemModProy = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuAdmin = new javax.swing.JMenu();
        jMenuItemEstados = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jButtonCerrar.setText("jButton1");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane.setToolTipText("");
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        jMenuArchivo.setText("Archivo");

        jMenuIniciarSesion.setText("Iniciar sesión ");
        jMenuIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIniciarSesionActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuIniciarSesion);

        jMenuItemCerrarSesion.setText("Cerrar sesión ");
        jMenuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesionActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemCerrarSesion);

        jMenuRegUsua.setText("Registro de Usuario ");
        jMenuRegUsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegUsuaActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuRegUsua);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuSalir);

        jMenuBar.add(jMenuArchivo);

        jMenuProyecto.setText("Proyecto ");

        jMenuItemCrearProy.setText("Registrar Proyecto");
        jMenuItemCrearProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearProyActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuItemCrearProy);

        jMenuItemModProy.setText("Registrar Fases ");
        jMenuItemModProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModProyActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuItemModProy);

        jMenuItem6.setText("Actividades Proyecto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuItem6);

        jMenuItem2.setText("Consultar Proyecto");
        jMenuProyecto.add(jMenuItem2);

        jMenuBar.add(jMenuProyecto);

        jMenuAdmin.setText("Administrador ");

        jMenuItemEstados.setText("Aprobar Proyectos");
        jMenuItemEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadosActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItemEstados);

        jMenuItem1.setText("Asociar Proyecto aTutor");
        jMenuAdmin.add(jMenuItem1);

        jMenuBar.add(jMenuAdmin);

        jMenu1.setText("Convocatoria");

        jMenuItem3.setText("Registrar Convocatoria");
        jMenu1.add(jMenuItem3);

        jMenuBar.add(jMenu1);

        jMenu3.setText("Patente");

        jMenuItem4.setText("Registrar Pantente");
        jMenu3.add(jMenuItem4);

        jMenuBar.add(jMenu3);

        jMenu4.setText("Visitante");

        jMenuItem5.setText("Registrar Vistante");
        jMenu4.add(jMenuItem5);

        jMenuBar.add(jMenu4);

        jMenu2.setText("Ayuda");
        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane.getSelectedIndex() >= 0) {
            String temp = jTabbedPane.getTitleAt(jTabbedPane.getSelectedIndex());

            jTabbedPane.removeTabAt(jTabbedPane.getSelectedIndex());
        }
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jMenuIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIniciarSesionActionPerformed
        try {
            // TODO add your handling code here:
            
            login.setVisible(true);
            login.setAlwaysOnTop(true);
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuIniciarSesionActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        // TODO add your handling code here:
        jTabbedPane.removeAll();
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    private void jMenuRegUsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegUsuaActionPerformed
        // TODO add your handling code here:
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            registroPersona = new RegistroPersona();
            //this.add(pantallaHerramentero, BorderLayout.CENTER);
            pestana(registroPersona, Cte.Alta_Usuario);
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuRegUsuaActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuItemCrearProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearProyActionPerformed
        // TODO add your handling code here:
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            registroProyecto = new RegistroProyecto();
            pestana(registroProyecto, Cte.Registro_Proyecto);
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuItemCrearProyActionPerformed

    private void jMenuItemModProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModProyActionPerformed
        // TODO add your handling code here:
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            avancesProyecto = new AvancesProyecto();
            pestana(avancesProyecto, Cte.Avances_Proyecto);
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuItemModProyActionPerformed

    private void jMenuItemEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstadosActionPerformed
        // TODO add your handling code here:
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            estadoProyecto = new EstadoProyecto();
            pestana(estadoProyecto, Cte.Estado_Proyecto);
            this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuItemEstadosActionPerformed

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        // TODO add your handling code here:
        System.out.println(jTabbedPane.getSelectedIndex());
        if (jTabbedPane.getSelectedIndex() > -1) {
            JPanel pnl = new JPanel();
            pnl.setOpaque(false);
            JLabel label = new JLabel(jTabbedPane.getTitleAt(jTabbedPane.getSelectedIndex()));
            pnl.add(label);
            pnl.add(jButtonCerrar);
            if (jTabbedPane.getSelectedIndex() >= 0) {
                jTabbedPane.setTabComponentAt(jTabbedPane.getSelectedIndex(), pnl);
            }
        }
    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    public void pestana(JPanel pantalla, String title) {

        jTabbedPane.addTab(title, null, pantalla);
//jTabbedPane1.;
        JPanel pnl = new JPanel();
        pnl.setOpaque(true);
        JLabel label = new JLabel(title);
        pnl.add(label);
        pnl.add(jButtonCerrar);
        jTabbedPane.setTabComponentAt(jTabbedPane.getTabCount() - 1, pnl);
        jTabbedPane.setSelectedIndex(jTabbedPane.getTabCount() - 1);

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuIniciarSesion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JMenuItem jMenuItemCrearProy;
    private javax.swing.JMenuItem jMenuItemEstados;
    private javax.swing.JMenuItem jMenuItemModProy;
    private javax.swing.JMenu jMenuProyecto;
    private javax.swing.JMenuItem jMenuRegUsua;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
