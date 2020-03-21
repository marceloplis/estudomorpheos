<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqcage" styleId="formQ">
		<html:hidden property="qcage.idQuestionarioCAGE"/>
		<html:hidden property="qcage.visita.idVisita"/>

		<div class="span10">
			<table class="table table-bordered">
				<caption class="text-left well well-small"><strong>Questionário CAGE (Cut Down; Annoyed; Guilty; Eye-opener): avalia risco de etilismo</strong></caption>
				<thead>
				<tr>
				<th></th>
				<th class="text-left">Sim</th>
				<th class="text-left">Não</th>
				</tr>
				</thead>
				<tbody>
				
				<tr>
				<td>Alguma vez o (a) senhor(a) sentiu que deveria diminuir a quantidade de bebida alcoólica ou parar de beber ? (Cut Down)</td>
				<td><html:radio property="qcage.PER_QC01" value="S"/></td>
				<td><html:radio property="qcage.PER_QC01" value="N"/></td>
				</tr>
				
				<tr>
				<td>As pessoas o(a) aborrecem porque criticam o seu modo de tomar bebida alcoólica? (Annoyed)</td>
				<td><html:radio property="qcage.PER_QC02" value="S"/></td>
				<td><html:radio property="qcage.PER_QC02" value="N"/></td>
				</tr>
				
				<tr>
				<td>O(a) senhor(a) se sente chateado(a) consigo mesmo(a) pela maneira como costuma tomar bebidas alcoólicas? (Guilty)</td>
				<td><html:radio property="qcage.PER_QC03" value="S"/></td>
				<td><html:radio property="qcage.PER_QC03" value="N"/></td>
				</tr>
				
				<tr>
				<td>Costuma tomar bebidas alcoólicas pela manha para diminiuir o nervosismo ou ressaca?(Eye-Opener)</td>
				<td><html:radio property="qcage.PER_QC04" value="S"/></td>
				<td><html:radio property="qcage.PER_QC04" value="N"/></td>
				</tr>
				
				<tr class="info">
				<td><strong>Positivo em 3 respostas ?</strong></td>
				<td><html:radio property="qcage.flPositivo" value="S"/></td>
				<td><html:radio property="qcage.flPositivo" value="N"/></td>
				</tr>
				
				</tbody>						
			</table>
										
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

</div>

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