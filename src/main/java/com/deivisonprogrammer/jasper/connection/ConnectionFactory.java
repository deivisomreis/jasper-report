package com.deivisonprogrammer.jasper.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory;
	
	public static void startConnection(){
		if(factory == null || !factory.isOpen())
			factory = Persistence.createEntityManagerFactory("jasper-relatorio");
	}
	
	public static void stopConnection(){
		if(factory != null && factory.isOpen())
			factory.close();
	}
	
	public static EntityManager getManager(){
		startConnection();
		
		return factory.createEntityManager();
	}
}
