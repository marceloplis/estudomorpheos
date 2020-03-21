<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<div class="span10">

		<h4 style="color: #0088CC">Logs de Auditoria</h4>
		<hr></hr>	
		
		<div class="span12">	
			<html:form action="/secure/auditoria?method=lista">
						  
			  	<div class="well well-small">
					<div class="row-fluid">
						<%-- 
						<div class="span10" style="margin-left: 30px;">							
							<label>Paciente</label>
							<html:text property="fltIdPaciente" styleClass="span2" readonly="true" disabled="true" styleId="idPaciente"/> &nbsp; 
							<html:text property="fltNmPaciente" maxlength="100" styleClass="span9" styleId="nomePaciente"/> &nbsp;
							<a href="#" id="btnBuscaPaciente"><img src="../shared/img/search.png" title="Buscar Paciente"/></a>
						</div>
						--%>
						<div class="span3">	
							<div class="inline">
							  	<label>Tipo Cadastro</label>
					  			<html:select property="fltEntidade">
					  				<html:option value="">Todos</html:option>
					  				<html:option value="V">Visitas</html:option>
					  				<html:option value="E">Eventos Adversos</html:option>
					  				<html:option value="S">Saídas do Estudo</html:option>
					  			</html:select>					 						 
							</div>
						</div>
						
						<div class="span3">	
							<div class="inline">
							  	<label>Tipo Modificação</label>
					  			<html:select property="fltModificacao">
					  				<html:option value="">Todas</html:option>
					  				<html:option value="I">Inclusão</html:option>
					  				<html:option value="U">Alteração</html:option>
					  				<html:option value="A">Aprovação</html:option>
					  				<html:option value="E">Exclusão</html:option>
					  			</html:select>					 						 
							</div>
						</div>
						
						<div class="span3">	
							<div class="inline">
								<label>&nbsp;</label>
								<html:submit styleClass="btn">Buscar</html:submit> &nbsp;&nbsp; <html:link styleClass="btn" action="/secure/auditoria.do?method=filtro">Limpar</html:link>
							</div>
						</div>
								
					</div>			
				</div>
				
			</html:form>
		</div>
		
		
         
        <div class="span12"> 
                
			<h5 class="well well-small">Registros &nbsp;&nbsp;&nbsp;</h5>	
		
			<display:table id="log" name="${auditoriaForm.listLogAuditoria}" requestURI="auditoria.do"
			               class="table table-bordered"
				           sort="list" defaultsort="1"
				           pagesize="20" export="true">
				
				<display:column 									title="Data Log" 			sortable="true" headerClass="sortable" style="width: 10%;">
					<fmt:formatDate value="${log.dtModificacao}" type="both"  pattern="dd/MM/yyyy" />
				</display:column>
				<display:column property="username" 				title="Usuario"  			sortable="true" headerClass="sortable" style="width: 10%;"/>
				
				<display:column  									title="Paciente"  			sortable="true" headerClass="sortable" style="width: 15%;">
					${log.paciente.iniciaisNome} - ${log.paciente.cpf}
				</display:column>
				
				<display:column  									title="Unidade"  			sortable="true" headerClass="sortable" style="width: 30%;">
					${log.paciente.unidade.dsUnidade}
				</display:column>
				
				<display:column 									title="Tipo Modificação"	sortable="true" headerClass="sortable" style="width: 15%;">
					<c:choose>
						<c:when test="${log.tpModificacao eq 'I'}">
							Inclusão do Registro
						</c:when>
						<c:when test="${log.tpModificacao eq 'U'}">
							Alteração do Registro
						</c:when>
						<c:when test="${log.tpModificacao eq 'A'}">
							Aprovação do Registro
						</c:when>
						<c:when test="${log.tpModificacao eq 'E'}">
							Exclusão do Registro
						</c:when>
					</c:choose>
				</display:column>
				
				<display:column property="dsModificacao" 			title="Descrição"  			sortable="true" headerClass="sortable" style="width: 15%;"/>				
						           
				<display:setProperty name="export.excel.filename" value="log_auditoria.xls"/>
			    <display:setProperty name="export.excel" value="true" />         
			</display:table>
		
		</div>
		
	</div>

</div>
<%-- 
<a data-target="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>
 
<div class="modal fade hide" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-remote="home.do?method=home">
  	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">Modal header</h3>
  	</div>
  	<div class="modal-body">
	    <p>One fine body</p>
  	</div>
  	<div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
  	</div>
</div>
--%>