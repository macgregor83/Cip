/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip;

import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.control.RecursosMaterialesJpaController;
import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.bussines.dao.model.RecursosMateriales;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.Convertir;
import es.cip.util.FormatoFechas;
import es.cip.util.Id;
import es.cip.util.ValidCampos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author iMac
 */
public class prueba {

    

    Usuario u = new Usuario();

    public static void main(String[] args) {
//        RecursoHumanoProyectoJpaController rhpjc=new RecursoHumanoProyectoJpaController();
//        System.out.println(rhpjc.findProyecto("", "ivan", 1));
//        for (RecursoHumanoProyecto recursoHumanoProyecto : rhpjc.findProyecto("", "ivan", 1)) {
//            System.out.println(recursoHumanoProyecto.getProyecto().getNombreProyecto());
//            System.out.println(recursoHumanoProyecto.getRecursoHumanoDatos().getUsuario().getNombre());
//            //System.out.println(recursoHumanoProyecto.getProyectoId());
//        }

//        java.util.Date ahora = new java.util.Date();
//        java.util.Date d;
//        d =  FormatoFechas.sumarFechasDias( ahora, 7*10);
//        System.out.println(d);
 String cadena="";
        for (int i = 0; i < 10; i++) {
            cadena=i+"\n\n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n\n"+cadena;
        }
        System.out.println(cadena);
    }
}
