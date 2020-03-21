<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>


<div class="formulario">	

	<h4>Filtro para Relatórios Excel</h4>
	<hr></hr> 
	
	<html:form action="/secure/relatoriosExcel?method=download" styleId="form">	

		<label><b>Tipo Relat&oacute;rio:</b></label>	
		<hr class="mini"></hr>		
		<html:select name="relatoriosExcelForm" property="codigo">
            <html:optionsCollection name="relatoriosExcelForm" property="listRelatorio" label="nmPlanilha" value="codigo" />
        </html:select>       

		<html:submit styleClass="btn btn-primary">Download</html:submit>
	
	</html:form>
	
</div>