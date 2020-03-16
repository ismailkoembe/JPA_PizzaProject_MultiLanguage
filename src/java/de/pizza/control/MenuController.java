/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.control;

import de.pizza.dao.DaoMenu;
import de.pizza.model.Pizza;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ikoembe
 */
@Named
@SessionScoped
public class MenuController implements Serializable{
    private List<Pizza> menu;
    
    @Inject
    private DaoMenu daoMenu;

    
    /**
     * Method shows all pizza item in index.xhtml page
     * if there is no pizza item in menu arraylist,
     * it calls DaoMenu getListPizza() method and
     * gets all list.
     */
    public MenuController() {
        menu = new ArrayList<>();
    }

     public List<Pizza> getMenu() {
        if (menu.size() <= 0) {
            menu = daoMenu.getListPizza();
        }
        return menu;
    }

    public void setMenu(List<Pizza> menu) {
        this.menu = menu;
    }

}

