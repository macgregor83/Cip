/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import java.util.Date;

/**
 *
 * @author iMac
 */
public class Id {

    public static final String Id(Integer idUsuario) {

        Date date = Fecha.Date();
        
        if (date == null) {
            date = new Date();
        }

        //   String id=(date.())+"";
        String id = (date.getYear()) + "";
        //id=id.substring(1, 3);
        id += date.getMonth() < 10 ? "0" + (date.getMonth()) : (date.getMonth()) + "";
        id += date.getDate() < 10 ? "0" + (date.getDate()) : (date.getDate()) + "";
        id += date.getHours() < 10 ? "0" + (date.getHours()) : (date.getHours()) + "";
        id += date.getMinutes() < 10 ? "0" + (date.getMinutes()) : (date.getMinutes()) + "";
        id += date.getSeconds() < 10 ? "0" + (date.getSeconds()) : (date.getSeconds()) + "";
        //id+=(date.getTime()<10?"0"+(date.getTime()):(date.getTime())+"").substring(0,4);
        if (idUsuario < 10) {
            id += "000000" + idUsuario;
        } else if (idUsuario < 100) {
            id += "00000" + idUsuario;
        } else if (idUsuario < 1000) {
            id += "0000" + idUsuario;
        } else if (idUsuario < 10000) {
            id += "0000" + idUsuario;
        } else if (idUsuario < 100000) {
            id += "000" + idUsuario;
        } else if (idUsuario < 1000000) {
            id += "00" + idUsuario;
        } else if (idUsuario < 10000000) {
            id += "0" + idUsuario;
        } else {
            id += idUsuario;
        }

        // return Float.parseFloat(id);
        return id;
    }
}
