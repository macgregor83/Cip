/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Usuario;

/**
 *
 * @author iMac
 */
public class JFRegistroPersonaBL {

    private Usuario usuario = new Usuario();
    private UsuarioJpaController usuarioJpaController = new UsuarioJpaController();

    public boolean guardar() throws Exception  {
        usuarioJpaController.create(usuario);
        return false;
    }

    public boolean extNickname(String nickname) {
        
        if (usuarioJpaController.findNickname(nickname).size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
