<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/titulovisita.jsp"/>
	
	<html:form action="/secure/gravavisita?method=gravarvisita13" styleId="formV">
		<html:hidden property="visita13.visita.idVisita"/>
		<html:hidden property="visita13.visita.nuVisita" value="13"/>
		<html:hidden property="visita13.visita.paciente.idPaciente" value="${visitasForm.paciente.idPaciente}"/>
	
		<div class="span10">
			<div class="well well-small">
				<div class="row-fluid">					
					<div class="span10">	
						<div class="inline">
						  	Data da Realização <html:text property="visita13.visita.dtRealizacaoParse" styleClass="input-small" styleId="dt1"/> 						 
						</div>
					</div>				
				</div>			
			</div>		
		</div>
		
		<div class="span10">
			<p><strong>Mudança de medicação (não programada)?</strong></p>
		</div>
		<html:hidden property="adesaoMedicacao.idMudancaMedicacao"/>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="adesaoMedicacao.flMudancaMedicamento" value="S"/>
				Sim
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="adesaoMedicacao.flMudancaMedicamento" value="N"/>
				Não
			</label>
		</div>		
		
		<div id="Randon2" class="desc">					 		
			
			<div class="clearfix"></div>
			<div class="span10">
				Se sim, motivo <html:text property="adesaoMedicacao.dsMotivo" styleClass="span4" maxlength="45"/>
			</div>
			
			<div class="span10">
				<p><i class="icon-ok"></i> Se sim, é possível manter a medicação prescrita no início do estudo?</p>
			</div>
			
			<div class="span2">
				<label class="radio">
					<html:radio property="adesaoMedicacao.flManterMedicamentoInicial" value="S"/>
					Sim
				</label>
			</div>	
			<div class="span2">
				<label class="radio">
					<html:radio property="adesaoMedicacao.flManterMedicamentoInicial" value="N"/>
					Não
				</label>
			</div>
			
			<div class="span10">
				<p><i class="icon-warning-sign"></i> Se NÃO, critério de exclusão</p>
			</div>
			
			<div class="span10">
				<hr></hr>
			</div>
			
		</div>
		<div id="Randon3" class="desc"></div>
	
	
		<div class="span10">
			<p><strong>Adesão ao tratamento medicamentoso</strong></p>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="adesaoMedicacao.flAdesaoMedicacao" value="S"/>
				Sim
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="adesaoMedicacao.flAdesaoMedicacao" value="N"/>
				Não
			</label>
		</div>
		
		<div class="span10">
			<label>Porcentagem total de Adesão</label>
			<html:text property="adesaoMedicacao.pcAdesaoMedicacao" styleClass="span1" maxlength="6" onkeypress="return formata_decimal(this, '', '.', event, 6);"/> %	
		</div>
		
		<div class="span10">
			<hr></hr>
		</div>
		
		<div class="span10">
			<p>Adesão ao Tratamento de randomização?</p>
		</div>
		<html:hidden property="adesaoTratamento.idAdesaoTratamento"/>
		
		<div class="span5">
			<label class="radio">
				<html:radio property="adesaoTratamento.flAdesaoTratamento" value="S"/>
				Sim
			</label>
		</div>	
		<div class="span5">
			<label class="radio">
				<html:radio property="adesaoTratamento.flAdesaoTratamento" value="N"/>
				Não
			</label>
		</div>
		
		<div class="span5">
			<label>CPAP: Média de horas de uso</label>
			<html:text property="adesaoTratamento.pcMediaCPAP" styleClass="span2" maxlength="6" onkeypress="return formata_decimal(this, '', '.', event, 6);"/> %			
		</div>
		
		<div class="span5">
			<label>Porcentagem de Adesão ao Dilatador nasal</label>
			<html:text property="adesaoTratamento.pcAdesaoDilatador" styleClass="span2" maxlength="6" onkeypress="return formata_decimal(this, '', '.', event, 6);"/> % (contagem dos dilatadores)	
		</div>
		
		<div class="span10">
			<hr></hr>
		</div>
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S'}">
					<html:hidden property="visita13.visita.assinaturaAprovador" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="visita13.visita.stAprovacao" value="A"/>
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
						<c:when test="${visitasForm.paciente.ativo eq 'N'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Paciente excluído do estudo.</span>
		   					</div>
						</c:when>
					
						<c:when test="${visitasForm.visita13.visita.stAprovacao eq 'A'}">
							<div class="span10 hero-unit">   
			      				<span class="msg-info">Visita Aprovada por ${visitasForm.visita13.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita13.visita.dtAssinaturaAprovacao}" /></span>
		   					</div>
						</c:when>
						
						<c:when test="${visitasForm.visita13.visita.stAprovacao eq 'R'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Visita Reprovada por ${visitasForm.visita13.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita13.visita.dtAssinaturaAprovacao}" /></span>
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
		
		<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && visitasForm.visita13.visita.stAprovacao eq 'A'}">
			<div class="span10 hero-unit">
				<html:link styleClass="btn" action="/secure/visitas?method=desfazerAprovacao&idParam=${visitasForm.visita13.visita.idVisita}" styleId="desfazAprovacao">Desfazer Aprovação</html:link>
				<script>
					$('#desfazAprovacao').on('click', function (e, confirmed) {
					    if (!confirmed) {
					        e.preventDefault();
					        var location = $(this).attr('href');
					        bootbox.confirm("Esta ação irá desfazer a aprovação da visita! Confirma?", function (response) {			
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

<c:if test="${flAcessoModal ne 'S'}">	
	<!-- Menu flutuante -->
	<!--MENU FIXO -->			
	<div id="footpanel">
		<ul id="mainpanel">	
			<!--li><a href="javascript:alert('Manual do usuário online')" class="home">Ajuda</a></li--> 
			<li id="chatpanel" class="chatpanelleft">
				<a href="#" class="chat"><i class="icon-list-alt"></i>&nbsp;MAIS QUESTIONÁRIOS</a>
				<div class="subpanel">
					<h3><span> &ndash; </span>Questionários</h3>			   
					<div class="acessoRapido HTMLcommon">						
						<div class="acessoRapidoContainer">
							<ul>
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qpressaoarterial&idVisita=${visitasForm.visita13.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Pressão Arterial</html:link></li>
								<hr/>										
							</ul>
						</div>																		
					</div>	
				</div>
			</li>		
		</ul>
	</div>
</c:if>

<script>		
	$(document).ready(function() {
		$('.datepicker').datepicker();
	});			
											
	$(function(){
		$('#dt1').datepicker({
		  format: 'dd/mm/yyyy'
		});			
	});
	
</script>

<c:choose>
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || visitasForm.visita13.visita.stAprovacao eq 'A' || visitasForm.visita13.visita.stAprovacao eq 'R' || visitasForm.paciente.ativo eq 'N'}">
		<script>		
			$(document).ready(function() {
				$('#formV input[type=text]').attr("disabled",true);					
		
				$('#formV input[type=radio]').attr("disabled",true);

				$('#formV input[type="text"], textarea').attr("disabled",true);	

				$('#formV input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formV input[type=text]').attr("disabled",false);		
		
				$('#formV input[type=radio]').attr("disabled",false);

				$('#formV input[type="text"], textarea').attr("disabled",false);	

				$('#formV input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>