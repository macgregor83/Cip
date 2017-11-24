/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void convertByteArrayToDoc(byte[] bytes) throws IOException {
        File someFile = new File("java2.pdf");
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(bytes);
        fos.flush();
        fos.close();

    }

    public static void main(String[] args) {
        try {
            byte[] by = Convertir.convertDocToByteArray("D:\\Users\\iMac\\Documents\\maestria\\1re cuatrimestre\\Nueva carpeta\\tarea\\IMGOD_Atc1_S2.pdf");

            Convertir.convertByteArrayToDoc(by);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
