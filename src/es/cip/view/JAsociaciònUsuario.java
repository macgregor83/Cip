/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.JAsociaciònUsuarioBL;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Cte;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Vero
 */
public class JAsociaciònUsuario extends javax.swing.JFrame {

    public JAsociaciònUsuarioBL bL = new JAsociaciònUsuarioBL();
    private final DefaultTableModel modelTabla;

    /**
     * Recursos Humanos Creates new form JAsociaciònUsuario
     */
    public JAsociaciònUsuario(String idProyecto, Integer idUsuario) {
        this.setTitle(Cte.Titulo_JAsociaciònUsuario);

        initComponents();

        bL.setIdProyecto(idProyecto);
        bL.setIdUsuario(idUsuario);
        jLabelAlertNomPro.setVisible(false);
        jLabelAlertNomPro.setToolTipText(Cte.Proyecto_No_existe);
        jComboBoxProyecto.setToolTipText(Cte.ToolTip_Escribe_Nombre_Proyecto);
        jComboBoxNombre.setToolTipText(Cte.ToolTip_Escribe_Nombre_Usuario);
        modelTabla = (DefaultTableModel) jTableAsesor.getModel();
        modelTabla.setNumRows(0);
        for (Proyecto object : bL.getLisProyecto()) {
            jComboBoxProyecto.addItem(object.getNombreProyecto());
            jComboBoxProyecto.addItem(object.getNombreProyecto());
        }
        List<RecursoHumanoDatos> list = bL.findNombreCompleto("");
        if (list.size() > 0) {
            DefaultComboBoxModel modelo=new DefaultComboBoxModel();
            for (RecursoHumanoDatos rh : list) {
                modelo.addElement(rh.getUsuario().getNombre() + " " + rh.getUsuario().getApellidoPaterno() + " " + rh.getUsuario().getApellidoMaterno() + "-" + rh.getUsuario().getCorreoElectronico() + "-" + rh.getTipoUsuario().getTipo());
            }
            jComboBoxNombre.setModel(modelo);
        }
        jComboBoxProyecto.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxProyecto.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Proyecto> list = bL.setNombreProyecto(cadenaEscrita);
                if (list.size() > 0) {
                    for (Proyecto proyecto : list) {
                        modelo.addElement(proyecto.getNombreProyecto());
                    }
                    jComboBoxProyecto.setModel(modelo);
                    if (jComboBoxProyecto.getItemCount() > 0) {
                        jComboBoxProyecto.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) jComboBoxProyecto.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxProyecto.getEditor().getItem().toString().length());
                        } else {
                            jComboBoxProyecto.getEditor().setItem(cadenaEscrita);
                        }
                    } else {
                        jComboBoxProyecto.addItem(cadenaEscrita);
                    }
                } else {
                    jComboBoxProyecto.setModel(modelo);
                }
            }
        });

        jComboBoxNombre.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxNombre.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<RecursoHumanoDatos> list = bL.findNombreCompleto(cadenaEscrita);
                if (list.size() > 0) {
                    for (RecursoHumanoDatos rh : list) {
                        modelo.addElement(rh.getUsuario().getNombre() + " " + rh.getUsuario().getApellidoPaterno() + " " + rh.getUsuario().getApellidoMaterno() + "-" + rh.getUsuario().getCorreoElectronico() + "-" + rh.getTipoUsuario().getTipo());
                    }
                    jComboBoxNombre.setModel(modelo);
                    if (jComboBoxNombre.getItemCount() > 0) {
                        jComboBoxNombre.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) jComboBoxNombre.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxNombre.getEditor().getItem().toString().length());
                        } else {
                            jComboBoxNombre.getEditor().setItem(cadenaEscrita);
                        }
                    } else {
                        jComboBoxNombre.addItem(cadenaEscrita);
                    }
                } else {
                    jComboBoxNombre.setModel(modelo);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxNombre = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBoxProyecto = new javax.swing.JComboBox<>();
        txtTutor = new javax.swing.JLabel();
        jbMayor = new javax.swing.JButton();
        jbtMenos = new javax.swing.JButton();
        jLabelAlertNomPro = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAsesor = new javax.swing.JTable();
        jLabelAlertNomPro1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage((new ImageIcon(this.getClass().getResource("/Imagenes/cip.png"))).getImage());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(1059, 356));

        jLabel9.setText("Proyecto");

        jComboBoxNombre.setEditable(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Recursos Humanos");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enviar.png"))); // NOI18N
        jButton2.setText("Enviar a Aprobación");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBoxProyecto.setEditable(true);
        jComboBoxProyecto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProyectoItemStateChanged(evt);
            }
        });
        jComboBoxProyecto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxProyectoFocusLost(evt);
            }
        });
        jComboBoxProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxProyectoKeyReleased(evt);
            }
        });

        txtTutor.setText("Tutor/Alumno");

        jbMayor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        jbMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMayorActionPerformed(evt);
            }
        });

        jbtMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        jbtMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMenosActionPerformed(evt);
            }
        });

        jLabelAlertNomPro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertNomPro.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertNomPro.setText("*");

        jTableAsesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Universidad", "Campus", "Carrera", "Correo", "Tipo Usuario"
            }
        ));
        jScrollPane4.setViewportView(jTableAsesor);

        jLabelAlertNomPro1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertNomPro1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertNomPro1.setText("*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(396, 396, 396))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTutor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAlertNomPro)
                            .addComponent(jLabelAlertNomPro1))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jbMayor)
                    .addComponent(jLabelAlertNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTutor)
                    .addComponent(jbtMenos)
                    .addComponent(jLabelAlertNomPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMenosActionPerformed
        // TODO add your handling code here:
        if (jTableAsesor.getSelectedRows().length == 0) {
            bL.getLisRHProyecto().remove(jTableAsesor.getRowCount() - 1);
            modelTabla.removeRow(jTableAsesor.getRowCount() - 1);

        } else {
            for (int i = jTableAsesor.getSelectedRows().length; 0 < i; i--) {
                bL.getLisRHProyecto().remove(jTableAsesor.getSelectedRows()[i - 1]);
                modelTabla.removeRow(jTableAsesor.getSelectedRows()[i - 1]);
            }
        }
        if (jTableAsesor.getRowCount() == 0) {
            jComboBoxProyecto.setEnabled(true);
        }
    }//GEN-LAST:event_jbtMenosActionPerformed

    private void jComboBoxProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxProyectoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProyectoKeyReleased

    private void jComboBoxProyectoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxProyectoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProyectoFocusLost

    private void jComboBoxProyectoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProyectoItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxProyecto.getItemCount() > 1) {
            System.out.println(jComboBoxProyecto.getSelectedItem().toString());
            bL.setNombreProyecto(jComboBoxProyecto.getSelectedItem().toString());
            if (bL.getLisProyecto().size() > 0) {
                jComboBoxProyecto.removeAllItems();
                jComboBoxProyecto.addItem(bL.getLisProyecto().get(0).getNombreProyecto());
                bL.setIdProyecto(bL.getLisProyecto().get(0).getId());
                jLabelAlertNomPro.setVisible(false);
            }
        } else {
            jLabelAlertNomPro.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxProyectoItemStateChanged

    private void jbMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMayorActionPerformed
        // TODO add your handling code here:
//        System.out.println((jComboBoxProyecto.getItemCount() > 0) +"-"+ (jComboBoxNombre.getItemCount() > 0) +"-"+
//                (jComboBoxProyecto.getSelectedIndex()> 0) +"-"+ (jComboBoxNombre.getSelectedIndex() > 0));
        jComboBoxProyecto.setEditable(false);
        System.out.println(jComboBoxProyecto.getSelectedIndex() + "-" + jComboBoxNombre.getSelectedIndex());
        if (jComboBoxProyecto.getItemCount() > 0 && jComboBoxNombre.getItemCount() > 0
                && jComboBoxNombre.getSelectedIndex() > 0) {
            modelTabla.addRow(new Object[]{bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getUsuario().getNombre(),
                bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getUniversidad().getNombre(),
                bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getCampus().getNombre(),
                bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getCarrera().getNombreCarrera(),
                bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getUsuario().getCorreoElectronico(),
                bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getTipoUsuario().getTipo()});
            bL.setlisRHProyecto(bL.getLisProyecto().get(jComboBoxProyecto.getSelectedIndex()).getId(), bL.getLisRHDatos().get(jComboBoxNombre.getSelectedIndex() - 1).getId());
            jComboBoxNombre.removeAllItems();
            JOptionPane.showMessageDialog(null, Cte.Mensaje_Espera_Apobar);
        } else {
            JOptionPane.showMessageDialog(rootPane, Cte.Selecciona_Campos);
        }
    }//GEN-LAST:event_jbMayorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        jButtonMas.doClick();
        if (jTableAsesor.getRowCount() > 0) {
            bL.guardar();
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, Cte.Falta_llenar_Campos);
        }
        System.out.println("hola");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JAsociaciònUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAsociaciònUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAsociaciònUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAsociaciònUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAsociaciònUsuario("11710262216430000001", 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxNombre;
    private javax.swing.JComboBox<String> jComboBoxProyecto;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAlertNomPro;
    private javax.swing.JLabel jLabelAlertNomPro1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAsesor;
    private javax.swing.JButton jbMayor;
    private javax.swing.JButton jbtMenos;
    private javax.swing.JLabel txtTutor;
    // End of variables declaration//GEN-END:variables
}
