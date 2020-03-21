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
@Table(name = "TbVisita09")
@SequenceGenerator(name = "seq_visita09", sequenceName = "seq_visita09", allocationSize = 1)
public class Visita09Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Visita09Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita09")
	@Column
	private Long id;
	
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

	
	
}
