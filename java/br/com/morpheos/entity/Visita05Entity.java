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
@Table(name = "TbVisita05")
@SequenceGenerator(name = "seq_visita05", sequenceName = "seq_visita05", allocationSize = 1)
public class Visita05Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Visita05Entity(){
		this.visita = new VisitaEntity();
	}	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita05")
	@Column
	private Long id;
	
	@Column(name = "pressaoCPAP")
	private Double pressaoCPAP;
	
	@Column(name = "tpMascara")
	private Integer tpMascara;
	
	@Column(name = "tamMascara")
	private String tamMascara;

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

	public Double getPressaoCPAP() {
		return pressaoCPAP;
	}

	public void setPressaoCPAP(Double pressaoCPAP) {
		this.pressaoCPAP = pressaoCPAP;
	}

	public Integer getTpMascara() {
		return tpMascara;
	}

	public void setTpMascara(Integer tpMascara) {
		this.tpMascara = tpMascara;
	}

	public String getTamMascara() {
		return tamMascara;
	}

	public void setTamMascara(String tamMascara) {
		this.tamMascara = tamMascara;
	}
}
