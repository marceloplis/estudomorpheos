package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.MedicamentoEntity;

public class MedicamentoController {

	private final FactoryDao factoryDao;
	
	public MedicamentoController(){
		this.factoryDao = new FactoryDao();
	}
	
	public List<MedicamentoEntity> listarTodos(){
		return this.factoryDao.getMedicamentoDao().listaTudo();
	}
	
	public MedicamentoEntity buscarById(Long id){
		MedicamentoEntity medicamento = this.factoryDao.getMedicamentoDao().procura(id);
		return medicamento;
	}
	
	public List<MedicamentoEntity> buscaPorGrupo(Long idGrupo){
		List<MedicamentoEntity> medicamentos = this.factoryDao.getMedicamentoDao().buscaMedicamentosByGrupo(idGrupo);
		return medicamentos;
	}
	
	public MedicamentoEntity gravar(MedicamentoEntity medicamento) throws Exception{		
		
		if(medicamento.getIdMedicamento() == null || medicamento.getIdMedicamento() == 0){
			medicamento.setIdMedicamento(null);				
			this.factoryDao.getMedicamentoDao().adiciona(medicamento);
		}else{				
			this.factoryDao.getMedicamentoDao().altera(medicamento);
		}
			
		return medicamento;
	}
	
	public void excluir(MedicamentoEntity medicamento){
		this.factoryDao.getMedicamentoDao().remove(medicamento);
	}
	
	public Integer countUsoByMedicamento(Long idMedicamento){
		return this.factoryDao.getMedicamentoUsoDao().countUsoByMedicamento(idMedicamento);
	}
	
}
