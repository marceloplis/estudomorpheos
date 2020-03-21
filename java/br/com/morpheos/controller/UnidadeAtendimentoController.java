package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class UnidadeAtendimentoController {

	private final FactoryDao factoryDao;
	
	public UnidadeAtendimentoController(){
		this.factoryDao = new FactoryDao();
	}
	
	public List<UnidadeAtendimentoEntity> listarTodos(){
		return this.factoryDao.getUnidadeDao().listaTudo();
	}
	
	public UnidadeAtendimentoEntity buscarById(Long id){
		UnidadeAtendimentoEntity unidade = this.factoryDao.getUnidadeDao().procura(id);
		return unidade;
	}
	
	public UnidadeAtendimentoEntity gravar(UnidadeAtendimentoEntity unidade) throws Exception{		
		
		if(unidade.getIdUnidadePesquisa() == null || unidade.getIdUnidadePesquisa() == 0){
			unidade.setIdUnidadePesquisa(null);				
			this.factoryDao.getUnidadeDao().adiciona(unidade);
		}else{				
			this.factoryDao.getUnidadeDao().altera(unidade);
		}
			
		return unidade;
	}
	
	
}
