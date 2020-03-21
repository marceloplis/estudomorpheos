package br.com.morpheos.action.estudo.auditoria;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.LogAuditoriaController;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;

public class AuditoriaAction extends ActionBase{

	public ActionForward filtro(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AuditoriaForm auditoriaform = (AuditoriaForm) form;
		auditoriaform.setListLogAuditoria(new ArrayList<LogAuditoriaEstudoEntity>());
		auditoriaform.setFltIdPaciente("");
		auditoriaform.setFltNmPaciente("");
		auditoriaform.setFltModificacao("");
		auditoriaform.setFltEntidade("");
		
		return mapping.findForward("filtro");
	}
	
	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AuditoriaForm auditoriaform = (AuditoriaForm) form;
		
		LogAuditoriaController controller = new LogAuditoriaController();
		auditoriaform.setListLogAuditoria(controller.listaLogs(auditoriaform.getFltIdPaciente(), auditoriaform.getFltEntidade(), auditoriaform.getFltModificacao()));
		
		return mapping.findForward("lista");
		
	}
	
}
