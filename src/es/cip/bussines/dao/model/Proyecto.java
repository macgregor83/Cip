/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author iMac
 */
@Entity
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String NombreProyecto;
    private Integer idTipoProyecto;
    private Integer TiempoEstimado;
    private String ObjGeneral;
    private Integer idCriterioClasificacion;
    private Integer idProductoEsperado;
    private String Resumen;
    private Integer idEstatusProyecto;

    @JoinColumn(name = "idTipoProyecto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoProyecto tipoProyecto;

    @JoinColumn(name = "idCriterioClasificacion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CriterioClasificacion criterioClasificacion;

    @JoinColumn(name = "idProductoEsperado", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductoEsperado ProductoEsperado;

    @JoinColumn(name = "idEstatusProyecto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EstatusProyecto EstatusProyecto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return NombreProyecto;
    }

    public void setNombreProyecto(String NombreProyecto) {
        this.NombreProyecto = NombreProyecto;
    }

    public Integer getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(Integer idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public Integer getTiempoEstimado() {
        return TiempoEstimado;
    }

    public void setTiempoEstimado(Integer TiempoEstimado) {
        this.TiempoEstimado = TiempoEstimado;
    }

    public String getObjGeneral() {
        return ObjGeneral;
    }

    public void setObjGeneral(String ObjGeneral) {
        this.ObjGeneral = ObjGeneral;
    }

    public Integer getIdCriterioClasificacion() {
        return idCriterioClasificacion;
    }

    public void setIdCriterioClasificacion(Integer idCriterioClasificacion) {
        this.idCriterioClasificacion = idCriterioClasificacion;
    }

    public Integer getIdProductoEsperado() {
        return idProductoEsperado;
    }

    public void setIdProductoEsperado(Integer idProductoEsperado) {
        this.idProductoEsperado = idProductoEsperado;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String Resumen) {
        this.Resumen = Resumen;
    }

    public Integer getIdEstatusProyecto() {
        return idEstatusProyecto;
    }

    public void setIdEstatusProyecto(Integer idEstatusProyecto) {
        this.idEstatusProyecto = idEstatusProyecto;
    }

    public TipoProyecto getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public CriterioClasificacion getCriterioClasificacion() {
        return criterioClasificacion;
    }

    public void setCriterioClasificacion(CriterioClasificacion criterioClasificacion) {
        this.criterioClasificacion = criterioClasificacion;
    }

    public ProductoEsperado getProductoEsperado() {
        return ProductoEsperado;
    }

    public void setProductoEsperado(ProductoEsperado ProductoEsperado) {
        this.ProductoEsperado = ProductoEsperado;
    }

    public EstatusProyecto getEstatusProyecto() {
        return EstatusProyecto;
    }

    public void setEstatusProyecto(EstatusProyecto EstatusProyecto) {
        this.EstatusProyecto = EstatusProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.Proyecto[ id=" + id + " ]";
    }

}
