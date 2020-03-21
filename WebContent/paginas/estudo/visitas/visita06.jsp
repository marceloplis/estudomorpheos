<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/titulovisita.jsp"/>
	
	<html:form action="/secure/gravavisita?method=gravarvisita06" styleId="formV">
		<html:hidden property="visita06.visita.idVisita"/>
		<html:hidden property="visita06.visita.nuVisita" value="6"/>
		<html:hidden property="visita06.visita.paciente.idPaciente" value="${visitasForm.paciente.idPaciente}"/>
	
		<div class="span10">
			<div class="well well-small">
				<div class="row-fluid">					
					<div class="span10">	
						<div class="inline">
						  	Data da Realiza��o <html:text property="visita06.visita.dtRealizacaoParse" styleClass="input-small" styleId="dt1"/>	 						 
						</div>
					</div>				
				</div>			
			</div>		
		</div>		
	
		<div class="span10">
			<p>Realizado adapta��o com dilatador nasal e com CPAP?</p>
		</div>
		
		<div class="span5">
			<label class="radio">
				<html:radio property="visita06.flAdaptacaoDoisGrupos" value="S"/>
				Sim
			</label>
		</div>	
		<div class="span5">
			<label class="radio">
				<html:radio property="visita06.flAdaptacaoDoisGrupos" value="N"/>
				N�o
			</label>
		</div>
		
		<div class="span5">
			<label>CPAP entregue?</label>
			<html:select property="visita06.flCPAPEntregue" styleClass="span6">
				<html:option value="">Selecione</html:option>
				<html:option value="S">Sim</html:option>
				<html:option value="N">N�o</html:option>
			</html:select>			
		</div>
		
		<div class="span5">
			<label>Dilatador Nasal entregue?</label>
			<html:select property="visita06.flDilatadorEntregue" styleClass="span6">
				<html:option value="">Selecione</html:option>
				<html:option value="S">Sim</html:option>
				<html:option value="N">N�o</html:option>
			</html:select>		
		</div>
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S'}">
					<html:hidden property="visita06.visita.assinaturaAprovador" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="visita06.visita.stAprovacao" value="A"/>
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
									  	<html:link action="/secure/aprovacao?method=lista" styleClass="btn">Voltar para Aprova��es</html:link>					 						 
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
			      				<span class="msg-error">Paciente exclu�do do estudo.</span>
		   					</div>
						</c:when>
					
						<c:when test="${visitasForm.visita06.visita.stAprovacao eq 'A'}">
							<div class="span10 hero-unit">   
			      				<span class="msg-info">Visita Aprovada por ${visitasForm.visita06.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita06.visita.dtAssinaturaAprovacao}" /></span>
		   					</div>
						</c:when>
						
						<c:when test="${visitasForm.visita06.visita.stAprovacao eq 'R'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Visita Reprovada por ${visitasForm.visita06.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita06.visita.dtAssinaturaAprovacao}" /></span>
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
		
		<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && visitasForm.visita06.visita.stAprovacao eq 'A'}">
			<div class="span10 hero-unit">
				<html:link styleClass="btn" action="/secure/visitas?method=desfazerAprovacao&idParam=${visitasForm.visita06.visita.idVisita}" styleId="desfazAprovacao">Desfazer Aprova��o</html:link>
				<script>
					$('#desfazAprovacao').on('click', function (e, confirmed) {
					    if (!confirmed) {
					        e.preventDefault();
					        var location = $(this).attr('href');
					        bootbox.confirm("Esta a��o ir� desfazer a aprova��o da visita! Confirma?", function (response) {			
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
			<!--li><a href="javascript:alert('Manual do usu�rio online')" class="home">Ajuda</a></li--> 
			<li id="chatpanel" class="chatpanelleft">
				<a href="#" class="chat"><i class="icon-list-alt"></i>&nbsp;MAIS QUESTION�RIOS</a>
				<div class="subpanel">
					<h3><span> &ndash; </span>Question�rios</h3>			   
					<div class="acessoRapido HTMLcommon">						
						<div class="acessoRapidoContainer">
							<ul>
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qpressaoarterial&idVisita=${visitasForm.visita06.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Press�o Arterial</html:link></li>
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
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || visitasForm.visita06.visita.stAprovacao eq 'A' || visitasForm.visita06.visita.stAprovacao eq 'R' || visitasForm.paciente.ativo eq 'N'}">
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