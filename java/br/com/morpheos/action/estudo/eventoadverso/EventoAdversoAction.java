package br.com.morpheos.action.estudo.eventoadverso;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.action.helper.VisitasHelper;
import br.com.morpheos.controller.DoencaEventoController;
import br.com.morpheos.controller.EventoAdversoController;
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.entity.EventoAdversoEntity;

public class EventoAdversoAction extends ActionBase{

	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EventoAdversoForm eventoForm = (EventoAdversoForm) form;
		eventoForm.setEvento(new EventoAdversoEntity());
		if(eventoForm.getIdPaciente() != null){
			PacienteController pacienteController = new PacienteController();
			eventoForm.setPaciente(pacienteController.buscarById(eventoForm.getIdPaciente()));			
			
			EventoAdversoController eventoController = new EventoAdversoController();
			
			eventoForm.setListEventos(eventoController.buscarEventosByIdPaciente(eventoForm.getIdPaciente()));		
			
		}else{
			eventoForm.reset(mapping, request);
		}
		
		VisitasHelper.getInstance().getStatusVisitas(request, eventoForm.getIdPaciente());
		
		return mapping.findForward("listar");
	}
	
	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EventoAdversoForm eventoForm = (EventoAdversoForm) form;
		
		DoencaEventoController doencaController = new DoencaEventoController();
		eventoForm.setListDoencas(doencaController.listarTodos());		
		
		eventoForm.setEvento(new EventoAdversoEntity());
		if(eventoForm.getIdParam() != null){
			EventoAdversoController eventoController = new EventoAdversoController();
			eventoForm.setEvento(eventoController.buscarById(eventoForm.getIdParam()));	
			
			PacienteController pacienteController = new PacienteController();
			eventoForm.setPaciente(pacienteController.buscarById(eventoForm.getIdPaciente()));
			
		}else{
			eventoForm.getEvento().setDtInclusao(new Date());
			eventoForm.reset(mapping, request);			
		}
		
		VisitasHelper.getInstance().getStatusVisitas(request, eventoForm.getIdPaciente());
		
		saveToken(request);		
		return mapping.findForward("formevento");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EventoAdversoForm eventoForm = (EventoAdversoForm) form;	
		
		String flAprovador = eventoForm.getAcessoAprovador() != null ? eventoForm.getAcessoAprovador() : "N";
		if(isTokenValid(request) || flAprovador.equals("S")) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				eventoForm.getEvento().setDtAssinatura(new Date());
			}			
			EventoAdversoController eventoController = new EventoAdversoController();    
			
			EventoAdversoEntity evento = eventoController.gravarEvento(eventoForm.getEvento(), getUsuarioSession(request).getUsername());
			eventoForm.setEvento(evento);
			
		} 			
		
		EventoAdversoController eventoController = new EventoAdversoController();		
		eventoForm.setListEventos(eventoController.buscarEventosByIdPaciente(eventoForm.getIdPaciente()));
		
		VisitasHelper.getInstance().getStatusVisitas(request, eventoForm.getEvento().getPaciente().getIdPaciente());
		
		saveToken(request);		
		
		ActionMessages messages = new ActionMessages();       
		
        if(flAprovador.equals("S")){
        	 messages.add("message", new ActionMessage("msg.aprovacao.evento.sucesso", eventoForm.getEvento().getPaciente().getIniciaisNome()));
             saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	messages.add("message", new ActionMessage("msg.evento.sucesso"));
            saveMessages(request, messages);
            return mapping.findForward("sucesso");
        }
	}
	
	
	public ActionForward excluir(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EventoAdversoForm eventoForm = (EventoAdversoForm) form;
					
		EventoAdversoController eventoController = new EventoAdversoController();	
		EventoAdversoEntity evento = new EventoAdversoEntity();
		
		evento = eventoController.buscarById(eventoForm.getIdParam());
		if(evento != null){
			eventoController.excluirEvento(evento, getUsuarioSession(request).getUsername());	
			
			eventoForm.setListEventos(eventoController.buscarEventosByIdPaciente(eventoForm.getIdPaciente()));	
			
			eventoForm.setIdParam(null);
		}
		
		VisitasHelper.getInstance().getStatusVisitas(request, eventoForm.getIdPaciente());
		
		ActionMessages messages = new ActionMessages();
		messages.add("message", new ActionMessage("msg.evento.excluido.sucesso"));
        saveMessages(request, messages);
		
		return mapping.findForward("sucesso");
	}
	
	
	public ActionForward desfazerAprovacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EventoAdversoForm eventoForm = (EventoAdversoForm) form;
		
		EventoAdversoController eController = new EventoAdversoController();
		EventoAdversoEntity evento = eController.buscarById(eventoForm.getIdParam().longValue());
		
		if(evento != null){
			evento.setStAprovacao("P");
			evento.setAssinatura(null);
			evento.setDtAssinatura(null);
			eController.gravarEvento(evento, getUsuarioSession(request).getUsername());
			eventoForm.setIdParam(null);
		}		
		
		VisitasHelper.getInstance().getStatusVisitas(request, evento.getPaciente().getIdPaciente());
		
		eventoForm.setListEventos(eController.buscarEventosByIdPaciente(evento.getPaciente().getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();
		messages.add("message", new ActionMessage("msg.aprovacao.evento.rollback"));
        saveMessages(request, messages);
		
        return mapping.findForward("sucesso");
	}
	
	
}
