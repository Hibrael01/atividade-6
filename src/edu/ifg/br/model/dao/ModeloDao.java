package edu.ifg.br.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ifg.br.connection.ConnectionFactory;
import edu.ifg.br.model.bean.Modelo;

public class ModeloDao {

	public Modelo save(Modelo modelo) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		
		try {
			
			em.getTransaction().begin();
			em.persist(modelo);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return modelo;
		
		
	}
	
	public Modelo update(Modelo modelo) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		
		try {
			
			em.getTransaction().begin();
			
			if(modelo.getId() == 0) {
				
				em.persist(modelo);
			}else {
				
				em.merge(modelo);
			}
			
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return modelo;
		
		
	}
	
	
	public Modelo findById(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Modelo modelo = null;
		
		
		try {
			
			modelo = em.find(Modelo.class, id);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			em.close();
			
		}
		
		return modelo;
	}
	
	
	public List<Modelo> findAll() {
		
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> modelos = null;
		
		
		try {
			
			modelos = em.createQuery("from Modelo m").getResultList();
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			em.close();
			
		}
		
		return modelos;
	}
	
	public Modelo remove(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Modelo modelo = null;
		
		try {
			
			modelo = em.find(Modelo.class, id);
			
			em.getTransaction().begin();
			em.remove(modelo);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return modelo;
	}
}
