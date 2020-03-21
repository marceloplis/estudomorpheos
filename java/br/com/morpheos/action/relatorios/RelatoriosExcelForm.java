package br.com.morpheos.action.relatorios;

import java.util.List;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.dao.types.TipoRelatorioExcel;

public class RelatoriosExcelForm extends FormBase {

	private static final long serialVersionUID = -5751447958522507534L;
		
	private Integer codigo;
	private List<TipoRelatorioExcel> listRelatorio;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<TipoRelatorioExcel> getListRelatorio() {
		return listRelatorio;
	}

	public void setListRelatorio(List<TipoRelatorioExcel> listRelatorio) {
		this.listRelatorio = listRelatorio;
	}
	
}
