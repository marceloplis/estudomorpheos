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
@Table(name = "TbQuestPoligrafia")
@SequenceGenerator(name = "seq_poligrafia", sequenceName = "seq_poligrafia", allocationSize = 1)
public class QuestPoligrafiaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestPoligrafiaEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_poligrafia")
	@Column(name = "idPoligrafia")
	private Integer idPoligrafia;
	
	@Column(name = "qtdEventos")
	private Integer qtdEventos;
	
	@Column(name = "local")
	private String local;
	
	@Column(name = "IAH")
	private String IAH;
	
	@Column(name = "SatBasal")
	private String satBasal;
	
	@Column(name = "SatMedia")
	private String satMedia;
	
	@Column(name = "SatMinimo")
	private String satMinimo;
	
	@Column(name = "TSMenor90")
	private String TSMenor90;
	
	@Column(name = "resultado")
	private Integer resultado;
	
	@Column(name = "flAOSGrave")
	private String flAOSGrave;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdPoligrafia() {
		return idPoligrafia;
	}

	public void setIdPoligrafia(Integer idPoligrafia) {
		this.idPoligrafia = idPoligrafia;
	}

	public Integer getQtdEventos() {
		return qtdEventos;
	}

	public void setQtdEventos(Integer qtdEventos) {
		this.qtdEventos = qtdEventos;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getIAH() {
		return IAH;
	}

	public void setIAH(String iAH) {
		IAH = iAH;
	}

	public String getSatBasal() {
		return satBasal;
	}

	public void setSatBasal(String satBasal) {
		this.satBasal = satBasal;
	}

	public String getSatMedia() {
		return satMedia;
	}

	public void setSatMedia(String satMedia) {
		this.satMedia = satMedia;
	}

	public String getSatMinimo() {
		return satMinimo;
	}

	public void setSatMinimo(String satMinimo) {
		this.satMinimo = satMinimo;
	}

	public String getTSMenor90() {
		return TSMenor90;
	}

	public void setTSMenor90(String tSMenor90) {
		TSMenor90 = tSMenor90;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	
	public String getFlAOSGrave() {
		return flAOSGrave;
	}
	public void setFlAOSGrave(String flAOSGrave) {
		this.flAOSGrave = flAOSGrave;
	}

	
}
