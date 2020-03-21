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
@Table(name = "TbQuestPressaoArterial")
@SequenceGenerator(name = "seq_pressaoarterial", sequenceName = "seq_pressaoarterial", allocationSize = 1)
public class QuestPressaoArterialEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestPressaoArterialEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_pressaoarterial")
	@Column(name = "idPressaoArterial")
	private Integer idPressaoArterial;
	
	@Column(name = "PER_PA00")
	private String PER_PA00;
	
	@Column(name = "PER_PA01A")
	private String PER_PA01A;
	
	@Column(name = "PER_PA01B")
	private Integer PER_PA01B;
	
	@Column(name = "PER_PA02A")
	private String PER_PA02A;
	
	@Column(name = "PER_PA02B")
	private Integer PER_PA02B;
	
	@Column(name = "PER_PA03A")
	private String PER_PA03A;
	
	@Column(name = "PER_PA03B")
	private Integer PER_PA03B;
	
	@Column(name = "PER_PA04A")
	private String PER_PA04A;
	
	@Column(name = "PER_PA04B")
	private Integer PER_PA04B;
	
	@Column(name = "PER_PA05A")
	private String PER_PA05A;
	
	@Column(name = "PER_PA05B")
	private Integer PER_PA05B;
	
	@Column(name = "PER_PA06")
	private String PER_PA06;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	
	public Integer getIdPressaoArterial() {
		return idPressaoArterial;
	}
	public void setIdPressaoArterial(Integer idPressaoArterial) {
		this.idPressaoArterial = idPressaoArterial;
	}
	public String getPER_PA00() {
		return PER_PA00;
	}
	public void setPER_PA00(String pER_PA00) {
		PER_PA00 = pER_PA00;
	}
	public String getPER_PA01A() {
		return PER_PA01A;
	}
	public void setPER_PA01A(String pER_PA01A) {
		PER_PA01A = pER_PA01A;
	}
	public Integer getPER_PA01B() {
		return PER_PA01B;
	}
	public void setPER_PA01B(Integer pER_PA01B) {
		PER_PA01B = pER_PA01B;
	}
	public String getPER_PA02A() {
		return PER_PA02A;
	}
	public void setPER_PA02A(String pER_PA02A) {
		PER_PA02A = pER_PA02A;
	}
	public Integer getPER_PA02B() {
		return PER_PA02B;
	}
	public void setPER_PA02B(Integer pER_PA02B) {
		PER_PA02B = pER_PA02B;
	}
	public String getPER_PA03A() {
		return PER_PA03A;
	}
	public void setPER_PA03A(String pER_PA03A) {
		PER_PA03A = pER_PA03A;
	}
	public Integer getPER_PA03B() {
		return PER_PA03B;
	}
	public void setPER_PA03B(Integer pER_PA03B) {
		PER_PA03B = pER_PA03B;
	}
	public String getPER_PA04A() {
		return PER_PA04A;
	}
	public void setPER_PA04A(String pER_PA04A) {
		PER_PA04A = pER_PA04A;
	}
	public Integer getPER_PA04B() {
		return PER_PA04B;
	}
	public void setPER_PA04B(Integer pER_PA04B) {
		PER_PA04B = pER_PA04B;
	}
	public String getPER_PA05A() {
		return PER_PA05A;
	}
	public void setPER_PA05A(String pER_PA05A) {
		PER_PA05A = pER_PA05A;
	}
	public Integer getPER_PA05B() {
		return PER_PA05B;
	}
	public void setPER_PA05B(Integer pER_PA05B) {
		PER_PA05B = pER_PA05B;
	}
	public String getPER_PA06() {
		return PER_PA06;
	}
	public void setPER_PA06(String pER_PA06) {
		PER_PA06 = pER_PA06;
	}

	
}
