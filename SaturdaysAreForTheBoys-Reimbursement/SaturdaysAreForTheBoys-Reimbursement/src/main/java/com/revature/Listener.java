package com.revature;

import com.revature.DAO.ExpenseReimbursementDAO;
import com.revature.DAO.ExpenseReimbursementDAOImplementation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.IOException;
import java.sql.SQLException;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private ExpenseReimbursementDAO service;


    public Listener() {}


    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Created Listener"); // This "Listener" establishes a path to db.properties for information on entering the DB 
        try {
            service = new ExpenseReimbursementDAOImplementation(sce.getServletContext().getRealPath("/WEB-INF/db.properties"));

            sce.getServletContext().setAttribute("db", service);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("Destroyed"); //Prints to the console when the session is destroyed
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}