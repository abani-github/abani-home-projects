/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.beans;

import com.jsfweb.ejbs.UserinfotableFacade;
import com.jsfweb.entities.Userinfotable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CHIKI
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
    private @EJB UserinfotableFacade userFaced;
    private Userinfotable userInfo;

    public Userinfotable getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Userinfotable userInfo) {
        this.userInfo = userInfo;
    }
    
    
    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }
    
    @PostConstruct
    public void postLogin(){
        String user = getPrincipal().getName();
        LOGGER.log(Level.INFO, "user is {0} ", user);
        Userinfotable ui = userFaced.find(user);
        LOGGER.log(Level.INFO, "ui is {0} ", ui.toString());
        setUserInfo(ui);
    }
    private HttpServletRequest getRequest(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        return (HttpServletRequest)ec.getRequest();
    }
    private Principal getPrincipal(){
        return getRequest().getUserPrincipal();
    }
    public String logout(){
        try {
            getRequest().logout();
            getRequest().getSession().invalidate();
        } catch (ServletException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return "index";
    }
}
