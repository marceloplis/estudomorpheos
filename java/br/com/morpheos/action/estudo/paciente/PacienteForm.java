package br.com.morpheos.action.estudo.paciente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.action.common.FormBase;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;
import br.com.morpheos.util.Utils;

public class PacienteForm extends FormBase{

	private static final long serialVersionUID = -6795890584003822077L;

	private PacienteEntity paciente;
	
	private List<PacienteEntity> listPacientes;
	
	private List<UnidadeAtendimentoEntity> listUnidades;
	
	private String dtNascimentoParse;
	
	public String getDtNascimentoParse() {  
		if (paciente.getDtNascimento()!= null)     
			dtNascimentoParse =  Utils.converteDataString(paciente.getDtNascimento() );  
		return dtNascimentoParse ;  
	}  
	  
	public void setDtNascimentoParse(String string) {  
		dtNascimentoParse = string;  
	    if ( (dtNascimentoParse != null) && (!dtNascimentoParse .equals("")) )      
	    	paciente.setDtNascimento(Utils.converteData(dtNascimentoParse ));  
	}   

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public List<PacienteEntity> getListPacientes() {
		return listPacientes;
	}

	public void setListPacientes(List<PacienteEntity> listPacientes) {
		this.listPacientes = listPacientes;
	}
	
	public List<UnidadeAtendimentoEntity> getListUnidades() {
		return listUnidades;
	}
	
	public void setListUnidades(List<UnidadeAtendimentoEntity> listUnidades) {
		this.listUnidades = listUnidades;
	}
		
	
	/*Overwrite*/
	public void reset(ActionMapping mapping, HttpServletRequest request) { 
		setNmBusca(null);
		setIdParam(null);
	} 
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ) {
	      ActionErrors errors = new ActionErrors();
	      
	      
	      if( paciente.getNome() == null || paciente.getNome().length() < 1 ) {
	    	  errors.add("nome",new ActionMessage("error.required.o","Nome"));
	      }	      
	      if( paciente.getIniciaisNome() == null || paciente.getIniciaisNome().length() < 1 ) {
	    	  errors.add("iniciais do nome",new ActionMessage("error.required.as","Iniciais do Nome"));
	      }
	      
	      if( paciente.getCpf() == null || paciente.getCpf().length() < 1 ) {
	    	  errors.add("cpf",new ActionMessage("error.required.o","CPF"));
	      }
	      if( paciente.getCpf().length() > 0 && paciente.getCpf().replaceAll("[.-]", "").length() < 11) {
	    	  errors.add("cpf",new ActionMessage("error.valor.invalido","CPF"));
	      }
	      
	      if( paciente.getNumRegistro() == null || paciente.getNumRegistro().length() < 1 ) {
	    	  errors.add("numRegistro",new ActionMessage("error.required.o","Número de Registro"));
	      }
	      
	      if( paciente.getDtNascimento() == null) {
	    	  errors.add("dtNascimento",new ActionMessage("error.required.a","Data de Nascimento"));
	      }
	      if( paciente.getSexo() == null || paciente.getSexo().length() == 0 ) {
	    	  errors.add("sexo",new ActionMessage("error.required.o","Sexo do Paciente"));
	      }
	      if( paciente.getRaca() == null || paciente.getRaca() == 0 ) {
	    	  errors.add("raca",new ActionMessage("error.required.a","Raça do Paciente"));
	      }
	      
	      if( paciente.getNumFoneRes() != null && paciente.getNumFoneRes().length() > 0 && paciente.getNumFoneRes().length() < 13 ){
	    	  errors.add("numFoneRes",new ActionMessage("error.valor.invalido","Tel.Res"));
	      }
	      if( paciente.getNumCelular() != null && paciente.getNumCelular().length() > 0 && paciente.getNumCelular().length() < 13 ){
	    	  errors.add("numCelular",new ActionMessage("error.valor.invalido","Tel.Cel"));
	      }
	      if( paciente.getNumFoneTrab() != null && paciente.getNumFoneTrab().length() > 0 && paciente.getNumFoneTrab().length() < 13 ){
	    	  errors.add("numFoneTrab",new ActionMessage("error.valor.invalido","Tel.Trabalho"));
	      }
	      if( paciente.getNumFoneRecado() != null && paciente.getNumFoneRecado().length() > 0 && paciente.getNumFoneRecado().length() < 13 ){
	    	  errors.add("numFoneRecado",new ActionMessage("error.valor.invalido","Tel.Recado"));
	      }
	      if( paciente.getCep() != null && paciente.getCep().length() > 0 && paciente.getCep().length() < 9 ){
	    	  errors.add("cep",new ActionMessage("error.valor.invalido","CEP"));
	      }
	      

	      return errors;
	}
	
}
