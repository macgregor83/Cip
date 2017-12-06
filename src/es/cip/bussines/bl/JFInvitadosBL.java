/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFInvitadosBL {
    RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController=new RecursoHumanoProyectoJpaController();
    private List<RecursoHumanoProyecto> lisRHP;
    public void setLisRHP(String nombreProyecto){
        lisRHP=recursoHumanoProyectoJpaController.findProyecto(nombreProyecto, "", 1);
    }

    public List<RecursoHumanoProyecto> getLisRHP() {
        return lisRHP;
    }
    
    
}
