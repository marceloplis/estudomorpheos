package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.DoencaEventoEntity;

public class DoencaEventoController {

private final FactoryDao factoryDao;
	
	public DoencaEventoController(){
		this.factoryDao = new FactoryDao();
	}
	
	public List<DoencaEventoEntity> listarTodos(){
		return this.factoryDao.getDoencaEventoDao().listaTudo();
	}
	
	public DoencaEventoEntity buscarById(Long id){
		DoencaEventoEntity doenca = this.factoryDao.getDoencaEventoDao().procura(id);
		return doenca;
	}
	
	public DoencaEventoEntity gravar(DoencaEventoEntity doenca) throws Exception{		
		
		if(doenca.getIdDoencaEvento() == null || doenca.getIdDoencaEvento() == 0){
			doenca.setIdDoencaEvento(null);				
			this.factoryDao.getDoencaEventoDao().adiciona(doenca);
		}else{				
			this.factoryDao.getDoencaEventoDao().altera(doenca);
		}
			
		return doenca;
	}
	
	public void excluir(Long idDoenca){
		DoencaEventoEntity doenca = new DoencaEventoEntity();
		doenca.setIdDoencaEvento(idDoenca);
		this.factoryDao.getDoencaEventoDao().remove(doenca);
	}
	
}
