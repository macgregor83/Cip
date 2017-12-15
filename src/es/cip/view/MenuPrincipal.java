/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.util.Cte;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Vero
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private RegistroPersona registroPersona;
    private JFInvitados invitado;
    private JFRegistroPersona JFRegistroPersona;
    private JFDatosAcademicos datosAcademicos;
    private JAsociaciònUsuario asociacionUsuario;
    private JRegistroProyecto registroProyecto;
    private JFPatentes patente;
    private JFActividades actividades;
    private AvancesProyecto avancesProyecto;
    private JFEstadoProyecto estadoProyecto;
    private SeccionPublica SeccionPublica;
    private JFConvocatorias convocatoria;
    private JFAprobarProyecto aprovarProyecto;
    private JConsultaConvocatoria consultaConvocatoria;
    private JFases JFases;
    private Login login;
    private JFEstadosProyectos jFEstadosProyectos;
    private JFInvitados invitados;
    private JFConvocatorias jfConvocatorias;
    private JFProyectoConvocatoria jfProyectoConvocatoria;
    private JFCambioTipoUsuario jfCambioTipoUsuario;

    /**
     * Creates new form JMenuPrincipal
     */
    public MenuPrincipal() {
        jTabbedPane = new JTabbedPane();
        try {
            login = new Login();
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        
        jMenuUsuario.setVisible(false);
        jMenuProyecto.setVisible(false);
        jMenuAdmin.setVisible(false);
        jMenuConvocatoria.setVisible(false);
        jMenuPatente.setVisible(false);
        
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
//        try {
//            login = new Login();
//            login.setVisible(true);
//        } catch (Exception ex) {
//            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally {
        //    this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        login();
//        }
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
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuRegUsua = new javax.swing.JMenuItem();
        jDatosAcademicos = new javax.swing.JMenuItem();
        jMenuInvitado = new javax.swing.JMenuItem();
        jMenuProyecto = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCrearProy = new javax.swing.JMenuItem();
        jMenuItemModProy = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuAdmin = new javax.swing.JMenu();
        jMenuItemEstados = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuConvocatoria = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuPatente = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jButtonCerrar.setText("jButton1");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jTabbedPane.setToolTipText("");
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cip");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage((new ImageIcon(this.getClass().getResource("/Imagenes/cip.png"))).getImage());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cip.jpeg"))); // NOI18N

        jMenu6.setText("Cerrar Sesión");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar.add(jMenu6);

        jMenuUsuario.setText("Usuario");

        jMenuRegUsua.setText("Registro de Usuario ");
        jMenuRegUsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegUsuaActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuRegUsua);

        jDatosAcademicos.setText("Datos Académicos");
        jDatosAcademicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatosAcademicosActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jDatosAcademicos);

        jMenuInvitado.setText("Invitado");
        jMenuInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInvitadoActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuInvitado);

        jMenuBar.add(jMenuUsuario);

        jMenuProyecto.setText("Proyecto ");

        jMenu1.setText("NuevoProyecto ");

        jMenuItemCrearProy.setText("Registrar Proyecto ");
        jMenuItemCrearProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearProyActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCrearProy);

        jMenuItemModProy.setText("Registrar Fases ");
        jMenuItemModProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModProyActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemModProy);

        jMenuItem7.setText("Asociación Tutor / Usuario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuProyecto.add(jMenu1);

        jMenuItem6.setText("Actividades Proyecto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuItem6);

        jMenuItem2.setText("Estado del Proyecto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuProyecto.add(jMenuItem2);

        jMenuBar.add(jMenuProyecto);

        jMenuAdmin.setText("Administrador ");

        jMenuItemEstados.setText("Estado de Proyectos");
        jMenuItemEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadosActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItemEstados);

        jMenuItem3.setText("Registrar Convocatoria");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItem3);

        jMenuItem8.setText("Cambiar Tipo de Usuario ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuItem8);

        jMenuBar.add(jMenuAdmin);

        jMenuConvocatoria.setText("Convocatoria");

        jMenuItem1.setText("Consulta Convocatoria");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuConvocatoria.add(jMenuItem1);

        jMenuBar.add(jMenuConvocatoria);

        jMenuPatente.setText("Patente");

        jMenuItem4.setText("Registrar Patente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuPatente.add(jMenuItem4);

        jMenuBar.add(jMenuPatente);

        jMenu4.setText("Visitante");

        jMenuItem5.setText("Registrar Visitante");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar.add(jMenu4);

        jMenu2.setText("Ayuda");

        jMenu5.setText("Manual");
        jMenu2.add(jMenu5);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
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

    private void jMenuItemCrearProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearProyActionPerformed
        // TODO add your handling code here:
        try {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            registroProyecto = new JRegistroProyecto(login.getIdUsuario());
            registroProyecto.setVisible(true);
            //  pestana(registroProyecto, Cte.Registro_Proyecto);
            //this.pack();
//            this.setExtendedState(MAXIMIZED_BOTH);
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
            JFases = new JFases("", login.getIdUsuario());
            JFases.setVisible(true);         //  pestana(avancesProyecto, Cte.JFases);
            //this.pack();
//            this.setExtendedState(MAXIMIZED_BOTH);
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
            //estadoProyecto = new (1);
            jFEstadosProyectos = new JFEstadosProyectos();
            jFEstadosProyectos.setVisible(true);
            // pestana(estadoProyecto, Cte.Estado_Proyecto);
            //this.pack();
            this.setExtendedState(MAXIMIZED_BOTH);
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuItemEstadosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        actividades = new JFActividades(login.getIdUsuario());
        actividades.setVisible(true);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInvitadoActionPerformed
        invitado = new JFInvitados();
        invitado.setVisible(true);        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuInvitadoActionPerformed

    private void jMenuRegUsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegUsuaActionPerformed
        // TODO add your handling code here:
        try {
//            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            JFRegistroPersona = new JFRegistroPersona();
            JFRegistroPersona.setVisible(true);

            //this.add(pantallaHerramentero, BorderLayout.CENTER);
            //  pestana(JFRegistroPersona, Cte.Alta_Usuario);
//            this.pack();
//            this.setExtendedState(MAXIMIZED_BOTH);
//            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jMenuRegUsuaActionPerformed

    private void jDatosAcademicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatosAcademicosActionPerformed
        try {
            // TODO add your handling code here:
            datosAcademicos = new JFDatosAcademicos();
            datosAcademicos.setVisible(true);
            // login.setVisible(true);
            //login.setAlwaysOnTop(true);
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_jDatosAcademicosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        convocatoria = new JFConvocatorias();
        convocatoria.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        patente = new JFPatentes();
        patente.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        invitados = new JFInvitados();
        invitados.setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        estadoProyecto = new JFEstadoProyecto(login.getIdUsuario());
        estadoProyecto.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        asociacionUsuario = new JAsociaciònUsuario("", login.getIdUsuario());
        asociacionUsuario.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jfProyectoConvocatoria = new JFProyectoConvocatoria(login.getIdUsuario());
        jfProyectoConvocatoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
        this.login();
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        try {
            // TODO add your handling code here:
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            login = new Login();
            login.setVisible(true);
            login();
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        // this.login();
        if (login.isVal()) {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_formMouseExited

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

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jfCambioTipoUsuario = new JFCambioTipoUsuario();
        jfCambioTipoUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("Salio"+login.getIdUsuario());
        
    }//GEN-LAST:event_formWindowClosing
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
    
    private void login() {
        final Thread t;
        t = new Thread(new Runnable() {
            //Implementamos el método run()
            @Override
            public void run() {
                // setVisible(true);
                //current.setStringPainted(true);
                boolean van = true;
                do {
                    
                    try {
                        Thread.sleep(1000);
                        if (login.isVal()) {
                            //System.out.println((login.getIdTipoUsuario() == Cte.Tipo_Alumno || login.getIdTipoUsuario() == Cte.Tipo_Asesor) ? true : false);
                            jMenuUsuario.setVisible((login.getIdTipoUsuario() == Cte.Tipo_Alumno || login.getIdTipoUsuario() == Cte.Tipo_Asesor) ? true : false);
                            jMenuProyecto.setVisible((login.getIdTipoUsuario() == Cte.Tipo_Alumno || login.getIdTipoUsuario() == Cte.Tipo_Asesor) ? true : false);
                            jMenuAdmin.setVisible((login.getIdTipoUsuario() == Cte.Tipo_Admin) ? true : false);
                            jMenuConvocatoria.setVisible((login.getIdTipoUsuario() == Cte.Tipo_Alumno || login.getIdTipoUsuario() == Cte.Tipo_Asesor) ? true : false);
                            jMenuPatente.setVisible((login.getIdTipoUsuario() == Cte.Tipo_Alumno || login.getIdTipoUsuario() == Cte.Tipo_Asesor) ? true : false);
                            System.out.println("CIP- \t" + login.getUsuario().getNombre() + " " + login.getUsuario().getApellidoPaterno() + " " + login.getUsuario().getApellidoMaterno() + " ");
                            setTitle("CIP- \t" + login.getUsuario().getNombre() + " " + login.getUsuario().getApellidoPaterno() + " " + login.getUsuario().getApellidoMaterno() + " ");
                            login.setVisible(false);
                            van = false;
                        } else {
                            login.toFront();
                            jMenuUsuario.setVisible(false);
                            jMenuProyecto.setVisible(false);
                            jMenuAdmin.setVisible(false);
                            jMenuPatente.setVisible(false);
                            setTitle("CIP-");
                            //login.setVisible(true);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (van);
            }
        });
        //Se ejecuta el Thread
        t.start();
        
    }
    
    public void loginVisible() {
        try {
            login = new Login();
            login.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
//                Login lo;
//                try {
//                    lo = new Login();
//                    lo.setVisible(true);
//                    lo.show();
//                } catch (Exception ex) {
//                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JMenuItem jDatosAcademicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConvocatoria;
    private javax.swing.JMenuItem jMenuInvitado;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemCrearProy;
    private javax.swing.JMenuItem jMenuItemEstados;
    private javax.swing.JMenuItem jMenuItemModProy;
    private javax.swing.JMenu jMenuPatente;
    private javax.swing.JMenu jMenuProyecto;
    private javax.swing.JMenuItem jMenuRegUsua;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables

//    private void cerrar() {
//
//        Object[] opciones = {"Aceptar", "Cancelar"};
//        int eleccion = JOptionPane.showOptionDialog(rootPane, "En realidad desea realizar cerrar la aplicacion", "Mensaje de Confirmacion",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
//        if (eleccion == JOptionPane.YES_OPTION) {
//            System.exit(0);
//        } else {
//        }
//    }
//
//    private void formWindowClosing(java.awt.event.WindowEvent evt) {
//        cerrar();
//    }
}
