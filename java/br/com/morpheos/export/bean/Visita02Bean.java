package br.com.morpheos.export.bean;

import java.util.Date;

import br.com.morpheos.export.excel.SheetColumnIgnore;
import br.com.morpheos.export.excel.SheetHeader;

public class Visita02Bean {
	
	@SheetHeader( name = "Nº Paciente")
	private String numeroPaciente;
	
	@SheetHeader( name = "Iniciais")
	private String iniciaisNome;

	@SheetHeader( name = "Data Visita")
	private Date dataVisita;
	
	@SheetHeader( name = "Adesão medicamentosa (%)")
	private String adesaoMedicamentosa;

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

	@SheetHeader( name = "Pergunta 1")
	private Long pergunta1Epworth;	
	
	@SheetHeader( name = "Pergunta 2")
	private Long pergunta2Epworth;	
	
	@SheetHeader( name = "Pergunta 3")
	private Long pergunta3Epworth;	
	
	@SheetHeader( name = "Pergunta 4")
	private Long pergunta4Epworth;	
	
	@SheetHeader( name = "Pergunta 5")
	private Long pergunta5Epworth;	
	
	@SheetHeader( name = "Pergunta 6")
	private Long pergunta6Epworth;	
	
	@SheetHeader( name = "Pergunta 7")
	private Long pergunta7Epworth;	
	
	@SheetHeader( name = "Pergunta 8")
	private Long pergunta8Epworth;	
	
	@SheetHeader( name = "Sonolência diurna ?")
	private String sonolenciaExcessiva;	
	
	@SheetHeader( name = "Score TOTAL")
	private String escalaTotalEpworth;	
	
	@SheetHeader( name = "Quantas horas dorme/dia ?")
	private Long qtdMediaDiariaSono;	
	
	@SheetHeader( name = "Pergunta 1")
	private Long pergunta1Berlim;	
	
	@SheetHeader( name = "Pergunta 2")
	private Long pergunta2Berlim;	
	
	@SheetHeader( name = "Pergunta 3")
	private Long pergunta3Berlim;	
	
	@SheetHeader( name = "Pergunta 4")
	private Long pergunta4Berlim;	
	
	@SheetHeader( name = "Pergunta 5")
	private String pergunta5Berlim;	
	
	@SheetHeader( name = "Pergunta 6")
	private Long pergunta6Berlim;	
	
	@SheetHeader( name = "Pergunta 7")
	private Long pergunta7Berlim;	
	
	@SheetHeader( name = "Pergunta 8")
	private Long pergunta8Berlim;	
	
	@SheetHeader( name = "Pergunta 9")
	private Long pergunta9Berlim;	
	
	@SheetColumnIgnore
	@SheetHeader( name = "Frequencia")
	private Long frequenciaPergunta9Berlim;	
	
	@SheetHeader( name = "Pergunta 10")
	private Long pergunta10Berlim;	
	
	@SheetHeader( name = "Pergunta 11")
	private String pergunta11Berlim;	
	
	@SheetHeader( name = "Categoria 1")
	private String categoria1Berlim;	
	
	@SheetHeader( name = "Categoria 2")
	private String categoria2Berlim;	
	
	@SheetHeader( name = "Categoria 3")
	private String categoria3Berlim;	
	
	@SheetHeader( name = "FINAL")
	private Long finalBerlim;	
	
	@SheetHeader( name = "Pergunta 1")
	private String pergunta1Cage;	
	
	@SheetHeader( name = "Pergunta 2")
	private String pergunta2Cage;	
	
	@SheetHeader( name = "Pergunta 3")
	private String pergunta3Cage;	
	
	@SheetHeader( name = "Pergunta 4")
	private String pergunta4Cage;	
	
	@SheetHeader( name = "Positivo em 3 ?")
	private String positivo3Cage;	
	
	@SheetHeader( name = "Você trabalha de forma remunerada?")
	private String trabalhoRemunerado;	
	
	@SheetHeader( name = "Quantas horas você trabalha por dia?")
	private String horasTrabalhadas;	
	
	@SheetHeader( name = "Quantos anos completos você estudou")
	private Long anosCompletosEstudo;	
	
	@SheetHeader( name = "Estado geral sua saude")
	private Long estadoGeralSaude;	
	
	@SheetHeader( name = "Pergunta 1a")
	private String pergunta1aAtvf;	
	
	@SheetHeader( name = "Pergunta 1b")
	private Long pergunta1bAtvf;	
	
	@SheetHeader( name = "Pergunta 1c")
	private Long pergunta1cAtvf;	
	
	@SheetHeader( name = "Pergunta 1d")
	private Long pergunta1dAtvf;	
	
	@SheetHeader( name = "Pergunta 1e")
	private Long pergunta1eAtvf;	
	
	@SheetHeader( name = "Pergunta 1f")
	private Long pergunta1fAtvf;	
	
	@SheetHeader( name = "Pergunta 1g")
	private Long pergunta1gAtvf;	
	
	@SheetHeader( name = "Pergunta 2a")
	private Long pergunta2aAtvf;	
	
	@SheetHeader( name = "Pergunta 2b")
	private Long pergunta2bAtvf;	
	
	@SheetHeader( name = "Pergunta 2c")
	private Long pergunta2cAtvf;	
	
	@SheetHeader( name = "Pergunta 2d")
	private Long pergunta2dAtvf;	
	
	@SheetHeader( name = "Pergunta 2e")
	private Long pergunta2eAtvf;	
	
	@SheetHeader( name = "Pergunta 2f")
	private Long pergunta2fAtvf;	
	
	@SheetHeader( name = "Pergunta 3a")
	private Long pergunta3aAtvf;	
	
	@SheetHeader( name = "Pergunta 3b")
	private Long pergunta3bAtvf;	
	
	@SheetHeader( name = "Pergunta 3c")
	private Long pergunta3cAtvf;	
	
	@SheetHeader( name = "Pergunta 3d")
	private Long pergunta3dAtvf;	
	
	@SheetHeader( name = "Pergunta 3e")
	private Long pergunta3eAtvf;	
	
	@SheetHeader( name = "Pergunta 3f")
	private Long pergunta3fAtvf;	
	
	@SheetHeader( name = "Pergunta 4a")
	private Long pergunta4aAtvf;	
	
	@SheetHeader( name = "Pergunta 4b")
	private Long pergunta4bAtvf;	
	
	@SheetHeader( name = "Pergunta 4c")
	private Long pergunta4cAtvf;	
	
	@SheetHeader( name = "Pergunta 4d")
	private Long pergunta4dAtvf;	
	
	@SheetHeader( name = "Pergunta 4e")
	private Long pergunta4eAtvf;	
	
	@SheetHeader( name = "Pergunta 4f")
	private Long pergunta4fAtvf;	
	
	@SheetHeader( name = "Pergunta 5a")
	private Long pergunta5aAtvf;	
	
	@SheetHeader( name = "Pergunta 5b")
	private Long pergunta5bAtvf;

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

	public String getAdesaoMedicamentosa() {
		return adesaoMedicamentosa;
	}

	public void setAdesaoMedicamentosa(String adesaoMedicamentosa) {
		this.adesaoMedicamentosa = adesaoMedicamentosa;
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

	public Long getPergunta1Epworth() {
		return pergunta1Epworth;
	}

	public void setPergunta1Epworth(Long pergunta1Epworth) {
		this.pergunta1Epworth = pergunta1Epworth;
	}

	public Long getPergunta2Epworth() {
		return pergunta2Epworth;
	}

	public void setPergunta2Epworth(Long pergunta2Epworth) {
		this.pergunta2Epworth = pergunta2Epworth;
	}

	public Long getPergunta3Epworth() {
		return pergunta3Epworth;
	}

	public void setPergunta3Epworth(Long pergunta3Epworth) {
		this.pergunta3Epworth = pergunta3Epworth;
	}

	public Long getPergunta4Epworth() {
		return pergunta4Epworth;
	}

	public void setPergunta4Epworth(Long pergunta4Epworth) {
		this.pergunta4Epworth = pergunta4Epworth;
	}

	public Long getPergunta5Epworth() {
		return pergunta5Epworth;
	}

	public void setPergunta5Epworth(Long pergunta5Epworth) {
		this.pergunta5Epworth = pergunta5Epworth;
	}

	public Long getPergunta6Epworth() {
		return pergunta6Epworth;
	}

	public void setPergunta6Epworth(Long pergunta6Epworth) {
		this.pergunta6Epworth = pergunta6Epworth;
	}

	public Long getPergunta7Epworth() {
		return pergunta7Epworth;
	}

	public void setPergunta7Epworth(Long pergunta7Epworth) {
		this.pergunta7Epworth = pergunta7Epworth;
	}

	public Long getPergunta8Epworth() {
		return pergunta8Epworth;
	}

	public void setPergunta8Epworth(Long pergunta8Epworth) {
		this.pergunta8Epworth = pergunta8Epworth;
	}

	public String getSonolenciaExcessiva() {
		return sonolenciaExcessiva;
	}

	public void setSonolenciaExcessiva(String sonolenciaExcessiva) {
		this.sonolenciaExcessiva = sonolenciaExcessiva;
	}

	public String getEscalaTotalEpworth() {
		return escalaTotalEpworth;
	}

	public void setEscalaTotalEpworth(String escalaTotalEpworth) {
		this.escalaTotalEpworth = escalaTotalEpworth;
	}

	public Long getQtdMediaDiariaSono() {
		return qtdMediaDiariaSono;
	}

	public void setQtdMediaDiariaSono(Long qtdMediaDiariaSono) {
		this.qtdMediaDiariaSono = qtdMediaDiariaSono;
	}

	public Long getPergunta1Berlim() {
		return pergunta1Berlim;
	}

	public void setPergunta1Berlim(Long pergunta1Berlim) {
		this.pergunta1Berlim = pergunta1Berlim;
	}

	public Long getPergunta2Berlim() {
		return pergunta2Berlim;
	}

	public void setPergunta2Berlim(Long pergunta2Berlim) {
		this.pergunta2Berlim = pergunta2Berlim;
	}

	public Long getPergunta3Berlim() {
		return pergunta3Berlim;
	}

	public void setPergunta3Berlim(Long pergunta3Berlim) {
		this.pergunta3Berlim = pergunta3Berlim;
	}

	public Long getPergunta4Berlim() {
		return pergunta4Berlim;
	}

	public void setPergunta4Berlim(Long pergunta4Berlim) {
		this.pergunta4Berlim = pergunta4Berlim;
	}

	public String getPergunta5Berlim() {
		return pergunta5Berlim;
	}

	public void setPergunta5Berlim(String pergunta5Berlim) {
		this.pergunta5Berlim = pergunta5Berlim;
	}

	public Long getPergunta6Berlim() {
		return pergunta6Berlim;
	}

	public void setPergunta6Berlim(Long pergunta6Berlim) {
		this.pergunta6Berlim = pergunta6Berlim;
	}

	public Long getPergunta7Berlim() {
		return pergunta7Berlim;
	}

	public void setPergunta7Berlim(Long pergunta7Berlim) {
		this.pergunta7Berlim = pergunta7Berlim;
	}

	public Long getPergunta8Berlim() {
		return pergunta8Berlim;
	}

	public void setPergunta8Berlim(Long pergunta8Berlim) {
		this.pergunta8Berlim = pergunta8Berlim;
	}

	public Long getPergunta9Berlim() {
		return pergunta9Berlim;
	}

	public void setPergunta9Berlim(Long pergunta9Berlim) {
		this.pergunta9Berlim = pergunta9Berlim;
	}

	public Long getFrequenciaPergunta9Berlim() {
		return frequenciaPergunta9Berlim;
	}

	public void setFrequenciaPergunta9Berlim(Long frequenciaPergunta9Berlim) {
		this.frequenciaPergunta9Berlim = frequenciaPergunta9Berlim;
	}

	public Long getPergunta10Berlim() {
		return pergunta10Berlim;
	}

	public void setPergunta10Berlim(Long pergunta10Berlim) {
		this.pergunta10Berlim = pergunta10Berlim;
	}

	public String getPergunta11Berlim() {
		return pergunta11Berlim;
	}

	public void setPergunta11Berlim(String pergunta11Berlim) {
		this.pergunta11Berlim = pergunta11Berlim;
	}

	public String getCategoria1Berlim() {
		return categoria1Berlim;
	}

	public void setCategoria1Berlim(String categoria1Berlim) {
		this.categoria1Berlim = categoria1Berlim;
	}

	public String getCategoria2Berlim() {
		return categoria2Berlim;
	}

	public void setCategoria2Berlim(String categoria2Berlim) {
		this.categoria2Berlim = categoria2Berlim;
	}

	public String getCategoria3Berlim() {
		return categoria3Berlim;
	}

	public void setCategoria3Berlim(String categoria3Berlim) {
		this.categoria3Berlim = categoria3Berlim;
	}

	public Long getFinalBerlim() {
		return finalBerlim;
	}

	public void setFinalBerlim(Long finalBerlim) {
		this.finalBerlim = finalBerlim;
	}

	public String getPergunta1Cage() {
		return pergunta1Cage;
	}

	public void setPergunta1Cage(String pergunta1Cage) {
		this.pergunta1Cage = pergunta1Cage;
	}

	public String getPergunta2Cage() {
		return pergunta2Cage;
	}

	public void setPergunta2Cage(String pergunta2Cage) {
		this.pergunta2Cage = pergunta2Cage;
	}

	public String getPergunta3Cage() {
		return pergunta3Cage;
	}

	public void setPergunta3Cage(String pergunta3Cage) {
		this.pergunta3Cage = pergunta3Cage;
	}

	public String getPergunta4Cage() {
		return pergunta4Cage;
	}

	public void setPergunta4Cage(String pergunta4Cage) {
		this.pergunta4Cage = pergunta4Cage;
	}

	public String getPositivo3Cage() {
		return positivo3Cage;
	}

	public void setPositivo3Cage(String positivo3Cage) {
		this.positivo3Cage = positivo3Cage;
	}

	public String getTrabalhoRemunerado() {
		return trabalhoRemunerado;
	}

	public void setTrabalhoRemunerado(String trabalhoRemunerado) {
		this.trabalhoRemunerado = trabalhoRemunerado;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Long getAnosCompletosEstudo() {
		return anosCompletosEstudo;
	}

	public void setAnosCompletosEstudo(Long anosCompletosEstudo) {
		this.anosCompletosEstudo = anosCompletosEstudo;
	}

	public Long getEstadoGeralSaude() {
		return estadoGeralSaude;
	}

	public void setEstadoGeralSaude(Long estadoGeralSaude) {
		this.estadoGeralSaude = estadoGeralSaude;
	}

	public String getPergunta1aAtvf() {
		return pergunta1aAtvf;
	}

	public void setPergunta1aAtvf(String pergunta1aAtvf) {
		this.pergunta1aAtvf = pergunta1aAtvf;
	}

	public Long getPergunta1bAtvf() {
		return pergunta1bAtvf;
	}

	public void setPergunta1bAtvf(Long pergunta1bAtvf) {
		this.pergunta1bAtvf = pergunta1bAtvf;
	}

	public Long getPergunta1cAtvf() {
		return pergunta1cAtvf;
	}

	public void setPergunta1cAtvf(Long pergunta1cAtvf) {
		this.pergunta1cAtvf = pergunta1cAtvf;
	}

	public Long getPergunta1dAtvf() {
		return pergunta1dAtvf;
	}

	public void setPergunta1dAtvf(Long pergunta1dAtvf) {
		this.pergunta1dAtvf = pergunta1dAtvf;
	}

	public Long getPergunta1eAtvf() {
		return pergunta1eAtvf;
	}

	public void setPergunta1eAtvf(Long pergunta1eAtvf) {
		this.pergunta1eAtvf = pergunta1eAtvf;
	}

	public Long getPergunta1fAtvf() {
		return pergunta1fAtvf;
	}

	public void setPergunta1fAtvf(Long pergunta1fAtvf) {
		this.pergunta1fAtvf = pergunta1fAtvf;
	}

	public Long getPergunta1gAtvf() {
		return pergunta1gAtvf;
	}

	public void setPergunta1gAtvf(Long pergunta1gAtvf) {
		this.pergunta1gAtvf = pergunta1gAtvf;
	}

	public Long getPergunta2aAtvf() {
		return pergunta2aAtvf;
	}

	public void setPergunta2aAtvf(Long pergunta2aAtvf) {
		this.pergunta2aAtvf = pergunta2aAtvf;
	}

	public Long getPergunta2bAtvf() {
		return pergunta2bAtvf;
	}

	public void setPergunta2bAtvf(Long pergunta2bAtvf) {
		this.pergunta2bAtvf = pergunta2bAtvf;
	}

	public Long getPergunta2cAtvf() {
		return pergunta2cAtvf;
	}

	public void setPergunta2cAtvf(Long pergunta2cAtvf) {
		this.pergunta2cAtvf = pergunta2cAtvf;
	}

	public Long getPergunta2dAtvf() {
		return pergunta2dAtvf;
	}

	public void setPergunta2dAtvf(Long pergunta2dAtvf) {
		this.pergunta2dAtvf = pergunta2dAtvf;
	}

	public Long getPergunta2eAtvf() {
		return pergunta2eAtvf;
	}

	public void setPergunta2eAtvf(Long pergunta2eAtvf) {
		this.pergunta2eAtvf = pergunta2eAtvf;
	}

	public Long getPergunta2fAtvf() {
		return pergunta2fAtvf;
	}

	public void setPergunta2fAtvf(Long pergunta2fAtvf) {
		this.pergunta2fAtvf = pergunta2fAtvf;
	}

	public Long getPergunta3aAtvf() {
		return pergunta3aAtvf;
	}

	public void setPergunta3aAtvf(Long pergunta3aAtvf) {
		this.pergunta3aAtvf = pergunta3aAtvf;
	}

	public Long getPergunta3bAtvf() {
		return pergunta3bAtvf;
	}

	public void setPergunta3bAtvf(Long pergunta3bAtvf) {
		this.pergunta3bAtvf = pergunta3bAtvf;
	}

	public Long getPergunta3cAtvf() {
		return pergunta3cAtvf;
	}

	public void setPergunta3cAtvf(Long pergunta3cAtvf) {
		this.pergunta3cAtvf = pergunta3cAtvf;
	}

	public Long getPergunta3dAtvf() {
		return pergunta3dAtvf;
	}

	public void setPergunta3dAtvf(Long pergunta3dAtvf) {
		this.pergunta3dAtvf = pergunta3dAtvf;
	}

	public Long getPergunta3eAtvf() {
		return pergunta3eAtvf;
	}

	public void setPergunta3eAtvf(Long pergunta3eAtvf) {
		this.pergunta3eAtvf = pergunta3eAtvf;
	}

	public Long getPergunta3fAtvf() {
		return pergunta3fAtvf;
	}

	public void setPergunta3fAtvf(Long pergunta3fAtvf) {
		this.pergunta3fAtvf = pergunta3fAtvf;
	}

	public Long getPergunta4aAtvf() {
		return pergunta4aAtvf;
	}

	public void setPergunta4aAtvf(Long pergunta4aAtvf) {
		this.pergunta4aAtvf = pergunta4aAtvf;
	}

	public Long getPergunta4bAtvf() {
		return pergunta4bAtvf;
	}

	public void setPergunta4bAtvf(Long pergunta4bAtvf) {
		this.pergunta4bAtvf = pergunta4bAtvf;
	}

	public Long getPergunta4cAtvf() {
		return pergunta4cAtvf;
	}

	public void setPergunta4cAtvf(Long pergunta4cAtvf) {
		this.pergunta4cAtvf = pergunta4cAtvf;
	}

	public Long getPergunta4dAtvf() {
		return pergunta4dAtvf;
	}

	public void setPergunta4dAtvf(Long pergunta4dAtvf) {
		this.pergunta4dAtvf = pergunta4dAtvf;
	}

	public Long getPergunta4eAtvf() {
		return pergunta4eAtvf;
	}

	public void setPergunta4eAtvf(Long pergunta4eAtvf) {
		this.pergunta4eAtvf = pergunta4eAtvf;
	}

	public Long getPergunta4fAtvf() {
		return pergunta4fAtvf;
	}

	public void setPergunta4fAtvf(Long pergunta4fAtvf) {
		this.pergunta4fAtvf = pergunta4fAtvf;
	}

	public Long getPergunta5aAtvf() {
		return pergunta5aAtvf;
	}

	public void setPergunta5aAtvf(Long pergunta5aAtvf) {
		this.pergunta5aAtvf = pergunta5aAtvf;
	}

	public Long getPergunta5bAtvf() {
		return pergunta5bAtvf;
	}

	public void setPergunta5bAtvf(Long pergunta5bAtvf) {
		this.pergunta5bAtvf = pergunta5bAtvf;
	}	
	
}
