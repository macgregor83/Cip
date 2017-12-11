/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.control.TipoUsuarioJpaController;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.TipoUsuario;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFCambioTipoUsuarioBL {

    private RecursoHumanoDatosJpaController recursoHumanoDatosJpaController = new RecursoHumanoDatosJpaController();
    private TipoUsuarioJpaController tipoUsuarioJpaController = new TipoUsuarioJpaController();

    private List<RecursoHumanoDatos> lisRHDatos;
    private List<TipoUsuario> listTipoUsuario;

    public List<RecursoHumanoDatos> findNombreCompleto(String nombre) {
        lisRHDatos = recursoHumanoDatosJpaController.findNombreUsuario(nombre);
        return lisRHDatos;
    }

    public List<TipoUsuario> listTipoUsuario() {
        return listTipoUsuario = tipoUsuarioJpaController.findTipoUsuarioEntities();
    }
    
    public void guardar(int row, int index) throws Exception{
        RecursoHumanoDatos rhDatos = lisRHDatos.get(row);
        rhDatos.setIdTipoUsuario(listTipoUsuario.get(index).getId());
        recursoHumanoDatosJpaController.edit(rhDatos);  
        System.out.println("guardr");
    }
}
