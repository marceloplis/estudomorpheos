package br.com.morpheos.action.estatisticas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.EventoAdversoController;
import br.com.morpheos.controller.PacienteController;
import br.com.morpheos.controller.SaidaEstudoController;
import br.com.morpheos.controller.VisitasController;

public class EstatisticasAction extends ActionBase{

	public ActionForward graficos(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EstatisticasForm estatisticaform = (EstatisticasForm) form;
		
		PacienteController pController = new PacienteController();
		
		String countPacientesGroupByStatus = pController.countPacientesGroupByStatus();		
		estatisticaform.setCountPacientesGroupByStatus(countPacientesGroupByStatus);

		String countPacientesGroupByUnidade = pController.countPacientesGroupByUnidade();	
		estatisticaform.setCountPacientesGroupByUnidade(countPacientesGroupByUnidade);
		
		VisitasController vController = new VisitasController();
		
		String countPacientesGroupByVisitas = vController.countPacientesGroupByVisitas();
		estatisticaform.setCountPacientesGroupByVisitas(countPacientesGroupByVisitas);
		
		String countVisitasGroupByStatus = vController.countVisitasGroupByStatus();
		estatisticaform.setCountVisitasGroupByStatus(countVisitasGroupByStatus);
		
		EventoAdversoController eController = new EventoAdversoController();
		
		String countEventosGroupByStatus = eController.countEventosGroupByStatus();
		estatisticaform.setCountEventosGroupByStatus(countEventosGroupByStatus);
		
		SaidaEstudoController sController = new SaidaEstudoController();
		
		String countSaidasGroupByStatus = sController.countSaidasGroupByStatus();
		estatisticaform.setCountSaidasGroupByStatus(countSaidasGroupByStatus);
		
		return mapping.findForward("graficos");
	}
	
}
