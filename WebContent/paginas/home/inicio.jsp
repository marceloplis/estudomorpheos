<%@include file="/templates/tags.jsp" %>

<div class="span10" style="width: 99%">
	<div class="hero-unit">
    	<h1>Estudo Morpheos</h1>
        <p style="text-align: justify;">
        	O estudo MORPHEOS é um estudo nacional, multicêntrico, randomizado, não cego cujo objetivo principal é avaliar o impacto do tratamento da apneia obstrutiva do sono (AOS) moderada a grave com CPAP (gerador de pressão positiva contínua em vias aéreas) no controle da pressão arterial em pacientes com HAS não controlada.
			<br/><br/>
			Além disso, como objetivos secundários, o estudo pretende avaliar o impacto do tratamento da AOS moderada a grave com CPAP sobre parâmetros ecocardiográficos (incluindo a hipertrofia ventricular esquerda) nesses pacientes e validar métodos de baixo custo para rastreamento e diagnóstico de AOS nessa população incluindo um questionário padrão e poligrafia portátil que serão testados contra a polissonografia completa, padrão ouro para o diagnóstico de AOS.
        </p>
	</div>
    <div class="row-fluid">
    	<div class="span6">
        	<h2>CR Assessoria em Pesquisa Clinica</h2>
            <p style="text-align: justify;">
            	A CR Assessoria em Pesquisa Clinica foi idealizada para fornecer soluções na condução de estudos clínicos e atuar na formação de equipes, sempre prezando pela qualidade e agilidade dos serviços prestados. Atuamos principalmente em:

				Condução, reestruturação e coordenação de centros de pesquisa;
				
				Tradução de documentos relacionados à pesquisa clínica.
				
				Reestruturação de sites de pesquisa clínica (SMO - Site Management Organization).
				
				Os profissionais que trabalham na reestruturação e coordenação são treinados e capacitados conforme às Boas Práticas Clínicas (GCP - Good Clinical Pratice), Conferência Internacional de Harmonização (ICH - International Conference on Harmonisation) e regulamentações nacionais.				
			</p>
            <p><a class="btn" href="http://www.crpesquisaclinica.com.br" target="blank">Mais &raquo;</a></p>
        </div><!--/span-->
        <div class="span6">
        	<h2>Centros Universitários</h2>
            <p style="text-align: justify;">
            	Os pacientes serão avaliados em ${fn:length(LoginForm.unidades)} centro(s) universitário(s) especializado(s) no diagnóstico e acompanhamento de pacientes com HAS.
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