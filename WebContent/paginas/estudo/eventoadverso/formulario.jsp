<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<c:set var="now" value="<%=new java.util.Date()%>" />

	<h4 style="color: #0088CC">Cadastro de Evento Adverso</h4>
	<hr></hr>
	
	<div class="span10">
		<div class="well well-small" style="background-color: #ADD8E6">
			<div class="row-fluid">					
				<div class="span4">
					<label><b>Nº do Paciente</b></label>
					<input type="text" value="${eventoForm.paciente.idPaciente}" readonly="true" disabled="true"/>										 
				</div>	
				<div class="span4">
					<label><b>Paciente</b></label> 
					<input type="text" value="${eventoForm.paciente.iniciaisNome}" readonly="true" disabled="true"/>
				</div>	
				<div class="span4">
					<label><b>Data/Hora</b></label> 
					<b><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" /></b>
				</div>			
			</div>	
		</div>			
	</div>	

	<html:form action="/secure/gravaevento?method=gravar" styleId="formE">
		<html:hidden property="evento.idEventoAdverso"/>
		<html:hidden property="evento.paciente.idPaciente" value="${eventoForm.paciente.idPaciente}"/>
	
		<div class="span10">					
			<h5 class="well well-small">EVENTOS ADVERSOS</h5>													
		</div>				
		
		<div class="span10">					
			<p>Se houve alguma intercorrência clínica desde a última visita, preencher abaixo:
			Se Evento Considerado Sério, encaminhar notificação de EAS para o Comitê de Ética Local e Monitor do Estudo  em até 24 horas!
			</p>													
		</div>
		
		<div class="span10">
			<table class="table table-bordered">
			   	<tbody>
				<tr>
					<td class="span6">
						<label><b>Doença apresentada:</b></label>					
					</td>						
					<td class="span6">
						<html:select property="evento.doenca.idDoencaEvento">
							<html:option value="0">Selecione</html:option>
							<c:forEach var="doenca" items="${eventoForm.listDoencas}">
								<html:option value="${doenca.idDoencaEvento}">
									<c:if test="${fn:length(doenca.siglaDoenca) > 0}">${doenca.siglaDoenca} - </c:if>
									${doenca.dsDoenca}
								</html:option>
							</c:forEach>
						</html:select>
					</td>											
				</tr>
				<tr>
					<td class="span6">
						<label><b>Visita do Evento:</b></label>					
					</td>						
					<td class="span6">
						<html:select property="evento.nuVisita">
					  		<html:option value="-1">Selecione</html:option>
					  		<html:option value="0">Visita 00</html:option>
					  		<html:option value="1">Visita 01</html:option>
					  		<html:option value="2">Visita 02</html:option>
					  		<html:option value="3">Visita 03</html:option>
					  		<html:option value="4">Visita 04</html:option>
					  		<html:option value="5">Visita 05</html:option>
					  		<html:option value="6">Visita 06</html:option>
					  		<html:option value="7">Visita 07</html:option>
					  		<html:option value="8">Visita 08</html:option>
					  		<html:option value="9">Visita 09</html:option>
					  		<html:option value="10">Visita 10</html:option>
					  		<html:option value="11">Visita 11</html:option>
					  		<html:option value="12">Visita 12</html:option>
					  		<html:option value="13">Visita 13</html:option>
					  		<html:option value="14">Visita 14</html:option>
					  		<html:option value="15">Visita 15</html:option>
					  		<html:option value="16">Visita 16</html:option>
					  		<html:option value="17">Visita 17</html:option>
					  	</html:select>
					</td>											
				</tr>
				<tr>
					<td>
						<div class="span6">									
							Início <html:text property="evento.dtInicioParse" styleClass="input-small" styleId="dt1"/>							
						</div>
					</td>
					<td>
						<div class="span6">
							Término <html:text property="evento.dtFimParse" styleClass="input-small" styleId="dt2"/>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="span10">
							<p>O evento adverso foi considerado sério?</p>
						</div>
						
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E01" value="S"/>
								Sim
							</label>
						</div>	
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E01" value="N"/>
								Não
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="span10">
							<label>Providências Tomadas</label>
							<html:textarea property="evento.PER_E02" styleClass="span12" rows="3"/>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="span10">
							<label>Evolução</label>
							<html:textarea property="evento.PER_E03" styleClass="span12" rows="3"/>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="span10">
							<p>O evento adverso está relacionado aos tratamentos do estudo? </p>
						</div>
						
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E04" value="1"/>
								Sim
							</label>
						</div>	
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E04" value="2"/>
								Não
							</label>
						</div>
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E04" value="3"/>
								Provavelmente Sim
							</label>
						</div>	
						<div class="span5">
							<label class="radio">
								<html:radio property="evento.PER_E04" value="4"/>
								Provavelmente Não
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="span10">
							<label>Obervações</label>
							<html:textarea property="evento.observacao" styleClass="span12" rows="3"/>
						</div>
					</td>
				</tr>
				</tbody>						
			</table>					
		</div>
		
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || eventoForm.acessoAprovador eq 'S'}">
					<html:hidden property="evento.assinatura" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="evento.stAprovacao" value="A"/>
					<html:hidden property="acessoAprovador" value="S"/>
					<div class="span10">				  
					  	<div class="well well-small">
							<div class="row-fluid">
								<div class="span10">
									<div class="inline">
							  			<html:submit styleClass="btn">Aprovar</html:submit>							  										  
									</div>
								</div>	
								
								<div class="span2">	
									<div class="inline">
									  	<html:link action="/secure/aprovacao?method=lista" styleClass="btn">Voltar para Aprovações</html:link>					 						 
									</div>
								</div>	
									
							</div>			
						</div>
					</div>					
				</c:when>
				
				<c:otherwise>				
					<c:choose>
						<c:when test="${eventoForm.evento.paciente.ativo eq 'N'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Paciente excluído do estudo.</span>
		   					</div>
						</c:when>
					
						<c:when test="${eventoForm.evento.stAprovacao eq 'A'}">
							<div class="span10 hero-unit">
			      				<span class="msg-info">Evento Aprovada por ${eventoForm.evento.assinatura} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${eventoForm.evento.dtAssinatura}" /></span>
		   					</div>
						</c:when>
						
						<c:when test="${eventoForm.evento.stAprovacao eq 'R'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Evento Reprovado por ${eventoForm.evento.assinatura} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${eventoForm.evento.dtAssinatura}" /></span>
		   					</div>
						</c:when>
						
						<c:otherwise>
							<div class="span10">
								<html:submit styleClass="btn btn-primary">Gravar</html:submit>
							</div>
						</c:otherwise>
					</c:choose>					
				</c:otherwise>
				
			</c:choose>
			
		</c:if>
		
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
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || eventoForm.acessoAprovador eq 'S' || eventoForm.evento.stAprovacao eq 'A' || eventoForm.evento.stAprovacao eq 'R' || eventoForm.paciente.ativo eq 'N'}">
		<script>		
			$(document).ready(function() {
				$('#formE input[type=text]').attr("disabled",true);					
		
				$('#formE input[type=radio]').attr("disabled",true);

				$('#formE input[type="text"], textarea').attr("disabled",true);	

				$('#formE input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formE input[type=text]').attr("disabled",false);		
		
				$('#formE input[type=radio]').attr("disabled",false);

				$('#formE input[type="text"], textarea').attr("disabled",false);	

				$('#formE input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>