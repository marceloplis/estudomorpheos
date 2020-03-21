package br.com.morpheos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TbQuestCAGE")
@SequenceGenerator(name = "seq_questcage", sequenceName = "seq_questcage", allocationSize = 1)
public class QuestCageEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestCageEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_questcage")
	@Column(name = "idQuestionarioCAGE")
	private Integer idQuestionarioCAGE;
	
	@Column(name = "PER_QC01")
	private String PER_QC01;
	
	@Column(name = "PER_QC02")
	private String PER_QC02;
	
	@Column(name = "PER_QC03")
	private String PER_QC03;
	
	@Column(name = "PER_QC04")
	private String PER_QC04;
	
	@Column(name = "flPositivo")
	private String flPositivo;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdQuestionarioCAGE() {
		return idQuestionarioCAGE;
	}

	public void setIdQuestionarioCAGE(Integer idQuestionarioCAGE) {
		this.idQuestionarioCAGE = idQuestionarioCAGE;
	}

	public String getPER_QC01() {
		return PER_QC01;
	}

	public void setPER_QC01(String pER_QC01) {
		PER_QC01 = pER_QC01;
	}

	public String getPER_QC02() {
		return PER_QC02;
	}

	public void setPER_QC02(String pER_QC02) {
		PER_QC02 = pER_QC02;
	}

	public String getPER_QC03() {
		return PER_QC03;
	}

	public void setPER_QC03(String pER_QC03) {
		PER_QC03 = pER_QC03;
	}

	public String getPER_QC04() {
		return PER_QC04;
	}

	public void setPER_QC04(String pER_QC04) {
		PER_QC04 = pER_QC04;
	}
	
	public String getFlPositivo() {
		return flPositivo;
	}
	public void setFlPositivo(String flPositivo) {
		this.flPositivo = flPositivo;
	}


}
