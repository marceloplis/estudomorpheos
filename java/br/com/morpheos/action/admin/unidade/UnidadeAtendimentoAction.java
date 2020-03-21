package br.com.morpheos.action.admin.unidade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.UnidadeAtendimentoController;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class UnidadeAtendimentoAction extends ActionBase{

	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UnidadeAtendimentoForm unidadeform = (UnidadeAtendimentoForm) form;
	
		UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		unidadeform.setListUnidades(unidadeController.listarTodos());
		
		return mapping.findForward("listar");
	}
	
	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UnidadeAtendimentoForm unidadeform = (UnidadeAtendimentoForm) form;				
		if(unidadeform.getIdParam() != null){			
			UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
			unidadeform.setUnidade(unidadeController.buscarById(unidadeform.getIdParam()));
		}else{
			unidadeform.reset(mapping, request);
		}
		saveToken(request);
		return mapping.findForward("formulario");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UnidadeAtendimentoForm unidadeform = (UnidadeAtendimentoForm) form;
		
		if(isTokenValid(request)) { 
			resetToken(request); 
			UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();    
			UnidadeAtendimentoEntity unidade = unidadeController.gravar(unidadeform.getUnidade());
			unidadeform.setUnidade(unidade);  
			unidadeform.setIdParam(unidade.getIdUnidadePesquisa());
		} 	
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.unidade.sucesso"));
        saveMessages(request, messages);
		
        UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		unidadeform.setListUnidades(unidadeController.listarTodos());
        
		saveToken(request);
		return mapping.findForward("sucesso"); 
	}	
	
}
