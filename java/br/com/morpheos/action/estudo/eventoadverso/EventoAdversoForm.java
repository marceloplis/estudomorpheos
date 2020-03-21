package br.com.morpheos.action.estudo.eventoadverso;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.DoencaEventoEntity;
import br.com.morpheos.entity.EventoAdversoEntity;
import br.com.morpheos.entity.PacienteEntity;

public class EventoAdversoForm extends FormBase{

	private static final long serialVersionUID = 1L;

	private Long idPaciente;
	private Date dtInclusao;
	private String acessoAprovador;
	
	private PacienteEntity paciente;

	private EventoAdversoEntity evento;
	private List<EventoAdversoEntity> listEventos;
	
	private List<DoencaEventoEntity> listDoencas;
	
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
	
	public EventoAdversoEntity getEvento() {
		return evento;
	}
	public void setEvento(EventoAdversoEntity evento) {
		this.evento = evento;
	}
	public List<EventoAdversoEntity> getListEventos() {
		return listEventos;
	}
	public void setListEventos(List<EventoAdversoEntity> listEventos) {
		this.listEventos = listEventos;
	}
	
	public List<DoencaEventoEntity> getListDoencas() {
		return listDoencas;
	}
	public void setListDoencas(List<DoencaEventoEntity> listDoencas) {
		this.listDoencas = listDoencas;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( evento.getDtInicioParse() == null) {
	    	  errors.add("dtInicio",new ActionMessage("error.required.a","Data Início"));
	      }
	      if( evento.getNuVisita() == -1) {
	    	  errors.add("nuVisita",new ActionMessage("error.required.a","Visita do Evento"));
	      }
	      if( evento.getPER_E01() == null || evento.getPER_E01().length() < 1 ) {
	    	  errors.add("eventoSerio",new ActionMessage("error.required.a","Seriedade do Evento"));
	      }
	      if( evento.getPER_E02() == null || evento.getPER_E02().length() < 1 ) {
	    	  errors.add("providenciasTomadas",new ActionMessage("error.required.as","Providências Tomadas"));
	      }	      
	      if( evento.getPER_E04() == null || evento.getPER_E04().length() < 1 ) {
	    	  errors.add("relacionadoEstudo",new ActionMessage("error.required.o","Relacionamento com o Estudo"));
	      }
		  
	      return errors;
	}
	
	/*Overwrite*/
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.acessoAprovador = null;
	} 
	
	
}
