/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author iMac
 */
public class Archivo {

    public static final String urlArchivo() {
        String aux = "";
        String texto = "";
        String ruta = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf", "pdf");
            file.setFileFilter(filter);
            file.showOpenDialog(file);
            /**
             * abrimos el archivo seleccionado
             */
            File abre = file.getSelectedFile();

            ruta = abre.getPath();

            byte[] by = Convertir.convertDocToByteArray(ruta);

            //Convertir.convertByteArrayToDoc(by);
            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,  ""
                    + "No se ha encontrado el archivo\n"+ex ,
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return ruta;
    }
}
