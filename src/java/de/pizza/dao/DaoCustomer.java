/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.dao;

import de.pizza.model.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author ikoembe
 */
@Named
@SessionScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class DaoCustomer implements Serializable{
    
    @PersistenceUnit (unitName = "JPAlPizzaServiceIsmailKPU")
    private EntityManagerFactory emf;
    
     @Transactional
    public int storeCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.persist(customer);
        em.flush();
        return customer.getCustId();
    }

    
    public List<Customer> getList() {

        List<Customer> customers = new ArrayList();
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Kunde.SelectAll");
        customers = q.getResultList();
        return customers;
    }
    
}
