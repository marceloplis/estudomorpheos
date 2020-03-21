<%@include file="/templates/tags.jsp" %>

<div class="form-msg-error">
	<jsp:include page="/templates/message-error.jsp"/>
</div>

<div class="formulario">

	<jsp:include page="../includes/tituloquestionario.jsp"/>
		
	<html:form action="/secure/gravaquestionarios?method=gravarqecocardiograma" styleId="formQ">
		<html:hidden property="qcardiograma.idEcocardiograma"/>
		<html:hidden property="qcardiograma.visita.idVisita"/>

		<div class="span10">					
			<h5 class="well well-small">ECOCARDIOGRAMA TRANSTOR�CICO</h5>													
		</div>
		
		<div class="span10">				  
		  	<div class="well well-small">
				<div class="row-fluid">					
					
					<div class="span3">
						<div class="inline">
				  			<label>Ecocardiograma realizado?</label>
				  
							<label class="radio inline">
							  	<html:radio property="qcardiograma.flRealizado" value="S"/>
							  	Sim
							</label>
							<label class="radio inline">
							  	<html:radio property="qcardiograma.flRealizado" value="N"/>
							  	N�o
							</label>
				  
						</div>
					</div>	
					
					<div class="span3">	
						<div class="inline">
						  	<label>Data da Realiza��o</label>	
						  	<html:text property="qcardiograma.dtRealizacao" styleClass="input-small" styleId="dt1"/>						 						 
						</div>
					</div>	
						
				</div>			
			</div>
		</div>
		
		<div class="span10">
			<table class="table table-bordered">
			   	<tbody>
				<tr>
				<td class="span7">DDVE- DI�METRO DIAST�LICO DO VE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT01" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">DSVE- DI�METRO SIST�LICO DO VE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT02" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">ESPESSURA SEPTAL </td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT03" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">ESPESSURA DA PAREDE POSTERIOR</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT04" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">ESPESSURA RELATIVA DA PAREDE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT05" styleClass="span4" maxlength="10"/> (sem unidade)</td>											
				</tr>
				<tr>
				<td class="span7">MASSA DO VE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT06" styleClass="span4" maxlength="10"/> (g)</td>											
				</tr>
				<tr>
				<td class="span7">�NDICE DE MASSA (MASSA/SUPERF�CIE CORP�REA)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT07" styleClass="span4" maxlength="10"/> (gr/m�)</td>											
				</tr>
				<tr>
				<td class="span7">INDICE DE MASSA(MASSA/ALTURA)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT08" styleClass="span4" maxlength="10"/> (gr/m)</td>											
				</tr>
				<tr>
				<td class="span7">TRIV-TEMPO DE RELAXAMENTO ISOVOLUM�TRICO</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT09" styleClass="span4" maxlength="10"/> (mseg)</td>											
				</tr>
				<tr>
				<td class="span7">TEMPO DE DESACELERA��O</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT10" styleClass="span4" maxlength="10"/> (mseg)</td>											
				</tr>
				<tr>
				<td class="span7">VELOCIDADE DA ONDA "E" MITRAL</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT11" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">VELOCIDADE DA  ONDA "A" MITRAL</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT12" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">RELA��O E/A</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT13" styleClass="span4" maxlength="10"/> (sem unidade)</td>											
				</tr>
				<tr>
				<td class="span7">FRA��O DE EJE��O</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT14" styleClass="span4" maxlength="10"/> (%)</td>											
				</tr>
				<tr>
				<td class="span7">FRA��O DE ENCURTAMENTO</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT15" styleClass="span4" maxlength="10"/> (%)</td>											
				</tr>
				<tr>
				<td class="span7">�NDICE DE ESFERICIDADE DO VENTR�CULO ESQUERDO</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT16" styleClass="span4" maxlength="10"/></td>											
				</tr>
				<tr>
				<td class="span7">DI�METRO DA AORTA</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT17" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">DI�METRO DO �TRIO ESQUERDO</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT18" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">MED. Doppler Tecidual Mitral  SEPTAL E'</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT19" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">MED. Doppler Tecidual Mitral  SEPTAL A'</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT20" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">MED Doppler Tecidual Mitral  LATERAL E'</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT21" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">MED. Doppler Tecidual Mitral  LATERAL A'</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT22" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">RELA��O ONDA E / A' SEPTAL</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT23" styleClass="span4" maxlength="10"/></td>											
				</tr>
				<tr>
				<td class="span7">RELA��O ONDA E / A' LATERAL</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT24" styleClass="span4" maxlength="10"/></td>											
				</tr>
				<tr>
				<td class="span7">M�dia entre a RELA��O ONDA E / A' SEPTAL  e  RELA��O ONDA E / A' LATERAL</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT25" styleClass="span4" maxlength="10"/></td>											
				</tr>
				<tr>
				<td class="span7">Onda S VD</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT26" styleClass="span4" maxlength="10"/> (cm/seg)</td>											
				</tr>
				<tr>
				<td class="span7">TAPSE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT27" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">Di�metro  Transversal VD (N�vel- Anel VD, proje��o apical 4 c�maras)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT28" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">Di�metro Transversal VD (N�vel - M�dio VD, proje��o apical 4 c�maras)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT29" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">Di�metro Longitudinal VD (proje��o apical 4 c�maras)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT30" styleClass="span4" maxlength="10"/> (mm)</td>											
				</tr>
				<tr>
				<td class="span7">Insufici�ncia tric�spide (grau)</td>
				<td class="span3">
				0 <html:radio property="qcardiograma.PER_CT31" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT31" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT31" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT31" value="3"/>
				</td>																
				</tr>	
				<tr>
				<td class="span7">PSVD</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT32" styleClass="span4" maxlength="10"/> mmHg</td>											
				</tr>
				<tr>
				<td class="span7">Velocidade m�xima VSVD</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT33" styleClass="span4" maxlength="10"/> m/s</td>											
				</tr>
				<tr>
				<td class="span7">Insufici�ncia mitral (grau)</td>
				<td class="span3"> 
				0 <html:radio property="qcardiograma.PER_CT34" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT34" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT34" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT34" value="3"/>
				</td>																
				</tr>
				<tr>
				<td class="span7">Insufici�ncia a�rtica (grau)</td>
				<td class="span3"> 
				0 <html:radio property="qcardiograma.PER_CT35" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT35" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT35" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT35" value="3"/>
				</td>																
				</tr>
				<tr>
				<td class="span7">Insufici�ncia pulmonar (grau)</td>
				<td class="span3"> 
				0 <html:radio property="qcardiograma.PER_CT36" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT36" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT36" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT36" value="3"/>
				</td>																
				</tr>
				<tr>
				<td class="span7">Estenose mitral (grau)</td>
				<td class="span3"> 
				0 <html:radio property="qcardiograma.PER_CT37" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT37" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT37" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT37" value="3"/>
				</td>																
				</tr>
				<tr>
				<td class="span7">Gradiente Transvalvar mitral (m�dio)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT38" styleClass="span4" maxlength="10"/> mmHg</td>											
				</tr>
				<tr>
				<td class="span7">Gradiente Transvalvar mitral (m�ximo)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT39" styleClass="span4" maxlength="10"/> mmHg</td>											
				</tr>
				<tr>
				<td class="span7">�rea mitral</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT40" styleClass="span4" maxlength="10"/> cm2</td>											
				</tr>
				<tr>
				<td class="span7">Estenose a�rtica (grau)</td>
				<td class="span3"> 
				0 <html:radio property="qcardiograma.PER_CT41" value="0"/> &nbsp; 
				1 <html:radio property="qcardiograma.PER_CT41" value="1"/> &nbsp;      
				2 <html:radio property="qcardiograma.PER_CT41" value="2"/> &nbsp;       
				3 <html:radio property="qcardiograma.PER_CT41" value="3"/>
				</td>																
				</tr>
				<tr>
				<td class="span7">Gradiente Transvalvar a�rtico (m�dio)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT42" styleClass="span4" maxlength="10"/> mmHg</td>											
				</tr>
				<tr>
				<tr>
				<td class="span7">Gradiente Transvalvar a�rtico (m�ximo)</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT43" styleClass="span4" maxlength="10"/> mmHg</td>											
				</tr>
				<tr>
				<tr>
				<td class="span7">�rea a�rtica</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT44" styleClass="span4" maxlength="10"/> cm2</td>											
				</tr>
				<tr>
				<tr>
				<td class="span7">Velocidade m�xima em VSVE</td>						
				<td class="span3"><html:text property="qcardiograma.PER_CT45" styleClass="span4" maxlength="10"/> m/s</td>											
				</tr>
				<tr>				
				</tbody>								
			</table>					
		</div>
	
		<div class="span10">
			<label>Observa��es</label>
			<html:textarea property="qcardiograma.observacao" rows="3" styleClass="span12"/>
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

<script>		
	$(document).ready(function() {
		$('.datepicker').datepicker();
	});			
											
	$(function(){
		$('#dt1').datepicker({
		  format: 'dd/mm/yyyy'
		});			
	});
	
</script>

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