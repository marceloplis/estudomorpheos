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
@Table(name = "TbVisita03")
@SequenceGenerator(name = "seq_visita03", sequenceName = "seq_visita03", allocationSize = 1)
public class Visita03Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Visita03Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita03")
	@Column
	private Long id;
	
	@Column(name = "flHasControlada")
	private boolean flHasControlada;

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

	public boolean isFlHasControlada() {
		return flHasControlada;
	}

	public void setFlHasControlada(boolean flHasControlada) {
		this.flHasControlada = flHasControlada;
	}
}
