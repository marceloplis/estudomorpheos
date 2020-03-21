package br.com.morpheos.action.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.actions.DispatchAction;

import br.com.morpheos.entity.UsuarioEntity;

public class ActionBase extends DispatchAction {

	public UsuarioEntity getUsuarioSession(HttpServletRequest request){
		UsuarioEntity usuario = null;
		if(request.getSession().getAttribute("UsuarioSistema") != null){
			usuario = (UsuarioEntity)request.getSession().getAttribute("UsuarioSistema");
		}
		return usuario;
	}
	
}
