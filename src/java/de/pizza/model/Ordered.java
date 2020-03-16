/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Trainer
 */
@Entity
@Table(name = "ordered")
@NamedQueries({
@NamedQuery(name = "Ordered.SelectAll", query = "SELECT o FROM Ordered o")})
public class Ordered implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_Id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @OneToOne
    private Customer customer;
    @OneToMany
    private List<Pizza> selection;
    private String sess_Id;
   
   

    public Ordered() {
        customer =new Customer();
        selection=new ArrayList<>();
       
        
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getSelection() {
        return selection;
    }

    public void setSelection(List<Pizza> selection) {
        this.selection = selection;
    }


    public String getSess_Id() {
        return sess_Id;
    }

    public void setSess_Id(String sess_Id) {
        this.sess_Id = sess_Id;
    }

    @Override
    public String toString() {
        return "Ordered{" + "order_Id=" + order_Id + ", orderDate=" + orderDate + ", customer=" + customer + ", selection=" + selection + ", sess_Id=" + sess_Id + '}';
    }
 
    
    
    //-----------------------------my Methods
    public double totalPrice(Ordered  order){
        
        double price=0.0;
        
        for (Pizza tmpSlcPricePizza : order.getSelection()) {

                    price += Double.valueOf(tmpSlcPricePizza.getPrice())*tmpSlcPricePizza.getNumber();
                }
        
        
        return price;
    }

}
