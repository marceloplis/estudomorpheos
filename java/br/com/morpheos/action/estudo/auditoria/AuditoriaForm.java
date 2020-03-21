package br.com.morpheos.action.estudo.auditoria;

import java.util.List;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;

public class AuditoriaForm extends FormBase{

	private static final long serialVersionUID = 1L;
	
	private String 	fltIdPaciente;
	private String 	fltNmPaciente;
	private String 	fltEntidade;
	private String 	fltModificacao;
	
	private List<LogAuditoriaEstudoEntity> listLogAuditoria;
	
	public String getFltIdPaciente() {
		return fltIdPaciente;
	}
	public void setFltIdPaciente(String fltIdPaciente) {
		this.fltIdPaciente = fltIdPaciente;
	}
	public String getFltNmPaciente() {
		return fltNmPaciente;
	}
	public void setFltNmPaciente(String fltNmPaciente) {
		this.fltNmPaciente = fltNmPaciente;
	}
	public String getFltEntidade() {
		return fltEntidade;
	}
	public void setFltEntidade(String fltEntidade) {
		this.fltEntidade = fltEntidade;
	}
	public String getFltModificacao() {
		return fltModificacao;
	}
	public void setFltModificacao(String fltModificacao) {
		this.fltModificacao = fltModificacao;
	}	
	
	public List<LogAuditoriaEstudoEntity> getListLogAuditoria() {
		return listLogAuditoria;
	}
	public void setListLogAuditoria(
			List<LogAuditoriaEstudoEntity> listLogAuditoria) {
		this.listLogAuditoria = listLogAuditoria;
	}
	

}
