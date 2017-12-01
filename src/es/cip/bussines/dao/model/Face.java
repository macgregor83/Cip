/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author iMac
 */
@Entity
public class Face implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String NombreFase;
    private Integer Duracion;
    private Integer IniciaMes;
    private String Objetivo;
    private String Actividad;
    private Integer idMetodologia;
    private Integer idEstatusFase;
    
    @Temporal(TemporalType.DATE)
    private Date FechaInicio;

    @Temporal(TemporalType.DATE)
    private Date FechaTermino;

    @JoinColumn(name = "idMetodologia", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Metodologia metodologia;
    
     @JoinColumn(name = "idEstatusFase", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EstatusFase estatusFase;

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

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(Date FechaTermino) {
        this.FechaTermino = FechaTermino;
    }

    public EstatusFase getEstatusFase() {
        return estatusFase;
    }

    public void setEstatusFase(EstatusFase estatusFase) {
        this.estatusFase = estatusFase;
    }

    public Integer getIdEstatusFase() {
        return idEstatusFase;
    }

    public void setIdEstatusFase(Integer idEstatusFase) {
        this.idEstatusFase = idEstatusFase;
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
