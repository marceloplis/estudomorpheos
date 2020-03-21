<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<div class="span10">

		<h4 style="color: #0088CC">Filtro de Aprovação</h4>
		<hr></hr>
	
		<html:form action="/secure/aprovacao?method=lista">
		
			<div class="span12">				  
			  	<div class="well well-small">
					<div class="row-fluid">
						<div class="span3">
							<div class="inline">				  			
					  			<label>Unidade</label>
					  			<select name="fltUnidade">
					  				<option value="0">Todas</option>
					  				<c:forEach var="un" items="${aprovacaoForm.unidades}">
									<option value="${un.idUnidadePesquisa}">
										<c:if test="${fn:length(un.siglaUnidade) > 0}">${un.siglaUnidade} - </c:if>
										${un.dsUnidade}
									</option>
								</c:forEach>
					  			</select>
							</div>
						</div>
				
						<div class="span3">	
							<div class="inline">
							  	<label>Tipo</label>
					  			<select name="fltTipo">
					  				<option value="0">Todos</option>
					  				<option value="1">Visitas</option>
					  				<option value="2">Eventos Adversos</option>
					  				<option value="3">Saídas do Estudo</option>
					  			</select>					 						 
							</div>
						</div>
						
						<div class="span3">	
							<div class="inline">
								<label>&nbsp;</label>
								<html:submit styleClass="btn">Buscar</html:submit>
							</div>
						</div>
								
					</div>			
				</div>
			</div>
		
		</html:form>
		
	</div>

</div>