package br.com.morpheos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TbUnidadePesquisa")
@SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade", allocationSize = 1)
public class UnidadeAtendimentoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_unidade")
	@Column
	private Long idUnidadePesquisa;
	
	@Column
	private Integer nuUnidade;
	
	@Column
	private String dsUnidade;
	
	@Column
	private String siglaUnidade; 
	
	@Column
	private String telUnidade; 	
	
	@Column
	private String endereco;
	
	@Column
	private String cidade; 
	
	@Column
	private String uf; 
	
	@Column
	private String cep;
	
	@Column
	private String investigador;
				   	
	@Column
	private String coordenador;
	
	@Column
	private String email;

	public Long getIdUnidadePesquisa() {
		return idUnidadePesquisa;
	}

	public void setIdUnidadePesquisa(Long idUnidadePesquisa) {
		this.idUnidadePesquisa = idUnidadePesquisa;
	}
	
	public Integer getNuUnidade() {
		return nuUnidade;
	}
	
	public void setNuUnidade(Integer nuUnidade) {
		this.nuUnidade = nuUnidade;
	}

	public String getDsUnidade() {
		return dsUnidade;
	}

	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}

	public String getSiglaUnidade() {
		return siglaUnidade;
	}

	public void setSiglaUnidade(String siglaUnidade) {
		this.siglaUnidade = siglaUnidade;
	}

	public String getTelUnidade() {
		return telUnidade;
	}

	public void setTelUnidade(String telUnidade) {
		this.telUnidade = telUnidade;
	}	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getInvestigador() {
		return investigador;
	}

	public void setInvestigador(String investigador) {
		this.investigador = investigador;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
