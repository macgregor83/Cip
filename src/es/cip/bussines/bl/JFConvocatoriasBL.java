/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

//import es.cip.bussines.dao.control.ConvocatoriaJpaController;
import es.cip.bussines.dao.control.ConvocatoriaJpaController;
import es.cip.bussines.dao.model.Convocatoria;
import es.cip.util.Convertir;
import es.cip.view.JFConvocatorias;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import es.cip.bussines.dao.model.Convocatoria;
/**
 *
 * @author iMac
 */
public class JFConvocatoriasBL {

    private Convocatoria convocatoria = new Convocatoria();
    private ConvocatoriaJpaController convocatoriaJpaController = new ConvocatoriaJpaController();
    private String urlArchivo;

    public void guardar() throws Exception {
       
        convocatoria.setAchivoPDF(Convertir.convertDocToByteArray(urlArchivo));
        convocatoria.setExtAchivoPDF(Convertir.nombreArchivo(urlArchivo));
        convocatoriaJpaController.create(convocatoria);
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

}
