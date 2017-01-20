package com.deivisonprogrammer.jasper.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.deivisonprogrammer.jasper.connection.ConnectionFactory;
import com.deivisonprogrammer.jasper.model.Usuario;

public class UsuarioDAO implements UsuarioInterface {
	
	private EntityManager manager = null;
	
	@Override
	public void insert(Usuario u) {
		if(u != null){
			manager = ConnectionFactory.getManager();
			
			try{
				manager.getTransaction().begin();
				manager.persist(u);
				manager.getTransaction().commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				manager.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		manager = ConnectionFactory.getManager();
		
		try{
			return manager.createQuery("from Usuario").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		
		return null;
	}	
}
