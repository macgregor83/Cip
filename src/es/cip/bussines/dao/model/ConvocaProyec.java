/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author iMac
 */
@Entity
public class ConvocaProyec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String idProyecto;
    private Integer idConvocatoria;
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @JoinColumn(name = "idProyecto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    @JoinColumn(name = "idConvocatoria", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Convocatoria convocatoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Integer idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
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
        if (!(object instanceof ConvocaProyec)) {
            return false;
        }
        ConvocaProyec other = (ConvocaProyec) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.ConvocaProyec[ id=" + id + " ]";
    }

}
