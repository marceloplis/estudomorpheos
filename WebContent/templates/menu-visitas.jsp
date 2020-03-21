<%@include file="/templates/tags.jsp" %>

<div class="span2" style="margin-top: 30px;">	
	<div class="well sidebar-nav">
    	<ul class="nav nav-list">
	    	<li class="nav-header"><div><img src="../shared/img/paciente.png"/><html:link action="/secure/paciente?method=formulario&idParam=${pacienteForm.idParam}">Dados do Paciente</html:link></div></li>
	    </ul>
	    <c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 2 || UsuarioSistema.perfil.idPerfilAcesso eq 1}">
			<hr/>
	    	<ul class="nav nav-list"> 
	    	
	    		<c:forEach var="entry" items="${STATUSVISITAS}" varStatus="status">
	    			<c:if test="${entry.key eq 0}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita00&idPaciente=${pacienteForm.idParam}&nuVisita=0">Visita 00</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 1}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita01&idPaciente=${pacienteForm.idParam}&nuVisita=1">Visita 01</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 2}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita02&idPaciente=${pacienteForm.idParam}&nuVisita=2">Visita 02</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 3}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita03&idPaciente=${pacienteForm.idParam}&nuVisita=3">Visita 03</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 4}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita04&idPaciente=${pacienteForm.idParam}&nuVisita=4">Visita 04</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 5}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita05&idPaciente=${pacienteForm.idParam}&nuVisita=5">Visita 05</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 6}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita06&idPaciente=${pacienteForm.idParam}&nuVisita=6">Visita 06</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 7}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita07&idPaciente=${pacienteForm.idParam}&nuVisita=7">Visita 07</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 8}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita08&idPaciente=${pacienteForm.idParam}&nuVisita=8">Visita 08</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 9}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita09&idPaciente=${pacienteForm.idParam}&nuVisita=9">Visita 09</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 10}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita10&idPaciente=${pacienteForm.idParam}&nuVisita=10">Visita 10</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 11}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita11&idPaciente=${pacienteForm.idParam}&nuVisita=11">Visita 11</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 12}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita12&idPaciente=${pacienteForm.idParam}&nuVisita=12">Visita 12</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 13}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita13&idPaciente=${pacienteForm.idParam}&nuVisita=13">Visita 13</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 14}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita14&idPaciente=${pacienteForm.idParam}&nuVisita=14">Visita 14</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 15}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita15&idPaciente=${pacienteForm.idParam}&nuVisita=15">Visita 15</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 16}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita16&idPaciente=${pacienteForm.idParam}&nuVisita=16">Visita 16</html:link>
							</div>
						</li>
					</c:if>
					<c:if test="${entry.key eq 17}">
						<li>
							<div>
								<c:choose>
									<c:when test="${entry.value eq 'P'}">
										<img src="../shared/img/pendente.png" title="Pendente de Aprovação"/>
									</c:when>
									<c:when test="${entry.value eq 'R'}">
										<img src="../shared/img/uncheck.png" title="Reprovada"/>
									</c:when>
									<c:when test="${entry.value eq 'A'}">
										<img src="../shared/img/check.png" title="Aprovado"/>
									</c:when>
									<c:otherwise>
										<img src="../shared/img/empty.png" title="Não Preenchida"/>
									</c:otherwise>
								</c:choose>							
								&nbsp;&nbsp;<html:link action="/secure/visitas?method=visita17&idPaciente=${pacienteForm.idParam}&nuVisita=17">Visita 17</html:link>
							</div>
						</li>
					</c:if>				
				
				</c:forEach>
						
		    </ul>
		    <hr/>
		    <ul class="nav nav-list">
		    	<li class="nav-header"><div><img src="../shared/img/eventoAdverso.png"/><html:link action="/secure/evento?method=lista&idPaciente=${pacienteForm.idParam}">Eventos Adversos</html:link></div></li>
		    </ul>
		    <br/>
		    <ul class="nav nav-list">
		    	<li class="nav-header"><div><img src="../shared/img/excluirPaciente.png"/><html:link action="/secure/saida?method=formulario&idPaciente=${pacienteForm.idParam}">&nbsp;Excluir do Estudo</html:link></div></li>
		    </ul>
		</c:if>
	</div><!--/.well -->
	
</div><!--/span-->
