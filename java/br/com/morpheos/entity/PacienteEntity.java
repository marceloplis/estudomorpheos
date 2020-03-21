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

@Entity
@Table(name="TbPaciente")
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1)
public class PacienteEntity implements Serializable{

	private static final long serialVersionUID = -2779279975843540170L;


	public PacienteEntity(){
		this.unidade = new UnidadeAtendimentoEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_paciente")
	@Column(name="idPaciente")
	private Long idPaciente;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="iniciaisNome")
	private String iniciaisNome;
	
	@Column(name="nuRegistroProtocolo")
	private String numRegistro;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="nuEndereco")
	private Integer numEndereco;
	
	@Column(name="complEndereco")
	private String complemento;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="telResidencial")
	private String numFoneRes;
	
	@Column(name="telCelular")
	private String numCelular;
	
	@Column(name="telTrabalho")
	private String numFoneTrab;
	
	@Column(name="telRecado")
	private String numFoneRecado;
	
	@Column(name="pessoaRecado")
	private String nmContato;
	
	@Column(name="profissao")
	private String profissao;
	
	@Column(name="dtNascimento")
	private Date dtNascimento;
	
	@Column(name="escolaridade")
	private Integer escolaridade;
	
	@Column(name="raca")
	private Integer raca;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="flAtivo")
	private String ativo;
	
	@OneToOne
	@JoinColumn(name = "idUnidadePesquisa", referencedColumnName = "idunidadepesquisa")
	private UnidadeAtendimentoEntity unidade;	
	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

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

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco(Integer numEndereco) {
		this.numEndereco = numEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumFoneRes() {
		return numFoneRes;
	}

	public void setNumFoneRes(String numFoneRes) {
		this.numFoneRes = numFoneRes;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getNumFoneTrab() {
		return numFoneTrab;
	}

	public void setNumFoneTrab(String numFoneTrab) {
		this.numFoneTrab = numFoneTrab;
	}

	public String getNumFoneRecado() {
		return numFoneRecado;
	}

	public void setNumFoneRecado(String numFoneRecado) {
		this.numFoneRecado = numFoneRecado;
	}

	public String getNmContato() {
		return nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	
	
	public UnidadeAtendimentoEntity getUnidade() {
		return unidade;
	}
	
	public void setUnidade(UnidadeAtendimentoEntity unidade) {
		this.unidade = unidade;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

		
}