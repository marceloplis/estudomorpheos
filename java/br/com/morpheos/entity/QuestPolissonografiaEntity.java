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
@Table(name = "TbQuestPolissonografia")
@SequenceGenerator(name = "seq_polissonografia", sequenceName = "seq_polissonografia", allocationSize = 1)
public class QuestPolissonografiaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestPolissonografiaEntity(){
		this.visita = new VisitaEntity();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_polissonografia")
	@Column(name = "idPolissonografia")
	private Integer idPolissonografia;
	
	@Column(name = "qtdEventos")
	private Integer qtdEventos;
	
	@Column(name = "latencia")
	private String latencia;
	
	@Column(name = "TST")
	private String TST;
	
	@Column(name = "pcS1")
	private String pcS1;
	
	@Column(name = "pcS2")
	private String pcS2;
	
	@Column(name = "pcS3")
	private String pcS3;
	
	@Column(name = "pcREM")
	private String pcREM;
	
	@Column(name = "arquitetura")
	private String arquitetura;
	
	@Column(name = "IAH")
	private String IAH;
	
	@Column(name = "SatBasal")
	private String satBasal;
	
	@Column(name = "SatMedia")
	private String satMedia;
	
	@Column(name = "SatMinima")
	private String satMinima;
	
	@Column(name = "TSMenor90")
	private String TSMenor90;
	
	@Column(name = "Arousals")
	private String arousals;
	
	@Column(name = "resultado")
	private Integer resultado;
	
	@Column
	private String pressaoCPAP;
	
	@Column
	private String flAplicaDilatador;
	
	@Column
	private String tmMascaraN;
	
	@Column
	private String tmMascaraNO;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdPolissonografia() {
		return idPolissonografia;
	}

	public void setIdPolissonografia(Integer idPolissonografia) {
		this.idPolissonografia = idPolissonografia;
	}

	public Integer getQtdEventos() {
		return qtdEventos;
	}

	public void setQtdEventos(Integer qtdEventos) {
		this.qtdEventos = qtdEventos;
	}

	public String getLatencia() {
		return latencia;
	}

	public void setLatencia(String latencia) {
		this.latencia = latencia;
	}

	public String getTST() {
		return TST;
	}

	public void setTST(String tST) {
		TST = tST;
	}

	public String getPcS1() {
		return pcS1;
	}

	public void setPcS1(String pcS1) {
		this.pcS1 = pcS1;
	}

	public String getPcS2() {
		return pcS2;
	}

	public void setPcS2(String pcS2) {
		this.pcS2 = pcS2;
	}

	public String getPcS3() {
		return pcS3;
	}

	public void setPcS3(String pcS3) {
		this.pcS3 = pcS3;
	}

	public String getPcREM() {
		return pcREM;
	}

	public void setPcREM(String pcREM) {
		this.pcREM = pcREM;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
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

	public String getSatMinima() {
		return satMinima;
	}

	public void setSatMinima(String satMinima) {
		this.satMinima = satMinima;
	}

	public String getTSMenor90() {
		return TSMenor90;
	}

	public void setTSMenor90(String tSMenor90) {
		TSMenor90 = tSMenor90;
	}

	public String getArousals() {
		return arousals;
	}

	public void setArousals(String arousals) {
		this.arousals = arousals;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	public String getPressaoCPAP() {
		return pressaoCPAP;
	}

	public void setPressaoCPAP(String pressaoCPAP) {
		this.pressaoCPAP = pressaoCPAP;
	}

	public String getFlAplicaDilatador() {
		return flAplicaDilatador;
	}

	public void setFlAplicaDilatador(String flAplicaDilatador) {
		this.flAplicaDilatador = flAplicaDilatador;
	}

	public String getTmMascaraN() {
		return tmMascaraN;
	}

	public void setTmMascaraN(String tmMascaraN) {
		this.tmMascaraN = tmMascaraN;
	}

	public String getTmMascaraNO() {
		return tmMascaraNO;
	}

	public void setTmMascaraNO(String tmMascaraNO) {
		this.tmMascaraNO = tmMascaraNO;
	}
	
	
	
}
