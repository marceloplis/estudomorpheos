<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<h4>Cadastro de Grupo de Medicamento</h4>
	<hr></hr> 
	
	<html:form action="/secure/admin/gravagrpmedicamento?method=gravar">
		<html:hidden property="grupo.idGrupoMedicamento"/>
		<label>Nome:	</label><html:text property="grupo.dsGrupoMedicamento" maxlength="100" styleClass="input-xxlarge"/>		
		<br/>
		<html:submit styleClass="btn btn-primary">Gravar</html:submit>
	</html:form>		 

</div>