package br.com.morpheos.action.relatorios;

import java.util.Arrays;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.controller.RelatorioExcelController;
import br.com.morpheos.dao.types.TipoRelatorioExcel;
import br.com.morpheos.export.excel.GeraPlanilha;

public class RelatoriosExcelAction  extends ActionBase{

	public ActionForward filtro(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RelatoriosExcelForm relatorioForm = (RelatoriosExcelForm) form;
		
		relatorioForm.setListRelatorio(Arrays.asList(TipoRelatorioExcel.values()));
		
		return mapping.findForward("filtro");
		
	}
	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// Obtem o tipo de relatorio selecionado
		RelatoriosExcelForm relatorioForm = (RelatoriosExcelForm) form;
		TipoRelatorioExcel tre = TipoRelatorioExcel.getTipoRelatorioExcelPorCodigo(relatorioForm.getCodigo());
		
		// Configura o retorno do response
        response.setContentType("application/octet-stream");
        
        // Configura o cabeçcalho do retorno
        StringBuilder sb = new StringBuilder();
        sb.append("attachment;filename=").append(tre.getNmArquivoExportado());
        response.setHeader("Content-Disposition", sb.toString());
        
        try{
        	
        	ServletOutputStream out = response.getOutputStream();

        	GeraPlanilha planilha = new GeraPlanilha();
        	RelatorioExcelController controller = new RelatorioExcelController();
        	
        	// Gera a Planilha
        	planilha.setObjetos(controller.buscaDados(tre));
    		planilha.processar(out, tre.getNmPlanilha());
    		
           	out.flush();
        	out.close();

    	}catch(Exception e){
    		e.printStackTrace();
    	}

		return null;
	}
	
}
