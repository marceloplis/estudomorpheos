<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/titulovisita.jsp"/>	
	
	<html:form action="/secure/gravavisita?method=gravarvisita00" styleClass="visitaForm"  styleId="formV">
		<html:hidden property="visita00.visita.idVisita"/>
		<html:hidden property="visita00.visita.nuVisita" value="0"/>
		<html:hidden property="visita00.visita.paciente.idPaciente" value="${visitasForm.paciente.idPaciente}"/>
	
		<div class="span10">				  
		  	<div class="well well-small">
				<div class="row-fluid">
					<div class="span3">
						<div class="inline">
				  			<label>Assinatura TCLE </label>
				  
							<label class="radio inline">
							  	<html:radio property="visita00.flAssinaturaTCLE" value="S"/>
							  	Sim
							</label>
							<label class="radio inline">
							  	<html:radio property="visita00.flAssinaturaTCLE" value="N"/>
							  	Não
							</label>
				  
						</div>
					</div>
			
					<div class="span3">	
						<div class="inline">
						  	<label>Data da Realização</label>	
						  	<html:text property="visita00.visita.dtRealizacaoParse" styleClass="input-small" styleId="dt1"/>						 						 
						</div>
					</div>		
				</div>			
			</div>
		</div>
		
		<div class="span10">
			<div class="space20"></div>
			<div class="well well-small">
				1 - Data da assinatura do TCLE: <html:text property="visita00.dtAssinaturaTCLEParse" styleClass="span2" styleId="dt2"/> para participação no Projeto <strong>"Morbidade em Pacientes com Hipertensão Arterial e Apneia Obstrutiva do Sono"</strong>
				<p>
					<small><em>Obs.: O paciente deverá assinar e datar o Termo de Consentimento Livre e Esclarecido antes da solicitação de exames ou procedimentos que visem a sua inclusão no estudo, ou seja, no primeiro contato. Uma cópia deverá ser entregue ao paciente.</em></small>
				</p>
			</div>
		</div>
						
		<div class="span10">
			<table class="table table-bordered">
				<caption class="text-left well well-small"><strong>CRITÉRIOS DE INCLUSÃO</strong></caption>
				<thead>
				<tr>
				<th></th>
				<th class="text-left">Sim</th>
				<th class="text-left">Não</th>
				</tr>
				</thead>
				<tbody>
				<tr>
				<td>1. Hipertenso não controlado com valor pressórico de &ge; 140 mmHg de PAS ou &ge; 90 para PAD mm Hg?</td>
				<td><html:radio property="visita00.PER_V00_CI01" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CI01" value="N"/></td>
				</tr>
				<tr>
				<td>2. Fazendo uso de, no mínimo, 01 medicamento anti-hipertensivo?</td>
				<td><html:radio property="visita00.PER_V00_CI02" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CI02" value="N"/></td>
				</tr>
				</tbody>						
			</table>
			<p><small><em>Se qualquer resposta acima for NÃO, o paciente não poderá participar do estudo!</em></small></p>
			<div class="space20"></div>
		</div>	
						
		<div class="span10">
			<table class="table table-bordered">
				<caption class="text-left well well-small"><strong>CRITÉRIOS DE EXCLUSÃO - Proceder de acordo com o Manual de Procedimentos</strong></caption>
				<thead>
				<tr>
				<th></th>
				<th class="text-left">Sim</th>
				<th class="text-left">Não</th>
				</tr>
				</thead>
				<tbody>
				
				<tr>
				<td>1- Idade &ge; 65 anos?</td>
				<td><html:radio property="visita00.PER_V00_CE01" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE01" value="N"/></td>
				</tr>
				
				<tr>
				<td>2- Diagnóstico de Insuficiência Cardíaca ou FE < 45%, IAM e AVC prévio;</td>
				<td><html:radio property="visita00.PER_V00_CE02" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE02" value="N"/></td>
				</tr>
				
				<tr>
				<td>3- Insuficiência renal crônica, definido por creatinina sérica maior que 2 mg/dl?</td>
				<td><html:radio property="visita00.PER_V00_CE03" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE03" value="N"/></td>
				</tr>
				
				<tr>
				<td>4- Usuários de Cocaína, anfetaminas, álcool, outras drogas ilícitas, não aderentes à terapêutica para o tratamento de hipertensão?</td>
				<td><html:radio property="visita00.PER_V00_CE04" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE04" value="N"/></td>
				</tr>
				<tr>
				<td>5- Uso de simpaticomiméticos (descongestionantes, anorexígenos)?</td>
				<td><html:radio property="visita00.PER_V00_CE05" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE05" value="N"/></td>
				</tr>
				<tr>
				<td>6- Uso de anticoncepcionais orais e uso crônico de antiinflamatórios não hormonais?</td>
				<td><html:radio property="visita00.PER_V00_CE06" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE06" value="N"/></td>
				</tr>
				<tr>
				<td>7- Gravidez atual?</td>
				<td><html:radio property="visita00.PER_V00_CE07" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE07" value="N"/></td>
				</tr>
				<tr>
				<td>8- Valor de PA igual ou acima da margem de segurança: 180x110 mmHg ?</td>
				<td><html:radio property="visita00.PER_V00_CE08" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE08" value="N"/></td>
				</tr>
				<tr>
				<td>9- Causa secundária conhecida de hipertensão arterial, conforme consta no Manual de Procedimentos?, Outras que não apneia do sono?</td>
				<td><html:radio property="visita00.PER_V00_CE09" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE09" value="N"/></td>
				</tr>
				<tr>
				<td>10- IMC &ge; 40 kg/m2?</td>
				<td><html:radio property="visita00.PER_V00_CE10" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_CE10" value="N"/></td>
				</tr>
				</tbody>						
			</table>
			<p><small><em>Se qualquer resposta acima for SIM, o paciente não poderá participar do estudo!</em></small></p>
			<div class="space20"></div>
		</div>
		
		<div class="span10">
			<p>
				<h5 class="well well-small">Aferição Antropométrica</h5>
			</p>
		</div>				
		<div class="span3">
			<label>Peso</label>			
			<html:text property="visita00.PER_V00_AA01" styleClass="span8" maxlength="6" styleId="peso" onkeypress="return formata_decimal(this, '', '.', event, 6);" onblur= "calcular_imc();"/> kg 	
		</div>
		
		<div class="span3">
			<label>Altura</label>			
			<html:text property="visita00.PER_V00_AA02" styleClass="span8" maxlength="4" styleId="altura" onkeyup="aplicarMascara(this,'9.99')" onblur= "calcular_imc();"/> m	
		</div>
	
		<div class="span4">
			<label>IMC</label>			
			<html:text property="visita00.PER_V00_AA03" styleClass="span2" styleId="textImc" readonly="true"/> Kg/m2 (&ge; 40 Kg/m2  =  critério exclusão)
		</div>
		<div class="span3">
			<label>Circunferência Cervical</label>
			<html:text property="visita00.PER_V00_AA04" styleClass="span8" maxlength="6" onkeyup="javascript:somente_numero(this);"/> cm
		</div>
		<div class="span3">
			<label>Circunferência Abdominal</label>
			<html:text property="visita00.PER_V00_AA05" styleClass="span8" maxlength="6" onkeyup="javascript:somente_numero(this);"/> cm
		</div>
		<div class="span4">
			<label>Circunferência Braquial</label>
			<html:text property="visita00.PER_V00_AA06" styleClass="span8" maxlength="6" onkeyup="javascript:somente_numero(this);"/> cm
		</div>
		
		<div class="span10">
			<div class="space20"></div>
			<table class="table table-bordered">
				<caption class="text-left well well-small"><strong>QUESTIONÁRIO DE DOENÇA PRÉ-EXISTENTE</strong></caption>
				<thead>
				<tr>
				<th></th>
				<th class="text-left">Sim</th>
				<th class="text-left">Não</th>
				<th class="text-left">Não se aplica</th>
				</tr>
				</thead>
				<tbody>						
				<tr>
				<td>Há quantos anos ronca? <html:text property="visita00.PER_V00_DP01" styleClass="span2" maxlength="4" onkeyup="javascript:somente_numero(this);"/> anos</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				</tr>
				
				<tr>
				<td>Teve aumento de PA durante a gravidez?</td>
				<td><html:radio property="visita00.PER_V00_DP02" value="1"/></td>
				<td><html:radio property="visita00.PER_V00_DP02" value="2"/></td>
				<td><html:radio property="visita00.PER_V00_DP02" value="3"/></td>
				</tr>
				
				<tr>
				<td>Dislipidemia</td>
				<td><html:radio property="visita00.PER_V00_DP03" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP03" value="N"/></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Diabetes Melittus</td>
				<td><html:radio property="visita00.PER_V00_DP04" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP04" value="N"/></td>
				<td></td>
				</tr>
								
				<tr>
				<td>Cigarros/dia <html:text property="visita00.PER_V00_DP07" styleClass="span2" maxlength="4" onkeyup="javascript:somente_numero(this);"/></td>
				<td></td>
				<td></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Tabagismo atual</td>
				<td><html:radio property="visita00.PER_V00_DP05" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP05" value="N"/></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Tempo de tabagismo <html:text property="visita00.PER_V00_DP06" styleClass="span2" maxlength="4" onkeyup="javascript:somente_numero(this);"/> anos</td>
				<td></td>
				<td></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Ex tabagista</td>
				<td><html:radio property="visita00.PER_V00_DP13" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP13" value="N"/></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Há quanto tempo parou <html:text property="visita00.PER_V00_DP14" styleClass="span2" maxlength="4" onkeyup="javascript:somente_numero(this);"/> meses</td>
				<td></td>
				<td></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Obstrução Nasal Constante</td>
				<td><html:radio property="visita00.PER_V00_DP08" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP08" value="N"/></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Diagnóstico de Rinite</td>
				<td><html:radio property="visita00.PER_V00_DP09" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP09" value="N"/></td>
				<td></td>
				</tr>
											
				<tr>
				<td>Ano em que foi feito o diagnóstico de HAS <html:text property="visita00.PER_V00_DP10" styleClass="span2" maxlength="4" onkeyup="javascript:somente_numero(this);"/></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				</tr>			
				
				<tr>
				<td>Depressão</td>
				<td><html:radio property="visita00.PER_V00_DP11" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP11" value="N"/></td>
				<td></td>
				</tr>
				
				<tr>
				<td>Refluxo</td>
				<td><html:radio property="visita00.PER_V00_DP12" value="S"/></td>
				<td><html:radio property="visita00.PER_V00_DP12" value="N"/></td>
				<td></td>
				</tr>				
				
				</tbody>						
			</table>					
			<div class="space20"></div>
		</div>			
			
		
		<c:if test="${flAcessoModal ne 'S'}">	
			
			<c:choose>
				<c:when test="${flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S'}">
					<html:hidden property="visita00.visita.assinaturaAprovador" value="${sessionScope.UsuarioSistema.username}"/>
					<html:hidden property="visita00.visita.stAprovacao" value="A"/>
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
					
						<c:when test="${visitasForm.visita00.visita.stAprovacao eq 'A'}">
							<div class="span10 hero-unit">   
			      				<span class="msg-info">Visita Aprovada por ${visitasForm.visita00.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita00.visita.dtAssinaturaAprovacao}" /></span>
		   					</div>
						</c:when>
						
						<c:when test="${visitasForm.visita00.visita.stAprovacao eq 'R'}">
							<div class="span10 hero-unit">
			      				<span class="msg-error">Visita Reprovada por ${visitasForm.visita00.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${visitasForm.visita00.visita.dtAssinaturaAprovacao}" /></span>
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
		
		<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1 && visitasForm.visita00.visita.stAprovacao eq 'A'}">
			<div class="span10 hero-unit">
				<html:link styleClass="btn" action="/secure/visitas?method=desfazerAprovacao&idParam=${visitasForm.visita00.visita.idVisita}" styleId="desfazAprovacao">Desfazer Aprovação</html:link>
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
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qpressaoarterial&idVisita=${visitasForm.visita00.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Pressão Arterial</html:link></li>
								<hr/>
								<li><img src="../shared/img/acessar2.png"/><html:link action="/secure/questionarios?method=qmedicamentouso&idVisita=${visitasForm.visita00.visita.idVisita}&nuVisita=${visitasForm.nuVisita}&flAcessoAprovador=${flAcessoAprovador}">Medicamentos em Uso</html:link></li>		
								<hr/>			
							</ul>
						</div>																		
					</div>	
				</div>
			</li>		
		</ul>
	</div>
</c:if>

<script type="text/javascript">
	function calcular_imc(){
		var peso = parseFloat(document.getElementById('peso').value);
		var altura = parseFloat(document.getElementById('altura').value);
		var imc = peso/(altura*altura);
		if(isNaN(imc)){			
			return false;
		}
		imc = Math.round(imc*100)/100;
		document.getElementById('textImc').value = imc;
		return imc;
	} 	
</script>

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
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || visitasForm.visita00.visita.stAprovacao eq 'A' || visitasForm.visita00.visita.stAprovacao eq 'R' || visitasForm.paciente.ativo eq 'N'}">
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