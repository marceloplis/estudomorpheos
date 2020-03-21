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
@Table(name = "TbQuestMedicamentoUso")
@SequenceGenerator(name = "seq_medicamentouso", sequenceName = "seq_medicamentouso", allocationSize = 1)
public class QuestMedicamentoUsoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestMedicamentoUsoEntity(){
		this.medicamento = new MedicamentoEntity();
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_medicamentouso")
	@Column(name = "idVisitaMedicamentoUso")
	private Long idVisitaMedicamentoUso;
	
	@Column(name = "dose")
	private String dose;
	
	@Column(name = "posologia")
	private String posologia;
	
	@Column(name = "observacao")
	private String observacao;

	@OneToOne
	@JoinColumn(name = "idMedicamento", referencedColumnName = "idMedicamento")
	private MedicamentoEntity medicamento;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public MedicamentoEntity getMedicamento() {
		return medicamento;
	}
	
	public void setMedicamento(MedicamentoEntity medicamento) {
		this.medicamento = medicamento;
	}
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Long getIdVisitaMedicamentoUso() {
		return idVisitaMedicamentoUso;
	}

	public void setIdVisitaMedicamentoUso(Long idVisitaMedicamentoUso) {
		this.idVisitaMedicamentoUso = idVisitaMedicamentoUso;
	}	

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
