/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abani.ejbs;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author CHIKI
 */
@Stateless
@LocalBean
public class HalloBean {
    public String greet (){
        System.out.println("invking greet methd");
        return "Hallo EJB Container";
    }
}
