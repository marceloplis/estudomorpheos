<%@include file="/templates/tags.jsp" %>

<div class="span10" style="width: 99%">
	<div class="hero-unit">
    	<h1>Estudo Morpheos</h1>
        <p style="text-align: justify;">
        	O estudo MORPHEOS � um estudo nacional, multic�ntrico, randomizado, n�o cego cujo objetivo principal � avaliar o impacto do tratamento da apneia obstrutiva do sono (AOS) moderada a grave com CPAP (gerador de press�o positiva cont�nua em vias a�reas) no controle da press�o arterial em pacientes com HAS n�o controlada.
			<br/><br/>
			Al�m disso, como objetivos secund�rios, o estudo pretende avaliar o impacto do tratamento da AOS moderada a grave com CPAP sobre par�metros ecocardiogr�ficos (incluindo a hipertrofia ventricular esquerda) nesses pacientes e validar m�todos de baixo custo para rastreamento e diagn�stico de AOS nessa popula��o incluindo um question�rio padr�o e poligrafia port�til que ser�o testados contra a polissonografia completa, padr�o ouro para o diagn�stico de AOS.
        </p>
	</div>
    <div class="row-fluid">
    	<div class="span6">
        	<h2>CR Assessoria em Pesquisa Clinica</h2>
            <p style="text-align: justify;">
            	A CR Assessoria em Pesquisa Clinica foi idealizada para fornecer solu��es na condu��o de estudos cl�nicos e atuar na forma��o de equipes, sempre prezando pela qualidade e agilidade dos servi�os prestados. Atuamos principalmente em:

				Condu��o, reestrutura��o e coordena��o de centros de pesquisa;
				
				Tradu��o de documentos relacionados � pesquisa cl�nica.
				
				Reestrutura��o de sites de pesquisa cl�nica (SMO - Site Management Organization).
				
				Os profissionais que trabalham na reestrutura��o e coordena��o s�o treinados e capacitados conforme �s Boas Pr�ticas Cl�nicas (GCP - Good Clinical Pratice), Confer�ncia Internacional de Harmoniza��o (ICH - International Conference on Harmonisation) e regulamenta��es nacionais.				
			</p>
            <p><a class="btn" href="http://www.crpesquisaclinica.com.br" target="blank">Mais &raquo;</a></p>
        </div><!--/span-->
        <div class="span6">
        	<h2>Centros Universit�rios</h2>
            <p style="text-align: justify;">
            	Os pacientes ser�o avaliados em ${fn:length(LoginForm.unidades)} centro(s) universit�rio(s) especializado(s) no diagn�stico e acompanhamento de pacientes com HAS.
				<br/>
				<b>Centros participantes:<b>
				
				<table class="table table-bordered">
					<thead>
						<tr>
							<td>&nbsp;</td>
							<td>Unidade</td>
							<td>Investigador(a)</td>
							<td>Coordenadores</td>
							<td>E-mail</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="un" items="${LoginForm.unidades}">
							<tr>
								<td>${un.nuUnidade}</td>
								<td>
									${un.dsUnidade} <c:if test="${fn:length(usuario.unidade.siglaUnidade) > 0}"> - ${usuario.unidade.siglaUnidade} </c:if>
								</td>
								<td>${un.investigador}</td>
								<td>
									${un.coordenador}
								</td>
								<td><a href="mailto:${un.email}">${un.email}</a></td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
         
            </p>
            <!--<p><a class="btn" href="http://www.hc.fm.usp.br/index.php?option=com_content&view=article&id=72&Itemid=228">Mais &raquo;</a></p>-->
        </div><!--/span-->            
	</div><!--/row-->          
</div><!--/span-->