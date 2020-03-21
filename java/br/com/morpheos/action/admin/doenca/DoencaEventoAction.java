package br.com.morpheos.action.admin.doenca;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.DoencaEventoController;
import br.com.morpheos.controller.EventoAdversoController;
import br.com.morpheos.entity.DoencaEventoEntity;

public class DoencaEventoAction extends ActionBase{

	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoencaEventoForm doencaform = (DoencaEventoForm) form;
	
		DoencaEventoController doencaController = new DoencaEventoController();
		List<DoencaEventoEntity> list = doencaController.listarTodos();
		
		EventoAdversoController eventoController = new EventoAdversoController();
		List<DoencaEventoEntity> retorno = new ArrayList<DoencaEventoEntity>();
		for(DoencaEventoEntity doenca : list){
			if(eventoController.countEventosByDoenca(doenca.getIdDoencaEvento()) <= 0){
				doenca.setPodeExcluir(true);
			}
			retorno.add(doenca);
		}
		
		doencaform.setListDoencas(retorno);

		return mapping.findForward("listar");
	}
	
	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DoencaEventoForm doencaform = (DoencaEventoForm) form;		
		
		if(doencaform.getIdParam() != null){			
			DoencaEventoController doencaController = new DoencaEventoController();
			doencaform.setDoenca(doencaController.buscarById(doencaform.getIdParam()));
		}else{
			doencaform.reset(mapping, request);
		}
		
		return mapping.findForward("formulario");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoencaEventoForm doencaform = (DoencaEventoForm) form;
		
		if(isTokenValid(request)) { 
			resetToken(request); 
			DoencaEventoController doencaController = new DoencaEventoController();    
			DoencaEventoEntity doenca = doencaController.gravar(doencaform.getDoenca());
			doencaform.setDoenca(doenca);  
			doencaform.setIdParam(doenca.getIdDoencaEvento());
		} 		
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.doenca.sucesso"));
        saveMessages(request, messages);
		
        DoencaEventoController doencaController = new DoencaEventoController();
		doencaform.setListDoencas(doencaController.listarTodos());
        
		saveToken(request);
		return mapping.findForward("sucesso"); 
	}
	
	public ActionForward excluir(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoencaEventoForm doencaform = (DoencaEventoForm) form;
		
		DoencaEventoController doencaController = new DoencaEventoController();
		
		
		try{
			if(doencaform.getIdParam() != null){
				doencaController.excluir(doencaform.getIdParam());
			}
		}catch (Exception e) {
			System.out.println("Erro ao excluir doença: " + e.getMessage());
			ActionMessages errors = new ActionMessages();
			errors.add("doenca",new ActionMessage("error.exclusao.doenca", doencaform.getIdParam()));	
			saveErrors(request, errors);
			saveToken(request);
			doencaform.setListDoencas(doencaController.listarTodos());
			return mapping.findForward("listar");
		}					
		
		return mapping.findForward("sucesso"); 
		
	}
	
}
