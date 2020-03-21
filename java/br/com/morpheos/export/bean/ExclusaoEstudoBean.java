package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class ExclusaoEstudoBean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;
	
	@SheetHeader( name = "Grupo Randomizado")
	private Long gruporandomizacao;

	@SheetHeader( name = "Data da Saída")
	private Date dataSaida;

	@SheetHeader( name = "Visita da Exclusão")
	private Long numeroVisita;

	@SheetHeader( name = "Motivo da Saída")
	private Long motivoSaida;

	@SheetHeader( name = "Observações")
	private String observacoes;

	@SheetHeader( name = "Data da Ocorrência")
	private Date dataOcorrencia;

	@SheetHeader( name = "Evoluiu a óbito ?")
	private String evoluiuObito;

	
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
	
	public Long getGruporandomizacao() {
		return gruporandomizacao;
	}
	
	public void setGruporandomizacao(Long gruporandomizacao) {
		this.gruporandomizacao = gruporandomizacao;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Long getNumeroVisita() {
		return numeroVisita;
	}

	public void setNumeroVisita(Long numeroVisita) {
		this.numeroVisita = numeroVisita;
	}

	public Long getMotivoSaida() {
		return motivoSaida;
	}

	public void setMotivoSaida(Long motivoSaida) {
		this.motivoSaida = motivoSaida;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getEvoluiuObito() {
		return evoluiuObito;
	}

	public void setEvoluiuObito(String evoluiuObito) {
		this.evoluiuObito = evoluiuObito;
	}
	
}
