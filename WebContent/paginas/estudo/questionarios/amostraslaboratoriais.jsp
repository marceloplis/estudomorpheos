<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqbioquimica" styleId="formQ">
		<html:hidden property="qbioquimica.idBioquimica"/>
		<html:hidden property="qbioquimica.visita.idVisita"/>

		<div class="span10">					
			<h5 class="well well-small">AMOSTRAS DE LABORATÓRIO</h5>											
		</div>
		
		<div class="span10">
			<p><strong>Exames Laboratoriais</strong> - coleta de amostras congeladas (os exames deverão ser processados no mesmo dia da coleta)</p>
		</div>	
		
		<div class="span5">
			<label>Data do Processamento de soro e plasma</label>
			<html:text property="qbioquimica.dtProcessamentoSoro" styleClass="span5" styleId="dt1"/>
		</div>
		
		<div class="span6">
			<div class="span10">
				<p>Coletados 4 frascos de soros e 4 de plamas?</p>
			</div>
			<div class="span5">
				<label class="radio">
					<html:radio property="qbioquimica.flQuatroColetas" value="S"/>
					Sim
				</label>
			</div>	
			<div class="span5">
				<label class="radio">
					<html:radio property="qbioquimica.flQuatroColetas" value="N"/>
					Não
				</label>
			</div>
		</div>			
		
		<div class="span10">					
			<p><strong>Bioquímica</strong> - Utilizar dados do prontuário , com data inferior a 1 ano</p>			
		</div>
		
		<div class="span5">
			<label>Data da coleta</label>
			<html:text property="qbioquimica.dtColeta" styleClass="span5" styleId="dt2"/>
		</div>
		
		<div class="span10">
			<table class="table table-bordered">
			    <thead>
				<tr>
				  <th class="span5"></th>
				  <th class="span5">Resultado</th>
				</tr>
				</thead>
				<tbody>
				
				<tr>
				<td>Glicemia</td>
				<td><html:text property="qbioquimica.PER_B01" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>		
	
				<tr>
				<td>Colesterol total</td>
				<td><html:text property="qbioquimica.PER_B02" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>LDL</td>
				<td><html:text property="qbioquimica.PER_B03" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>HDL</td>
				<td><html:text property="qbioquimica.PER_B04" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>Triglicérides</td>
				<td><html:text property="qbioquimica.PER_B05" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>Não HDL</td>
				<td><html:text property="qbioquimica.PER_B06" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>Ác. Úrico</td>
				<td><html:text property="qbioquimica.PER_B07" styleClass="span6" maxlength="10"/> mg/dL</td>											
				</tr>
				
				<tr>
				<td>Renina</td>
				<td><html:text property="qbioquimica.PER_B08" styleClass="span6" maxlength="10"/> ng/mL/h</td>											
				</tr>
				
				<tr>
				<td>Aldosterona</td>
				<td><html:text property="qbioquimica.PER_B09" styleClass="span6" maxlength="10"/> ng/dL</td>											
				</tr>
				
				<tr>
				<td>Microalbuminúria</td>
				<td><html:text property="qbioquimica.PER_B10" styleClass="span6" maxlength="10"/> mg/24h</td>											
				</tr>
				
				<tr>
				<td>PCR Ultra-sensível</td>
				<td><html:text property="qbioquimica.PER_B11" styleClass="span6" maxlength="10"/> mg/dL</td>											
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

<script>		
	$(document).ready(function() {
		$('.datepicker').datepicker();
	});			
											
	$(function(){
		$('#dt1').datepicker({
		  format: 'dd/mm/yyyy'
		});	

		$('#dt2').datepicker({
		  format: 'dd/mm/yyyy'
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