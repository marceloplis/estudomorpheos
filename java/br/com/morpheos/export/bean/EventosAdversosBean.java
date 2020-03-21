package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class EventosAdversosBean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data da Inclusão")
	private Date dataInclusao;

	@SheetHeader( name = "Doença")
	private String doenca;

	@SheetHeader( name = "Data Início")
	private Date dataInicio;

	@SheetHeader( name = "Data Término")
	private Date dataTermino;
	
	@SheetHeader( name = "Status")
	private String status;

	
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
