package br.com.morpheos.action.relatorios;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.controller.UnidadeAtendimentoController;
import br.com.morpheos.controller.VisitasController;

public class RelatoriosAction  extends ActionBase{

	public ActionForward filtro(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RelatoriosForm relatorioForm = (RelatoriosForm) form;
		
		UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		relatorioForm.setListUnidades(unidadeController.listarTodos());
		relatorioForm.setTpRelatorio(1);
		relatorioForm.setPacienteId(0);
		
		return mapping.findForward("filtro");
		
	}
	
	public ActionForward filtrar(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RelatoriosForm relatorioForm = (RelatoriosForm) form;
		String page = "";
		
		if(relatorioForm.getTpRelatorio() == 1){
			PacienteController pacienteController = new PacienteController();
			relatorioForm.setListPacientes(pacienteController.buscarByUnidade(relatorioForm.getUnidadeId()));
			page = "listaPacientes";
		}else if (relatorioForm.getTpRelatorio() == 2){
			VisitasController visitaController = new VisitasController();
			relatorioForm.setListVisitas(visitaController.buscaVisitasRelatorio(relatorioForm.getUnidadeId(), relatorioForm.getPacienteId()>0 ? relatorioForm.getPacienteId() : null));
			page = "listaVisitas";
		}
		
		return mapping.findForward(page);
		
	}
	
	
}
