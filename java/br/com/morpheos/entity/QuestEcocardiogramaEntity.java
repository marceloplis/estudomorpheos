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
@Table(name = "TbQuestEcocardiograma")
@SequenceGenerator(name = "seq_ecocardiograma", sequenceName = "seq_ecocardiograma", allocationSize = 1)
public class QuestEcocardiogramaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public QuestEcocardiogramaEntity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_ecocardiograma")
	@Column(name = "idEcocardiograma")
	private Integer idEcocardiograma;
	
	@Column
	private String dtRealizacao;
	
	@Column
	private String flRealizado;
	
	@Column(name = "PER_CT01")
	private String PER_CT01;
	
	@Column(name = "PER_CT02")
	private String PER_CT02;
	
	@Column(name = "PER_CT03")
	private String PER_CT03;
	
	@Column(name = "PER_CT04")
	private String PER_CT04;
	
	@Column(name = "PER_CT05")
	private String PER_CT05;
	
	@Column(name = "PER_CT06")
	private String PER_CT06;
	
	@Column(name = "PER_CT07")
	private String PER_CT07;
	
	@Column(name = "PER_CT08")
	private String PER_CT08;
	
	@Column(name = "PER_CT09")
	private String PER_CT09;
	
	@Column(name = "PER_CT10")
	private String PER_CT10;
	
	@Column(name = "PER_CT11")
	private String PER_CT11;
	
	@Column(name = "PER_CT12")
	private String PER_CT12;
	
	@Column(name = "PER_CT13")
	private String PER_CT13;
	
	@Column(name = "PER_CT14")
	private String PER_CT14;
	
	@Column(name = "PER_CT15")
	private String PER_CT15;
	
	@Column(name = "PER_CT16")
	private String PER_CT16;
	
	@Column(name = "PER_CT17")
	private String PER_CT17;
	
	@Column(name = "PER_CT18")
	private String PER_CT18;
	
	@Column(name = "PER_CT19")
	private String PER_CT19;
	
	@Column(name = "PER_CT20")
	private String PER_CT20;
	
	@Column(name = "PER_CT21")
	private String PER_CT21;
	
	@Column(name = "PER_CT22")
	private String PER_CT22;
	
	@Column(name = "PER_CT23")
	private String PER_CT23;
	
	@Column(name = "PER_CT24")
	private String PER_CT24;
	
	@Column(name = "PER_CT25")
	private String PER_CT25;
	
	@Column(name = "PER_CT26")
	private String PER_CT26;
	
	@Column(name = "PER_CT27")
	private String PER_CT27;
	
	@Column(name = "PER_CT28")
	private String PER_CT28;
	
	@Column(name = "PER_CT29")
	private String PER_CT29;
	
	@Column(name = "PER_CT30")
	private String PER_CT30;
	
	@Column(name = "PER_CT31")
	private String PER_CT31;
	
	@Column(name = "PER_CT32")
	private String PER_CT32;
	
	@Column(name = "PER_CT33")
	private String PER_CT33;
	
	@Column(name = "PER_CT34")
	private String PER_CT34;
	
	@Column(name = "PER_CT35")
	private String PER_CT35;
	
	@Column(name = "PER_CT36")
	private String PER_CT36;
	
	@Column(name = "PER_CT37")
	private String PER_CT37;
	
	@Column(name = "PER_CT38")
	private String PER_CT38;
	
	@Column(name = "PER_CT39")
	private String PER_CT39;
	
	@Column(name = "PER_CT40")
	private String PER_CT40;
	
	@Column(name = "PER_CT41")
	private String PER_CT41;
	
	@Column(name = "PER_CT42")
	private String PER_CT42;
	
	@Column(name = "PER_CT43")
	private String PER_CT43;
	
	@Column(name = "PER_CT44")
	private String PER_CT44;
	
	@Column(name = "PER_CT45")
	private String PER_CT45;
	
	@Column(name = "PER_CT46")
	private String PER_CT46;
	
	@Column(name = "observacao")	
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = "idVisita", referencedColumnName = "idVisita")
	private VisitaEntity visita; 
	
	public VisitaEntity getVisita() {
		return visita;
	}
	public void setVisita(VisitaEntity visita) {
		this.visita = visita;
	}
	
	public Integer getIdEcocardiograma() {
		return idEcocardiograma;
	}
	public void setIdEcocardiograma(Integer idEcocardiograma) {
		this.idEcocardiograma = idEcocardiograma;
	}	
	
	public String getDtRealizacao() {
		return dtRealizacao;
	}
	public void setDtRealizacao(String dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}
	
	public String getFlRealizado() {
		return flRealizado;
	}
	public void setFlRealizado(String flRealizado) {
		this.flRealizado = flRealizado;
	}
	public String getPER_CT01() {
		return PER_CT01;
	}
	public void setPER_CT01(String pER_CT01) {
		PER_CT01 = pER_CT01;
	}
	public String getPER_CT02() {
		return PER_CT02;
	}
	public void setPER_CT02(String pER_CT02) {
		PER_CT02 = pER_CT02;
	}
	public String getPER_CT03() {
		return PER_CT03;
	}
	public void setPER_CT03(String pER_CT03) {
		PER_CT03 = pER_CT03;
	}
	public String getPER_CT04() {
		return PER_CT04;
	}
	public void setPER_CT04(String pER_CT04) {
		PER_CT04 = pER_CT04;
	}
	public String getPER_CT05() {
		return PER_CT05;
	}
	public void setPER_CT05(String pER_CT05) {
		PER_CT05 = pER_CT05;
	}
	public String getPER_CT06() {
		return PER_CT06;
	}
	public void setPER_CT06(String pER_CT06) {
		PER_CT06 = pER_CT06;
	}
	public String getPER_CT07() {
		return PER_CT07;
	}
	public void setPER_CT07(String pER_CT07) {
		PER_CT07 = pER_CT07;
	}
	public String getPER_CT08() {
		return PER_CT08;
	}
	public void setPER_CT08(String pER_CT08) {
		PER_CT08 = pER_CT08;
	}
	public String getPER_CT09() {
		return PER_CT09;
	}
	public void setPER_CT09(String pER_CT09) {
		PER_CT09 = pER_CT09;
	}
	public String getPER_CT10() {
		return PER_CT10;
	}
	public void setPER_CT10(String pER_CT10) {
		PER_CT10 = pER_CT10;
	}
	public String getPER_CT11() {
		return PER_CT11;
	}
	public void setPER_CT11(String pER_CT11) {
		PER_CT11 = pER_CT11;
	}
	public String getPER_CT12() {
		return PER_CT12;
	}
	public void setPER_CT12(String pER_CT12) {
		PER_CT12 = pER_CT12;
	}
	public String getPER_CT13() {
		return PER_CT13;
	}
	public void setPER_CT13(String pER_CT13) {
		PER_CT13 = pER_CT13;
	}
	public String getPER_CT14() {
		return PER_CT14;
	}
	public void setPER_CT14(String pER_CT14) {
		PER_CT14 = pER_CT14;
	}
	public String getPER_CT15() {
		return PER_CT15;
	}
	public void setPER_CT15(String pER_CT15) {
		PER_CT15 = pER_CT15;
	}
	public String getPER_CT16() {
		return PER_CT16;
	}
	public void setPER_CT16(String pER_CT16) {
		PER_CT16 = pER_CT16;
	}
	public String getPER_CT17() {
		return PER_CT17;
	}
	public void setPER_CT17(String pER_CT17) {
		PER_CT17 = pER_CT17;
	}
	public String getPER_CT18() {
		return PER_CT18;
	}
	public void setPER_CT18(String pER_CT18) {
		PER_CT18 = pER_CT18;
	}
	public String getPER_CT19() {
		return PER_CT19;
	}
	public void setPER_CT19(String pER_CT19) {
		PER_CT19 = pER_CT19;
	}
	public String getPER_CT20() {
		return PER_CT20;
	}
	public void setPER_CT20(String pER_CT20) {
		PER_CT20 = pER_CT20;
	}
	public String getPER_CT21() {
		return PER_CT21;
	}
	public void setPER_CT21(String pER_CT21) {
		PER_CT21 = pER_CT21;
	}
	public String getPER_CT22() {
		return PER_CT22;
	}
	public void setPER_CT22(String pER_CT22) {
		PER_CT22 = pER_CT22;
	}
	public String getPER_CT23() {
		return PER_CT23;
	}
	public void setPER_CT23(String pER_CT23) {
		PER_CT23 = pER_CT23;
	}
	public String getPER_CT24() {
		return PER_CT24;
	}
	public void setPER_CT24(String pER_CT24) {
		PER_CT24 = pER_CT24;
	}
	public String getPER_CT25() {
		return PER_CT25;
	}
	public void setPER_CT25(String pER_CT25) {
		PER_CT25 = pER_CT25;
	}
	public String getPER_CT26() {
		return PER_CT26;
	}
	public void setPER_CT26(String pER_CT26) {
		PER_CT26 = pER_CT26;
	}
	public String getPER_CT27() {
		return PER_CT27;
	}
	public void setPER_CT27(String pER_CT27) {
		PER_CT27 = pER_CT27;
	}
	public String getPER_CT28() {
		return PER_CT28;
	}
	public void setPER_CT28(String pER_CT28) {
		PER_CT28 = pER_CT28;
	}
	public String getPER_CT29() {
		return PER_CT29;
	}
	public void setPER_CT29(String pER_CT29) {
		PER_CT29 = pER_CT29;
	}
	public String getPER_CT30() {
		return PER_CT30;
	}
	public void setPER_CT30(String pER_CT30) {
		PER_CT30 = pER_CT30;
	}
	public String getPER_CT31() {
		return PER_CT31;
	}
	public void setPER_CT31(String pER_CT31) {
		PER_CT31 = pER_CT31;
	}
	public String getPER_CT32() {
		return PER_CT32;
	}
	public void setPER_CT32(String pER_CT32) {
		PER_CT32 = pER_CT32;
	}
	public String getPER_CT33() {
		return PER_CT33;
	}
	public void setPER_CT33(String pER_CT33) {
		PER_CT33 = pER_CT33;
	}
	public String getPER_CT34() {
		return PER_CT34;
	}
	public void setPER_CT34(String pER_CT34) {
		PER_CT34 = pER_CT34;
	}
	public String getPER_CT35() {
		return PER_CT35;
	}
	public void setPER_CT35(String pER_CT35) {
		PER_CT35 = pER_CT35;
	}
	public String getPER_CT36() {
		return PER_CT36;
	}
	public void setPER_CT36(String pER_CT36) {
		PER_CT36 = pER_CT36;
	}
	public String getPER_CT37() {
		return PER_CT37;
	}
	public void setPER_CT37(String pER_CT37) {
		PER_CT37 = pER_CT37;
	}
	public String getPER_CT38() {
		return PER_CT38;
	}
	public void setPER_CT38(String pER_CT38) {
		PER_CT38 = pER_CT38;
	}
	public String getPER_CT39() {
		return PER_CT39;
	}
	public void setPER_CT39(String pER_CT39) {
		PER_CT39 = pER_CT39;
	}
	public String getPER_CT40() {
		return PER_CT40;
	}
	public void setPER_CT40(String pER_CT40) {
		PER_CT40 = pER_CT40;
	}
	public String getPER_CT41() {
		return PER_CT41;
	}
	public void setPER_CT41(String pER_CT41) {
		PER_CT41 = pER_CT41;
	}
	public String getPER_CT42() {
		return PER_CT42;
	}
	public void setPER_CT42(String pER_CT42) {
		PER_CT42 = pER_CT42;
	}
	public String getPER_CT43() {
		return PER_CT43;
	}
	public void setPER_CT43(String pER_CT43) {
		PER_CT43 = pER_CT43;
	}
	public String getPER_CT44() {
		return PER_CT44;
	}
	public void setPER_CT44(String pER_CT44) {
		PER_CT44 = pER_CT44;
	}
	public String getPER_CT45() {
		return PER_CT45;
	}
	public void setPER_CT45(String pER_CT45) {
		PER_CT45 = pER_CT45;
	}
	public String getPER_CT46() {
		return PER_CT46;
	}
	public void setPER_CT46(String pER_CT46) {
		PER_CT46 = pER_CT46;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	

}
