package br.com.morpheos.entity;

import java.io.Serializable;

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
@Table(name = "TbVisitaMudancaMedicacao")
@SequenceGenerator(name = "seq_adesaomedicacao", sequenceName = "seq_adesaomedicacao", allocationSize = 1)
public class AdesaoMedicacaoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdesaoMedicacaoEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_adesaomedicacao")
	@Column(name = "idMudancaMedicacao")
	private Integer idMudancaMedicacao;
	
	@Column(name = "flMudancaMedicamento")
	private String flMudancaMedicamento;
	
	@Column(name = "dsMotivo")
	private String dsMotivo;
	
	@Column(name = "flManterMedicamentoInicial")
	private String flManterMedicamentoInicial;
	
	@Column(name = "flAdesaoMedicacao")
	private String flAdesaoMedicacao;
	
	@Column(name = "pcAdesaoMedicacao")
	private Double pcAdesaoMedicacao;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdMudancaMedicacao() {
		return idMudancaMedicacao;
	}

	public void setIdMudancaMedicacao(Integer idMudancaMedicacao) {
		this.idMudancaMedicacao = idMudancaMedicacao;
	}
	
	public String getFlMudancaMedicamento() {
		return flMudancaMedicamento;
	}
	
	public void setFlMudancaMedicamento(String flMudancaMedicamento) {
		this.flMudancaMedicamento = flMudancaMedicamento;
	}
	
	public String getDsMotivo() {
		return dsMotivo;
	}

	public void setDsMotivo(String dsMotivo) {
		this.dsMotivo = dsMotivo;
	}

	public String getFlManterMedicamentoInicial() {
		return flManterMedicamentoInicial;
	}

	public void setFlManterMedicamentoInicial(String flManterMedicamentoInicial) {
		this.flManterMedicamentoInicial = flManterMedicamentoInicial;
	}

	public String getFlAdesaoMedicacao() {
		return flAdesaoMedicacao;
	}

	public void setFlAdesaoMedicacao(String flAdesaoMedicacao) {
		this.flAdesaoMedicacao = flAdesaoMedicacao;
	}

	public Double getPcAdesaoMedicacao() {
		return pcAdesaoMedicacao;
	}

	public void setPcAdesaoMedicacao(Double pcAdesaoMedicacao) {
		this.pcAdesaoMedicacao = pcAdesaoMedicacao;
	}

	
}
