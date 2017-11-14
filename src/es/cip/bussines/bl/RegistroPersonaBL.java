/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.CampusJpaController;
import es.cip.bussines.dao.control.CarreraJpaController;
import es.cip.bussines.dao.control.LoginJpaController;
import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.control.TipoUsuarioJpaController;
import es.cip.bussines.dao.control.UniversidadJpaController;
import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Campus;
import es.cip.bussines.dao.model.Carrera;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.Usuario;
import es.cip.bussines.dao.model.Login;
import es.cip.bussines.dao.model.TipoUsuario;
import es.cip.bussines.dao.model.Universidad;
import es.cip.prueba;
import javafx.scene.Camera;
import javax.persistence.Id;

/**
 *
 * @author iMac
 */
public class RegistroPersonaBL {

    private RecursoHumanoDatos recursoHumanoDatos;
    private Usuario usuario;
    private Login login;
    private Universidad universidad;
    private TipoUsuario tipoUsuario;
    private Campus campus;
    private Carrera carrera;

    public RegistroPersonaBL() {
        recursoHumanoDatos = new RecursoHumanoDatos();
        usuario = new Usuario();
        login = new Login();
        universidad = new Universidad();
        tipoUsuario = new TipoUsuario();
        campus = new Campus();
        carrera = new Carrera();
    }


    public void guardarUsuario() {
        RecursoHumanoDatosJpaController rhdjc = new RecursoHumanoDatosJpaController();
        UsuarioJpaController usujc = new UsuarioJpaController();
        LoginJpaController logjc = new LoginJpaController();
        UniversidadJpaController unijc1 = new UniversidadJpaController();
        TipoUsuarioJpaController tuujc =new TipoUsuarioJpaController();
        CampusJpaController camjc=new CampusJpaController();
        CarreraJpaController carrjc=new CarreraJpaController();
        
        Integer id = es.cip.util.Id.Id();       
        Integer id2 = (int) (Integer)id;
        
        usuario.setId(id);
        login.setId(id);
        login.setIdUsuario(usuario.getId());
        universidad.setId(id);
        tipoUsuario.setId(id);
        campus.setId(id);
        carrera.setId(id);
        
        recursoHumanoDatos.setId(id);
        recursoHumanoDatos.setIdUsuario(usuario.getId());
        recursoHumanoDatos.setIdUniversidad(id2);
        recursoHumanoDatos.setIdCampus(id2);
        recursoHumanoDatos.setIdCarrera(id2);
        recursoHumanoDatos.setIdTipoUsuario(id2);
       
        
        usujc.create(usuario);        
        logjc.create(login);
        unijc1.create(universidad);
        tuujc.create(tipoUsuario);
        camjc.create(campus);
        carrjc.create(carrera);
        rhdjc.create(recursoHumanoDatos);  
        
    }

    public RecursoHumanoDatos getRecursoHumanoDatos() {
        return recursoHumanoDatos;
    }

    public void setRecursoHumanoDatos(RecursoHumanoDatos recursoHumanoDatos) {
        this.recursoHumanoDatos = recursoHumanoDatos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public static void main(String[] args) {
        RegistroPersonaBL bL = new RegistroPersonaBL();
        //bL.guardarUsuario("ameya", "oviedo", "dorantes", "calle", "Colonia", "municipio", " numInt", " numExt", " telefono", " correoE", " nickname", " password");
    }
}
//    public void guardarUsuario(String nombreUsu, String apellidoPaterno, String apellidoMaterno, String calle, String Colonia, String municipioUsu, String numInt, String numExt, String telefono, String correoE, String nickname, String password, String nombreUni, String direccionUni){
////        recursoHumanoDatos=new RecursoHumanoDatos();
////        usuario=new Usuario();
////        login=new Login();
////        universidad=new Universidad();
//        
//        RecursoHumanoDatosJpaController rhdjc=new RecursoHumanoDatosJpaController();
//        UsuarioJpaController usujc=new UsuarioJpaController();
//        LoginJpaController logjc=new LoginJpaController();
//        UniversidadJpaController unijc1=new UniversidadJpaController();
//        
//        
//        Integer id = es.cip.util.cte.Id.Id();
//        // Integer id = 20;
//        System.out.println("id\t"+id);
//        Integer id2 = (int) (Integer)id;
//        System.out.println("id2\t"+id2);
//        usuario.setId(id);
//        usuario.setNombre(nombreUsu);
//        usuario.setApellidoPaterno(apellidoPaterno);
//        usuario.setApellidoMaterno(apellidoMaterno);
//        usuario.setCalle(calle);
//        usuario.setColonia(Colonia);
//        usuario.setMunicipio(municipioUsu);
//        usuario.setNumInt(numInt);
//        usuario.setNumExt(numExt);
//        usuario.setTelefono(telefono);
//        usuario.setCorreoElectronico(correoE);
//        
//        login.setId(id);
//        login.setIdUsuario(id2);
//        login.setNickname(nickname);
//        login.setPassword(password);
//        login.setIntentos(0);
//        
//        universidad.setId(id);
//        universidad.setNombre(nombreUni);
//        universidad.setDireccion(direccionUni);
//        universidad.setMunicipio(municipioUni);
//        
//        usujc.create(usuario);
//        logjc.create(login);
//        
//    }