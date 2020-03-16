/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.model;
import de.pizza.util.LocalDateTimeConverter;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ikoembe
 */
@Entity
@Table(name = "customer")
@NamedQueries({@NamedQuery(name = "Customer.SelectAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private String email;
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "customer",targetEntity =Ordered.class)
    @JoinColumn(name = "CUSTOMER_CUSTID",nullable = false )
    private Ordered ordered;

      
    public Customer() {
    }
    
    public Customer(int custId, String firstname, String lastname, String street, String city, String email) {
        this.custId = custId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.email = email;

    }

    

    public Customer(int custId, String firstname, String lastname, String street, String city) {
        this.custId = custId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "custId=" + custId + ", firstname=" + firstname + ", lastname=" + lastname + ", street=" + street + ", city=" + city + ", email=" + email + ", ordered=" + ordered + '}';
    }



}
