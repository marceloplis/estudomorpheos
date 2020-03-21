package br.com.morpheos.action.admin.usuario;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;
import br.com.morpheos.entity.UsuarioEntity;

public class UsuarioForm extends FormBase{

	private static final long serialVersionUID = 9003342327000588870L;

	private UsuarioEntity usuario;
	
	private List<UsuarioEntity> listUsuarios;
	
	private List<UnidadeAtendimentoEntity> listUnidades;

	private String senhaAtual;
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	public List<UsuarioEntity> getListUsuarios() {
		return listUsuarios;
	}
	public void setListUsuarios(List<UsuarioEntity> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}	
	
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	
	public List<UnidadeAtendimentoEntity> getListUnidades() {
		return listUnidades;
	}
	public void setListUnidades(List<UnidadeAtendimentoEntity> listUnidades) {
		this.listUnidades = listUnidades;
	}
	
	
	/*Overwrite*/
	public void reset(ActionMapping mapping, HttpServletRequest request) {		
		setNmBusca(null);
		setIdParam(null);
		this.senhaAtual = null;
	} 
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( usuario.getNome() == null || usuario.getNome().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","nome"));
	      }
	      if( usuario.getUsername() == null || usuario.getUsername().length() < 1 ) {
	    	  errors.add("username",new ActionMessage("error.required.o","username"));
	      }
	      if( usuario.getSenha() == null || usuario.getSenha().length() < 1 ) {
	    	  errors.add("senha",new ActionMessage("error.required.a","senha"));
	      }
	      if( usuario.getPerfil().getIdPerfilAcesso() == null) {
	    	  errors.add("perfil",new ActionMessage("error.required.o","perfil"));
	      }
	      if( usuario.getUnidade().getIdUnidadePesquisa() == null) {
	    	  errors.add("unidade",new ActionMessage("error.required.a","unidade"));
	      }

	      return errors;
	}
	
}
