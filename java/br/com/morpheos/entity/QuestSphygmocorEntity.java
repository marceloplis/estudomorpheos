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
@Table(name = "TbQuestSphygmocor")
@SequenceGenerator(name = "seq_sphygmocor", sequenceName = "seq_sphygmocor", allocationSize = 1)
public class QuestSphygmocorEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestSphygmocorEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_sphygmocor")
	@Column(name = "idSphygmocor")
	private Integer idSphygmocor;
	
	@Column(name = "PAS")
	private String PAS;
	
	@Column(name = "PAD")
	private String PAD;
	
	@Column(name = "PPC")
	private String PPC;
	
	@Column(name = "ALX")
	private String ALX;
	
	@Column(name = "ALX75")
	private String ALX75;
	
	@Column(name = "observacao")	
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdSphygmocor() {
		return idSphygmocor;
	}
	public void setIdSphygmocor(Integer idSphygmocor) {
		this.idSphygmocor = idSphygmocor;
	}
	
	public String getPAS() {
		return PAS;
	}
	public void setPAS(String pAS) {
		PAS = pAS;
	}
	public String getPAD() {
		return PAD;
	}
	public void setPAD(String pAD) {
		PAD = pAD;
	}
	public String getPPC() {
		return PPC;
	}
	public void setPPC(String pPC) {
		PPC = pPC;
	}
	public String getALX() {
		return ALX;
	}
	public void setALX(String aLX) {
		ALX = aLX;
	}
	public String getALX75() {
		return ALX75;
	}
	public void setALX75(String aLX75) {
		ALX75 = aLX75;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
