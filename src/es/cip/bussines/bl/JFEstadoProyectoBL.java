/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.FaceJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.prueba;
import es.cip.util.Cte;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFEstadoProyectoBL {

    private Integer idUsuario;
    public RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();

    public RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();
    private FaceJpaController faceJpaController = new FaceJpaController();
    public ProyectoJpaController proyectoJpaController=new ProyectoJpaController();
    private List<Proyecto> listProyecto;
    private List<Face> lisFace;
    
    public JFEstadoProyectoBL(Integer idUsuario) {
        this.idUsuario = idUsuario;
        RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();
       
    }
    public List<Proyecto> getListProyecto(String nombreProyecto){
        listProyecto=proyectoJpaController.findProyecto(nombreProyecto, idUsuario);
        return listProyecto;
    }
    public int porsentaje(String idProyecto) {

        int cont = 0;
        int cont1 = 0;
        lisFace = faceJpaController.findProyecto(idProyecto);
        for (Face face1 : lisFace) {
            if (face1.getIdEstatusFase() == Cte.Estatus_Face_Termino) {
                cont += face1.getDuracion();
            }
            cont1 += face1.getDuracion();
        }
        if (cont1 > 0) {
            System.out.println(cont * 100 / cont1);
            return cont * 100 / cont1;
        }
        return 0;
    }
}
