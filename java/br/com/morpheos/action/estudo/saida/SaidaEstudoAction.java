package br.com.morpheos.action.estudo.saida;

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
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.controller.SaidaEstudoController;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;

public class SaidaEstudoAction extends ActionBase{

	public ActionForward formulario(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SaidaEstudoForm saidaForm = (SaidaEstudoForm) form;	
		
		PacienteController pacienteController = new PacienteController();
		saidaForm.setPaciente(pacienteController.buscarById(saidaForm.getIdPaciente()));		
		
		SaidaEstudoController controller = new SaidaEstudoController();
		saidaForm.setSaida(controller.buscarSaidaEstudoByIdPaciente(saidaForm.getIdPaciente()));
				
		if(saidaForm.getSaida() == null){						
			saidaForm.setSaida(new SaidaEstudoEntity());
			saidaForm.getSaida().setDtInclusao(new Date());
			saidaForm.reset(mapping, request);			
		}
		
		VisitasHelper.getInstance().getStatusVisitas(request, saidaForm.getIdPaciente());
		
		saveToken(request);	
		
		return mapping.findForward("formulario");
	}
	
	
	public ActionForward gravar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SaidaEstudoForm saidaForm = (SaidaEstudoForm) form;
		
		String flAprovador = saidaForm.getAcessoAprovador() != null ? saidaForm.getAcessoAprovador() : "N";
		if(isTokenValid(request) || flAprovador.equals("S")) { 
			resetToken(request); 			
			
			if(flAprovador.equals("S")){
				saidaForm.getSaida().setDtAssinatura(new Date());
			}
			resetToken(request); 			
			SaidaEstudoController controller = new SaidaEstudoController();    
			
			SaidaEstudoEntity saida = controller.gravarSaidaEstudo(saidaForm.getSaida(), getUsuarioSession(request).getUsername());
			
			PacienteController pacienteController = new PacienteController();
			PacienteEntity paciente = saidaForm.getPaciente();
			paciente.setAtivo("N");			
			pacienteController.gravar(paciente);
			
			saidaForm.setSaida(saida);
			
		} 			
		
		VisitasHelper.getInstance().getStatusVisitas(request, saidaForm.getSaida().getPaciente().getIdPaciente());
		
		saveToken(request);		
		
		ActionMessages messages = new ActionMessages();
        
        if(flAprovador.equals("S")){
        	messages.add("message", new ActionMessage("msg.aprovacao.saida.sucesso", saidaForm.getPaciente().getIniciaisNome()));
            saveMessages(request, messages);		
    		
        	return mapping.findForward("sucessoaprovacao");
        }else{
        	messages.add("message", new ActionMessage("msg.saida.estudo.sucesso"));
            saveMessages(request, messages);		
    		
        	return mapping.findForward("sucessosaida");
        }
		
	}
	
	public ActionForward desfazerAprovacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SaidaEstudoForm saidaForm = (SaidaEstudoForm) form;
		
		SaidaEstudoController sController = new SaidaEstudoController();
		SaidaEstudoEntity saida = sController.buscarSaidaEstudoByIdPaciente(saidaForm.getIdParam().longValue());
		
		if(saida != null){
			saida.setStAprovacao(null);
			saida.setAssinatura(null);
			saida.setDtAssinatura(null);
			sController.gravarSaidaEstudo(saida, getUsuarioSession(request).getUsername());
		}
		
		SaidaEstudoController controller = new SaidaEstudoController();
		saidaForm.setSaida(controller.buscarSaidaEstudoByIdPaciente(saidaForm.getIdParam().longValue()));
		
		ActionMessages messages = new ActionMessages();
		messages.add("message", new ActionMessage("msg.aprovacao.saida.rollback"));
        saveMessages(request, messages);
		
		return mapping.findForward("formulario");
	}
			
}
