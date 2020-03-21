package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.GrupoMedicamentoEntity;

public class GrpMedicamentoController {

	private final FactoryDao factoryDao;
	
	public GrpMedicamentoController(){
		this.factoryDao = new FactoryDao();
	}
	
	public List<GrupoMedicamentoEntity> listarTodos(){
		return this.factoryDao.getGrpMedicamentoDao().listaTudo();
	}
	
	public GrupoMedicamentoEntity buscarById(Long id){
		GrupoMedicamentoEntity grupo = this.factoryDao.getGrpMedicamentoDao().procura(id);
		return grupo;
	}
	
	public GrupoMedicamentoEntity gravar(GrupoMedicamentoEntity grupo) throws Exception{		
		
		if(grupo.getIdGrupoMedicamento() == null || grupo.getIdGrupoMedicamento() == 0){
			grupo.setIdGrupoMedicamento(null);				
			this.factoryDao.getGrpMedicamentoDao().adiciona(grupo);
		}else{				
			this.factoryDao.getGrpMedicamentoDao().altera(grupo);
		}
			
		return grupo;
	}
	
	public Integer countMedicamentoByGrupo(Long idGrupoMedicamento){
		return this.factoryDao.getMedicamentoDao().countMedicamentoByGrupo(idGrupoMedicamento);
	}
	
	public void excluir(Long idGrupoMedicamento){
		GrupoMedicamentoEntity grpMedicamento = new GrupoMedicamentoEntity();
		grpMedicamento.setIdGrupoMedicamento(idGrupoMedicamento);
		this.factoryDao.getGrpMedicamentoDao().remove(grpMedicamento);
	}
	
	
	
}
