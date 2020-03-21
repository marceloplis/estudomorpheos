<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/titulovisita.jsp"/>
	
	<html:form action="/secure/gravavisita?method=gravarvisita02" styleId="formV">
		<html:hidden property="visita02.visita.idVisita"/>
		<html:hidden property="visita02.visita.nuVisita" value="2"/>
		<html:hidden property="visita02.visita.paciente.idPaciente" value="${visitasForm.paciente.idPaciente}"/>
	
		<div class="span10">
			<div class="well well-small">
				<div class="row-fluid">					
					<div class="span10">	
						<div class="inline">
						  Data da Realização <html:text property="visita02.visita.dtRealizacaoParse" styleClass="input-small" styleId="dt1"/>	 						 
						</div>
					</div>
					
				</div>			
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th></th>
						<th class="text-left">Sim</th>
						<th class="text-left">Não</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Adesão ao tratamento medicamentoso</td>
						<td><html:radio property="visita02.flAdesaoTratamentoMedicamentoso" value="S"/></td>
						<td><html:radio property="visita02.flAdesaoTratamentoMedicamentoso" value="N"/></td>
					</tr>
					<tr>
						<td colspan="3">
							Porcentagem total de Adesão <html:text property="visita02.pcTotalAdesao" styleClass="span1" maxlength="6" onkeypress="return formata_decimal(this, '', '.', event, 6);"/> %
						</td>
					</tr>
				</tbody>
			</table>
		</div>		
		
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S'}">
					<html:hidden property="visita02.visita.assinaturaAprovador" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="visita02.visita.stAprovacao" value="A"/>
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
					
						<c:when test="${visitasForm.visita02.visita.stAprovacao eq 'A'}">
							<div class="span10 hero-unit">   
			      				<span class="msg-info">Visita Aprovada por ${visitasForm.visita02.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita02.visita.dtAssinaturaAprovacao}" /></span>
		   					</div>
						</c:when>
						
						<c:when test="${visitasForm.visita02.visita.stAprovacao eq 'R'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Visita Reprovada por ${visitasForm.visita02.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita02.visita.dtAssinaturaAprovacao}" /></span>
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
		
		<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && visitasForm.visita02.visita.stAprovacao eq 'A'}">
			<div class="span10 hero-unit">
				<html:link styleClass="btn" action="/secure/visitas?method=desfazerAprovacao&idParam=${visitasForm.visita02.visita.idVisita}" styleId="desfazAprovacao">Desfazer Aprovação</html:link>
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
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qpressaoarterial&idVisita=${visitasForm.visita02.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Pressão Arterial</html:link></li>
								<hr/>
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qaplicacao&idVisita=${visitasForm.visita02.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Questionário Epworth</html:link></li>		
								<hr/>
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qberlim&idVisita=${visitasForm.visita02.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Berlim</html:link></li>		
								<hr/>	
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qcage&idVisita=${visitasForm.visita02.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Questionário CAGE</html:link></li>		
								<hr/>	
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qatividadefisica&idVisita=${visitasForm.visita02.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Questionário Internacional de Atividade Física</html:link></li>		
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
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || visitasForm.visita02.visita.stAprovacao eq 'A' || visitasForm.visita02.visita.stAprovacao eq 'R' || visitasForm.paciente.ativo eq 'N'}">
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