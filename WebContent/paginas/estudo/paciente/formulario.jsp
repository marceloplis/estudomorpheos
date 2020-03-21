<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<h4>Cadastro de Paciente</h4>				
	<hr></hr> 

	<html:form action="/secure/gravapaciente?method=gravar" styleId="formP">
		<html:hidden property="paciente.idPaciente"/>
		<c:choose>				
			<c:when test="${pacienteForm.paciente.unidade.idUnidadePesquisa > 0}">
				<html:hidden property="paciente.unidade.idUnidadePesquisa"/>
			</c:when>
			<c:otherwise>
				<html:hidden property="paciente.unidade.idUnidadePesquisa" value="${UsuarioSistema.unidade.idUnidadePesquisa}"/>
			</c:otherwise>				
		</c:choose>		
		<html:hidden property="idParam" value="${pacienteForm.idParam}"/>
		<html:hidden property="idPaciente" value="${pacienteForm.paciente.idPaciente}"/>
		
		<div class="span5">
			<label>ID:</label>
			<c:choose>				
				<c:when test="${pacienteForm.paciente.idPaciente > 0}">					
					<html:text property="paciente.idPaciente" readonly="true" disabled="true" styleClass="span6"/>			
				</c:when>
				<c:otherwise>
					<input type="text" readonly="true" disabled="true" value="Novo Paciente"/>	
				</c:otherwise>				
			</c:choose>
		</div>
		
		<div class="span12">
			<label>Unidade</label>
			<c:choose>				
				<c:when test="${pacienteForm.paciente.unidade.idUnidadePesquisa > 0}">
					<input type="text" value="${pacienteForm.paciente.unidade.dsUnidade}" readonly="true" disabled="true" class="span10"/>
				</c:when>
				<c:otherwise>
					<input type="text" value="${UsuarioSistema.unidade.dsUnidade}" readonly="true" disabled="true" class="span10"/>
				</c:otherwise>				
			</c:choose>			
		</div>
		
		<div class="span5">
			<label>CPF:</label>
		    <html:text property="paciente.cpf" onkeyup="aplicarMascara(this,'999.999.999-99')" onblur="ValidaCpf(this)" maxlength="14" styleClass="span6"/>
		</div>
		
		<div class="span12">
			<label>Nome do paciente</label>
			<html:text property="paciente.nome" maxlength="100" styleClass="span10"/>
		</div>
		  
		<div class="span5">
			<label>Iniciais</label>
			<html:text property="paciente.iniciaisNome" maxlength="3" styleClass="span6"/>
		</div>
		
		<div class="span6">
			<label>Centro/ No de Registro no Protocolo</label>
			<html:text property="paciente.numRegistro" maxlength="45" styleClass="span10"/>
		</div>
		
		<div class="span6">
			<label>Endereço</label>
			<html:text property="paciente.endereco" maxlength="100" styleClass="span12"/>
		</div>
		
		<div class="span2">
			<label>No</label>
			<html:text property="paciente.numEndereco" onkeyup="javascript:somente_numero(this);" styleClass="span12"/>	
		</div>
		
		<div class="span2">
			<label>Complemento</label>
			<html:text property="paciente.complemento" maxlength="45" styleClass="span12"/>	
		</div>
		
		<div class="span4">
			<label>Bairro</label>
			<html:text property="paciente.bairro" maxlength="45" styleClass="span12"/>	
		</div>
		<div class="span2">
			<label>Cidade</label>
			<html:text property="paciente.cidade" maxlength="100" styleClass="span12"/>
		</div>
		<div class="span2">
			<label>Estado</label>
			<html:select property="paciente.uf" styleClass="span12"> 
	          	<html:option value="">Selecione</html:option>
			    <html:option value="AC">AC</html:option>  
			    <html:option value="AL">AL</html:option>  
			    <html:option value="AM">AM</html:option>  
			    <html:option value="AP">AP</html:option>  
			    <html:option value="BA">BA</html:option>  
			    <html:option value="CE">CE</html:option>  
			    <html:option value="DF">DF</html:option>  
			    <html:option value="ES">ES</html:option>  
			    <html:option value="GO">GO</html:option>  
			    <html:option value="MA">MA</html:option>  
			    <html:option value="MG">MG</html:option>  
			    <html:option value="MS">MS</html:option>  
			    <html:option value="MT">MT</html:option>  
			    <html:option value="PA">PA</html:option>  
			    <html:option value="PB">PB</html:option>  
			    <html:option value="PE">PE</html:option>  
			    <html:option value="PI">PI</html:option>  
			    <html:option value="PR">PR</html:option>  
			    <html:option value="RJ">RJ</html:option>  
			    <html:option value="RN">RN</html:option>  
			    <html:option value="RO">RO</html:option>  
			    <html:option value="RR">RR</html:option>  
			    <html:option value="RS">RS</html:option>  
			    <html:option value="SC">SC</html:option>  
			    <html:option value="SE">SE</html:option>  
			    <html:option value="SP">SP</html:option>  
			    <html:option value="TO">TO</html:option>  
		    </html:select> 		
		</div>
		<div class="span2">
			<label>CEP</label>
			<html:text property="paciente.cep" onkeyup="aplicarMascara(this,'99999-999')" onblur="ValidaCep(this)" maxlength="9" styleClass="span12"/>	
		</div>
		<div class="span4">
			<label>Tel. Residencial</label>
			<html:text property="paciente.numFoneRes" onkeyup="aplicarMascara(this,'(99)9999-9999')" maxlength="13"  onblur="ValidaTelefone(this);" styleClass="span12"/>	
		</div>
		<div class="span3">
			<label>Celular</label>
			<html:text property="paciente.numCelular" onkeyup="aplicarMascara(this,'(99)?9999-9999')" maxlength="14"  onblur="ValidaTelefone(this);" styleClass="span12"/>		
		</div>
		<div class="span3">
			<label>Tel. Comercial</label>
			<html:text property="paciente.numFoneTrab" onkeyup="aplicarMascara(this,'(99)9999-9999')" maxlength="13"  onblur="ValidaTelefone(this);" styleClass="span12"/>		
		</div>
		<div class="span3">
			<label>Tel. Recado</label>
			<html:text property="paciente.numFoneRecado" onkeyup="aplicarMascara(this,'(99)?9999-9999')" maxlength="14"  onblur="ValidaTelefone(this);" styleClass="span12"/>	
		</div>
		<div class="span7">
			<label>Falar com</label>
			<html:text property="paciente.nmContato" maxlength="100" styleClass="span12"/>	
		</div>
		
		<div class="span6">
			<label>Profissão</label>
			<html:text property="paciente.profissao" size="59" maxlength="45" styleClass="span12"/>	
		</div>
		<div class="span2">
			<label>Data de nascimento</label>
			<html:text property="dtNascimentoParse" styleId="dtNascimento" size="16" onkeypress="formatarGenerico(this, '##/##/####');" maxlength="10" onblur= "calcular_idade(this.value);" styleClass="span12"/>
		</div>
		<div class="span2">
			<label>Idade</label>
			<input type="text" id="spanIdade" class="span12" readonly="true" disabled="true">	
		</div>
		<div class="span10">
			<div class="space15"></div>
			<label>Escolaridade</label>	
			<hr class="mini"></hr>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="1"/>				
				Analfabeto
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="2"/>	
				Ler e escrever
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="3"/>	
				1 grau  completo
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="4"/>	
				1 grau incompleto
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="5"/>	
				2 grau  completo
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="6"/>	
				2 grau incompleto
			</label>
		</div>					
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.escolaridade" value="7"/>	
				Superior ou mais
			</label>
		</div>
		
		
		
		<div class="span10">
			<div class="space15"></div>
			<label>Raça</label>
			<hr class="mini"></hr>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.raca" value="1"/>					
				Branco
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.raca" value="2"/>
				Negro
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.raca" value="3"/>
				Mulato
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.raca" value="4"/>
				Oriental
			</label>
		</div>
		<div class="span10">
			<div class="space15"></div>
			<label>Sexo</label>
			<hr class="mini"></hr>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.sexo" value="1"/>
				Masculino
			</label>
		</div>	
		<div class="span2">
			<label class="radio">
				<html:radio property="paciente.sexo" value="2"/>
				Feminino
			</label>
		</div>
		
		
		<div align="center">
			<c:choose>
				<c:when test="${pacienteForm.paciente.ativo eq 'N'}">
					<div class="span12 hero-unit">
	      				<span class="msg-error">Paciente excluído do estudo.</span>
	      				<br/>
	      				<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1}">							
							<html:link styleClass="btn" action="/secure/paciente?method=desfazerExclusao&idParam=${pacienteForm.paciente.idPaciente}" styleId="desfazExclusao">Desfazer Exclusão do Estudo</html:link>
							<script>
								$('#desfazExclusao').on('click', function (e, confirmed) {
								    if (!confirmed) {
								        e.preventDefault();
								        var location = $(this).attr('href');
								        bootbox.confirm("Esta ação irá desfazer a saída do estudo do paciente! Confirma?", function (response) {			
								            if(response) {
								            	window.location.replace(location);
								            }
								        });
								    }
								});
							</script>							
						</c:if>
   					</div>   					
				</c:when>
				
				<c:otherwise>
					<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 2 || UsuarioSistema.perfil.idPerfilAcesso eq 1}">
						<div class="span12">			
							<html:submit styleClass="btn btn-primary">Gravar</html:submit> 						
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
		
	</html:form>
	
</div>

<script type="text/javascript">
	function calcular_idade(data){
		var dataNasc = data;
		if(dataNasc){
			var dataAtual = new Date();
			var anoAtual = dataAtual.getFullYear();
			var anoNascParts = dataNasc.split('/');
			var diaNasc =anoNascParts[0];
			var mesNasc =anoNascParts[1];
			var anoNasc =anoNascParts[2];
			var idade = anoAtual - anoNasc;
			var mesAtual = dataAtual.getMonth() + 1;
			//se mês atual for menor que o nascimento, nao fez aniversario ainda; (26/10/2009)
			if(mesAtual < mesNasc){
				idade--;
			}else {
				//se estiver no mes do nasc, verificar o dia
				if(mesAtual == mesNasc){
					if(dataAtual.getDate() < diaNasc ){
					//se a data atual for menor que o dia de nascimento ele ainda nao fez aniversario
					idade--;
					}
				}
			}			
			document.getElementById('spanIdade').value  = idade;			
			return idade; 
		}
		else{
			return false;
		}	
	} 	
</script>

<script>		
	$(document).ready(function() {
		$('.datepicker').datepicker();

		calcular_idade(document.getElementById("dtNascimento").value);
		
	});													
	$(function(){
		$('#dtNascimento').datepicker({
		  format: 'dd/mm/yyyy'
		});		
	});
	
</script>

<c:choose>
	<c:when test="${pacienteForm.paciente.ativo eq 'N' || UsuarioSistema.perfil.idPerfilAcesso > 2}">
		<script>		
			$(document).ready(function() {
				$('#formP input[type=text]').attr("disabled",true);					
		
				$('#formP input[type=radio]').attr("disabled",true);

				$('#formP input[type="text"], textarea').attr("disabled",true);	

				$('#formP input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formP input[type=text]').attr("disabled",false);		
		
				$('#formP input[type=radio]').attr("disabled",false);

				$('#formP input[type="text"], textarea').attr("disabled",false);	

				$('#formP input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>