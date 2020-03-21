<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>


<div class="formulario">	

	<h4>Filtro para Relatório</h4>
	<hr></hr> 
	
	<html:form action="/secure/relatorios?method=filtrar" styleId="form">	

		<label><b>Unidade:</b></label>	
		<hr class="mini"></hr>		
		<html:select name="relatoriosForm" property="unidadeId">
        	<html:option value="0">TODAS</html:option>
            <html:optionsCollection name="relatoriosForm" property="listUnidades" label="dsUnidade" value="idUnidadePesquisa" />
        </html:select>       

		<label><b>Tipo Relatório:</b></label>
		<hr class="mini"></hr>


		<label class="radio">
			<html:radio property="tpRelatorio" value="1"/>
			Paciente
		</label>

		<label class="radio">
			<html:radio property="tpRelatorio" value="2"/>
			Visita
		</label>

		<html:submit styleClass="btn btn-primary">Filtrar</html:submit>
	
	</html:form>
	
</div>