/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.JFasesBL;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Cte;
import es.cip.util.ValidCampos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Vero
 */
public class JFases extends javax.swing.JFrame {

    private JFasesBL bL = new JFasesBL();
    private final DefaultTableModel modelFase;

    /** 
     * Creates new form JFases
     */
    public JFases(String idProyecto, Integer idUsuario) {
        
        initComponents();
        this.setTitle(Cte.Titulo_JFases);
        bL.setIdProyecto(idProyecto);
        bL.setIdUsuario(idUsuario);

        jLabelAlertNomPro.setVisible(false);
        jLabelAlertNomMeto.setVisible(false);
        jLabelAlertNomFace.setVisible(false);

        jLabelAlertNomPro.setToolTipText(Cte.Proyecto_No_existe);
        jLabelAlertNomMeto.setToolTipText(Cte.Solo_Letras);
        jLabelAlertNomFace.setToolTipText(Cte.Solo_Letras);

        for (Proyecto object : bL.getLisProyecto()) {
            jComboBoxProyecto.addItem(object.getNombreProyecto());

        }
        for (int i = 0; i < bL.getLisProyecto().get(0).getTiempoEstimado(); i++) {
            jComboBoxIniciaMes.addItem((i + 1) + "");
        }
        modelFase = (DefaultTableModel) jTable6.getModel();
        modelFase.setNumRows(0);
        ///// jComboBoxNombre ////
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldNombreFase = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxDuracion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxIniciaMes = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextFieldActividad = new javax.swing.JTextArea();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObjetivo = new javax.swing.JTextArea();
        jLabelAlertNomFace = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldNombreMetod = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButtonMas = new javax.swing.JButton();
        jButtonMenos = new javax.swing.JButton();
        jComboBoxProyecto = new javax.swing.JComboBox<>();
        jLabelAlertNomPro = new javax.swing.JLabel();
        jLabelAlertNomMeto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Metodologia/Cronograma");

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldNombreFase.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFaseFocusLost(evt);
            }
        });
        jTextFieldNombreFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreFaseActionPerformed(evt);
            }
        });

        jLabel42.setText("Nombre de la fase");

        jComboBoxDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDuracionActionPerformed(evt);
            }
        });

        jLabel7.setText("Duracion");

        jLabel43.setText("Inicia en el mes");

        jComboBoxIniciaMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxIniciaMesItemStateChanged(evt);
            }
        });
        jComboBoxIniciaMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIniciaMesActionPerformed(evt);
            }
        });

        jTextFieldActividad.setColumns(20);
        jTextFieldActividad.setRows(5);
        jScrollPane13.setViewportView(jTextFieldActividad);

        jLabel44.setText("Objetivo");

        jLabel46.setText("meses");

        jLabel48.setText("Actividad");

        jTextAreaObjetivo.setColumns(20);
        jTextAreaObjetivo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObjetivo);

        jLabelAlertNomFace.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertNomFace.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertNomFace.setText("*");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel42)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxIniciaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel46))
                    .addComponent(jTextFieldNombreFase, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAlertNomFace)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombreFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jLabelAlertNomFace, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBoxDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(jComboBoxIniciaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel44)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next.png"))); // NOI18N
        jButton5.setText("Siguente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel47.setText("Nombre del Proyecto");

        jTextFieldNombreMetod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNombreMetodFocusLost(evt);
            }
        });
        jTextFieldNombreMetod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreMetodActionPerformed(evt);
            }
        });

        jLabel49.setText("Nombre de la Metodologia");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Fase", "Actividad ", "Objetivo"
            }
        ));
        jScrollPane9.setViewportView(jTable6);

        jButtonMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        jButtonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasActionPerformed(evt);
            }
        });

        jButtonMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        jButtonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosActionPerformed(evt);
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

        jLabelAlertNomPro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertNomPro.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertNomPro.setText("*");

        jLabelAlertNomMeto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertNomMeto.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertNomMeto.setText("*");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreMetod)
                                    .addComponent(jComboBoxProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(0, 35, Short.MAX_VALUE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAlertNomPro)
                    .addComponent(jLabelAlertNomMeto))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jComboBoxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAlertNomPro))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreMetod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMas)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabelAlertNomMeto)
                        .addGap(84, 84, 84)
                        .addComponent(jButtonMenos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreFaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreFaseActionPerformed

    private void jComboBoxDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDuracionActionPerformed

    private void jButtonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasActionPerformed
        // TODO add your handling code here:
        jComboBoxProyecto.setEnabled(false);
        jTextFieldNombreMetod.setEnabled(false);
        modelFase.addRow(new Object[]{jTextFieldNombreFase.getText(), jTextFieldActividad.getText(), jTextAreaObjetivo.getText()});
        bL.getFase(jTextFieldNombreFase.getText().trim(),
                jComboBoxDuracion.getSelectedIndex(),
                jComboBoxIniciaMes.getSelectedIndex(),
                jTextAreaObjetivo.getText(),
                jTextFieldActividad.getText());
        jTextFieldNombreFase.setText("");
        jComboBoxDuracion.setSelectedIndex(0);
        jComboBoxIniciaMes.setSelectedIndex(0);
        jTextAreaObjetivo.setText("");
        jTextFieldActividad.setText("");
    }//GEN-LAST:event_jButtonMasActionPerformed

    private void jButtonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosActionPerformed
        // TODO add your handling code here:
        if (jTable6.getSelectedRows().length == 0) {
            bL.getLisFace().remove(jTable6.getRowCount() - 1);
            modelFase.removeRow(jTable6.getRowCount() - 1);
        } else {
            for (int i = jTable6.getSelectedRows().length; 0 < i; i--) {
                bL.getLisFace().remove(jTable6.getSelectedRows()[i - 1]);
                modelFase.removeRow(jTable6.getSelectedRows()[i - 1]);
            }
        }
        if (jTable6.getRowCount() == 0) {
            jComboBoxProyecto.setEnabled(true);
            jTextFieldNombreMetod.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonMenosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //jComboBox1.getSelectedItem();
//        jButtonMas.doClick();
        if (jTextFieldNombreMetod.getText().trim() != ""
                && ValidCampos.sonLetrasNumero(jTextFieldNombreMetod.getText())
                && jTextFieldNombreFase.getText().trim() != ""
                && ValidCampos.sonLetrasNumero(jTextFieldNombreFase.getText())
                && jTextFieldActividad.getText().trim() != ""
                && jTextAreaObjetivo.getText().trim() != ""
                && jComboBoxProyecto.getItemCount() == 1
                && jTable6.getRowCount() > 0) {
            bL.guardar(jTextFieldNombreMetod.getText().trim());
            JAsociaciònUsuario asociacionUsuario = new JAsociaciònUsuario("", bL.getIdUsuario());
            asociacionUsuario.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, Cte.Falta_llenar_Campos);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldNombreMetodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreMetodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreMetodActionPerformed

    private void jComboBoxIniciaMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxIniciaMesItemStateChanged
        // TODO add your handling code here:
        jComboBoxDuracion.removeAllItems();
        for (int i = 0; i < jComboBoxIniciaMes.getItemCount() - jComboBoxIniciaMes.getSelectedIndex(); i++) {
            jComboBoxDuracion.addItem((i + 1) + "");
        }
    }//GEN-LAST:event_jComboBoxIniciaMesItemStateChanged

    private void jComboBoxIniciaMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIniciaMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIniciaMesActionPerformed

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

    private void jTextFieldNombreMetodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreMetodFocusLost
        // TODO add your handling code here:
        jLabelAlertNomMeto.setVisible(!ValidCampos.sonLetrasNumero(jTextFieldNombreMetod.getText()));
    }//GEN-LAST:event_jTextFieldNombreMetodFocusLost

    private void jTextFieldNombreFaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFaseFocusLost
        // TODO add your handling code here:
        jLabelAlertNomFace.setVisible(!ValidCampos.sonLetrasNumero(jTextFieldNombreFase.getText()));
    }//GEN-LAST:event_jTextFieldNombreFaseFocusLost

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
            java.util.logging.Logger.getLogger(JFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFases f = new JFases("11711031227240000001", 2);
//                f.setIdProyecto("11710262216430000001");
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonMas;
    private javax.swing.JButton jButtonMenos;
    private javax.swing.JComboBox<String> jComboBoxDuracion;
    private javax.swing.JComboBox<String> jComboBoxIniciaMes;
    private javax.swing.JComboBox<String> jComboBoxProyecto;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAlertNomFace;
    private javax.swing.JLabel jLabelAlertNomMeto;
    private javax.swing.JLabel jLabelAlertNomPro;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextAreaObjetivo;
    private javax.swing.JTextArea jTextFieldActividad;
    private javax.swing.JTextField jTextFieldNombreFase;
    private javax.swing.JTextField jTextFieldNombreMetod;
    // End of variables declaration//GEN-END:variables

//    public void datos(String idProyecto,Integer idUsuario) {
//        bL.setIdProyecto(idProyecto);
//        bL.setIdUsuario(idUsuario);
//        for (int i = 0; i < bL.getProyecto().getTiempoEstimado(); i++) {
//            jComboBoxIniciaMes.addItem((i + 1) + "");
//        }        
//    }
}
