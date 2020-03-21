<%@include file="/templates/tags.jsp" %>

<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<h4>Lista de Registros Pendentes de Aprova��es</h4>
<hr></hr> 

<div class="formulario">	

	<div class="form-msg-error">
		<jsp:include page="/templates/message-error.jsp"/>
	</div>
	
	<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
       	<li class="active"><a href="#visitas" data-toggle="tab">Visitas (${fn:length(aprovacaoForm.visitas)})</a></li>
       	<li><a href="#eventos" data-toggle="tab">Eventos Adversos (${fn:length(aprovacaoForm.eventos)})</a></li>
       	<li><a href="#saidas" data-toggle="tab">Exclus�es do Estudo (${fn:length(aprovacaoForm.saidas)})</a></li>      
    </ul>
    
     <div class="span10">
    
	    <div id="my-tab-content" class="tab-content">
	        
	        <div class="tab-pane active" id="visitas">	            
	            
				<h5 class="well well-small">Visitas &nbsp;&nbsp;&nbsp; <img src="../shared/img/visitas.png"/></h5>	
			
				<display:table id="visita" name="${aprovacaoForm.visitas}" requestURI="aprovacao.do"
				               class="table table-bordered"
					           sort="list" defaultsort="1"
					           pagesize="20" export="true">
					
					<display:column 									title="Data Realiza��o" sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${visita.dtRealizacao}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>
					<display:column property="nuVisita" 				title="N� Visita" 		sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column property="paciente.iniciaisNome" 	title="Paciente" 		sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column property="paciente.cpf" 			title="CPF" 			sortable="true" headerClass="sortable" style="width: 15%;"/>           
					<%--
					<display:column media="html"						title="" 				sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 					 	
					 	<a class="btn" data-toggle="modal" data-target="#myModal" data-remote="${baseURL}/secure/visitas.do?method=visita${visita.nuVisita < 10 ? '0' : ''}${visita.nuVisita}&idPaciente=${visita.paciente.idPaciente}&nuVisita=${visita.nuVisita}&flAcessoAprovador=S&flAcessoModal=S">
					 		<img src="../shared/img/lupa.png" title="Visualizar"/>
					 	</a>
					</display:column>
					--%>
					<display:column media="html"						title="" 				sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 
						<html:link  styleClass="btn" action="/secure/visitas.do?method=visita${visita.nuVisita < 10 ? '0' : ''}${visita.nuVisita}&idPaciente=${visita.paciente.idPaciente}&nuVisita=${visita.nuVisita}&flAcessoAprovador=S">
							<img src="../shared/img/acessar.png" title="Acessar Visita para Aprova��o"/>
						</html:link>
					</display:column>
							           
					<display:setProperty name="export.excel.filename" value="visitas_pendentes.xls"/>
				    <display:setProperty name="export.excel" value="true" />         
				</display:table>
				
				<hr></hr> 					
	            
	        </div>
	        
	        <div class="tab-pane" id="eventos">	            
	            
				<h5 class="well well-small">Eventos Adversos &nbsp;&nbsp;&nbsp; <img src="../shared/img/eventoAdverso.png"/></h5>		
			
				<display:table id="evento" name="${aprovacaoForm.eventos}" requestURI="/secure/listaaprovacao.do"
				               class="table table-bordered"
					           sort="list" defaultsort="1"
					           pagesize="20" export="true">
					           
					<display:column 									title="Data Inclus�o" 			sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${evento.dtInclusao}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>
										
					<display:column property="paciente.iniciaisNome" 	title="Paciente" 				sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column property="paciente.cpf" 			title="CPF" 					sortable="true" headerClass="sortable" style="width: 15%;"/> 
					<display:column property="nuVisita" 				title="N� Visita do Evento"		sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column property="doenca.dsDoenca" 			title="Doen�a"					sortable="true" headerClass="sortable" style="width: 10%;"/>
					
					<display:column 									title="Data In�cio" 			sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${evento.dtInicio}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>
					<display:column 									title="Data Fim" 				sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${evento.dtFim}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>					
					<%--
					<display:column media="html"						title="" 						sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 
					 	<a class="btn" data-toggle="modal" data-target="#myModal" data-remote="${baseURL}/secure/evento.do?method=formulario&idParam=${evento.idEventoAdverso}&idPaciente=${evento.paciente.idPaciente}&flAcessoAprovador=S&flAcessoModal=S">
					 		<img src="../shared/img/lupa.png" title="Visualizar"/>
					 	</a>
					</display:column>
					--%>
					<display:column media="html"						title="" 				sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 
						<html:link  styleClass="btn" action="/secure/evento?method=formulario&idParam=${evento.idEventoAdverso}&idPaciente=${evento.paciente.idPaciente}&flAcessoAprovador=S">
							<img src="../shared/img/acessar.png" title="Acessar Evento Adverso para Aprova��o"/>
						</html:link>
					</display:column>    
					           
					<display:setProperty name="export.excel.filename" value="eventos_pendentes.xls"/>
				    <display:setProperty name="export.excel" value="true" />        
				</display:table>
				
				<hr></hr> 
	            
	        </div>
	        
	        <div class="tab-pane" id="saidas">	            
	           
				<h5 class="well well-small">Sa�das do Estudo &nbsp;&nbsp;&nbsp; <img src="../shared/img/excluirPaciente.png"/></h5>		
			
				<display:table id="saida" name="${aprovacaoForm.saidas}" requestURI="/secure/listaaprovacao.do"
				               class="table table-bordered"
					           sort="list" defaultsort="1"
					           pagesize="20" export="true">
					           
					<display:column 									title="Data Sa�da" 			sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${saida.dtSaida}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>
					<display:column property="paciente.iniciaisNome" 	title="Paciente" 			sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column property="paciente.cpf" 			title="CPF" 				sortable="true" headerClass="sortable" style="width: 15%;"/>   
					<display:column property="nuVisita" 				title="N� Visita da Sa�da"	sortable="true" headerClass="sortable" style="width: 10%;"/>
					<display:column 									title="Data Ocorr�ncia"		sortable="true" headerClass="sortable" style="width: 10%;">
						<fmt:formatDate value="${saida.dtOcorrencia}" type="both"  pattern="dd/MM/yyyy" />
					</display:column>			
					<%--
					<display:column media="html"						title="" 					sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 
					 	<a class="btn" data-toggle="modal" data-target="#myModal" data-remote="${baseURL}/secure/saida.do?method=formulario&idPaciente=${saida.paciente.idPaciente}&flAcessoAprovador=S&flAcessoModal=S">
					 		<img src="../shared/img/lupa.png" title="Visualizar"/>
					 	</a>
					</display:column> 
					 --%> 
					<display:column media="html"						title="" 				sortable="true" headerClass="sortable" style="width: 05%; text-align:center;"> 
						<html:link  styleClass="btn" action="/secure/saida?method=formulario&idPaciente=${saida.paciente.idPaciente}&flAcessoAprovador=S">
							<img src="../shared/img/acessar.png" title="Acessar Sa�da do Estudo para Aprova��o"/>
						</html:link>
					</display:column>        
					           
					<display:setProperty name="export.excel.filename" value="saidas_pendentes.xls"/>
				    <display:setProperty name="export.excel" value="true" />        
				</display:table>
				
				<hr></hr> 
	            
	        </div>  
	             
	    </div>
	    
	</div>
    
</div>

<style type="text/css">
.modal-body {
	max-height: 80%;
 	overflow-y: auto;
  	max-height: none;
  	text-align: center; 
}
</style>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">�</button>
		<h3>Visualiza��o do Registro - Formul�rio Principal</h3>
	</div>
	<div class="modal-body">
		<p>Carregando registro...</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal">Fechar</button>
	</div>
</div>

<script>
	jQuery(document).ready(function ($) {
	    $('#tabs').tab();
	});
</script>