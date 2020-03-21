package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;
import br.com.morpheos.enums.TipoEntidadeEnum;
import br.com.morpheos.enums.TipoModificacaoEnum;
import br.com.morpheos.util.FusionChartsHelper;

public class SaidaEstudoController {

	private final FactoryDao factoryDao;
	private final LogAuditoriaController logController;
	
	public SaidaEstudoController(){
		this.factoryDao = new FactoryDao();
		this.logController = new LogAuditoriaController();
	}	
	
	/*Saida Estudo*/
	public SaidaEstudoEntity buscarSaidaEstudoByIdPaciente(Long id) {
		SaidaEstudoEntity saidaEstudo = this.factoryDao.getSaidaEstudoDao().buscaByPaciente(id);
		return saidaEstudo;
	}

	public SaidaEstudoEntity gravarSaidaEstudo(SaidaEstudoEntity saidaEstudo, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.SAIDA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(saidaEstudo.getIdSaidaEstudo() == null || saidaEstudo.getIdSaidaEstudo() == 0){
			saidaEstudo.setIdSaidaEstudo(null);				
			this.factoryDao.getSaidaEstudoDao().adiciona(saidaEstudo);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{				
			this.factoryDao.getSaidaEstudoDao().altera(saidaEstudo);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(saidaEstudo.getStAprovacao() != null && saidaEstudo.getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Saída do Estudo");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(saidaEstudo.getPaciente().getIdPaciente());
		log.setPaciente(saidaEstudo.getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return saidaEstudo;
	}
	
	public void excluir(SaidaEstudoEntity saidaEstudo, String username){
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.SAIDA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		this.factoryDao.getSaidaEstudoDao().remove(saidaEstudo);
		
		log.setTpModificacao(TipoModificacaoEnum.EXCLUSAO.getValue());	
		
		dsModificacao.append("Saída do Estudo");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(saidaEstudo.getPaciente().getIdPaciente());
		log.setPaciente(saidaEstudo.getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
	}
	
	public String countSaidasGroupByStatus(){
		
		StringBuilder strXML = new StringBuilder();       
        
		FusionChartsHelper colorHelper= new FusionChartsHelper();
       
        strXML.append("<graph caption='' showPercentageInLabel='1' pieSliceDepth='25' decimalPrecision='0' showNames='1'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getSaidaEstudoDao().countSaidasGroupByStatus();        
        for(EstatisticasDTO dado : list){
        	String name = dado.getValor() == null || dado.getValor().equals("P") ? "Pendentes" : dado.getValor().equals("R") ? "Reprovadas": "Aprovadas";
        	strXML.append("<set name='" + name + "' value='" + dado.getCount() + "' color='" + colorHelper.getFCColor() + "'/>");
        }
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}
	
}
