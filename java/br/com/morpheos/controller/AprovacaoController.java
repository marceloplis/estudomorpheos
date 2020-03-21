package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.EventoAdversoEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;
import br.com.morpheos.entity.VisitaEntity;

public class AprovacaoController {

private final FactoryDao factoryDao;
	
	public AprovacaoController(){
		this.factoryDao = new FactoryDao();
	}
	
	public List<VisitaEntity> listVisitasPententes(Integer idUnidade){
		return this.factoryDao.getVisitaDao().buscaVisitasPendentes(idUnidade);
	}
	
	public List<EventoAdversoEntity> listEventosPententes(Integer idUnidade){
		return this.factoryDao.getEventoAdversoDao().buscaEventosPendentes(idUnidade);
	}
	
	public List<SaidaEstudoEntity> listSaidasPententes(Integer idUnidade){
		return this.factoryDao.getSaidaEstudoDao().buscaSaidasPendentes(idUnidade);
	}
	
}
