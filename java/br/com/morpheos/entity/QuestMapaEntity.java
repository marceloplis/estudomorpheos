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
@Table(name = "TbQuestMAPA")
@SequenceGenerator(name = "seq_questmapa", sequenceName = "seq_questmapa", allocationSize = 1)
public class QuestMapaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestMapaEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_questmapa")
	@Column(name = "idQuestionarioMAPA")
	private Integer idQuestionarioMAPA;	
	
	@Column(name = "hrInicio")
	private String hrInicio;
	
	@Column(name = "hrTermino")
	private String hrTermino;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "qtMedidasValidas")
	private Double qtMedidasValidas;
	
	@Column(name = "PER_QM01")
	private String PER_QM01;
	
	@Column(name = "PER_QM02")
	private String PER_QM02; 
	
	@Column(name = "PER_QM03")
	private String PER_QM03; 
	
	@Column(name = "PER_QM04")
	private String PER_QM04; 
	
	@Column(name = "PER_QM05")
	private String PER_QM05; 
	
	@Column(name = "PER_QM06")
	private String PER_QM06; 
	
	@Column(name = "PER_QM07")
	private String PER_QM07; 
	
	@Column(name = "PER_QM08")
	private String PER_QM08; 
	
	@Column(name = "PER_QM09")
	private String PER_QM09; 
	
	@Column(name = "PER_QM10")
	private String PER_QM10; 
	
	@Column(name = "PER_QM11")
	private String PER_QM11; 
	
	@Column(name = "PER_QM12")
	private String PER_QM12; 
	
	@Column(name = "PER_QM13")
	private String PER_QM13; 
	
	@Column(name = "PER_QM14")
	private String PER_QM14; 
	
	@Column(name = "PER_QM15")
	private String PER_QM15; 
	
	@Column(name = "PER_QM16")
	private String PER_QM16; 
	
	@Column(name = "PER_QM17")
	private String PER_QM17; 
	
	@Column(name = "PER_QM18")
	private String PER_QM18;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdQuestionarioMAPA() {
		return idQuestionarioMAPA;
	}

	public void setIdQuestionarioMAPA(Integer idQuestionarioMAPA) {
		this.idQuestionarioMAPA = idQuestionarioMAPA;
	}

	public String getHrInicio() {
		return hrInicio;
	}

	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}

	public String getHrTermino() {
		return hrTermino;
	}

	public void setHrTermino(String hrTermino) {
		this.hrTermino = hrTermino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Double getQtMedidasValidas() {
		return qtMedidasValidas;
	}
	
	public void setQtMedidasValidas(Double qtMedidasValidas) {
		this.qtMedidasValidas = qtMedidasValidas;
	}

	public String getPER_QM01() {
		return PER_QM01;
	}

	public void setPER_QM01(String pER_QM01) {
		PER_QM01 = pER_QM01;
	}

	public String getPER_QM02() {
		return PER_QM02;
	}

	public void setPER_QM02(String pER_QM02) {
		PER_QM02 = pER_QM02;
	}

	public String getPER_QM03() {
		return PER_QM03;
	}

	public void setPER_QM03(String pER_QM03) {
		PER_QM03 = pER_QM03;
	}

	public String getPER_QM04() {
		return PER_QM04;
	}

	public void setPER_QM04(String pER_QM04) {
		PER_QM04 = pER_QM04;
	}

	public String getPER_QM05() {
		return PER_QM05;
	}

	public void setPER_QM05(String pER_QM05) {
		PER_QM05 = pER_QM05;
	}

	public String getPER_QM06() {
		return PER_QM06;
	}

	public void setPER_QM06(String pER_QM06) {
		PER_QM06 = pER_QM06;
	}

	public String getPER_QM07() {
		return PER_QM07;
	}

	public void setPER_QM07(String pER_QM07) {
		PER_QM07 = pER_QM07;
	}

	public String getPER_QM08() {
		return PER_QM08;
	}

	public void setPER_QM08(String pER_QM08) {
		PER_QM08 = pER_QM08;
	}

	public String getPER_QM09() {
		return PER_QM09;
	}

	public void setPER_QM09(String pER_QM09) {
		PER_QM09 = pER_QM09;
	}

	public String getPER_QM10() {
		return PER_QM10;
	}

	public void setPER_QM10(String pER_QM10) {
		PER_QM10 = pER_QM10;
	}

	public String getPER_QM11() {
		return PER_QM11;
	}

	public void setPER_QM11(String pER_QM11) {
		PER_QM11 = pER_QM11;
	}

	public String getPER_QM12() {
		return PER_QM12;
	}

	public void setPER_QM12(String pER_QM12) {
		PER_QM12 = pER_QM12;
	}

	public String getPER_QM13() {
		return PER_QM13;
	}

	public void setPER_QM13(String pER_QM13) {
		PER_QM13 = pER_QM13;
	}

	public String getPER_QM14() {
		return PER_QM14;
	}

	public void setPER_QM14(String pER_QM14) {
		PER_QM14 = pER_QM14;
	}

	public String getPER_QM15() {
		return PER_QM15;
	}

	public void setPER_QM15(String pER_QM15) {
		PER_QM15 = pER_QM15;
	}

	public String getPER_QM16() {
		return PER_QM16;
	}

	public void setPER_QM16(String pER_QM16) {
		PER_QM16 = pER_QM16;
	}

	public String getPER_QM17() {
		return PER_QM17;
	}

	public void setPER_QM17(String pER_QM17) {
		PER_QM17 = pER_QM17;
	}

	public String getPER_QM18() {
		return PER_QM18;
	}

	public void setPER_QM18(String pER_QM18) {
		PER_QM18 = pER_QM18;
	} 

	
}
