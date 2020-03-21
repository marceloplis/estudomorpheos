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
			<h5 class="well well-small">QUESTION�RIO INTERNACIONAL DE ATIVIDADE F�SICA</h5>
		</div>
		
							
		<div class="span10">
			<label>Voc� trabalha de forma remunerada?</label>						
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
				N�o
			</label>
		</div>
		  
		<div class="span10">
			<label>Quantas horas voc� trabalha por dia?</label>
			<html:text property="qatividadefisica.PER_QI02" styleClass="span1" maxlength="5" onkeydown="formatarGenerico(this, '##:##');"/> horas
		</div>
	
		<div class="span10">
			<label>Quantos anos completos voc� estudou</label>
			<html:text property="qatividadefisica.PER_QI03" styleClass="span1" maxlength="2" onkeyup="javascript:somente_numero(this);"/> anos
		</div>
					
		<div class="span10">
			<label>De forma geral sua sa�de est�</label>						
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
			<p>N�s estamos interessados em saber que tipos de atividade f�sica as pessoas fazem como parte do seu dia a dia. Este projeto faz parte de um grande estudo que est� sendo feito em diferentes pa�ses ao redor do mundo. Suas respostas nos ajudar�o a entender que t�o ativos n�s somos em rela��o � pessoas de outros pa�ses. As perguntas est�o relacionadas ao tempo que voc� gasta fazendo atividade f�sica em uma semana <strong>ultima semana</strong>. As perguntas incluem as atividades que voc� faz no trabalho, para ir de um lugar a outro, por lazer, por esporte, por exerc�cio ou como parte das suas atividades em casa ou no jardim. Suas respostas s�o MUITO importantes. Por favor, responda cada quest�o mesmo que considere que n�o seja ativo. Obrigado pela sua participa��o!</p>
			<p>Para responder as quest�es lembre que:</p>
			<p>- Atividades f�sicas <strong>VIGOROSAS</strong> s�o aquelas que precisam de um grande esfor�o f�sico e que fazem respirar MUITO mais forte que o normal;</p>
			<p>- Atividades f�sicas <strong>MODERADAS</strong> s�o aquelas que precisam de algum esfor�o f�sico e que fazem respirar UM POUCO mais forte que o normal.</p>
		</div>
	
		<div class="span10">
			<h5 class="well well-small">SE��O 1- ATIVIDADE F�SICA NO TRABALHO</h5>
		</div>
		
		<div class="span10">					
			<p>Esta se��o inclui as atividades que voc� faz no seu servi�o, que incluem trabalho remunerado ou volunt�rio, as atividades na escola ou faculdade e outro tipo de trabalho n�o remunerado fora da sua casa. N�O incluir trabalho n�o remunerado que voc� faz na sua casa como tarefas dom�sticas, cuidar do jardim e da casa ou tomar conta da sua fam�lia. Estas ser�o inclu�das na se��o 3.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>1a. Atualmente voc� trabalha ou faz trabalho volunt�rio fora de sua casa?</p>						
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
				N�o - Caso voc� responda n�o <strong>V� para se��o 2: Transporte</strong> 
			</label>
		</div>
		
		<div class="span10">
			<hr></hr>				
			<p>As pr�ximas quest�es s�o em rela��o a toda a atividade f�sica que voc� fez na ultima semana como parte do seu trabalho remunerado ou n�o remunerado. N�O inclua o transporte para o trabalho. Pense unicamente nas atividades que voc� faz por pelo menos 10 minutos cont�nuos:</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>1b. Em quantos dias de uma semana normal voc� anda, durante pelo menos 10 minutos cont�nuos, como parte do seu trabalho?Por favor, N�O inclua o andar como forma de transporte para ir ou voltar do trabalho.</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1B" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para se��o 2: Transporte</strong> 
			</label>
		</div>
		
		
		<div class="span10">
			<hr></hr>
			<p>1c. Quanto tempo  no total voc� usualmente gasta POR DIA caminhando como parte do seu trabalho ?</p>						
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
			<p>1d. Em quantos dias de uma semana normal voc� faz atividades moderadas, por pelo menos 10 minutos cont�nuos, como carregar pesos leves como parte do seu trabalho?</p>						
		</div>
		
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1D" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 1f</strong> 
			</label>
		</div>
		
		
		<div class="span10">
			<hr></hr>
			<p>1e. Quanto tempo no total voc� usualmente gasta POR DIA fazendo atividades moderadas como parte do seu trabalho?</p>						
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
			<p>1f. Em quantos dias de uma semana normal voc� gasta fazendo atividades vigorosas, por pelo menos 10 minutos cont�nuos, como trabalho de constru��o pesada, carregar grandes pesos, trabalhar com enxada, escavar ou subir escadas como parte do seu trabalho:</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS1F" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 2a</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>1g. Quanto tempo no total voc� usualmente gasta POR DIA fazendo atividades f�sicas vigorosas como parte do seu trabalho?</p>						
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
			<h5 class="well well-small">SE��O 2 - ATIVIDADE F�SICA COMO MEIO DE TRANSPORTE</h5>
		</div>				
		<div class="span10">					
			<p>Estas quest�es se referem � forma t�pica como voc� se desloca de um lugar para outro, incluindo seu trabalho, escola, cinema, lojas e outros.</p>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2a. O quanto voc� andou na ultima semana de carro, �nibus, metr� ou trem?</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 2c</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2b.Quanto tempo no total voc� usualmente gasta POR DIA andando de carro, �nibus, metr� ou trem?</p>						
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
			<p>Agora pense somente em rela��o a caminhar ou pedalar para ir de um lugar a outro na ultima semana.</p>
		</div>
		<div class="span10">
			<hr></hr>
			<p>2c. Em quantos dias da ultima semana voc� andou de bicicleta por pelo menos 10 minutos cont�nuos para ir de um lugar para outro? (N�O inclua o pedalar por lazer ou exerc�cio)</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 2e</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2d. Nos dias que voc� pedala quanto tempo no total voc� pedala POR DIA para ir de um lugar para outro?</p>						
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
			<p>2e. Em quantos dias da ultima semana voc� caminhou por pelo menos 10 minutos cont�nuos para ir de um lugar para outro? (N�O inclua as caminhadas por lazer ou exerc�cio)</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS2E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a Se��o 3</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>2f. Quando voc� caminha para ir de um lugar para outro quanto tempo POR DIA voc� gasta? (N�O inclua as caminhadas por lazer ou exerc�cio)</p>						
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
			<h5 class="well well-small">SE��O 3 - ATIVIDADE F�SICA EM CASA: TRABALHO, TAREFAS DOM�STICAS E CUIDAR DA FAM�LIA</h5>
		</div>				
		<div class="span10">					
			<p>Esta parte inclui as atividades f�sicas que voc� fez na ultima semana na sua casa e ao redor da sua casa, por exemplo, trabalho em casa, cuidar do jardim, cuidar do quintal, trabalho de manuten��o da casa ou para cuidar da sua fam�lia. Novamente pense somente naquelas atividades f�sicas que voc� faz por pelo menos 10 minutos cont�nuos.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>3a. Em quantos dias da ultima semana voc� fez atividades moderadas por pelo menos 10 minutos como carregar pesos leves, limpar vidros, varrer, rastelar no jardim ou quintal.</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 3b</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3b. Nos dias que voc� faz este tipo de atividades quanto tempo no total voc� gasta POR DIA fazendo essas atividades moderadas no jardim ou no quintal?</p>						
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
			<p>3c. Em quantos dias da ultima semana voc� fez atividades moderadas por pelo menos 10 minutos como carregar pesos leves, limpar vidros, varrer ou limpar o ch�o dentro da sua casa.</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 3d</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>3d. Nos dias que voc� faz este tipo de atividades moderadas dentro da sua casa quanto tempo no total voc� gasta POR DIA?</p>						
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
			<p>3e. Em quantos dias da ultima semana voc� fez atividades f�sicas vigorosas no jardim ou quintal por pelo menos 10 minutos como carpir, lavar o quintal, esfregar o ch�o:</p>						
		</div>				
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS3E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>				
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a Se��o 4</strong> 
			</label>
		</div>				
		<div class="span10">
			<hr></hr>
			<p>3f. Nos dias que voc� faz este tipo de atividades vigorosas no quintal ou jardim quanto tempo no total voc� gasta POR DIA?</p>						
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
			<h5 class="well well-small">SE��O 4- ATIVIDADES F�SICAS DE RECREA��O, ESPORTE, EXERC�CIO E DE LAZER.</h5>
		</div>
		<div class="span10">					
			<p>Esta se��o se refere �s atividades f�sicas que voc� fez na ultima semana unicamente por recrea��o, esporte, exerc�cio ou lazer. Novamente pense somente nas atividades f�sicas que faz por pelo menos 10 minutos cont�nuos. Por favor, N�O inclua atividades que voc� j� tenha citado.</p>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4a. Sem contar qualquer caminhada que voc� tenha citado anteriormente, em quantos dias da ultima semana voc� caminhou por pelo menos 10 minutos cont�nuos no seu tempo livre?</p>						
		</div>
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4A" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 4b</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4b. Nos dias em que voc� caminha no seu tempo livre, quanto tempo no total voc� gasta POR DIA?</p>						
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
			<p>4c. Em quantos dias da ultima semana voc� fez atividades moderadas no seu tempo livre por pelo menos 10 minutos,  como pedalar ou nadar a velocidade regular, jogar bola, v�lei, basquete, t�nis :</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4C" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a quest�o 4d</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4d. Nos dias em que voc� faz estas atividades moderadas no seu tempo livre quanto tempo no total voc� gasta POR DIA?</p>						
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
			<p>4e. Em quantos dias da ultima semana voc� fez atividades vigorosas no seu tempo livre por pelo menos 10 minutos, como correr, fazer aer�bicos, nadar r�pido, pedalar r�pido ou fazer Jogging:</p>						
		</div>	
		<div class="span3">
			<label class="radio">
				<html:text property="qatividadefisica.PER_QIS4E" styleClass="span3" maxlength="1" onkeyup="javascript:somente_numero(this);"/> dias por SEMANA 
			</label>
		</div>
		<div class="span7">
			<label class="radio">
				ZERO/VAZIO <strong>V� para a Se��o 5</strong> 
			</label>
		</div>
		<div class="span10">
			<hr></hr>
			<p>4f. Nos dias em que voc� faz estas atividades vigorosas no seu tempo livre quanto tempo no total voc� gasta POR DIA?</p>						
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
			<h5 class="well well-small">SE��O 5 - TEMPO GASTO SENTADO</h5>
		</div>
		<div class="span10">					
			<p>Estas �ltimas quest�es s�o sobre o tempo que voc� permanece sentado todo dia, no trabalho, na escola ou faculdade, em casa e durante seu tempo livre. Isto inclui o tempo sentado estudando, sentado enquanto descansa, fazendo li��o de casa visitando um amigo, lendo, sentado ou deitado assistindo TV. N�o inclua o tempo gasto sentando durante o transporte em �nibus, trem, metr� ou carro.</p>
		</div>
		
		<div class="span10">
			<hr></hr>
			<p>5a. Quanto tempo no total voc� gasta sentado durante um dia de semana?</p>						
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
			<p>5b. Quanto tempo no total voc� gasta sentado durante em um dia de final de semana?</p>						
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
      				<span class="msg-error">Paciente exclu�do do estudo.</span>
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