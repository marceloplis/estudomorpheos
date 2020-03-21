<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>


<div class="formulario">	

	<h4>Acesso ao Paciente</h4>
	<hr></hr> 

	<html:form action="/secure/paciente?method=buscar" styleId="form">		
		
		<div class="span10">
			<table class="table table-bordered">
				<caption class="text-left well well-small"><strong>Buscar Paciente</strong></caption>
				<thead>
					<tr>
						<th class="text-left">Por favor informe ao menos 2 caracteres</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<html:text property="nmBusca" size="50" styleId="nmBusca" style="margin-top: 10px;"/> &nbsp;&nbsp; <html:submit styleClass="btn">Buscar</html:submit>
						</td>						
					</tr>
					<tr>
						<td>
							<texto>
								O valor informado irá buscar o Paciente pelas seguintes informações:<br/>
								- Nome do Paciente</br>
								- Iniciais</br>
								- CPF</br>
								- Nº de Registro
							</texto>
						</td>
					</tr>
				</tbody>
			</table>
			
			<br/><br/>		

			<html:link action="/secure/paciente?method=todos" styleClass="btn btn-primary">Listar Todos</html:link>			
			<c:if test="${UsuarioSistema.perfil.idPerfilAcesso <= 2}">
				&nbsp;&nbsp;&nbsp;
				<html:link action="/secure/paciente?method=formulario" styleClass="btn btn-primary">Novo Paciente</html:link>
			</c:if>
		</div>
		
	</html:form>
	
</div>
