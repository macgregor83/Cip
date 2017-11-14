/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;

/**
 *
 * @author iMac
 */
public class ValidCampos {

    //Devuelve true si la cadena que llega es un numero decimal, false en caso contrario
    public static final boolean esDecimal(String cad) {
        try {
            Double.parseDouble(cad.trim());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static final boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena.trim());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static final boolean esMayorIgual(Date fecha1, Date fecha2) {
        if (fecha1.getYear() <= fecha2.getYear()) {
            if (fecha1.getMonth() <= fecha2.getMonth() && fecha1.getYear() == fecha2.getYear()) {
                if (fecha1.getDate() <= fecha2.getDate() && fecha1.getMonth() == fecha2.getMonth()) {
                    return true;
                } else if (fecha1.getDate() > fecha2.getDate() && fecha1.getMonth() == fecha2.getMonth()) {
                    return false;
                } else {
                    return true;
                }
            } else if (fecha1.getMonth() > fecha2.getMonth() && fecha1.getYear() == fecha2.getYear()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public static final boolean esSoloLetras(String entrada) {
        //String entrada = " No para mi?? que triste :( por que??";
        Pattern patron = Pattern.compile("[^A-Za-z ]");
        Matcher encaja = patron.matcher(entrada);

        if (!encaja.find()) //System.out.println("solo tiene letras y espacio!");
        {
            return true;
        } else //System.out.println("tiene otra cosa");
        {
            return false;
        }

    }

    public static final boolean esMoneda(String entrada) {
        //String entrada = " No para mi?? que triste :( por que??";
        Pattern patron = Pattern.compile("[^0-9.0-90-9 ]");
        Matcher encaja = patron.matcher(entrada);

        if (!encaja.find()) //System.out.println("solo tiene letras y espacio!");
        {
            return true;
        } else //System.out.println("tiene otra cosa");
        {
            return false;
        }

    }

    public static final boolean esIP(String entrada) {
        //String entrada = " No para mi?? que triste :( por que??";
        Pattern patron = Pattern.compile("([1][0])\\."
                + "([2][5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher encaja = patron.matcher(entrada);
        return encaja.matches();
        /*
        if(!encaja.find())
            //System.out.println("solo tiene letras y espacio!");
            return true;
        else
            //System.out.println("tiene otra cosa");
            return false;
         */
    }

    public static final boolean esMAC(String entrada) {
        //String entrada = " No para mi?? que triste :( por que??";
        Pattern patron = Pattern.compile("^([0-9A-Fa-f]{2}[\\\\.:-]){5}([0-9A-Fa-f]{2})$");
        Matcher encaja = patron.matcher(entrada);
        return encaja.matches();

    }

    public static final boolean mayorIgualFechas(Date fechaDate1, Date fechaDate2) {
        System.out.println("Parametro Date Fecha 1 = " + fechaDate1 + "\n"
                + "Parametro Date fechaActual = " + fechaDate2 + "\n");

        if (fechaDate1.getYear() > fechaDate2.getYear()) {
            return false;
        } else if (fechaDate1.getYear() < fechaDate2.getYear()) {
            return true;
        } else if (fechaDate1.getMonth() > fechaDate2.getMonth()) {
            return false;
        } else if (fechaDate1.getMonth() < fechaDate2.getMonth()) {
            return true;
        } else if (fechaDate1.getDate() > fechaDate2.getDate()) {
            return false;
        } else if (fechaDate1.getDate() <= fechaDate2.getDate()) {
            return true;
        }
        return false;
    }

    /*Método que tiene la función de validar el curp*/
    public static final boolean validarRPE(String rpe) {
        rpe = rpe.toUpperCase().trim();
        return rpe.matches("[9]{1}[A-Za-z0-9]{4}|[A-Za-z]{1}[A-Za-z0-9]{4}");
    }//Cierra método validarCurp

    /*Método que tiene la función de validar el email*/
    public static final boolean validarEmail(String email) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        return pattern.matcher(email).find();
    }

    /**
     *
     * @param archivo
     * @return
     */
    public static final boolean validarArchivo(String archivo, String[] extensionesPermitidas) {
        //String[] extensionesPermitidas={".pdf","doc","docx"};
        //recupero la extensión de este nombre de archivo
        String extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase();
               
        for (int i = 0; i < extensionesPermitidas.length; i++) {
            if (extensionesPermitidas[i].equals(extension)) {
                return true;
            }
        }
        return false;
    }
}