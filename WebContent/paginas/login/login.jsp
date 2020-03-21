<%@include file="/templates/tags.jsp" %>

<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #fff;
    }

    .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #f8f7f7;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
    }
   
    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;		
    }
	
	.logo {
		width: 200px;
		height: 34px;
		display: block; 
		margin-left: auto; 
		margin-right: auto;		
		background: url("shared/img/logo.jpg") no-repeat;
	}
</style>	

<div class="container">		

	<html:form action="login" styleClass="form-signin">			
		<div class="logo"></div>
		<h2 class="form-signin-heading">Login</h2>
		<jsp:include page="/templates/message-error.jsp"/>
		<html:hidden property="method" value="autenticacao"/>
		<label>Username</label><html:text property="username" maxlength="30" size="30"  styleClass="input-large"/>
		<label>Senha</label>   <html:password property="senha" maxlength="30" size="30" styleClass="input-large"/>
		<br/>
		<html:submit styleClass="btn btn-primary">Entrar</html:submit>		
	</html:form>

</div>

