<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqpoligrafia" styleId="formQ">
		<html:hidden property="qpoligrafia.idPoligrafia"/>
		<html:hidden property="qpoligrafia.visita.idVisita"/>
	
		<div class="span10">					
			<h5 class="well well-small">Resultado da Poligrafia Portátil</h5>													
		</div>
		
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpoligrafia.qtdEventos" value="0"/> 0 - 4,9 eventos/hora (sem apneia)  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpoligrafia.qtdEventos" value="5"/> 5 - 14,9 eventos/h (Leve)  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpoligrafia.qtdEventos" value="15"/> 14,9 - 29,9 eventos/h (Moderado) - Critério de randomização  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpoligrafia.qtdEventos" value="30"/> &ge; 30 eventos/h (Grave) - Critério de randomização  
			</label>
		</div>	
		
		<div class="span10">
			<label>Local</label>
			<html:text property="qpoligrafia.local" styleClass="span10" maxlength="45"/>
		</div>
		
		<div class="span2">
			<label>IAH</label>
			<html:text property="qpoligrafia.IAH" styleClass="span5" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 basal</label>
			<html:text property="qpoligrafia.satBasal" styleClass="span5" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 média</label>
			<html:text property="qpoligrafia.satMedia" styleClass="span5" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 mínima</label>
			<html:text property="qpoligrafia.satMinimo" styleClass="span5" maxlength="10"/>
		</div>
		<div class="span2">
			<label>TS <90%</label>
			<html:text property="qpoligrafia.TSMenor90" styleClass="span5" maxlength="10"/>
		</div>
		
		
		<div class="span10">
			<hr class="mini"></hr>
			<p><strong>Resultado</strong></p>					
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.resultado" value="0"/>
				sem apneia
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.resultado" value="1"/>
				apneia leve
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.resultado" value="2"/>
				apneia moderada
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.resultado" value="3"/>
				apneia grave
			</label>
		</div>
	
		<div class="span10">
			<div class="space15"></div>
			<h5 class="well well-small">Status do paciente</h5>					
		</div>
		
		<div class="span10">
			<p>Confirmado AOS MODERADA OU GRAVE pela poligrafia?</p>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.flAOSGrave" value="S"/>
				Sim
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpoligrafia.flAOSGrave" value="N"/>
				Não (Excluir do Estudo)
			</label>
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