package br.com.morpheos.action.admin.medicamento;

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
import br.com.morpheos.controller.MedicamentoController;
import br.com.morpheos.entity.MedicamentoEntity;

public class MedicamentoAction extends ActionBase{

	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MedicamentoForm medicamentoForm = (MedicamentoForm) form;
	
		MedicamentoController medicamentoController = new MedicamentoController();
		List<MedicamentoEntity> list =  medicamentoController.listarTodos();
		
		List<MedicamentoEntity> retorno = new ArrayList<MedicamentoEntity>();
		for(MedicamentoEntity med : list){
			if(medicamentoController.countUsoByMedicamento(med.getIdMedicamento()) <= 0){
				med.setPodeExcluir(true);
			}
			retorno.add(med);
		}
		
		medicamentoForm.setListMedicamentos(retorno);
		
		return mapping.findForward("listar");
	}
	
	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MedicamentoForm medicamentoForm = (MedicamentoForm) form;				
		if(medicamentoForm.getIdParam() != null){			
			MedicamentoController medicamentoController = new MedicamentoController();
			medicamentoForm.setMedicamento(medicamentoController.buscarById(medicamentoForm.getIdParam()));
		}else{
			medicamentoForm.reset(mapping, request);
		}
		GrpMedicamentoController grpController = new GrpMedicamentoController();
		medicamentoForm.setListGrupos(grpController.listarTodos());
		saveToken(request);
		return mapping.findForward("formulario");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MedicamentoForm medicamentoForm = (MedicamentoForm) form;
		
		MedicamentoController medicamentoController = new MedicamentoController();
		
		if(isTokenValid(request)) { 			 			
			MedicamentoEntity medicamento = medicamentoController.gravar(medicamentoForm.getMedicamento());
			medicamentoForm.setMedicamento(medicamento);  
			medicamentoForm.setIdParam(medicamento.getIdMedicamento());
			resetToken(request);
		} 		
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.medicamento.sucesso"));
        saveMessages(request, messages);		
        
		saveToken(request);
		return mapping.findForward("sucesso"); 
	}	
	
	public ActionForward excluir(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MedicamentoForm medicamentoForm = (MedicamentoForm) form;
		
		MedicamentoController medicamentoController = new MedicamentoController();
		
		try{
			if(medicamentoForm.getIdParam() != null){
				medicamentoController.excluir(medicamentoController.buscarById(medicamentoForm.getIdParam()));
			}
		}catch (Exception e) {
			System.out.println("Erro ao excluir doença: " + e.getMessage());
			ActionMessages errors = new ActionMessages();
			errors.add("doenca",new ActionMessage("error.exclusao.medicamento", medicamentoForm.getIdParam()));	
			saveErrors(request, errors);
			saveToken(request);
			medicamentoForm.setListMedicamentos(medicamentoController.listarTodos());
			return mapping.findForward("listar");
		}					
		
		return mapping.findForward("sucesso"); 
		
	}
	
}
