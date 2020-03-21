package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetHeader;

public class Visita16Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Grupo Randomizado")
	private Long gruporandomizacao;

	@SheetHeader( name = "PAS 24h")
	private String pas24;
	
	@SheetHeader( name = "PAD 24h")
	private String pad24;
	
	@SheetHeader( name = "PAM 24h")
	private String pam24;
	
	@SheetHeader( name = "FC 24h")
	private String fc24;
	
	@SheetHeader( name = "PAS Vigília")
	private String pasVigilia;
	
	@SheetHeader( name = "PAD Vigília")
	private String padVigilia;
	
	@SheetHeader( name = "PAM Vigília")
	private String pamVigilia;
	
	@SheetHeader( name = "FC Vigília")
	private String fcVigilia;
	
	@SheetHeader( name = "PAS Sono")
	private String pasSono;
	
	@SheetHeader( name = "PAD Sono")
	private String padSono;
	
	@SheetHeader( name = "PAM Sono")
	private String pamSono;
	
	@SheetHeader( name = "FC Sono")
	private String fcSono;
	
	@SheetHeader( name = "PAS Min Sono")
	private String pasMinSono;
	
	@SheetHeader( name = "PAD Min Sono")
	private String padMinSono;
	
	@SheetHeader( name = "PAM Min Sono")
	private String pamMinSono;
	
	@SheetHeader( name = "PAS 2h Acordar")
	private String pas2Acordar;
	
	@SheetHeader( name = "PAD 2h Acordar")
	private String pad2Acordar;
	
	@SheetHeader( name = "PAM 2h Acordar")
	private String pam2Acordar;
	
	@SheetHeader( name = "Hora de início")
	private String horaInicio;
	
	@SheetHeader( name = "Hora de término")
	private String horaTermino;

	@SheetHeader( name = "#DDV (mm)")
	private String ddv;

	@SheetHeader( name = "DSVE (mm)")
	private String dsve;

	@SheetHeader( name = "Espessura septal (mm)")
	private String espSeptal;

	@SheetHeader( name = "Espessura da parede posterior (mm)")
	private String espParedePosterior;

	@SheetHeader( name = "Espessura relativa da parede")
	private String espRelativaParede;

	@SheetHeader( name = "Massa do VE")
	private String massaVe;

	@SheetHeader( name = "Índice de massa (g/m2)")
	private String indiceMassaGM2;

	@SheetHeader( name = "Índice de massa (g/m)")
	private String indicaMassaGM;

	@SheetHeader( name = "TRIV (mseg)")
	private String triv;

	@SheetHeader( name = "Tempo de desaceleração (mseg)")
	private String tempoDesaceleracao;

	@SheetHeader( name = "Velocidade onda \"E\" mitral (cm/seg)")
	private String velOndaEMitral;

	@SheetHeader( name = "Velocidade onda \"A\" mitral (cm/seg)")
	private String velOndaAMitral;

	@SheetHeader( name = "Relação E/A")
	private String relacaoEA;

	@SheetHeader( name = "Fração de Ejeção (%)")
	private String fracaoEjecao;

	@SheetHeader( name = "Fração de Encurtamento (%)")
	private String fracaoEncurtamento;

	@SheetHeader( name = "Índice de esfericidade do ventrículo esquerdo")
	private String indiceEsfericidadeVE;

	@SheetHeader( name = "Diâmetro da aorta (mm)")
	private String diametroAorta;

	@SheetHeader( name = "Diâmetro do átrio esquerdo (mm)")
	private String diametroAtrioEsquerdo;

	@SheetHeader( name = "Med Doppler mitral septal E' (cm/seg)")
	private String medDopplerMitralSE;

	@SheetHeader( name = "Med Doppler mitral septal A' (cm/seg)")
	private String medDopplerMitralSA;

	@SheetHeader( name = "Med Doppler mitral lateral E' (cm/seg)")
	private String medDopplerMitralLE;

	@SheetHeader( name = "Med Doppler mitral lateral A' (cm/seg)")
	private String medDopplerMitralLA;

	@SheetHeader( name = "Relação Onda E'/A' Septal")
	private String relacaoOndaEAS;

	@SheetHeader( name = "Relação Onda E'/A' Lateral")
	private String relacaoOndaEASL;

	@SheetHeader( name = "Média relação onda E'/A' septal e lateral")
	private String medRelacaoOndaEASL;

	@SheetHeader( name = "Onda SVD (cm/seg)")
	private String ondaSVD;

	@SheetHeader( name = "TAPSE (mm)")
	private String tapse;

	@SheetHeader( name = "Diâmetro transversal VD (anel VD) (mm)")
	private String diametroTVDAnel;

	@SheetHeader( name = "Diâmetro transversal VD (médio VD) (mm)")
	private String diametroTVDMedio;

	@SheetHeader( name = "Diâmetro longitudinal VD (mm)")
	private String diametroLongVD;

	@SheetHeader( name = "Insuficiência tricúspide (grau)")
	private String insuficienciaT;

	@SheetHeader( name = "PSVD (mm Hg)")
	private String psvd;

	@SheetHeader( name = "Velocidade máxima VSVD (m/s)")
	private String velMaximaVSVD;

	@SheetHeader( name = "xInsuficiência mitral (grau)x")
	private String insuficienciaM;

	@SheetHeader( name = "Insuficiência aórtica (grau)")
	private String insuficienciaA;

	@SheetHeader( name = "Insuficiência pulmonar (grau)")
	private String insuficienciaP;

	@SheetHeader( name = "Estenose mitral (grau)")
	private String estenoseMitral;

	@SheetHeader( name = "Gradiente transvalvar mitral (médio) (mm Hg)")
	private String gradTransMitralMed;

	@SheetHeader( name = "Gradiente transvalvar mitral (máximo) (mm Hg)")
	private String gradTransMitralMax;

	@SheetHeader( name = "Área mitral (cm2)")
	private String areaMitral;

	@SheetHeader( name = "Estenose aórtica (grau)")
	private String estenoseAortica;

	@SheetHeader( name = "Gradiente transvalvar aórtica (médio) (mm Hg)")
	private String gradTransAMed;

	@SheetHeader( name = "Gradiente transvalvar aórtica (máximo) (mm Hg)")
	private String gradTransAMax;

	@SheetHeader( name = "Área aórtica (cm2)")
	private String areaAortica;

	@SheetHeader( name = "Velocidade máxima VSVE (m/s)")
	private String velMaxVSVE;

	@SheetHeader( name = "Observações")
	private String obsEco;

	@SheetHeader( name = "Data processamento soro/plasma congelado")
	private String dataProcessamentoSoro;

	@SheetHeader( name = "Data coleta")
	private String dataColeta;

	@SheetHeader( name = "Glicemia (mg/dL)")
	private String glicemia;

	@SheetHeader( name = "Colesterol Total (mg/dL)")
	private String colesterol;

	@SheetHeader( name = "LDL (mg/dL)")
	private String ldl;

	@SheetHeader( name = "HDL (mg/dL)")
	private String hdl;

	@SheetHeader( name = "Triglicerídeos (mg/dL)")
	private String trigliceridios;

	@SheetHeader( name = "Não HDL (mg/dL)")
	private String naoHDL;

	@SheetHeader( name = "Ác. Úrico (mg/dL)")
	private String acidoUrico;

	@SheetHeader( name = "Renina (ng/mL/h)")
	private String renina;

	@SheetHeader( name = "Aldosterona (ng/dL)")
	private String aldosterona;

	@SheetHeader( name = "Microalbuminúria (mg/24h)")
	private String microalbuminuria;

	@SheetHeader( name = "PCR Ultra-sensível (mg/dL)")
	private String pcrUltraSensivel;

	@SheetHeader( name = "PAS Central (mm Hg)")
	private String pasCentral;

	@SheetHeader( name = "PAD Central (mm Hg)")
	private String padCentral;

	@SheetHeader( name = "Pressão de Pulso Central (mm Hg)")
	private String pressaoPulso;

	@SheetHeader( name = "Augmentation Index (%)")
	private String augmentarion;

	@SheetHeader( name = "Aix 75 (%)")
	private String aix75;

	@SheetHeader( name = "Observações")
	private String obsSph;

	
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
	
	public Long getGruporandomizacao() {
		return gruporandomizacao;
	}
	
	public void setGruporandomizacao(Long gruporandomizacao) {
		this.gruporandomizacao = gruporandomizacao;
	}

	public String getPas24() {
		return pas24;
	}

	public void setPas24(String pas24) {
		this.pas24 = pas24;
	}

	public String getPad24() {
		return pad24;
	}

	public void setPad24(String pad24) {
		this.pad24 = pad24;
	}

	public String getPam24() {
		return pam24;
	}

	public void setPam24(String pam24) {
		this.pam24 = pam24;
	}

	public String getFc24() {
		return fc24;
	}

	public void setFc24(String fc24) {
		this.fc24 = fc24;
	}

	public String getPasVigilia() {
		return pasVigilia;
	}

	public void setPasVigilia(String pasVigilia) {
		this.pasVigilia = pasVigilia;
	}

	public String getPadVigilia() {
		return padVigilia;
	}

	public void setPadVigilia(String padVigilia) {
		this.padVigilia = padVigilia;
	}

	public String getPamVigilia() {
		return pamVigilia;
	}

	public void setPamVigilia(String pamVigilia) {
		this.pamVigilia = pamVigilia;
	}

	public String getFcVigilia() {
		return fcVigilia;
	}

	public void setFcVigilia(String fcVigilia) {
		this.fcVigilia = fcVigilia;
	}

	public String getPasSono() {
		return pasSono;
	}

	public void setPasSono(String pasSono) {
		this.pasSono = pasSono;
	}

	public String getPadSono() {
		return padSono;
	}

	public void setPadSono(String padSono) {
		this.padSono = padSono;
	}

	public String getPamSono() {
		return pamSono;
	}

	public void setPamSono(String pamSono) {
		this.pamSono = pamSono;
	}

	public String getFcSono() {
		return fcSono;
	}

	public void setFcSono(String fcSono) {
		this.fcSono = fcSono;
	}

	public String getPasMinSono() {
		return pasMinSono;
	}

	public void setPasMinSono(String pasMinSono) {
		this.pasMinSono = pasMinSono;
	}

	public String getPadMinSono() {
		return padMinSono;
	}

	public void setPadMinSono(String padMinSono) {
		this.padMinSono = padMinSono;
	}

	public String getPamMinSono() {
		return pamMinSono;
	}

	public void setPamMinSono(String pamMinSono) {
		this.pamMinSono = pamMinSono;
	}

	public String getPas2Acordar() {
		return pas2Acordar;
	}

	public void setPas2Acordar(String pas2Acordar) {
		this.pas2Acordar = pas2Acordar;
	}

	public String getPad2Acordar() {
		return pad2Acordar;
	}

	public void setPad2Acordar(String pad2Acordar) {
		this.pad2Acordar = pad2Acordar;
	}

	public String getPam2Acordar() {
		return pam2Acordar;
	}

	public void setPam2Acordar(String pam2Acordar) {
		this.pam2Acordar = pam2Acordar;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getDdv() {
		return ddv;
	}

	public void setDdv(String ddv) {
		this.ddv = ddv;
	}

	public String getDsve() {
		return dsve;
	}

	public void setDsve(String dsve) {
		this.dsve = dsve;
	}

	public String getEspSeptal() {
		return espSeptal;
	}

	public void setEspSeptal(String espSeptal) {
		this.espSeptal = espSeptal;
	}

	public String getEspParedePosterior() {
		return espParedePosterior;
	}

	public void setEspParedePosterior(String espParedePosterior) {
		this.espParedePosterior = espParedePosterior;
	}

	public String getEspRelativaParede() {
		return espRelativaParede;
	}

	public void setEspRelativaParede(String espRelativaParede) {
		this.espRelativaParede = espRelativaParede;
	}

	public String getMassaVe() {
		return massaVe;
	}

	public void setMassaVe(String massaVe) {
		this.massaVe = massaVe;
	}

	public String getIndiceMassaGM2() {
		return indiceMassaGM2;
	}

	public void setIndiceMassaGM2(String indiceMassaGM2) {
		this.indiceMassaGM2 = indiceMassaGM2;
	}

	public String getIndicaMassaGM() {
		return indicaMassaGM;
	}

	public void setIndicaMassaGM(String indicaMassaGM) {
		this.indicaMassaGM = indicaMassaGM;
	}

	public String getTriv() {
		return triv;
	}

	public void setTriv(String triv) {
		this.triv = triv;
	}

	public String getTempoDesaceleracao() {
		return tempoDesaceleracao;
	}

	public void setTempoDesaceleracao(String tempoDesaceleracao) {
		this.tempoDesaceleracao = tempoDesaceleracao;
	}

	public String getVelOndaEMitral() {
		return velOndaEMitral;
	}

	public void setVelOndaEMitral(String velOndaEMitral) {
		this.velOndaEMitral = velOndaEMitral;
	}

	public String getVelOndaAMitral() {
		return velOndaAMitral;
	}

	public void setVelOndaAMitral(String velOndaAMitral) {
		this.velOndaAMitral = velOndaAMitral;
	}

	public String getRelacaoEA() {
		return relacaoEA;
	}

	public void setRelacaoEA(String relacaoEA) {
		this.relacaoEA = relacaoEA;
	}

	public String getFracaoEjecao() {
		return fracaoEjecao;
	}

	public void setFracaoEjecao(String fracaoEjecao) {
		this.fracaoEjecao = fracaoEjecao;
	}

	public String getFracaoEncurtamento() {
		return fracaoEncurtamento;
	}

	public void setFracaoEncurtamento(String fracaoEncurtamento) {
		this.fracaoEncurtamento = fracaoEncurtamento;
	}

	public String getIndiceEsfericidadeVE() {
		return indiceEsfericidadeVE;
	}

	public void setIndiceEsfericidadeVE(String indiceEsfericidadeVE) {
		this.indiceEsfericidadeVE = indiceEsfericidadeVE;
	}

	public String getDiametroAorta() {
		return diametroAorta;
	}

	public void setDiametroAorta(String diametroAorta) {
		this.diametroAorta = diametroAorta;
	}

	public String getDiametroAtrioEsquerdo() {
		return diametroAtrioEsquerdo;
	}

	public void setDiametroAtrioEsquerdo(String diametroAtrioEsquerdo) {
		this.diametroAtrioEsquerdo = diametroAtrioEsquerdo;
	}

	public String getMedDopplerMitralSE() {
		return medDopplerMitralSE;
	}

	public void setMedDopplerMitralSE(String medDopplerMitralSE) {
		this.medDopplerMitralSE = medDopplerMitralSE;
	}

	public String getMedDopplerMitralSA() {
		return medDopplerMitralSA;
	}

	public void setMedDopplerMitralSA(String medDopplerMitralSA) {
		this.medDopplerMitralSA = medDopplerMitralSA;
	}

	public String getMedDopplerMitralLE() {
		return medDopplerMitralLE;
	}

	public void setMedDopplerMitralLE(String medDopplerMitralLE) {
		this.medDopplerMitralLE = medDopplerMitralLE;
	}

	public String getMedDopplerMitralLA() {
		return medDopplerMitralLA;
	}

	public void setMedDopplerMitralLA(String medDopplerMitralLA) {
		this.medDopplerMitralLA = medDopplerMitralLA;
	}

	public String getRelacaoOndaEAS() {
		return relacaoOndaEAS;
	}

	public void setRelacaoOndaEAS(String relacaoOndaEAS) {
		this.relacaoOndaEAS = relacaoOndaEAS;
	}

	public String getRelacaoOndaEASL() {
		return relacaoOndaEASL;
	}

	public void setRelacaoOndaEASL(String relacaoOndaEASL) {
		this.relacaoOndaEASL = relacaoOndaEASL;
	}

	public String getMedRelacaoOndaEASL() {
		return medRelacaoOndaEASL;
	}

	public void setMedRelacaoOndaEASL(String medRelacaoOndaEASL) {
		this.medRelacaoOndaEASL = medRelacaoOndaEASL;
	}

	public String getOndaSVD() {
		return ondaSVD;
	}

	public void setOndaSVD(String ondaSVD) {
		this.ondaSVD = ondaSVD;
	}

	public String getTapse() {
		return tapse;
	}

	public void setTapse(String tapse) {
		this.tapse = tapse;
	}

	public String getDiametroTVDAnel() {
		return diametroTVDAnel;
	}

	public void setDiametroTVDAnel(String diametroTVDAnel) {
		this.diametroTVDAnel = diametroTVDAnel;
	}

	public String getDiametroTVDMedio() {
		return diametroTVDMedio;
	}

	public void setDiametroTVDMedio(String diametroTVDMedio) {
		this.diametroTVDMedio = diametroTVDMedio;
	}

	public String getDiametroLongVD() {
		return diametroLongVD;
	}

	public void setDiametroLongVD(String diametroLongVD) {
		this.diametroLongVD = diametroLongVD;
	}

	public String getInsuficienciaT() {
		return insuficienciaT;
	}

	public void setInsuficienciaT(String insuficienciaT) {
		this.insuficienciaT = insuficienciaT;
	}

	public String getPsvd() {
		return psvd;
	}

	public void setPsvd(String psvd) {
		this.psvd = psvd;
	}

	public String getVelMaximaVSVD() {
		return velMaximaVSVD;
	}

	public void setVelMaximaVSVD(String velMaximaVSVD) {
		this.velMaximaVSVD = velMaximaVSVD;
	}

	public String getInsuficienciaM() {
		return insuficienciaM;
	}

	public void setInsuficienciaM(String insuficienciaM) {
		this.insuficienciaM = insuficienciaM;
	}

	public String getInsuficienciaA() {
		return insuficienciaA;
	}

	public void setInsuficienciaA(String insuficienciaA) {
		this.insuficienciaA = insuficienciaA;
	}

	public String getInsuficienciaP() {
		return insuficienciaP;
	}

	public void setInsuficienciaP(String insuficienciaP) {
		this.insuficienciaP = insuficienciaP;
	}

	public String getEstenoseMitral() {
		return estenoseMitral;
	}

	public void setEstenoseMitral(String estenoseMitral) {
		this.estenoseMitral = estenoseMitral;
	}

	public String getGradTransMitralMed() {
		return gradTransMitralMed;
	}

	public void setGradTransMitralMed(String gradTransMitralMed) {
		this.gradTransMitralMed = gradTransMitralMed;
	}

	public String getGradTransMitralMax() {
		return gradTransMitralMax;
	}

	public void setGradTransMitralMax(String gradTransMitralMax) {
		this.gradTransMitralMax = gradTransMitralMax;
	}

	public String getAreaMitral() {
		return areaMitral;
	}

	public void setAreaMitral(String areaMitral) {
		this.areaMitral = areaMitral;
	}

	public String getEstenoseAortica() {
		return estenoseAortica;
	}

	public void setEstenoseAortica(String estenoseAortica) {
		this.estenoseAortica = estenoseAortica;
	}

	public String getGradTransAMed() {
		return gradTransAMed;
	}

	public void setGradTransAMed(String gradTransAMed) {
		this.gradTransAMed = gradTransAMed;
	}

	public String getGradTransAMax() {
		return gradTransAMax;
	}

	public void setGradTransAMax(String gradTransAMax) {
		this.gradTransAMax = gradTransAMax;
	}

	public String getAreaAortica() {
		return areaAortica;
	}

	public void setAreaAortica(String areaAortica) {
		this.areaAortica = areaAortica;
	}

	public String getVelMaxVSVE() {
		return velMaxVSVE;
	}

	public void setVelMaxVSVE(String velMaxVSVE) {
		this.velMaxVSVE = velMaxVSVE;
	}

	public String getObsEco() {
		return obsEco;
	}

	public void setObsEco(String obsEco) {
		this.obsEco = obsEco;
	}

	public String getDataProcessamentoSoro() {
		return dataProcessamentoSoro;
	}

	public void setDataProcessamentoSoro(String dataProcessamentoSoro) {
		this.dataProcessamentoSoro = dataProcessamentoSoro;
	}

	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	public String getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(String glicemia) {
		this.glicemia = glicemia;
	}

	public String getColesterol() {
		return colesterol;
	}

	public void setColesterol(String colesterol) {
		this.colesterol = colesterol;
	}

	public String getLdl() {
		return ldl;
	}

	public void setLdl(String ldl) {
		this.ldl = ldl;
	}

	public String getHdl() {
		return hdl;
	}

	public void setHdl(String hdl) {
		this.hdl = hdl;
	}

	public String getTrigliceridios() {
		return trigliceridios;
	}

	public void setTrigliceridios(String trigliceridios) {
		this.trigliceridios = trigliceridios;
	}

	public String getNaoHDL() {
		return naoHDL;
	}

	public void setNaoHDL(String naoHDL) {
		this.naoHDL = naoHDL;
	}

	public String getAcidoUrico() {
		return acidoUrico;
	}

	public void setAcidoUrico(String acidoUrico) {
		this.acidoUrico = acidoUrico;
	}

	public String getRenina() {
		return renina;
	}

	public void setRenina(String renina) {
		this.renina = renina;
	}

	public String getAldosterona() {
		return aldosterona;
	}

	public void setAldosterona(String aldosterona) {
		this.aldosterona = aldosterona;
	}

	public String getMicroalbuminuria() {
		return microalbuminuria;
	}

	public void setMicroalbuminuria(String microalbuminuria) {
		this.microalbuminuria = microalbuminuria;
	}

	public String getPcrUltraSensivel() {
		return pcrUltraSensivel;
	}

	public void setPcrUltraSensivel(String pcrUltraSensivel) {
		this.pcrUltraSensivel = pcrUltraSensivel;
	}

	public String getPasCentral() {
		return pasCentral;
	}

	public void setPasCentral(String pasCentral) {
		this.pasCentral = pasCentral;
	}

	public String getPadCentral() {
		return padCentral;
	}

	public void setPadCentral(String padCentral) {
		this.padCentral = padCentral;
	}

	public String getPressaoPulso() {
		return pressaoPulso;
	}

	public void setPressaoPulso(String pressaoPulso) {
		this.pressaoPulso = pressaoPulso;
	}

	public String getAugmentarion() {
		return augmentarion;
	}

	public void setAugmentarion(String augmentarion) {
		this.augmentarion = augmentarion;
	}

	public String getAix75() {
		return aix75;
	}

	public void setAix75(String aix75) {
		this.aix75 = aix75;
	}

	public String getObsSph() {
		return obsSph;
	}

	public void setObsSph(String obsSph) {
		this.obsSph = obsSph;
	}
	
}
