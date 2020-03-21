<%@include file="/templates/tags.jsp" %>

<h4>Pacientes</h4>
<hr></hr>

<display:table id="paciente" name="${relatoriosForm.listPacientes}" requestURI="/secure/relatorios.do?method=filtrar"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="100" export="true">
	
	<display:column   					    title="Unidade"	sortable="true" 			headerClass="sortable" style="width: 30%;">
		<c:if test="${fn:length(paciente.unidade.dsUnidade) > 0}">				
			<c:if test="${fn:length(paciente.unidade.siglaUnidade) > 0}">${paciente.unidade.siglaUnidade} - </c:if>
			${paciente.unidade.dsUnidade}
		</c:if>
	</display:column>
	<display:column property="iniciaisNome" title="Iniciais"		sortable="true" 	headerClass="sortable" style="width: 08%;"/>
	<display:column  						title="CPF"				sortable="true" 	headerClass="sortable" style="width: 10%;">
		<util:formataCPFCNPJ valor="${paciente.cpf}"/>
	</display:column>
	<display:column property="numRegistro" 	title="Nº Registro"		sortable="true" 	headerClass="sortable" style="width: 08%;"/>	
	
	<display:column                     	title="Data Nascimento"	sortable="false"	headerClass="sortable" style="width: 08%;">
		<fmt:formatDate value="${paciente.dtNascimento}" type="both"  pattern="dd/MM/yyyy" />
	</display:column>
	<display:column 					    title="Sexo"			sortable="false"	headerClass="sortable" style="width: 10%;" >
		${paciente.sexo == 1 ? "Masculino" : paciente.sexo == 2 ? "Feminino" : ""}
	</display:column>
	<display:column 					    title="Raça"			sortable="false"	headerClass="sortable" style="width: 10%;" >
		${paciente.raca == 1 ? "Branco" : paciente.raca == 2 ? "Negro" : paciente.raca == 3 ? "Mulato" : "Oriental"}
	</display:column>
	<display:column 					    title="Status"			sortable="false"	headerClass="sortable" style="width: 10%;" >
		${paciente.ativo eq 'N'? "Excluído do Estudo" : "Ativo no Estudo"}
	</display:column>	
	
	<display:column title="Visitas" style="text-align:center;width: 05%;" media="html">
		<html:link action="/secure/relatorios?method=filtrar&pacienteId=${paciente.idPaciente}&tpRelatorio=2"><img src="../shared/img/lupa.png"/></html:link>
	</display:column>
	
	<display:setProperty name="export.excel.filename" value="pacientes.xls"/>
    <display:setProperty name="export.excel" value="true" />
	
</display:table>
