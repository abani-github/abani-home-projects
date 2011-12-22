/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.domains;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author CHIKI
 */
@Named(value = "userBean")
@RequestScoped
public class UserInfo {
    private String username;
    private String password;
    private boolean rememberMeChecked;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMeChecked() {
        return rememberMeChecked;
    }

    public UserInfo() {
    }

    public void setRememberMeChecked(boolean rememberMeChecked) {
        this.rememberMeChecked = rememberMeChecked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ username ").append(username).
                append(" remember me ").append(rememberMeChecked)
                .append(" ]");
        return sb.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String login(){
        System.out.println(toString());
        try {
            this.getRequest().login(username, password);
        } catch (ServletException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "myhome";
    }
    private HttpServletRequest getRequest(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        return (HttpServletRequest)ec.getRequest();
    }
}
