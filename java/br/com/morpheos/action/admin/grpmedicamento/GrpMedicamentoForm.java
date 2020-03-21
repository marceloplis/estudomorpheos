package br.com.morpheos.action.admin.grpmedicamento;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.GrupoMedicamentoEntity;

public class GrpMedicamentoForm extends FormBase{

	private static final long serialVersionUID = 3991994094635997559L;
	
	private GrupoMedicamentoEntity grupo;
	private List<GrupoMedicamentoEntity> listGrupos;
			
	public GrupoMedicamentoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoMedicamentoEntity grupo) {
		this.grupo = grupo;
	}

	public List<GrupoMedicamentoEntity> getListGrupos() {
		return listGrupos;
	}

	public void setListGrupos(List<GrupoMedicamentoEntity> listGrupos) {
		this.listGrupos = listGrupos;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.grupo = new GrupoMedicamentoEntity();  
		setIdParam(null);
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( grupo.getDsGrupoMedicamento() == null || grupo.getDsGrupoMedicamento().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","nome"));
	      }
	      
	      return errors;
	}
	
}
