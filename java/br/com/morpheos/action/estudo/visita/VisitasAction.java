package br.com.morpheos.action.estudo.visita;

import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.action.helper.VisitasHelper;
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.controller.VisitasController;
import br.com.morpheos.entity.AdesaoMedicacaoEntity;
import br.com.morpheos.entity.AdesaoTratamentoEntity;
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
import br.com.morpheos.entity.VisitaEntity;

public class VisitasAction extends ActionBase{

	ResourceBundle bundle = ResourceBundle.getBundle("morpheos");
	
	/*visita00*/
	public ActionForward visita00(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		VisitasController visitasController = new VisitasController();
		
		if(visitaForm.getIdPaciente() != null){
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));			
			
			visitaForm.setVisita00(new Visita00Entity());
			Visita00Entity visita = visitasController.buscarVisita00ByIdPaciente(visitaForm.getIdPaciente());
			if(visita != null){
				visitaForm.setVisita00(visita);				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita00");
	}
	
	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita00(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validateVisita00(mapping, request, visitaForm.getVisita00());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita00");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita00().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita00Entity visita00 = visitaController.gravarVisita00(visitaForm.getVisita00(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita00(visita00);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita00().getVisita().getNuVisita(), visitaForm.getVisita00().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita00().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso00");
        }
        
	}
	
	
	/*visita01*/
	public ActionForward visita01(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if(visitaForm.getIdPaciente() != null){
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(0L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));			
			
			visitaForm.setVisita01(new Visita01Entity());
			Visita01Entity visita = visitasController.buscarVisita01ByIdPaciente(visitaForm.getIdPaciente());
			if(visita != null){
				visitaForm.setVisita01(visita);				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita01");
	}
	
	
	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita01(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita01().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita01");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita01().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita01Entity visita01 = visitaController.gravarVisita01(visitaForm.getVisita01(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita01(visita01);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita01(visitaController.buscarVisita01ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita01().getVisita().getNuVisita(), visitaForm.getVisita01().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita01().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso01");
        }
	}
	
	
	/*visita02*/
	public ActionForward visita02(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if(visitaForm.getIdPaciente() != null){
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(1L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));
			
			visitaForm.setVisita02(new Visita02Entity());
			Visita02Entity visita = visitasController.buscarVisita02ByIdPaciente(visitaForm.getIdPaciente());
			if(visita != null){
				visitaForm.setVisita02(visita);				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita02");
	}
	
	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita02(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita02().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita02");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita02().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita02Entity visita02 = visitaController.gravarVisita02(visitaForm.getVisita02(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita02(visita02);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita02(visitaController.buscarVisita02ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita02().getVisita().getNuVisita(), visitaForm.getVisita02().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita02().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso02");
        }
	}
	
	/*Visita 3*/
	public ActionForward visita03(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(2L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita03(new Visita03Entity());
			Visita03Entity visita = visitasController.buscarVisita03ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita03(visita);
			} 
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita03");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita03(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita03().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita03");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) {
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita03().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita03Entity visita03 = visitaController.gravarVisita03(visitaForm.getVisita03(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita03(visita03);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita03(visitaController.buscarVisita03ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita03().getVisita().getNuVisita(), visitaForm.getVisita03().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita03().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso03");
        }
	}

	/*Visita 4*/
	public ActionForward visita04(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(3L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita04(new Visita04Entity());

			Visita04Entity visita = visitasController.buscarVisita04ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita04(visita);
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita04");
	}
				
	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita04(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita04().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita04");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita04().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita04Entity visita04 = visitaController.gravarVisita04(visitaForm.getVisita04(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita04(visita04);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita04(visitaController.buscarVisita04ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita04().getVisita().getNuVisita(), visitaForm.getVisita04().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita04().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso04");
        }
	}
			
	/*Visita 5*/
	public ActionForward visita05(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(4L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita05(new Visita05Entity());
			Visita05Entity visita = visitasController.buscarVisita05ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita05(visita);
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita05");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita05(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita05().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita05");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) {
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita05().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita05Entity visita05 = visitaController.gravarVisita05(visitaForm.getVisita05(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita05(visita05);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita05(visitaController.buscarVisita05ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita05().getVisita().getNuVisita(), visitaForm.getVisita05().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita05().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso05");
        }
	}

	/*Visita 6*/
	public ActionForward visita06(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(5L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita06(new Visita06Entity());
			Visita06Entity visita = visitasController.buscarVisita06ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita06(visita);
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita06");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita06(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita06().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita06");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita06().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita06Entity visita06 = visitaController.gravarVisita06(visitaForm.getVisita06(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita06(visita06);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita06(visitaController.buscarVisita06ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita06().getVisita().getNuVisita(), visitaForm.getVisita06().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita06().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso06");
        }
	}

	/*Visita 7*/
	public ActionForward visita07(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(6L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita07(new Visita07Entity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita07Entity visita = visitasController.buscarVisita07ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita07(visita);
								
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
			}						
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita07");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita07(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita07().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita07");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita07().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita07Entity visita07 = visitaController.gravarVisita07(visitaForm.getVisita07(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita07(visita07);	
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita07().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita07(visitaController.buscarVisita07ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita07().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita07().getVisita().getNuVisita(), visitaForm.getVisita07().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita07().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso07");
        }
	}

	/*Visita 8*/
	public ActionForward visita08(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(7L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita08(new Visita08Entity());
			visitaForm.setAdesaoMedicacao(new AdesaoMedicacaoEntity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita08Entity visita = visitasController.buscarVisita08ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita08(visita);
				
				AdesaoMedicacaoEntity adesaoMedicacao = visitasController.buscarAdesaoMedicacao(visita.getVisita().getIdVisita());
				if(adesaoMedicacao != null){
					visitaForm.setAdesaoMedicacao(adesaoMedicacao);
				}
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita08");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita08(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita08().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita08");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita08().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita08Entity visita08 = visitaController.gravarVisita08(visitaForm.getVisita08(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita08(visita08);	
			
			visitaForm.getAdesaoMedicacao().setVisita(visitaForm.getVisita08().getVisita());
			AdesaoMedicacaoEntity adesaoMedicacao = visitaController.gravarAdesaoMedicacao(visitaForm.getAdesaoMedicacao());
			visitaForm.setAdesaoMedicacao(adesaoMedicacao);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita08().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita08(visitaController.buscarVisita08ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoMedicacao(visitaController.buscarAdesaoMedicacao(visitaForm.getVisita08().getVisita().getIdVisita()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita08().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita08().getVisita().getNuVisita(), visitaForm.getVisita08().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita08().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso08");
        }
	}

	/*Visita 9*/
	public ActionForward visita09(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(8L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita09(new Visita09Entity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita09Entity visita = visitasController.buscarVisita09ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita09(visita);
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita09");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita09(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita09().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita09");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita09().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita09Entity visita09 = visitaController.gravarVisita09(visitaForm.getVisita09(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita09(visita09);	
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita09().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita09(visitaController.buscarVisita09ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita09().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita09().getVisita().getNuVisita(), visitaForm.getVisita09().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita09().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso09");
        }
	}

	/*Visita 10*/
	public ActionForward visita10(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(9L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita10(new Visita10Entity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita10Entity visita = visitasController.buscarVisita10ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita10(visita);
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita10");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita10(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita10().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita10");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita10().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita10Entity visita10 = visitaController.gravarVisita10(visitaForm.getVisita10(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita10(visita10);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita10().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita10(visitaController.buscarVisita10ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita10().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita10().getVisita().getNuVisita(), visitaForm.getVisita10().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita10().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso10");
        }
	}

	/*Visita 11*/
	public ActionForward visita11(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(10L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita11(new Visita11Entity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita11Entity visita = visitasController.buscarVisita11ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita11(visita);
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita11");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita11(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita11().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita11");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita11().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita11Entity visita11 = visitaController.gravarVisita11(visitaForm.getVisita11(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita11(visita11);	
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita11().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita11(visitaController.buscarVisita11ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita11().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita11().getVisita().getNuVisita(), visitaForm.getVisita11().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita11().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso11");
        }
	}

	/*Visita 12*/
	public ActionForward visita12(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(11L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita12(new Visita12Entity());
			visitaForm.setAdesaoMedicacao(new AdesaoMedicacaoEntity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita12Entity visita = visitasController.buscarVisita12ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita12(visita);
				
				AdesaoMedicacaoEntity adesaoMedicacao = visitasController.buscarAdesaoMedicacao(visita.getVisita().getIdVisita());
				if(adesaoMedicacao != null){
					visitaForm.setAdesaoMedicacao(adesaoMedicacao);
				}
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita12");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita12(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita12().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita12");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita12().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita12Entity visita12 = visitaController.gravarVisita12(visitaForm.getVisita12(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita12(visita12);
			
			visitaForm.getAdesaoMedicacao().setVisita(visitaForm.getVisita12().getVisita());
			AdesaoMedicacaoEntity adesaoMedicacao = visitaController.gravarAdesaoMedicacao(visitaForm.getAdesaoMedicacao());
			visitaForm.setAdesaoMedicacao(adesaoMedicacao);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita12().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita12(visitaController.buscarVisita12ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoMedicacao(visitaController.buscarAdesaoMedicacao(visitaForm.getVisita12().getVisita().getIdVisita()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita12().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita12().getVisita().getNuVisita(), visitaForm.getVisita12().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita12().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso12");
        }
	}

	/*Visita 13*/
	public ActionForward visita13(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(12L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita13(new Visita13Entity());
			visitaForm.setAdesaoMedicacao(new AdesaoMedicacaoEntity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita13Entity visita = visitasController.buscarVisita13ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita13(visita);
				
				AdesaoMedicacaoEntity adesaoMedicacao = visitasController.buscarAdesaoMedicacao(visita.getVisita().getIdVisita());
				if(adesaoMedicacao != null){
					visitaForm.setAdesaoMedicacao(adesaoMedicacao);
				}
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita13");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita13(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita13().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita13");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) {  
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita13().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita13Entity visita13 = visitaController.gravarVisita13(visitaForm.getVisita13(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita13(visita13);		
			
			visitaForm.getAdesaoMedicacao().setVisita(visitaForm.getVisita13().getVisita());
			AdesaoMedicacaoEntity adesaoMedicacao = visitaController.gravarAdesaoMedicacao(visitaForm.getAdesaoMedicacao());
			visitaForm.setAdesaoMedicacao(adesaoMedicacao);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita13().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita13(visitaController.buscarVisita13ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoMedicacao(visitaController.buscarAdesaoMedicacao(visitaForm.getVisita13().getVisita().getIdVisita()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita13().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita13().getVisita().getNuVisita(), visitaForm.getVisita13().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita13().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso13");
        }
	}

	/*Visita 14*/
	public ActionForward visita14(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(13L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita14(new Visita14Entity());
			visitaForm.setAdesaoMedicacao(new AdesaoMedicacaoEntity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita14Entity visita = visitasController.buscarVisita14ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita14(visita);
				
				AdesaoMedicacaoEntity adesaoMedicacao = visitasController.buscarAdesaoMedicacao(visita.getVisita().getIdVisita());
				if(adesaoMedicacao != null){
					visitaForm.setAdesaoMedicacao(adesaoMedicacao);
				}
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita14");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita14(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita14().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita14");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita14().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita14Entity visita14 = visitaController.gravarVisita14(visitaForm.getVisita14(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita14(visita14);	
			
			visitaForm.getAdesaoMedicacao().setVisita(visitaForm.getVisita14().getVisita());
			AdesaoMedicacaoEntity adesaoMedicacao = visitaController.gravarAdesaoMedicacao(visitaForm.getAdesaoMedicacao());
			visitaForm.setAdesaoMedicacao(adesaoMedicacao);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita14().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita14(visitaController.buscarVisita14ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoMedicacao(visitaController.buscarAdesaoMedicacao(visitaForm.getVisita14().getVisita().getIdVisita()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita14().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita14().getVisita().getNuVisita(), visitaForm.getVisita14().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita14().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso14");
        }
	}

	/*Visita 15*/
	public ActionForward visita15(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(14L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita15(new Visita15Entity());
			visitaForm.setAdesaoMedicacao(new AdesaoMedicacaoEntity());
			visitaForm.setAdesaoTratamento(new AdesaoTratamentoEntity());
			
			Visita15Entity visita = visitasController.buscarVisita15ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita15(visita);
				
				AdesaoMedicacaoEntity adesaoMedicacao = visitasController.buscarAdesaoMedicacao(visita.getVisita().getIdVisita());
				if(adesaoMedicacao != null){
					visitaForm.setAdesaoMedicacao(adesaoMedicacao);
				}
				
				AdesaoTratamentoEntity adesaoTratamento = visitasController.buscarAdesaoTratamento(visita.getVisita().getIdVisita());
				if(adesaoTratamento != null){
					visitaForm.setAdesaoTratamento(adesaoTratamento);
				}
				
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita15");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita15(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita15().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita15");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) {  
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita15().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita15Entity visita15 = visitaController.gravarVisita15(visitaForm.getVisita15(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita15(visita15);		
			
			visitaForm.getAdesaoMedicacao().setVisita(visitaForm.getVisita15().getVisita());
			AdesaoMedicacaoEntity adesaoMedicacao = visitaController.gravarAdesaoMedicacao(visitaForm.getAdesaoMedicacao());
			visitaForm.setAdesaoMedicacao(adesaoMedicacao);
			
			visitaForm.getAdesaoTratamento().setVisita(visitaForm.getVisita15().getVisita());
			AdesaoTratamentoEntity adesaoTratamento = visitaController.gravarAdesaoTratamento(visitaForm.getAdesaoTratamento());
			visitaForm.setAdesaoTratamento(adesaoTratamento);
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita15(visitaController.buscarVisita15ByIdPaciente(visitaForm.getIdPaciente()));
		visitaForm.setAdesaoMedicacao(visitaController.buscarAdesaoMedicacao(visitaForm.getVisita15().getVisita().getIdVisita()));
		visitaForm.setAdesaoTratamento(visitaController.buscarAdesaoTratamento(visitaForm.getVisita15().getVisita().getIdVisita()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita15().getVisita().getNuVisita(), visitaForm.getVisita15().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita15().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso15");
        }
	}

	/*Visita 16*/
	public ActionForward visita16(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(15L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita16(new Visita16Entity());
			Visita16Entity visita = visitasController.buscarVisita16ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita16(visita);
			}
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita16");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita16(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita16().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita16");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita16().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita16Entity visita16 = visitaController.gravarVisita16(visitaForm.getVisita16(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita16(visita16);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita16(visitaController.buscarVisita16ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita16().getVisita().getNuVisita(), visitaForm.getVisita16().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita16().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso16");
        }
	}

	/*Visita 17*/
	public ActionForward visita17(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		visitaForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visitaForm.getNuVisita()));
		
		if (visitaForm.getIdPaciente() != null) {
			VisitasController visitasController = new VisitasController();
			if(!visitasController.validaVisitaAnterior(16L, visitaForm.getIdPaciente())){
				request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.visita.nao.preenchida"));
				return mapping.findForward("erro-fluxo");
			}
			
			PacienteController pacienteController = new PacienteController();
			visitaForm.setPaciente(pacienteController.buscarById(visitaForm.getIdPaciente()));

			visitaForm.setVisita17(new Visita17Entity());
			Visita17Entity visita = visitasController.buscarVisita17ByIdPaciente(visitaForm.getIdPaciente());
			if (visita != null) {
				visitaForm.setVisita17(visita);
			} 
			
			VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
			
		} else {
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		saveToken(request);
		
		return mapping.findForward("formvisita17");
	}

	@SuppressWarnings("deprecation")
	public ActionForward gravarvisita17(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		VisitasForm visitaForm = (VisitasForm) form;
		
		ActionErrors errors = VisitasHelper.getInstance().validate(mapping, request, visitaForm.getVisita17().getVisita());
		if(errors.size() > 0){
			saveErrors(request, errors);
			return mapping.findForward("formvisita17");
		}
		
		VisitasController visitaController = new VisitasController();	    
		
		String flAprovador = visitaForm.getAcessoAprovador() != null ? visitaForm.getAcessoAprovador() : "N";
		String errorSystem = request.getSession().getAttribute("errorSystem") != null ? (String)request.getSession().getAttribute("errorSystem") : "N";
		if((isTokenValid(request) || flAprovador.equals("S")) || (errorSystem.equals("S"))) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				visitaForm.getVisita17().getVisita().setDtAssinaturaAprovacao(new Date());
			}
			Visita17Entity visita17 = visitaController.gravarVisita17(visitaForm.getVisita17(), getUsuarioSession(request).getUsername());
			visitaForm.setVisita17(visita17);			
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);	
		request.getSession().setAttribute("errorSystem", "N");
		
		visitaForm.setVisita17(visitaController.buscarVisita17ByIdPaciente(visitaForm.getIdPaciente()));
		
		ActionMessages messages = new ActionMessages();        
		
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.visita.sucesso", visitaForm.getVisita17().getVisita().getNuVisita(), visitaForm.getVisita17().getVisita().getPaciente().getIniciaisNome()));
            saveMessages(request, messages);
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	VisitasHelper.getInstance().getStatusVisitas(request, visitaForm.getIdPaciente());
        	
        	messages.add("message", new ActionMessage("msg.visita.sucesso", visitaForm.getVisita17().getVisita().getNuVisita()));
            saveMessages(request, messages);
        	return mapping.findForward("sucesso17");
        }        
        
	}
	
	
	public ActionForward desfazerAprovacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		VisitasForm visitaForm = (VisitasForm) form;
		
		VisitasController vController = new VisitasController();
		VisitaEntity visita = vController.buscaVisitaEntityById(visitaForm.getIdParam().longValue());
		
		if(visita != null){
			visita.setStAprovacao(null);
			visita.setAssinaturaAprovador(null);
			visita.setDtAssinaturaAprovacao(null);
			vController.gravarVisitaEntity(visita, getUsuarioSession(request).getUsername());
		}
		
		if(visita.getNuVisita() == 0)
			visitaForm.setVisita00(vController.buscarVisita00ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 1)
			visitaForm.setVisita01(vController.buscarVisita01ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 2)
			visitaForm.setVisita02(vController.buscarVisita02ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 3)
			visitaForm.setVisita03(vController.buscarVisita03ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 4)
			visitaForm.setVisita04(vController.buscarVisita04ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 5)
			visitaForm.setVisita05(vController.buscarVisita05ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 6)
			visitaForm.setVisita06(vController.buscarVisita06ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 7)
			visitaForm.setVisita07(vController.buscarVisita07ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 8)
			visitaForm.setVisita08(vController.buscarVisita08ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 9)
			visitaForm.setVisita09(vController.buscarVisita09ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 10)
			visitaForm.setVisita10(vController.buscarVisita10ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 11)
			visitaForm.setVisita11(vController.buscarVisita11ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 12)
			visitaForm.setVisita12(vController.buscarVisita12ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 13)
			visitaForm.setVisita13(vController.buscarVisita13ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 14)
			visitaForm.setVisita14(vController.buscarVisita14ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 15)
			visitaForm.setVisita15(vController.buscarVisita15ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 16)
			visitaForm.setVisita16(vController.buscarVisita16ByIdPaciente(visita.getPaciente().getIdPaciente()));
		if(visita.getNuVisita() == 17)
			visitaForm.setVisita17(vController.buscarVisita17ByIdPaciente(visita.getPaciente().getIdPaciente()));
		
		
		VisitasHelper.getInstance().getStatusVisitas(request, visita.getPaciente().getIdPaciente());
		
		ActionMessages messages = new ActionMessages();
		messages.add("message", new ActionMessage("msg.aprovacao.visita.rollback", visita.getNuVisita()));
        saveMessages(request, messages);
		
		String nuVisita = visita.getNuVisita() < 10 ? "0"+visita.getNuVisita() : visita.getNuVisita().toString();		
		
		return mapping.findForward("formvisita"+nuVisita);
	}

	
}