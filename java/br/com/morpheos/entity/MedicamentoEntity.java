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
import javax.persistence.Transient;

@Entity
@Table(name="TbMedicamento")
@SequenceGenerator(name = "seq_medicamento", sequenceName = "seq_medicamento", allocationSize = 1)
public class MedicamentoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicamentoEntity(){
		this.grpMedicamento = new GrupoMedicamentoEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_medicamento")
	@Column
	private Long idMedicamento;
	
	@Column
	private String dsMedicamento;
	
	@OneToOne
	@JoinColumn(name = "idGrupoMedicamento", referencedColumnName = "idGrupoMedicamento")	
	private GrupoMedicamentoEntity grpMedicamento;

	@Transient
	private boolean podeExcluir;
	
	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getDsMedicamento() {
		return dsMedicamento;
	}

	public void setDsMedicamento(String dsMedicamento) {
		this.dsMedicamento = dsMedicamento;
	}

	public GrupoMedicamentoEntity getGrpMedicamento() {
		return grpMedicamento;
	}

	public void setGrpMedicamento(GrupoMedicamentoEntity grpMedicamento) {
		this.grpMedicamento = grpMedicamento;
	}	
	
	public boolean isPodeExcluir() {
		return podeExcluir;
	}

	public void setPodeExcluir(boolean podeExcluir) {
		this.podeExcluir = podeExcluir;
	}	
	
	
}
