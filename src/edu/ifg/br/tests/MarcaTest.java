package edu.ifg.br.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.ifg.br.connection.ConnectionFactory;
import edu.ifg.br.model.bean.Marca;
import edu.ifg.br.model.bean.Modelo;
import edu.ifg.br.model.dao.MarcaDao;

public class MarcaTest {

	public static void main(String[] args) {
		
		
		MarcaDao mDao = new MarcaDao();
		Marca m = new Marca();
		m.setNome("Ford");
		
		mDao.save(m);
		
		/*for(Marca m : mDao.findAll()) {
			System.out.println("Marca: " + m.getNome());
		}*/
		
		
		
		

	}

}
