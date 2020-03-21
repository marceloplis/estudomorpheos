package br.com.morpheos.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.dao.types.TipoRelatorioExcel;

public class RelatorioExcelController {		
	
	private final FactoryDao factoryDao;
	
	public RelatorioExcelController(){
		this.factoryDao = new FactoryDao();
	}
	
	public <T> List<T> buscaDados(TipoRelatorioExcel tre) throws SQLException, Exception{
		
		List<T> list = this.factoryDao.getFRelatorioExcelDao().buscaDados(tre);
		return list;
		
	}
		
}
