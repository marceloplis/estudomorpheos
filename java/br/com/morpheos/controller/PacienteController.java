package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.UsuarioEntity;
import br.com.morpheos.enums.PerfilEnum;
import br.com.morpheos.util.FusionChartsHelper;

public class PacienteController {

	private final FactoryDao factoryDao;
	
	public PacienteController(){
		this.factoryDao = new FactoryDao();
	}
	
	public PacienteEntity gravar(PacienteEntity paciente) throws Exception{		
		
		String cpf = paciente.getCpf().replaceAll("[.-]", "");
		paciente.setCpf(cpf);
		
		if(paciente.getIdPaciente() == null || paciente.getIdPaciente() == 0){
			paciente.setIdPaciente(null);				
			this.factoryDao.getPacienteDao().adiciona(paciente);
		}else{				
			this.factoryDao.getPacienteDao().altera(paciente);
		}
		
		paciente = this.factoryDao.getPacienteDao().buscaPorCpf(cpf);
		
		return paciente;
	}
	
	public PacienteEntity buscarById(Long id){
		PacienteEntity paciente = this.factoryDao.getPacienteDao().procura(id);
		return paciente;
	}
	
	public PacienteEntity buscarByCpf(String cpf){
		PacienteEntity paciente = this.factoryDao.getPacienteDao().buscaPorCpf(cpf);
		return paciente;
	}
	
	public List<PacienteEntity> buscar(String termo, UsuarioEntity usuarioLogado){		
		List<PacienteEntity> listPacientes;
		if(usuarioLogado.getPerfil().getIdPerfilAcesso() == PerfilEnum.ADMIN.getValue()){
			listPacientes = this.factoryDao.getPacienteDao().busca(termo);
		}else{
			listPacientes = this.factoryDao.getPacienteDao().buscaPorUnidade(termo, usuarioLogado.getUnidade().getIdUnidadePesquisa());
		}
		return listPacientes;
	}
	
	public List<PacienteEntity> listTodos(UsuarioEntity usuarioLogado){		
		List<PacienteEntity> listPacientes = null;
		if(usuarioLogado.getPerfil().getIdPerfilAcesso() == PerfilEnum.ADMIN.getValue()){
			listPacientes = this.factoryDao.getPacienteDao().listaTudo();
		}else{
			listPacientes = this.factoryDao.getPacienteDao().buscaPorUnidade(null, usuarioLogado.getUnidade().getIdUnidadePesquisa());
		}
		return listPacientes;
	}
	
	public void apagarPaciente(PacienteEntity paciente){
		this.factoryDao.getPacienteDao().remove(paciente);
	}
	
	public List<PacienteEntity> buscarByUnidade(long idUnidade){
		List<PacienteEntity> listPacientes = null;
		if(idUnidade == 0){
			listPacientes = this.factoryDao.getPacienteDao().listaTudo();
		}else{
			listPacientes = this.factoryDao.getPacienteDao().buscaPorUnidade(null, idUnidade);
		}
		return listPacientes;
		
	}
	
	public String countPacientesGroupByStatus(){
		
		StringBuilder strXML = new StringBuilder();       
        
		FusionChartsHelper colorHelper= new FusionChartsHelper();
       
        strXML.append("<graph caption='' showPercentageInLabel='1' pieSliceDepth='25' decimalPrecision='0' showNames='1'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getPacienteDao().countPacientesGroupByStatus();        
        for(EstatisticasDTO dado : list){
        	String name = dado.getValor() == null ? "Ativos" : "Excluídos";
        	strXML.append("<set name='" + name + "' value='" + dado.getCount() + "' color='" + colorHelper.getFCColor() + "'/>");
        }
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}
	
	
	public String countPacientesGroupByUnidade(){
		
		StringBuilder strXML = new StringBuilder();       
        
		FusionChartsHelper colorHelper= new FusionChartsHelper();
       
        strXML.append("<graph caption='' showPercentageInLabel='1' pieSliceDepth='25' decimalPrecision='0' showNames='1'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getPacienteDao().countPacientesGroupByUnidade();        
        for(EstatisticasDTO dado : list){
        	strXML.append("<set name='" + dado.getValor() + "' value='" + dado.getCount() + "' color='" + colorHelper.getFCColor() + "'/>");
        }
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}
	
}
