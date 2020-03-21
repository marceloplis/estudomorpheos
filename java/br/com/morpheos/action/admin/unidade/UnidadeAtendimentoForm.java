package br.com.morpheos.action.admin.unidade;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class UnidadeAtendimentoForm extends FormBase{

	private static final long serialVersionUID = 3991994094635997559L;
	
	private UnidadeAtendimentoEntity unidade;
	private List<UnidadeAtendimentoEntity> listUnidades;
	
	
	public UnidadeAtendimentoEntity getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeAtendimentoEntity unidade) {
		this.unidade = unidade;
	}
	public List<UnidadeAtendimentoEntity> getListUnidades() {
		return listUnidades;
	}
	public void setListUnidades(List<UnidadeAtendimentoEntity> listUnidades) {
		this.listUnidades = listUnidades;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.unidade = new UnidadeAtendimentoEntity();  
		setIdParam(null);
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( unidade.getNuUnidade() == null || unidade.getNuUnidade() <= 0 ) {
	    	  errors.add("idUnidade",new ActionMessage("error.required.o","idUnidade"));
	      }
	      
	      if( unidade.getDsUnidade() == null || unidade.getDsUnidade().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","nome"));
	      }
	      
	      if( unidade.getEmail() != null && unidade.getEmail().length() > 0 ){
	    	  Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");  
	    	  Matcher m = p.matcher(unidade.getEmail());  
	    	  if (!m.find()) 
	    		  errors.add("email",new ActionMessage("error.valor.invalido","email")); 
	      }
	      
	      return errors;
	}
	
}
