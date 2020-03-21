package br.com.morpheos.action.relatorios;

import java.util.List;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;
import br.com.morpheos.entity.VisitaEntity;

public class RelatoriosForm extends FormBase {

	private static final long serialVersionUID = -5751447958522507534L;
		
	private List<UnidadeAtendimentoEntity> listUnidades;
	private long unidadeId;
	private int tpRelatorio;
	private long pacienteId;
	
	private List<PacienteEntity> listPacientes;
	private List<VisitaEntity> listVisitas;
	
	public List<UnidadeAtendimentoEntity> getListUnidades() {
		return listUnidades;
	}
	public void setListUnidades(List<UnidadeAtendimentoEntity> listUnidades) {
		this.listUnidades = listUnidades;
	}
	public long getUnidadeId() {
		return unidadeId;
	}
	public void setUnidadeId(long unidadeId) {
		this.unidadeId = unidadeId;
	}
	
	public int getTpRelatorio() {
		return tpRelatorio;
	}
	public void setTpRelatorio(int tpRelatorio) {
		this.tpRelatorio = tpRelatorio;
	}
	
	public long getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(long pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	public List<PacienteEntity> getListPacientes() {
		return listPacientes;
	}
	public void setListPacientes(List<PacienteEntity> listPacientes) {
		this.listPacientes = listPacientes;
	}
	
	public List<VisitaEntity> getListVisitas() {
		return listVisitas;
	}
	public void setListVisitas(List<VisitaEntity> listVisitas) {
		this.listVisitas = listVisitas;
	}
	
}
