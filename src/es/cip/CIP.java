/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip;

//import es.cip.view.MenuPrincipal;

import es.cip.view.MenuPrincipal;


/**
 *
 * @author iMac
 */
public class CIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuPrincipal p=new MenuPrincipal();
        p.setVisible(true);
        p.loginVisible();
        p.isFocusableWindow();
    }
    
}
