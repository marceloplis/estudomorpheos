package br.com.morpheos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TbGrupoMedicamento")
@SequenceGenerator(name = "seq_grpmedicamento", sequenceName = "seq_grpmedicamento", allocationSize = 1)
public class GrupoMedicamentoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_grpmedicamento")
	@Column
	private Long idGrupoMedicamento;
	
	@Column
	private String dsGrupoMedicamento;

	@Transient
	private boolean podeExcluir;
	
	public Long getIdGrupoMedicamento() {
		return idGrupoMedicamento;
	}

	public void setIdGrupoMedicamento(Long idGrupoMedicamento) {
		this.idGrupoMedicamento = idGrupoMedicamento;
	}

	public String getDsGrupoMedicamento() {
		return dsGrupoMedicamento;
	}

	public void setDsGrupoMedicamento(String dsGrupoMedicamento) {
		this.dsGrupoMedicamento = dsGrupoMedicamento;
	}
	
	public boolean isPodeExcluir() {
		return podeExcluir;
	}

	public void setPodeExcluir(boolean podeExcluir) {
		this.podeExcluir = podeExcluir;
	}	
	
	
}
