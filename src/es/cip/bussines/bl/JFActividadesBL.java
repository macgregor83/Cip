/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ArchivoFaseJpaController;
import es.cip.bussines.dao.control.FaceJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.model.ArchivoFase;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.util.Convertir;
import es.cip.util.Cte;
import es.cip.util.Fecha;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iMac
 */
public class JFActividadesBL {

    private final Integer idUsuario;
    private Integer idFase;

    private ArchivoFase archivoFase =new ArchivoFase();
    
    private FaceJpaController faceJpaController = new FaceJpaController();
    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();
    private ArchivoFaseJpaController archivoFaseJpaController=new ArchivoFaseJpaController();
    
    private List<Face> listFase;
    private List<Proyecto> listProyecto;
    private List<ArchivoFase> listArchivoFase=new ArrayList<>();
    private Face fase;
    
    public JFActividadesBL(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Face> setListFase(String nombreProyecto) {
        listFase = faceJpaController.findProyecto(nombreProyecto, idUsuario, 4, 5);
        return listFase;
    }

    public List<Face> getListFase() {
        return listFase;
    }
    public void setIdFase(Integer selectedIndex) {
        this.idFase = listFase.get(selectedIndex).getId();
        this.fase=listFase.get(selectedIndex);
    }
    public void setListProyecto(String nombreProyecto) {
        listProyecto = proyectoJpaController.findProyecto(nombreProyecto, idUsuario, Cte.Estatus_Proyecto_Aprobado);

    }

    public void setListArchivoFase(String urlEntregable, String Descripcion) {
        try {
            this.archivoFase.setIdFace(this.idFase);
            this.archivoFase.setExtEntregable(Convertir.nombreArchivo(urlEntregable));
            this.archivoFase.setEntregable(Convertir.convertDocToByteArray(urlEntregable));
            this.archivoFase.setDescripcion(Descripcion);
            this.archivoFase.setFecha(Fecha.Date());
            
            this.listArchivoFase.add(archivoFase);
        } catch (Exception ex) {
            Logger.getLogger(JFActividadesBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
       
    }

    public List<ArchivoFase> getListArchivoFase() {
        return listArchivoFase;
    }

    public List<Proyecto> getListProyecto() {
        return listProyecto;
    }
    public void guardar(){
        for (ArchivoFase archivoFase1 : listArchivoFase) {
            archivoFaseJpaController.create(archivoFase);
        }
        fase.setIdEstatusFase(Cte.Estatus_Face_Iniciada);
        //faceJpaController
    }
            
}
