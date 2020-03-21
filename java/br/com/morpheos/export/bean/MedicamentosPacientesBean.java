package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class MedicamentosPacientesBean {

	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;
	
	@SheetHeader( name = "Visita")
	private Integer nuVisita;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Grupo do medicamento")
	private String grupoMedicamento;

	@SheetHeader( name = "Medicamento")
	private String medicamento;

	@SheetHeader( name = "Dose")
	private String dose;

	@SheetHeader( name = "Posologia")
	private String posologia;

	@SheetHeader( name = "Observação")
	private String observacao;

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

	public Integer getNuVisita() {
		return nuVisita;
	}

	public void setNuVisita(Integer nuVisita) {
		this.nuVisita = nuVisita;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public String getGrupoMedicamento() {
		return grupoMedicamento;
	}

	public void setGrupoMedicamento(String grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
