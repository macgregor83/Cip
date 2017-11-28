/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.prueba;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFEstadoProyectoBL {

    private Integer idUsuario;
    public RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();

    public RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();
    public ProyectoJpaController proyectoJpaController=new ProyectoJpaController();
    private List<Proyecto> listProyecto;
    
    public JFEstadoProyectoBL(Integer idUsuario) {
        this.idUsuario = idUsuario;
        RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();
       
    }
    public List<Proyecto> getListProyecto(String nombreProyecto){
        listProyecto=proyectoJpaController.findProyecto(nombreProyecto, idUsuario);
        return listProyecto;
    }
    
}
