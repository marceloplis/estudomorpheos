<%@include file="/templates/tags.jsp" %>

<h4>Medicamentos Cadastrados</h4>
<hr></hr>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<display:table id="medicamento" name="${medicamentoForm.listMedicamentos}" requestURI="medicamento.do"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="20" export="true">
	
	<display:column property="idMedicamento"  						title="ID"		sortable="true"  headerClass="sortable" style="width: 15%;"/>
	<display:column property="dsMedicamento" 						title="Nome"	sortable="true"  headerClass="sortable" style="width: 30%;"/>
	<display:column property="grpMedicamento.dsGrupoMedicamento" 	title="Grupo"	sortable="true"  headerClass="sortable" style="width: 30%;"/>
		
	<display:column style="width: 10%; text-align:center;" media="html">
		<html:link action="/secure/admin/medicamento?method=formulario&idParam=${medicamento.idMedicamento}" styleClass="btn">Editar</html:link>
	</display:column>
	<display:column style="width: 10%; text-align:center;" media="html">
		<c:if test="${medicamento.podeExcluir}">
			<html:link action="/secure/admin/medicamento?method=excluir&idParam=${medicamento.idMedicamento}" styleClass="btn" styleId="delete${medicamento.idMedicamento}">Excluir</html:link>
			<script>
				$('#delete${medicamento.idMedicamento}').on('click', function (e, confirmed) {
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
	<display:setProperty name="export.excel.filename" value="medicamentos.xls"/>
    <display:setProperty name="export.excel" value="true" />
</display:table>

</br>

<div align="center">
	<html:link action="/secure/admin/medicamento?method=formulario" styleClass="btn btn-primary">Incluir Novo Medicamento</html:link>
</div>