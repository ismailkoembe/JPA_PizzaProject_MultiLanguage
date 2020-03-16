/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.util;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author schulung
 */
@WebListener
public class ActionListener implements HttpSessionListener {

    private static Map<String,HttpSession> listAllSessions=new HashMap<>();
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session createt  "+ se.getSession().getId());
        listAllSessions.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed  "+ se.getSession().getId());
        listAllSessions.remove(se.getSession().getId());
    }

    public static Map<String, HttpSession> getListAllSessions() {
        return listAllSessions;
    }

    public static void setListAllSessions(Map<String, HttpSession> listAllSessions) {
        ActionListener.listAllSessions = listAllSessions;
    }
    
}
