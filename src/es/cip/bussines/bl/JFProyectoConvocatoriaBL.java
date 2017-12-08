/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ConvocaProyecJpaController;
import es.cip.bussines.dao.control.ConvocatoriaJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.model.ConvocaProyec;
import es.cip.bussines.dao.model.Convocatoria;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.util.Fecha;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFProyectoConvocatoriaBL {

    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();
    private ConvocatoriaJpaController convocatoriaJpaController = new ConvocatoriaJpaController();
    private ConvocaProyecJpaController convocaProyecJpaController=new ConvocaProyecJpaController();

    private List<Proyecto> listProyecto;
    private List<Convocatoria> listConvocatoria;
    private final Integer idUsuario;
    private ConvocaProyec convocaProyec;

    public JFProyectoConvocatoriaBL(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Proyecto> getListProyecto(String nombreProyecto) {
        return listProyecto = proyectoJpaController.findProyecto(nombreProyecto, idUsuario);

    }

    public List<Proyecto> getListProyecto() {
        return listProyecto;
    }

    public List<Convocatoria> getListConvocatoria(String convocatoria) {
        return listConvocatoria = convocatoriaJpaController.findConvocatoria(convocatoria);
    }

    public List<Convocatoria> getListConvocatoria() {
        return listConvocatoria;
    }

    public void guardar(int rowProyecto, int rowConvoca) {
        convocaProyec=new ConvocaProyec();
        //convocaProyec.setId(1);
        convocaProyec.setIdProyecto(listProyecto.get(rowProyecto).getId());
        convocaProyec.setIdConvocatoria(listConvocatoria.get(rowConvoca).getId());
        convocaProyec.setFecha(Fecha.Date());
        convocaProyecJpaController.create(convocaProyec);
        
    }
}
