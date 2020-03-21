package br.com.morpheos.action.estudo.questionarios;

import java.util.List;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.GrupoMedicamentoEntity;
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

public class QuestionariosForm extends FormBase{

	private static final long serialVersionUID = 1L;
	
	private String tituloPagina;
	private Long idVisita;
	private Long nuVisita;
	private VisitaEntity visita;
	
	private QuestPressaoArterialEntity 	qpressaoarterial;
	private QuestMedicamentoUsoEntity 	qmedicamentouso;
	
	private QuestAplicacaoEntity 		qaplicacao;
	private QuestAtividadeFisicaEntity 	qatividadefisica;
	private QuestBerlimEntity 			qberlim;
	private QuestBioquimicaEntity 		qbioquimica;	
	private QuestCageEntity 			qcage;
	private QuestEcocardiogramaEntity 	qcardiograma;
	private QuestMapaEntity 			qmapa;	
	private QuestPoligrafiaEntity 		qpoligrafia;
	private QuestPolissonografiaEntity 	qpolissonografia;	
	private QuestSphygmocorEntity		qsphygmocor;	
	
	private List<GrupoMedicamentoEntity> 	grpsMedicamentos;
	private List<QuestMedicamentoUsoEntity> medicamentosUso;
	
	
	public String getTituloPagina() {
		return tituloPagina;
	}
	
	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}
	
	public Long getIdVisita() {
		return idVisita;
	}
	
	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	
	public Long getNuVisita() {
		return nuVisita;
	}
	
	public void setNuVisita(Long nuVisita) {
		this.nuVisita = nuVisita;
	}

	public VisitaEntity getVisita() {
		return visita;
	}

	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}

	public QuestAplicacaoEntity getQaplicacao() {
		return qaplicacao;
	}

	public void setQaplicacao(QuestAplicacaoEntity qaplicacao) {
		this.qaplicacao = qaplicacao;
	}

	public QuestAtividadeFisicaEntity getQatividadefisica() {
		return qatividadefisica;
	}

	public void setQatividadefisica(QuestAtividadeFisicaEntity qatividadefisica) {
		this.qatividadefisica = qatividadefisica;
	}

	public QuestBerlimEntity getQberlim() {
		return qberlim;
	}

	public void setQberlim(QuestBerlimEntity qberlim) {
		this.qberlim = qberlim;
	}

	public QuestBioquimicaEntity getQbioquimica() {
		return qbioquimica;
	}

	public void setQbioquimica(QuestBioquimicaEntity qbioquimica) {
		this.qbioquimica = qbioquimica;
	}

	public QuestCageEntity getQcage() {
		return qcage;
	}

	public void setQcage(QuestCageEntity qcage) {
		this.qcage = qcage;
	}

	public QuestEcocardiogramaEntity getQcardiograma() {
		return qcardiograma;
	}

	public void setQcardiograma(QuestEcocardiogramaEntity qcardiograma) {
		this.qcardiograma = qcardiograma;
	}

	public QuestMapaEntity getQmapa() {
		return qmapa;
	}

	public void setQmapa(QuestMapaEntity qmapa) {
		this.qmapa = qmapa;
	}

	public QuestMedicamentoUsoEntity getQmedicamentouso() {
		return qmedicamentouso;
	}

	public void setQmedicamentouso(QuestMedicamentoUsoEntity qmedicamentouso) {
		this.qmedicamentouso = qmedicamentouso;
	}

	public QuestPoligrafiaEntity getQpoligrafia() {
		return qpoligrafia;
	}

	public void setQpoligrafia(QuestPoligrafiaEntity qpoligrafia) {
		this.qpoligrafia = qpoligrafia;
	}

	public QuestPolissonografiaEntity getQpolissonografia() {
		return qpolissonografia;
	}

	public void setQpolissonografia(QuestPolissonografiaEntity qpolissonografia) {
		this.qpolissonografia = qpolissonografia;
	}

	public QuestPressaoArterialEntity getQpressaoarterial() {
		return qpressaoarterial;
	}

	public void setQpressaoarterial(QuestPressaoArterialEntity qpressaoarterial) {
		this.qpressaoarterial = qpressaoarterial;
	}

	public QuestSphygmocorEntity getQsphygmocor() {
		return qsphygmocor;
	}

	public void setQsphygmocor(QuestSphygmocorEntity qsphygmocor) {
		this.qsphygmocor = qsphygmocor;
	}
	
	public List<GrupoMedicamentoEntity> getGrpsMedicamentos() {
		return grpsMedicamentos;
	}
	
	public void setGrpsMedicamentos(
			List<GrupoMedicamentoEntity> grpsMedicamentos) {
		this.grpsMedicamentos = grpsMedicamentos;
	}
	
	public List<QuestMedicamentoUsoEntity> getMedicamentosUso() {
		return medicamentosUso;
	}
	
	public void setMedicamentosUso(
			List<QuestMedicamentoUsoEntity> medicamentosUso) {
		this.medicamentosUso = medicamentosUso;
	}
	
}
