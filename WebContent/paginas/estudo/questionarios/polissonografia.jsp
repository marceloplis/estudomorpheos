<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqpolissonografia" styleId="formQ">
		<html:hidden property="qpolissonografia.idPolissonografia"/>
		<html:hidden property="qpolissonografia.visita.idVisita"/>

		<div class="span10">					
			<h5 class="well well-small">Resultado da Polissonografia</h5>													
		</div>		
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpolissonografia.qtdEventos" value="0"/> 0 - 4,9 eventos/hora (sem apneia)  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpolissonografia.qtdEventos" value="5"/> 5 - 14,9 eventos/h (Leve)  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpolissonografia.qtdEventos" value="15"/> 14,9 - 29,9 eventos/h (Moderado) - Critério de randomização  
			</label>
		</div>
		
		<div class="span5">
			<label class="checkbox">
				<html:radio property="qpolissonografia.qtdEventos" value="30"/> &ge; 30 eventos/h (Grave) - Critério de randomização  
			</label>
		</div>
		
		<div class="span10 clearfix">
			<hr></hr>
		</div>	
		
						
		<div class="span2">
			<label><abbr title="Latência início do sono">Latência início do sono</abbr></label>
			<html:text property="qpolissonografia.latencia" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>TST</label>
			<html:text property="qpolissonografia.TST" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>S1(%)</label>
			<html:text property="qpolissonografia.pcS1" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>S2(%)</label>
			<html:text property="qpolissonografia.pcS2" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>S3 (%)</label>
			<html:text property="qpolissonografia.pcS3" styleClass="span10" maxlength="10"/>
		</div>			
		<div class="span2">
			<label>REM (%)</label>
			<html:text property="qpolissonografia.pcREM" styleClass="span10" maxlength="10"/>
		</div>
		
		<c:if test="${questionariosForm.qpolissonografia.visita.nuVisita == 5}">
			<div class="span10">
				<label>Arquitetura do Sono</label>
				<html:textarea property="qpolissonografia.arquitetura" styleClass="span12" rows="2"/>
			</div>
		</c:if>
		
		
		<div class="span2">
			<label>IAH</label>
			<html:text property="qpolissonografia.IAH" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 basal</label>
			<html:text property="qpolissonografia.satBasal" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 média</label>
			<html:text property="qpolissonografia.satMedia" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Sat O2 mínima</label>
			<html:text property="qpolissonografia.satMinima" styleClass="span10" maxlength="10"/>
		</div>
		
		<div class="span2">
			<label>TS <90%</label>
			<html:text property="qpolissonografia.TSMenor90" styleClass="span10" maxlength="10"/>
		</div>
		<div class="span2">
			<label>Arousals</label>
			<html:text property="qpolissonografia.arousals" styleClass="span10" maxlength="10"/>
		</div>			
		
		<div class="span10">
			<hr class="mini"></hr>
			<p><strong>Resultado</strong></p>					
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qpolissonografia.resultado" value="0"/>
				sem apneia
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpolissonografia.resultado" value="1"/>
				apneia leve
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpolissonografia.resultado" value="2"/>
				apneia moderada
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="qpolissonografia.resultado" value="3"/>
				apneia grave
			</label>			
		</div>	
		
		<c:if test="${questionariosForm.qpolissonografia.visita.nuVisita == 5}">
		
			<div class="span10">
				<hr class="mini"></hr>
			</div>
			
			<div class="span5">
				Pressão ideal de CPAP: <html:text property="qpolissonografia.pressaoCPAP" styleClass="span3" maxlength="10"/> cm H2O
			</div>
			<div class="span5">
				<label class="checkbox">
					<html:checkbox property="qpolissonografia.flAplicaDilatador" value="S"/>
					não se aplica (dilatador nasal)
				</label>
			</div>
			
			<div class="clearfix"></div>
			
			
			<div class="span5">
				<label>Máscara nasal</label>
				<html:select property="qpolissonografia.tmMascaraN" styleClass="span10">
				  <html:option value="">Selecione</html:option>
				  <html:option value="P">Pequena</html:option>
				  <html:option value="M">Média</html:option>
				  <html:option value="G">Grande</html:option>
				</html:select>	
			</div>
			
			<div class="span5">
				<label>Oro-nasal </label>
				<html:select property="qpolissonografia.tmMascaraNO" styleClass="span10">
				  <html:option value="">Selecione</html:option>
				  <html:option value="P">Pequena</html:option>
				  <html:option value="M">Média</html:option>
				  <html:option value="G">Grande</html:option>
				</html:select>	
			</div>
			
		</c:if>
		
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