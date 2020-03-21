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
@Table(name = "TbQuestBerlim")
@SequenceGenerator(name = "seq_questberlim", sequenceName = "seq_questberlim", allocationSize = 1)
public class QuestBerlimEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QuestBerlimEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_questberlim")
	@Column(name = "idQuestionarioBerlim")
	private Integer idQuestionarioBerlim;
	
	@Column(name = "PER_QB01")
	private Integer PER_QB01;
	
	@Column(name = "PER_QB02")
	private Integer PER_QB02;
	
	@Column(name = "PER_QB03")
	private Integer PER_QB03;
	
	@Column(name = "PER_QB04")
	private Integer PER_QB04;
	
	@Column(name = "PER_QB05")
	private String PER_QB05;
	
	@Column(name = "PER_QB06")
	private Integer PER_QB06;
	
	@Column(name = "PER_QB07")
	private Integer PER_QB07;
	
	@Column(name = "PER_QB08")
	private Integer PER_QB08;
	
	@Column(name = "PER_QB09A")
	private Integer PER_QB09A;
	
	@Column(name = "PER_QB09B")
	private Integer PER_QB09B;
	
	@Column(name = "PER_QB10")
	private Integer PER_QB10;
	
	@Column(name = "PER_QB11")
	private String PER_QB11;
	
	@Column(name = "CAT_01")
	private String CAT_01;
	
	@Column(name = "CAT_02")
	private String CAT_02;
	
	@Column(name = "CAT_03")
	private String CAT_03;
	
	@Column(name = "resultado")
	private Integer resultado;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdQuestionarioBerlim() {
		return idQuestionarioBerlim;
	}
	public void setIdQuestionarioBerlim(Integer idQuestionarioBerlim) {
		this.idQuestionarioBerlim = idQuestionarioBerlim;
	}
	public Integer getPER_QB01() {
		return PER_QB01;
	}
	public void setPER_QB01(Integer pER_QB01) {
		PER_QB01 = pER_QB01;
	}
	public Integer getPER_QB02() {
		return PER_QB02;
	}
	public void setPER_QB02(Integer pER_QB02) {
		PER_QB02 = pER_QB02;
	}
	public Integer getPER_QB03() {
		return PER_QB03;
	}
	public void setPER_QB03(Integer pER_QB03) {
		PER_QB03 = pER_QB03;
	}
	public Integer getPER_QB04() {
		return PER_QB04;
	}
	public void setPER_QB04(Integer pER_QB04) {
		PER_QB04 = pER_QB04;
	}
	public String getPER_QB05() {
		return PER_QB05;
	}
	public void setPER_QB05(String pER_QB05) {
		PER_QB05 = pER_QB05;
	}
	public Integer getPER_QB06() {
		return PER_QB06;
	}
	public void setPER_QB06(Integer pER_QB06) {
		PER_QB06 = pER_QB06;
	}
	public Integer getPER_QB07() {
		return PER_QB07;
	}
	public void setPER_QB07(Integer pER_QB07) {
		PER_QB07 = pER_QB07;
	}
	public Integer getPER_QB08() {
		return PER_QB08;
	}
	public void setPER_QB08(Integer pER_QB08) {
		PER_QB08 = pER_QB08;
	}
	public Integer getPER_QB09A() {
		return PER_QB09A;
	}
	public void setPER_QB09A(Integer pER_QB09A) {
		PER_QB09A = pER_QB09A;
	}
	public Integer getPER_QB09B() {
		return PER_QB09B;
	}
	public void setPER_QB09B(Integer pER_QB09B) {
		PER_QB09B = pER_QB09B;
	}
	public Integer getPER_QB10() {
		return PER_QB10;
	}
	public void setPER_QB10(Integer pER_QB10) {
		PER_QB10 = pER_QB10;
	}
	public String getPER_QB11() {
		return PER_QB11;
	}
	public void setPER_QB11(String pER_QB11) {
		PER_QB11 = pER_QB11;
	}
	public String getCAT_01() {
		return CAT_01;
	}
	public void setCAT_01(String cAT_01) {
		CAT_01 = cAT_01;
	}
	public String getCAT_02() {
		return CAT_02;
	}
	public void setCAT_02(String cAT_02) {
		CAT_02 = cAT_02;
	}
	public String getCAT_03() {
		return CAT_03;
	}
	public void setCAT_03(String cAT_03) {
		CAT_03 = cAT_03;
	}
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	
	

}
