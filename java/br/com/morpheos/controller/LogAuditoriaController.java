package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;
import br.com.morpheos.entity.PacienteEntity;

public class LogAuditoriaController {

	private final FactoryDao factoryDao;
	
	public LogAuditoriaController(){
		this.factoryDao = new FactoryDao();
	}	
	
	public void gravaLogAuditoriaEstudo(LogAuditoriaEstudoEntity log){
		try{
			PacienteEntity paciente = new PacienteEntity();
			paciente.setIdPaciente(log.getIdPaciente());
			log.setPaciente(paciente);
			this.factoryDao.getLogAuditoriaVisitaDao().adiciona(log);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LogAuditoriaEstudoEntity> listaLogs(String idPaciente, String tpEntidade, String tpModificaocao){
		return this.factoryDao.getLogAuditoriaVisitaDao().buscaLogs(idPaciente, tpEntidade, tpModificaocao);
	}
	
}
