/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ikoembe
 */
@Entity
@Table(name = "selection")
@NamedQueries({@NamedQuery(name = "Selection.SelectAll", query = "SELECT s FROM Selection s")})
public class Selection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int selectionId;
    private int pizzaId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Ordered ordered;

    public Selection() {
    }

    public Selection(Ordered ordered, int selectionId, int pizzaId, Date date) {
        this.ordered = ordered;
        this.selectionId = selectionId;
        this.pizzaId = pizzaId;
        this.date = date;
    }

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }

    public int getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(int selectionId) {
        this.selectionId = selectionId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Selection{" + "ordered=" + ordered + ", selectionId=" + selectionId + ", pizzaId=" + pizzaId + ", date=" + date + '}';
    }

}
