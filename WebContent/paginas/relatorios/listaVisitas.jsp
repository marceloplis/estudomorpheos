<%@include file="/templates/tags.jsp" %>

<h4>Visitas</h4>
<hr></hr>

<display:table id="visita" name="${relatoriosForm.listVisitas}" requestURI="/secure/relatorios.do?method=filtrar"
               class="table table-bordered"
	           sort="list" defaultsort="1"
	           pagesize="100" export="true">
	
	<display:column   					    title="Unidade"	sortable="true" 			headerClass="sortable" style="width: 15%;">
		<c:if test="${fn:length(visita.paciente.unidade.dsUnidade) > 0}">				
			<c:if test="${fn:length(visita.paciente.unidade.siglaUnidade) > 0}">${visita.paciente.unidade.siglaUnidade} - </c:if>
			${visita.paciente.unidade.dsUnidade}
		</c:if>
	</display:column>
	<display:column property="paciente.iniciaisNome" title="Iniciais"		sortable="true" 	headerClass="sortable" style="width: 05%;"/>
	<display:column  						title="CPF"				sortable="true" 	headerClass="sortable" style="width: 07%;">
		<util:formataCPFCNPJ valor="${visita.paciente.cpf}"/>
	</display:column>
	<display:column property="nuVisita" 	title="Nº Visita"		sortable="true" 	headerClass="sortable" style="width: 05%;"/>	
	
	<display:column                     	title="Data Visita"	sortable="false"	headerClass="sortable" style="width: 08%;">
		${visita.dtRealizacaoParse}
	</display:column>
	<display:column 					    title="Aplicação"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questaplic > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Ativ.Física"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questaticfis > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Berlim"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questberl > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Bioquímica"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questbioq > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Cage"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questcage > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Eco"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questeco > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Mapa"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questmapa > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Medicamento"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questmedic > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Poligrafia"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questpolig > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Polissonografia"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questpoliss > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Pressão"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questpressao > 0 ? "Sim" : "Não"}
	</display:column>
	<display:column 					    title="Sphygmocor"			sortable="false"	headerClass="sortable" style="width: 05%;" >
		${visita.has_questsphy > 0 ? "Sim" : "Não"}
	</display:column>
	
	
	<display:setProperty name="export.excel.filename" value="visitas.xls"/>
    <display:setProperty name="export.excel" value="true" />
	
</display:table>