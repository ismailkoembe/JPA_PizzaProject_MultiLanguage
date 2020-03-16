package de.pizza.dao;


import de.pizza.model.Ordered;
import de.pizza.model.Selection;
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

@Named
@SessionScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class DaoOrder implements Serializable {

    @PersistenceUnit(unitName = "JPAlPizzaServiceIsmailKPU")
    private EntityManagerFactory emf;

//    @Transactional 
    public void storeOrder(Ordered o) {

        EntityManager em = emf.createEntityManager();
        em.persist(o);
        em.flush();

    }

    public List<Ordered> getOrdersList() {

        List<Ordered> orders = new ArrayList();
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Ordered.SelectAll");
        orders = q.getResultList();
        return orders;
    }

    //    @Transactional 
    public void storeSelection(Selection slc) {

        EntityManager em = emf.createEntityManager();
        em.persist(slc);
        em.flush();

    }
    
    
}
