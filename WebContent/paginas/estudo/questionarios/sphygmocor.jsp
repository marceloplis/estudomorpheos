<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqsphygmocor" styleId="formQ">
		<html:hidden property="qsphygmocor.idSphygmocor"/>
		<html:hidden property="qsphygmocor.visita.idVisita"/>
		
		<div class="span10">					
			<h5 class="well well-small">SPHYGMOCOR</h5>											
		</div>	
	
		<div class="span10">				
			<h5>Proceder de acordo com o manual</h5>								
		</div>
	
	
		<div class="span10">
			<table class="table table-bordered">
			   	<tbody>
			   	
				<tr>
				<td class="span3">1. PAS Central</td>
				<td class="span7"><html:text property="qsphygmocor.PAS" styleClass="span4" maxlength="10"/> mmHg</td>														
				</tr>
				
				<tr>
				<td class="span3">2. PAD Central</td>
				<td class="span7"><html:text property="qsphygmocor.PAD" styleClass="span4" maxlength="10"/> mmHg</td>														
				</tr>
				
				<tr>
				<td class="span3">3. Pressão de Pulso Central</td>
				<td class="span7"><html:text property="qsphygmocor.PPC" styleClass="span4" maxlength="10"/> mmHg</td>														
				</tr>
				
				<tr>
				<td class="span3">4. Augmentation Index (Alx)</td>
				<td class="span7"><html:text property="qsphygmocor.ALX" styleClass="span4" maxlength="10"/> %</td>														
				</tr>
				
				<tr>
				<td class="span3">5. Alx 75</td>
				<td class="span7"><html:text property="qsphygmocor.ALX75" styleClass="span4" maxlength="10"/> %</td>														
				</tr>
				
				</tbody>						
			</table>								
		</div>
		
		<div class="span10">
			<label>Observações</label>
			<html:textarea property="qsphygmocor.observacao" rows="3" styleClass="span12"/>
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