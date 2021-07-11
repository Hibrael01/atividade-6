package edu.ifg.br.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade6");
	
	
	public EntityManager getConnection() {
		return emf.createEntityManager();
		
	}
	
}
