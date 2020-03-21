package br.com.morpheos.action.admin.grpmedicamento;

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
import br.com.morpheos.controller.GrpMedicamentoController;
import br.com.morpheos.entity.GrupoMedicamentoEntity;

public class GrpMedicamentoAction extends ActionBase{

	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GrpMedicamentoForm grupoForm = (GrpMedicamentoForm) form;
	
		GrpMedicamentoController grupoController = new GrpMedicamentoController();
		List<GrupoMedicamentoEntity> list =  grupoController.listarTodos();
		
		List<GrupoMedicamentoEntity> retorno = new ArrayList<GrupoMedicamentoEntity>();
		for(GrupoMedicamentoEntity grp : list){
			if(grupoController.countMedicamentoByGrupo(grp.getIdGrupoMedicamento()) <= 0){
				grp.setPodeExcluir(true);
			}
			retorno.add(grp);
		}
		
		
		grupoForm.setListGrupos(retorno);		
		
		return mapping.findForward("listar");
	}
	
	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GrpMedicamentoForm grupoForm = (GrpMedicamentoForm) form;				
		if(grupoForm.getIdParam() != null){			
			GrpMedicamentoController grupoController = new GrpMedicamentoController();
			grupoForm.setGrupo(grupoController.buscarById(grupoForm.getIdParam()));
		}else{
			grupoForm.reset(mapping, request);
		}
		saveToken(request);
		return mapping.findForward("formulario");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GrpMedicamentoForm grupoForm = (GrpMedicamentoForm) form;		
		GrpMedicamentoController grupoController = new GrpMedicamentoController(); 
		
		if(isTokenValid(request)) { 
			resetToken(request); 			   
			GrupoMedicamentoEntity grupo = grupoController.gravar(grupoForm.getGrupo());
			grupoForm.setGrupo(grupo);  
			grupoForm.setIdParam(grupo.getIdGrupoMedicamento());
		} 		
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.grpmedicamento.sucesso"));
        saveMessages(request, messages);		
        
		grupoForm.setListGrupos(grupoController.listarTodos());
        
		saveToken(request);
		return mapping.findForward("sucesso"); 
	}
	
	public ActionForward excluir(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GrpMedicamentoForm grupoForm = (GrpMedicamentoForm) form;
		
		GrpMedicamentoController controller = new GrpMedicamentoController();
		
		try{
			if(grupoForm.getIdParam() != null){
				controller.excluir(grupoForm.getIdParam());
			}
		}catch (Exception e) {
			System.out.println("Erro ao excluir doença: " + e.getMessage());
			ActionMessages errors = new ActionMessages();
			errors.add("doenca",new ActionMessage("error.exclusao.grpmedicamento", grupoForm.getIdParam()));	
			saveErrors(request, errors);
			saveToken(request);
			grupoForm.setListGrupos(controller.listarTodos());
			return mapping.findForward("listar");
		}					
		
		return mapping.findForward("sucesso"); 
		
	}
	
}
