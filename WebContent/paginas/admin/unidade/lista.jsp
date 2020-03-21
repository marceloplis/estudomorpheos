<%@include file="/templates/tags.jsp" %>

<h4>Unidades de Pesquisa Cadastradas</h4>
<hr></hr>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<display:table id="unidade" name="${unidadeForm.listUnidades}" requestURI="unidade.do"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="20" export="true">
	<display:column property="nuUnidade"    	title="ID Unidade"	 sortable="true" headerClass="sortable" style="width: 05%;"/>
	<display:column property="dsUnidade"    	title="Descrição"	 sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column property="siglaUnidade" 	title="Sigla"		 sortable="true" headerClass="sortable" style="width: 05%;"/>
	<display:column property="investigador" 	title="Investigador" sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column property="coordenador" 		title="Coordenador"  sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column property="email" 			title="E-mail"		 sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column property="cidade" 			title="Cidade"		 sortable="true" headerClass="sortable" style="width: 10%;"/>
	<display:column property="uf" 				title="UF"			 sortable="true" headerClass="sortable" style="width: 05%;"/>
	<display:column style="width: 05%; text-align:center;">
		<html:link action="/secure/admin/unidade?method=formulario&idParam=${unidade.idUnidadePesquisa}" styleClass="btn">Editar</html:link>
	</display:column>
	<display:setProperty name="export.excel.filename" value="unidades.xls"/>
    <display:setProperty name="export.excel" value="true" />
</display:table>

</br>

<div align="center">
	<html:link action="/secure/admin/unidade?method=formulario" styleClass="btn btn-primary">Incluir Nova Unidade</html:link>
</div>