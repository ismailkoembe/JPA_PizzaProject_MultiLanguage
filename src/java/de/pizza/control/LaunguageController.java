/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.control;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ikoembe
 */

@Named
@SessionScoped
public class LaunguageController implements Serializable{   
   private Locale locale;

    public LaunguageController() {
        locale=new Locale("de");
    }
   
   

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    //-------------- my method


     public void switchLanguage(String lang){
        locale=new Locale(lang);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}

