package br.com.morpheos.action.relatorios;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.morpheos.action.common.ActionBase;
import br.com.morpheos.dao.impl.ExportDadosExcelDao;

public class ExportExcelAction extends ActionBase{

	public ActionForward exportarVisitasExcel(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExportDadosExcelDao dao = new ExportDadosExcelDao();
		String dados = dao.exportVisitasExcel();
		//agora, salvando o StringBuffer no arquivo
		response.setContentType( "application/vnd.ms-excel" ); 
		response.setHeader("Content-disposition", "attachment; filename=export_morpheos.xls" );
		OutputStream outStream = response.getOutputStream();
		outStream.write(dados.getBytes());
		outStream.close();
		return null;
	}
	
	public ActionForward exportarEventosExcel(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExportDadosExcelDao dao = new ExportDadosExcelDao();
		String dados = dao.exportEventosExcel();
		//agora, salvando o StringBuffer no arquivo
		response.setContentType( "application/vnd.ms-excel" ); 
		response.setHeader("Content-disposition", "attachment; filename=export_morpheos.xls" );
		OutputStream outStream = response.getOutputStream();
		outStream.write(dados.getBytes());
		outStream.close();
		return null;
	}
	
	public ActionForward exportarPacientesExcel(ActionMapping mapping, ActionForm  form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExportDadosExcelDao dao = new ExportDadosExcelDao();
		String dados = dao.exportPacientesExcel();
		//agora, salvando o StringBuffer no arquivo
		response.setContentType( "application/vnd.ms-excel" ); 
		response.setHeader("Content-disposition", "attachment; filename=export_morpheos.xls" );
		OutputStream outStream = response.getOutputStream();
		outStream.write(dados.getBytes());
		outStream.close();
		return null;
	}
	
}
