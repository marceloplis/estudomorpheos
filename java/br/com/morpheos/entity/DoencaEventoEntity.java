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
@Table(name="TbDoencaEvento")
@SequenceGenerator(name = "seq_doenca", sequenceName = "seq_doenca", allocationSize = 1)
public class DoencaEventoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_doenca")
	@Column
	private Long idDoencaEvento;
	
	@Column
	private String dsDoenca;
	
	@Column
	private String siglaDoenca;

	@Transient
	private boolean podeExcluir;
	
	public Long getIdDoencaEvento() {
		return idDoencaEvento;
	}

	public void setIdDoencaEvento(Long idDoencaEvento) {
		this.idDoencaEvento = idDoencaEvento;
	}

	public String getDsDoenca() {
		return dsDoenca;
	}

	public void setDsDoenca(String dsDoenca) {
		this.dsDoenca = dsDoenca;
	}

	public String getSiglaDoenca() {
		return siglaDoenca;
	}

	public void setSiglaDoenca(String siglaDoenca) {
		this.siglaDoenca = siglaDoenca;
	}

	public boolean isPodeExcluir() {
		return podeExcluir;
	}

	public void setPodeExcluir(boolean podeExcluir) {
		this.podeExcluir = podeExcluir;
	}	
	
	
}
