package br.com.morpheos.action.estudo.aprovacao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.AprovacaoController;
import br.com.morpheos.controller.UnidadeAtendimentoController;
import br.com.morpheos.entity.EventoAdversoEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;
import br.com.morpheos.entity.VisitaEntity;

public class AprovacaoAction extends ActionBase{

	public ActionForward filtro(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AprovacaoForm aprovacaoform = (AprovacaoForm) form;
		aprovacaoform.setVisitas(new ArrayList<VisitaEntity>());
		aprovacaoform.setEventos(new ArrayList<EventoAdversoEntity>());
		aprovacaoform.setSaidas(new ArrayList<SaidaEstudoEntity>());
		
		UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		aprovacaoform.setUnidades(unidadeController.listarTodos());
		
		return mapping.findForward("filtro");
	}
	
	public ActionForward lista(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AprovacaoForm aprovacaoform = (AprovacaoForm) form;
		
		AprovacaoController controller = new AprovacaoController();
		
		if(aprovacaoform.getFltTipo() == 1){
			//VISITA
			aprovacaoform.setVisitas(controller.listVisitasPententes(aprovacaoform.getFltUnidade()));
			
		}else if(aprovacaoform.getFltTipo() == 2){
			//EVENTOS
			aprovacaoform.setEventos(controller.listEventosPententes(aprovacaoform.getFltUnidade()));
			
		}else if(aprovacaoform.getFltTipo() == 3){
			//SAIDAS
			aprovacaoform.setSaidas(controller.listSaidasPententes(aprovacaoform.getFltUnidade()));
			
		}else{
			//TODOS
			aprovacaoform.setVisitas(controller.listVisitasPententes(aprovacaoform.getFltUnidade()));
			aprovacaoform.setEventos(controller.listEventosPententes(aprovacaoform.getFltUnidade()));
			aprovacaoform.setSaidas(controller.listSaidasPententes(aprovacaoform.getFltUnidade()));
			
		}
		
		return mapping.findForward("lista");
	}
	
	
}
