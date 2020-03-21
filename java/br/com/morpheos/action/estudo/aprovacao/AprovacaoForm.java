package br.com.morpheos.action.estudo.aprovacao;

import java.util.List;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.EventoAdversoEntity;
import br.com.morpheos.entity.SaidaEstudoEntity;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;
import br.com.morpheos.entity.VisitaEntity;

public class AprovacaoForm extends FormBase{

	private static final long serialVersionUID = 1L;
	
	private List<UnidadeAtendimentoEntity> unidades;
	
	private Integer fltUnidade;
	private Integer fltTipo;
	
	private List<VisitaEntity> 			visitas;
	private List<EventoAdversoEntity> 	eventos;
	private List<SaidaEstudoEntity> 	saidas;
	
	public List<UnidadeAtendimentoEntity> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<UnidadeAtendimentoEntity> unidades) {
		this.unidades = unidades;
	}	
	public Integer getFltUnidade() {
		return fltUnidade;
	}
	public void setFltUnidade(Integer fltUnidade) {
		this.fltUnidade = fltUnidade;
	}
	public Integer getFltTipo() {
		return fltTipo;
	}
	public void setFltTipo(Integer fltTipo) {
		this.fltTipo = fltTipo;
	}
	public List<VisitaEntity> getVisitas() {
		return visitas;
	}
	public void setVisitas(List<VisitaEntity> visitas) {
		this.visitas = visitas;
	}
	public List<EventoAdversoEntity> getEventos() {
		return eventos;
	}
	public void setEventos(List<EventoAdversoEntity> eventos) {
		this.eventos = eventos;
	}
	public List<SaidaEstudoEntity> getSaidas() {
		return saidas;
	}
	public void setSaidas(List<SaidaEstudoEntity> saidas) {
		this.saidas = saidas;
	}	
	
	
}
