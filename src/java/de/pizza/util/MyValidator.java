/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.util;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author Trainer
 */
@FacesValidator(value = "myValidator")
public class MyValidator implements Validator {

    @Override
     public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        ResourceBundle bundle = ResourceBundle.getBundle("meldungen", fc.getViewRoot().getLocale());
        String key = "validatorMeldung";
        String msg = bundle.getString(key);
        if (uic.getId().equals("lastIn")||uic.getId().equals("street")||uic.getId().equals("city")||uic.getId().equals("email")) {
            System.out.println("Aus dem Validator::" + uic.getClientId());
            if (((String) o).equals("")) {
                FacesMessage fmsg = new FacesMessage(msg);
                throw new ValidatorException(fmsg);
        }
    }
    
     }
}
