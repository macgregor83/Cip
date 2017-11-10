/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util.cte;

import java.util.Date;

/**
 *
 * @author iMac
 */
public class Id {
    public static final long Id() {
              
        Date date=new Date();
        if (date==null) {
            date=new Date();
        }

     //   String id=(date.())+"";
        String id=(date.getYear())+"";
        id=id.substring(1, 3);
        id+=date.getMonth()<10?"0"+(date.getMonth()):(date.getMonth())+"";
        id+=date.getDate()<10?"0"+(date.getDate()):(date.getDate())+"";
        id+=date.getHours()<10?"0"+(date.getHours()):(date.getHours())+"";
        id+=date.getMinutes()<10?"0"+(date.getMinutes()):(date.getMinutes())+"";
//        id+=date.getSeconds()<10?"0"+(date.getSeconds()):(date.getSeconds())+"";
        //id+=(date.getTime()<10?"0"+(date.getTime()):(date.getTime())+"").substring(0,2);
        
        return Long.parseLong(id);
    }
}
