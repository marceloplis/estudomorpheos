package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita00Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;

	@SheetHeader( name = "Data Assinatura TCLE")
	private Date dataAssinaturaTCLE;
	
	@SheetHeader( name = "1-Hipertensão")
	private String hipertensao;
	
	@SheetHeader( name = "2-Anti-hipertensivos")
	private String antiHipertendivo;
	
	@SheetHeader( name = "1- >= 65 anos")
	private String maiorIgual65Anos;

	@SheetHeader( name = "2- ICC ou FE < 45%, IAM e AVC")
	private String iccFEMenor45IAMAVC;

	@SheetHeader( name = "3- Creatinina > 2mg/dL")
	private String creatininaMaior2mg;

	@SheetHeader( name = "4- Usuário droga ilícita")
	private String usuarioDrogaIlicita;

	@SheetHeader( name = "5- Uso de simpaticomiméticos")
	private String usoSimpaticomimetico;

	@SheetHeader( name = "6- Uso de anticoncepcionais e AINHs")
	private String usoAnticoncepcionalAINH;

	@SheetHeader( name = "7- Gravidez")
	private String gravidez;

	@SheetHeader( name = "8- PA > 180x110")
	private String paMaior180Por110;

	@SheetHeader( name = "9- Causa secundária HAS")
	private String causaSecundariaHAS;

	@SheetHeader( name = "10- IMC >= 40 kg/m2")
	private String imcMaiorIgual40;

	@SheetHeader( name = "Peso")
	private Float peso;

	@SheetHeader( name = "Altura")
	private Float altura;

	@SheetHeader( name = "IMC")
	private Float imc;

	@SheetHeader( name = "Circ. Cervical")
	private Long circCervical;

	@SheetHeader( name = "Circ. Abdominal")
	private Long circAbdominal;

	@SheetHeader( name = "Circ. Braquial")
	private Long circBranquial;

	@SheetHeader( name = "Anos de ronco")
	private Long anosRonco;

	@SheetHeader( name = "Aumento PA gravidez")
	private Long aumentoPAGravidez;

	@SheetHeader( name = "Dislipidemia")
	private String dislipidemia;

	@SheetHeader( name = "Diabetes")
	private String diabetes;

	@SheetHeader( name = "Tabagismo Atual")
	private String tabagismoAtual;
	
	@SheetHeader( name = "Cigarros/dia")
	private Long cigarrosDia;

	@SheetHeader( name = "Ex-tabagista")
	private String exTabagista;

	@SheetHeader( name = "Tempo tabagismo")
	private Long tempoTabagismo;

	@SheetHeader( name = "Quando parou")
	private Long qtosMesesParou;

	@SheetHeader( name = "Obstrução Nasal Constante")
	private String obstrucaoNasalConstante;

	@SheetHeader( name = "Rinite")
	private String rinite;

	@SheetHeader( name = "Ano diagnóstico HAS")
	private Integer anoDiagnosticoHAS;

	@SheetHeader( name = "Depressão")
	private String depressao;

	@SheetHeader( name = "Refluxo")
	private String refluxo;

	@SheetHeader( name = "Braço")
	private String braco;

	@SheetHeader( name = "PA 1")
	private String pa01;

	@SheetHeader( name = "PA 2")
	private String pa02;

	@SheetHeader( name = "PA 3")
	private String pa03;

	@SheetHeader( name = "PA 4")
	private String pa04;

	@SheetHeader( name = "PA 5")
	private String pa05;

	@SheetHeader( name = "Média PA")
	private String mediaPA;

	@SheetHeader( name = "FC 1")
	private Long fc01;

	@SheetHeader( name = "FC 2")
	private Long fc02;

	@SheetHeader( name = "FC 3")
	private Long fc03;

	@SheetHeader( name = "FC 4")
	private Long fc04;

	@SheetHeader( name = "FC 5")
	private Long fc05;

	/*@SheetHeader( name = "Grupo do medicamento")
	private String grupoMedicamento;

	@SheetHeader( name = "Medicamento")
	private String medicamento;

	@SheetHeader( name = "Dose")
	private String dose;

	@SheetHeader( name = "Posologia")
	private String posologia;

	@SheetHeader( name = "Observação")
	private String observacao;*/

	
	public String getNumeroPaciente() {
		return numeroPaciente;
	}

	public void setNumeroPaciente(String numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getIniciaisNome() {
		return iniciaisNome;
	}

	public void setIniciaisNome(String iniciaisNome) {
		this.iniciaisNome = iniciaisNome;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}

	public Date getDataAssinaturaTCLE() {
		return dataAssinaturaTCLE;
	}

	public void setDataAssinaturaTCLE(Date dataAssinaturaTCLE) {
		this.dataAssinaturaTCLE = dataAssinaturaTCLE;
	}

	public String getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(String hipertensao) {
		this.hipertensao = hipertensao;
	}

	public String getAntiHipertendivo() {
		return antiHipertendivo;
	}

	public void setAntiHipertendivo(String antiHipertendivo) {
		this.antiHipertendivo = antiHipertendivo;
	}

	public String getMaiorIgual65Anos() {
		return maiorIgual65Anos;
	}

	public void setMaiorIgual65Anos(String maiorIgual65Anos) {
		this.maiorIgual65Anos = maiorIgual65Anos;
	}

	public String getIccFEMenor45IAMAVC() {
		return iccFEMenor45IAMAVC;
	}

	public void setIccFEMenor45IAMAVC(String iccFEMenor45IAMAVC) {
		this.iccFEMenor45IAMAVC = iccFEMenor45IAMAVC;
	}

	public String getCreatininaMaior2mg() {
		return creatininaMaior2mg;
	}

	public void setCreatininaMaior2mg(String creatininaMaior2mg) {
		this.creatininaMaior2mg = creatininaMaior2mg;
	}

	public String getUsuarioDrogaIlicita() {
		return usuarioDrogaIlicita;
	}

	public void setUsuarioDrogaIlicita(String usuarioDrogaIlicita) {
		this.usuarioDrogaIlicita = usuarioDrogaIlicita;
	}

	public String getUsoSimpaticomimetico() {
		return usoSimpaticomimetico;
	}

	public void setUsoSimpaticomimetico(String usoSimpaticomimetico) {
		this.usoSimpaticomimetico = usoSimpaticomimetico;
	}

	public String getUsoAnticoncepcionalAINH() {
		return usoAnticoncepcionalAINH;
	}

	public void setUsoAnticoncepcionalAINH(String usoAnticoncepcionalAINH) {
		this.usoAnticoncepcionalAINH = usoAnticoncepcionalAINH;
	}

	public String getGravidez() {
		return gravidez;
	}

	public void setGravidez(String gravidez) {
		this.gravidez = gravidez;
	}

	public String getPaMaior180Por110() {
		return paMaior180Por110;
	}

	public void setPaMaior180Por110(String paMaior180Por110) {
		this.paMaior180Por110 = paMaior180Por110;
	}

	public String getCausaSecundariaHAS() {
		return causaSecundariaHAS;
	}

	public void setCausaSecundariaHAS(String causaSecundariaHAS) {
		this.causaSecundariaHAS = causaSecundariaHAS;
	}

	public String getImcMaiorIgual40() {
		return imcMaiorIgual40;
	}

	public void setImcMaiorIgual40(String imcMaiorIgual40) {
		this.imcMaiorIgual40 = imcMaiorIgual40;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public Long getCircCervical() {
		return circCervical;
	}

	public void setCircCervical(Long circCervical) {
		this.circCervical = circCervical;
	}

	public Long getCircAbdominal() {
		return circAbdominal;
	}

	public void setCircAbdominal(Long circAbdominal) {
		this.circAbdominal = circAbdominal;
	}

	public Long getCircBranquial() {
		return circBranquial;
	}

	public void setCircBranquial(Long circBranquial) {
		this.circBranquial = circBranquial;
	}

	public Long getAnosRonco() {
		return anosRonco;
	}

	public void setAnosRonco(Long anosRonco) {
		this.anosRonco = anosRonco;
	}

	public Long getAumentoPAGravidez() {
		return aumentoPAGravidez;
	}

	public void setAumentoPAGravidez(Long aumentoPAGravidez) {
		this.aumentoPAGravidez = aumentoPAGravidez;
	}

	public String getDislipidemia() {
		return dislipidemia;
	}

	public void setDislipidemia(String dislipidemia) {
		this.dislipidemia = dislipidemia;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getTabagismoAtual() {
		return tabagismoAtual;
	}

	public void setTabagismoAtual(String tabagismoAtual) {
		this.tabagismoAtual = tabagismoAtual;
	}

	public Long getCigarrosDia() {
		return cigarrosDia;
	}

	public void setCigarrosDia(Long cigarrosDia) {
		this.cigarrosDia = cigarrosDia;
	}

	public String getExTabagista() {
		return exTabagista;
	}

	public void setExTabagista(String exTabagista) {
		this.exTabagista = exTabagista;
	}

	public Long getTempoTabagismo() {
		return tempoTabagismo;
	}

	public void setTempoTabagismo(Long tempoTabagismo) {
		this.tempoTabagismo = tempoTabagismo;
	}

	public Long getQtosMesesParou() {
		return qtosMesesParou;
	}

	public void setQtosMesesParou(Long qtosMesesParou) {
		this.qtosMesesParou = qtosMesesParou;
	}

	public String getObstrucaoNasalConstante() {
		return obstrucaoNasalConstante;
	}

	public void setObstrucaoNasalConstante(String obstrucaoNasalConstante) {
		this.obstrucaoNasalConstante = obstrucaoNasalConstante;
	}

	public String getRinite() {
		return rinite;
	}

	public void setRinite(String rinite) {
		this.rinite = rinite;
	}

	public Integer getAnoDiagnosticoHAS() {
		return anoDiagnosticoHAS;
	}

	public void setAnoDiagnosticoHAS(Integer anoDiagnosticoHAS) {
		this.anoDiagnosticoHAS = anoDiagnosticoHAS;
	}

	public String getDepressao() {
		return depressao;
	}

	public void setDepressao(String depressao) {
		this.depressao = depressao;
	}

	public String getRefluxo() {
		return refluxo;
	}

	public void setRefluxo(String refluxo) {
		this.refluxo = refluxo;
	}

	public String getBraco() {
		return braco;
	}

	public void setBraco(String braco) {
		this.braco = braco;
	}

	public String getPa01() {
		return pa01;
	}

	public void setPa01(String pa01) {
		this.pa01 = pa01;
	}

	public String getPa02() {
		return pa02;
	}

	public void setPa02(String pa02) {
		this.pa02 = pa02;
	}

	public String getPa03() {
		return pa03;
	}

	public void setPa03(String pa03) {
		this.pa03 = pa03;
	}

	public String getPa04() {
		return pa04;
	}

	public void setPa04(String pa04) {
		this.pa04 = pa04;
	}

	public String getPa05() {
		return pa05;
	}

	public void setPa05(String pa05) {
		this.pa05 = pa05;
	}

	public String getMediaPA() {
		return mediaPA;
	}

	public void setMediaPA(String mediaPA) {
		this.mediaPA = mediaPA;
	}

	public Long getFc01() {
		return fc01;
	}

	public void setFc01(Long fc01) {
		this.fc01 = fc01;
	}

	public Long getFc02() {
		return fc02;
	}

	public void setFc02(Long fc02) {
		this.fc02 = fc02;
	}

	public Long getFc03() {
		return fc03;
	}

	public void setFc03(Long fc03) {
		this.fc03 = fc03;
	}

	public Long getFc04() {
		return fc04;
	}

	public void setFc04(Long fc04) {
		this.fc04 = fc04;
	}

	public Long getFc05() {
		return fc05;
	}

	public void setFc05(Long fc05) {
		this.fc05 = fc05;
	}

	/*
	public String getGrupoMedicamento() {
		return grupoMedicamento;
	}

	public void setGrupoMedicamento(String grupoMedicamento) {
		this.grupoMedicamento = grupoMedicamento;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	*/
	
}
