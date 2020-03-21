package br.com.morpheos.action.admin.doenca;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.DoencaEventoEntity;

public class DoencaEventoForm extends FormBase{

	private static final long serialVersionUID = -683622877726502442L;
	
	private DoencaEventoEntity doenca;
	private List<DoencaEventoEntity> listDoencas;
	
	public DoencaEventoEntity getDoenca() {
		return doenca;
	}
	public void setDoenca(DoencaEventoEntity doenca) {
		this.doenca = doenca;
	}
	public List<DoencaEventoEntity> getListDoencas() {
		return listDoencas;
	}
	public void setListDoencas(List<DoencaEventoEntity> listDoencas) {
		this.listDoencas = listDoencas;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.doenca = new DoencaEventoEntity();  
		setIdParam(null);
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( doenca.getDsDoenca() == null || doenca.getDsDoenca().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","nome"));
	      }
	      
	      return errors;
	}
	
}
