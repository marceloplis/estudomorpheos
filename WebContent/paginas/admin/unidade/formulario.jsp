<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<h4>Cadastro de Unidade de Atendimento</h4>
	<hr></hr> 
	
	<html:form action="/secure/admin/gravaunidade?method=gravar">
		<html:hidden property="unidade.idUnidadePesquisa"/>
		<label>ID Unidade:		</label><html:text property="unidade.nuUnidade"		maxlength="20" 	styleClass="input-medium"/>
		<label>Descrição:		</label><html:text property="unidade.dsUnidade" 	maxlength="100" styleClass="input-xxlarge"/>
		<label>Sigla:	</label><html:text property="unidade.siglaUnidade" 			maxlength="20" 	styleClass="input-medium"/>
		<label>Investigador(a):	</label><html:text property="unidade.investigador"	maxlength="100"	styleClass="input-xxlarge"/>
		<label>Coordenador(a):	</label><html:text property="unidade.coordenador" 	maxlength="100"	styleClass="input-xxlarge"/>
		<label>E-mail:			</label><html:text property="unidade.email" 		maxlength="200"	styleClass="input-xxlarge"/>
		<label>Telefone:</label><html:text property="unidade.telUnidade" 			maxlength="12" 	onkeydown="formatarGenerico(this, '## ####-####');" onblur="ValidaTelefone(this);"/>
		<label>Endereço:</label><html:text property="unidade.endereco" 				maxlength="100" styleClass="input-xxlarge"/>
		<label>Cidade:	</label><html:text property="unidade.cidade" 				maxlength="60" 	styleClass="input-xlarge"/>
		<label>Estado:	</label>
		<html:select property="unidade.uf" styleClass="input-medium">
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
		<label>CEP:</label><html:text property="unidade.cep" onkeypress="formatarGenerico(this, '#####-###');" onblur="ValidaCep(this)" maxlength="10"/>
		<br/>
		<html:submit styleClass="btn btn-primary">Gravar</html:submit>
	</html:form>		 

</div>