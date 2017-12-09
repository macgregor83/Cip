/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.LoginJpaController;
import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Usuario;
import es.cip.bussines.dao.model.Login;
import es.cip.util.ValidCampos;

/**
 *
 * @author iMac
 */
public class JFRegistroPersonaBL {

    private Usuario usuario = new Usuario();
    private Login login=new Login();
    
    private UsuarioJpaController usuarioJpaController = new UsuarioJpaController();
    private LoginJpaController loginJpaController = new LoginJpaController();

    public boolean guardar() throws Exception  {
        usuarioJpaController.create(usuario);
        login.setIdUsuario(usuario.getId());
        loginJpaController.create(login);
        return false;
    }

    public boolean extNickname(String nickname) {
        
        if (usuarioJpaController.findNickname(nickname).size() == 0 && ValidCampos.sonLetrasNumeroSinEspacios(nickname)) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
