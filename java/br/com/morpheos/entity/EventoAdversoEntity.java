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
@Table(name = "TbEventoAdverso")
@SequenceGenerator(name = "seq_evento", sequenceName = "seq_evento", allocationSize = 1)
public class EventoAdversoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EventoAdversoEntity(){
		this.paciente = new PacienteEntity();
		this.doenca = new DoencaEventoEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_evento")
	@Column(name = "idEventoAdverso")
	private Long idEventoAdverso;
		
	@Column(name = "dtInclusao")
	private Date dtInclusao;
	
	@Column(name = "dtInicio")
	private Date dtInicio;
	@Transient
	private String dtInicioParse;
	
	@Column(name = "dtFim")
	private Date dtFim;
	@Transient
	private String dtFimParse;
	
	@Column
	private Integer nuVisita;
	
	@Column(name = "PER_E01")
	private String PER_E01;
	
	@Column(name = "PER_E02")
	private String PER_E02;
	
	@Column(name = "PER_E03")
	private String PER_E03;
	
	@Column(name = "PER_E04")
	private String PER_E04;	
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column
	private String stAprovacao;
	
	@Column(name = "assinatura")
	private String assinatura;
	
	@Column(name = "dtAssinatura")
	private Date dtAssinatura;
	
	@OneToOne
	@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
	private PacienteEntity paciente;
	
	@OneToOne
	@JoinColumn(name = "idDoenca", referencedColumnName = "idDoencaEvento")
	private DoencaEventoEntity doenca;
	
	public PacienteEntity getPaciente() {
		return paciente;
	}
	
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	
	public DoencaEventoEntity getDoenca() {
		return doenca;
	}
	
	public void setDoenca(DoencaEventoEntity doenca) {
		this.doenca = doenca;
	}
	
	public Long getIdEventoAdverso() {
		return idEventoAdverso;
	}

	public void setIdEventoAdverso(Long idEventoAdverso) {
		this.idEventoAdverso = idEventoAdverso;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	
	public Integer getNuVisita() {
		return nuVisita;
	}
	public void setNuVisita(Integer nuVisita) {
		this.nuVisita = nuVisita;
	}

	public String getPER_E01() {
		return PER_E01;
	}

	public void setPER_E01(String pER_E01) {
		PER_E01 = pER_E01;
	}

	public String getPER_E02() {
		return PER_E02;
	}

	public void setPER_E02(String pER_E02) {
		PER_E02 = pER_E02;
	}

	public String getPER_E03() {
		return PER_E03;
	}

	public void setPER_E03(String pER_E03) {
		PER_E03 = pER_E03;
	}

	public String getPER_E04() {
		return PER_E04;
	}

	public void setPER_E04(String pER_E04) {
		PER_E04 = pER_E04;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getDtInicioParse() {  
		if (getDtInicio()!= null)     
			dtInicioParse =  Utils.converteDataString(getDtInicio());  
		return dtInicioParse ;  
	}  
	  
	public void setDtInicioParse(String string) {  
		dtInicioParse = string;  
	    if ( (dtInicioParse != null) && (!dtInicioParse .equals("")) )      
	    	setDtInicio(Utils.converteData(dtInicioParse));  
	}
	
	public String getDtFimParse() {  
		if (getDtFim()!= null)     
			dtFimParse =  Utils.converteDataString(getDtFim() );  
		return dtFimParse ;  
	}  
	  
	public void setDtFimParse(String string) {  
		dtFimParse = string;  
	    if ( (dtFimParse != null) && (!dtFimParse .equals("")) )      
	    	setDtFim(Utils.converteData(dtFimParse ));  
	}

	public String getStAprovacao() {
		return stAprovacao;
	}

	public void setStAprovacao(String stAprovacao) {
		this.stAprovacao = stAprovacao;
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
	
	
}
