/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.AreaColaboracionJpaController;
import es.cip.bussines.dao.control.FaceJpaController;
import es.cip.bussines.dao.control.ObjetivoEspecificoJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.control.RecursosMaterialesJpaController;
import es.cip.bussines.dao.model.AreaColaboracion;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.ObjetivoEspecifico;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.bussines.dao.model.RecursosMateriales;
import es.cip.util.Cte;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iMac
 */
public class JFEstadosProyectosBL {

    private RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();
    private ObjetivoEspecificoJpaController objetivoEspecificoJpaController = new ObjetivoEspecificoJpaController();
    private AreaColaboracionJpaController areaColaboracionJpaController = new AreaColaboracionJpaController();
    private RecursosMaterialesJpaController recursosMaterialesJpaController = new RecursosMaterialesJpaController();
    private RecursoHumanoProyectoJpaController recursosHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();
    private FaceJpaController faceJpaController = new FaceJpaController();
    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();

    private List<RecursoHumanoProyecto> lisRHP;
    private List<ObjetivoEspecifico> lisObjEsp;
    private List<AreaColaboracion> lisAreaCol;
    private List<RecursosMateriales> lisRH;
    private List<Face> lisFace;
    private Proyecto proyecto;

    public void getProyectos() {
        recursoHumanoProyectoJpaController.findRecursoHumanoProyecto(1);
    }

    public List<RecursoHumanoProyecto> setNombreProyecto(String nombreProyecto, String nombreUsuario) {
        lisRHP = recursoHumanoProyectoJpaController.findProyecto(nombreProyecto, nombreUsuario, Cte.Estatus_Proyecto_Por_Aprobacion);
        return lisRHP;
    }

    public List<RecursoHumanoProyecto> getLisRHP() {
        return lisRHP;
    }

    public List<ObjetivoEspecifico> getLisObjEsp(String idProyecto) {
        lisObjEsp = objetivoEspecificoJpaController.findProyecto(idProyecto);
        proyecto = lisObjEsp.get(0).getProyecto();
        return lisObjEsp;
    }

    public List<AreaColaboracion> getLisAreaCol(String idProyecto) {
        return lisAreaCol = areaColaboracionJpaController.findProyecto(idProyecto);
    }

    public List<RecursosMateriales> getLisRM(String idProyecto) {
        return lisRH = recursosMaterialesJpaController.findProyecto(idProyecto);
    }

    public List<RecursoHumanoProyecto> getLisRMP(String idProyecto) {
        return recursoHumanoProyectoJpaController.findProyecto(idProyecto);
    }

    public List<Face> getLisFase(String idProyecto) {
        return lisFace = faceJpaController.findProyecto(idProyecto);
    }

    public boolean guardar() {
        try {
            if (proyecto.getIdEstatusProyecto() == Cte.Estatus_Proyecto_Por_Aprobacion) {
                proyecto.setIdEstatusProyecto(Cte.Estatus_Proyecto_Aprobado);
                proyectoJpaController.edit(proyecto);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, Cte.No_aprueba);
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(JFEstadosProyectosBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
}
