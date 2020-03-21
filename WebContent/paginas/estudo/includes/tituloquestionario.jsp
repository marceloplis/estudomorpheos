<%@include file="/templates/tags.jsp" %>

<c:set var="now" value="<%=new java.util.Date()%>" />

<h4 style="color: #0088CC">${questionariosForm.tituloPagina}</h4>
<hr></hr>

<div class="span10">
	<div class="well well-small" style="background-color: #ADD8E6">
		<div class="row-fluid">					
			<div class="span4">
				<label><b>Nº do Paciente</b></label>
				<input type="text" value="${questionariosForm.visita.paciente.idPaciente}" readonly="true" disabled="true"/>										 
			</div>	
			<div class="span4">
				<label><b>Paciente</b></label> 
				<input type="text" value="${questionariosForm.visita.paciente.iniciaisNome}" readonly="true" disabled="true"/>
			</div>	
			<div class="span4">
				<label><b>Data/Hora</b></label> 
				<b><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" /></b>
			</div>			
		</div>	
	</div>			
</div>