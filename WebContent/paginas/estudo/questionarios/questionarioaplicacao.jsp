<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">
	
	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqaplicacao" styleId="formQ">
		<html:hidden property="qaplicacao.idQuestionarioAplicacao"/>
		<html:hidden property="qaplicacao.visita.idVisita"/>
	
		<div class="span10">					
			<h5 class="well well-small">Questionário Epworth</h5>
			<p><strong>Epworth:</strong> Avaliação de Sonolência Diurna com pontuação maxima de 24 pontos</p>
			<p>Obs: 0 - nenhuma chance de cochilar;</p>
			<p>1 - pequena chance de cochilar;</p>
			<p>2 - média chance de cochilar;</p>
			<p>3 - alta chance de cochilar</p>
			<p><strong>> 10 pontos: Sonolência Excessiva Diurna</strong></p>				
		</div>
		
		<div class="span10">
			<table class="table table-bordered">
			    <thead>
				<tr>
				  <th class="span8">SITUAÇÃO</th>
				  <th class="span2" colspan="4">Chance de Cochilar</th>
				</tr>
				</thead>
				<tbody>
				<tr>
				<td>Sentado e lendo</td>
				<td><html:radio property="qaplicacao.PER_QA01" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA01" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA01" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA01" value="3"/> 3</td>						
				</tr>
	
				<tr>
				<td>Assistindo TV</td>
				<td><html:radio property="qaplicacao.PER_QA02" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA02" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA02" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA02" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Sentado em um lugar público (cinema, igreja, sala de espera)</td>
				<td><html:radio property="qaplicacao.PER_QA03" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA03" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA03" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA03" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Como passageiro de trem, carro ou ônibus, andando uma hora sem parar</td>
				<td><html:radio property="qaplicacao.PER_QA04" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA04" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA04" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA04" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Deitando-se para descansar à tarde, quando as circunstâncias permitem</td>
				<td><html:radio property="qaplicacao.PER_QA05" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA05" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA05" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA05" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Sentado e conversando com alguém</td>
				<td><html:radio property="qaplicacao.PER_QA06" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA06" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA06" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA06" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Sentado calmamente após o almoço (sem álcool)</td>
				<td><html:radio property="qaplicacao.PER_QA07" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA07" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA07" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA07" value="3"/> 3</td>					
				</tr>
				<tr>
				<td>Dirigindo um carro, enquanto pára por alguns minutos ao pegar um trânsito intenso</td>
				<td><html:radio property="qaplicacao.PER_QA08" value="0"/> 0</td>
				<td><html:radio property="qaplicacao.PER_QA08" value="1"/> 1</td>
				<td><html:radio property="qaplicacao.PER_QA08" value="2"/> 2</td>
				<td><html:radio property="qaplicacao.PER_QA08" value="3"/> 3</td>				
				</tr>
				<tr>
				<td colspan="5">Sonolência Excessiva diurna? 
					<label class="radio"><html:radio property="qaplicacao.PER_QA09" value="S"/> Sim </label>
					<label class="radio"><html:radio property="qaplicacao.PER_QA09" value="N"/> Não </label>
					Escala de Sonolência de EPWORTH <html:text property="qaplicacao.PER_QA10" styleClass="span4"/>
				</td>
				</tr>						
				<tr>
				<td colspan="5">Quantas horas em média você dorme por dia? <html:text property="qaplicacao.PER_QA11" styleClass="span1" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas
				</td>
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