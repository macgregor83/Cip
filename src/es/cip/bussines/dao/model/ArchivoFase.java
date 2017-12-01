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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author iMac
 */
@Entity
public class ArchivoFase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Lob
    private byte[] Entregable;

    private String ExtEntregable;
    private String Descripcion;
    private int idFace;

    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @JoinColumn(name = "idFace", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Face face;

    public int getId() {
        return id;
    }

    public byte[] getEntregable() {
        return Entregable;
    }

    public void setEntregable(byte[] Entregable) {
        this.Entregable = Entregable;
    }

    public String getExtEntregable() {
        return ExtEntregable;
    }

    public void setExtEntregable(String ExtEntregable) {
        this.ExtEntregable = ExtEntregable;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdFace() {
        return idFace;
    }

    public void setIdFace(int idFace) {
        this.idFace = idFace;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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
        if (!(object instanceof ArchivoFase)) {
            return false;
        }
        ArchivoFase other = (ArchivoFase) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.ArchivoFase[ id=" + id + " ]";
    }

}
