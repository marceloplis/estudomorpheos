<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<style type="text/css">
	negrito{
		font:  bold 14px Verdana;
		color: #0000FF;
	}
</style>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqberlim" styleId="formQ">
		<html:hidden property="qberlim.idQuestionarioBerlim"/>
		<html:hidden property="qberlim.visita.idVisita"/>

		<div class="span10">					
			<h5 class="well well-small">Berlim: Questionário dividido em 3 categorias</h5>									
		</div>
		
		<div class="span10">
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="3">1- Seu peso mudou os últimos anos?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB01" value="1"/> Aumentou</td>
				<td><html:radio property="qberlim.PER_QB01" value="2"/> Diminuiu</td>
				<td><html:radio property="qberlim.PER_QB01" value="3"/> Não mudou</td>												
				</tr>
				</tbody>
			</table>	
			
			<h5>Categoria ou Domínio 1</h5>
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="3">2- Você ronca?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB02" value="1"/> <negrito>Sim</negrito></td>
				<td><html:radio property="qberlim.PER_QB02" value="2"/> Não</td>
				<td><html:radio property="qberlim.PER_QB02" value="3"/> Não sabe</td>												
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="4">3- O seu ronco é</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB03" value="1"/> Tão alto quanto a respiração</td>
				<td><html:radio property="qberlim.PER_QB03" value="2"/> Tão alto quanto falar</td>
				<td><html:radio property="qberlim.PER_QB03" value="3"/> <negrito>Mais alto que falar</negrito> </td>
				<td><html:radio property="qberlim.PER_QB03" value="4"/> <negrito>Muito alto, ouve-se de outros quartos</negrito> </td>						
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="5">4- Você ronca</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB04" value="1"/> <negrito>Quase todo dia</negrito></td>
				<td><html:radio property="qberlim.PER_QB04" value="2"/> <negrito>3-4 vezes por semana</negrito></td>
				<td><html:radio property="qberlim.PER_QB04" value="3"/> 1-2 vezes por semana</td>
				<td><html:radio property="qberlim.PER_QB04" value="4"/> 1-2 vezes por mês</td>
				<td><html:radio property="qberlim.PER_QB04" value="5"/> Nunca ou quase nunca </td>						
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2">5- O seu ronco incomoda outras pessoas?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB05" value="S"/> <negrito>Sim</negrito></td>
				<td><html:radio property="qberlim.PER_QB05" value="N"/> Não</td>					
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="6">6- Com que frequência suas paradas respiratórias ('engasgos') durante o sono são percebidas?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB06" value="1"/> <negrito>Quase todo dia</negrito></td>
				<td><html:radio property="qberlim.PER_QB06" value="2"/> <negrito>3-4 vezes por semana</negrito></td>
				<td><html:radio property="qberlim.PER_QB06" value="3"/> 1-2 vezes por semana</td>	
				<td><html:radio property="qberlim.PER_QB06" value="4"/> 1-2 vezes por mês</td>	
				<td><html:radio property="qberlim.PER_QB06" value="5"/> Nunca ou quase nunca</td>	
				<td><html:radio property="qberlim.PER_QB06" value="6"/> Não aplicável pois o paciente dorme sozinho</td>							
				</tr>
				</tbody>
			</table>
			<h5>Categoria ou Domínio 2</h5>
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="5">7- Você se sente cansado/fadigado ao acordar?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB07" value="1"/> <negrito>Quase todo dia</negrito></td>
				<td><html:radio property="qberlim.PER_QB07" value="2"/> <negrito>3-4 vezes por semana</negrito></td>
				<td><html:radio property="qberlim.PER_QB07" value="3"/> 1-2 vezes por semana</td>
				<td><html:radio property="qberlim.PER_QB07" value="4"/> 1-2 vezes por mês</td>
				<td><html:radio property="qberlim.PER_QB07" value="5"/> Nunca ou quase nunca</td>
				</tr>
				</tbody>
			</table>					
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="5">8- Você se sente cansado/fadigado durante o dia?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB08" value="1"/> <negrito>Quase todo dia</negrito></td>
				<td><html:radio property="qberlim.PER_QB08" value="2"/> <negrito>3-4 vezes por semana</negrito></td>
				<td><html:radio property="qberlim.PER_QB08" value="3"/> 1-2 vezes por semana</td>
				<td><html:radio property="qberlim.PER_QB08" value="4"/> 1-2 vezes por mês</td>
				<td><html:radio property="qberlim.PER_QB08" value="5"/> Nunca ou quase nunca</td>
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="3">9- Você alguma vez dormiu enquanto dirigia?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB09A" value="1"/> <negrito>Sim</negrito></td>
				<td><html:radio property="qberlim.PER_QB09A" value="2"/> Não</td>
				<td><html:radio property="qberlim.PER_QB09A" value="3"/> Não sei / Não aplicável</td>
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="5">Se sim, com que freqüência isso ocorre?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB09B" value="1"/> <negrito>Todos os dias</negrito></td>
				<td><html:radio property="qberlim.PER_QB09B" value="2"/> <negrito>3-4 vezes por semana</negrito></td>
				<td><html:radio property="qberlim.PER_QB09B" value="3"/> 1-2 vezes por semana</td>
				<td><html:radio property="qberlim.PER_QB09B" value="4"/> 1-2 vezes por mês</td>
				<td><html:radio property="qberlim.PER_QB09B" value="5"/> Nunca ou quase nunca</td>
				</tr>
				</tbody>
			</table>
			<h5>Categoria ou Domínio 3</h5>
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="3">10- Você tem pressão alta?</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB10" value="1"/> <negrito>Sim</negrito></td>
				<td><html:radio property="qberlim.PER_QB10" value="2"/> Não</td>
				<td><html:radio property="qberlim.PER_QB10" value="3"/> Não sabe</td>
				</tr>
				</tbody>
			</table>
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2">11 - IMC > 30</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.PER_QB11" value="S"/> <negrito>Sim</negrito></td>
				<td><html:radio property="qberlim.PER_QB11" value="N"/> Não</td>
				</tr>
				</tbody>
			</table>
			
			<h5>Berlin Resultados</h5>
			<p>Categorias 1 e 2: Positivas quando a somatória é de 2 ou mais respostas para as alternativas em Negrito Azul.</p>	
			<p>Categoria 3: Positiva se hipertensão ou IMC maior que 30.</p>
			<div class="space15"></div>
			
	
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2">Categoria-1</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.CAT_01" value="P"/> Positiva</td>
				<td><html:radio property="qberlim.CAT_01" value="N"/> Negativa</td>
				</tr>
				</tbody>
			</table>
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2">Categoria-2</td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.CAT_02" value="P"/> Positiva</td>
				<td><html:radio property="qberlim.CAT_02" value="N"/> Negativa</td>
				</tr>
				</tbody>
			</table>
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2"><p>Categoria-3   <strong>PA- Categoria Positiva Critério de Inclusão</strong></p></td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.CAT_03" value="S"/> Sim</td>
				<td><html:radio property="qberlim.CAT_03" value="N"/> Não</td>
				</tr>
				</tbody>
			</table>		
			
			
			<table class="table table-bordered">					    
				<tbody>
				<tr>
				<td colspan="2"><h4>Berlin FINAL</h4></td>
				<tr>
				<tr>
				<td><html:radio property="qberlim.resultado" value="1"/> Alto risco ( 2 das 3 categorias)</td>
				<td><html:radio property="qberlim.resultado" value="2"/> Baixo risco</td>
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