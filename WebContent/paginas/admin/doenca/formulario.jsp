<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<h4>Cadastro de Doença</h4>
	<hr></hr> 
	<html:form action="/secure/admin/gravadoenca?method=gravar">
		<html:hidden property="doenca.idDoencaEvento"/>
		<label>Nome:</label>
		<html:text property="doenca.dsDoenca" 	 maxlength="100" styleClass="input-xlarge"/>
		<label>Sigla:</label>
		<html:text property="doenca.siglaDoenca" maxlength="10"  styleClass="input-medium"/>
		<br/>
		<html:submit styleClass="btn btn-primary">Gravar</html:submit>		
	</html:form>		 

</div>