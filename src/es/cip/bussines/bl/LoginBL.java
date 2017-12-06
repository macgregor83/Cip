/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.LoginJpaController;
import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.model.Login;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.Usuario;
import java.util.List;

/**
 *
 * @author iMac
 */
public class LoginBL {

    private Usuario usuario;
    private Login login;
    private Integer idUsuario=0;
    private List<RecursoHumanoDatos> rhd;
    private Integer idTipoUsuario=0;

    public LoginBL() {
        usuario = new Usuario();
        login = new Login();
    }

    public boolean validarUsuario(String nickname, String pass) {
        LoginJpaController logjc = new LoginJpaController();
        List<Login> lis = logjc.findLogin(nickname, pass);
        System.out.println(lis.size());
        if (lis.size() > 0) {
            this.idUsuario = lis.get(0).getIdUsuario();
            RecursoHumanoDatosJpaController rhdjc=new RecursoHumanoDatosJpaController();
            List<RecursoHumanoDatos> list = rhdjc.findIdUsuario(idUsuario);
            idTipoUsuario=list.get(0).getIdTipoUsuario();
            usuario=list.get(0).getUsuario();
            return true;
        }
        return false;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }
        public Usuario getUsuario() {
        return usuario;
    }
    
}
