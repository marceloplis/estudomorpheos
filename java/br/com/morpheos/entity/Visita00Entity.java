package br.com.morpheos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.morpheos.util.Utils;

@Entity
@Table(name = "TbVisita00")
@SequenceGenerator(name = "seq_visita00", sequenceName = "seq_visita00", allocationSize = 1)
public class Visita00Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Visita00Entity(){
		this.visita = new VisitaEntity();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq_visita00")
	@Column
	private Long id;
	
	@Column(name = "flAssinaturaTCLE")
	private String flAssinaturaTCLE;
	
	@Column(name = "dtAssinaturaTCLE")
	private Date dtAssinaturaTCLE;
	@Transient
	private String dtAssinaturaTCLEParse;
	
	@Column(name = "PER_V00_CI01")
	private String PER_V00_CI01;
	
	@Column(name = "PER_V00_CI02")
	private String PER_V00_CI02;
	
	@Column(name = "PER_V00_CE01")
	private String PER_V00_CE01;
	
	@Column(name = "PER_V00_CE02")
	private String PER_V00_CE02;
	
	@Column(name = "PER_V00_CE03")
	private String PER_V00_CE03;
	
	@Column(name = "PER_V00_CE04")
	private String PER_V00_CE04;
	
	@Column(name = "PER_V00_CE05")
	private String PER_V00_CE05;
	
	@Column(name = "PER_V00_CE06")
	private String PER_V00_CE06;
	
	@Column(name = "PER_V00_CE07")
	private String PER_V00_CE07;
	
	@Column(name = "PER_V00_CE08")
	private String PER_V00_CE08;
	
	@Column(name = "PER_V00_CE09")
	private String PER_V00_CE09;
	
	@Column(name = "PER_V00_CE10")
	private String PER_V00_CE10;
	
	@Column(name = "PER_V00_AA01")
	private Double PER_V00_AA01;
	
	@Column(name = "PER_V00_AA02")
	private Double PER_V00_AA02;
	
	@Column(name = "PER_V00_AA03")
	private Double PER_V00_AA03;
	
	@Column(name = "PER_V00_AA04")
	private Integer PER_V00_AA04;
	
	@Column(name = "PER_V00_AA05")
	private Integer PER_V00_AA05;
	
	@Column(name = "PER_V00_AA06")
	private Integer PER_V00_AA06;
	
	@Column(name = "PER_V00_DP01")
	private Integer PER_V00_DP01;
	
	@Column(name = "PER_V00_DP02")
	private Integer PER_V00_DP02;
	
	@Column(name = "PER_V00_DP03")
	private String PER_V00_DP03;
	
	@Column(name = "PER_V00_DP04")
	private String PER_V00_DP04;
	
	@Column(name = "PER_V00_DP05")
	private String PER_V00_DP05;
	
	@Column(name = "PER_V00_DP06")
	private Integer PER_V00_DP06;
	
	@Column(name = "PER_V00_DP07")
	private Integer PER_V00_DP07;
	
	@Column(name = "PER_V00_DP08")
	private String PER_V00_DP08;
	
	@Column(name = "PER_V00_DP09")
	private String PER_V00_DP09;
	
	@Column(name = "PER_V00_DP10")
	private Integer PER_V00_DP10;
	
	@Column(name = "PER_V00_DP11")
	private String PER_V00_DP11;
	
	@Column(name = "PER_V00_DP12")
	private String PER_V00_DP12;
	
	@Column(name = "PER_V00_DP13")
	private String PER_V00_DP13;
	
	@Column(name = "PER_V00_DP14")
	private Integer PER_V00_DP14;
	
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
	
	public String getFlAssinaturaTCLE() {
		return flAssinaturaTCLE;
	}
	public void setFlAssinaturaTCLE(String flAssinaturaTCLE) {
		this.flAssinaturaTCLE = flAssinaturaTCLE;
	}
	
	public Date getDtAssinaturaTCLE() {
		return dtAssinaturaTCLE;
	}
	public void setDtAssinaturaTCLE(Date dtAssinaturaTCLE) {
		this.dtAssinaturaTCLE = dtAssinaturaTCLE;
	}
	public String getDtAssinaturaTCLEParse() {  
		if (getDtAssinaturaTCLE()!= null)     
			dtAssinaturaTCLEParse =  Utils.converteDataString(getDtAssinaturaTCLE());  
		return dtAssinaturaTCLEParse ;  
	}  
	  
	public void setDtAssinaturaTCLEParse(String string) {  
		dtAssinaturaTCLEParse = string;  
	    if ( (dtAssinaturaTCLEParse != null) && (!dtAssinaturaTCLEParse .equals("")) )      
	    	setDtAssinaturaTCLE(Utils.converteData(dtAssinaturaTCLEParse));  
	}
	
	public String getPER_V00_CI01() {
		return PER_V00_CI01;
	}
	public void setPER_V00_CI01(String pER_V00_CI01) {
		PER_V00_CI01 = pER_V00_CI01;
	}
	public String getPER_V00_CI02() {
		return PER_V00_CI02;
	}
	public void setPER_V00_CI02(String pER_V00_CI02) {
		PER_V00_CI02 = pER_V00_CI02;
	}
	public String getPER_V00_CE01() {
		return PER_V00_CE01;
	}
	public void setPER_V00_CE01(String pER_V00_CE01) {
		PER_V00_CE01 = pER_V00_CE01;
	}
	public String getPER_V00_CE02() {
		return PER_V00_CE02;
	}
	public void setPER_V00_CE02(String pER_V00_CE02) {
		PER_V00_CE02 = pER_V00_CE02;
	}
	public String getPER_V00_CE03() {
		return PER_V00_CE03;
	}
	public void setPER_V00_CE03(String pER_V00_CE03) {
		PER_V00_CE03 = pER_V00_CE03;
	}
	public String getPER_V00_CE04() {
		return PER_V00_CE04;
	}
	public void setPER_V00_CE04(String pER_V00_CE04) {
		PER_V00_CE04 = pER_V00_CE04;
	}
	public String getPER_V00_CE05() {
		return PER_V00_CE05;
	}
	public void setPER_V00_CE05(String pER_V00_CE05) {
		PER_V00_CE05 = pER_V00_CE05;
	}
	public String getPER_V00_CE06() {
		return PER_V00_CE06;
	}
	public void setPER_V00_CE06(String pER_V00_CE06) {
		PER_V00_CE06 = pER_V00_CE06;
	}
	public String getPER_V00_CE07() {
		return PER_V00_CE07;
	}
	public void setPER_V00_CE07(String pER_V00_CE07) {
		PER_V00_CE07 = pER_V00_CE07;
	}
	public String getPER_V00_CE08() {
		return PER_V00_CE08;
	}
	public void setPER_V00_CE08(String pER_V00_CE08) {
		PER_V00_CE08 = pER_V00_CE08;
	}
	public String getPER_V00_CE09() {
		return PER_V00_CE09;
	}
	public void setPER_V00_CE09(String pER_V00_CE09) {
		PER_V00_CE09 = pER_V00_CE09;
	}
	public String getPER_V00_CE10() {
		return PER_V00_CE10;
	}
	public void setPER_V00_CE10(String pER_V00_CE10) {
		PER_V00_CE10 = pER_V00_CE10;
	}
	public Double getPER_V00_AA01() {
		return PER_V00_AA01;
	}
	public void setPER_V00_AA01(Double pER_V00_AA01) {
		PER_V00_AA01 = pER_V00_AA01;
	}
	public Double getPER_V00_AA02() {
		return PER_V00_AA02;
	}
	public void setPER_V00_AA02(Double pER_V00_AA02) {
		PER_V00_AA02 = pER_V00_AA02;
	}
	public Double getPER_V00_AA03() {
		return PER_V00_AA03;
	}
	public void setPER_V00_AA03(Double pER_V00_AA03) {
		PER_V00_AA03 = pER_V00_AA03;
	}
	public Integer getPER_V00_AA04() {
		return PER_V00_AA04;
	}
	public void setPER_V00_AA04(Integer pER_V00_AA04) {
		PER_V00_AA04 = pER_V00_AA04;
	}
	public Integer getPER_V00_AA05() {
		return PER_V00_AA05;
	}
	public void setPER_V00_AA05(Integer pER_V00_AA05) {
		PER_V00_AA05 = pER_V00_AA05;
	}
	public Integer getPER_V00_AA06() {
		return PER_V00_AA06;
	}
	public void setPER_V00_AA06(Integer pER_V00_AA06) {
		PER_V00_AA06 = pER_V00_AA06;
	}
	public Integer getPER_V00_DP01() {
		return PER_V00_DP01;
	}
	public void setPER_V00_DP01(Integer pER_V00_DP01) {
		PER_V00_DP01 = pER_V00_DP01;
	}
	public Integer getPER_V00_DP02() {
		return PER_V00_DP02;
	}
	public void setPER_V00_DP02(Integer pER_V00_DP02) {
		PER_V00_DP02 = pER_V00_DP02;
	}
	public String getPER_V00_DP03() {
		return PER_V00_DP03;
	}
	public void setPER_V00_DP03(String pER_V00_DP03) {
		PER_V00_DP03 = pER_V00_DP03;
	}
	public String getPER_V00_DP04() {
		return PER_V00_DP04;
	}
	public void setPER_V00_DP04(String pER_V00_DP04) {
		PER_V00_DP04 = pER_V00_DP04;
	}
	public String getPER_V00_DP05() {
		return PER_V00_DP05;
	}
	public void setPER_V00_DP05(String pER_V00_DP05) {
		PER_V00_DP05 = pER_V00_DP05;
	}
	public Integer getPER_V00_DP06() {
		return PER_V00_DP06;
	}
	public void setPER_V00_DP06(Integer pER_V00_DP06) {
		PER_V00_DP06 = pER_V00_DP06;
	}
	public Integer getPER_V00_DP07() {
		return PER_V00_DP07;
	}
	public void setPER_V00_DP07(Integer pER_V00_DP07) {
		PER_V00_DP07 = pER_V00_DP07;
	}
	public String getPER_V00_DP08() {
		return PER_V00_DP08;
	}
	public void setPER_V00_DP08(String pER_V00_DP08) {
		PER_V00_DP08 = pER_V00_DP08;
	}
	public String getPER_V00_DP09() {
		return PER_V00_DP09;
	}
	public void setPER_V00_DP09(String pER_V00_DP09) {
		PER_V00_DP09 = pER_V00_DP09;
	}
	public Integer getPER_V00_DP10() {
		return PER_V00_DP10;
	}
	public void setPER_V00_DP10(Integer pER_V00_DP10) {
		PER_V00_DP10 = pER_V00_DP10;
	}
	public String getPER_V00_DP11() {
		return PER_V00_DP11;
	}
	public void setPER_V00_DP11(String pER_V00_DP11) {
		PER_V00_DP11 = pER_V00_DP11;
	}
	public String getPER_V00_DP12() {
		return PER_V00_DP12;
	}
	public void setPER_V00_DP12(String pER_V00_DP12) {
		PER_V00_DP12 = pER_V00_DP12;
	}
	public String getPER_V00_DP13() {
		return PER_V00_DP13;
	}
	public void setPER_V00_DP13(String pER_V00_DP13) {
		PER_V00_DP13 = pER_V00_DP13;
	}
	public Integer getPER_V00_DP14() {
		return PER_V00_DP14;
	}
	public void setPER_V00_DP14(Integer pER_V00_DP14) {
		PER_V00_DP14 = pER_V00_DP14;
	}
		
	
}
