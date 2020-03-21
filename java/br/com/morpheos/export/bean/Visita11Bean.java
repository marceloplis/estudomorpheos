package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita11Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Grupo Randomizado")
	private Long gruporandomizacao;

	@SheetHeader( name = "Adesão ao CPAP (%)")
	private Double mediaCPAP;

	@SheetHeader( name = "Adesão ao Dilatador Nasal (%)")
	private Double adesaoDilatador;
	
	@SheetHeader( name = "Braço")
	private String braco;

	@SheetHeader( name = "PA 1")
	private String pa01;

	@SheetHeader( name = "PA 2")
	private String pa02;

	@SheetHeader( name = "PA 3")
	private String pa03;

	@SheetHeader( name = "PA 4")
	private String pa04;

	@SheetHeader( name = "PA 5")
	private String pa05;

	@SheetHeader( name = "Média PA")
	private String mediaPA;

	@SheetHeader( name = "FC 1")
	private Long fc01;

	@SheetHeader( name = "FC 2")
	private Long fc02;

	@SheetHeader( name = "FC 3")
	private Long fc03;

	@SheetHeader( name = "FC 4")
	private Long fc04;

	@SheetHeader( name = "FC 5")
	private Long fc05;

	
	public String getNumeroPaciente() {
		return numeroPaciente;
	}

	public void setNumeroPaciente(String numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getIniciaisNome() {
		return iniciaisNome;
	}

	public void setIniciaisNome(String iniciaisNome) {
		this.iniciaisNome = iniciaisNome;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	public Long getGruporandomizacao() {
		return gruporandomizacao;
	}
	
	public void setGruporandomizacao(Long gruporandomizacao) {
		this.gruporandomizacao = gruporandomizacao;
	}

	public Double getMediaCPAP() {
		return mediaCPAP;
	}

	public void setMediaCPAP(Double mediaCPAP) {
		this.mediaCPAP = mediaCPAP;
	}

	public Double getAdesaoDilatador() {
		return adesaoDilatador;
	}

	public void setAdesaoDilatador(Double adesaoDilatador) {
		this.adesaoDilatador = adesaoDilatador;
	}

	public String getBraco() {
		return braco;
	}

	public void setBraco(String braco) {
		this.braco = braco;
	}

	public String getPa01() {
		return pa01;
	}

	public void setPa01(String pa01) {
		this.pa01 = pa01;
	}

	public String getPa02() {
		return pa02;
	}

	public void setPa02(String pa02) {
		this.pa02 = pa02;
	}

	public String getPa03() {
		return pa03;
	}

	public void setPa03(String pa03) {
		this.pa03 = pa03;
	}

	public String getPa04() {
		return pa04;
	}

	public void setPa04(String pa04) {
		this.pa04 = pa04;
	}

	public String getPa05() {
		return pa05;
	}

	public void setPa05(String pa05) {
		this.pa05 = pa05;
	}

	public String getMediaPA() {
		return mediaPA;
	}

	public void setMediaPA(String mediaPA) {
		this.mediaPA = mediaPA;
	}

	public Long getFc01() {
		return fc01;
	}

	public void setFc01(Long fc01) {
		this.fc01 = fc01;
	}

	public Long getFc02() {
		return fc02;
	}

	public void setFc02(Long fc02) {
		this.fc02 = fc02;
	}

	public Long getFc03() {
		return fc03;
	}

	public void setFc03(Long fc03) {
		this.fc03 = fc03;
	}

	public Long getFc04() {
		return fc04;
	}

	public void setFc04(Long fc04) {
		this.fc04 = fc04;
	}

	public Long getFc05() {
		return fc05;
	}

	public void setFc05(Long fc05) {
		this.fc05 = fc05;
	}
		
}
