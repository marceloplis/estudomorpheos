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
@Table(name = "TbVisita02")
@SequenceGenerator(name = "seq_visita02", sequenceName = "seq_visita02", allocationSize = 1)
public class Visita02Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Visita02Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita02")
	@Column
	private Long id;

	@Column(name = "flAdesaoTratamentoMedicamentoso")
	private String flAdesaoTratamentoMedicamentoso;
	
	@Column(name = "pcTotalAdesao")
	private Double pcTotalAdesao;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public VisitaEntity getVisita() {  
	    if(this.visita == null) {  
	        this.visita = new VisitaEntity();       
	    }  
	    return visita;  
	}	
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}	
	
	public String getFlAdesaoTratamentoMedicamentoso() {
		return flAdesaoTratamentoMedicamentoso;
	}
	public void setFlAdesaoTratamentoMedicamentoso(String flAdesaoTratamentoMedicamentoso) {
		this.flAdesaoTratamentoMedicamentoso = flAdesaoTratamentoMedicamentoso;
	}
	public Double getPcTotalAdesao() {
		return pcTotalAdesao;
	}
	public void setPcTotalAdesao(Double pcTotalAdesao) {
		this.pcTotalAdesao = pcTotalAdesao;
	}
	
}
