package br.com.morpheos.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.UnidadeAtendimentoController;
import br.com.morpheos.controller.UsuarioController;
import br.com.morpheos.entity.UsuarioEntity;

public class LoginAction extends ActionBase {

	public ActionForward inicio(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("login-form");
	}
	
	
	public ActionForward autenticacao(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LoginForm loginform = (LoginForm) form;		
		
		UsuarioController controller = new UsuarioController();
		UsuarioEntity usuario = controller.login(loginform);
		if(usuario != null && usuario.getIdUsuario() != null){
			request.getSession(true).setAttribute("UsuarioSistema", usuario);
			return mapping.findForward("sucesso");
		}		
		
		ActionMessages msg = new ActionMessages();
		msg.add("login_invalido",new ActionMessage("error.login.invalido"));
		saveMessages(request, msg);
		
		return mapping.findForward("erro");
			
	}
	
	public ActionForward home(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LoginForm loginform = (LoginForm) form;	
		UnidadeAtendimentoController unidadeController = new UnidadeAtendimentoController();
		loginform.setUnidades(unidadeController.listarTodos());
		
		return mapping.findForward("home");
	}
	
	public ActionForward sessaoinvalida(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("login-form");
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("login-form");
	}
	
}
