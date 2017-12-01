/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

//import com.sun.org.apache.bcel.internal.generic.AALOAD;
import es.cip.bussines.dao.control.AreaColaboracionJpaController;
import es.cip.bussines.dao.control.CriterioClasificacionJpaController;
import es.cip.bussines.dao.control.ObjetivoEspecificoJpaController;
import es.cip.bussines.dao.control.ProductoEsperadoJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.control.RecursosMaterialesJpaController;
import es.cip.bussines.dao.control.TipoProyectoJpaController;
import es.cip.bussines.dao.control.RecursoHumanoDatosJpaController;
import es.cip.bussines.dao.control.RecursoHumanoProyectoJpaController;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
import es.cip.bussines.dao.model.AreaColaboracion;
import es.cip.bussines.dao.model.CriterioClasificacion;
import es.cip.bussines.dao.model.ObjetivoEspecifico;
import es.cip.bussines.dao.model.ProductoEsperado;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
import es.cip.bussines.dao.model.RecursosMateriales;
import es.cip.bussines.dao.model.TipoProyecto;
import es.cip.util.Cte;
import es.cip.util.Fecha;
import es.cip.util.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author iMac
 */
public class JRegistroProyectoBL {

    private Integer idUsuario;

    private TipoProyecto tipoProyecto = new TipoProyecto();
    private CriterioClasificacion criterioClasificacion = new CriterioClasificacion();
    private ProductoEsperado productoEsperado = new ProductoEsperado();
    private RecursosMateriales recursosMateriales = new RecursosMateriales();
    private ObjetivoEspecifico objetivoEspecifico = new ObjetivoEspecifico();
    private AreaColaboracion areaColaboracion = new AreaColaboracion();
    private RecursoHumanoDatos recursoHumanoDatos = new RecursoHumanoDatos();
    private RecursoHumanoProyecto recursoHumanoProyecto = new RecursoHumanoProyecto();

    private Proyecto proyecto = new Proyecto();

    private TipoProyectoJpaController tipoProyectoJpaController = new TipoProyectoJpaController();
    private CriterioClasificacionJpaController criterioClasificacionJpaController = new CriterioClasificacionJpaController();
    private ProductoEsperadoJpaController productoEsperadoJpaController = new ProductoEsperadoJpaController();
    private RecursosMaterialesJpaController recursosMaterialesJpaController = new RecursosMaterialesJpaController();
    private ObjetivoEspecificoJpaController objetivoEspecificoJpaController = new ObjetivoEspecificoJpaController();
    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();
    private AreaColaboracionJpaController areaColaboracionJpaController = new AreaColaboracionJpaController();
    private RecursoHumanoDatosJpaController recursoHumanoDatosJpaController = new RecursoHumanoDatosJpaController();
    private RecursoHumanoProyectoJpaController recursoHumanoProyectoJpaController = new RecursoHumanoProyectoJpaController();

    private List<TipoProyecto> lisTipoProyecto = tipoProyectoJpaController.findTipoProyectoEntities();
    private List<CriterioClasificacion> lisCriterioClasificacion = criterioClasificacionJpaController.findCriterioClasificacionEntities();
    private List<ProductoEsperado> lisProductoEsperado = productoEsperadoJpaController.findProductoEsperadoEntities();

    private List<ObjetivoEspecifico> lisObjetivoEspecifico = new ArrayList<>();
    private List<AreaColaboracion> lisAreaColaboracion = new ArrayList<>();
    private List<RecursosMateriales> lisRecursosMateriales = new ArrayList<>();
    private String id;

    public JRegistroProyectoBL() {

    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        id = Id.Id(idUsuario);
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getId() {
        return id;
    }

    public List<TipoProyecto> getLisTipoProyecto() {
        return lisTipoProyecto;
    }

    public List<CriterioClasificacion> getLisCriterioClasificacion() {
        return lisCriterioClasificacion;
    }

    public List<ProductoEsperado> getLisProductoEsperado() {
        return lisProductoEsperado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = new ObjetivoEspecifico();
        this.objetivoEspecifico.setObjEspecifico(objetivoEspecifico);
        this.lisObjetivoEspecifico.add(this.objetivoEspecifico);
    }

    public void setAreaColaboracion(String areaColaboracion) {
        this.areaColaboracion = new AreaColaboracion();
        this.areaColaboracion.setAreaColaboracion(areaColaboracion);;
        this.lisAreaColaboracion.add(this.areaColaboracion);
    }

    public void setRecursosMateriales(String recursosMateriales) {
        this.recursosMateriales = new RecursosMateriales();
        this.recursosMateriales.setRecursosMateriales(recursosMateriales);;
        this.lisRecursosMateriales.add(this.recursosMateriales);
    }

    public List<ObjetivoEspecifico> getLisObjetivoEspecifico() {
        return lisObjetivoEspecifico;
    }

    public List<AreaColaboracion> getLisAreaColaboracion() {
        return lisAreaColaboracion;
    }

    public List<RecursosMateriales> getLisRecursosMateriales() {
        return lisRecursosMateriales;
    }

    public boolean guardar(int jComboBoxTipoProyecto, int jComboBoxCriterioClasificacion, int jComboBoxPrototipo) {
        List<RecursoHumanoDatos> lis = recursoHumanoDatosJpaController.findIdUsuario(idUsuario);
        if (lis.size() > 0) {
            
            proyecto.setId(id);
            proyecto.setIdTipoProyecto(lisTipoProyecto.get(jComboBoxTipoProyecto).getId());
            proyecto.setIdCriterioClasificacion(lisCriterioClasificacion.get(jComboBoxCriterioClasificacion).getId());
            proyecto.setIdProductoEsperado(lisProductoEsperado.get(jComboBoxPrototipo).getId());
            proyecto.setFechaInicio(Fecha.Date());
            proyecto.setIdEstatusProyecto(Cte.Estatus_Registro_Proyecto_F1);
            proyectoJpaController.create(proyecto);
            for (ObjetivoEspecifico objetivoEspecifico : lisObjetivoEspecifico) {
                objetivoEspecifico.setIdProyecto(id);
                objetivoEspecificoJpaController.create(objetivoEspecifico);
            }
            for (AreaColaboracion areaColaboracion : lisAreaColaboracion) {
                areaColaboracion.setIdProyecto(id);
                areaColaboracionJpaController.create(areaColaboracion);
            }
            for (RecursosMateriales recursosMateriales : lisRecursosMateriales) {
                recursosMateriales.setIdProyecto(id);
                recursosMaterialesJpaController.create(recursosMateriales);
            }
            recursoHumanoDatos = lis.get(0);
            recursoHumanoProyecto.setIdRecursoHumanoDatos(recursoHumanoDatos.getId());
            recursoHumanoProyecto.setIdproyecto(id);
            recursoHumanoProyectoJpaController.create(recursoHumanoProyecto);
            return true;
        }else{
            return false;
        }
            
    }
}
