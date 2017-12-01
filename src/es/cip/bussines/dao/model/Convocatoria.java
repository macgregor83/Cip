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
public class Convocatoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Convocatoria;
    
    @Lob
    private byte[] AchivoPDF;
    
    private String url;
    
    @Temporal(TemporalType.DATE)
    private Date FechaAperura;
    
    @Temporal(TemporalType.DATE)
    private Date FechaCierre;
    
    private String ExtAchivoPDF;
      

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConvocatoria() {
        return Convocatoria;
    }

    public void setConvocatoria(String Convocatoria) {
        this.Convocatoria = Convocatoria;
    }

    public byte[] getAchivoPDF() {
        return AchivoPDF;
    }

    public void setAchivoPDF(byte[] AchivoPDF) {
        this.AchivoPDF = AchivoPDF;
    }

 

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaAperura() {
        return FechaAperura;
    }

    public void setFechaAperura(Date FechaAperura) {
        this.FechaAperura = FechaAperura;
    }

    public Date getFechaCierre() {
        return FechaCierre;
    }

    public void setFechaCierre(Date FechaCierre) {
        this.FechaCierre = FechaCierre;
    }

    public String getExtAchivoPDF() {
        return ExtAchivoPDF;
    }

    public void setExtAchivoPDF(String ExtAchivoPDF) {
        this.ExtAchivoPDF = ExtAchivoPDF;
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
        if (!(object instanceof Convocatoria)) {
            return false;
        }
        Convocatoria other = (Convocatoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cip.bussines.dao.model.Convocatoria[ id=" + id + " ]";
    }

}
