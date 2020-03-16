/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Schulung
 */
public class GConnection {

    /**
     * Holt eine Datenbankverbindung.
     *
     * @return SQL Connection oder null wenn Fehler.
     */
    protected Connection getConnection()  {
        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
           Context ctx=new InitialContext();
            //Get a connection
           DataSource ds = (DataSource) ctx.lookup("jdbc/pizza_pizza_pool");//
           Connection conn = ds.getConnection();//
            System.out.println("CONNECTION SUCCESS------------------");

            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
