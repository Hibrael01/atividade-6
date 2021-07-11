package edu.ifg.br.tests;

import edu.ifg.br.model.bean.Automovel;
import edu.ifg.br.model.bean.Marca;
import edu.ifg.br.model.bean.Modelo;
import edu.ifg.br.model.dao.AutomovelDao;
import edu.ifg.br.model.dao.MarcaDao;
import edu.ifg.br.model.dao.ModeloDao;

public class Application {

	public static void main(String[] args) {
		
		//Criando DAO para realizar as operações no Banco
		MarcaDao marcaDao = new MarcaDao();
		ModeloDao modeloDao = new ModeloDao();
		AutomovelDao automovelDao = new AutomovelDao();
		
		
		//Criando a Marca
		Marca marca = new Marca();
		marca.setNome("Koenigsegg Automotive AB");
		
		//Adicionando Marca no Banco de Dados
		marcaDao.save(marca);
		
		//Criando o Modelo
		Modelo modelo = new Modelo();
		modelo.setDescricao("Gemera");
		modelo.setPotencia(1700);
		modelo.setMarca(marca);
		
		//Adicionando o Modelo no BD
		modeloDao.save(modelo);
		
		//Criando o Automovel
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(2020);
		automovel.setAnoModelo(2020);
		automovel.setKilometragem(0);
		automovel.setModelo(modelo);
		automovel.setObservacoes("De 0 a 100km/h em menos de 2 segundos");
		automovel.setPreco((float) 5000000.41);
		
		//Adicionando o Automovel no BD
		automovelDao.save(automovel);
		
		//Imprime Marcas existentes no BD
		for(Marca m : marcaDao.findAll()) {
			System.out.println("|ID: " + m.getId() + "| Nome: " + m.getNome() + "|");
		}
		
		//Imprime Modelos existentes no BD
		for(Modelo m: modeloDao.findAll()) {
			System.out.println("|ID: " + m.getId() + "| Descrição: " + m.getDescricao()
			+ "| Potência: " + m.getPotencia() + "| ID Marca: " + m.getMarca().getId()
			+ "| Marca: " + m.getMarca().getNome() + "|");
		}
		
		//Imprime Automoveis existentes no BD
		for(Automovel a: automovelDao.findAll()) {
			System.out.println("|ID: " + a.getId() + "| Ano de Fabricação:" + a.getAnoFabricacao()
			+ "| Ano do Modelo: " + a.getAnoModelo() + "| Observações: " + a.getObservacoes()
			+ "| Preço: R$" + a.getPreco() + "| Kilometragem: " + a.getKilometragem()
			+ "km | ID Modelo: " + a.getModelo().getId() + "| Modelo: " + a.getModelo().getDescricao()
			+ "|");
		}
		

	}

}
