/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.view;

import es.cip.bussines.bl.JFEstadosProyectosBL;
import es.cip.bussines.dao.model.AreaColaboracion;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.ObjetivoEspecifico;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.bussines.dao.model.RecursosMateriales;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Vero
 */
public class JFEstadosProyectos extends javax.swing.JFrame {

    private JFEstadosProyectosBL bL = new JFEstadosProyectosBL();
    private final DefaultTableModel modelTabla;
    private final DefaultTableModel modelObjEsp;
    private final DefaultTableModel modelArea;
    private final DefaultTableModel modelRM;
    private final DefaultTableModel modelMetodo;
    private final DefaultTableModel modelRH;

    /**
     * Creates new form JFEstadoProyecto
     */
    public JFEstadosProyectos() {
        initComponents();
        modelTabla = (DefaultTableModel) jTEstadoProyecto.getModel();
        modelTabla.setNumRows(0);

        modelObjEsp = (DefaultTableModel) jTableObjetivoEspecificos.getModel();
        modelObjEsp.setNumRows(0);

        modelArea = (DefaultTableModel) jTableArea.getModel();
        modelArea.setNumRows(0);

        modelRM = (DefaultTableModel) jTableRecursos.getModel();
        modelRM.setNumRows(0);

        modelMetodo = (DefaultTableModel) jTableMetodologia.getModel();
        modelMetodo.setNumRows(0);

        modelRH = (DefaultTableModel) jTableRH.getModel();
        modelRH.setNumRows(0);

        for (RecursoHumanoProyecto rhp : bL.setNombreProyecto("", "")) {
            modelTabla.addRow(new Object[]{
                rhp.getProyecto().getNombreProyecto(),
                rhp.getRecursoHumanoDatos().getUsuario().getNombre() + " "
                + rhp.getRecursoHumanoDatos().getUsuario().getApellidoPaterno() + " "
                + rhp.getRecursoHumanoDatos().getUsuario().getApellidoMaterno() + " - "
                + rhp.getRecursoHumanoDatos().getUsuario().getCorreoElectronico(),
                rhp.getProyecto().getTipoProyecto().getTipo(),
                rhp.getProyecto().getCriterioClasificacion().getCriterioClasificacion(),
                "0",
                rhp.getProyecto().getEstatusProyecto().getDescripcion()
            });
        }

        ///// jComboBoxNombre ////
        jComboBoxProyecto.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = jComboBoxProyecto.getEditor().getItem().toString().toUpperCase();
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement(cadenaEscrita);
                List<RecursoHumanoProyecto> list = bL.setNombreProyecto(cadenaEscrita, "");
                modelTabla.setNumRows(0);
                if (list.size() > 0) {
                    for (RecursoHumanoProyecto rhp : list) {
                        modelo.addElement(rhp.getProyecto().getNombreProyecto());

                        modelTabla.addRow(new Object[]{
                            rhp.getProyecto().getNombreProyecto(),
                            rhp.getRecursoHumanoDatos().getUsuario().getNombre() + " "
                            + rhp.getRecursoHumanoDatos().getUsuario().getApellidoPaterno() + " "
                            + rhp.getRecursoHumanoDatos().getUsuario().getApellidoMaterno() + " - "
                            + rhp.getRecursoHumanoDatos().getUsuario().getCorreoElectronico(),
                            rhp.getProyecto().getTipoProyecto().getTipo(),
                            rhp.getProyecto().getCriterioClasificacion().getCriterioClasificacion(),
                            "0",
                            rhp.getProyecto().getEstatusProyecto().getDescripcion()
                        });

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

        jFrame1 = new javax.swing.JFrame();
        jButtonActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableMetodologia = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRH = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelObjetivoGeneral = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableObjetivoEspecificos = new javax.swing.JTable();
        jLabelTiempo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObjetivoGeneral = new javax.swing.JTextArea();
        jTextFieldTiempo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaResumen = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabeCriterio = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableArea = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableRecursos = new javax.swing.JTable();
        jTextFieldNombreProyecto = new javax.swing.JTextField();
        jTextFieldTipoProyecto = new javax.swing.JTextField();
        jTextFieldCriterioClas = new javax.swing.JTextField();
        jTextFieldProductoEsperado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelEstados = new javax.swing.JLabel();
        jComboBoxEstados = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEstadoProyecto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProyecto = new javax.swing.JComboBox<>();
        jLabelEstado1 = new javax.swing.JLabel();
        jLabelEstado2 = new javax.swing.JLabel();
        jComboBoxAsesorAlumno = new javax.swing.JComboBox<>();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabelEstado = new javax.swing.JLabel();

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Metodologia/Cronograma");

        jTableMetodologia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Actividad ", "Duracion", "Objetivo"
            }
        ));
        jScrollPane9.setViewportView(jTableMetodologia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(1059, 356));

        jTableRH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Universidad", "Campus", "Carrera", "Correo", "Tipo"
            }
        ));
        jScrollPane4.setViewportView(jTableRH);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Recursos Humanos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4)
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(842, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(1059, 356));
        jPanel1.setMinimumSize(new java.awt.Dimension(1059, 356));

        jLabelObjetivoGeneral.setText("Objetivo General ");

        jLabelNombre.setText("Nombre del Proyecto");

        jTableObjetivoEspecificos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Objetivos Específicos"
            }
        ));
        jScrollPane12.setViewportView(jTableObjetivoEspecificos);

        jLabelTiempo.setText("Tiempo Estimado");

        jTextAreaObjetivoGeneral.setEditable(false);
        jTextAreaObjetivoGeneral.setColumns(20);
        jTextAreaObjetivoGeneral.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObjetivoGeneral);

        jTextFieldTiempo.setEditable(false);
        jTextFieldTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTiempoActionPerformed(evt);
            }
        });

        jLabel6.setText("meses");

        jLabelTipo.setText("Tipo de Proyecto");

        jLabel8.setText("Resumen/Abstract");

        jTextAreaResumen.setEditable(false);
        jTextAreaResumen.setColumns(20);
        jTextAreaResumen.setRows(5);
        jScrollPane3.setViewportView(jTextAreaResumen);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Datos Proyecto");

        jLabeCriterio.setText("Criterio de Clasificación");

        jLabelProducto.setText("Producto Esperado");

        jTableArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Areas de  Colaboración"
            }
        ));
        jScrollPane7.setViewportView(jTableArea);

        jTableRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Recursos Materiales"
            }
        ));
        jScrollPane8.setViewportView(jTableRecursos);

        jTextFieldNombreProyecto.setEditable(false);
        jTextFieldNombreProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProyectoActionPerformed(evt);
            }
        });

        jTextFieldTipoProyecto.setEditable(false);
        jTextFieldTipoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoProyectoActionPerformed(evt);
            }
        });

        jTextFieldCriterioClas.setEditable(false);

        jTextFieldProductoEsperado.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObjetivoGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTiempo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTipo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombreProyecto)
                            .addComponent(jTextFieldTipoProyecto))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeCriterio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jTextFieldCriterioClas)
                            .addComponent(jTextFieldProductoEsperado)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(522, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre)
                            .addComponent(jTextFieldNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipo)
                            .addComponent(jTextFieldTipoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTiempo)
                            .addComponent(jTextFieldTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObjetivoGeneral)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeCriterio)
                            .addComponent(jTextFieldCriterioClas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProducto)
                            .addComponent(jTextFieldProductoEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelEstados.setText("Estado");

        jComboBoxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobar" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Administrador");

        jLabelObservaciones.setText("Observaciones ");

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        jScrollPane10.setViewportView(jTextAreaObservaciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObservaciones, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEstados, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10)
                            .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstados)
                    .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObservaciones)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTEstadoProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre del Proyecto", "Contacto (Nombre/Correo) ", "Tipo de Proyecto", "Criterio de Clasificación", "Porcentaje de Avance ", "Estado"
            }
        ));
        jTEstadoProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEstadoProyectoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEstadoProyecto);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proyectos");

        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("*Dar clic en el proyecto para ver mas a detalle  ");

        jComboBoxProyecto.setEditable(true);
        jComboBoxProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProyectoActionPerformed(evt);
            }
        });

        jLabelEstado1.setText("Asesor /Alumno");

        jLabelEstado2.setText("Proyecto");

        jComboBoxAsesorAlumno.setEditable(true);
        jComboBoxAsesorAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAsesorAlumnoActionPerformed(evt);
            }
        });

        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        jLabelEstado.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1671, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 1383, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEstado1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEstado2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAsesorAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAsesorAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTEstadoProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEstadoProyectoMouseClicked
        // TODO add your handling code he        this.jFrame1.setVisible(true);
        modelObjEsp.setNumRows(0);
        modelArea.setNumRows(0);
        modelRM.setNumRows(0);
        modelRH.setNumRows(0);
        modelMetodo.setNumRows(0);
        jTextFieldNombreProyecto.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getNombreProyecto());
        jTextFieldTipoProyecto.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getTipoProyecto().getTipo());
        jTextFieldTiempo.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getTiempoEstimado() + "");
        jTextAreaObjetivoGeneral.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getObjGeneral());
        jTextAreaResumen.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getResumen());
        jTextFieldCriterioClas.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getCriterioClasificacion().getCriterioClasificacion());
        jTextFieldProductoEsperado.setText(bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getProductoEsperado().getProductoEsperado());
        String idProyecto = bL.getLisRHP().get(jTEstadoProyecto.getSelectedRow()).getProyecto().getId();
        for (ObjetivoEspecifico objetivoEspecifico : bL.getLisObjEsp(idProyecto)) {
            modelObjEsp.addRow(new Object[]{objetivoEspecifico.getObjEspecifico()});
        }

        for (AreaColaboracion obj : bL.getLisAreaCol(idProyecto)) {
            modelArea.addRow(new Object[]{obj.getAreaColaboracion()});
        }
        for (RecursosMateriales obj : bL.getLisRM(idProyecto)) {
            modelRM.addRow(new Object[]{obj.getRecursosMateriales()});
        }
        for (RecursoHumanoProyecto obj : bL.getLisRMP(idProyecto)) {
            modelRH.addRow(new Object[]{
                obj.getRecursoHumanoDatos().getUsuario().getNombre() + " " + obj.getRecursoHumanoDatos().getUsuario().getApellidoPaterno() + " " + obj.getRecursoHumanoDatos().getUsuario().getApellidoMaterno(),
                obj.getRecursoHumanoDatos().getUniversidad().getNombre(),
                obj.getRecursoHumanoDatos().getCampus().getNombre(),
                obj.getRecursoHumanoDatos().getCarrera().getNombreCarrera(),
                obj.getRecursoHumanoDatos().getUsuario().getCorreoElectronico(),
                obj.getRecursoHumanoDatos().getTipoUsuario().getTipo()
            });
        }
        for (Face obj : bL.getLisFase(idProyecto)) {
            modelMetodo.addRow(new Object[]{
                obj.getActividad(),
                obj.getDuracion(),
                obj.getObjetivo()
            });
        }

        jFrame1.setVisible(true);
        this.jFrame1.setExtendedState(MAXIMIZED_BOTH);
//        System.out.println("tt");
        //this.jTEstadoProyecto.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_jTEstadoProyectoMouseClicked

    private void jComboBoxProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProyectoActionPerformed

    private void jComboBoxAsesorAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAsesorAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAsesorAlumnoActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(!bL.guardar());
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTextFieldTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTiempoActionPerformed

    private void jTextFieldNombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProyectoActionPerformed

    private void jTextFieldTipoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTipoProyectoActionPerformed

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
            java.util.logging.Logger.getLogger(JFEstadosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEstadosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEstadosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEstadosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEstadosProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JComboBox<String> jComboBoxAsesorAlumno;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxEstados;
    private javax.swing.JComboBox<String> jComboBoxProyecto;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabeCriterio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelEstado1;
    private javax.swing.JLabel jLabelEstado2;
    private javax.swing.JLabel jLabelEstados;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelObjetivoGeneral;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTEstadoProyecto;
    private javax.swing.JTable jTableArea;
    private javax.swing.JTable jTableMetodologia;
    private javax.swing.JTable jTableObjetivoEspecificos;
    private javax.swing.JTable jTableRH;
    private javax.swing.JTable jTableRecursos;
    private javax.swing.JTextArea jTextAreaObjetivoGeneral;
    private javax.swing.JTextArea jTextAreaObservaciones;
    private javax.swing.JTextArea jTextAreaResumen;
    private javax.swing.JTextField jTextFieldCriterioClas;
    private javax.swing.JTextField jTextFieldNombreProyecto;
    private javax.swing.JTextField jTextFieldProductoEsperado;
    private javax.swing.JTextField jTextFieldTiempo;
    private javax.swing.JTextField jTextFieldTipoProyecto;
    // End of variables declaration//GEN-END:variables
}
