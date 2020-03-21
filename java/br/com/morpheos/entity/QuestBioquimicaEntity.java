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
@Table(name = "TbQuestBioquimica")
@SequenceGenerator(name = "seq_bioquimica", sequenceName = "seq_bioquimica", allocationSize = 1)
public class QuestBioquimicaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestBioquimicaEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_bioquimica")
	@Column
	private Long idBioquimica;
	
	@Column(name = "dtProcessamentoSoro")
	private String dtProcessamentoSoro;
	
	@Column(name = "dtColeta")
	private String dtColeta;
	
	@Column(name = "flQuatroColetas")
	private String flQuatroColetas;
	
	@Column(name = "PER_B01")
	private String PER_B01;
	
	@Column(name = "PER_B02")
	private String PER_B02;
	
	@Column(name = "PER_B03")
	private String PER_B03;
	
	@Column(name = "PER_B04")
	private String PER_B04;
	
	@Column(name = "PER_B05")
	private String PER_B05;
	
	@Column(name = "PER_B06")
	private String PER_B06;
	
	@Column(name = "PER_B07")
	private String PER_B07;
	
	@Column(name = "PER_B08")
	private String PER_B08;
	
	@Column(name = "PER_B09")
	private String PER_B09;
	
	@Column(name = "PER_B10")
	private String PER_B10;
	
	@Column(name = "PER_B11")
	private String PER_B11;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita;

	public Long getIdBioquimica() {
		return idBioquimica;
	}

	public void setIdBioquimica(Long idBioquimica) {
		this.idBioquimica = idBioquimica;
	}

	public String getDtProcessamentoSoro() {
		return dtProcessamentoSoro;
	}

	public void setDtProcessamentoSoro(String dtProcessamentoSoro) {
		this.dtProcessamentoSoro = dtProcessamentoSoro;
	}

	public String getDtColeta() {
		return dtColeta;
	}

	public void setDtColeta(String dtColeta) {
		this.dtColeta = dtColeta;
	}

	public String getFlQuatroColetas() {
		return flQuatroColetas;
	}

	public void setFlQuatroColetas(String flQuatroColetas) {
		this.flQuatroColetas = flQuatroColetas;
	}

	public String getPER_B01() {
		return PER_B01;
	}

	public void setPER_B01(String pER_B01) {
		PER_B01 = pER_B01;
	}

	public String getPER_B02() {
		return PER_B02;
	}

	public void setPER_B02(String pER_B02) {
		PER_B02 = pER_B02;
	}

	public String getPER_B03() {
		return PER_B03;
	}

	public void setPER_B03(String pER_B03) {
		PER_B03 = pER_B03;
	}

	public String getPER_B04() {
		return PER_B04;
	}

	public void setPER_B04(String pER_B04) {
		PER_B04 = pER_B04;
	}

	public String getPER_B05() {
		return PER_B05;
	}

	public void setPER_B05(String pER_B05) {
		PER_B05 = pER_B05;
	}

	public String getPER_B06() {
		return PER_B06;
	}

	public void setPER_B06(String pER_B06) {
		PER_B06 = pER_B06;
	}

	public String getPER_B07() {
		return PER_B07;
	}

	public void setPER_B07(String pER_B07) {
		PER_B07 = pER_B07;
	}

	public String getPER_B08() {
		return PER_B08;
	}

	public void setPER_B08(String pER_B08) {
		PER_B08 = pER_B08;
	}

	public String getPER_B09() {
		return PER_B09;
	}

	public void setPER_B09(String pER_B09) {
		PER_B09 = pER_B09;
	}

	public String getPER_B10() {
		return PER_B10;
	}

	public void setPER_B10(String pER_B10) {
		PER_B10 = pER_B10;
	}

	public String getPER_B11() {
		return PER_B11;
	}

	public void setPER_B11(String pER_B11) {
		PER_B11 = pER_B11;
	}

	public VisitaEntity getVisita() {
		return visita;
	}

	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	} 
	
	
	
}
