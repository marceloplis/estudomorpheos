package br.com.morpheos.controller;

import java.util.List;

import br.com.morpheos.dao.common.FactoryDao;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;
import br.com.morpheos.entity.QuestAplicacaoEntity;
import br.com.morpheos.entity.QuestAtividadeFisicaEntity;
import br.com.morpheos.entity.QuestBerlimEntity;
import br.com.morpheos.entity.QuestBioquimicaEntity;
import br.com.morpheos.entity.QuestCageEntity;
import br.com.morpheos.entity.QuestEcocardiogramaEntity;
import br.com.morpheos.entity.QuestMapaEntity;
import br.com.morpheos.entity.QuestMedicamentoUsoEntity;
import br.com.morpheos.entity.QuestPoligrafiaEntity;
import br.com.morpheos.entity.QuestPolissonografiaEntity;
import br.com.morpheos.entity.QuestPressaoArterialEntity;
import br.com.morpheos.entity.QuestSphygmocorEntity;
import br.com.morpheos.entity.VisitaEntity;
import br.com.morpheos.enums.TipoEntidadeEnum;
import br.com.morpheos.enums.TipoModificacaoEnum;

public class QuestionariosController {

	private final FactoryDao factoryDao;	
	private final LogAuditoriaController logController;
	
	public QuestionariosController(){
		this.factoryDao = new FactoryDao();
		this.logController = new LogAuditoriaController();
	}	
	

	/*Busca Visita*/
	public VisitaEntity buscarVisita(Long idVisita) {
		VisitaEntity visita = this.factoryDao.getVisitaDao().buscaVisita(idVisita);
		return visita;
	}
	
	/*Pressao Arterial*/
	public QuestPressaoArterialEntity buscaQuestPressaoArterial(Long idVisita){
		QuestPressaoArterialEntity qpressaoarterial = this.factoryDao.getPressaoArterialDao().buscaQuestionarioByVisita(idVisita);
		return qpressaoarterial;
	}
	
	public QuestPressaoArterialEntity gravarQuestPressaoArterial(QuestPressaoArterialEntity qpressaoarterial, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qpressaoarterial.getIdPressaoArterial() == null || qpressaoarterial.getIdPressaoArterial() == 0){	
			this.factoryDao.getPressaoArterialDao().adiciona(qpressaoarterial);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getPressaoArterialDao().altera(qpressaoarterial);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qpressaoarterial.getVisita().getNuVisita()).append(" | Medidas da Pressão Arterial");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qpressaoarterial.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qpressaoarterial;
	}
	
	
	/*Medicacao em Uso*/
	public QuestMedicamentoUsoEntity buscaMedicamentoUso(Long idVisitaMedicamentoUso){
		QuestMedicamentoUsoEntity qmedicamentouso = this.factoryDao.getMedicamentoUsoDao().procura(idVisitaMedicamentoUso);
		return qmedicamentouso;
	}
	
	public void excluiMedicamentoUso(QuestMedicamentoUsoEntity med){
		this.factoryDao.getMedicamentoUsoDao().remove(med);
	}
	
	public List<QuestMedicamentoUsoEntity> buscaMedicamentosUso(Long idVisita){
		List<QuestMedicamentoUsoEntity> medicamentosuso = this.factoryDao.getMedicamentoUsoDao().buscaMedicamentosUsoByVisita(idVisita);
		return medicamentosuso;
	}
	
	public QuestMedicamentoUsoEntity gravarQuestMedicamentoUso(QuestMedicamentoUsoEntity qmedicamentouso, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qmedicamentouso.getIdVisitaMedicamentoUso() == null || qmedicamentouso.getIdVisitaMedicamentoUso() == 0){	
			this.factoryDao.getMedicamentoUsoDao().adiciona(qmedicamentouso);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getMedicamentoUsoDao().altera(qmedicamentouso);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qmedicamentouso.getVisita().getNuVisita()).append(" | Medicações em Uso");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qmedicamentouso.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qmedicamentouso;
	}
	
	
	/*Aplicacao*/
	public QuestAplicacaoEntity buscaQuestAplicacao(Long idVisita){
		QuestAplicacaoEntity qaplicacao = this.factoryDao.getQuestionarioAplicacaoDao().buscaQuestionarioByVisita(idVisita);
		return qaplicacao;
	}
	
	public QuestAplicacaoEntity gravarQuestAplicacao(QuestAplicacaoEntity qaplicacao, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qaplicacao.getIdQuestionarioAplicacao() == null || qaplicacao.getIdQuestionarioAplicacao() == 0){	
			this.factoryDao.getQuestionarioAplicacaoDao().adiciona(qaplicacao);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getQuestionarioAplicacaoDao().altera(qaplicacao);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qaplicacao.getVisita().getNuVisita()).append(" | Questionário de Aplicação");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qaplicacao.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qaplicacao;
	}
	
	
	/*Berlim*/
	public QuestBerlimEntity buscaQuestBerlim(Long idVisita){
		QuestBerlimEntity qberlim = this.factoryDao.getQuestionarioBerlimDao().buscaQuestionarioByVisita(idVisita);
		return qberlim;
	}
	
	public QuestBerlimEntity gravarQuestBerlim(QuestBerlimEntity qberlim, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qberlim.getIdQuestionarioBerlim() == null || qberlim.getIdQuestionarioBerlim() == 0){	
			this.factoryDao.getQuestionarioBerlimDao().adiciona(qberlim);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getQuestionarioBerlimDao().altera(qberlim);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qberlim.getVisita().getNuVisita()).append(" | Berlim");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qberlim.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qberlim;
	}
	
	
	/*CAGE*/
	public QuestCageEntity buscaQuestCage(Long idVisita){
		QuestCageEntity qcage = this.factoryDao.getQuestionarioCageDao().buscaQuestionarioByVisita(idVisita);
		return qcage;
	}
	
	public QuestCageEntity gravarQuestCage(QuestCageEntity qcage, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qcage.getIdQuestionarioCAGE() == null || qcage.getIdQuestionarioCAGE() == 0){	
			this.factoryDao.getQuestionarioCageDao().adiciona(qcage);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getQuestionarioCageDao().altera(qcage);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qcage.getVisita().getNuVisita()).append(" | Questionário CAGE");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qcage.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qcage;
	}
	
	
	
	/*Atividade Física*/
	public QuestAtividadeFisicaEntity buscaQuestAtividadeFisica(Long idVisita){
		QuestAtividadeFisicaEntity qatividadefisica = this.factoryDao.getQuestionarioInternacionalDao().buscaQuestionarioByVisita(idVisita);
		return qatividadefisica;
	}
	
	public QuestAtividadeFisicaEntity gravarQuestAtividadeFisica(QuestAtividadeFisicaEntity qatividadefisica, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qatividadefisica.getIdQuestionarioInternacional() == null || qatividadefisica.getIdQuestionarioInternacional() == 0){	
			this.factoryDao.getQuestionarioInternacionalDao().adiciona(qatividadefisica);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getQuestionarioInternacionalDao().altera(qatividadefisica);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qatividadefisica.getVisita().getNuVisita()).append(" | Questionário Internacional de Atividade Física");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qatividadefisica.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qatividadefisica;
	}
		
	
	
	/*MAPA*/
	public QuestMapaEntity buscaQuestMapa(Long idVisita){
		QuestMapaEntity qmapa = this.factoryDao.getQuestionarioMapaDao().buscaQuestionarioByVisita(idVisita);
		return qmapa;
	}
	
	public QuestMapaEntity gravarQuestMapa(QuestMapaEntity qmapa, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qmapa.getIdQuestionarioMAPA() == null || qmapa.getIdQuestionarioMAPA() == 0){	
			this.factoryDao.getQuestionarioMapaDao().adiciona(qmapa);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getQuestionarioMapaDao().altera(qmapa);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qmapa.getVisita().getNuVisita()).append(" | MAPA");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qmapa.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qmapa;
	}
	
	
	
	/*Poligrafia*/
	public QuestPoligrafiaEntity buscaQuestPoligrafia(Long idVisita){
		QuestPoligrafiaEntity qaplicacao = this.factoryDao.getPoligrafiaDao().buscaQuestionarioByVisita(idVisita);
		return qaplicacao;
	}
	
	public QuestPoligrafiaEntity gravarQuestPoligrafia(QuestPoligrafiaEntity qaplicacao, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qaplicacao.getIdPoligrafia() == null || qaplicacao.getIdPoligrafia() == 0){	
			this.factoryDao.getPoligrafiaDao().adiciona(qaplicacao);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getPoligrafiaDao().altera(qaplicacao);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qaplicacao.getVisita().getNuVisita()).append(" | Poligrafia");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qaplicacao.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qaplicacao;
	}
	
	
	
	/*Polissonografia*/
	public QuestPolissonografiaEntity buscaQuestPolissonografia(Long idVisita){
		QuestPolissonografiaEntity qpolissonografia = this.factoryDao.getPolissonografiaDao().buscaQuestionarioByVisita(idVisita);
		return qpolissonografia;
	}
	
	public QuestPolissonografiaEntity gravarQuestPolissonografia(QuestPolissonografiaEntity qpolissonografia, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qpolissonografia.getIdPolissonografia() == null || qpolissonografia.getIdPolissonografia() == 0){	
			this.factoryDao.getPolissonografiaDao().adiciona(qpolissonografia);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getPolissonografiaDao().altera(qpolissonografia);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qpolissonografia.getVisita().getNuVisita()).append(" | Polissonografia");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qpolissonografia.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qpolissonografia;
	}
	
	
	
	/*Ecocardiograma*/
	public QuestEcocardiogramaEntity buscaQuestEcocardiograma(Long idVisita){
		QuestEcocardiogramaEntity qecocardiograma = this.factoryDao.getEcocardiogramaDao().buscaQuestionarioByVisita(idVisita);
		return qecocardiograma;
	}
	
	public QuestEcocardiogramaEntity gravarQuestEcocardiograma(QuestEcocardiogramaEntity qecocardiograma, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qecocardiograma.getIdEcocardiograma() == null || qecocardiograma.getIdEcocardiograma() == 0){	
			this.factoryDao.getEcocardiogramaDao().adiciona(qecocardiograma);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getEcocardiogramaDao().altera(qecocardiograma);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qecocardiograma.getVisita().getNuVisita()).append(" | Ecocardiograma Transtorácico");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qecocardiograma.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qecocardiograma;
	}
	
	
	/*Bioquimica*/
	public QuestBioquimicaEntity buscaQuestBioquimica(Long idVisita){
		QuestBioquimicaEntity qbioquimica = this.factoryDao.getBioquimicaDao().buscaQuestionarioByVisita(idVisita);
		return qbioquimica;
	}
	
	public QuestBioquimicaEntity gravarQuestBioquimica(QuestBioquimicaEntity qbioquimica, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qbioquimica.getIdBioquimica() == null || qbioquimica.getIdBioquimica() == 0){	
			this.factoryDao.getBioquimicaDao().adiciona(qbioquimica);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getBioquimicaDao().altera(qbioquimica);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qbioquimica.getVisita().getNuVisita()).append(" | Amostras de Laboratório");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qbioquimica.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qbioquimica;
	}	
	
	
	/*Sphygmocor*/
	public QuestSphygmocorEntity buscaQuestSphygmocor(Long idVisita){
		QuestSphygmocorEntity qsphygmocor = this.factoryDao.getSphygmocorDao().buscaQuestionarioByVisita(idVisita);
		return qsphygmocor;
	}
	
	public QuestSphygmocorEntity gravarQuestSphygmocor(QuestSphygmocorEntity qsphygmocor, String username) throws Exception {

		LogAuditoriaEstudoEntity log = new LogAuditoriaEstudoEntity();
		log.setTpEntidade(TipoEntidadeEnum.VISITA.getValue());
		
		StringBuilder dsModificacao = new StringBuilder();
		
		if(qsphygmocor.getIdSphygmocor() == null || qsphygmocor.getIdSphygmocor() == 0){	
			this.factoryDao.getSphygmocorDao().adiciona(qsphygmocor);
			log.setTpModificacao(TipoModificacaoEnum.INCLUSAO.getValue());
		}else{	
			this.factoryDao.getSphygmocorDao().altera(qsphygmocor);
			log.setTpModificacao(TipoModificacaoEnum.ALTERACAO.getValue());	
		}
		
		dsModificacao.append("Visita ").append(qsphygmocor.getVisita().getNuVisita()).append(" | Sphygmocor");
		
		log.setDsModificacao(dsModificacao.toString());
		log.setUsername(username);
		log.setIdPaciente(qsphygmocor.getVisita().getPaciente().getIdPaciente());
		logController.gravaLogAuditoriaEstudo(log);
		
		return qsphygmocor;
	}
	
	
	
}
