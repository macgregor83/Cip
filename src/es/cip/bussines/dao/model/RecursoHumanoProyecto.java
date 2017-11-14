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
public class RecursoHumanoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idproyecto;
    private Integer idRecursoHumanoDatos;

    @JoinColumn(name = "idProyecto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    @JoinColumn(name = "idRecursoHumanoDatos", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RecursoHumanoDatos RecursoHumanoDatos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Integer getIdRecursoHumanoDatos() {
        return idRecursoHumanoDatos;
    }

    public void setIdRecursoHumanoDatos(Integer idRecursoHumanoDatos) {
        this.idRecursoHumanoDatos = idRecursoHumanoDatos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public RecursoHumanoDatos getRecursoHumanoDatos() {
        return RecursoHumanoDatos;
    }

    public void setRecursoHumanoDatos(RecursoHumanoDatos RecursoHumanoDatos) {
        this.RecursoHumanoDatos = RecursoHumanoDatos;
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
        if (!(object instanceof RecursoHumanoProyecto)) {
            return false;
        }
        RecursoHumanoProyecto other = (RecursoHumanoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.RecursoHumanoProyecto[ id=" + id + " ]";
    }

}
