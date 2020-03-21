package br.com.morpheos.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class LoginForm extends FormBase{

	private static final long serialVersionUID = -8620433400850706262L;
	
	private String username;
	private String senha;
	
	private List<UnidadeAtendimentoEntity> unidades;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public List<UnidadeAtendimentoEntity> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<UnidadeAtendimentoEntity> unidades) {
		this.unidades = unidades;
	}
	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( getUsername() == null || getUsername().length() < 1 ) {
	        errors.add("username",new ActionMessage("error.required.o","username"));
	      }
	      if( getSenha() == null || getSenha().length() < 1 ) {
	        errors.add("senha",new ActionMessage("error.required.a","senha"));
	      }

	      return errors;
	}
	
}
