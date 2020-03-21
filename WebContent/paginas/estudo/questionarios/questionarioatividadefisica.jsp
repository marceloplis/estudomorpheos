<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqatividadefisica" styleId="formQ">
		<html:hidden property="qatividadefisica.idQuestionarioInternacional"/>
		<html:hidden property="qatividadefisica.visita.idVisita"/>

		<div class="span10">
			<h5 class="well well-small">QUESTIONÁRIO INTERNACIONAL DE ATIVIDADE FÍSICA</h5>
		</div>
		
							
		<div class="span10">
			<label>Você trabalha de forma remunerada?</label>						
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI01" value="S"/>
				Sim
			</label>
		</div>
		
		<div class="span8">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI01" value="N"/>
				Não
			</label>
		</div>
		  
		<div class="span10">
			<label>Quantas horas você trabalha por dia?</label>
			<html:text property="qatividadefisica.PER_QI02" styleClass="span1" maxlength="5" onkeydown="formatarGenerico(this, '##:##');"/> horas
		</div>
	
		<div class="span10">
			<label>Quantos anos completos você estudou</label>
			<html:text property="qatividadefisica.PER_QI03" styleClass="span1" maxlength="2" onkeyup="javascript:somente_numero(this);"/> anos
		</div>
					
		<div class="span10">
			<label>De forma geral sua saúde está</label>						
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI04" value="1"/>
				Excelente 
			</label>
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI04" value="2"/>
				Muito boa
			</label>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI04" value="3"/>
				Boa
			</label>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI04" value="4"/>
				Regular
			</label>
		</div>
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QI04" value="5"/>
				Ruim
			</label>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>Nós estamos interessados em saber que tipos de atividade física as pessoas fazem como parte do seu dia a dia. Este projeto faz parte de um grande estudo que está sendo feito em diferentes países ao redor do mundo. Suas respostas nos ajudarão a entender que tão ativos nós somos em relação à pessoas de outros países. As perguntas estão relacionadas ao tempo que você gasta fazendo atividade física em uma semana <strong>ultima semana</strong>. As perguntas incluem as atividades que você faz no trabalho, para ir de um lugar a outro, por lazer, por esporte, por exercício ou como parte das suas atividades em casa ou no jardim. Suas respostas são MUITO importantes. Por favor, responda cada questão mesmo que considere que não seja ativo. Obrigado pela sua participação!</p>
			<p>Para responder as questões lembre que:</p>
			<p>- Atividades físicas <strong>VIGOROSAS</strong> são aquelas que precisam de um grande esforço físico e que fazem respirar MUITO mais forte que o normal;</p>
			<p>- Atividades físicas <strong>MODERADAS</strong> são aquelas que precisam de algum esforço físico e que fazem respirar UM POUCO mais forte que o normal.</p>
		</div>
	
		<div class="span10">
			<h5 class="well well-small">SEÇÃO 1- ATIVIDADE FÍSICA NO TRABALHO</h5>
		</div>
		
		<div class="span10">					
			<p>Esta seção inclui as atividades que você faz no seu serviço, que incluem trabalho remunerado ou voluntário, as atividades na escola ou faculdade e outro tipo de trabalho não remunerado fora da sua casa. NÃO incluir trabalho não remunerado que você faz na sua casa como tarefas domésticas, cuidar do jardim e da casa ou tomar conta da sua família. Estas serão incluídas na seção 3.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>1a. Atualmente você trabalha ou faz trabalho voluntário fora de sua casa?</p>						
		</div>
		
		<div class="span2">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QIS1A" value="S"/>
				Sim 
			</label>
		</div>
		
		<div class="span8">
			<label class="radio">
				<html:radio property="qatividadefisica.PER_QIS1A" value="N"/>
				Não - Caso você responda não <strong>Vá para seção 2: Transporte</strong> 
			</label>
		</div>
		
		<div class="span10">
			<hr></hr>				
			<p>As próximas questões são em relação a toda a atividade física que você fez na ultima semana como parte do seu trabalho remunerado ou não remunerado. NÃO inclua o transporte para o trabalho. Pense unicamente nas atividades que você faz por pelo menos 10 minutos contínuos:</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>1b. Em quantos dias de uma semana normal você anda, durante pelo menos 10 minutos contínuos, como parte do seu trabalho?Por favor, NÃO inclua o andar como forma de transporte para ir ou voltar do trabalho.</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1B" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para seção 2: Transporte</strong> 
			</label>
		</div>
		
		
		<div class="span10">
			<hr></hr>
			<p>1c. Quanto tempo  no total você usualmente gasta POR DIA caminhando como parte do seu trabalho ?</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1CH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1CM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>1d. Em quantos dias de uma semana normal você faz atividades moderadas, por pelo menos 10 minutos contínuos, como carregar pesos leves como parte do seu trabalho?</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1D" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 1f</strong> 
			</label>
		</div>
		
		
		<div class="span10">
			<hr></hr>
			<p>1e. Quanto tempo no total você usualmente gasta POR DIA fazendo atividades moderadas como parte do seu trabalho?</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1EH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1EM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>1f. Em quantos dias de uma semana normal você gasta fazendo atividades vigorosas, por pelo menos 10 minutos contínuos, como trabalho de construção pesada, carregar grandes pesos, trabalhar com enxada, escavar ou subir escadas como parte do seu trabalho:</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1F" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 2a</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>1g. Quanto tempo no total você usualmente gasta POR DIA fazendo atividades físicas vigorosas como parte do seu trabalho?</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1GH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1GM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
					
		<div class="span10">
			<h5 class="well well-small">SEÇÃO 2 - ATIVIDADE FÍSICA COMO MEIO DE TRANSPORTE</h5>
		</div>				
		<div class="span10">					
			<p>Estas questões se referem à forma típica como você se desloca de um lugar para outro, incluindo seu trabalho, escola, cinema, lojas e outros.</p>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2a. O quanto você andou na ultima semana de carro, ônibus, metrô ou trem?</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 2c</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2b.Quanto tempo no total você usualmente gasta POR DIA andando de carro, ônibus, metrô ou trem?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2BH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2BM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">					
			<p>Agora pense somente em relação a caminhar ou pedalar para ir de um lugar a outro na ultima semana.</p>
		</div>
		<div class="span10">
			<hr></hr>
			<p>2c. Em quantos dias da ultima semana você andou de bicicleta por pelo menos 10 minutos contínuos para ir de um lugar para outro? (NÃO inclua o pedalar por lazer ou exercício)</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 2e</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2d. Nos dias que você pedala quanto tempo no total você pedala POR DIA para ir de um lugar para outro?</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2DH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2DM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>2e. Em quantos dias da ultima semana você caminhou por pelo menos 10 minutos contínuos para ir de um lugar para outro? (NÃO inclua as caminhadas por lazer ou exercício)</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a Seção 3</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2f. Quando você caminha para ir de um lugar para outro quanto tempo POR DIA você gasta? (NÃO inclua as caminhadas por lazer ou exercício)</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2FH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2FM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<h5 class="well well-small">SEÇÃO 3 - ATIVIDADE FÍSICA EM CASA: TRABALHO, TAREFAS DOMÉSTICAS E CUIDAR DA FAMÍLIA</h5>
		</div>				
		<div class="span10">					
			<p>Esta parte inclui as atividades físicas que você fez na ultima semana na sua casa e ao redor da sua casa, por exemplo, trabalho em casa, cuidar do jardim, cuidar do quintal, trabalho de manutenção da casa ou para cuidar da sua família. Novamente pense somente naquelas atividades físicas que você faz por pelo menos 10 minutos contínuos.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>3a. Em quantos dias da ultima semana você fez atividades moderadas por pelo menos 10 minutos como carregar pesos leves, limpar vidros, varrer, rastelar no jardim ou quintal.</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 3b</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3b. Nos dias que você faz este tipo de atividades quanto tempo no total você gasta POR DIA fazendo essas atividades moderadas no jardim ou no quintal?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3BH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3BM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3c. Em quantos dias da ultima semana você fez atividades moderadas por pelo menos 10 minutos como carregar pesos leves, limpar vidros, varrer ou limpar o chão dentro da sua casa.</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 3d</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3d. Nos dias que você faz este tipo de atividades moderadas dentro da sua casa quanto tempo no total você gasta POR DIA?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3DH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3DM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3e. Em quantos dias da ultima semana você fez atividades físicas vigorosas no jardim ou quintal por pelo menos 10 minutos como carpir, lavar o quintal, esfregar o chão:</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a Seção 4</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>3f. Nos dias que você faz este tipo de atividades vigorosas no quintal ou jardim quanto tempo no total você gasta POR DIA?</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3FH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3FM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>	
					
		<div class="span10">
			<h5 class="well well-small">SEÇÃO 4- ATIVIDADES FÍSICAS DE RECREAÇÃO, ESPORTE, EXERCÍCIO E DE LAZER.</h5>
		</div>
		<div class="span10">					
			<p>Esta seção se refere às atividades físicas que você fez na ultima semana unicamente por recreação, esporte, exercício ou lazer. Novamente pense somente nas atividades físicas que faz por pelo menos 10 minutos contínuos. Por favor, NÃO inclua atividades que você já tenha citado.</p>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4a. Sem contar qualquer caminhada que você tenha citado anteriormente, em quantos dias da ultima semana você caminhou por pelo menos 10 minutos contínuos no seu tempo livre?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 4b</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4b. Nos dias em que você caminha no seu tempo livre, quanto tempo no total você gasta POR DIA?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4BH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4BM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4c. Em quantos dias da ultima semana você fez atividades moderadas no seu tempo livre por pelo menos 10 minutos,  como pedalar ou nadar a velocidade regular, jogar bola, vôlei, basquete, tênis :</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a questão 4d</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4d. Nos dias em que você faz estas atividades moderadas no seu tempo livre quanto tempo no total você gasta POR DIA?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4DH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4DM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4e. Em quantos dias da ultima semana você fez atividades vigorosas no seu tempo livre por pelo menos 10 minutos, como correr, fazer aeróbicos, nadar rápido, pedalar rápido ou fazer Jogging:</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>Vá para a Seção 5</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4f. Nos dias em que você faz estas atividades vigorosas no seu tempo livre quanto tempo no total você gasta POR DIA?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4FH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4FM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		<div class="span10">
			<h5 class="well well-small">SEÇÃO 5 - TEMPO GASTO SENTADO</h5>
		</div>
		<div class="span10">					
			<p>Estas últimas questões são sobre o tempo que você permanece sentado todo dia, no trabalho, na escola ou faculdade, em casa e durante seu tempo livre. Isto inclui o tempo sentado estudando, sentado enquanto descansa, fazendo lição de casa visitando um amigo, lendo, sentado ou deitado assistindo TV. Não inclua o tempo gasto sentando durante o transporte em ônibus, trem, metrô ou carro.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>5a. Quanto tempo no total você gasta sentado durante um dia de semana?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS5AH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS5AM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>5b. Quanto tempo no total você gasta sentado durante em um dia de final de semana?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS5BH" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> horas 
			</label>
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS5BM" styleClass="span3" maxlength="2" onkeyup="javascript:somente_numero(this);"/> minutos  
			</label>
		</div>
		
		<c:choose>
			<c:when test="${questionariosForm.visita.paciente.ativo eq 'N'}">
				<div class="span10 hero-unit">
      				<span class="msg-error">Paciente excluído do estudo.</span>
  				</div>
			</c:when>
		
			<c:when test="${questionariosForm.visita.stAprovacao eq 'A'}">
				<div class="span10 hero-unit">   
      				<span class="msg-info">Visita Aprovada por ${questionariosForm.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${questionariosForm.visita.dtAssinaturaAprovacao}" /></span>
  				</div>
			</c:when>
			
			<c:when test="${questionariosForm.visita.stAprovacao eq 'R'}">
				<div class="span10 hero-unit">
      				<span class="msg-error">Visita Reprovada por ${questionariosForm.visita.assinaturaAprovador} em <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${questionariosForm.visita.dtAssinaturaAprovacao}" /></span>
  				</div>
			</c:when>
			
			<c:otherwise>
				<div class="span10">					
					<c:if test="${flAcessoAprovador ne 'S'}">					
						<html:submit styleClass="btn btn-primary">Gravar</html:submit>&nbsp;&nbsp;&nbsp;				
					</c:if>
					<html:link styleClass="btn" action="/secure/visitas.do?method=visita${questionariosForm.visita.nuVisita <= 9 ? '0' : ''}${questionariosForm.visita.nuVisita}&idPaciente=${questionariosForm.visita.paciente.idPaciente}&nuVisita=${questionariosForm.visita.nuVisita}">Voltar</html:link>
				</div>
			</c:otherwise>
		</c:choose>
		
	</html:form>

</div>

<c:choose>
	<c:when test="${flAcessoModal eq 'S' || flAcessoAprovador eq 'S' || visitasForm.acessoAprovador eq 'S' || questionariosForm.visita.stAprovacao eq 'A' || questionariosForm.visita.stAprovacao eq 'R' || questionariosForm.visita.paciente.ativo eq 'N'}">
		<script>		
			$(document).ready(function() {
				$('#formQ input[type=text]').attr("disabled",true);					
		
				$('#formQ input[type=radio]').attr("disabled",true);

				$('#formQ input[type="text"], textarea').attr("disabled",true);	

				$('#formQ input[type=text], select').attr("disabled",true);

			});		
		</script>
	</c:when>
	<c:otherwise>
		<script>		
			$(document).ready(function() {
				$('#formQ input[type=text]').attr("disabled",false);		
		
				$('#formQ input[type=radio]').attr("disabled",false);

				$('#formQ input[type="text"], textarea').attr("disabled",false);	

				$('#formQ input[type=text], select').attr("disabled",false);
			});		
		</script>
	</c:otherwise>
</c:choose>