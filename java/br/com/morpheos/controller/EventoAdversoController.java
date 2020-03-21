package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.EventoAdversoEntity;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;
import br.com.morpheos.enums.TipoEntidadeEnum;
import br.com.morpheos.enums.TipoModificacaoEnum;
import br.com.morpheos.util.FusionChartsHelper;

public class EventoAdversoController {

	private final FactoryDao factoryDao;
	private final LogAuditoriaController logController;
	
	public EventoAdversoController(){
		this.factoryDao = new FactoryDao();
		this.logController = new LogAuditoriaController();
	}
		
	
	public List<EventoAdversoEntity> buscarEventosByIdPaciente(Long id){
		List<EventoAdversoEntity> listEventos = this.factoryDao.getEventoAdversoDao().buscaEventosByPaciente(id);
		return listEventos;
	}
	
	public EventoAdversoEntity buscarById(Long id){
		EventoAdversoEntity evento = this.factoryDao.getEventoAdversoDao().procura(id);
		return evento;
	}
	
	public EventoAdversoEntity gravarEvento(EventoAdversoEntity evento, String username) throws Exception{		
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.EVENTO.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(evento.getIdEventoAdverso() == null || evento.getIdEventoAdverso() == 0){
			evento.setIdEventoAdverso(null);				
			this.factoryDao.getEventoAdversoDao().adiciona(evento);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{				
			this.factoryDao.getEventoAdversoDao().altera(evento);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(evento.getStAprovacao() != null && evento.getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Evento Adverso - ").append("Visita ").append(evento.getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(evento.getPaciente().getIdPaciente());
		log.setPaciente(evento.getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
			
		return evento;
	}
	
	
	public void excluirEvento(EventoAdversoEntity evento, String username) throws Exception{	
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.EVENTO.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		this.factoryDao.getEventoAdversoDao().remove(evento);
		
		log.setTpModificacao(TipoModificacaoEnum.EXCLUSAO.getValue());	
		
		dsModificacao.append("Evento Adverso - ").append(evento.getDoenca().getDsDoenca());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(evento.getPaciente().getIdPaciente());
		log.setPaciente(evento.getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
	}
	
	public Integer countEventosByDoenca(Long idDoencaEvento){
		return this.factoryDao.getEventoAdversoDao().countEventosByDoenca(idDoencaEvento);
	}
	
	public String countEventosGroupByStatus(){
		
		StringBuilder strXML = new StringBuilder();       
        
		FusionChartsHelper colorHelper= new FusionChartsHelper();
       
        strXML.append("<graph caption='' showPercentageInLabel='1' pieSliceDepth='25' decimalPrecision='0' showNames='1'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getEventoAdversoDao().countEventosGroupByStatus();        
        Integer countP = 0;
        Integer countA = 0;
        for(EstatisticasDTO dado : list){
        	
        	if(dado.getValor() == null || dado.getValor().equals("P"))
        		countP = countP + dado.getCount(); 
        	else
        		countA = countA + dado.getCount();
        		
        }
        strXML.append("<set name='Pendentes' value='" + countP + "' color='" + colorHelper.getFCColor() + "'/>");
        strXML.append("<set name='Aprovados' value='" + countA + "' color='" + colorHelper.getFCColor() + "'/>");
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}
	
}
