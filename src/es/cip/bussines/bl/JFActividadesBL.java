/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.bl;

import es.cip.bussines.dao.control.ArchivoFaseJpaController;
import es.cip.bussines.dao.control.FaceJpaController;
import es.cip.bussines.dao.control.ObservacionesProyectoJpaController;
import es.cip.bussines.dao.control.ProyectoJpaController;
import es.cip.bussines.dao.model.ArchivoFase;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.ObservacionesProyecto;
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

    private ArchivoFase archivoFase = new ArchivoFase();

    private FaceJpaController faceJpaController = new FaceJpaController();
    private ProyectoJpaController proyectoJpaController = new ProyectoJpaController();
    private ArchivoFaseJpaController archivoFaseJpaController = new ArchivoFaseJpaController();
    private ObservacionesProyectoJpaController observacionesProyectoJpaController = new ObservacionesProyectoJpaController();

    private List<Face> listFase;
    private List<Proyecto> listProyecto;
    private List<ArchivoFase> listArchivoFase = new ArrayList<>();
    private Face fase;
    private String idProyecto;
    private List<ObservacionesProyecto> listObsProy;

    public JFActividadesBL(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ObservacionesProyecto> setListObsProy() {
        listObsProy = observacionesProyectoJpaController.findProyecto(idProyecto);
        return listObsProy;
    }

    public List<Face> setListFase(String nombreProyecto) {
        listFase = faceJpaController.findProyecto(nombreProyecto, idUsuario, 4, 5, Cte.Estatus_Face_registro);
        return listFase;
    }

    public List<Face> getListFase() {
        return listFase;
    }

    public void setIdFase(Integer selectedIndex) {
        if (listFase.size() > 0) {
            this.idFase = listFase.get(selectedIndex).getId();
            this.idProyecto = listFase.get(selectedIndex).getMetodologia().getIdProyecto();
            this.fase = listFase.get(selectedIndex);
        }
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
            archivoFase = new ArchivoFase();
        } catch (Exception ex) {
            Logger.getLogger(JFActividadesBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void setListArchivoFase() {
        //listArchivoFase=archivoFaseJpaController.findProyecto(idProyecto, idUsuario);
        listArchivoFase = archivoFaseJpaController.findFase(idFase);
    }

    public List<ArchivoFase> getListArchivoFase() {

        return listArchivoFase;
    }

    public List<Proyecto> getListProyecto() {
        return listProyecto;
    }

    public void guardar() {
        try {
            for (ArchivoFase archivoFase1 : listArchivoFase) {
                System.out.println(archivoFaseJpaController.findArchivoFase(archivoFase1.getId()));
                if (archivoFaseJpaController.findArchivoFase(archivoFase1.getId()) == null) {
                    archivoFaseJpaController.create(archivoFase1);
                }
            }
            fase.setIdEstatusFase(Cte.Estatus_Face_Termino);
            faceJpaController.edit(fase);
        } catch (Exception ex) {
            Logger.getLogger(JFActividadesBL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
