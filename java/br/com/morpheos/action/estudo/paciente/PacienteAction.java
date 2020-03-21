package br.com.morpheos.action.estudo.paciente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.action.helper.VisitasHelper;
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.controller.SaidaEstudoController;
import br.com.morpheos.controller.UnidadeAtendimentoController;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;
import br.com.morpheos.enums.PerfilEnum;

public class PacienteAction extends ActionBase{

	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PacienteForm pacienteform = (PacienteForm) form;
		pacienteform.setPaciente(new PacienteEntity());
		
		if(pacienteform.getIdParam() != null){
			PacienteController pacienteController = new PacienteController();
			pacienteform.setPaciente(pacienteController.buscarById(pacienteform.getIdParam()));
		}else{
			pacienteform.reset(mapping, request);
		}	
		
		VisitasHelper.getInstance().getStatusVisitas(request, pacienteform.getPaciente().getIdPaciente());
		
		UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		pacienteform.setListUnidades(unidadeController.listarTodos());
		
		saveToken(request);
		return mapping.findForward("formulario");
	}
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PacienteForm pacienteform = (PacienteForm) form;
		
		if(isTokenValid(request)) { 
			resetToken(request); 
			PacienteController pacienteController = new PacienteController();	    
			
			if(pacienteform.getPaciente().getIdPaciente() == null || pacienteform.getPaciente().getIdPaciente() == 0){
				
				PacienteEntity paciente = pacienteController.buscarByCpf(pacienteform.getPaciente().getCpf());
				if(paciente != null){
					ActionMessages errors = new ActionMessages();
					errors.add("paciente",new ActionMessage("error.paciente.cpf.existente", paciente.getCpf()));	
					saveErrors(request, errors);
					return mapping.findForward("formulario");
				}
				
			}
			
			PacienteEntity paciente = pacienteController.gravar(pacienteform.getPaciente());
			pacienteform.setPaciente(paciente);  
			pacienteform.setIdParam(paciente.getIdPaciente());		
			
		} 	
		
		VisitasHelper.getInstance().getStatusVisitas(request, pacienteform.getPaciente().getIdPaciente());
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.paciente.sucesso"));
        saveMessages(request, messages);
		
		saveToken(request);
		return mapping.findForward("sucesso"); 
	}	
	
	public ActionForward consulta(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		saveToken(request);
		return mapping.findForward("consulta");
	}
		
	public ActionForward buscar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		PacienteForm pacienteform = (PacienteForm) form;	
		
		if(pacienteform.getNmBusca().length() < 2){			
			return mapping.findForward("consulta");
		}
		
		if(isTokenValid(request)) {
			resetToken(request);
			PacienteController pacienteController = new PacienteController();
			List<PacienteEntity> pacientes = pacienteController.buscar(pacienteform.getNmBusca(), getUsuarioSession(request));
			
			pacienteform.setListPacientes(pacientes);
		}
		
		saveToken(request);
		return mapping.findForward("listar");
		
	}
	
	public ActionForward todos(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PacienteForm pacienteform = (PacienteForm) form;	
		
		PacienteController pacienteController = new PacienteController();
		List<PacienteEntity> pacientes = pacienteController.listTodos(getUsuarioSession(request));
			
		pacienteform.setListPacientes(pacientes);
		
		return mapping.findForward("listar");
		
	}
	
	public ActionForward apagar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PacienteForm pacienteform = (PacienteForm) form;
		
		//Apenas se for ADMIN
		if(getUsuarioSession(request).getPerfil().getIdPerfilAcesso() == PerfilEnum.ADMIN.getValue()){
		
			PacienteController pacienteController = new PacienteController();	
			PacienteEntity paciente = new PacienteEntity();
			
			paciente = pacienteController.buscarById(pacienteform.getIdParam());
			if(paciente != null){
				pacienteController.apagarPaciente(paciente);
				
				pacienteform.setIdParam(null);
			}
			
			ActionMessages messages = new ActionMessages();
			messages.add("message", new ActionMessage("msg.paciente.excluido.sucesso"));
	        saveMessages(request, messages);
	        
		}
		
		return mapping.findForward("consulta");
	}
	
	
	public ActionForward desfazerExclusao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PacienteForm pacienteform = (PacienteForm) form;
		
		PacienteController pController = new PacienteController();
		SaidaEstudoController scontroller = new SaidaEstudoController();  
				
		if(pacienteform.getPaciente() != null){
			pacienteform.getPaciente().setAtivo("S");
			pController.gravar(pacienteform.getPaciente());
			SaidaEstudoEntity saida = scontroller.buscarSaidaEstudoByIdPaciente(pacienteform.getPaciente().getIdPaciente());
			scontroller.excluir(saida, getUsuarioSession(request).getUsername());
		}
		
		ActionMessages messages = new ActionMessages();
		messages.add("message", new ActionMessage("msg.exclusao.paciente.rollback"));
        saveMessages(request, messages);
		
		return mapping.findForward("formulario");
	}
	
}
