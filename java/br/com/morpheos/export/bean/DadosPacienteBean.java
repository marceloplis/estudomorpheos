package br.com.morpheos.export.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.morpheos.export.excel.SheetHeader;

public class DadosPacienteBean {

	@SheetHeader( name = "Nome do Paciente")
	private String nome;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;
	
	@SheetHeader( name = "Idade")
	private Integer idade;
	
	@SheetHeader( name = "Centro")
	private String dsUnidade;

	@SheetHeader( name = "Nº Registro")
	private String nuRegistroProtocolo;

	@SheetHeader( name = "Data Nasc.")
	private Date dtNascimento;
	
	@SheetHeader( name = "Sexo")
	private String sexo;
	
	@SheetHeader( name = "Escolaridade")
	private Integer escolaridade;
	
	@SheetHeader( name = "Raça")
	private Integer raca;
	
	@SheetHeader( name = "Profissão")
	private String profissao;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIniciaisNome() {
		return iniciaisNome;
	}
	
	public void setIniciaisNome(String iniciaisNome) {
		this.iniciaisNome = iniciaisNome;
	}
	
	public Integer getIdade() {
		int NUMERO_INTEIRO_ZERO = 0;
		// Data de hoje.
 		GregorianCalendar agora = new GregorianCalendar();
 		int ano = NUMERO_INTEIRO_ZERO, 
			mes = NUMERO_INTEIRO_ZERO, dia = NUMERO_INTEIRO_ZERO;
		// Data do nascimento.
 		GregorianCalendar nascimento = new GregorianCalendar();
 		int anoNasc = NUMERO_INTEIRO_ZERO, 
			mesNasc = NUMERO_INTEIRO_ZERO, diaNasc = NUMERO_INTEIRO_ZERO;
 		// Idade.
 		int idade = NUMERO_INTEIRO_ZERO;
 		if(this.getDtNascimento() != null){
 			nascimento.setTime(this.getDtNascimento());
 			ano = agora.get(Calendar.YEAR);
 	 		mes = agora.get(Calendar.MONTH) + 1;
 	 		dia = agora.get(Calendar.DAY_OF_MONTH);
 	 		anoNasc = nascimento.get(Calendar.YEAR);
 	 		mesNasc = nascimento.get(Calendar.MONTH) + 1;
 	 		diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);
 	 		idade = ano - anoNasc;
 	 		// Calculando diferencas de mes e dia.
 	 		if(mes < mesNasc) {
 	 			idade--;
 	 		} else {
 	 			if(dia < diaNasc) {
 	 				idade--;
 	 			}
 	 		}
 	 		// Ultimo teste, idade "negativa".
 	 		if(idade < NUMERO_INTEIRO_ZERO) {
 	 			idade = NUMERO_INTEIRO_ZERO;
 	 		}
 		}
		 
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getDsUnidade() {
		return dsUnidade;
	}

	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}

	public String getNuRegistroProtocolo() {
		return nuRegistroProtocolo;
	}

	public void setNuRegistroProtocolo(String nuRegistroProtocolo) {
		this.nuRegistroProtocolo = nuRegistroProtocolo;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Integer getRaca() {
		return raca;
	}

	public void setRaca(Integer raca) {
		this.raca = raca;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
