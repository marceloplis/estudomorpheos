package br.com.morpheos.action.estudo.visita;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.AdesaoMedicacaoEntity;
import br.com.morpheos.entity.AdesaoTratamentoEntity;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.Visita00Entity;
import br.com.morpheos.entity.Visita01Entity;
import br.com.morpheos.entity.Visita02Entity;
import br.com.morpheos.entity.Visita03Entity;
import br.com.morpheos.entity.Visita04Entity;
import br.com.morpheos.entity.Visita05Entity;
import br.com.morpheos.entity.Visita06Entity;
import br.com.morpheos.entity.Visita07Entity;
import br.com.morpheos.entity.Visita08Entity;
import br.com.morpheos.entity.Visita09Entity;
import br.com.morpheos.entity.Visita10Entity;
import br.com.morpheos.entity.Visita11Entity;
import br.com.morpheos.entity.Visita12Entity;
import br.com.morpheos.entity.Visita13Entity;
import br.com.morpheos.entity.Visita14Entity;
import br.com.morpheos.entity.Visita15Entity;
import br.com.morpheos.entity.Visita16Entity;
import br.com.morpheos.entity.Visita17Entity;

public class VisitasForm extends FormBase{

	private static final long serialVersionUID = 1L;

	private String 	tituloPagina;
	private Long 	idPaciente;
	private Integer nuVisita;
	private Date 	dtInclusao;
	private String 	acessoAprovador;
	
	private PacienteEntity paciente;
	
	private Visita00Entity visita00;	
	private Visita01Entity visita01;
	private Visita02Entity visita02;	
	private Visita03Entity visita03;
	private Visita04Entity visita04;
	private Visita05Entity visita05;
	private Visita06Entity visita06;
	private Visita07Entity visita07;
	private Visita08Entity visita08;
	private Visita09Entity visita09;
	private Visita10Entity visita10;
	private Visita11Entity visita11;
	private Visita12Entity visita12;
	private Visita13Entity visita13;
	private Visita14Entity visita14;
	private Visita15Entity visita15;
	private Visita16Entity visita16;
	private Visita17Entity visita17;
	
	private AdesaoMedicacaoEntity  adesaoMedicacao;
	private AdesaoTratamentoEntity adesaoTratamento;	 
	
	/**/
	public String getTituloPagina() {
		return tituloPagina;
	}
	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}	
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}	
	
	public Integer getNuVisita() {
		return nuVisita;
	}	
	public void setNuVisita(Integer nuVisita) {
		this.nuVisita = nuVisita;
	}
	
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}	
	
	public String getAcessoAprovador() {
		return acessoAprovador;
	}
	public void setAcessoAprovador(String acessoAprovador) {
		this.acessoAprovador = acessoAprovador;
	}
	
	public PacienteEntity getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
		
	/*Visitas*/
	public Visita00Entity getVisita00() {  
	    if(this.visita00 == null) {  
	        this.visita00 = new Visita00Entity();       
	    }  
	    return visita00;  
	} 
	public void setVisita00(Visita00Entity visita00) {
		this.visita00 = visita00;
	}	
	
	public Visita01Entity getVisita01() {  
	    if(this.visita01 == null) {  
	        this.visita01 = new Visita01Entity();       
	    }  
	    return visita01;  
	}
	public void setVisita01(Visita01Entity visita01) {
		this.visita01 = visita01;
	}
	
	public Visita02Entity getVisita02() {  
	    if(this.visita02 == null) {  
	        this.visita02 = new Visita02Entity();       
	    }  
	    return visita02;  
	}
	public void setVisita02(Visita02Entity visita02) {
		this.visita02 = visita02;
	}
	
	public Visita03Entity getVisita03() {  
	    if(this.visita03 == null) {  
	        this.visita03 = new Visita03Entity();       
	    }  
	    return visita03;  
	}
	public void setVisita03(Visita03Entity visita03) {
		this.visita03 = visita03;
	}
	
	public Visita04Entity getVisita04() {  
	    if(this.visita04 == null) {  
	        this.visita04 = new Visita04Entity();       
	    }  
	    return visita04;  
	}
	public void setVisita04(Visita04Entity visita04) {
		this.visita04 = visita04;
	}
	
	public Visita05Entity getVisita05() {  
	    if(this.visita05 == null) {  
	        this.visita05 = new Visita05Entity();       
	    }  
	    return visita05;  
	}
	public void setVisita05(Visita05Entity visita05) {
		this.visita05 = visita05;
	}
	
	public Visita06Entity getVisita06() {  
	    if(this.visita06 == null) {  
	        this.visita06 = new Visita06Entity();       
	    }  
	    return visita06;  
	}
	public void setVisita06(Visita06Entity visita06) {
		this.visita06 = visita06;
	}
	
	public Visita07Entity getVisita07() {  
	    if(this.visita07 == null) {  
	        this.visita07 = new Visita07Entity();       
	    }  
	    return visita07;  
	}
	public void setVisita07(Visita07Entity visita07) {
		this.visita07 = visita07;
	}
	
	public Visita08Entity getVisita08() {  
	    if(this.visita08 == null) {  
	        this.visita08 = new Visita08Entity();       
	    }  
	    return visita08;  
	}
	public void setVisita08(Visita08Entity visita08) {
		this.visita08 = visita08;
	}
	
	public Visita09Entity getVisita09() {  
	    if(this.visita09 == null) {  
	        this.visita09 = new Visita09Entity();       
	    }  
	    return visita09;  
	}
	public void setVisita09(Visita09Entity visita09) {
		this.visita09 = visita09;
	}
	
	public Visita10Entity getVisita10() {  
	    if(this.visita10 == null) {  
	        this.visita10 = new Visita10Entity();       
	    }  
	    return visita10;  
	}
	public void setVisita10(Visita10Entity visita10) {
		this.visita10 = visita10;
	}
	
	public Visita11Entity getVisita11() {  
	    if(this.visita11 == null) {  
	        this.visita11 = new Visita11Entity();       
	    }  
	    return visita11;  
	}
	public void setVisita11(Visita11Entity visita11) {
		this.visita11 = visita11;
	}
	
	public Visita12Entity getVisita12() {  
	    if(this.visita12 == null) {  
	        this.visita12 = new Visita12Entity();       
	    }  
	    return visita12;  
	}
	public void setVisita12(Visita12Entity visita12) {
		this.visita12 = visita12;
	}
	
	public Visita13Entity getVisita13() {  
	    if(this.visita13 == null) {  
	        this.visita13 = new Visita13Entity();       
	    }  
	    return visita13;  
	}
	public void setVisita13(Visita13Entity visita13) {
		this.visita13 = visita13;
	}
	
	public Visita14Entity getVisita14() {  
	    if(this.visita14 == null) {  
	        this.visita14 = new Visita14Entity();       
	    }  
	    return visita14;  
	}
	public void setVisita14(Visita14Entity visita14) {
		this.visita14 = visita14;
	}
	
	public Visita15Entity getVisita15() {  
	    if(this.visita15 == null) {  
	        this.visita15 = new Visita15Entity();       
	    }  
	    return visita15;  
	}
	public void setVisita15(Visita15Entity visita15) {
		this.visita15 = visita15;
	}
	
	public Visita16Entity getVisita16() {  
	    if(this.visita16 == null) {  
	        this.visita16 = new Visita16Entity();       
	    }  
	    return visita16;  
	}
	public void setVisita16(Visita16Entity visita16) {
		this.visita16 = visita16;
	}
	
	public Visita17Entity getVisita17() {  
	    if(this.visita17 == null) {  
	        this.visita17 = new Visita17Entity();       
	    }  
	    return visita17;  
	}
	public void setVisita17(Visita17Entity visita17) {
		this.visita17 = visita17;
	}
	
	/*ADESÃO*/
	public AdesaoMedicacaoEntity getAdesaoMedicacao() {
		return adesaoMedicacao;
	}
	public void setAdesaoMedicacao(AdesaoMedicacaoEntity adesaoMedicacao) {
		this.adesaoMedicacao = adesaoMedicacao;
	}
	
	public AdesaoTratamentoEntity getAdesaoTratamento() {
		return adesaoTratamento;
	}
	public void setAdesaoTratamento(AdesaoTratamentoEntity adesaoTratamento) {
		this.adesaoTratamento = adesaoTratamento;
	}
	
	/*Overwrite*/
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.acessoAprovador = null;
	} 
	
	
}
