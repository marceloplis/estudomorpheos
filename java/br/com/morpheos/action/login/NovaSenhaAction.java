package br.com.morpheos.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.UsuarioController;
import br.com.morpheos.entity.UsuarioEntity;
import br.com.morpheos.util.Utils;

public class NovaSenhaAction extends ActionBase{

	public ActionForward trocarsenha(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		NovaSenhaForm novasenhaform = (NovaSenhaForm) form;
		novasenhaform.setNovasenha("");
		novasenhaform.setNovasenhaconfirma("");
		UsuarioController usuarioController = new UsuarioController();
		novasenhaform.setUsuario(usuarioController.buscarById(getUsuarioSession(request).getIdUsuario()));
		saveToken(request);
		return mapping.findForward("trocar-senha");
	}
	
	public ActionForward gravarsenha(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		NovaSenhaForm novasenhaform = (NovaSenhaForm) form;		
		
		if(isTokenValid(request)) { 
			resetToken(request); 
		    UsuarioController usuarioController = new UsuarioController();
		    novasenhaform.getUsuario().setFlSenhaTemporaria(false);
		    novasenhaform.getUsuario().setFlAtivo(true);
		    String senhaCriptografada = Utils.criptografaSenha(novasenhaform.getNovasenha().toLowerCase());
		    novasenhaform.getUsuario().setSenha(senhaCriptografada);
			UsuarioEntity usuario = usuarioController.gravar(novasenhaform.getUsuario(), null);
			novasenhaform.setUsuario(usuario);  
		} 		
		
		ActionMessages messages = new ActionMessages();
        messages.add("message", new ActionMessage("msg.novasenha.sucesso"));
        saveMessages(request, messages);
		
		saveToken(request);
		return mapping.findForward("sucesso"); 
		
	}
	
	
}
