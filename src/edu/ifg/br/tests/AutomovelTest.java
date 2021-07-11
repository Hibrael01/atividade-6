package edu.ifg.br.tests;

import edu.ifg.br.model.bean.Automovel;
import edu.ifg.br.model.bean.Modelo;
import edu.ifg.br.model.dao.AutomovelDao;

public class AutomovelTest {
	public static void main(String[] args) {
		
		Modelo mod = new Modelo();
		mod.setId(14);
		
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(1969);
		automovel.setAnoModelo(1969);
		automovel.setKilometragem(250000);
		automovel.setModelo(mod);
		automovel.setObservacoes("Modelo Raro");
		automovel.setPreco((float) 950000.00);
		
		AutomovelDao autoDao = new AutomovelDao();
		autoDao.save(automovel);
	}
}
