/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.JFProyectoConvocatoriaBL;
import es.cip.bussines.dao.model.Convocatoria;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.util.Convertir;
import es.cip.util.Cte;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Vero
 */
public class JFProyectoConvocatoria extends javax.swing.JFrame {

    private final JFProyectoConvocatoriaBL bl;
    private final DefaultTableModel modelProyecto;
    private final DefaultTableModel modelConvocatoria;

    /**
     * Creates new form JFProyectoConvocatoria
     */
    public JFProyectoConvocatoria(Integer idUsuario) {
        bl = new JFProyectoConvocatoriaBL(idUsuario);
        initComponents();
        modelProyecto = (DefaultTableModel) jTableProyecto.getModel();
        modelProyecto.setNumRows(0);

        modelConvocatoria = (DefaultTableModel) jTable2.getModel();
        modelConvocatoria.setNumRows(0);

        ///// jComboBoxNombre ////
        jComboBoxProyecto.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxProyecto.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Proyecto> list = bl.getListProyecto(cadenaEscrita);
                modelProyecto.setNumRows(0);
                if (list.size() > 0) {
                    for (Proyecto proyecto : list) {
                        modelo.addElement(proyecto.getNombreProyecto());
                        modelProyecto.addRow(new Object[]{proyecto.getNombreProyecto(), 0, proyecto.getEstatusProyecto().getDescripcion()});
                    }
                    jComboBoxProyecto.setModel(modelo);
//                    if (jComboBoxProyecto.getItemCount() > 0) {
//                        jComboBoxProyecto.showPopup();
//                        if (evt.getKeyCode() != 8) {
//                            ((JTextComponent) jComboBoxProyecto.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxProyecto.getEditor().getItem().toString().length());
//                        } else {
//                            jComboBoxProyecto.getEditor().setItem(cadenaEscrita);
//                        }
//                    } else {
//                        jComboBoxProyecto.addItem(cadenaEscrita);
//                    }
                } else {
                    jComboBoxProyecto.setModel(modelo);
                }
            }
        });

        jComboBoxBuscarConvocatorio.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxBuscarConvocatorio.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Convocatoria> list = bl.getListConvocatoria(cadenaEscrita);
                modelConvocatoria.setNumRows(0);
                if (list.size() > 0) {
                    for (Convocatoria convocatoria : list) {
                        modelo.addElement(convocatoria.getConvocatoria());
                        modelConvocatoria.addRow(new Object[]{convocatoria.getConvocatoria(), convocatoria.getFechaAperura(), convocatoria.getFechaCierre()});
                    }
                    jComboBoxBuscarConvocatorio.setModel(modelo);
//                    if (jComboBoxBuscarConvocatorio.getItemCount() > 0) {
//                        jComboBoxBuscarConvocatorio.showPopup();
//                        if (evt.getKeyCode() != 8) {
//                            ((JTextComponent) jComboBoxBuscarConvocatorio.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxBuscarConvocatorio.getEditor().getItem().toString().length());
//                        } else {
//                            jComboBoxBuscarConvocatorio.getEditor().setItem(cadenaEscrita);
//                        }
//                    } else {
//                        jComboBoxBuscarConvocatorio.addItem(cadenaEscrita);
//                    }
                } else {
                    jComboBoxBuscarConvocatorio.setModel(modelo);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProyecto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxBuscarConvocatorio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonCargar1 = new javax.swing.JButton();
        jComboBoxProyecto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Proyecto", "Porcentaje de Avance", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTableProyecto);

        jLabel1.setText("Nombre del Proyecto:");

        jComboBoxBuscarConvocatorio.setEditable(true);

        jLabel2.setText("Convocatoria:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Convocatoria", "Fecha Aperura", "Fecha Cierre"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButtonCargar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/asociado.png"))); // NOI18N
        jButtonCargar1.setText("Asociar Convocatoria");
        jButtonCargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargar1ActionPerformed(evt);
            }
        });

        jComboBoxProyecto.setEditable(true);

        jButton1.setText("Descargar convocatoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Abrir Pagina");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("*Seleccionar una convocatoria ");

        jLabel4.setText("*Seleccione un proyecto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCargar1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jComboBoxBuscarConvocatorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProyecto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuscarConvocatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCargar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargar1ActionPerformed
        // TODO add your handling code here:
        if (jTableProyecto.getSelectedRows().length == 1 && jTable2.getSelectedRows().length == 1) {
            bl.guardar(jTableProyecto.getSelectedRow(), jTable2.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, Cte.Selecciona_Solo_Uno);
        }
    }//GEN-LAST:event_jButtonCargar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (jTable2.getSelectedRows().length == 1) {
                Desktop.getDesktop().browse(new URI(bl.getListConvocatoria().get(jTable2.getSelectedRow()).getUrl()));
            } else {
                JOptionPane.showMessageDialog(null, Cte.Selecciona_Solo_Uno);
            }
        } catch (Exception ex) {
            Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,Cte.Error_Abrir_Pagina+"\n"+ ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (jTable2.getSelectedRows().length == 1) {
                Convertir.convertByteArrayToDoc(bl.getListConvocatoria().get(jTable2.getSelectedRow()).getAchivoPDF(),bl.getListConvocatoria().get(jTable2.getSelectedRow()).getExtAchivoPDF());
            } else {
                JOptionPane.showMessageDialog(null, Cte.Selecciona_Solo_Uno);
            }
        } catch (IOException ex) {
            Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,Cte.Error_Abrir_PDF+"\n"+ ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProyectoConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProyectoConvocatoria(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCargar1;
    private javax.swing.JComboBox<String> jComboBoxBuscarConvocatorio;
    private javax.swing.JComboBox<String> jComboBoxProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableProyecto;
    // End of variables declaration//GEN-END:variables
}
