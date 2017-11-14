/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util.cte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iMac
 */
public class Convertir {

    public static byte[] convertDocToByteArray(String sourcePath) {

        byte[] byteArray = null;
        try {
            InputStream inputstream = new FileInputStream("capitulo7.pdf");

            String inputStreamToString = inputstream.toString();
            byteArray = inputStreamToString.getBytes();

            inputstream.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File Not found" + e);
//        } catch (IOException e) {
//            System.out.println("IO Ex" + e);
//        }
        } catch (IOException ex) {
            Logger.getLogger(Convertir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byteArray;

    }

    public static void convertByteArrayToDoc(byte[] bArray) {
        try {
            // Create file  
            FileWriter fstream = new FileWriter("out.pdf");
            BufferedWriter out = new BufferedWriter(fstream);
            for (Byte b : bArray) {
                out.write(b);
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
