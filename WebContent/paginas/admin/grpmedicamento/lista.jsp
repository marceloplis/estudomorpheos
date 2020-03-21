<%@include file="/templates/tags.jsp" %>

<h4>Grupos de Medicamentos Cadastrados</h4>
<hr></hr> 

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<display:table id="grupo" name="${grpmedicamentoForm.listGrupos}" requestURI="grpmedicamento.do"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="20" export="true">
	
	<display:column property="idGrupoMedicamento"  	title="ID"		sortable="true"  headerClass="sortable" style="width: 15%;"/>
	<display:column property="dsGrupoMedicamento" 	title="Nome"	sortable="true"  headerClass="sortable" style="width: 35%;"/>	
	<display:column style="width: 10%; text-align:center;" media="html">
		<html:link action="/secure/admin/grpmedicamento?method=formulario&idParam=${grupo.idGrupoMedicamento}" styleClass="btn">Editar</html:link>
	</display:column>
	<display:column style="width: 10%; text-align:center;" media="html">
		<c:if test="${grupo.podeExcluir}">
			<html:link action="/secure/admin/grpmedicamento?method=excluir&idParam=${grupo.idGrupoMedicamento}" styleClass="btn" styleId="delete${grupo.idGrupoMedicamento}">Excluir</html:link>
			<script>
				$('#delete${grupo.idGrupoMedicamento}').on('click', function (e, confirmed) {
					if (!confirmed) {
				        e.preventDefault();
				        var location = $(this).attr('href');
				        bootbox.confirm("Confirma e exclusão?", function (response) {			
				            if(response) {
				            	window.location.replace(location);
				            }
				        });
				    }
				});
			</script>
		</c:if>
	</display:column>
	<display:setProperty name="export.excel.filename" value="grpmedicamentos.xls"/>
    <display:setProperty name="export.excel" value="true" />
</display:table>

</br>

<div align="center">
	<html:link action="/secure/admin/grpmedicamento?method=formulario" styleClass="btn btn-primary">Incluir Novo Grupo</html:link>
</div>