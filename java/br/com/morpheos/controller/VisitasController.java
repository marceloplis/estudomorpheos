package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.AdesaoMedicacaoEntity;
import br.com.morpheos.entity.AdesaoTratamentoEntity;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;
import br.com.morpheos.entity.Visita00Entity;
import br.com.morpheos.entity.Visita01Entity;
import br.com.morpheos.entity.Visita02Entity;
import br.com.morpheos.entity.Visita03Entity;
import br.com.morpheos.entity.Visita04Entity;
import br.com.morpheos.entity.Visita05Entity;
import br.com.morpheos.entity.Visita06Entity;
import br.com.morpheos.entity.Visita07Entity;
import br.com.morpheos.entity.Visita08Entity;
import br.com.morpheos.entity.Visita09Entity;
import br.com.morpheos.entity.Visita10Entity;
import br.com.morpheos.entity.Visita11Entity;
import br.com.morpheos.entity.Visita12Entity;
import br.com.morpheos.entity.Visita13Entity;
import br.com.morpheos.entity.Visita14Entity;
import br.com.morpheos.entity.Visita15Entity;
import br.com.morpheos.entity.Visita16Entity;
import br.com.morpheos.entity.Visita17Entity;
import br.com.morpheos.entity.VisitaEntity;
import br.com.morpheos.enums.TipoEntidadeEnum;
import br.com.morpheos.enums.TipoModificacaoEnum;
import br.com.morpheos.util.FusionChartsHelper;

public class VisitasController {

	private final FactoryDao factoryDao;
	private final LogAuditoriaController logController;
	
	public VisitasController(){
		this.factoryDao = new FactoryDao();
		this.logController = new LogAuditoriaController();
	}	

	
	public List<VisitaEntity> buscaTodasVisitas(Long idPaciente){
		List<VisitaEntity> visitas = this.factoryDao.getVisitaDao().buscaVisitasByPaciente(idPaciente);
		return visitas;
	}
	
	public VisitaEntity buscaVisitaEntityById(Long id){
		return this.factoryDao.getVisitaDao().procura(id);
	}
	
	public VisitaEntity gravarVisitaEntity(VisitaEntity visita, String username) throws Exception{		
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita.getIdVisita() == null || visita.getIdVisita() == 0){
			visita.setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());		
		}else{	
			this.factoryDao.getVisitaDao().altera(visita);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita.getStAprovacao() != null && visita.getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}		
		
		dsModificacao.append("Visita ").append(visita.getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita.getPaciente().getIdPaciente());
		log.setPaciente(visita.getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
			
		return visita;
	}
	
	public String countPacientesGroupByVisitas(){
		
		StringBuilder strXML = new StringBuilder(); 
		
		FusionChartsHelper colorHelper= new FusionChartsHelper();
	       
        strXML.append("<graph caption='' xAxisName='Visitas' yAxisName='Pacientes' decimalPrecision='0' formatNumberScale='0'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getVisitaDao().countPacientesGroupByVisitas();        
        for(EstatisticasDTO dado : list){
        	strXML.append("<set name='" + dado.getValor() + "' value='" + dado.getCount() + "' color='" + colorHelper.getFCColor() + "'/>");
        }
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}
	
	
	public String countVisitasGroupByStatus(){
		
		StringBuilder strXML = new StringBuilder();       
        
		FusionChartsHelper colorHelper= new FusionChartsHelper();
       
        strXML.append("<graph caption='' showPercentageInLabel='1' pieSliceDepth='25' decimalPrecision='0' showNames='1'>");
       
        List<EstatisticasDTO> list = this.factoryDao.getVisitaDao().countVisitasGroupByStatus();        
        for(EstatisticasDTO dado : list){
        	String name = dado.getValor() == null || dado.getValor().equals("P") ? "Pendentes" : dado.getValor().equals("R") ? "Reprovadas": "Aprovadas";
        	strXML.append("<set name='" + name + "' value='" + dado.getCount() + "' color='" + colorHelper.getFCColor() + "'/>");
        }
        //Close <graph> element
        strXML.append("</graph>");       
        
		return strXML.toString();
		
	}

	
	/*visita00*/
	public Visita00Entity buscarVisita00ByIdPaciente(Long id){
		Visita00Entity visita00 = this.factoryDao.getVisita00Dao().buscaVisitaByPaciente(id, 0);
		return visita00;
	}	

	public Visita00Entity gravarVisita00(Visita00Entity visita00, String username) throws Exception{		
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita00.getVisita().getIdVisita() == null || visita00.getVisita().getIdVisita() == 0){
			visita00.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita00.getVisita());
			this.factoryDao.getVisita00Dao().adiciona(visita00);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita00.getVisita());
			this.factoryDao.getVisita00Dao().altera(visita00);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita00.getVisita().getStAprovacao() != null && visita00.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}		
		
		dsModificacao.append("Visita ").append(visita00.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita00.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita00.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
			
		return visita00;
	}
	
	/*visita01*/
	public Visita01Entity buscarVisita01ByIdPaciente(Long id){
		Visita01Entity visita01 = this.factoryDao.getVisita01Dao().buscaVisitaByPaciente(id, 1);
		return visita01;
	}	

	public Visita01Entity gravarVisita01(Visita01Entity visita01, String username) throws Exception{		
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita01.getVisita().getIdVisita() == null || visita01.getVisita().getIdVisita() == 0){
			visita01.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita01.getVisita());
			this.factoryDao.getVisita01Dao().adiciona(visita01);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita01.getVisita());
			this.factoryDao.getVisita01Dao().altera(visita01);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita01.getVisita().getStAprovacao() != null && visita01.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}		
		
		dsModificacao.append("Visita ").append(visita01.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita01.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita01.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
			
		return visita01;
	}
	
	/*visita02*/
	public Visita02Entity buscarVisita02ByIdPaciente(Long id){
		Visita02Entity visita02 = this.factoryDao.getVisita02Dao().buscaVisitaByPaciente(id, 2);
		return visita02;
	}	

	public Visita02Entity gravarVisita02(Visita02Entity visita02, String username) throws Exception{		
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita02.getVisita().getIdVisita() == null || visita02.getVisita().getIdVisita() == 0){
			visita02.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita02.getVisita());
			this.factoryDao.getVisita02Dao().adiciona(visita02);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita02.getVisita());
			this.factoryDao.getVisita02Dao().altera(visita02);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita02.getVisita().getStAprovacao() != null && visita02.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita02.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita02.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita02.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
			
		return visita02;
	}
	
	
	/*visita03*/
	public Visita03Entity buscarVisita03ByIdPaciente(Long id) {
		Visita03Entity visita03 = this.factoryDao.getVisita03Dao().buscaVisitaByPaciente(id, 3);
		return visita03;
	}

	public Visita03Entity gravarVisita03(Visita03Entity visita03, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita03.getVisita().getIdVisita() == null || visita03.getVisita().getIdVisita() == 0){
			visita03.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita03.getVisita());
			this.factoryDao.getVisita03Dao().adiciona(visita03);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita03.getVisita());
			this.factoryDao.getVisita03Dao().altera(visita03);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita03.getVisita().getStAprovacao() != null && visita03.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita03.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita03.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita03.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita03;
	}
	
	/*visita04*/
	public Visita04Entity buscarVisita04ByIdPaciente(Long id) {
		Visita04Entity visita04 = this.factoryDao.getVisita04Dao().buscaVisitaByPaciente(id, 4);
		return visita04;
	}

	public Visita04Entity gravarVisita04(Visita04Entity visita04, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita04.getVisita().getIdVisita() == null || visita04.getVisita().getIdVisita() == 0){
			visita04.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita04.getVisita());
			this.factoryDao.getVisita04Dao().adiciona(visita04);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita04.getVisita());
			this.factoryDao.getVisita04Dao().altera(visita04);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita04.getVisita().getStAprovacao() != null && visita04.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita04.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita04.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita04.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita04;
	}
	
	/*visita05*/
	public Visita05Entity buscarVisita05ByIdPaciente(Long id) {
		Visita05Entity visita05 = this.factoryDao.getVisita05Dao().buscaVisitaByPaciente(id, 5);
		return visita05;
	}

	public Visita05Entity gravarVisita05(Visita05Entity visita05, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita05.getVisita().getIdVisita() == null || visita05.getVisita().getIdVisita() == 0){
			visita05.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita05.getVisita());
			this.factoryDao.getVisita05Dao().adiciona(visita05);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita05.getVisita());
			this.factoryDao.getVisita05Dao().altera(visita05);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita05.getVisita().getStAprovacao() != null && visita05.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita05.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita05.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita05.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita05;
	}
	
	/*visita06*/
	public Visita06Entity buscarVisita06ByIdPaciente(Long id) {
		Visita06Entity visita06 = this.factoryDao.getVisita06Dao().buscaVisitaByPaciente(id, 6);
		return visita06;
	}

	public Visita06Entity gravarVisita06(Visita06Entity visita06, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita06.getVisita().getIdVisita() == null || visita06.getVisita().getIdVisita() == 0){
			visita06.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita06.getVisita());
			this.factoryDao.getVisita06Dao().adiciona(visita06);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita06.getVisita());
			this.factoryDao.getVisita06Dao().altera(visita06);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita06.getVisita().getStAprovacao() != null && visita06.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita06.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita06.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita06.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita06;
	}
	
	/*visita07*/
	public Visita07Entity buscarVisita07ByIdPaciente(Long id) {
		Visita07Entity visita07 = this.factoryDao.getVisita07Dao().buscaVisitaByPaciente(id, 7);
		return visita07;
	}

	public Visita07Entity gravarVisita07(Visita07Entity visita07, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita07.getVisita().getIdVisita() == null || visita07.getVisita().getIdVisita() == 0){
			visita07.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita07.getVisita());
			this.factoryDao.getVisita07Dao().adiciona(visita07);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita07.getVisita());
			this.factoryDao.getVisita07Dao().altera(visita07);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita07.getVisita().getStAprovacao() != null && visita07.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita07.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita07.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita07.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita07;
	}
	
	/*visita08*/
	public Visita08Entity buscarVisita08ByIdPaciente(Long id) {
		Visita08Entity visita08 = this.factoryDao.getVisita08Dao().buscaVisitaByPaciente(id, 8);
		return visita08;
	}

	public Visita08Entity gravarVisita08(Visita08Entity visita08, String username) throws Exception {
				
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita08.getVisita().getIdVisita() == null || visita08.getVisita().getIdVisita() == 0){
			visita08.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita08.getVisita());
			this.factoryDao.getVisita08Dao().adiciona(visita08);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita08.getVisita());
			this.factoryDao.getVisita08Dao().altera(visita08);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita08.getVisita().getStAprovacao() != null && visita08.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita08.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita08.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita08.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita08;
	}
	
	/*visita09*/
	public Visita09Entity buscarVisita09ByIdPaciente(Long id) {
		Visita09Entity visita09 = this.factoryDao.getVisita09Dao().buscaVisitaByPaciente(id, 9);
		return visita09;
	}

	public Visita09Entity gravarVisita09(Visita09Entity visita09, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita09.getVisita().getIdVisita() == null || visita09.getVisita().getIdVisita() == 0){
			visita09.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita09.getVisita());
			this.factoryDao.getVisita09Dao().adiciona(visita09);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita09.getVisita());
			this.factoryDao.getVisita09Dao().altera(visita09);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita09.getVisita().getStAprovacao() != null && visita09.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita09.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita09.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita09.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita09;
	}
	
	/*visita10*/
	public Visita10Entity buscarVisita10ByIdPaciente(Long id) {
		Visita10Entity visita10 = this.factoryDao.getVisita10Dao().buscaVisitaByPaciente(id, 10);
		return visita10;
	}

	public Visita10Entity gravarVisita10(Visita10Entity visita10, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita10.getVisita().getIdVisita() == null || visita10.getVisita().getIdVisita() == 0){
			visita10.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita10.getVisita());
			this.factoryDao.getVisita10Dao().adiciona(visita10);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita10.getVisita());
			this.factoryDao.getVisita10Dao().altera(visita10);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita10.getVisita().getStAprovacao() != null && visita10.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita10.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita10.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita10.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita10;
	}
	
	/*visita11*/
	public Visita11Entity buscarVisita11ByIdPaciente(Long id) {
		Visita11Entity visita11 = this.factoryDao.getVisita11Dao().buscaVisitaByPaciente(id, 11);
		return visita11;
	}

	public Visita11Entity gravarVisita11(Visita11Entity visita11, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita11.getVisita().getIdVisita() == null || visita11.getVisita().getIdVisita() == 0){
			visita11.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita11.getVisita());
			this.factoryDao.getVisita11Dao().adiciona(visita11);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita11.getVisita());
			this.factoryDao.getVisita11Dao().altera(visita11);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita11.getVisita().getStAprovacao() != null && visita11.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita11.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita11.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita11.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita11;
	}
	
	/*visita12*/
	public Visita12Entity buscarVisita12ByIdPaciente(Long id) {
		Visita12Entity visita12 = this.factoryDao.getVisita12Dao().buscaVisitaByPaciente(id, 12);
		return visita12;
	}

	public Visita12Entity gravarVisita12(Visita12Entity visita12, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita12.getVisita().getIdVisita() == null || visita12.getVisita().getIdVisita() == 0){
			visita12.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita12.getVisita());
			this.factoryDao.getVisita12Dao().adiciona(visita12);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita12.getVisita());
			this.factoryDao.getVisita12Dao().altera(visita12);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita12.getVisita().getStAprovacao() != null && visita12.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita12.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita12.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita12.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita12;
	}
	
	/*visita13*/
	public Visita13Entity buscarVisita13ByIdPaciente(Long id) {
		Visita13Entity visita13 = this.factoryDao.getVisita13Dao().buscaVisitaByPaciente(id, 13);
		return visita13;
	}

	public Visita13Entity gravarVisita13(Visita13Entity visita13, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita13.getVisita().getIdVisita() == null || visita13.getVisita().getIdVisita() == 0){
			visita13.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita13.getVisita());
			this.factoryDao.getVisita13Dao().adiciona(visita13);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita13.getVisita());
			this.factoryDao.getVisita13Dao().altera(visita13);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita13.getVisita().getStAprovacao() != null && visita13.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita13.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita13.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita13.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita13;
	}
	
	/*visita14*/
	public Visita14Entity buscarVisita14ByIdPaciente(Long id) {
		Visita14Entity visita14 = this.factoryDao.getVisita14Dao().buscaVisitaByPaciente(id, 14);
		return visita14;
	}

	public Visita14Entity gravarVisita14(Visita14Entity visita14, String username) throws Exception {
		
		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita14.getVisita().getIdVisita() == null || visita14.getVisita().getIdVisita() == 0){
			visita14.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita14.getVisita());
			this.factoryDao.getVisita14Dao().adiciona(visita14);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita14.getVisita());
			this.factoryDao.getVisita14Dao().altera(visita14);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita14.getVisita().getStAprovacao() != null && visita14.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita14.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita14.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita14.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita14;
	}
	
	/*visita15*/
	public Visita15Entity buscarVisita15ByIdPaciente(Long id) {
		Visita15Entity visita15 = this.factoryDao.getVisita15Dao().buscaVisitaByPaciente(id, 15);
		return visita15;
	}

	public Visita15Entity gravarVisita15(Visita15Entity visita15, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita15.getVisita().getIdVisita() == null || visita15.getVisita().getIdVisita() == 0){
			visita15.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita15.getVisita());
			this.factoryDao.getVisita15Dao().adiciona(visita15);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita15.getVisita());
			this.factoryDao.getVisita15Dao().altera(visita15);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita15.getVisita().getStAprovacao() != null && visita15.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita15.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita15.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita15.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita15;
	}
	
	/*visita16*/
	public Visita16Entity buscarVisita16ByIdPaciente(Long id) {
		Visita16Entity visita16 = this.factoryDao.getVisita16Dao().buscaVisitaByPaciente(id, 16);
		return visita16;
	}

	public Visita16Entity gravarVisita16(Visita16Entity visita16, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita16.getVisita().getIdVisita() == null || visita16.getVisita().getIdVisita() == 0){
			visita16.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita16.getVisita());
			this.factoryDao.getVisita16Dao().adiciona(visita16);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita16.getVisita());
			this.factoryDao.getVisita16Dao().altera(visita16);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita16.getVisita().getStAprovacao() != null && visita16.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita16.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita16.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita16.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita16;
	}
	
	/*visita17*/
	public Visita17Entity buscarVisita17ByIdPaciente(Long id) {
		Visita17Entity visita17 = this.factoryDao.getVisita17Dao().buscaVisitaByPaciente(id, 17);
		return visita17;
	}

	public Visita17Entity gravarVisita17(Visita17Entity visita17, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(visita17.getVisita().getIdVisita() == null || visita17.getVisita().getIdVisita() == 0){
			visita17.getVisita().setIdVisita(null);		
			this.factoryDao.getVisitaDao().adiciona(visita17.getVisita());
			this.factoryDao.getVisita17Dao().adiciona(visita17);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getVisitaDao().altera(visita17.getVisita());
			this.factoryDao.getVisita17Dao().altera(visita17);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
			if(visita17.getVisita().getStAprovacao() != null && visita17.getVisita().getStAprovacao().equals("A")){
				log.setTpModificacao(TipoModificacaoEnum.APROVACAO.getValue());	
			}
		}
		
		dsModificacao.append("Visita ").append(visita17.getVisita().getNuVisita());
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(visita17.getVisita().getPaciente().getIdPaciente());
		log.setPaciente(visita17.getVisita().getPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return visita17;
	}
	
	/*Adesão Tratamento*/
	public AdesaoTratamentoEntity buscarAdesaoTratamento(Long idVisita) {
		AdesaoTratamentoEntity adesaoTratamento = this.factoryDao.getAdesaoTratamentoDao().buscaQuestionarioByVisita(idVisita);
		return adesaoTratamento;
	}

	public AdesaoTratamentoEntity gravarAdesaoTratamento(AdesaoTratamentoEntity adesao) throws Exception {

		if(adesao.getIdAdesaoTratamento() == null || adesao.getIdAdesaoTratamento() == 0){	
			this.factoryDao.getAdesaoTratamentoDao().adiciona(adesao);
		}else{	
			this.factoryDao.getAdesaoTratamentoDao().altera(adesao);
		}
		
		return adesao;
	}
	
	/*Adesão Medicacao*/
	public AdesaoMedicacaoEntity buscarAdesaoMedicacao(Long idVisita) {
		AdesaoMedicacaoEntity adesaoMedicacao = this.factoryDao.getAdesaoMedicacaoDao().buscaQuestionarioByVisita(idVisita);
		return adesaoMedicacao;
	}

	public AdesaoMedicacaoEntity gravarAdesaoMedicacao(AdesaoMedicacaoEntity adesao) throws Exception {

		if(adesao.getIdMudancaMedicacao() == null || adesao.getIdMudancaMedicacao() == 0){	
			this.factoryDao.getAdesaoMedicacaoDao().adiciona(adesao);
		}else{	
			this.factoryDao.getAdesaoMedicacaoDao().altera(adesao);
		}
		
		return adesao;
	}
	
	public boolean validaVisitaAnterior(Long numVisita, Long idPaciente){
		boolean retorno = false;
		
		switch (numVisita.intValue()) {
			case 0:
				Visita00Entity visita00 = buscarVisita00ByIdPaciente(idPaciente);
				if(visita00 != null &&  visita00.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 1:
				Visita01Entity visita01 = buscarVisita01ByIdPaciente(idPaciente);
				if(visita01 != null &&  visita01.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 2:
				Visita02Entity visita02 = buscarVisita02ByIdPaciente(idPaciente);
				if(visita02 != null &&  visita02.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 3:
				Visita03Entity visita03 = buscarVisita03ByIdPaciente(idPaciente);
				if(visita03 != null &&  visita03.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 4:
				Visita04Entity visita04 = buscarVisita04ByIdPaciente(idPaciente);
				if(visita04 != null &&  visita04.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 5:
				Visita05Entity visita05 = buscarVisita05ByIdPaciente(idPaciente);
				if(visita05 != null &&  visita05.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 6:
				Visita06Entity visita06 = buscarVisita06ByIdPaciente(idPaciente);
				if(visita06 != null &&  visita06.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 7:
				Visita07Entity visita07 = buscarVisita07ByIdPaciente(idPaciente);
				if(visita07 != null &&  visita07.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 8:
				Visita08Entity visita08 = buscarVisita08ByIdPaciente(idPaciente);
				if(visita08 != null &&  visita08.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 9:
				Visita09Entity visita09 = buscarVisita09ByIdPaciente(idPaciente);
				if(visita09 != null &&  visita09.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 10:
				Visita10Entity visita10 = buscarVisita10ByIdPaciente(idPaciente);
				if(visita10 != null &&  visita10.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 11:
				Visita11Entity visita11 = buscarVisita11ByIdPaciente(idPaciente);
				if(visita11 != null &&  visita11.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 12:
				Visita12Entity visita12 = buscarVisita12ByIdPaciente(idPaciente);
				if(visita12 != null &&  visita12.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 13:
				Visita13Entity visita13 = buscarVisita13ByIdPaciente(idPaciente);
				if(visita13 != null &&  visita13.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 14:
				Visita14Entity visita14 = buscarVisita14ByIdPaciente(idPaciente);
				if(visita14 != null &&  visita14.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 15:
				Visita15Entity visita15 = buscarVisita15ByIdPaciente(idPaciente);
				if(visita15 != null &&  visita15.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 16:
				Visita16Entity visita16 = buscarVisita16ByIdPaciente(idPaciente);
				if(visita16 != null &&  visita16.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
			case 17:
				Visita17Entity visita17 = buscarVisita17ByIdPaciente(idPaciente);
				if(visita17 != null &&  visita17.getVisita().getIdVisita() != null){
					retorno = true;
				}
				break;
						
		}
		
		return retorno;
		
	}	
	
	public List<VisitaEntity> buscaVisitasRelatorio(Long idUnidade, Long idPaciente){
		
		return this.factoryDao.getVisitaDao().buscaVisitasRelatorio(idUnidade, idPaciente);
	}

	
}
