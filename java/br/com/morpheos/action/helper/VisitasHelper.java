package br.com.morpheos.action.helper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import br.com.morpheos.controller.VisitasController;
import br.com.morpheos.entity.Visita00Entity;
import br.com.morpheos.entity.VisitaEntity;

public class VisitasHelper {

	ResourceBundle bundle = ResourceBundle.getBundle("morpheos");
	
	private static VisitasHelper instance;
	
	public String getTitulo(Integer nuVisita){
		
		String retorno = null;
		
		if(nuVisita != null){
			retorno = bundle.getString("tit.visita"+nuVisita);
		}
		
		return retorno;
		
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request, VisitaEntity visita ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if(request.getParameter("method") != null){
		      if(visita.getDtRealizacao() == null) {
		    	  errors.add("dtRealizacao",new ActionMessage("error.required.a","Data de Realizacao da Visita " + visita.getNuVisita()));
		      }
		      
	      }

	      return errors;
	}
	
	public ActionErrors validateVisita00(ActionMapping mapping, HttpServletRequest request, Visita00Entity visita00 ) {
	      ActionErrors errors = new ActionErrors();
	      
	      if(request.getParameter("method") != null){
		      
	    	  if(visita00.getVisita().getDtRealizacao() == null) {
		    	  errors.add("dtRealizacao",new ActionMessage("error.required.a","Data de Realizacao"));
		      }
	    	  
	    	  if( visita00.getFlAssinaturaTCLE() == null || visita00.getFlAssinaturaTCLE().length() == 0) {
		    	  errors.add("flAssinaturaTCLE",new ActionMessage("error.required.o","Assinatura TCLE"));
		      }
	    	  
		      if( visita00.getDtAssinaturaTCLE() == null) {
		    	  errors.add("dtAssinaturaTCLE",new ActionMessage("error.required.o","Data da assinatura do TCLE"));
		      }
		      
		      if( (visita00.getPER_V00_CI01() == null || visita00.getPER_V00_CI01().length() == 0) || 
		          (visita00.getPER_V00_CI02() == null || visita00.getPER_V00_CI02().length() == 0)
		      ) {
		    	  errors.add("criteriosInclusao",new ActionMessage("error.required.o","Critério(s) de Inclusão"));
		      }
		      
		      if( (visita00.getPER_V00_CI01() == null || visita00.getPER_V00_CI01().length() == 0) || 
			      (visita00.getPER_V00_CI02() == null || visita00.getPER_V00_CI02().length() == 0)
		      ) {
		    	  errors.add("criteriosInclusao",new ActionMessage("error.required.todos","Critérios de Inclusão"));
		      }
		      
		      if( (visita00.getPER_V00_CE01() == null || visita00.getPER_V00_CE01().length() == 0) || 
			      (visita00.getPER_V00_CE02() == null || visita00.getPER_V00_CE02().length() == 0) ||
			      (visita00.getPER_V00_CE03() == null || visita00.getPER_V00_CE03().length() == 0) || 
			      (visita00.getPER_V00_CE04() == null || visita00.getPER_V00_CE04().length() == 0) || 
			      (visita00.getPER_V00_CE05() == null || visita00.getPER_V00_CE05().length() == 0) || 
			      (visita00.getPER_V00_CE06() == null || visita00.getPER_V00_CE06().length() == 0) || 
			      (visita00.getPER_V00_CE07() == null || visita00.getPER_V00_CE07().length() == 0) || 
			      (visita00.getPER_V00_CE08() == null || visita00.getPER_V00_CE08().length() == 0) || 
			      (visita00.getPER_V00_CE09() == null || visita00.getPER_V00_CE09().length() == 0) || 
			      (visita00.getPER_V00_CE10() == null || visita00.getPER_V00_CE10().length() == 0) 
		      ) {
		    	  errors.add("criteriosInclusao",new ActionMessage("error.required.todos","Critérios de Exclusão"));
		      }
		      
		      if( visita00.getPER_V00_AA01() == null || visita00.getPER_V00_AA01() == 0) {
		    	  errors.add("peso",new ActionMessage("error.required.o","Peso"));
		      }
		      
		      if( visita00.getPER_V00_AA02() == null || visita00.getPER_V00_AA02() == 0) {
		    	  errors.add("altura",new ActionMessage("error.required.a","Altura"));
		      }	    	  
		      
	      }

	      return errors;
	}
	
	public void getStatusVisitas(HttpServletRequest request, Long idPaciente){
		
		VisitasController controller = new VisitasController();
		List<VisitaEntity> visitas = controller.buscaTodasVisitas(idPaciente);
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for(VisitaEntity visita : visitas){
			map.put(visita.getNuVisita(), visita.getStAprovacao() == null || visita.getStAprovacao().equals("") ? "P" : visita.getStAprovacao());
		}
		if(!map.containsKey(0)){
			map.put(0, "");
		}
		if(!map.containsKey(1)){
			map.put(1, "");
		}
		if(!map.containsKey(2)){
			map.put(2, "");
		}
		if(!map.containsKey(3)){
			map.put(3, "");
		}
		if(!map.containsKey(4)){
			map.put(4, "");
		}
		if(!map.containsKey(5)){
			map.put(5, "");
		}
		if(!map.containsKey(6)){
			map.put(6, "");
		}
		if(!map.containsKey(7)){
			map.put(7, "");
		}
		if(!map.containsKey(8)){
			map.put(8, "");
		}
		if(!map.containsKey(9)){
			map.put(9, "");
		}
		if(!map.containsKey(10)){
			map.put(10, "");
		}
		if(!map.containsKey(11)){
			map.put(11, "");
		}
		if(!map.containsKey(12)){
			map.put(12, "");
		}
		if(!map.containsKey(13)){
			map.put(13, "");
		}
		if(!map.containsKey(14)){
			map.put(14, "");
		}
		if(!map.containsKey(15)){
			map.put(15, "");
		}
		if(!map.containsKey(16)){
			map.put(16, "");
		}
		if(!map.containsKey(17)){
			map.put(17, "");
		}
		
		request.getSession(true).setAttribute("STATUSVISITAS", map);
		
	}
	
	public static VisitasHelper getInstance() {
	   if (instance == null){
	         instance = new VisitasHelper();	     
	   }
	   return instance;
	}
	
	
	
}
