package br.com.morpheos.action.estatisticas;

import br.com.morpheos.action.common.FormBase;

public class EstatisticasForm extends FormBase{

	private static final long serialVersionUID = 1L;
	
	private String countPacientesGroupByStatus;
	
	private String countPacientesGroupByUnidade;
	
	private String countVisitasGroupByStatus;
	
	private String countEventosGroupByStatus;
	
	private String countSaidasGroupByStatus;
	
	private String countPacientesGroupByVisitas;

	
	public String getCountPacientesGroupByStatus() {
		return countPacientesGroupByStatus;
	}

	public void setCountPacientesGroupByStatus(String countPacientesGroupByStatus) {
		this.countPacientesGroupByStatus = countPacientesGroupByStatus;
	}

	public String getCountPacientesGroupByUnidade() {
		return countPacientesGroupByUnidade;
	}
	
	public void setCountPacientesGroupByUnidade(
			String countPacientesGroupByUnidade) {
		this.countPacientesGroupByUnidade = countPacientesGroupByUnidade;
	}
			
	public String getCountVisitasGroupByStatus() {
		return countVisitasGroupByStatus;
	}

	public void setCountVisitasGroupByStatus(String countVisitasGroupByStatus) {
		this.countVisitasGroupByStatus = countVisitasGroupByStatus;
	}

	public String getCountEventosGroupByStatus() {
		return countEventosGroupByStatus;
	}

	public void setCountEventosGroupByStatus(String countEventosGroupByStatus) {
		this.countEventosGroupByStatus = countEventosGroupByStatus;
	}

	public String getCountSaidasGroupByStatus() {
		return countSaidasGroupByStatus;
	}

	public void setCountSaidasGroupByStatus(String countSaidasGroupByStatus) {
		this.countSaidasGroupByStatus = countSaidasGroupByStatus;
	}

	public String getCountPacientesGroupByVisitas() {
		return countPacientesGroupByVisitas;
	}

	public void setCountPacientesGroupByVisitas(String countPacientesGroupByVisitas) {
		this.countPacientesGroupByVisitas = countPacientesGroupByVisitas;
	}
	
	
	
	
}
