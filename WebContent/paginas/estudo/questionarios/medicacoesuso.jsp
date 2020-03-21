<%@include file="/templates/tags.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/displaytag-table.css"/>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>


<div class="formulario">				
		
	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqmedicamentouso" styleId="formQ">
		<html:hidden property="qmedicamentouso.idVisitaMedicamentoUso"/>
		<html:hidden property="qmedicamentouso.visita.idVisita"/>
			
		<div class="span10">
			<h5 class="well well-small">MEDICAÇÕES EM USO</h5>		
		</div>	
		
		<div class="span10 linhas well well-small">
		
			<div class="span5">
				<label>Tipo</label>
				<select id="grupo">
					<c:choose>
						<c:when test="${questionariosForm.qmedicamentouso.idVisitaMedicamentoUso > 0 }">
							<option value="${questionariosForm.qmedicamentouso.medicamento.grpMedicamento.idGrupoMedicamento}">${questionariosForm.qmedicamentouso.medicamento.grpMedicamento.dsGrupoMedicamento}</option>
						</c:when>
						<c:otherwise>							
								<option value="-1">Selecione</option>								
						</c:otherwise>
					</c:choose>
					<c:forEach var="grp" items="${questionariosForm.grpsMedicamentos}">
						<option value="${grp.idGrupoMedicamento}">					
							${grp.dsGrupoMedicamento}
						</option>
					</c:forEach>
				</select>
				
			</div>				
		
			<div class="span5">
				<label>Medicamento</label>
				<html:select property="qmedicamentouso.medicamento.idMedicamento" styleId="medicamento">	          		
	          		<c:choose>
	          			<c:when test="${questionariosForm.qmedicamentouso.medicamento.idMedicamento > 0}">
	          				<html:option value="${questionariosForm.qmedicamentouso.medicamento.idMedicamento}">${questionariosForm.qmedicamentouso.medicamento.dsMedicamento}</html:option>
	          			</c:when>
	          			<c:otherwise>
	          				<html:option value="0">Selecione</html:option>
	          			</c:otherwise>
	          		</c:choose>	          		
	       		</html:select>			
			</div>					
			
			<div class="clearfix">
				<div class="span5">						 
					<label>Dose</label>
					<html:text property="qmedicamentouso.dose" styleClass="span5"/> mg					
				</div>
				
				<div class="span5">						
					<label>Posologia</label>
					<html:text property="qmedicamentouso.posologia" styleClass="span5"/>
				</div>
			</div>	
			
			<div class="clearfix">
				<label>Observações</label>
				<html:textarea property="qmedicamentouso.observacao" rows="3" styleClass="span12"/>
			</div>		
		
		</div>	
		
		<c:choose>
			<c:when test="${questionariosForm.visita.paciente.ativo eq 'N'}">
				<div class="span10 hero-unit">
      				<span class="msg-error">Paciente excluído do estudo.</span>
  				</div>
			</c:when>
		
			<c:when test="${questionariosForm.visita.stAprovacao eq 'A'}">
				<div class="span10 hero-unit">   
      				<span class="msg-info">Visita Aprovada por ${questionariosForm.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${questionariosForm.visita.dtAssinaturaAprovacao}" /></span>
  				</div>
			</c:when>
			
			<c:when test="${questionariosForm.visita.stAprovacao eq 'R'}">
				<div class="span10 hero-unit">
      				<span class="msg-error">Visita Reprovada por ${questionariosForm.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${questionariosForm.visita.dtAssinaturaAprovacao}" /></span>
  				</div>
			</c:when>
			
			<c:otherwise>
				<div class="span10">					
					<c:if test="${flAcessoAprovador ne 'S'}">					
						<html:submit styleClass="btn btn-primary">Gravar</html:submit>&nbsp;&nbsp;&nbsp;				
					</c:if>
					<html:link styleClass="btn" action="/secure/visitas.do?method=visita${questionariosForm.visita.nuVisita <= 9 ? '0' : ''}${questionariosForm.visita.nuVisita}&idPaciente=${questionariosForm.visita.paciente.idPaciente}&nuVisita=${questionariosForm.visita.nuVisita}">Voltar</html:link>
				</div>
			</c:otherwise>
		</c:choose>		
		
	</html:form>
	
	<hr></hr>
	
	<div class="span10">
		
		<h5 class="well well-small">Medicações em Uso Cadastradas</h5>	
		<display:table id="medicamento" name="${questionariosForm.medicamentosUso}" requestURI="questionarios.do?method=qmedicamentouso"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="20" export="true">
			<display:column property="medicamento.grpMedicamento.dsGrupoMedicamento" 	title="Grupo de Medicamento" 	sortable="true" headerClass="sortable" style="width: 15%;"/>
			<display:column property="medicamento.dsMedicamento" 						title="Medicamento" 		  	sortable="true" headerClass="sortable" style="width: 15%;"/>
			<display:column property="dose" 											title="Dose" 		  			sortable="true" headerClass="sortable" style="width: 10%;"/>
			<display:column property="posologia" 										title="Posologia" 		  		sortable="true" headerClass="sortable" style="width: 20%;"/>
			<display:column property="observacao" 										title="Observação" 		  		sortable="true" headerClass="sortable" style="width: 35%;"/>
			
			<display:column style="width: 05%; text-align:center;" media="html">
				<html:link action="/secure/questionarios?method=editarmedicamentouso&idParam=${medicamento.idVisitaMedicamentoUso}" styleClass="btn">Editar</html:link>
			</display:column>
			<display:column style="width: 10%; text-align:center;" media="html">
				<html:link action="/secure/questionarios?method=excluirmedicamentouso&idParam=${medicamento.idVisitaMedicamentoUso}" styleClass="btn" styleId="delete${medicamento.idVisitaMedicamentoUso}">Excluir</html:link>
				<script>
					$('#delete${medicamento.idVisitaMedicamentoUso}').on('click', function (e, confirmed) {
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
			</display:column>
			<display:setProperty name="export.excel.filename" value="medicamentos_em_uso.xls"/>
		    <display:setProperty name="export.excel" value="true" />
		</display:table>
				
	</div>	
	
</div>


<script type="text/javascript">
$(function() {
   $("#grupo").change(function() {
     $("#medicamento").empty();
     $.getJSON(location.pathname + '?method=carregaMedicamentos&idGrupo=' + $(this).val(), function(data) {
       $("#medicamento").append('<option value=-1>Selecione</option>');
       $.each(data, function(index, item) {
         $("#medicamento").append('<option value=' + item.id + '>' + item.nome + '</option>');
       });
     });
   });
});
</script>

<c:choose>
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || questionariosForm.visita.stAprovacao eq 'A' || questionariosForm.visita.stAprovacao eq 'R' || questionariosForm.visita.paciente.ativo eq 'N'}">
		<script>		
			$(document).ready(function() {
				$('#formQ input[type=text]').attr("disabled",true);					
		
				$('#formQ input[type=radio]').attr("disabled",true);

				$('#formQ input[type="text"], textarea').attr("disabled",true);	

				$('#formQ input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formQ input[type=text]').attr("disabled",false);		
		
				$('#formQ input[type=radio]').attr("disabled",false);

				$('#formQ input[type="text"], textarea').attr("disabled",false);	

				$('#formQ input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>
