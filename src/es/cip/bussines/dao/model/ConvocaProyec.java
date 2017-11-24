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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer idProyecto;
    private Integer idConvocatoria;
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    private String ExtAchivoPDF;

    @JoinColumn(name = "idProyecto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    @JoinColumn(name = "idConvocatoria", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Convocatoria convocatoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
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

    public String getExtAchivoPDF() {
        return ExtAchivoPDF;
    }

    public void setExtAchivoPDF(String ExtAchivoPDF) {
        this.ExtAchivoPDF = ExtAchivoPDF;
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
        hash += (int) id;
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
