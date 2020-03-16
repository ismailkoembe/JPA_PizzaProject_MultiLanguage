/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ikoembe
 */
@Entity
@Table(name = "pizza")
@NamedQueries({@NamedQuery(name = "Pizza.SelectAll", query = "SELECT p FROM Pizza p")})
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizzaId;
    private String pType;
    private double price;
    private int number;


    public Pizza() {
    
    }

    public Pizza(Integer pizzaId) {
        pizzaId = pizzaId;
    }

    public Pizza(Integer pizzaId, String pType, double price) {
        this.pizzaId = pizzaId;
        this.pType = pType;
        this.price = price;
    }

    public Pizza(Integer pizzaId, String pType, double price, int number) {
        this.pizzaId = pizzaId;
        this.pType = pType;
        this.price = price;
        this.number = number;
    }

    public Pizza(String pType, double price, int number) {
        this.pType = pType;
        this.price = price;
        this.number = number;
    }

    

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    
    

}
