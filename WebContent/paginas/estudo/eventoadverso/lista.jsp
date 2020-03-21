<%@include file="/templates/tags.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/displaytag-table.css"/>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<c:set var="now" value="<%=new java.util.Date()%>" />

	<h4 style="color: #0088CC">Cadastro de Evento Adverso</h4>
	<hr></hr>
	
	<div class="span10">
		<div class="well well-small" style="background-color: #ADD8E6">
			<div class="row-fluid">					
				<div class="span4">
					<label><b>Nº do Paciente</b></label>
					<input type="text" value="${eventoForm.paciente.idPaciente}" readonly="true" disabled="true"/>										 
				</div>	
				<div class="span4">
					<label><b>Paciente</b></label> 
					<input type="text" value="${eventoForm.paciente.iniciaisNome}" readonly="true" disabled="true"/>
				</div>	
				<div class="span4">
					<label><b>Data/Hora</b></label> 
					<b><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" /></b>
				</div>			
			</div>	
		</div>			
	</div>	
	
	<div class="span10">
		<h5 class="well well-small">Eventos Adversos Cadastrados</h5>
	
		<display:table id="evento" name="${eventoForm.listEventos}" requestURI="evento.do"
		               class="table table-bordered"
			           sort="list" defaultsort="1"
			           pagesize="20" export="true">
			
			<display:column                     		title="Data Inclusão"	sortable="true"	headerClass="sortable" style="width: 10%;">
				<fmt:formatDate value="${evento.dtInclusao}" type="both"  pattern="dd/MM/yyyy" />
			</display:column>
			<display:column property="doenca.dsDoenca" 	title="Doença"			sortable="true"  headerClass="sortable" style="width: 45%;"/>
			<display:column                     		title="Data Início"	sortable="true"	headerClass="sortable" style="width: 10%;">
				<fmt:formatDate value="${evento.dtInicio}" type="both"  pattern="dd/MM/yyyy" />
			</display:column>
			<display:column                     		title="Data Término"	sortable="true"	headerClass="sortable" style="width: 10%;">
				<fmt:formatDate value="${evento.dtFim}" type="both"  pattern="dd/MM/yyyy" />
			</display:column>
			<display:column                     		title="Status"			sortable="true"	headerClass="sortable" style="width: 10%;">
				<c:choose>
					<c:when test="${evento.stAprovacao eq 'A'}">
						Aprovado
					</c:when>				
					<c:when test="${evento.stAprovacao eq 'R'}">
						Reprovado
					</c:when>				
					<c:otherwise>
						Pendente
					</c:otherwise>
				</c:choose>	
			</display:column>
			
				<display:column style="width: 10%; text-align:center;" media="html">
					<c:choose>
						<c:when test="${evento.stAprovacao ne 'A' && evento.stAprovacao ne 'R' && eventoForm.paciente.ativo ne 'N'}">
							<html:link action="/secure/evento?method=formulario&idParam=${evento.idEventoAdverso}" styleClass="btn">Editar</html:link>
						</c:when>
						<c:when test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && evento.stAprovacao eq 'A' && eventoForm.paciente.ativo ne 'N'}">
							<html:link action="/secure/evento?method=desfazerAprovacao&idParam=${evento.idEventoAdverso}" styleClass="btn" styleId="desfazAp${evento.idEventoAdverso}">Desfazer Aprovação</html:link>
							<script>
								$('#desfazAp${evento.idEventoAdverso}').on('click', function (e, confirmed) {
								    if (!confirmed) {
								        e.preventDefault();
								        var location = $(this).attr('href');
								        bootbox.confirm("Esta ação irá desfazer a aprovação do evento adverso! Confirma?", function (response) {			
								            if(response) {
								            	window.location.replace(location);
								            }
								        });
								    }
								});
							</script>
						</c:when>
						<c:otherwise>
							&nbsp;
						</c:otherwise>
					</c:choose>
				</display:column>
				<display:column style="width: 10%; text-align:center;" media="html">
					<c:if test="${evento.stAprovacao ne 'A' && evento.stAprovacao ne 'R' && eventoForm.paciente.ativo ne 'N'}">
						<html:link action="/secure/evento?method=excluir&idParam=${evento.idEventoAdverso}" styleClass="btn" styleId="delete${evento.idEventoAdverso}">Excluir</html:link>
						<script>
							$('#delete${evento.idEventoAdverso}').on('click', function (e, confirmed) {
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
			
			<display:setProperty name="export.excel.filename" value="eventos.xls"/>
   		 	<display:setProperty name="export.excel" value="true" />
		</display:table>
		
		</br>
	
		<div align="center">
			<c:choose>
				<c:when test="${eventoForm.paciente.ativo eq 'N'}">
					<div class="span12 hero-unit">
	      				<span class="msg-error">Paciente excluído do estudo.</span>
   					</div>
				</c:when>
				
				<c:otherwise>
					<html:link action="/secure/evento?method=formulario" styleClass="btn btn-primary">Incluir Novo Evento</html:link>
				</c:otherwise>
			</c:choose>	
				
		</div>
		
	</div>		
	
</div>