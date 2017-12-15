/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ObservacionesProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.model.ObservacionesProyecto;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.util.Cte;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iMac
 */
public class JFInvitadosBL {
    RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController=new RecursoHumanoProyectoJpaController();
    private ObservacionesProyecto observacionesProyecto = new ObservacionesProyecto();
    private ObservacionesProyectoJpaController observacionesProyectoJpaController = new ObservacionesProyectoJpaController();
    private List<RecursoHumanoProyecto> lisRHP;
    public void setLisRHP(String nombreProyecto){
        lisRHP=recursoHumanoProyectoJpaController.findProyecto(nombreProyecto, "", 1);
    }

    public List<RecursoHumanoProyecto> getLisRHP() {
        return lisRHP;
    }
    public boolean guardar(String observaciones, String idProyecto) {
        try {

            if (observaciones != "") {
                observacionesProyecto.setObservaciones(observaciones);
                observacionesProyecto.setIdProyecto(idProyecto);
                observacionesProyectoJpaController.create(observacionesProyecto);
                JOptionPane.showMessageDialog(null, Cte.Guardo_Correcto);
                return true;
            }
            return false;

        } catch (Exception ex) {
            Logger.getLogger(JFEstadosProyectosBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
}
