<%@include file="/templates/tags.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/displaytag-table.css"/>

<h4>Doenças Cadastradas</h4>
<hr></hr> 

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<display:table id="doenca" name="${doencaForm.listDoencas}" requestURI="doenca.do"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="20" export="true">	
	<display:column property="dsDoenca"    	title="Nome"		sortable="true"  headerClass="sortable" style="width: 40%;"/>
	<display:column property="siglaDoenca"	title="Sigla"		sortable="true"  headerClass="sortable" style="width: 40%;"/>
	<display:column style="width: 10%; text-align:center;" media="html">
		<html:link action="/secure/admin/doenca?method=formulario&idParam=${doenca.idDoencaEvento}" styleClass="btn">Editar</html:link>
	</display:column>
	<display:column style="width: 10%; text-align:center;" media="html">
		<c:if test="${doenca.podeExcluir}">
			<html:link action="/secure/admin/doenca?method=excluir&idParam=${doenca.idDoencaEvento}" styleClass="btn" styleId="delete${doenca.idDoencaEvento}">Excluir</html:link>
			<script>
				$('#delete${doenca.idDoencaEvento}').on('click', function (e, confirmed) {
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
	<display:setProperty name="export.excel.filename" value="doencas.xls"/>
    <display:setProperty name="export.excel" value="true" />
</display:table>

</br>

<div align="center">
	<html:link action="/secure/admin/doenca?method=formulario" styleClass="btn btn-primary">Incluir Nova Doença</html:link>
</div>