/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

/**
 *
 * @author Vero
 */
public class JFActividades extends javax.swing.JFrame {

    /**
     * Creates new form JFActividades
     */
    public JFActividades() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabelActividad1 = new javax.swing.JLabel();
        jComboBoxActividad1 = new javax.swing.JComboBox<>();
        jTextFieldAgregarArchivos1 = new javax.swing.JTextField();
        jLabelAgregarArchivos1 = new javax.swing.JLabel();
        jButtonCargar1 = new javax.swing.JButton();
        jScrollPaneActualizaciones1 = new javax.swing.JScrollPane();
        jTableActualizaciones1 = new javax.swing.JTable();
        jLabelEntregable1 = new javax.swing.JLabel();
        jComboBoxEntregable1 = new javax.swing.JComboBox<>();
        jLabelDescripcion1 = new javax.swing.JLabel();
        jScrollPaneDescripcion1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabelObservaciones1 = new javax.swing.JLabel();
        jScrollPaneObservaciones1 = new javax.swing.JScrollPane();
        jTextAreaObservaciones1 = new javax.swing.JTextArea();
        jButtonActualizar1 = new javax.swing.JButton();
        jButtonConcluida1 = new javax.swing.JButton();
        jButtonActualizar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelActividad1.setText("Actividad");

        jTextFieldAgregarArchivos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAgregarArchivos1ActionPerformed(evt);
            }
        });

        jLabelAgregarArchivos1.setText("Agregar archivos ");

        jButtonCargar1.setText("Cargar");

        jTableActualizaciones1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Archivo", "Fecha"
            }
        ));
        jScrollPaneActualizaciones1.setViewportView(jTableActualizaciones1);

        jLabelEntregable1.setText("Entregable");

        jLabelDescripcion1.setText("Descripcion");

        jTextAreaDescripcion1.setColumns(20);
        jTextAreaDescripcion1.setRows(5);
        jScrollPaneDescripcion1.setViewportView(jTextAreaDescripcion1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Actualizaciones de la Actividad");

        jLabelObservaciones1.setText("Observaciones ");

        jTextAreaObservaciones1.setColumns(20);
        jTextAreaObservaciones1.setRows(5);
        jScrollPaneObservaciones1.setViewportView(jTextAreaObservaciones1);

        jButtonActualizar1.setText("Actualizar Actividad");
        jButtonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar1ActionPerformed(evt);
            }
        });

        jButtonConcluida1.setText("Actividad Concluida");
        jButtonConcluida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluida1ActionPerformed(evt);
            }
        });

        jButtonActualizar2.setText("Eliminar Actividad");
        jButtonActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEntregable1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelActividad1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEntregable1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxActividad1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelObservaciones1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneObservaciones1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonActualizar1)
                                .addGap(41, 41, 41)
                                .addComponent(jButtonActualizar2)
                                .addGap(46, 46, 46)
                                .addComponent(jButtonConcluida1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAgregarArchivos1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelDescripcion1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAgregarArchivos1)
                                    .addComponent(jScrollPaneDescripcion1)))))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneActualizaciones1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCargar1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelActividad1)
                    .addComponent(jComboBoxActividad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEntregable1)
                    .addComponent(jComboBoxEntregable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAgregarArchivos1)
                    .addComponent(jTextFieldAgregarArchivos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescripcion1)
                    .addComponent(jScrollPaneDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCargar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneActualizaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObservaciones1)
                    .addComponent(jScrollPaneObservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonActualizar1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonActualizar2)
                        .addComponent(jButtonConcluida1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAgregarArchivos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAgregarArchivos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAgregarArchivos1ActionPerformed

    private void jButtonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizar1ActionPerformed

    private void jButtonConcluida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConcluida1ActionPerformed

    private void jButtonActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizar2ActionPerformed

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
            java.util.logging.Logger.getLogger(JFActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFActividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFActividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar1;
    private javax.swing.JButton jButtonActualizar2;
    private javax.swing.JButton jButtonCargar1;
    private javax.swing.JButton jButtonConcluida1;
    private javax.swing.JComboBox<String> jComboBoxActividad1;
    private javax.swing.JComboBox<String> jComboBoxEntregable1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabelActividad1;
    private javax.swing.JLabel jLabelAgregarArchivos1;
    private javax.swing.JLabel jLabelDescripcion1;
    private javax.swing.JLabel jLabelEntregable1;
    private javax.swing.JLabel jLabelObservaciones1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPaneActualizaciones1;
    private javax.swing.JScrollPane jScrollPaneDescripcion1;
    private javax.swing.JScrollPane jScrollPaneObservaciones1;
    private javax.swing.JTable jTableActualizaciones1;
    private javax.swing.JTextArea jTextAreaDescripcion1;
    private javax.swing.JTextArea jTextAreaObservaciones1;
    private javax.swing.JTextField jTextFieldAgregarArchivos1;
    // End of variables declaration//GEN-END:variables
}
