package edu.ifg.br.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ifg.br.connection.ConnectionFactory;
import edu.ifg.br.model.bean.Automovel;

public class AutomovelDao {

	public Automovel save(Automovel auto) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			
			em.getTransaction().begin();
			em.persist(auto);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return auto;
	}
	
	public Automovel update(Automovel auto) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			if(auto.getId() == 0) {
				em.persist(auto);
			}else {
				em.merge(auto);
			}
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return auto;
		
	}
	
	
	public Automovel findById(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Automovel auto = null;
		
		try {
			
			auto = em.find(Automovel.class, id);
			
		} catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		}finally {
			
			em.close();
			
		}
		
		return auto;
	}
	
	public List<Automovel> findAll(){
		
		EntityManager em = new ConnectionFactory().getConnection();
		List<Automovel> autos = null;
		
		try {
			
			autos = em.createQuery("from Automovel a").getResultList();
			
		} catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		}finally {
			em.close();
		}
		
		return autos;
		
	}
	
	public Automovel remove(int id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Automovel auto = null;
		
		try {
			
			auto = em.find(Automovel.class, id);
			
			em.getTransaction().begin();
			em.remove(auto);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
			// TODO: handle exception
		}finally {
			em.close();
		}
		
		return auto;
	}
	
}


