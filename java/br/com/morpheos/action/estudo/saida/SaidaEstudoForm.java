package br.com.morpheos.action.estudo.saida;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;

public class SaidaEstudoForm extends FormBase{

	private static final long serialVersionUID = 1L;
	
	private Long idPaciente;
	private String acessoAprovador;
	
	private PacienteEntity paciente;
	private SaidaEstudoEntity saida;
	
	public String getAcessoAprovador() {
		return acessoAprovador;
	}
	public void setAcessoAprovador(String acessoAprovador) {
		this.acessoAprovador = acessoAprovador;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public PacienteEntity getPaciente() {
		return paciente;
	}
	
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	
	public SaidaEstudoEntity getSaida() {
		return saida;
	}
	
	public void setSaida(SaidaEstudoEntity saida) {
		this.saida = saida;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( saida.getDtSaida() == null) {
	    	  errors.add("dtSaida",new ActionMessage("error.required.a","Data de Saída"));
	      }
	      if( saida.getNuVisita() == -1) {
	    	  errors.add("nuVisita",new ActionMessage("error.required.a","Visita da Exclusão"));
	      }
	      if( saida.getMotivo() == null || saida.getMotivo() <= 0 ) {
	    	  errors.add("motivo",new ActionMessage("error.required.o","Motivo da Saída"));
	      }
	      
		  
	      return errors;
	}
	
	/*Overwrite*/
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.acessoAprovador = null;
	} 
	
}
