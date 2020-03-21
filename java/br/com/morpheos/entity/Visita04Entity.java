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
@Table(name = "TbVisita04")
@SequenceGenerator(name = "seq_visita04", sequenceName = "seq_visita04", allocationSize = 1)
public class Visita04Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Visita04Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita04")
	@Column
	private Long id;
	
	@Column
	private String flAdesaoMedicamentos;
	
	@Column
	private Double pcAdesaoMedicamentos;
	
	@Column(name = "flRandomizacao")
	private String flRandomizacao;
	
	@Column(name = "tpGrupoRandomizacao")
	private Integer tpGrupoRandomizacao;
	
	@Column(name = "flAceiteRandomizacao")
	private	String	flAceiteRandomizacao;
	
	@Column(name = "observacao")
	private String observacao;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFlAdesaoMedicamentos() {
		return flAdesaoMedicamentos;
	}
	
	public void setFlAdesaoMedicamentos(String flAdesaoMedicamentos) {
		this.flAdesaoMedicamentos = flAdesaoMedicamentos;
	}
	
	public Double getPcAdesaoMedicamentos() {
		return pcAdesaoMedicamentos;
	}
	
	public void setPcAdesaoMedicamentos(Double pcAdesaoMedicamentos) {
		this.pcAdesaoMedicamentos = pcAdesaoMedicamentos;
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

	public String getFlRandomizacao() {
		return flRandomizacao;
	}

	public void setFlRandomizacao(String flRandomizacao) {
		this.flRandomizacao = flRandomizacao;
	}

	public Integer getTpGrupoRandomizacao() {
		return tpGrupoRandomizacao;
	}

	public void setTpGrupoRandomizacao(Integer tpGrupoRandomizacao) {
		this.tpGrupoRandomizacao = tpGrupoRandomizacao;
	}

	public String getFlAceiteRandomizacao() {
		return flAceiteRandomizacao;
	}

	public void setFlAceiteRandomizacao(String flAceiteRandomizacao) {
		this.flAceiteRandomizacao = flAceiteRandomizacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
