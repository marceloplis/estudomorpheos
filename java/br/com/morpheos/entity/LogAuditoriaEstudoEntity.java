package br.com.morpheos.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="TbAuditoriaEstudo")
@SequenceGenerator(name = "seq_logauditoria", sequenceName = "seq_logauditoria", allocationSize = 1)
public class LogAuditoriaEstudoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_logauditoria")
	@Column
	private Long idAuditoriaEstudo;
	
	@Transient
	private Long idPaciente;
	
	@Column
	private String username;
	
	@Column
	private String dsModificacao;
	
	@Column
	private String tpModificacao;
	
	@Column
	private String tpEntidade;
	
	@Column
	private Date dtModificacao;

	@OneToOne
	@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
	private PacienteEntity paciente;
	
	public PacienteEntity getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	
	public Long getIdAuditoriaEstudo() {
		return idAuditoriaEstudo;
	}

	public void setIdAuditoriaEstudo(Long idAuditoriaEstudo) {
		this.idAuditoriaEstudo = idAuditoriaEstudo;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDsModificacao() {
		return dsModificacao;
	}

	public void setDsModificacao(String dsModificacao) {
		this.dsModificacao = dsModificacao;
	}

	public String getTpModificacao() {
		return tpModificacao;
	}

	public void setTpModificacao(String tpModificacao) {
		this.tpModificacao = tpModificacao;
	}

	public String getTpEntidade() {
		return tpEntidade;
	}

	public void setTpEntidade(String tpEntidade) {
		this.tpEntidade = tpEntidade;
	}

	public Date getDtModificacao() {
		return dtModificacao;
	}
	
	public void setDtModificacao(Date dtModificacao) {
		this.dtModificacao = dtModificacao;
	}
	
}
