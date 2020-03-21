<%@include file="/templates/tags.jsp" %>

<h4>Resultado da Busca de Usuários</h4>
<hr></hr> 

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<display:table id="usuario" name="${usuarioForm.listUsuarios}" requestURI="usuario.do"
               class="table table-bordered"
	           sort="list" defaultsort="2"
	           pagesize="20" export="true">
	
	<display:column property="nome"		  		title="Nome"		sortable="true" headerClass="sortable" style="width: 30%;"/>
	<display:column property="username"	  		title="Username"	sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column property="perfil.dsPerfil"	title="Perfil"		sortable="true" headerClass="sortable" style="width: 05%;"/>
	<display:column   					 		title="Unidade"		sortable="true" headerClass="sortable" style="width: 25%;">
		<c:choose>
			<c:when test="${fn:length(usuario.unidade.dsUnidade) > 0}">				
				<c:if test="${fn:length(usuario.unidade.siglaUnidade) > 0}">${usuario.unidade.siglaUnidade} - </c:if>
				${usuario.unidade.dsUnidade}
			</c:when>
			<c:otherwise>Todos (Admin)</c:otherwise>
		</c:choose>
	</display:column>
	<display:column property="email"	  title="E-mail"	sortable="true" headerClass="sortable" style="width: 15%;"/>
	<display:column 					  title="Ativo"		sortable="true" headerClass="sortable" style="width: 05%;" >
		${usuario.flAtivo ? "Sim" : "Não"}
	</display:column>
	<display:column style="width: 05%; text-align:center;" media="html">
		<html:link action="/secure/admin/usuario?method=formulario&idParam=${usuario.idUsuario}" styleClass="btn">Editar</html:link>
	</display:column>
	<display:setProperty name="export.excel.filename" value="usuarios.xls"/>
    <display:setProperty name="export.excel" value="true" />
</display:table>
