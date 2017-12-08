/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author iMac
 */
public class Convertir {

    public static byte[] convertDocToByteArray(String sourcePath) throws FileNotFoundException {

        File file = new File(sourcePath);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                //   System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bos.toByteArray();

    }

    public static void convertByteArrayToDoc(byte[] bytes, String nombreArchivo) throws IOException {

        File someFile = new File(nombreArchivo);
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(bytes);        
        fos.flush();
        fos.close();
        Desktop.getDesktop().open(someFile);
    }

    public static String nombreArchivo(String urlArchivo) {

        char[] nombre = urlArchivo.toCharArray();
        int index=0;
        for (int i = 0; i < nombre.length; i++) {
            char string = nombre[i];
            if(string==92){
                index=i;
            }
        }
        return urlArchivo.substring(index+1);
       
    }

    public static void main(String[] args) {
        try {
            String urlArchivo = "D:\\Users\\iMac\\Documents\\maestria\\1re cuatrimestre\\Nueva carpeta\\tarea\\IMGOD_Atc1_S2.pdf";
            byte[] by = Convertir.convertDocToByteArray(urlArchivo);

            Convertir.convertByteArrayToDoc(by,"a.pdf");
            Convertir.nombreArchivo(urlArchivo);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
