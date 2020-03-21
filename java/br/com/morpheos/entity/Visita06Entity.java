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
@Table(name = "TbVisita06")
@SequenceGenerator(name = "seq_visita06", sequenceName = "seq_visita06", allocationSize = 1)
public class Visita06Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Visita06Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita06")
	@Column
	private Long id;
	
	@Column(name = "flAdaptacaoDoisGrupos")
	private String flAdaptacaoDoisGrupos;
	
	@Column(name = "flCPAPEntregue")
	private String flCPAPEntregue;
	
	@Column(name = "flDilatadorEntregue")
	private String flDilatadorEntregue;

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

	public String getFlAdaptacaoDoisGrupos() {
		return flAdaptacaoDoisGrupos;
	}

	public void setFlAdaptacaoDoisGrupos(String flAdaptacaoDoisGrupos) {
		this.flAdaptacaoDoisGrupos = flAdaptacaoDoisGrupos;
	}

	public String getFlCPAPEntregue() {
		return flCPAPEntregue;
	}

	public void setFlCPAPEntregue(String flCPAPEntregue) {
		this.flCPAPEntregue = flCPAPEntregue;
	}

	public String getFlDilatadorEntregue() {
		return flDilatadorEntregue;
	}

	public void setFlDilatadorEntregue(String flDilatadorEntregue) {
		this.flDilatadorEntregue = flDilatadorEntregue;
	}
}
