<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<h4>Cadastro de Medicamento</h4>
	<hr></hr> 
	
	<html:form action="/secure/admin/gravamedicamento?method=gravar">
		<html:hidden property="medicamento.idMedicamento"/>
		<label>Nome:	</label><html:text property="medicamento.dsMedicamento" maxlength="100" styleClass="input-xxlarge"/>	
		<label>Grupo:	</label>	
		<html:select property="medicamento.grpMedicamento.idGrupoMedicamento" styleClass="input-xlarge">
			<html:option value="">Selecione</html:option>
			<c:forEach var="grp" items="${medicamentoForm.listGrupos}">
				<html:option value="${grp.idGrupoMedicamento}">					
					${grp.dsGrupoMedicamento}
				</html:option>
			</c:forEach>
		</html:select>	
		<br/>
		<html:submit styleClass="btn btn-primary">Gravar</html:submit>
	</html:form>		 

</div>