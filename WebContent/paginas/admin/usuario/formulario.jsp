<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">	

	<h4>Cadastro de Usuário</h4>
	<hr></hr> 
	
	<html:form action="/secure/admin/gravausuario?method=gravar">
		<html:hidden property="usuario.idUsuario"/>
		<html:hidden property="usuario.flSenhaTemporaria"/>
		<html:hidden property="usuario.flAtivo"/>
		<html:hidden property="senhaAtual"/>
		<label>Nome:</label>
		<html:text property="usuario.nome" 		styleClass="input-xxlarge"/>
		<label>Username:</label>
		<html:text property="usuario.username"	styleClass="input-medium"/>
		<label>Senha:</label>
		<html:password property="usuario.senha"	styleClass="input-medium"/>
		<label>Perfil:</label>
		<html:select property="usuario.perfil.idPerfilAcesso"  	styleClass="input-xlarge">
			<html:option value="">Selecione</html:option>
			<html:option value="1">Administrador</html:option>
			<html:option value="2">Cadastro</html:option>
			<html:option value="3">Consulta</html:option>
			<html:option value="4">Aprovador</html:option>
		</html:select>
		<label>E-mail:</label>
		<html:text property="usuario.email" 	styleClass="input-xxlarge"/>
		<label>Unidade:</label>				
		<html:select property="usuario.unidade.idUnidadePesquisa" styleClass="input-xlarge">
			<html:option value="">Selecione</html:option>
			<c:forEach var="un" items="${usuarioForm.listUnidades}">
				<html:option value="${un.idUnidadePesquisa}">
					<c:if test="${fn:length(un.siglaUnidade) > 0}">${un.siglaUnidade} - </c:if>
					${un.dsUnidade}
				</html:option>
			</c:forEach>
		</html:select>
		<br/>	
		<html:submit styleClass="btn btn-primary">Gravar</html:submit>									

	</html:form>
</div>