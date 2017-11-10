/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip;

import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Usuario;
import es.cip.util.cte.Id;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author iMac
 */
public class prueba {

    Usuario u = new Usuario();

    public static void main(String[] args) {
//        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("CIPPU");
//        UsuarioJpaController oControl = new UsuarioJpaController(emf);
//        List<Usuario> lis = oControl.findUsuarioEntities();
//        for (Usuario li : lis) {
//            System.out.println("" + li.getNombre());
//        }
    
        
        for (int i = 0; i < 10000; i++) {
            System.out.println(Id.Id());
        }
    }
}
