/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.LoginJpaController;
import es.cip.bussines.dao.model.Login;
import es.cip.bussines.dao.model.Usuario;
import java.util.List;

/**
 *
 * @author iMac
 */
public class LoginBL {

    private Usuario usuario;
    private Login login;

    public LoginBL() {
        usuario = new Usuario();
        login = new Login();
    }
    public boolean validarUsuario(String nickname, String pass ){
        
        LoginJpaController logjc = new LoginJpaController();
        List<Login> lis = logjc.findLoginEntities(nickname);
        if(lis.size()>0){
            if(lis.get(0).getPassword().equalsIgnoreCase(pass)){
              return true;  
            }
        }            
        return false;        
    }
    
    
}
