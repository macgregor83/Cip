/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.control.TipoUsuarioJpaController;
import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.bussines.dao.model.TipoUsuario;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Cte;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iMac
 */
public class JAsociaciònUsuarioBL {

    private Integer idUsuario;
    private String idProyecto;

    RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();

    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();
    private UsuarioJpaController usuarioJpaController = new UsuarioJpaController();
    private RecursoHumanoDatosJpaController recursoHumanoDatosJpaController = new RecursoHumanoDatosJpaController();
    private RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();
    private TipoUsuarioJpaController  tipoUsuarioJpaController = new TipoUsuarioJpaController();

    private List<Proyecto> lisProyecto;
    private List<Usuario> lisUsuario;
    private List<RecursoHumanoDatos> lisRHDatos;

    private List<RecursoHumanoProyecto> lisRHProyecto = new ArrayList<>();

    ;

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        lisProyecto = proyectoJpaController.findProyecto(idProyecto, idUsuario, Cte.Estatus_Registro_Proyecto_F2);
    }

    public void setIdProyecto(String id) {
        this.idProyecto = id;
    }

    public List<RecursoHumanoProyecto> getLisRHProyecto() {
        return lisRHProyecto;
    }

    public List<Proyecto> getLisProyecto() {
        return lisProyecto;
    }

    public List<RecursoHumanoDatos> getLisRHDatos() {
        return lisRHDatos;
    }

    public void setlisRHProyecto(String idProyecto, Integer idRHDatos) {
        this.idProyecto = idProyecto;
        recursoHumanoProyecto.setIdproyecto(idProyecto);
        recursoHumanoProyecto.setIdRecursoHumanoDatos(idRHDatos);
        lisRHProyecto.add(recursoHumanoProyecto);
    }

    public List<Proyecto> setNombreProyecto(String nombreProyecto) {
        lisProyecto = proyectoJpaController.findProyecto(nombreProyecto, idUsuario, Cte.Estatus_Registro_Proyecto_F2);
        return lisProyecto;
    }

    public List<RecursoHumanoDatos> findNombreCompleto(String nombre) {
        lisRHDatos = recursoHumanoDatosJpaController.findNombreUsuario(nombre);
        if (lisRHDatos.size() > 0) {
            for (RecursoHumanoDatos lisRHDato : lisRHDatos) {
                if (lisRHDato.getUsuario() == null) {
                    lisRHDato.setUsuario(usuarioJpaController.findUsuario(lisRHDato.getIdUsuario()));
                    lisRHDato.setTipoUsuario(tipoUsuarioJpaController.findTipoUsuario(lisRHDato.getIdTipoUsuario()));
                }
            }
        }
        return lisRHDatos;
    }

    public void guardar() {
        for (RecursoHumanoProyecto recursoHumanoProyecto1 : lisRHProyecto) {
            recursoHumanoProyectoJpaController.create(recursoHumanoProyecto1);
        }
        Proyecto proyecto = proyectoJpaController.findProyecto(idProyecto);
        proyecto.setIdEstatusProyecto(Cte.Estatus_Proyecto_Por_Aprobacion);
        try {
            proyectoJpaController.edit(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(JAsociaciònUsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
