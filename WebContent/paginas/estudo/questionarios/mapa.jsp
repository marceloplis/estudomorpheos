<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqmapa" styleId="formQ">
		<html:hidden property="qmapa.idQuestionarioMAPA"/>
		<html:hidden property="qmapa.visita.idVisita"/>

		<div class="span10">					
			<h5 class="well well-small">MAPA</h5>
			<h5>Proceder de acordo com o manual</h5>								
		</div>
			
		<div class="span10">
			<p>Porcentagem de medidas válidas &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <html:text property="qmapa.qtMedidasValidas" styleClass="span2" maxlength="6" onkeypress="return formata_decimal(this, '', '.', event, 6);"/> %</p>				
			<hr class="mini"></hr> 
		</div>
		
		<div class="span2">
			<label>PAS 24h</label>
			<html:text property="qmapa.PER_QM01" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAS Vigília</label>
			<html:text property="qmapa.PER_QM02" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAS Sono</label>
			<html:text property="qmapa.PER_QM03" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAS Min Sono</label>
			<html:text property="qmapa.PER_QM04" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAS 2h Acordar</label>
			<html:text property="qmapa.PER_QM05" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAD 24h</label>
			<html:text property="qmapa.PER_QM06" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAD Vigília</label>
			<html:text property="qmapa.PER_QM07" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAD Sono</label>
			<html:text property="qmapa.PER_QM08" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAD Min Sono</label>
			<html:text property="qmapa.PER_QM09" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAD 2h Acordar</label>
			<html:text property="qmapa.PER_QM10" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAM 24h</label>
			<html:text property="qmapa.PER_QM11" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAM Vigília</label>
			<html:text property="qmapa.PER_QM12" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAM Sono</label>
			<html:text property="qmapa.PER_QM13" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAM Min Sono</label>
			<html:text property="qmapa.PER_QM14" styleClass="span8" maxlength="5"/> mmHg	
		</div>
		
		<div class="span2">
			<label>PAM 2h Acordar</label>
			<html:text property="qmapa.PER_QM15" styleClass="span8" maxlength="5"/> mmHg	
		</div>			
		
		<div class="span2">
			<label>FC 24h</label>
			<html:text property="qmapa.PER_QM16" styleClass="span8" maxlength="5"/> bpm	
		</div>
		
		<div class="span2">
			<label>FC Vigília</label>
			<html:text property="qmapa.PER_QM17" styleClass="span8" maxlength="5"/> bpm	
		</div>
		
		<div class="span2">
			<label>FC Sono</label>
			<html:text property="qmapa.PER_QM18" styleClass="span8" maxlength="5"/> bpm	
		</div>
		
		<div class="span2">
			<label>Hora de início</label>
			<html:text property="qmapa.hrInicio" styleClass="span8" maxlength="5"/>	
		</div>
		
		<div class="span2">
			<label>Hora de término</label>
			<html:text property="qmapa.hrTermino" styleClass="span8" maxlength="5"/>
		</div>
		
		<div class="span10">
			<label>Observação</label>
			<html:textarea property="qmapa.observacao" styleClass="span12" rows="4"/>
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