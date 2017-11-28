/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.FaceJpaController;
import es.cip.bussines.dao.control.MetodologiaJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.Metodologia;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.util.Cte;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iMac
 */
public class JFasesBL {

    private Integer idUsuario;
    private String idProyecto;

    private Metodologia metodologia = new Metodologia();
    private Face face = new Face();
    private Proyecto proyecto = new Proyecto();

    private MetodologiaJpaController metodologiaJpaController = new MetodologiaJpaController();
    private FaceJpaController faceJpaController = new FaceJpaController();
    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();

    private List<Face> lisFace = new ArrayList<>();
    private List<Proyecto> lisProyecto = new ArrayList<>();

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        lisProyecto = proyectoJpaController.findProyecto(idProyecto, idUsuario, Cte.Estatus_Registro_Proyecto_F1);
        if (lisProyecto.size()>0) {
            idProyecto=lisProyecto.get(0).getId();
        }
    }

    public void setIdProyecto(String id) {
        this.idProyecto = id;
        proyecto = proyectoJpaController.findProyecto(idProyecto);
    }

    public List<Proyecto> setNombreProyecto(String nombreProyecto) {
        lisProyecto = proyectoJpaController.findProyecto(nombreProyecto, idUsuario, Cte.Estatus_Registro_Proyecto_F1);
        return lisProyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public List<Proyecto> getLisProyecto() {
        return lisProyecto;
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public List<Face> getLisFace() {
        return lisFace;
    }

    public void getFase(String nombreFase, Integer duracion, Integer iniciaMes, String objeto, String actividad) {
        this.face.setNombreFase(nombreFase);
        this.face.setDuracion(duracion);
        this.face.setIniciaMes(iniciaMes);
        this.face.setObjetivo(objeto);
        this.face.setActividad(actividad);
        lisFace.add(face);

    }

    public void guardar(String metodo ) {        
        metodologia.setMetodologia(metodo);    
        metodologia.setIdProyecto(idProyecto);
        metodologiaJpaController.create(metodologia);
        
        for (Face face1 : lisFace) {
            face1.setIdMetodologia(metodologia.getId());
            faceJpaController.create(face);
        }
        Proyecto proyecto = proyectoJpaController.findProyecto(idProyecto);
        proyecto.setIdEstatusProyecto(Cte.Estatus_Registro_Proyecto_F2);
        try {
            proyectoJpaController.edit(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(JAsociaciònUsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
