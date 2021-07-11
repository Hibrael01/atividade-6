package edu.ifg.br.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import edu.ifg.br.connection.ConnectionFactory;
import edu.ifg.br.model.bean.Marca;

public class MarcaDao {

	
	
	public Marca save(Marca marca) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(marca);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return marca;
	}
	
	public Marca update(Marca marca) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			if(marca.getId() == 0) {
				em.persist(marca);
			}else {
				em.merge(marca);
			}
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return marca;
	}


	public Marca findId(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Marca marca = null;
		
		try {
			marca = em.find(Marca.class, id);
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return marca;
		
	}

	
	
	
	public List<Marca> findAll() {
		
		EntityManager em = new ConnectionFactory().getConnection();
		List<Marca> marcas = null;
		
		try {
			marcas = em.createQuery("from Marca m").getResultList();
			
		}catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return marcas;
		
	}
	
	public Marca remove(int id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Marca marca = null;
		try {
			marca = em.find(Marca.class, id);
			
			em.getTransaction().begin();
			em.remove(marca);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally {
			em.close();
		}
		
		return marca;
	}
	
}

