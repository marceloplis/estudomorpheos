<%@page import="br.com.morpheos.entity.UsuarioEntity"%>
<%@include file="/templates/tags.jsp" %>

<%	
	UsuarioEntity usuario =  (UsuarioEntity)request.getSession().getAttribute("UsuarioSistema");	
%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
    	<div class="container-fluid">
        	<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
          	</button>
          	<a class="brand" href="#">&nbsp;</a>
          	<div class="nav-collapse collapse">
	            <p class="navbar-text pull-right">
	              	<b>Logado como:</b> <%=usuario.getNome() %> | <b>Perfil:</b> <%=usuario.getPerfil().getDsPerfil() %> | <html:link action="formlogin?method=logout" styleClass="navbar-link" title="LOGOUT"><b>SAIR</b></html:link>
	            </p>
	            <ul class="nav">
	            	<li>
	            		<html:link action="/secure/home.do?method=home">Home</html:link>
	            	</li>					

					<li>
	              		<html:link action="/secure/paciente.do?method=consulta">Pacientes</html:link>
	              	</li> 	              				  	
				  	
				  	<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 4}">
				  	
					  	<li>
		            		<html:link action="/secure/aprovacao.do?method=filtro">Aprovação</html:link>
		            	</li>
		            	
		            </c:if>
	              	
	              	<li>
	            		<html:link action="/secure/estatisticas.do?method=graficos">Estatísticas</html:link>
	            	</li>
	            	
	            	<li class="dropdown">
	                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios<b class="caret"></b></a>
	                	<ul class="dropdown-menu">
	                	
		                	<li>
			            		<html:link action="/secure/relatorios.do?method=filtro">Filtro Relat&oacute;rios</html:link>
			            	</li>
            	
            				<li>
								<html:link action="/secure/relatoriosExcel.do?method=filtro">Filtro Relat&oacute;rios Excel</html:link>
							</li>
						</ul>
					</li>
	            	
	            	<c:if test="${UsuarioSistema.perfil.idPerfilAcesso <= 2}">
	            	
	            		<li class="dropdown">
		                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Parâmetros do Sistema<b class="caret"></b></a>
		                	<ul class="dropdown-menu">
	            	
	            				<li>
									<html:link action="/secure/admin/doenca.do?method=lista">Doenças</html:link>
								</li>
								
								<li class="dropdown-submenu">
									<a tabindex="-1" href="#">Medicamento</a>
								    <ul class="dropdown-menu">
								    	<li>
		                 					<html:link action="/secure/admin/grpmedicamento.do?method=lista">Grupos</html:link>
		                 				</li>
		                 				
		                 				<li>
		                 					<html:link action="/secure/admin/medicamento.do?method=lista">Medicamentos</html:link>
		                 				</li>
								    </ul>
								</li> 
								
							</ul>
						</li>
	            	
	            	</c:if>
				  	
				  	<c:if test="${UsuarioSistema.perfil.idPerfilAcesso eq 1}">
				  	
				  		<li>
		            		<html:link action="/secure/auditoria.do?method=filtro">Auditoria</html:link>
		            	</li>
				  	
					  	<li class="dropdown">
		                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Administrador<b class="caret"></b></a>
		                	<ul class="dropdown-menu">
		                 		
		                 		<li class="dropdown-submenu">
									<a tabindex="-1" href="#">Usuários do Sistema</a>
								    <ul class="dropdown-menu">
								    	<li>
		                 					<html:link action="/secure/admin/usuario.do?method=formconsulta">Consultar</html:link>
		                 				</li>
		                 				
		                 				<li>
		                 					<html:link action="/secure/admin/usuario.do?method=formulario">Cadastrar</html:link>
		                 				</li>
								    </ul>
								</li>	
								               		
		                  		<li>
		                  			<html:link action="/secure/admin/unidade.do?method=lista">Unidades de Pesquisa</html:link>
		                  		</li> 	               						 
								
		                	</ul>
		             	</li>
		              	
		        	</c:if>
		              
		            <li>
				  		<html:link action="/secure/trocarsenha.do?method=trocarsenha">Trocar Senha</html:link>
				  	</li>
		              
	            </ul>
        	</div><!--/.nav-collapse -->
    	</div>
	</div>
</div>

<script>
$(function(){
	function stripTrailingSlash(str) {
		if(str.substr(-1) == '/') {
	      	return str.substr(0, str.length - 1);
	    }
	    return str;
	}

  	var url = window.location.pathname;  
	var activePage = stripTrailingSlash(url);

	$('.nav li a').each(function(){  
		var currentPage = stripTrailingSlash($(this).attr('href'));	    
		
	    if (currentPage.indexOf(activePage) == 0) {
			if(activePage.indexOf('/admin/') > 0 ){
				$(this).parent().parent().parent().addClass('active');
				$(this).parent().parent().parent().parent().parent().addClass('active');
			}else{
	      		$(this).parent().addClass('active'); 
			}
	    }
	});
});
</script>