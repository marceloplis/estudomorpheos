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
@Table(name = "TbQuestAtividadeFisica")
@SequenceGenerator(name = "seq_questintern", sequenceName = "seq_questintern", allocationSize = 1)
public class QuestAtividadeFisicaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestAtividadeFisicaEntity(){
		this.visita = new VisitaEntity();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_questintern")
	@Column(name = "idQuestionarioInternacional")
	private Integer idQuestionarioInternacional;
	
	@Column(name = "PER_QI01")
	private String PER_QI01;
	
	@Column(name = "PER_QI02")
	private String PER_QI02;
	
	@Column(name = "PER_QI03")
	private Integer PER_QI03;
	
	@Column(name = "PER_QI04")
	private Integer PER_QI04;
	
	@Column(name = "PER_QIS1A")
	private String PER_QIS1A;
	
	@Column(name = "PER_QIS1B")
	private Integer PER_QIS1B;
	
	@Column(name = "PER_QIS1CH")
	private Integer PER_QIS1CH;
	
	@Column(name = "PER_QIS1CM")
	private Integer PER_QIS1CM;
	
	@Column(name = "PER_QIS1D")
	private Integer PER_QIS1D;
	
	@Column(name = "PER_QIS1EH")
	private Integer PER_QIS1EH;
	
	@Column(name = "PER_QIS1EM")
	private Integer PER_QIS1EM;
	
	@Column(name = "PER_QIS1F")
	private Integer PER_QIS1F;
	
	@Column(name = "PER_QIS1GH")
	private Integer PER_QIS1GH;
	
	@Column(name = "PER_QIS1GM")
	private Integer PER_QIS1GM;
	
	@Column(name = "PER_QIS2A")
	private Integer PER_QIS2A;
	
	@Column(name = "PER_QIS2BH")
	private Integer PER_QIS2BH;
	
	@Column(name = "PER_QIS2BM")
	private Integer PER_QIS2BM;
	
	@Column(name = "PER_QIS2C")
	private Integer PER_QIS2C;
	
	@Column(name = "PER_QIS2DH")
	private Integer PER_QIS2DH;
	
	@Column(name = "PER_QIS2DM")
	private Integer PER_QIS2DM;
	
	@Column(name = "PER_QIS2E")
	private Integer PER_QIS2E;
	
	@Column(name = "PER_QIS2FH")
	private Integer PER_QIS2FH;
	
	@Column(name = "PER_QIS2FM")
	private Integer PER_QIS2FM;
	
	@Column(name = "PER_QIS3A")
	private Integer PER_QIS3A;
	
	@Column(name = "PER_QIS3BH")
	private Integer PER_QIS3BH;
	
	@Column(name = "PER_QIS3BM")
	private Integer PER_QIS3BM;
	
	@Column(name = "PER_QIS3C")
	private Integer PER_QIS3C;
	
	@Column(name = "PER_QIS3DH")
	private Integer PER_QIS3DH;
	
	@Column(name = "PER_QIS3DM")
	private Integer PER_QIS3DM;
	
	@Column(name = "PER_QIS3E")
	private Integer PER_QIS3E;
	
	@Column(name = "PER_QIS3FH")
	private Integer PER_QIS3FH;
	
	@Column(name = "PER_QIS3FM")
	private Integer PER_QIS3FM;
	
	@Column(name = "PER_QIS4A")
	private Integer PER_QIS4A;
	
	@Column(name = "PER_QIS4BH")
	private Integer PER_QIS4BH;
	
	@Column(name = "PER_QIS4BM")
	private Integer PER_QIS4BM;
	
	@Column(name = "PER_QIS4C")
	private Integer PER_QIS4C;
	
	@Column(name = "PER_QIS4DH")
	private Integer PER_QIS4DH;
	
	@Column(name = "PER_QIS4DM")
	private Integer PER_QIS4DM;
	
	@Column(name = "PER_QIS4E")
	private Integer PER_QIS4E;
	
	@Column(name = "PER_QIS4FH")
	private Integer PER_QIS4FH;
	
	@Column(name = "PER_QIS4FM")
	private Integer PER_QIS4FM;
	
	@Column(name = "PER_QIS5AH")
	private Integer PER_QIS5AH;
	
	@Column(name = "PER_QIS5AM")
	private Integer PER_QIS5AM;
	
	@Column(name = "PER_QIS5BH")
	private Integer PER_QIS5BH;
	
	@Column(name = "PER_QIS5BM")
	private Integer PER_QIS5BM;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita;

	public Integer getIdQuestionarioInternacional() {
		return idQuestionarioInternacional;
	}

	public void setIdQuestionarioInternacional(Integer idQuestionarioInternacional) {
		this.idQuestionarioInternacional = idQuestionarioInternacional;
	}

	public String getPER_QI01() {
		return PER_QI01;
	}

	public void setPER_QI01(String pER_QI01) {
		PER_QI01 = pER_QI01;
	}

	public String getPER_QI02() {
		return PER_QI02;
	}

	public void setPER_QI02(String pER_QI02) {
		PER_QI02 = pER_QI02;
	}

	public Integer getPER_QI03() {
		return PER_QI03;
	}

	public void setPER_QI03(Integer pER_QI03) {
		PER_QI03 = pER_QI03;
	}

	public Integer getPER_QI04() {
		return PER_QI04;
	}

	public void setPER_QI04(Integer pER_QI04) {
		PER_QI04 = pER_QI04;
	}

	public String getPER_QIS1A() {
		return PER_QIS1A;
	}

	public void setPER_QIS1A(String pER_QIS1A) {
		PER_QIS1A = pER_QIS1A;
	}

	public Integer getPER_QIS1B() {
		return PER_QIS1B;
	}

	public void setPER_QIS1B(Integer pER_QIS1B) {
		PER_QIS1B = pER_QIS1B;
	}

	public Integer getPER_QIS1CH() {
		return PER_QIS1CH;
	}

	public void setPER_QIS1CH(Integer pER_QIS1CH) {
		PER_QIS1CH = pER_QIS1CH;
	}

	public Integer getPER_QIS1CM() {
		return PER_QIS1CM;
	}

	public void setPER_QIS1CM(Integer pER_QIS1CM) {
		PER_QIS1CM = pER_QIS1CM;
	}

	public Integer getPER_QIS1D() {
		return PER_QIS1D;
	}

	public void setPER_QIS1D(Integer pER_QIS1D) {
		PER_QIS1D = pER_QIS1D;
	}

	public Integer getPER_QIS1EH() {
		return PER_QIS1EH;
	}

	public void setPER_QIS1EH(Integer pER_QIS1EH) {
		PER_QIS1EH = pER_QIS1EH;
	}

	public Integer getPER_QIS1EM() {
		return PER_QIS1EM;
	}

	public void setPER_QIS1EM(Integer pER_QIS1EM) {
		PER_QIS1EM = pER_QIS1EM;
	}

	public Integer getPER_QIS1F() {
		return PER_QIS1F;
	}

	public void setPER_QIS1F(Integer pER_QIS1F) {
		PER_QIS1F = pER_QIS1F;
	}

	public Integer getPER_QIS1GH() {
		return PER_QIS1GH;
	}

	public void setPER_QIS1GH(Integer pER_QIS1GH) {
		PER_QIS1GH = pER_QIS1GH;
	}

	public Integer getPER_QIS1GM() {
		return PER_QIS1GM;
	}

	public void setPER_QIS1GM(Integer pER_QIS1GM) {
		PER_QIS1GM = pER_QIS1GM;
	}

	public Integer getPER_QIS2A() {
		return PER_QIS2A;
	}

	public void setPER_QIS2A(Integer pER_QIS2A) {
		PER_QIS2A = pER_QIS2A;
	}

	public Integer getPER_QIS2BH() {
		return PER_QIS2BH;
	}

	public void setPER_QIS2BH(Integer pER_QIS2BH) {
		PER_QIS2BH = pER_QIS2BH;
	}

	public Integer getPER_QIS2BM() {
		return PER_QIS2BM;
	}

	public void setPER_QIS2BM(Integer pER_QIS2BM) {
		PER_QIS2BM = pER_QIS2BM;
	}

	public Integer getPER_QIS2C() {
		return PER_QIS2C;
	}

	public void setPER_QIS2C(Integer pER_QIS2C) {
		PER_QIS2C = pER_QIS2C;
	}

	public Integer getPER_QIS2DH() {
		return PER_QIS2DH;
	}

	public void setPER_QIS2DH(Integer pER_QIS2DH) {
		PER_QIS2DH = pER_QIS2DH;
	}

	public Integer getPER_QIS2DM() {
		return PER_QIS2DM;
	}

	public void setPER_QIS2DM(Integer pER_QIS2DM) {
		PER_QIS2DM = pER_QIS2DM;
	}

	public Integer getPER_QIS2E() {
		return PER_QIS2E;
	}

	public void setPER_QIS2E(Integer pER_QIS2E) {
		PER_QIS2E = pER_QIS2E;
	}

	public Integer getPER_QIS2FH() {
		return PER_QIS2FH;
	}

	public void setPER_QIS2FH(Integer pER_QIS2FH) {
		PER_QIS2FH = pER_QIS2FH;
	}

	public Integer getPER_QIS2FM() {
		return PER_QIS2FM;
	}

	public void setPER_QIS2FM(Integer pER_QIS2FM) {
		PER_QIS2FM = pER_QIS2FM;
	}

	public Integer getPER_QIS3A() {
		return PER_QIS3A;
	}

	public void setPER_QIS3A(Integer pER_QIS3A) {
		PER_QIS3A = pER_QIS3A;
	}

	public Integer getPER_QIS3BH() {
		return PER_QIS3BH;
	}

	public void setPER_QIS3BH(Integer pER_QIS3BH) {
		PER_QIS3BH = pER_QIS3BH;
	}

	public Integer getPER_QIS3BM() {
		return PER_QIS3BM;
	}

	public void setPER_QIS3BM(Integer pER_QIS3BM) {
		PER_QIS3BM = pER_QIS3BM;
	}

	public Integer getPER_QIS3C() {
		return PER_QIS3C;
	}

	public void setPER_QIS3C(Integer pER_QIS3C) {
		PER_QIS3C = pER_QIS3C;
	}

	public Integer getPER_QIS3DH() {
		return PER_QIS3DH;
	}

	public void setPER_QIS3DH(Integer pER_QIS3DH) {
		PER_QIS3DH = pER_QIS3DH;
	}

	public Integer getPER_QIS3DM() {
		return PER_QIS3DM;
	}

	public void setPER_QIS3DM(Integer pER_QIS3DM) {
		PER_QIS3DM = pER_QIS3DM;
	}

	public Integer getPER_QIS3E() {
		return PER_QIS3E;
	}

	public void setPER_QIS3E(Integer pER_QIS3E) {
		PER_QIS3E = pER_QIS3E;
	}

	public Integer getPER_QIS3FH() {
		return PER_QIS3FH;
	}

	public void setPER_QIS3FH(Integer pER_QIS3FH) {
		PER_QIS3FH = pER_QIS3FH;
	}

	public Integer getPER_QIS3FM() {
		return PER_QIS3FM;
	}

	public void setPER_QIS3FM(Integer pER_QIS3FM) {
		PER_QIS3FM = pER_QIS3FM;
	}

	public Integer getPER_QIS4A() {
		return PER_QIS4A;
	}

	public void setPER_QIS4A(Integer pER_QIS4A) {
		PER_QIS4A = pER_QIS4A;
	}

	public Integer getPER_QIS4BH() {
		return PER_QIS4BH;
	}

	public void setPER_QIS4BH(Integer pER_QIS4BH) {
		PER_QIS4BH = pER_QIS4BH;
	}

	public Integer getPER_QIS4BM() {
		return PER_QIS4BM;
	}

	public void setPER_QIS4BM(Integer pER_QIS4BM) {
		PER_QIS4BM = pER_QIS4BM;
	}

	public Integer getPER_QIS4C() {
		return PER_QIS4C;
	}

	public void setPER_QIS4C(Integer pER_QIS4C) {
		PER_QIS4C = pER_QIS4C;
	}

	public Integer getPER_QIS4DH() {
		return PER_QIS4DH;
	}

	public void setPER_QIS4DH(Integer pER_QIS4DH) {
		PER_QIS4DH = pER_QIS4DH;
	}

	public Integer getPER_QIS4DM() {
		return PER_QIS4DM;
	}

	public void setPER_QIS4DM(Integer pER_QIS4DM) {
		PER_QIS4DM = pER_QIS4DM;
	}

	public Integer getPER_QIS4E() {
		return PER_QIS4E;
	}

	public void setPER_QIS4E(Integer pER_QIS4E) {
		PER_QIS4E = pER_QIS4E;
	}

	public Integer getPER_QIS4FH() {
		return PER_QIS4FH;
	}

	public void setPER_QIS4FH(Integer pER_QIS4FH) {
		PER_QIS4FH = pER_QIS4FH;
	}

	public Integer getPER_QIS4FM() {
		return PER_QIS4FM;
	}

	public void setPER_QIS4FM(Integer pER_QIS4FM) {
		PER_QIS4FM = pER_QIS4FM;
	}

	public Integer getPER_QIS5AH() {
		return PER_QIS5AH;
	}

	public void setPER_QIS5AH(Integer pER_QIS5AH) {
		PER_QIS5AH = pER_QIS5AH;
	}

	public Integer getPER_QIS5AM() {
		return PER_QIS5AM;
	}

	public void setPER_QIS5AM(Integer pER_QIS5AM) {
		PER_QIS5AM = pER_QIS5AM;
	}

	public Integer getPER_QIS5BH() {
		return PER_QIS5BH;
	}

	public void setPER_QIS5BH(Integer pER_QIS5BH) {
		PER_QIS5BH = pER_QIS5BH;
	}

	public Integer getPER_QIS5BM() {
		return PER_QIS5BM;
	}

	public void setPER_QIS5BM(Integer pER_QIS5BM) {
		PER_QIS5BM = pER_QIS5BM;
	}

	public VisitaEntity getVisita() {
		return visita;
	}

	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	} 
	
	

}
