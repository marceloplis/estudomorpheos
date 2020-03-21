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
@Table(name = "TbQuestAplicacao")
@SequenceGenerator(name = "seq_questaplicacao", sequenceName = "seq_questaplicacao", allocationSize = 1)
public class QuestAplicacaoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestAplicacaoEntity(){
		this.visita = new VisitaEntity();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_questaplicacao")
	@Column(name = "idQuestionarioAplicacao")
	private Integer idQuestionarioAplicacao;
	
	@Column(name = "PER_QA01")
	private Integer PER_QA01;
	
	@Column(name = "PER_QA02")
	private Integer PER_QA02;
	
	@Column(name = "PER_QA03")
	private Integer PER_QA03;
	
	@Column(name = "PER_QA04")
	private Integer PER_QA04;
	
	@Column(name = "PER_QA05")
	private Integer PER_QA05;
	
	@Column(name = "PER_QA06")
	private Integer PER_QA06;
	
	@Column(name = "PER_QA07")
	private Integer PER_QA07;
	
	@Column(name = "PER_QA08")
	private Integer PER_QA08;
	
	@Column(name = "PER_QA09")
	private String PER_QA09;
	
	@Column(name = "PER_QA10")
	private String PER_QA10;
	
	@Column(name = "PER_QA11")
	private Integer PER_QA11;

	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdQuestionarioAplicacao() {
		return idQuestionarioAplicacao;
	}

	public void setIdQuestionarioAplicacao(Integer idQuestionarioAplicacao) {
		this.idQuestionarioAplicacao = idQuestionarioAplicacao;
	}

	public Integer getPER_QA01() {
		return PER_QA01;
	}

	public void setPER_QA01(Integer pER_QA01) {
		PER_QA01 = pER_QA01;
	}

	public Integer getPER_QA02() {
		return PER_QA02;
	}

	public void setPER_QA02(Integer pER_QA02) {
		PER_QA02 = pER_QA02;
	}

	public Integer getPER_QA03() {
		return PER_QA03;
	}

	public void setPER_QA03(Integer pER_QA03) {
		PER_QA03 = pER_QA03;
	}

	public Integer getPER_QA04() {
		return PER_QA04;
	}

	public void setPER_QA04(Integer pER_QA04) {
		PER_QA04 = pER_QA04;
	}

	public Integer getPER_QA05() {
		return PER_QA05;
	}

	public void setPER_QA05(Integer pER_QA05) {
		PER_QA05 = pER_QA05;
	}

	public Integer getPER_QA06() {
		return PER_QA06;
	}

	public void setPER_QA06(Integer pER_QA06) {
		PER_QA06 = pER_QA06;
	}

	public Integer getPER_QA07() {
		return PER_QA07;
	}

	public void setPER_QA07(Integer pER_QA07) {
		PER_QA07 = pER_QA07;
	}

	public Integer getPER_QA08() {
		return PER_QA08;
	}

	public void setPER_QA08(Integer pER_QA08) {
		PER_QA08 = pER_QA08;
	}

	public String getPER_QA09() {
		return PER_QA09;
	}

	public void setPER_QA09(String pER_QA09) {
		PER_QA09 = pER_QA09;
	}

	public String getPER_QA10() {
		return PER_QA10;
	}

	public void setPER_QA10(String pER_QA10) {
		PER_QA10 = pER_QA10;
	}

	public Integer getPER_QA11() {
		return PER_QA11;
	}

	public void setPER_QA11(Integer pER_QA11) {
		PER_QA11 = pER_QA11;
	}

	
}
