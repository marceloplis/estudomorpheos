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
@Table(name="TbVisita")
@SequenceGenerator(name = "seq_visita", sequenceName = "seq_visita", allocationSize = 1)
public class VisitaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VisitaEntity(){
		this.paciente = new PacienteEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita")
	@Column
	private Long idVisita;
	
	@Column(name = "nuVisita")
	private Integer nuVisita;	
	
	@Column(name = "dtInclusao")
	private Date dtInclusao; 
	
	@Column(name = "dtRealizacao")
	private Date dtRealizacao;
	@Transient
	private String dtRealizacaoParse;
	
	@Column(name = "assinaturaAprovador")
	private String assinaturaAprovador;
	
	@Column(name = "dtAssinaturaAprovacao")
	private Date dtAssinaturaAprovacao;

	@Column(name = "stAprovacao")
	private String stAprovacao;
	
	@OneToOne
	@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
	private PacienteEntity paciente;
	
	@Transient
	private int has_questaplic;
	@Transient
	private int has_questaticfis;
	@Transient
	private int has_questberl;
	@Transient
	private int has_questbioq;
	@Transient
	private int has_questcage;
	@Transient
	private int has_questeco;
	@Transient
	private int has_questmapa;
	@Transient
	private int has_questmedic;
	@Transient
	private int has_questpolig;
	@Transient
	private int has_questpoliss;
	@Transient
	private int has_questpressao;
	@Transient
	private int has_questsphy;  

	
	
	public Long getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}

	public Integer getNuVisita() {
		return nuVisita;
	}

	public void setNuVisita(Integer nuVisita) {
		this.nuVisita = nuVisita;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtRealizacao() {
		return dtRealizacao;
	}

	public void setDtRealizacao(Date dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}
	
	public String getDtRealizacaoParse() {  
		if (getDtRealizacao()!= null)     
			dtRealizacaoParse =  Utils.converteDataString(getDtRealizacao());  
		return dtRealizacaoParse ;  
	}  
	  
	public void setDtRealizacaoParse(String string) {  
		dtRealizacaoParse = string;  
	    if ( (dtRealizacaoParse != null) && (!dtRealizacaoParse .equals("")) )      
	    	setDtRealizacao(Utils.converteData(dtRealizacaoParse));  
	}

	public String getAssinaturaAprovador() {
		return assinaturaAprovador;
	}

	public void setAssinaturaAprovador(String assinaturaAprovador) {
		this.assinaturaAprovador = assinaturaAprovador;
	}

	public Date getDtAssinaturaAprovacao() {
		return dtAssinaturaAprovacao;
	}

	public void setDtAssinaturaAprovacao(Date dtAssinaturaAprovacao) {
		this.dtAssinaturaAprovacao = dtAssinaturaAprovacao;
	}
	
	public String getStAprovacao() {
		return stAprovacao;
	}
	
	public void setStAprovacao(String stAprovacao) {
		this.stAprovacao = stAprovacao;
	}
	
	public PacienteEntity getPaciente() {
		return paciente;
	}
	
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	
	public int getHas_questaplic() {
		return has_questaplic;
	}

	public void setHas_questaplic(int has_questaplic) {
		this.has_questaplic = has_questaplic;
	}

	public int getHas_questaticfis() {
		return has_questaticfis;
	}

	public void setHas_questaticfis(int has_questaticfis) {
		this.has_questaticfis = has_questaticfis;
	}

	public int getHas_questberl() {
		return has_questberl;
	}

	public void setHas_questberl(int has_questberl) {
		this.has_questberl = has_questberl;
	}

	public int getHas_questbioq() {
		return has_questbioq;
	}

	public void setHas_questbioq(int has_questbioq) {
		this.has_questbioq = has_questbioq;
	}

	public int getHas_questcage() {
		return has_questcage;
	}

	public void setHas_questcage(int has_questcage) {
		this.has_questcage = has_questcage;
	}

	public int getHas_questeco() {
		return has_questeco;
	}

	public void setHas_questeco(int has_questeco) {
		this.has_questeco = has_questeco;
	}

	public int getHas_questmapa() {
		return has_questmapa;
	}

	public void setHas_questmapa(int has_questmapa) {
		this.has_questmapa = has_questmapa;
	}

	public int getHas_questmedic() {
		return has_questmedic;
	}

	public void setHas_questmedic(int has_questmedic) {
		this.has_questmedic = has_questmedic;
	}

	public int getHas_questpolig() {
		return has_questpolig;
	}

	public void setHas_questpolig(int has_questpolig) {
		this.has_questpolig = has_questpolig;
	}

	public int getHas_questpoliss() {
		return has_questpoliss;
	}

	public void setHas_questpoliss(int has_questpoliss) {
		this.has_questpoliss = has_questpoliss;
	}

	public int getHas_questpressao() {
		return has_questpressao;
	}

	public void setHas_questpressao(int has_questpressao) {
		this.has_questpressao = has_questpressao;
	}

	public int getHas_questsphy() {
		return has_questsphy;
	}

	public void setHas_questsphy(int has_questsphy) {
		this.has_questsphy = has_questsphy;
	}	
	
	
}
