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

import br.com.morpheos.util.Utils;

@Entity
@Table(name = "TbSaidaEstudo")
@SequenceGenerator(name = "seq_saida", sequenceName = "seq_saida", allocationSize = 1)
public class SaidaEstudoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SaidaEstudoEntity(){
		this.paciente = new PacienteEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_saida")
	@Column(name = "idSaidaEstudo")
	private Integer idSaidaEstudo;
	
	@Column(name = "dtInclusao")
	private Date dtInclusao;
	
	@Column(name = "dtSaida")
	private Date dtSaida;
	@Transient
	private String dtSaidaParse;
	
	@Column(name = "dtOcorrencia")
	private Date dtOcorrencia;
	@Transient
	private String dtOcorrenciaParse;
	
	@Column
	private Integer nuVisita;

	@Column
	private Integer motivo;
	
	@Column
	private String stAprovacao;

	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "flEvolucaoObito")
	private String flEvolucaoObito;
	
	@Column(name = "assinatura")
	private String assinatura;
	
	@Column(name = "dtAssinatura")
	private Date dtAssinatura;

	@OneToOne
	@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
	private PacienteEntity paciente;

	public Integer getIdSaidaEstudo() {
		return idSaidaEstudo;
	}

	public void setIdSaidaEstudo(Integer idSaidaEstudo) {
		this.idSaidaEstudo = idSaidaEstudo;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Date getDtOcorrencia() {
		return dtOcorrencia;
	}

	public void setDtOcorrencia(Date dtOcorrencia) {
		this.dtOcorrencia = dtOcorrencia;
	}

	public Integer getNuVisita() {
		return nuVisita;
	}

	public void setNuVisita(Integer nuVisita) {
		this.nuVisita = nuVisita;
	}

	public Integer getMotivo() {
		return motivo;
	}

	public void setMotivo(Integer motivo) {
		this.motivo = motivo;
	}

	public String getStAprovacao() {
		return stAprovacao;
	}

	public void setStAprovacao(String stAprovacao) {
		this.stAprovacao = stAprovacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFlEvolucaoObito() {
		return flEvolucaoObito;
	}

	public void setFlEvolucaoObito(String flEvolucaoObito) {
		this.flEvolucaoObito = flEvolucaoObito;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}

	public Date getDtAssinatura() {
		return dtAssinatura;
	}

	public void setDtAssinatura(Date dtAssinatura) {
		this.dtAssinatura = dtAssinatura;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	
	public String getDtSaidaParse() {  
		if (getDtSaida()!= null)     
			dtSaidaParse =  Utils.converteDataString(getDtSaida());  
		return dtSaidaParse ;  
	}  
	  
	public void setDtSaidaParse(String string) {  
		dtSaidaParse = string;  
	    if ( (dtSaidaParse != null) && (!dtSaidaParse .equals("")) )      
	    	setDtSaida(Utils.converteData(dtSaidaParse));  
	}
	
	public String getDtOcorrenciaParse() {  
		if (getDtOcorrencia()!= null)     
			dtOcorrenciaParse =  Utils.converteDataString(getDtOcorrencia() );  
		return dtOcorrenciaParse ;  
	}  
	  
	public void setDtOcorrenciaParse(String string) {  
		dtOcorrenciaParse = string;  
	    if ( (dtOcorrenciaParse != null) && (!dtOcorrenciaParse .equals("")) )      
	    	setDtOcorrencia(Utils.converteData(dtOcorrenciaParse ));  
	}
	
	
	
}
