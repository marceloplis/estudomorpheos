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
@Table(name = "TbVisitaAdesaoTratamento")
@SequenceGenerator(name = "seq_adesaotrat", sequenceName = "seq_adesaotrat", allocationSize = 1)
public class AdesaoTratamentoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdesaoTratamentoEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_adesaotrat")
	@Column(name = "idAdesaoTratamento")
	private Integer idAdesaoTratamento;	
	
	@Column(name = "flAdesaoTratamento")
	private String flAdesaoTratamento;
	
	@Column(name = "pcMediaCPAP")
	private Double pcMediaCPAP;
	
	@Column(name = "pcAdesaoDilatador")
	private Double pcAdesaoDilatador;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 

	public Integer getIdAdesaoTratamento() {
		return idAdesaoTratamento;
	}

	public void setIdAdesaoTratamento(Integer idAdesaoTratamento) {
		this.idAdesaoTratamento = idAdesaoTratamento;
	}
	
	public String getFlAdesaoTratamento() {
		return flAdesaoTratamento;
	}
	
	public void setFlAdesaoTratamento(String flAdesaoTratamento) {
		this.flAdesaoTratamento = flAdesaoTratamento;
	}
	
	public Double getPcMediaCPAP() {
		return pcMediaCPAP;
	}

	public void setPcMediaCPAP(Double pcMediaCPAP) {
		this.pcMediaCPAP = pcMediaCPAP;
	}

	public Double getPcAdesaoDilatador() {
		return pcAdesaoDilatador;
	}

	public void setPcAdesaoDilatador(Double pcAdesaoDilatador) {
		this.pcAdesaoDilatador = pcAdesaoDilatador;
	}

	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}

}
