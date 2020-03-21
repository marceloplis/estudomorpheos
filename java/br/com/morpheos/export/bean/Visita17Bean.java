package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita17Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Grupo Randomizado")
	private Long gruporandomizacao;

	@SheetHeader( name = "Local")
	private String local;

	@SheetHeader( name = "IAH")
	private String iah;

	@SheetHeader( name = "Sat O2 basal")
	private String satO2Basal;

	@SheetHeader( name = "Sat O2 média")
	private String satO2Media;

	@SheetHeader( name = "Sat O2 mínima")
	private String satO2Minima;

	@SheetHeader( name = "TS <90%")
	private String tsMenor90;
	
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

	@SheetHeader( name = "IAH")
	private String iahPolis;

	@SheetHeader( name = "Sat O2 basal")
	private String sat02BasalPolis;

	@SheetHeader( name = "Sat O2 média")
	private String satO2MediaPolis;

	@SheetHeader( name = "Sat O2 mínima")
	private String satO2MinimaPolis;

	@SheetHeader( name = "TS <90%")
	private String tsMenor90Polis;

	@SheetHeader( name = "Arousals")
	private String arousals;

	
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getIah() {
		return iah;
	}

	public void setIah(String iah) {
		this.iah = iah;
	}

	public String getSatO2Basal() {
		return satO2Basal;
	}

	public void setSatO2Basal(String satO2Basal) {
		this.satO2Basal = satO2Basal;
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

	public String getLatencia() {
		return latencia;
	}

	public void setLatencia(String latencia) {
		this.latencia = latencia;
	}
	
	public Integer getQtdEventos() {
		return qtdEventos;
	}
	
	public void setQtdEventos(Integer qtdEventos) {
		this.qtdEventos = qtdEventos;
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

	public String getIahPolis() {
		return iahPolis;
	}

	public void setIahPolis(String iahPolis) {
		this.iahPolis = iahPolis;
	}

	public String getSat02BasalPolis() {
		return sat02BasalPolis;
	}

	public void setSat02BasalPolis(String sat02BasalPolis) {
		this.sat02BasalPolis = sat02BasalPolis;
	}

	public String getSatO2MediaPolis() {
		return satO2MediaPolis;
	}

	public void setSatO2MediaPolis(String satO2MediaPolis) {
		this.satO2MediaPolis = satO2MediaPolis;
	}

	public String getSatO2MinimaPolis() {
		return satO2MinimaPolis;
	}

	public void setSatO2MinimaPolis(String satO2MinimaPolis) {
		this.satO2MinimaPolis = satO2MinimaPolis;
	}

	public String getTsMenor90Polis() {
		return tsMenor90Polis;
	}

	public void setTsMenor90Polis(String tsMenor90Polis) {
		this.tsMenor90Polis = tsMenor90Polis;
	}

	public String getArousals() {
		return arousals;
	}

	public void setArousals(String arousals) {
		this.arousals = arousals;
	}

}
