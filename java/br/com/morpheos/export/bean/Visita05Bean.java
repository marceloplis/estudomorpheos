package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita05Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Grupo Randomizado")
	private Long gruporandomizacao;
	
	@SheetHeader( name = "Qtd. Eventos")
	private Integer qtdEventos;

	@SheetHeader( name = "Latência início do sono")
	private String latencia;

	@SheetHeader( name = "TST")
	private String tst;

	@SheetHeader( name = "S1 (%)")
	private String pcs1;

	@SheetHeader( name = "S2 (%)")
	private String pcs2;

	@SheetHeader( name = "S3 (%)")
	private String pcs3;

	@SheetHeader( name = "REM (%)")
	private String pcsRem;

	@SheetHeader( name = "Arquitetura do Sono")
	private String arquitetura;
	
	@SheetHeader( name = "IAH")
	private String iah;

	@SheetHeader( name = "Sat O2 basal")
	private String sat02Basal;

	@SheetHeader( name = "Sat O2 média")
	private String satO2Media;

	@SheetHeader( name = "Sat O2 mínima")
	private String satO2Minima;

	@SheetHeader( name = "TS <90%")
	private String tsMenor90;
	
	@SheetHeader( name = "Arousals")
	private String arousals;
	
	@SheetHeader( name = "Pressão ideal CPAP (cm H2O)")
	private String pressaoCPAP;

	@SheetHeader( name = "Nasal")
	private String nasal;

	@SheetHeader( name = "Oronasal")
	private String oronasal;

	
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
	
	public Integer getQtdEventos() {
		return qtdEventos;
	}
	
	public void setQtdEventos(Integer qtdEventos) {
		this.qtdEventos = qtdEventos;
	}

	public String getLatencia() {
		return latencia;
	}

	public void setLatencia(String latencia) {
		this.latencia = latencia;
	}

	public String getTst() {
		return tst;
	}

	public void setTst(String tst) {
		this.tst = tst;
	}

	public String getPcs1() {
		return pcs1;
	}

	public void setPcs1(String pcs1) {
		this.pcs1 = pcs1;
	}

	public String getPcs2() {
		return pcs2;
	}

	public void setPcs2(String pcs2) {
		this.pcs2 = pcs2;
	}

	public String getPcs3() {
		return pcs3;
	}

	public void setPcs3(String pcs3) {
		this.pcs3 = pcs3;
	}

	public String getPcsRem() {
		return pcsRem;
	}

	public void setPcsRem(String pcsRem) {
		this.pcsRem = pcsRem;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public String getIah() {
		return iah;
	}

	public void setIah(String iah) {
		this.iah = iah;
	}

	public String getSat02Basal() {
		return sat02Basal;
	}

	public void setSat02Basal(String sat02Basal) {
		this.sat02Basal = sat02Basal;
	}

	public String getSatO2Media() {
		return satO2Media;
	}

	public void setSatO2Media(String satO2Media) {
		this.satO2Media = satO2Media;
	}

	public String getSatO2Minima() {
		return satO2Minima;
	}

	public void setSatO2Minima(String satO2Minima) {
		this.satO2Minima = satO2Minima;
	}

	public String getTsMenor90() {
		return tsMenor90;
	}

	public void setTsMenor90(String tsMenor90) {
		this.tsMenor90 = tsMenor90;
	}

	public String getArousals() {
		return arousals;
	}

	public void setArousals(String arousals) {
		this.arousals = arousals;
	}

	public String getPressaoCPAP() {
		return pressaoCPAP;
	}

	public void setPressaoCPAP(String pressaoCPAP) {
		this.pressaoCPAP = pressaoCPAP;
	}

	public String getNasal() {
		return nasal;
	}

	public void setNasal(String nasal) {
		this.nasal = nasal;
	}

	public String getOronasal() {
		return oronasal;
	}

	public void setOronasal(String oronasal) {
		this.oronasal = oronasal;
	}
	
}
