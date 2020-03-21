<%@include file="/templates/tags.jsp" %>

<c:set var="grfPacienteStatus" 	value="${estatisticasForm.countPacientesGroupByStatus}"/>
<c:set var="grfPacienteUnidade"	value="${estatisticasForm.countPacientesGroupByUnidade}"/>
<c:set var="grfPacienteVisitas" value="${estatisticasForm.countPacientesGroupByVisitas}"/>
<c:set var="grfVisitaStatus" 	value="${estatisticasForm.countVisitasGroupByStatus}"/>
<c:set var="grfEventoStatus" 	value="${estatisticasForm.countEventosGroupByStatus}"/>
<c:set var="grfSaidaStatus" 	value="${estatisticasForm.countSaidasGroupByStatus}"/>

<h4>Lista de Registros Pendentes de Aprovações</h4>
<hr></hr> 

<div class="formulario">	

	<div class="form-msg-error">
		<jsp:include page="/templates/message-error.jsp"/>
	</div>
	
	<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
       	<li class="active"><a href="#pacientes" data-toggle="tab">Pacientes</a></li>
       	<li><a href="#visitas" data-toggle="tab">Visitas</a></li>
       	<li><a href="#aprovacoes" data-toggle="tab">Aprovações</a></li>     
    </ul>
    
     <div class="span10">

	    <div id="my-tab-content" class="tab-content">
	        
	        <div class="tab-pane active" id="pacientes">
	        	<div class="span5">
	        		<h5 class="well well-small">Status Paciente</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Pie3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfPacienteStatus}" /> 
                 		<jsp:param name="chartId" value="grfPacienteStatus" /> 
                 		<jsp:param name="chartWidth" value="600" /> 
                 		<jsp:param name="chartHeight" value="300" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>            		     		
	        	</div>
	        	<div class="span5">
	        		<h5 class="well well-small">Unidade Paciente</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Pie3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfPacienteUnidade}" /> 
                 		<jsp:param name="chartId" value="grfPacienteUnidade" /> 
                 		<jsp:param name="chartWidth" value="600" /> 
                 		<jsp:param name="chartHeight" value="300" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>            		     		
	        	</div>
	        </div>
	        
	        <div class="tab-pane" id="visitas">
	        	<div class="span5">
	        		<h5 class="well well-small">Pacientes em Visita</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Column3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfPacienteVisitas}" /> 
                 		<jsp:param name="chartId" value="grfPacienteVisitas" /> 
                 		<jsp:param name="chartWidth" value="800" /> 
                 		<jsp:param name="chartHeight" value="400" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>
	        	</div>
	        </div>
	        
	        <div class="tab-pane" id="aprovacoes">
	        
	        	<div class="span5">
	        		<h5 class="well well-small">Aprovações de Visitas</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Pie3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfVisitaStatus}" /> 
                 		<jsp:param name="chartId" value="grfVisitaStatus" /> 
                 		<jsp:param name="chartWidth" value="600" /> 
                 		<jsp:param name="chartHeight" value="300" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>
	        	</div>
	        	
	        	<div class="span5">
	        		<h5 class="well well-small">Aprovações de Eventos</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Pie3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfEventoStatus}" /> 
                 		<jsp:param name="chartId" value="grfEventoStatus" /> 
                 		<jsp:param name="chartWidth" value="600" /> 
                 		<jsp:param name="chartHeight" value="300" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>
	        	</div>	        	
	        		        	
	        	<div class="span5">
	        		<h5 class="well well-small">Aprovações de Saídas</h5>
	        		<jsp:include page="FusionChartsRenderer.jsp" flush="true"> 
                 		<jsp:param name="chartSWF" value="/estudomorpheos/paginas/estatisticas/charts/FCF_Pie3D.swf"/> 
                 		<jsp:param name="strURL" value="" /> 
                 		<jsp:param name="strXML" value="${grfSaidaStatus}" /> 
                 		<jsp:param name="chartId" value="grfSaidaStatus" /> 
                 		<jsp:param name="chartWidth" value="600" /> 
                 		<jsp:param name="chartHeight" value="300" /> 
                		<jsp:param name="debugMode" value="false" /> 
             		</jsp:include>
	        	</div>	        	
	        	
	        </div>
	        
	   	</div>
	   	
	</div>
	
</div>

<script>
	jQuery(document).ready(function ($) {
	    $('#tabs').tab();
	});
</script>
	        