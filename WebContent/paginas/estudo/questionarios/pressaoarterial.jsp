<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>	

	<html:form action="/secure/gravaquestionarios?method=gravarqpressaoarterial" styleId="formQ">
		<html:hidden property="qpressaoarterial.visita.idVisita"/>

		<div class="span10">
			<p>
				<h5 class="well well-small">MEDIDAS DA PRESS�O ARTERIAL (Sist�lica/Diast�lica) NA POSI��O SENTADA</h5>
				Realizar medidas com o intervalo m�nimo de 01 minuto entre elas. 
				OBSERVA��O: se houver uma diferen�a acima de 5 mmHg entre as medidas de sist�lica ou diast�lica, continuar a verificar PA at� este valor ser menor que 5 mmHg. Realizar at� 5 medidas e efetuar a m�dia entre elas.
				M�nimo de 02 medidas s�o obrigat�rias.
			</p>
		</div>
					
		<div class="span10">
			<div class="space15"></div>
			<label>Bra�o</label>
			<hr class="mini"></hr>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qpressaoarterial.PER_PA00" value="D"/>
				Direito
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpressaoarterial.PER_PA00" value="E"/>
				Esquerdo
			</label>
		</div>
		
		<div class="span10">
			<table class="table table-bordered">
				<tbody>
				<tr>
				<td>1- Press�o Arterial: <html:text property="qpressaoarterial.PER_PA01A" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>Frequ�ncia Card�aca: <html:text property="qpressaoarterial.PER_PA01B" styleClass="span3" maxlength="3" onkeyup="javascript:somente_numero(this);"/> bpm</td>						
				</tr>
				<tr>
				<td>2- Press�o Arterial: <html:text property="qpressaoarterial.PER_PA02A" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>Frequ�ncia Card�aca: <html:text property="qpressaoarterial.PER_PA02B" styleClass="span3" maxlength="3" onkeyup="javascript:somente_numero(this);"/> bpm</td>						
				</tr>
				<tr>
				<td>3- Press�o Arterial: <html:text property="qpressaoarterial.PER_PA03A" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>Frequ�ncia Card�aca: <html:text property="qpressaoarterial.PER_PA03B" styleClass="span3" maxlength="3" onkeyup="javascript:somente_numero(this);"/> bpm</td>						
				</tr>
				<tr>
				<td>4- Press�o Arterial: <html:text property="qpressaoarterial.PER_PA04A" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>Frequ�ncia Card�aca: <html:text property="qpressaoarterial.PER_PA04B" styleClass="span3" maxlength="3" onkeyup="javascript:somente_numero(this);"/> bpm</td>						
				</tr>
				<tr>
				<td>5- Press�o Arterial: <html:text property="qpressaoarterial.PER_PA05A" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>Frequ�ncia Card�aca: <html:text property="qpressaoarterial.PER_PA05B" styleClass="span3" maxlength="3" onkeyup="javascript:somente_numero(this);"/> bpm</td>						
				</tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; <strong>M�dia P.A:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text property="qpressaoarterial.PER_PA06" styleClass="span3" maxlength="7"/> mmHg</td>
				<td>&nbsp;</td>						
				</tr>						
				</tbody>						
			</table>					
		</div>
		
		<c:choose>
			<c:when test="${questionariosForm.visita.paciente.ativo eq 'N'}">
				<div class="span10 hero-unit">
      				<span class="msg-error">Paciente exclu�do do estudo.</span>
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