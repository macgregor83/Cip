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
public class Face implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String NombreFase;
    private Integer Duracion;
    private Integer IniciaMes;
    private String Objetivo;
    private String Actividad;
    private Integer idMetodologia;
    private String Entregable;
    @JoinColumn(name = "idMetodologia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;    
    private Metodologia metodologia;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFase() {
        return NombreFase;
    }

    public void setNombreFase(String NombreFase) {
        this.NombreFase = NombreFase;
    }

    public Integer getDuracion() {
        return Duracion;
    }

    public void setDuracion(Integer Duracion) {
        this.Duracion = Duracion;
    }

    public Integer getIniciaMes() {
        return IniciaMes;
    }

    public void setIniciaMes(Integer IniciaMes) {
        this.IniciaMes = IniciaMes;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String Objetivo) {
        this.Objetivo = Objetivo;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public Integer getIdMetodologia() {
        return idMetodologia;
    }

    public void setIdMetodologia(Integer idMetodologia) {
        this.idMetodologia = idMetodologia;
    }

    public String getEntregable() {
        return Entregable;
    }

    public void setEntregable(String Entregable) {
        this.Entregable = Entregable;
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
        if (!(object instanceof Face)) {
            return false;
        }
        Face other = (Face) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.Face[ id=" + id + " ]";
    }
    
}
