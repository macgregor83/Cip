/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.CampusJpaController;
import es.cip.bussines.dao.control.CarreraJpaController;
import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.control.TipoUsuarioJpaController;
import es.cip.bussines.dao.control.UniversidadJpaController;
import es.cip.bussines.dao.control.UsuarioJpaController;
import es.cip.bussines.dao.model.Campus;
import es.cip.bussines.dao.model.Carrera;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.TipoUsuario;
import es.cip.bussines.dao.model.Universidad;
import es.cip.bussines.dao.model.Usuario;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JFDatosAcademicosBL {

    private String nickname;

    private Usuario usuario = new Usuario();
    private TipoUsuario tipoUsuario = new TipoUsuario();
    private Universidad universidad = new Universidad();
    private Campus campus = new Campus();
    private Carrera carrera = new Carrera();
    private RecursoHumanoDatos recursoHumanoDatos = new RecursoHumanoDatos();

    private UsuarioJpaController usuarioJpaController = new UsuarioJpaController();
    private TipoUsuarioJpaController tipoUsuarioJpaController = new TipoUsuarioJpaController();
    private UniversidadJpaController universidadJpaController = new UniversidadJpaController();
    private CarreraJpaController carreraJpaController = new CarreraJpaController();
    private CampusJpaController campusJpaController = new CampusJpaController();
    private RecursoHumanoDatosJpaController recursoHumanoDatosJpaController = new RecursoHumanoDatosJpaController();
    private List<TipoUsuario> listTipoUsuario;
    private List<Universidad> listUniversidad;
    private List<Campus> listCampus;
    private List<Carrera> listCarrera;
    private List<Usuario> lisUsuario;

    public void guardarUni(String uni){
       
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
        List<Usuario> lis = usuarioJpaController.findNickname(nickname);
        if (lis.size() == 0) {
            this.usuario = lis.get(0);
        }
    }

    public List<TipoUsuario> getListTipoUsuario(String tipo) {
        listTipoUsuario=tipoUsuarioJpaController.findTipoUsuario(tipo);
        return listTipoUsuario;
    }

    public List<Universidad> getListUniversidad(String uni) {
        listUniversidad=universidadJpaController.findUniversidad(uni);
        return listUniversidad;
    }

    public List<Campus> getListCampus(String campus) {
        listCampus=campusJpaController.findCampus(campus);
        return listCampus;
    }

    public List<Carrera> getListCarrera(String carr) {
        listCarrera=carreraJpaController.findNombreCarrera(carr);
        return listCarrera;
    }

    public boolean extisteNoControl(String noControl) {
        if (recursoHumanoDatosJpaController.findNoControl(noControl).size() == 0) {
            return false;
        } else {
            return true;
        }
    }
        public List<Usuario> findNombreCompleto(String nombre) {
        lisUsuario=usuarioJpaController.findNombreCompleto(nombre);
        return lisUsuario;
//            System.out.println(lis.size());
//        if (lis.size() == 0) {
//            this.usuario = lis.get(0);
//            System.out.println(lis.get(0).getNombre());
//        }
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public Campus getCampus() {
        return campus;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public RecursoHumanoDatos getRecursoHumanoDatos() {
        return recursoHumanoDatos;
    }

    public void guardar(int jComboBoxNombre, int jComboBoxTipoDA, int jComboBoxUniversidad, int jComboBoxCampus, int jComboBoxCarrera) {
        usuario=lisUsuario.get(jComboBoxNombre-1);
        tipoUsuario=listTipoUsuario.get(jComboBoxTipoDA);
        
    }
        
}
