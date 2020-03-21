package br.com.morpheos.action.admin.medicamento;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.GrupoMedicamentoEntity;
import br.com.morpheos.entity.MedicamentoEntity;

public class MedicamentoForm extends FormBase{

	private static final long serialVersionUID = 3991994094635997559L;
	
	private MedicamentoEntity medicamento;
	private List<MedicamentoEntity> listMedicamentos;	
	private List<GrupoMedicamentoEntity> listGrupos;
	

	public MedicamentoEntity getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(MedicamentoEntity medicamento) {
		this.medicamento = medicamento;
	}

	public List<MedicamentoEntity> getListMedicamentos() {
		return listMedicamentos;
	}

	public void setListMedicamentos(List<MedicamentoEntity> listMedicamentos) {
		this.listMedicamentos = listMedicamentos;
	}
	
	public List<GrupoMedicamentoEntity> getListGrupos() {
		return listGrupos;
	}
	
	public void setListGrupos(List<GrupoMedicamentoEntity> listGrupos) {
		this.listGrupos = listGrupos;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.medicamento = new MedicamentoEntity();  
		setIdParam(null);
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if( medicamento.getDsMedicamento() == null || medicamento.getDsMedicamento().trim().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","nome"));
	      }
	      
	      if( medicamento.getGrpMedicamento().getIdGrupoMedicamento() == null || medicamento.getGrpMedicamento().getIdGrupoMedicamento() == 0) {
	    	  errors.add("grupo",new ActionMessage("error.required.o","grupo"));
	      }
	      
	      return errors;
	}
	
}
