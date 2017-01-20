package com.deivisonprogrammer.jasper.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.deivisonprogrammer.jasper.connection.ConnectionFactory;


@WebListener
public class ConnectionListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	ConnectionFactory.stopConnection();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ConnectionFactory.startConnection();
    }
	
}
