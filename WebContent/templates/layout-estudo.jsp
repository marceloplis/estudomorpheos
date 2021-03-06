<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@include file="/templates/tags.jsp" %>

<html xmlns='http://www.w3.org/1999/xhtml'>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/bootstrap.css"/>		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/datepicker.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/menu_footpanel.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/geral.css"/>		
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/shared/css/bootstrap-responsive.css"/>					
		<style type="text/css">
	    	body {
	        	padding-top: 60px;
	        	padding-bottom: 40px;
	      	}
	      	.sidebar-nav {
	       	 	padding: 9px 0;
	      	}
	
	      	@media (max-width: 980px) {
	       	 	/* Enable use of floated navbar text */
	        	.navbar-text.pull-right {
	          		float: none;
	          		padding-left: 5px;
	          		padding-right: 5px;
	        	}
	      	}
	    </style>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/util.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/jquery.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/bootstrap-dropdown.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/fixed_bar.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/bootstrap-modal.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/shared/js/bootbox.js"></script>
		
		<title><bean:message key="page.title"/></title>
	</head>
	<body>
		
		<tiles:insert attribute="header" ignore="true" />
		
		<c:set var="flAcessoAprovador" value="${param.flAcessoAprovador}" scope="session"/>
		<c:set var="flAcessoModal"     value="${param.flAcessoModal}"     scope="request"/>
		
		<div class="container-fluid">
			<div class="row-fluid">	
				<c:if test="${pacienteForm.paciente.idPaciente > 0 && flAcessoAprovador ne 'S'}">
					<tiles:insert attribute="menu-visitas" />	
				</c:if>		
				
				<div class="span10">		
					<tiles:insert attribute="body" />
				</div>
			</div>			
			
		</div><!--/.fluid-container-->	
		
		<tiles:insert attribute="footer" />
		
	</body>
</html>
