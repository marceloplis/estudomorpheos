<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<c:set var="now" value="<%=new java.util.Date()%>" />

	<h4 style="color: #0088CC">Saída do Paciente do Estudo</h4>
	<hr></hr>
	
	<div class="span10">
		<div class="well well-small" style="background-color: #ADD8E6">
			<div class="row-fluid">					
				<div class="span4">
					<label><b>Nº do Paciente</b></label>
					<input type="text" value="${saidaForm.paciente.idPaciente}" readonly="true" disabled="true"/>										 
				</div>	
				<div class="span4">
					<label><b>Paciente</b></label> 
					<input type="text" value="${saidaForm.paciente.iniciaisNome}" readonly="true" disabled="true"/>
				</div>	
				<div class="span4">
					<label><b>Data/Hora</b></label> 
					<b><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" /></b>
				</div>			
			</div>	
		</div>			
	</div>	

	<h4></h4>	
	<hr></hr>
	
	<html:form action="/secure/gravasaida?method=gravar" styleId="formS">
		<html:hidden property="saida.idSaidaEstudo"/>
		<html:hidden property="saida.paciente.idPaciente" value="${saidaForm.paciente.idPaciente}"/>
		
		<div class="span10">				  
		  	<div class="well well-small">
				<div class="row-fluid">
					<div class="span3">	
						<div class="inline">
						  	<label>Data da Saída do Estudo</label>	
						  	<html:text property="saida.dtSaidaParse" styleClass="input-small" styleId="dt1"/>						 						 
						</div>
					</div>
					<div class="span3">	
						<div class="inline">
						  	<label>Visita da Exclusão</label>	
						  	<html:select property="saida.nuVisita">
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
						</div>						
					</div>			
				</div>			
			</div>
		</div>
		
		<div class="span10">
			<div class="space15"></div>
			<label>Motivo da Saída</label>	
			<hr class="mini"></hr>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="1"/>
				Finalizou o Estudo
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="2"/>
				Decisão do Paciente
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="3"/>
				Retirada do TCLE pelo paciente
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="4"/>
				Descoberta de Critérios de Exclusão no decorrer do estudo
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="5"/>
				Necessidade de uso de droga e/ou procedimentos não permitidos pelo protocolo
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="6"/>
				Perda de Seguimento
			</label>
		</div>					
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="7"/>
				Evento Adverso Sério
			</label>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="8"/>
				Decisão do Médico
			</label>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="saida.motivo" value="9"/>
				Outros (descrever abaixo)
			</label>
		</div>
		
		<div class="span10">
			<label>Obervações</label>
			<html:textarea property="saida.observacao" styleClass="span12" rows="3"/>
		</div>

		<div class="span10">
			<div class="span5">						 
				<label>Data da Ocorrência</label>
				<html:text property="saida.dtOcorrenciaParse" styleClass="input-small" styleId="dt2"/>
			</div>
			
			<div class="span5">						
				<label>Evoluiu para Óbito</label>
				<div class="span2">
					<label class="radio">
						<html:radio property="saida.flEvolucaoObito" value="S"/>
						Sim
					</label>
				</div>	
				<div class="span2">
					<label class="radio">
						<html:radio property="saida.flEvolucaoObito" value="N"/>
						Não
					</label>
				</div>				
			</div>
		</div>		
		
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S'}">
					<html:hidden property="saida.assinatura" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="saida.stAprovacao" value="A"/>
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
						<c:when test="${saidaForm.paciente.ativo eq 'N'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Paciente excluído do estudo</span>		      							
								<c:choose>
									<c:when test="${saidaForm.saida.stAprovacao eq 'A'}">  
						      			<span class="msg-info">&nbsp;[Saída Aprovada por ${saidaForm.saida.assinatura} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${saidaForm.saida.dtAssinatura}" />]</span>
									</c:when>
									
									<c:when test="${saidaForm.saida.stAprovacao eq 'R'}">
						      			<span class="msg-error">&nbsp;[Saída Reprovado por ${saidaForm.saida.assinatura} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${saidaForm.saida.dtAssinatura}" />]</span>
									</c:when>
									<c:otherwise>
										<span class="msg-info">&nbsp;[Saída pendente de aprovação]</span>
									</c:otherwise>									
								</c:choose>									
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
		
		<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && saidaForm.saida.stAprovacao eq 'A'}">
			<div class="span10 hero-unit">
				<html:link styleClass="btn" action="/secure/saida?method=desfazerAprovacao&idParam=${saidaForm.paciente.idPaciente}" styleId="desfazAprovacao">Desfazer Aprovação</html:link>
				<script>
					$('#desfazAprovacao').on('click', function (e, confirmed) {
					    if (!confirmed) {
					        e.preventDefault();
					        var location = $(this).attr('href');
					        bootbox.confirm("Esta ação irá desfazer a aprovação da saída do estudo do paciente! Confirma?", function (response) {			
					            if(response) {
					            	window.location.replace(location);
					            }
					        });
					    }
					});
				</script>
			</div>
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
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || saidaForm.saida.stAprovacao eq 'A' || saidaForm.saida.stAprovacao eq 'R' || saidaForm.paciente.ativo eq 'N'}">
		<script>		
			$(document).ready(function() {
				$('#formS input[type=text]').attr("disabled",true);					
		
				$('#formS input[type=radio]').attr("disabled",true);

				$('#formS input[type="text"], textarea').attr("disabled",true);	

				$('#formS input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formS input[type=text]').attr("disabled",false);		
		
				$('#formS input[type=radio]').attr("disabled",false);

				$('#formS input[type="text"], textarea').attr("disabled",false);	

				$('#formS input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>