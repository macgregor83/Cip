/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.JFDatosAcademicosBL;
import es.cip.bussines.dao.model.Campus;
import es.cip.bussines.dao.model.Carrera;
import es.cip.bussines.dao.model.TipoUsuario;
import es.cip.bussines.dao.model.Universidad;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Cte;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Vero
 */
public class JFDatosAcademicos extends javax.swing.JFrame {

    private JFDatosAcademicosBL bL = new JFDatosAcademicosBL();

    /** Datos Academicos
     * Creates new form JFDatosAcademicos
     */
    public JFDatosAcademicos() {
        this.setTitle(Cte.Titulo_JFDatosAcademicos);
        initComponents();
        jLabelAlertaNoControl.setVisible(false);
        jLabelAlertaNombre.setVisible(false);

        jLabelAlertaNoControl.setToolTipText(Cte.No_Control_Rep);
        jLabelAlertaNombre.setToolTipText(Cte.No_Existe_Usuario);

        for (TipoUsuario li : bL.getListTipoUsuario("")) {
            if (li.getId() < Cte.Tipo_Admin) {
                jComboBoxTipoDA.addItem(li.getTipo());
            }
        }
        ///// jComboBoxNombre ////
        jComboBoxNombre.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxNombre.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Usuario> list = bL.findNombreCompleto(cadenaEscrita);
                if (list.size() > 0) {
                    for (Usuario Usuario : list) {
                        modelo.addElement(Usuario.getNombre() + " " + Usuario.getApellidoPaterno() + " " + Usuario.getApellidoMaterno() + "-" + Usuario.getCorreoElectronico());
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
        ///// jComboBoxUniversidad ////
        jComboBoxUniversidad.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxUniversidad.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Universidad> list = bL.getListUniversidad(cadenaEscrita);
                if (list.size() > 0) {
                    for (Universidad universidad : list) {
                        modelo.addElement(universidad.getNombre());
                    }
                    jComboBoxUniversidad.setModel(modelo);
                    if (jComboBoxUniversidad.getItemCount() > 0) {
                        jComboBoxUniversidad.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) jComboBoxUniversidad.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxUniversidad.getEditor().getItem().toString().length());
                        } else {
                            jComboBoxUniversidad.getEditor().setItem(cadenaEscrita);
                        }
                    } else {
                        jComboBoxUniversidad.addItem(cadenaEscrita);
                    }
                }
            }
        });
        ///// jComboBoxCampus ////
        jComboBoxCampus.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxCampus.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Campus> list = bL.getListCampus(cadenaEscrita);
                if (list.size() > 0) {
                    for (Campus campus : list) {
                        modelo.addElement(campus.getNombre());
                    }
                    jComboBoxCampus.setModel(modelo);
                    if (jComboBoxCampus.getItemCount() > 0) {
                        jComboBoxCampus.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) jComboBoxCampus.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxCampus.getEditor().getItem().toString().length());
                        } else {
                            jComboBoxCampus.getEditor().setItem(cadenaEscrita);
                        }
                    } else {
                        jComboBoxCampus.addItem(cadenaEscrita);
                    }
                }
            }
        });
        ///// jComboBoxCarrera ////
        jComboBoxCarrera.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxCarrera.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<Carrera> list = bL.getListCarrera(cadenaEscrita);
                if (list.size() > 0) {
                    for (Carrera carrera : list) {
                        modelo.addElement(carrera.getNombreCarrera());
                    }
                    jComboBoxCarrera.setModel(modelo);
                    if (jComboBoxCarrera.getItemCount() > 0) {
                        jComboBoxCarrera.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) jComboBoxCarrera.getEditor().getEditorComponent()).select(cadenaEscrita.length(), jComboBoxCarrera.getEditor().getItem().toString().length());
                        } else {
                            jComboBoxCarrera.getEditor().setItem(cadenaEscrita);
                        }
                    } else {
                        jComboBoxCarrera.addItem(cadenaEscrita);
                    }
                }
            }
        });
//        jComboBoxCampus.getEditor().getEditorComponent().addMouseListener(new MouseAdapter() {
//            
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldDireccionDA = new javax.swing.JTextField();
        jTextFieldLocalidadDA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxTipoDA = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldNoControl = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jComboBoxUniversidad = new javax.swing.JComboBox<>();
        jComboBoxCampus = new javax.swing.JComboBox<>();
        jComboBoxCarrera = new javax.swing.JComboBox<>();
        jLabelAlertaNoControl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxNombre = new javax.swing.JComboBox<>();
        jLabelAlertaNombre = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage((new ImageIcon(this.getClass().getResource("/Imagenes/cip.png"))).getImage());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Datos Academicos");

        jLabel13.setText("Universidad");

        jLabel14.setText("Campus");

        jLabel15.setText("Carrera");

        jLabel16.setText("Dirección");

        jLabel17.setText("Localidad");

        jTextFieldDireccionDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDireccionDAActionPerformed(evt);
            }
        });
        jTextFieldDireccionDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionDAKeyReleased(evt);
            }
        });

        jTextFieldLocalidadDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLocalidadDAActionPerformed(evt);
            }
        });
        jTextFieldLocalidadDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldLocalidadDAKeyReleased(evt);
            }
        });

        jLabel18.setText("Tipo");

        jComboBoxTipoDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxTipoDAKeyReleased(evt);
            }
        });

        jLabel23.setText("No de Control");

        jTextFieldNoControl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNoControlFocusLost(evt);
            }
        });
        jTextFieldNoControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNoControlActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jComboBoxUniversidad.setEditable(true);
        jComboBoxUniversidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxUniversidadKeyReleased(evt);
            }
        });

        jComboBoxCampus.setEditable(true);
        jComboBoxCampus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxCampusFocusLost(evt);
            }
        });
        jComboBoxCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCampusActionPerformed(evt);
            }
        });
        jComboBoxCampus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxCampusKeyReleased(evt);
            }
        });

        jComboBoxCarrera.setEditable(true);

        jLabelAlertaNoControl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertaNoControl.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertaNoControl.setText("*");

        jLabel1.setText("Nombre");

        jComboBoxNombre.setEditable(true);
        jComboBoxNombre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jComboBoxNombreMouseDragged(evt);
            }
        });
        jComboBoxNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxNombreFocusLost(evt);
            }
        });
        jComboBoxNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxNombreMouseClicked(evt);
            }
        });

        jLabelAlertaNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlertaNombre.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAlertaNombre.setText("*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNoControl)
                    .addComponent(jTextFieldDireccionDA)
                    .addComponent(jTextFieldLocalidadDA)
                    .addComponent(jComboBoxTipoDA, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUniversidad, 0, 319, Short.MAX_VALUE)
                    .addComponent(jComboBoxCampus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAlertaNoControl)
                    .addComponent(jLabelAlertaNombre))
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAlertaNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxTipoDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNoControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabelAlertaNoControl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldDireccionDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldLocalidadDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDireccionDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDireccionDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDireccionDAActionPerformed

    private void jTextFieldLocalidadDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLocalidadDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLocalidadDAActionPerformed

    private void jTextFieldNoControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNoControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNoControlActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if ((jComboBoxNombre.getItemCount() > 1 && jComboBoxNombre.getSelectedIndex() > 0) || bL.getNickname() != "") {
            try {
                jLabelAlertaNombre.setVisible(false);
                bL.getUniversidad().setNombre(jComboBoxUniversidad.getEditor().getItem().toString().toUpperCase().trim());
                bL.getCampus().setNombre(jComboBoxCampus.getEditor().getItem().toString().toUpperCase().trim());
                bL.getCarrera().setNombreCarrera(jComboBoxCarrera.getEditor().getItem().toString().toUpperCase().trim());
                bL.getRecursoHumanoDatos().setNoControl(jTextFieldNoControl.getText());
                bL.getCampus().setDireccion(jTextFieldDireccionDA.getText());
                bL.getCampus().setLocalidad(jTextFieldLocalidadDA.getText());
                bL.guardar(jComboBoxNombre.getSelectedIndex(),
                        jComboBoxTipoDA.getSelectedIndex(),
                        jComboBoxUniversidad.getSelectedIndex(),
                        jComboBoxCampus.getSelectedIndex(),
                        jComboBoxCarrera.getSelectedIndex());
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(JFDatosAcademicos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        } else {
            jLabelAlertaNombre.setVisible(true);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jComboBoxTipoDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxTipoDAKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxTipoDAKeyReleased

    private void jComboBoxUniversidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUniversidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUniversidadKeyReleased

    private void jTextFieldNoControlFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNoControlFocusLost
        // TODO add your handling code here:
        jLabelAlertaNoControl.setVisible(bL.extisteNoControl(jTextFieldNoControl.getText().trim()));
    }//GEN-LAST:event_jTextFieldNoControlFocusLost

    private void jTextFieldDireccionDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionDAKeyReleased
        // TODO add your handling code here:
        jTextFieldDireccionDA.setText(jTextFieldDireccionDA.getText().toUpperCase());
    }//GEN-LAST:event_jTextFieldDireccionDAKeyReleased

    private void jComboBoxNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNombreMouseClicked

    private void jComboBoxNombreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxNombreMouseDragged
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxNombreMouseDragged

    private void jComboBoxNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxNombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNombreFocusLost

    private void jTextFieldLocalidadDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLocalidadDAKeyReleased
        // TODO add your handling code here:
        jTextFieldLocalidadDA.setText(jTextFieldLocalidadDA.getText().toUpperCase());
    }//GEN-LAST:event_jTextFieldLocalidadDAKeyReleased

    private void jComboBoxCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCampusActionPerformed
        // TODO add your handling code here:
        if (bL.getListCampus().size() > 0) {
            jTextFieldDireccionDA.setText(bL.getListCampus().get(jComboBoxCampus.getSelectedIndex()-1).getDireccion());
            jTextFieldLocalidadDA.setText(bL.getListCampus().get(jComboBoxCampus.getSelectedIndex()-1).getLocalidad());
        }
    }//GEN-LAST:event_jComboBoxCampusActionPerformed

    private void jComboBoxCampusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCampusKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCampusKeyReleased

    private void jComboBoxCampusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxCampusFocusLost
        // TODO add your handling code here:
        if (bL.getListCampus().size() > 0) {
            jTextFieldDireccionDA.setText(bL.getListCampus().get(jComboBoxCampus.getSelectedIndex()-1).getDireccion());
            jTextFieldLocalidadDA.setText(bL.getListCampus().get(jComboBoxCampus.getSelectedIndex()-1).getLocalidad());
        }
    }//GEN-LAST:event_jComboBoxCampusFocusLost

    public void setNickname(String nickname) {
        bL.setNickname(nickname);

        jLabel1.setVisible(false);
        jComboBoxNombre.setVisible(false);
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
            java.util.logging.Logger.getLogger(JFDatosAcademicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFDatosAcademicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFDatosAcademicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFDatosAcademicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDatosAcademicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> jComboBoxCampus;
    private javax.swing.JComboBox<String> jComboBoxCarrera;
    private javax.swing.JComboBox<String> jComboBoxNombre;
    private javax.swing.JComboBox<String> jComboBoxTipoDA;
    private javax.swing.JComboBox<String> jComboBoxUniversidad;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAlertaNoControl;
    private javax.swing.JLabel jLabelAlertaNombre;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldDireccionDA;
    private javax.swing.JTextField jTextFieldLocalidadDA;
    private javax.swing.JTextField jTextFieldNoControl;
    // End of variables declaration//GEN-END:variables
}
