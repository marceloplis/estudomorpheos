package br.com.morpheos.action.estudo.questionarios;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.json.JSONArray;
import org.json.JSONObject;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.action.helper.VisitasHelper;
import br.com.morpheos.controller.GrpMedicamentoController;
import br.com.morpheos.controller.MedicamentoController;
import br.com.morpheos.controller.QuestionariosController;
import br.com.morpheos.entity.MedicamentoEntity;
import br.com.morpheos.entity.QuestAplicacaoEntity;
import br.com.morpheos.entity.QuestAtividadeFisicaEntity;
import br.com.morpheos.entity.QuestBerlimEntity;
import br.com.morpheos.entity.QuestBioquimicaEntity;
import br.com.morpheos.entity.QuestCageEntity;
import br.com.morpheos.entity.QuestEcocardiogramaEntity;
import br.com.morpheos.entity.QuestMapaEntity;
import br.com.morpheos.entity.QuestMedicamentoUsoEntity;
import br.com.morpheos.entity.QuestPoligrafiaEntity;
import br.com.morpheos.entity.QuestPolissonografiaEntity;
import br.com.morpheos.entity.QuestPressaoArterialEntity;
import br.com.morpheos.entity.QuestSphygmocorEntity;
import br.com.morpheos.entity.VisitaEntity;

public class QuestionariosAction extends ActionBase{

	ResourceBundle bundle = ResourceBundle.getBundle("morpheos");

	/*Pressao Arterial*/
	@SuppressWarnings("deprecation")
	public ActionForward qpressaoarterial(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Pressão Arterial", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestPressaoArterialEntity qpressaoarterial = controller.buscaQuestPressaoArterial(visita.getIdVisita());
		if(qpressaoarterial != null){
			qpressaoarterial.setVisita(visita);
			qForm.setQpressaoarterial(qpressaoarterial);
		}else{			
			qForm.setQpressaoarterial(new QuestPressaoArterialEntity());
			qForm.getQpressaoarterial().setVisita(visita);
		}
				
		return mapping.findForward("formpressaoarterial");		
	}
	
	public ActionForward gravarqpressaoarterial(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestPressaoArterialEntity quest = controller.gravarQuestPressaoArterial(qForm.getQpressaoarterial(), getUsuarioSession(request).getUsername());
			qForm.setQpressaoarterial(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qpressaoarterial.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessopressaoarterial");		
	}
	
	/*Medicamento Uso*/
	@SuppressWarnings("deprecation")
	public ActionForward qmedicamentouso(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Medicamentos em Uso", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		qForm.setQmedicamentouso(new QuestMedicamentoUsoEntity());
		qForm.getQmedicamentouso().setVisita(visita);
		
		qForm.setMedicamentosUso(controller.buscaMedicamentosUso(qForm.getIdVisita()));
		
		GrpMedicamentoController grpMedicamentoController = new GrpMedicamentoController();
		qForm.setGrpsMedicamentos(grpMedicamentoController.listarTodos());
		
		return mapping.findForward("formmedicamentouso");		
	}
	
	public ActionForward carregaMedicamentos(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		String idGrupo = request.getParameter("idGrupo");
		 
		MedicamentoController controller = new MedicamentoController();
		List<MedicamentoEntity> medicamentos = 	controller.buscaPorGrupo(Long.valueOf(idGrupo));   
		    
		JSONArray array = new JSONArray();
		for (MedicamentoEntity medicamento : medicamentos) {
			JSONObject object = new JSONObject();
		 
		    object.put("id", medicamento.getIdMedicamento());
		    object.put("nome", medicamento.getDsMedicamento());
		 
		    array.put(object);
		}
		 
		String jsonResult = array.toString();
		 
		response.setContentType("text/javascript; charset=utf-8");
		response.getWriter().write(jsonResult);
		 
		return null;
	}
	
	public ActionForward gravarqmedicamentouso(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			controller.gravarQuestMedicamentoUso(qForm.getQmedicamentouso(), getUsuarioSession(request).getUsername());					
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		qForm.setQmedicamentouso(new QuestMedicamentoUsoEntity());
		qForm.setMedicamentosUso(controller.buscaMedicamentosUso(qForm.getIdVisita()));
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qmedicamentouso.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
        response.sendRedirect("/estudomorpheos/secure/questionarios.do?method=qmedicamentouso&idVisita="+qForm.getVisita().getIdVisita()+"&nuVisita="+qForm.getVisita().getNuVisita()+"&flAcessoAprovador=");       
        
		return null;//mapping.findForward("sucessomedicamentouso");		
	}
	
	public ActionForward editarmedicamentouso(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		QuestionariosController controller = new QuestionariosController();	
		
		qForm.setQmedicamentouso(controller.buscaMedicamentoUso(qForm.getIdParam()));
		
		qForm.setMedicamentosUso(controller.buscaMedicamentosUso(qForm.getIdVisita()));
		
		GrpMedicamentoController grpMedicamentoController = new GrpMedicamentoController();
		qForm.setGrpsMedicamentos(grpMedicamentoController.listarTodos());
		
		return mapping.findForward("formmedicamentouso");		
	}
	
	
	public ActionForward excluirmedicamentouso(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		QuestionariosController controller = new QuestionariosController();	
		
		try{
			controller.excluiMedicamentoUso(controller.buscaMedicamentoUso(qForm.getIdParam()));
		}catch (Exception e) {
			System.out.println("Erro ao excluir medicamento em uso: " + e.getMessage());
			ActionMessages errors = new ActionMessages();
			errors.add("medicamento",new ActionMessage("error.exclusao.medicamento.uso", qForm.getIdParam()));	
			saveErrors(request, errors);
			saveToken(request);
		}
		
		qForm.setMedicamentosUso(controller.buscaMedicamentosUso(qForm.getIdVisita()));
		
		GrpMedicamentoController grpMedicamentoController = new GrpMedicamentoController();
		qForm.setGrpsMedicamentos(grpMedicamentoController.listarTodos());
		
		return mapping.findForward("formmedicamentouso");		
	}
	
	/*Aplicacao*/
	@SuppressWarnings("deprecation")
	public ActionForward qaplicacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário de Aplicação", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestAplicacaoEntity qaplicacao = controller.buscaQuestAplicacao(visita.getIdVisita());
		if(qaplicacao != null){
			qaplicacao.setVisita(visita);
			qForm.setQaplicacao(qaplicacao);
		}else{			
			qForm.setQaplicacao(new QuestAplicacaoEntity());
			qForm.getQaplicacao().setVisita(visita);
		}
		
		return mapping.findForward("formaplicacao");		
	}
	
	
	public ActionForward gravarqaplicacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestAplicacaoEntity quest = controller.gravarQuestAplicacao(qForm.getQaplicacao(), getUsuarioSession(request).getUsername());
			qForm.setQaplicacao(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qaplicacao.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessoaplicacao");		
	}
	
	
	
	/*Berlim*/
	@SuppressWarnings("deprecation")
	public ActionForward qberlim(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Berlim", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestBerlimEntity qberlim = controller.buscaQuestBerlim(visita.getIdVisita());
		if(qberlim != null){
			qberlim.setVisita(visita);
			qForm.setQberlim(qberlim);
		}else{			
			qForm.setQberlim(new QuestBerlimEntity());
			qForm.getQberlim().setVisita(visita);
		}
		
		return mapping.findForward("formberlim");		
	}
	
	public ActionForward gravarqberlim(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestBerlimEntity quest = controller.gravarQuestBerlim(qForm.getQberlim(), getUsuarioSession(request).getUsername());
			qForm.setQberlim(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qberlim.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessoberlim");		
	}
	
	
	/*CAGE*/
	@SuppressWarnings("deprecation")
	public ActionForward qcage(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário CAGE", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestCageEntity qcage = controller.buscaQuestCage(visita.getIdVisita());
		if(qcage != null){
			qcage.setVisita(visita);
			qForm.setQcage(qcage);
		}else{			
			qForm.setQcage(new QuestCageEntity());
			qForm.getQcage().setVisita(visita);
		}
		
		return mapping.findForward("formcage");		
	}
	
	public ActionForward gravarqcage(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestCageEntity quest = controller.gravarQuestCage(qForm.getQcage(), getUsuarioSession(request).getUsername());
			qForm.setQcage(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qcage.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessocage");		
	}
	
	/*Atividade Fisica*/
	@SuppressWarnings("deprecation")
	public ActionForward qatividadefisica(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário de Atividade Física", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestAtividadeFisicaEntity qatividadefisica = controller.buscaQuestAtividadeFisica(visita.getIdVisita());
		if(qatividadefisica != null){
			qatividadefisica.setVisita(visita);
			qForm.setQatividadefisica(qatividadefisica);
		}else{			
			qForm.setQatividadefisica(new QuestAtividadeFisicaEntity());
			qForm.getQatividadefisica().setVisita(visita);
		}
		
		return mapping.findForward("formatividadefisica");		
	}
	
	public ActionForward gravarqatividadefisica(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestAtividadeFisicaEntity quest = controller.gravarQuestAtividadeFisica(qForm.getQatividadefisica(), getUsuarioSession(request).getUsername());
			qForm.setQatividadefisica(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qatividadefisica.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessoatividadefisica");		
	}
	
	
	/*MAPA*/
	@SuppressWarnings("deprecation")
	public ActionForward qmapa(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário MAPA", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestMapaEntity qmapa = controller.buscaQuestMapa(visita.getIdVisita());
		if(qmapa != null){
			qmapa.setVisita(visita);
			qForm.setQmapa(qmapa);
		}else{			
			qForm.setQmapa(new QuestMapaEntity());
			qForm.getQmapa().setVisita(visita);
		}
		
		return mapping.findForward("formmapa");		
	}
	
	
	public ActionForward gravarqmapa(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestMapaEntity quest = controller.gravarQuestMapa(qForm.getQmapa(), getUsuarioSession(request).getUsername());
			qForm.setQmapa(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qmapa.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessomapa");		
	}
	
	/*Poligrafia*/
	@SuppressWarnings("deprecation")
	public ActionForward qpoligrafia(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Poligrafia", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestPoligrafiaEntity qpoligrafia = controller.buscaQuestPoligrafia(visita.getIdVisita());
		if(qpoligrafia != null){
			qpoligrafia.setVisita(visita);
			qForm.setQpoligrafia(qpoligrafia);
		}else{			
			qForm.setQpoligrafia(new QuestPoligrafiaEntity());
			qForm.getQpoligrafia().setVisita(visita);
		}
		
		return mapping.findForward("formpoligrafia");		
	}

	
	public ActionForward gravarqpoligrafia(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestPoligrafiaEntity quest = controller.gravarQuestPoligrafia(qForm.getQpoligrafia(), getUsuarioSession(request).getUsername());
			qForm.setQpoligrafia(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qpoligrafia.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessopoligrafia");		
	}
	
	/*Polissonografia*/
	@SuppressWarnings("deprecation")
	public ActionForward qpolissonografia(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Polissonografia", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestPolissonografiaEntity qpolissonografia = controller.buscaQuestPolissonografia(visita.getIdVisita());
		if(qpolissonografia != null){
			qpolissonografia.setVisita(visita);
			qForm.setQpolissonografia(qpolissonografia);
		}else{			
			qForm.setQpolissonografia(new QuestPolissonografiaEntity());
			qForm.getQpolissonografia().setVisita(visita);
		}
		
		return mapping.findForward("formpolissonografia");		
	}
	
	
	public ActionForward gravarqpolissonografia(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestPolissonografiaEntity quest = controller.gravarQuestPolissonografia(qForm.getQpolissonografia(), getUsuarioSession(request).getUsername());
			qForm.setQpolissonografia(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qpolissonografia.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessopolissonografia");		
	}
	
	/*Ecocardiograma*/
	@SuppressWarnings("deprecation")
	public ActionForward qecocardiograma(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Ecocardiograma", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestEcocardiogramaEntity qcardiograma = controller.buscaQuestEcocardiograma(visita.getIdVisita());
		if(qcardiograma != null){
			qcardiograma.setVisita(visita);
			qForm.setQcardiograma(qcardiograma);
		}else{			
			qForm.setQcardiograma(new QuestEcocardiogramaEntity());
			qForm.getQcardiograma().setVisita(visita);
		}
		
		return mapping.findForward("formecocardiograma");		
	}
	
	
	public ActionForward gravarqecocardiograma(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestEcocardiogramaEntity quest = controller.gravarQuestEcocardiograma(qForm.getQcardiograma(), getUsuarioSession(request).getUsername());
			qForm.setQcardiograma(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qecocardiograma.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessoecocardiograma");		
	}
	
	
	/*Bioquimica*/
	@SuppressWarnings("deprecation")
	public ActionForward qbioquimica(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Bioquímica", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestBioquimicaEntity qbioquimica = controller.buscaQuestBioquimica(visita.getIdVisita());
		if(qbioquimica != null){
			qbioquimica.setVisita(visita);
			qForm.setQbioquimica(qbioquimica);
		}else{			
			qForm.setQbioquimica(new QuestBioquimicaEntity());
			qForm.getQbioquimica().setVisita(visita);
		}
		
		return mapping.findForward("formbioquimica");		
	}
	
	
	public ActionForward gravarqbioquimica(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestBioquimicaEntity quest = controller.gravarQuestBioquimica(qForm.getQbioquimica(), getUsuarioSession(request).getUsername());
			qForm.setQbioquimica(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qbioquimica.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessobioquimica");		
	}
	
	/*Sphygmocor*/
	@SuppressWarnings("deprecation")
	public ActionForward qsphygmocor(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;			
		
		if(qForm.getIdVisita() == null || qForm.getIdVisita() == 0){
			ActionErrors errors = new ActionErrors();
			errors.add("idVisita",new ActionMessage("error.questoes.visita.null","Questionário Sphygmocor", qForm.getNuVisita()));
			saveErrors(request, errors);
			return mapping.findForward("formvisita"+qForm.getNuVisita());
		}		
		
		QuestionariosController controller = new QuestionariosController();
		
		VisitaEntity visita = controller.buscarVisita(qForm.getIdVisita());
		qForm.setTituloPagina(VisitasHelper.getInstance().getTitulo(visita.getNuVisita()));
		qForm.setVisita(visita);
		
		QuestSphygmocorEntity qsphygmocor = controller.buscaQuestSphygmocor(visita.getIdVisita());
		if(qsphygmocor != null){
			qsphygmocor.setVisita(visita);
			qForm.setQsphygmocor(qsphygmocor);
		}else{			
			qForm.setQsphygmocor(new QuestSphygmocorEntity());
			qForm.getQsphygmocor().setVisita(visita);
		}
		
		return mapping.findForward("formsphygmocor");		
	}
	
	
	public ActionForward gravarqsphygmocor(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QuestionariosForm qForm = (QuestionariosForm) form;	
		
		QuestionariosController controller = new QuestionariosController();	    
		
		if(isTokenValid(request)) { 
			resetToken(request); 					
			
			QuestSphygmocorEntity quest = controller.gravarQuestSphygmocor(qForm.getQsphygmocor(), getUsuarioSession(request).getUsername());
			qForm.setQsphygmocor(quest);		
						
		}else{
			request.getSession().setAttribute("msg-erro", bundle.getString("msg.visita.erro.fluxo"));
			return mapping.findForward("erro-fluxo");
		}
		
		saveToken(request);
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.qsphygmocor.sucesso",qForm.getVisita().getNuVisita()));
        saveMessages(request, messages);
		
		return mapping.findForward("sucessosphygmocor");		
	}
		
}
