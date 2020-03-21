package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita03Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;

	@SheetHeader( name = "PAS 24h")
	private String pas24;
	
	@SheetHeader( name = "PAD 24h")
	private String pad24;
	
	@SheetHeader( name = "PAM 24h")
	private String pam24;
	
	@SheetHeader( name = "FC 24h")
	private String fc24;
	
	@SheetHeader( name = "PAS Vigília")
	private String pasVigilia;
	
	@SheetHeader( name = "PAD Vigília")
	private String padVigilia;
	
	@SheetHeader( name = "PAM Vigília")
	private String pamVigilia;
	
	@SheetHeader( name = "FC Vigília")
	private String fcVigilia;
	
	@SheetHeader( name = "PAS Sono")
	private String pasSono;
	
	@SheetHeader( name = "PAD Sono")
	private String padSono;
	
	@SheetHeader( name = "PAM Sono")
	private String pamSono;
	
	@SheetHeader( name = "FC Sono")
	private String fcSono;
	
	@SheetHeader( name = "PAS Min Sono")
	private String pasMinSono;
	
	@SheetHeader( name = "PAD Min Sono")
	private String padMinSono;
	
	@SheetHeader( name = "PAM Min Sono")
	private String pamMinSono;
	
	@SheetHeader( name = "PAS 2h Acordar")
	private String pas2Acordar;
	
	@SheetHeader( name = "PAD 2h Acordar")
	private String pad2Acordar;
	
	@SheetHeader( name = "PAM 2h Acordar")
	private String pam2Acordar;
	
	@SheetHeader( name = "Hora de início")
	private String horaInicio;
	
	@SheetHeader( name = "Hora de término")
	private String horaTermino;

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

	public String getPas24() {
		return pas24;
	}

	public void setPas24(String pas24) {
		this.pas24 = pas24;
	}

	public String getPad24() {
		return pad24;
	}

	public void setPad24(String pad24) {
		this.pad24 = pad24;
	}

	public String getPam24() {
		return pam24;
	}

	public void setPam24(String pam24) {
		this.pam24 = pam24;
	}

	public String getFc24() {
		return fc24;
	}

	public void setFc24(String fc24) {
		this.fc24 = fc24;
	}

	public String getPasVigilia() {
		return pasVigilia;
	}

	public void setPasVigilia(String pasVigilia) {
		this.pasVigilia = pasVigilia;
	}

	public String getPadVigilia() {
		return padVigilia;
	}

	public void setPadVigilia(String padVigilia) {
		this.padVigilia = padVigilia;
	}

	public String getPamVigilia() {
		return pamVigilia;
	}

	public void setPamVigilia(String pamVigilia) {
		this.pamVigilia = pamVigilia;
	}

	public String getFcVigilia() {
		return fcVigilia;
	}

	public void setFcVigilia(String fcVigilia) {
		this.fcVigilia = fcVigilia;
	}

	public String getPasSono() {
		return pasSono;
	}

	public void setPasSono(String pasSono) {
		this.pasSono = pasSono;
	}

	public String getPadSono() {
		return padSono;
	}

	public void setPadSono(String padSono) {
		this.padSono = padSono;
	}

	public String getPamSono() {
		return pamSono;
	}

	public void setPamSono(String pamSono) {
		this.pamSono = pamSono;
	}

	public String getFcSono() {
		return fcSono;
	}

	public void setFcSono(String fcSono) {
		this.fcSono = fcSono;
	}

	public String getPasMinSono() {
		return pasMinSono;
	}

	public void setPasMinSono(String pasMinSono) {
		this.pasMinSono = pasMinSono;
	}

	public String getPadMinSono() {
		return padMinSono;
	}

	public void setPadMinSono(String padMinSono) {
		this.padMinSono = padMinSono;
	}

	public String getPamMinSono() {
		return pamMinSono;
	}

	public void setPamMinSono(String pamMinSono) {
		this.pamMinSono = pamMinSono;
	}

	public String getPas2Acordar() {
		return pas2Acordar;
	}

	public void setPas2Acordar(String pas2Acordar) {
		this.pas2Acordar = pas2Acordar;
	}

	public String getPad2Acordar() {
		return pad2Acordar;
	}

	public void setPad2Acordar(String pad2Acordar) {
		this.pad2Acordar = pad2Acordar;
	}

	public String getPam2Acordar() {
		return pam2Acordar;
	}

	public void setPam2Acordar(String pam2Acordar) {
		this.pam2Acordar = pam2Acordar;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

}
