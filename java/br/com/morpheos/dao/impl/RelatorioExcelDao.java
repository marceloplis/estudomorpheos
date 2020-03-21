package br.com.morpheos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import br.com.morpheos.dao.types.TipoRelatorioExcel;
import br.com.morpheos.export.bean.DadosPacienteBean;
import br.com.morpheos.export.bean.EventosAdversosBean;
import br.com.morpheos.export.bean.ExclusaoEstudoBean;
import br.com.morpheos.export.bean.MedicamentosPacientesBean;
import br.com.morpheos.export.bean.Visita00Bean;
import br.com.morpheos.export.bean.Visita01Bean;
import br.com.morpheos.export.bean.Visita02Bean;
import br.com.morpheos.export.bean.Visita03Bean;
import br.com.morpheos.export.bean.Visita04Bean;
import br.com.morpheos.export.bean.Visita05Bean;
import br.com.morpheos.export.bean.Visita06Bean;
import br.com.morpheos.export.bean.Visita07Bean;
import br.com.morpheos.export.bean.Visita08Bean;
import br.com.morpheos.export.bean.Visita09Bean;
import br.com.morpheos.export.bean.Visita10Bean;
import br.com.morpheos.export.bean.Visita11Bean;
import br.com.morpheos.export.bean.Visita12Bean;
import br.com.morpheos.export.bean.Visita13Bean;
import br.com.morpheos.export.bean.Visita14Bean;
import br.com.morpheos.export.bean.Visita15Bean;
import br.com.morpheos.export.bean.Visita16Bean;
import br.com.morpheos.export.bean.Visita17Bean;

public class RelatorioExcelDao{

	private final Session session;
	
	public RelatorioExcelDao(Session session){
		this.session = session;
	}

	public <T> List<T> buscaDados(TipoRelatorioExcel tf) {
		
		List<T> listReturn = null;
		
		switch (tf) {
		case DADOS_PACIENTE:{
					
			listReturn = (List<T>) this.buscaDadosPaciente();
			break;

		}
		case EXCLUSAO_ESTUDO:{
			
			listReturn = (List<T>) this.buscaExclusaoEstudo();
			break;

		}
		case EVENTOS_ADVERSOS:{
			
			listReturn = (List<T>) this.buscaEventosAdversos();
			break;

		}
		case MEDICAMENTOS_PACIENTE:{
			
			listReturn = (List<T>) this.buscaMedicamentosPaciente();
			break;

		}
		case VISITA_00:{
			
			listReturn = (List<T>) this.buscaVisita00();
			break;
		}
		case VISITA_01:{
			
			listReturn = (List<T>) this.buscaVisita01();
			break;
		}
		case VISITA_02:{
			
			listReturn = (List<T>) this.buscaVisita02();
			break;
		}
		case VISITA_03:{
			
			listReturn = (List<T>) this.buscaVisita03();
			break;
		}
		case VISITA_04:{
			
			listReturn = (List<T>) this.buscaVisita04();
			break;
		}
		case VISITA_05:{
			
			listReturn = (List<T>) this.buscaVisita05();
			break;
		}
		case VISITA_06:{
			
			listReturn = (List<T>) this.buscaVisita06();
			break;
		}
		case VISITA_07:{
			
			listReturn = (List<T>) this.buscaVisita07();
			break;
		}
		case VISITA_08:{
			
			listReturn = (List<T>) this.buscaVisita08();
			break;
		}
		case VISITA_09:{
			
			listReturn = (List<T>) this.buscaVisita09();
			break;
		}
		case VISITA_10:{
			
			listReturn = (List<T>) this.buscaVisita10();
			break;
		}
		case VISITA_11:{
			
			listReturn = (List<T>) this.buscaVisita11();
			break;
		}
		case VISITA_12:{
			
			listReturn = (List<T>) this.buscaVisita12();
			break;
		}
		case VISITA_13:{
			
			listReturn = (List<T>) this.buscaVisita13();
			break;
		}
		case VISITA_14:{
			
			listReturn = (List<T>) this.buscaVisita14();
			break;
		}
		case VISITA_15:{
			
			listReturn = (List<T>) this.buscaVisita15();
			break;
		}
		case VISITA_16:{
			
			listReturn = (List<T>) this.buscaVisita16();
			break;
		}
		case VISITA_17:{
			
			listReturn = (List<T>) this.buscaVisita17();
			break;
		}
		default:
			break;
		}
		
		this.session.flush();
		this.session.clear();
		
		return listReturn;
	}
	
	private List<DadosPacienteBean> buscaDadosPaciente(){
		
		Query query = this.session.createSQLQuery(""
			+ " select "
			+ "		p.nome, "
			+ "     p.iniciaisNome, "
			+ "     0 as idade, "  
			+ "		up.dsUnidade, "
			+ "		p.nuRegistroProtocolo, "
			+ "		p.dtNascimento, "
			+ "		p.sexo, "
			+ "		p.escolaridade, "
			+ "		p.raca, "			
			+ "     p.profissao "			          
			+ "	from "
			+ "		estudomorpheos.TbPaciente p,"
			+ "		estudomorpheos.TbUnidadePesquisa up"
			+ " where "
			+ "		p.idUnidadePesquisa = up.idUnidadePesquisa"
			+ "")
		.addScalar("nome", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("idade", new IntegerType())
		.addScalar("dsUnidade", new StringType())
		.addScalar("nuRegistroProtocolo", new StringType())
		.addScalar("dtNascimento", new DateType())
		.addScalar("sexo", new StringType())
		.addScalar("escolaridade", new IntegerType())
		.addScalar("raca", new IntegerType())		
		.addScalar("profissao", new StringType())
		
		.setResultTransformer(Transformers.aliasToBean(DadosPacienteBean.class));
		
		List<DadosPacienteBean> list = query.list();
			
		return list;
		
	}
	

	private List<ExclusaoEstudoBean> buscaExclusaoEstudo(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	se.idPaciente numeroPaciente"
	    + " 	,p.iniciaisNome iniciaisNome"
	    + " 	,se.dtSaida dataSaida"
	    + " 	,se.nuVisita numeroVisita"
	    + " 	,se.motivo motivoSaida"
	    + " 	,se.observacao observacoes"
	    + " 	,se.dtOcorrencia dataOcorrencia"
	    + " 	,se.flEvolucaoObito evoluiuObito"
	    + "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = p.idPaciente and b.nuVisita = 4) as gruporandomizacao"
	    + " FROM "
	    + " 	estudomorpheos.TbSaidaEstudo se"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (se.idPaciente = p.idPaciente)"				
	    + "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataSaida", new DateType())
		.addScalar("numeroVisita", new LongType())
		.addScalar("motivoSaida", new LongType())
		.addScalar("observacoes", new StringType())
		.addScalar("dataOcorrencia", new DateType())
		.addScalar("evoluiuObito", new StringType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(ExclusaoEstudoBean.class));
		
		List<ExclusaoEstudoBean> list = query.list();
			
		return list;
		
	}

	
	private List<EventosAdversosBean> buscaEventosAdversos(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	ea.idPaciente numeroPaciente"
	    + " 	,p.iniciaisNome iniciaisNome"
	    + " 	,ea.dtInclusao dataInclusao"
	    + " 	,de.dsDoenca doenca"
	    + " 	,ea.dtInicio dataInicio"
	    + " 	,ea.dtFim dataTermino"
	    + " 	,ea.stAprovacao status"
	    + " FROM" 
	    + " 	estudomorpheos.TbEventoAdverso ea"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (ea.idPaciente = p.idPaciente)"
	    + " 	JOIN (estudomorpheos.TbDoencaEvento de) ON (ea.idDoenca = de.idDoencaEvento)"				
	    + "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataInclusao", new DateType())
		.addScalar("doenca", new StringType())
		.addScalar("dataInicio", new DateType())
		.addScalar("dataTermino", new DateType())
		.addScalar("status", new StringType())		
		.setResultTransformer(Transformers.aliasToBean(EventosAdversosBean.class));		
		List<EventosAdversosBean> list = query.list();
			
		return list;
		
	}
	
	private List<Visita00Bean> buscaMedicamentosPaciente(){
		
		Query query = this.session.createSQLQuery(""
			+ "	SELECT" 
			+ "		p.nuRegistroProtocolo numeroPaciente"
			+ "		,p.iniciaisNome iniciaisNome"
			+ "		,v.nuVisita"	
			+ "		,v.dtRealizacao dataVisita"				    
		    + "		,gm.dsGrupoMedicamento grupoMedicamento"
		    + "		,m.dsMedicamento medicamento"
		    + "		,qmed.dose dose"
		    + "		,qmed.posologia posologia"
		    + "		,qmed.observacao observacao"
		    + "	FROM "
		    + "		estudomorpheos.TbVisita v"		    
		    + "		JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		    + "		JOIN (estudomorpheos.TbQuestMedicamentoUso qmed) ON (v.idVisita = qmed.idVisita)"
		    + "		JOIN (estudomorpheos.TbMedicamento m) ON (qmed.idMedicamento = m.idMedicamento)"
		    + "		JOIN (estudomorpheos.TbGrupoMedicamento gm) ON (m.idGrupoMedicamento = gm.idGrupoMedicamento)"
			+ "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("nuVisita", new IntegerType())
		.addScalar("dataVisita", new DateType())				
		.addScalar("grupoMedicamento", new StringType())
		.addScalar("medicamento", new StringType())
		.addScalar("dose", new StringType())
		.addScalar("posologia", new StringType())
		.addScalar("observacao", new StringType())

		.setResultTransformer(Transformers.aliasToBean(MedicamentosPacientesBean.class));
		
		List<Visita00Bean> list = query.list();		
		
		return list;
		
	}
	
	
	private List<Visita00Bean> buscaVisita00(){
		
		Query query = this.session.createSQLQuery(""
			+ "	SELECT" 
			+ "		p.nuRegistroProtocolo numeroPaciente"
			+ "		,p.iniciaisNome iniciaisNome"
			+ "		,v.dtRealizacao dataVisita"
		    + "		,v0.dtAssinaturaTCLE dataAssinaturaTCLE"
		    + "		,v0.PER_V00_CI01 hipertensao"
		    + "		,v0.PER_V00_CI02 antiHipertendivo"
		    + "		,v0.PER_V00_CE01 maiorIgual65Anos"
		    + "		,v0.PER_V00_CE02 iccFEMenor45IAMAVC"
		    + "		,v0.PER_V00_CE03 creatininaMaior2mg"
		    + "		,v0.PER_V00_CE04 usuarioDrogaIlicita"
		    + "		,v0.PER_V00_CE05 usoSimpaticomimetico"
		    + "		,v0.PER_V00_CE06 usoAnticoncepcionalAINH"
		    + "		,v0.PER_V00_CE07 gravidez"
		    + "		,v0.PER_V00_CE08 paMaior180Por110"
		    + "		,v0.PER_V00_CE09 causaSecundariaHAS"
		    + "		,v0.PER_V00_CE10 imcMaiorIgual40"
		    + "		,v0.PER_V00_AA01 peso"
		    + "		,v0.PER_V00_AA02 altura"
		    + "		,v0.PER_V00_AA03 imc"
		    + "		,v0.PER_V00_AA04 circCervical"
		    + "		,v0.PER_V00_AA05 circAbdominal"
		    + "		,v0.PER_V00_AA06 circBranquial"
		    + "		,v0.PER_V00_DP01 anosRonco"
		    + "		,v0.PER_V00_DP02 aumentoPAGravidez"
		    + "		,v0.PER_V00_DP03 dislipidemia"
		    + "		,v0.PER_V00_DP04 diabetes"
		    + "		,v0.PER_V00_DP05 tabagismoAtual"
		    + "		,v0.PER_V00_DP07 cigarrosDia"
		    + "		,v0.PER_V00_DP13 exTabagista"
		    + "		,v0.PER_V00_DP06 tempoTabagismo"
		    + "		,v0.PER_V00_DP14 qtosMesesParou"
		    + "		,v0.PER_V00_DP08 obstrucaoNasalConstante"
		    + "		,v0.PER_V00_DP09 rinite"
		    + "		,v0.PER_V00_DP10 anoDiagnosticoHAS"
		    + "		,v0.PER_V00_DP11 depressao"
		    + "		,v0.PER_V00_DP12 refluxo"
		    + "		,qpre.PER_PA00 braco"
		    + "		,qpre.PER_PA01A pa01"
		    + "		,qpre.PER_PA02A pa02"
		    + "		,qpre.PER_PA03A pa03"
		    + "		,qpre.PER_PA04A pa04"
		    + "		,qpre.PER_PA05A pa05"
		    + "		,qpre.PER_PA06 mediaPA"
		    + "		,qpre.PER_PA01B fc01"
		    + "		,qpre.PER_PA02B fc02"
		    + "		,qpre.PER_PA03B fc03"
		    + "		,qpre.PER_PA04B fc04"
		    + "		,qpre.PER_PA05B fc05"
		    //+ "		,gm.dsGrupoMedicamento grupoMedicamento"
		    //+ "		,m.dsMedicamento medicamento"
		    //+ "		,qmed.dose dose"
		    //+ "		,qmed.posologia posologia"
		    //+ "		,qmed.observacao observacao"
		    + "	FROM "
		    + "		estudomorpheos.TbVisita v"
		    + "		JOIN (estudomorpheos.TbVisita00 v0) ON (v.idVisita = v0.idVisita)"
		    + "		JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		    + "		LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		    //+ "		LEFT JOIN (estudomorpheos.TbQuestMedicamentoUso qmed) ON (v.idVisita = qmed.idVisita)"
		    //+ "		LEFT JOIN (estudomorpheos.TbMedicamento m) ON (qmed.idMedicamento = m.idMedicamento)"
		    //+ "		LEFT JOIN (estudomorpheos.TbGrupoMedicamento gm) ON (m.idGrupoMedicamento = gm.idGrupoMedicamento)"
			+ "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("dataAssinaturaTCLE", new DateType())
		.addScalar("hipertensao", new StringType())
		.addScalar("antiHipertendivo", new StringType())
		.addScalar("maiorIgual65Anos", new StringType())
		.addScalar("iccFEMenor45IAMAVC", new StringType())
		.addScalar("creatininaMaior2mg", new StringType())
		.addScalar("usuarioDrogaIlicita", new StringType())
		.addScalar("usoSimpaticomimetico", new StringType())
		.addScalar("usoAnticoncepcionalAINH", new StringType())
		.addScalar("gravidez", new StringType())
		.addScalar("paMaior180Por110", new StringType())
		.addScalar("causaSecundariaHAS", new StringType())
		.addScalar("imcMaiorIgual40", new StringType())
		.addScalar("peso", new FloatType())
		.addScalar("altura", new FloatType())
		.addScalar("imc", new FloatType())
		.addScalar("circCervical", new LongType())
		.addScalar("circAbdominal", new LongType())
		.addScalar("circBranquial", new LongType())
		.addScalar("anosRonco", new LongType())
		.addScalar("aumentoPAGravidez", new LongType())
		.addScalar("dislipidemia", new StringType())
		.addScalar("diabetes", new StringType())
		.addScalar("tabagismoAtual", new StringType())
		.addScalar("cigarrosDia", new LongType())
		.addScalar("exTabagista", new StringType())
		.addScalar("tempoTabagismo", new LongType())
		.addScalar("qtosMesesParou", new LongType())
		.addScalar("obstrucaoNasalConstante", new StringType())
		.addScalar("rinite", new StringType())
		.addScalar("anoDiagnosticoHAS", new IntegerType())
		.addScalar("depressao", new StringType())
		.addScalar("refluxo", new StringType())
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		/*
		.addScalar("grupoMedicamento", new StringType())
		.addScalar("medicamento", new StringType())
		.addScalar("dose", new StringType())
		.addScalar("posologia", new StringType())
		.addScalar("observacao", new StringType())
		*/
		.setResultTransformer(Transformers.aliasToBean(Visita00Bean.class));
		
		List<Visita00Bean> list = query.list();		
		
		return list;
		
	}
	
	private List<Visita01Bean> buscaVisita01(){
	
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
	    + " 	,v.dtRealizacao dataVisita"
	    + " 	,qpolig.local local"
	    + " 	,qpolig.IAH iah"
	    + " 	,qpolig.SatBasal satO2Basal"
	    + " 	,qpolig.SatMedia satO2Media"
	    + " 	,qpolig.SatMinimo satO2Minima"
	    + " 	,qpolig.TSMenor90 tsMenor90"
	    + "     ,qpolis.qtdEventos"
	    + " 	,qpolis.latencia latencia"	    
	    + " 	,qpolis.TST tst"
	    + " 	,qpolis.pcS1 pcs1"
	    + " 	,qpolis.pcS2 pcs2"
	    + " 	,qpolis.pcS3 pcs3"
	    + " 	,qpolis.pcREM pcsRem"
	    + " 	,qpolis.IAH iahPolis"
	    + " 	,qpolis.SatBasal sat02BasalPolis"
	    + " 	,qpolis.SatMedia satO2MediaPolis"
	    + " 	,qpolis.SatMinima satO2MinimaPolis"
	    + " 	,qpolis.TSMenor90 tsMenor90Polis"
	    + " 	,qpolis.Arousals arousals"
	    + " 	FROM" 
	    + " 	estudomorpheos.TbVisita v"
	    + " 	JOIN (estudomorpheos.TbVisita01 v1) ON (v.idVisita = v1.idVisita)"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestPoligrafia qpolig) ON (v.idVisita = qpolig.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestPolissonografia qpolis) ON (v.idVisita = qpolis.idVisita)"
		+ "") 
	    .addScalar("numeroPaciente", new StringType())
	    .addScalar("iniciaisNome", new StringType())
	    .addScalar("dataVisita", new DateType())
	    .addScalar("local", new StringType())
	    .addScalar("iah", new StringType())
	    .addScalar("satO2Basal", new StringType())
	    .addScalar("satO2Media", new StringType())
	    .addScalar("satO2Minima", new StringType())
	    .addScalar("tsMenor90", new StringType())
	    .addScalar("qtdEventos", new IntegerType())
	    .addScalar("latencia", new StringType())
	    .addScalar("tst", new StringType())
	    .addScalar("pcs1", new StringType())
	    .addScalar("pcs2", new StringType())
	    .addScalar("pcs3", new StringType())
	    .addScalar("pcsRem", new StringType())
	    .addScalar("iahPolis", new StringType())
	    .addScalar("sat02BasalPolis", new StringType())
	    .addScalar("satO2MediaPolis", new StringType())
	    .addScalar("satO2MinimaPolis", new StringType())
	    .addScalar("tsMenor90Polis", new StringType())
	    .addScalar("arousals", new StringType())
	    .setResultTransformer(Transformers.aliasToBean(Visita01Bean.class));
		
		List<Visita01Bean> list = query.list();		
		
		return list;
	}
	
	
	private List<Visita02Bean> buscaVisita02(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,v2.flAdesaoTratamentoMedicamentoso adesaoMedicamentosa"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ " 	,qapl.PER_QA01 pergunta1Epworth" 
		+ " 	,qapl.PER_QA02 pergunta2Epworth"
		+ " 	,qapl.PER_QA03 pergunta3Epworth"
		+ " 	,qapl.PER_QA04 pergunta4Epworth"
		+ " 	,qapl.PER_QA05 pergunta5Epworth"
		+ " 	,qapl.PER_QA06 pergunta6Epworth"
		+ " 	,qapl.PER_QA07 pergunta7Epworth"
		+ " 	,qapl.PER_QA08 pergunta8Epworth"
		+ " 	,qapl.PER_QA09 sonolenciaExcessiva" 
		+ " 	,qapl.PER_QA10 escalaTotalEpworth"
		+ " 	,qapl.PER_QA11 qtdMediaDiariaSono" 
		+ " 	,qber.PER_QB01 pergunta1Berlim" 
		+ " 	,qber.PER_QB02 pergunta2Berlim"
		+ " 	,qber.PER_QB03 pergunta3Berlim"
		+ " 	,qber.PER_QB04 pergunta4Berlim"
		+ " 	,qber.PER_QB05 pergunta5Berlim"
		+ " 	,qber.PER_QB06 pergunta6Berlim"
		+ " 	,qber.PER_QB07 pergunta7Berlim"
		+ " 	,qber.PER_QB08 pergunta8Berlim"
		+ " 	,qber.PER_QB09A pergunta9Berlim"
		+ " 	,qber.PER_QB09B frequenciaPergunta9Berlim"
		+ " 	,qber.PER_QB10 pergunta10Berlim"
		+ " 	,qber.PER_QB11 pergunta11Berlim"
		+ " 	,qber.CAT_01 categoria1Berlim"
		+ " 	,qber.CAT_02 categoria2Berlim"
		+ " 	,qber.CAT_03 categoria3Berlim"
		+ " 	,qber.resultado finalBerlim"
		+ " 	,qcage.PER_QC01 pergunta1Cage"
		+ " 	,qcage.PER_QC02 pergunta2Cage"
		+ " 	,qcage.PER_QC03 pergunta3Cage"
		+ " 	,qcage.PER_QC04 pergunta4Cage"
		+ " 	,qcage.flPositivo positivo3Cage"
		+ " 	,qatf.PER_QI01 trabalhoRemunerado"
		+ " 	,qatf.PER_QI02 horasTrabalhadas" 
		+ " 	,qatf.PER_QI03 anosCompletosEstudo" 
		+ " 	,qatf.PER_QI04 estadoGeralSaude" 
		+ " 	,qatf.PER_QIS1A pergunta1aAtvf" 
		+ " 	,qatf.PER_QIS1B pergunta1bAtvf" 
		+ " 	,if(qatf.PER_QIS1CH  != null, qatf.PER_QIS1CH, qatf.PER_QIS1CM) pergunta1cAtvf"       
		+ " 	,qatf.PER_QIS1D pergunta1dAtvf" 
		+ " 	,if(qatf.PER_QIS1EH !=null, qatf.PER_QIS1EH, qatf.PER_QIS1EM) pergunta1eAtvf"  
		+ " 	,qatf.PER_QIS1F pergunta1fAtvf" 
		+ " 	,if(qatf.PER_QIS1GH != null, qatf.PER_QIS1GH, qatf.PER_QIS1GM) pergunta1gAtvf" 
		+ " 	,qatf.PER_QIS2A pergunta2aAtvf"  
		+ " 	,if(qatf.PER_QIS2BH != null, qatf.PER_QIS2BH, qatf.PER_QIS2BM) pergunta2bAtvf" 
		+ " 	,qatf.PER_QIS2C pergunta2cAtvf" 
		+ " 	,if(qatf.PER_QIS2DH != null, qatf.PER_QIS2DH, qatf.PER_QIS2DM) pergunta2dAtvf" 
		+ " 	,qatf.PER_QIS2E pergunta2eAtvf" 
		+ " 	,if(qatf.PER_QIS2FH != null, qatf.PER_QIS2FH, qatf.PER_QIS2FM) pergunta2fAtvf" 
		+ " 	,qatf.PER_QIS3A pergunta3aAtvf"  
		+ " 	,if(qatf.PER_QIS3BH != null,qatf.PER_QIS3BH, qatf.PER_QIS3BM) pergunta3bAtvf" 
		+ " 	,qatf.PER_QIS3C pergunta3cAtvf" 
		+ " 	,if(qatf.PER_QIS3DH != null,qatf.PER_QIS3DH, qatf.PER_QIS3DM) pergunta3dAtvf"
		+ " 	,qatf.PER_QIS3E pergunta3eAtvf"  
		+ " 	,if(qatf.PER_QIS3FH != null, qatf.PER_QIS3FH, qatf.PER_QIS3FM) pergunta3fAtvf"
		+ " 	,qatf.PER_QIS4A pergunta4aAtvf" 
		+ " 	,if(qatf.PER_QIS4BH != null, qatf.PER_QIS4BH, qatf.PER_QIS4BM) pergunta4bAtvf"
		+ " 	,qatf.PER_QIS4C pergunta4cAtvf"
		+ " 	,if(qatf.PER_QIS4DH != null, qatf.PER_QIS4DH, qatf.PER_QIS4DM) pergunta4dAtvf"
		+ " 	,qatf.PER_QIS4E pergunta4eAtvf"
		+ " 	,if(qatf.PER_QIS4FH != null, qatf.PER_QIS4FH, qatf.PER_QIS4FM) pergunta4fAtvf" 
		+ " 	,if(qatf.PER_QIS5AH != null, qatf.PER_QIS5AH, qatf.PER_QIS5AM) pergunta5aAtvf" 
		+ " 	,if(qatf.PER_QIS5BH != null, qatf.PER_QIS5BH, qatf.PER_QIS5BM) pergunta5bAtvf"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita02 v2) ON (v.idVisita = v2.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestAplicacao qapl) ON (v.idVisita = qapl.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestBerlim qber) ON (v.idVisita = qber.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestCAGE qcage) ON (v.idVisita = qcage.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestAtividadeFisica qatf) ON (v.idVisita = qatf.idVisita)"				
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("adesaoMedicamentosa", new StringType())
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("pergunta1Epworth", new LongType())
		.addScalar("pergunta2Epworth", new LongType())
		.addScalar("pergunta3Epworth", new LongType())
		.addScalar("pergunta4Epworth", new LongType())
		.addScalar("pergunta5Epworth", new LongType())
		.addScalar("pergunta6Epworth", new LongType())
		.addScalar("pergunta7Epworth", new LongType())
		.addScalar("pergunta8Epworth", new LongType())
		.addScalar("sonolenciaExcessiva", new StringType())
		.addScalar("escalaTotalEpworth", new StringType())
		.addScalar("qtdMediaDiariaSono", new LongType())
		.addScalar("pergunta1Berlim", new LongType())
		.addScalar("pergunta2Berlim", new LongType())
		.addScalar("pergunta3Berlim", new LongType())
		.addScalar("pergunta4Berlim", new LongType())
		.addScalar("pergunta5Berlim", new StringType())
		.addScalar("pergunta6Berlim", new LongType())
		.addScalar("pergunta7Berlim", new LongType())
		.addScalar("pergunta8Berlim", new LongType())
		.addScalar("pergunta9Berlim", new LongType())
		.addScalar("frequenciaPergunta9Berlim", new LongType())
		.addScalar("pergunta10Berlim", new LongType())
		.addScalar("pergunta11Berlim", new StringType())
		.addScalar("categoria1Berlim", new StringType())
		.addScalar("categoria2Berlim", new StringType())
		.addScalar("categoria3Berlim", new StringType())
		.addScalar("finalBerlim", new LongType())
		.addScalar("pergunta1Cage", new StringType())
		.addScalar("pergunta2Cage", new StringType())
		.addScalar("pergunta3Cage", new StringType())
		.addScalar("pergunta4Cage", new StringType())
		.addScalar("positivo3Cage", new StringType())
		.addScalar("trabalhoRemunerado", new StringType())
		.addScalar("horasTrabalhadas", new StringType())
		.addScalar("anosCompletosEstudo", new LongType())
		.addScalar("estadoGeralSaude", new LongType())
		.addScalar("pergunta1aAtvf", new StringType())
		.addScalar("pergunta1bAtvf", new LongType())
		.addScalar("pergunta1cAtvf", new LongType())
		.addScalar("pergunta1dAtvf", new LongType())
		.addScalar("pergunta1eAtvf", new LongType())
		.addScalar("pergunta1fAtvf", new LongType())
		.addScalar("pergunta1gAtvf", new LongType())
		.addScalar("pergunta2aAtvf", new LongType())
		.addScalar("pergunta2bAtvf", new LongType())
		.addScalar("pergunta2cAtvf", new LongType())
		.addScalar("pergunta2dAtvf", new LongType())
		.addScalar("pergunta2eAtvf", new LongType())
		.addScalar("pergunta2fAtvf", new LongType())
		.addScalar("pergunta3aAtvf", new LongType())
		.addScalar("pergunta3bAtvf", new LongType())
		.addScalar("pergunta3cAtvf", new LongType())
		.addScalar("pergunta3dAtvf", new LongType())
		.addScalar("pergunta3eAtvf", new LongType())
		.addScalar("pergunta3fAtvf", new LongType())
		.addScalar("pergunta4aAtvf", new LongType())
		.addScalar("pergunta4bAtvf", new LongType())
		.addScalar("pergunta4cAtvf", new LongType())
		.addScalar("pergunta4dAtvf", new LongType())
		.addScalar("pergunta4eAtvf", new LongType())
		.addScalar("pergunta4fAtvf", new LongType())
		.addScalar("pergunta5aAtvf", new LongType())
		.addScalar("pergunta5bAtvf", new LongType())		
		.setResultTransformer(Transformers.aliasToBean(Visita02Bean.class));

		List<Visita02Bean> list = query.list();		
		
		return list;
		
	}
	
	private List<Visita03Bean> buscaVisita03(){
			
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"    
		+ " 	,qmapa.PER_QM01 pas24" 
		+ " 	,qmapa.PER_QM06 pad24"
		+ " 	,qmapa.PER_QM11 pam24"
	    + " 	,qmapa.PER_QM16 fc24"
	    + " 	,qmapa.PER_QM02 pasVigilia" 
	    + " 	,qmapa.PER_QM07 padVigilia"
	    + " 	,qmapa.PER_QM12 pamVigilia"
	    + " 	,qmapa.PER_QM17 fcVigilia" 
	    + " 	,qmapa.PER_QM03 pasSono" 
	    + " 	,qmapa.PER_QM08 padSono" 
	    + " 	,qmapa.PER_QM13 pamSono"
	    + " 	,qmapa.PER_QM18 fcSono"
	    + " 	,qmapa.PER_QM04 pasMinSono" 
	    + " 	,qmapa.PER_QM09 padMinSono" 
	    + " 	,qmapa.PER_QM14 pamMinSono" 
	    + " 	,qmapa.PER_QM05 pas2Acordar" 
	    + " 	,qmapa.PER_QM10 pad2Acordar"
	    + " 	,qmapa.PER_QM15 pam2Acordar"
	    + " 	,qmapa.hrInicio horaInicio" 
	    + " 	,qmapa.hrTermino horaTermino"
	    + " FROM" 
	    + " 	estudomorpheos.TbVisita v"
	    + " 	JOIN (estudomorpheos.TbVisita03 v3) ON (v.idVisita = v3.idVisita)"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestMAPA qmapa) ON (v.idVisita = qmapa.idVisita)"
		+ "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("pas24", new StringType())
		.addScalar("pad24", new StringType())
		.addScalar("pam24", new StringType())
		.addScalar("fc24", new StringType())
		.addScalar("pasVigilia", new StringType())
		.addScalar("padVigilia", new StringType())
		.addScalar("pamVigilia", new StringType())
		.addScalar("fcVigilia", new StringType())
		.addScalar("pasSono", new StringType())
		.addScalar("padSono", new StringType())
		.addScalar("pamSono", new StringType())
		.addScalar("fcSono", new StringType())
		.addScalar("pasMinSono", new StringType())
		.addScalar("padMinSono", new StringType())
		.addScalar("pamMinSono", new StringType())
		.addScalar("pas2Acordar", new StringType())
		.addScalar("pad2Acordar", new StringType())
		.addScalar("pam2Acordar", new StringType())
		.addScalar("horaInicio", new StringType())
		.addScalar("horaTermino", new StringType())		
		.setResultTransformer(Transformers.aliasToBean(Visita03Bean.class));

		List<Visita03Bean> list = query.list();		
		
		return list;		
	}
	

	
	
	private List<Visita04Bean> buscaVisita04(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
	    + " 	,v.dtRealizacao dataVisita" 
	    + " 	,v4.tpGrupoRandomizacao gruporandomizacao" 
	    + " 	,v4.flAdesaoMedicamentos adesaoMedicamentosa"
	    + " 	,qeco.PER_CT01 ddv"
	    + " 	,qeco.PER_CT02 dsve"
	    + " 	,qeco.PER_CT03 espSeptal"
	    + " 	,qeco.PER_CT04 espParedePosterior"
	    + " 	,qeco.PER_CT05 espRelativaParede"
	    + " 	,qeco.PER_CT06 massaVe"
	    + " 	,qeco.PER_CT07 indiceMassaGM2"
	    + " 	,qeco.PER_CT08 indicaMassaGM"
	    + " 	,qeco.PER_CT09 triv"
	    + " 	,qeco.PER_CT10 tempoDesaceleracao"
	    + " 	,qeco.PER_CT11 velOndaEMitral"
	    + " 	,qeco.PER_CT12 velOndaAMitral"
	    + " 	,qeco.PER_CT13 relacaoEA"
	    + " 	,qeco.PER_CT14 fracaoEjecao"
	    + " 	,qeco.PER_CT15 fracaoEncurtamento"
	    + " 	,qeco.PER_CT16 indiceEsfericidadeVE"
	    + " 	,qeco.PER_CT17 diametroAorta"
	    + " 	,qeco.PER_CT18 diametroAtrioEsquerdo"
	    + " 	,qeco.PER_CT19 medDopplerMitralSE"
	    + " 	,qeco.PER_CT20 medDopplerMitralSA"
	    + " 	,qeco.PER_CT21 medDopplerMitralLE"
	    + " 	,qeco.PER_CT22 medDopplerMitralLA"
	    + " 	,qeco.PER_CT23 relacaoOndaEAS"
	    + " 	,qeco.PER_CT24 relacaoOndaEASL"
	    + " 	,qeco.PER_CT25 medRelacaoOndaEASL"
	    + " 	,qeco.PER_CT26 ondaSVD"
	    + " 	,qeco.PER_CT27 tapse"
	    + " 	,qeco.PER_CT28 diametroTVDAnel"
	    + " 	,qeco.PER_CT29 diametroTVDMedio"
	    + " 	,qeco.PER_CT30 diametroLongVD"
	    + " 	,qeco.PER_CT31 insuficienciaT"
	    + " 	,qeco.PER_CT32 psvd"
	    + " 	,qeco.PER_CT33 velMaximaVSVD"
	    + " 	,qeco.PER_CT34 insuficienciaM"
	    + " 	,qeco.PER_CT35 insuficienciaA"
	    + " 	,qeco.PER_CT36 insuficienciaP"
	    + " 	,qeco.PER_CT37 estenoseMitral"
	    + " 	,qeco.PER_CT38 gradTransMitralMed"
	    + " 	,qeco.PER_CT39 gradTransMitralMax"
	    + " 	,qeco.PER_CT40 areaMitral"
	    + " 	,qeco.PER_CT41 estenoseAortica"
	    + " 	,qeco.PER_CT42 gradTransAMed"
	    + " 	,qeco.PER_CT43 gradTransAMax"
	    + " 	,qeco.PER_CT44 areaAortica"
	    + " 	,qeco.PER_CT45 velMaxVSVE"
	    + " 	,qeco.observacao obsEco"
	    + " 	,qbio.dtProcessamentoSoro dataProcessamentoSoro"
	    + " 	,qbio.dtColeta dataColeta"
	    + " 	,qbio.PER_B01 glicemia"
	    + " 	,qbio.PER_B02 colesterol"
	    + " 	,qbio.PER_B03 ldl"
	    + " 	,qbio.PER_B04 hdl"
	    + " 	,qbio.PER_B05 trigliceridios"
	    + " 	,qbio.PER_B06 naoHDL"
	    + " 	,qbio.PER_B07 acidoUrico"
	    + " 	,qbio.PER_B08 renina"
	    + " 	,qbio.PER_B09 aldosterona"
	    + " 	,qbio.PER_B10 microalbuminuria"
	    + " 	,qbio.PER_B11 pcrUltraSensivel"    
	    + " 	,qsph.PAS pasCentral"
	    + " 	,qsph.PAD padCentral"
	    + " 	,qsph.PPC pressaoPulso"
	    + " 	,qsph.ALX augmentarion"
	    + " 	,qsph.ALX75 aix75"
	    + " 	,qsph.observacao obsSph"
	    + "	FROM"
	    + " 	estudomorpheos.TbVisita v"
	    + " 	JOIN (estudomorpheos.TbVisita04 v4) ON (v.idVisita = v4.idVisita)"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestEcocardiograma qeco) ON (v.idVisita = qeco.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestBioquimica qbio) ON (v.idVisita = qbio.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestSphygmocor qsph) ON (v.idVisita = qsph.idVisita)"				
	    + "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("gruporandomizacao", new LongType())
		.addScalar("adesaoMedicamentosa", new StringType())
		.addScalar("ddv", new StringType())
		.addScalar("dsve", new StringType())
		.addScalar("espSeptal", new StringType())
		.addScalar("espParedePosterior", new StringType())
		.addScalar("espRelativaParede", new StringType())
		.addScalar("massaVe", new StringType())
		.addScalar("indiceMassaGM2", new StringType())
		.addScalar("indicaMassaGM", new StringType())
		.addScalar("triv", new StringType())
		.addScalar("tempoDesaceleracao", new StringType())
		.addScalar("velOndaEMitral", new StringType())
		.addScalar("velOndaAMitral", new StringType())
		.addScalar("relacaoEA", new StringType())
		.addScalar("fracaoEjecao", new StringType())
		.addScalar("fracaoEncurtamento", new StringType())
		.addScalar("indiceEsfericidadeVE", new StringType())
		.addScalar("diametroAorta", new StringType())
		.addScalar("diametroAtrioEsquerdo", new StringType())
		.addScalar("medDopplerMitralSE", new StringType())
		.addScalar("medDopplerMitralSA", new StringType())
		.addScalar("medDopplerMitralLE", new StringType())
		.addScalar("medDopplerMitralLA", new StringType())
		.addScalar("relacaoOndaEAS", new StringType())
		.addScalar("relacaoOndaEASL", new StringType())
		.addScalar("medRelacaoOndaEASL", new StringType())
		.addScalar("ondaSVD", new StringType())
		.addScalar("tapse", new StringType())
		.addScalar("diametroTVDAnel", new StringType())
		.addScalar("diametroTVDMedio", new StringType())
		.addScalar("diametroLongVD", new StringType())
		.addScalar("insuficienciaT", new StringType())
		.addScalar("psvd", new StringType())
		.addScalar("velMaximaVSVD", new StringType())
		.addScalar("insuficienciaM", new StringType())
		.addScalar("insuficienciaA", new StringType())
		.addScalar("insuficienciaP", new StringType())
		.addScalar("estenoseMitral", new StringType())
		.addScalar("gradTransMitralMed", new StringType())
		.addScalar("gradTransMitralMax", new StringType())
		.addScalar("areaMitral", new StringType())
		.addScalar("estenoseAortica", new StringType())
		.addScalar("gradTransAMed", new StringType())
		.addScalar("gradTransAMax", new StringType())
		.addScalar("areaAortica", new StringType())
		.addScalar("velMaxVSVE", new StringType())
		.addScalar("obsEco", new StringType())
		.addScalar("dataProcessamentoSoro", new StringType())
		.addScalar("dataColeta", new StringType())
		.addScalar("glicemia", new StringType())
		.addScalar("colesterol", new StringType())
		.addScalar("ldl", new StringType())
		.addScalar("hdl", new StringType())
		.addScalar("trigliceridios", new StringType())
		.addScalar("naoHDL", new StringType())
		.addScalar("acidoUrico", new StringType())
		.addScalar("renina", new StringType())
		.addScalar("aldosterona", new StringType())
		.addScalar("microalbuminuria", new StringType())
		.addScalar("pcrUltraSensivel", new StringType())
		.addScalar("pasCentral", new StringType())
		.addScalar("padCentral", new StringType())
		.addScalar("pressaoPulso", new StringType())
		.addScalar("augmentarion", new StringType())
		.addScalar("aix75", new StringType())
		.addScalar("obsSph", new StringType())		
		.setResultTransformer(Transformers.aliasToBean(Visita04Bean.class));		
		List<Visita04Bean> list = query.list();
			
		return list;
		
	}

	
	private List<Visita05Bean> buscaVisita05(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ "		p.nuRegistroProtocolo numeroPaciente"
		+ "		,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ "     ,qpolis.qtdEventos"
   		+ " 	,qpolis.latencia latencia"
   		+ " 	,qpolis.TST tst"
   		+ " 	,qpolis.pcS1 pcs1"
   		+ " 	,qpolis.pcS2 pcs2"
   		+ " 	,qpolis.pcS3 pcs3"
   		+ " 	,qpolis.pcREM pcsRem"
   		+ " 	,qpolis.arquitetura"
   		+ " 	,qpolis.IAH iah"
   		+ " 	,qpolis.SatBasal sat02Basal"
   		+ " 	,qpolis.SatMedia satO2Media"
   		+ " 	,qpolis.SatMinima satO2Minima"
   		+ " 	,qpolis.TSMenor90 tsMenor90"
   		+ " 	,qpolis.Arousals arousals"
   		+ " 	,qpolis.pressaoCPAP pressaoCPAP"
   		+ " 	,qpolis.tmMascaraN nasal"
   		+ " 	,qpolis.tmMascaraNO oronasal"
   		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
   		+ " FROM"
   		+ " 	estudomorpheos.TbVisita v"
   		+ " 	JOIN (estudomorpheos.TbVisita05 v5) ON (v.idVisita = v5.idVisita)"
   		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
   		+ " 	LEFT JOIN (estudomorpheos.TbQuestPolissonografia qpolis) ON (v.idVisita = qpolis.idVisita)"
		+ "") 
	    .addScalar("numeroPaciente", new StringType())
	    .addScalar("iniciaisNome", new StringType())
	    .addScalar("dataVisita", new DateType())
	    .addScalar("qtdEventos", new IntegerType())
	    .addScalar("latencia", new StringType())
	    .addScalar("tst", new StringType())
	    .addScalar("pcs1", new StringType())
	    .addScalar("pcs2", new StringType())
	    .addScalar("pcs3", new StringType())
	    .addScalar("pcsRem", new StringType())
	    .addScalar("arquitetura", new StringType())
	    .addScalar("iah", new StringType())
	    .addScalar("sat02Basal", new StringType())
	    .addScalar("satO2Media", new StringType())
	    .addScalar("satO2Minima", new StringType())
	    .addScalar("tsMenor90", new StringType())
	    .addScalar("arousals", new StringType())
	    .addScalar("pressaoCPAP", new StringType())
	    .addScalar("nasal", new StringType())
	    .addScalar("oronasal", new StringType())
	    .addScalar("gruporandomizacao", new LongType())
	    .setResultTransformer(Transformers.aliasToBean(Visita05Bean.class));
		
		List<Visita05Bean> list = query.list();		
		
		return list;
	}
	
	
	private List<Visita06Bean> buscaVisita06(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita06 v6) ON (v.idVisita = v6.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita06Bean.class));

		List<Visita06Bean> list = query.list();		
		
		return list;
		
	}
	
	
	private List<Visita07Bean> buscaVisita07(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita07 v7) ON (v.idVisita = v7.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"		
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita07Bean.class));

		List<Visita07Bean> list = query.list();		
		
		return list;
		
	}
	
	private List<Visita08Bean> buscaVisita08(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"		
		+ " 	,qvmm.flMudancaMedicamento mudancaMedicacao"
		+ " 	,qvmm.pcAdesaoMedicacao adesaoMedicamentosa"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita08 v8) ON (v.idVisita = v8.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaMudancaMedicacao qvmm) ON (v.idVisita = qvmm.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mudancaMedicacao", new StringType())
		.addScalar("adesaoMedicamentosa", new DoubleType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita08Bean.class));

		List<Visita08Bean> list = query.list();		
		
		return list;
		
	}


	private List<Visita09Bean> buscaVisita09(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita09 v9) ON (v.idVisita = v9.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"		
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita09Bean.class));
	
		List<Visita09Bean> list = query.list();		
		
		return list;
		
	}


	private List<Visita10Bean> buscaVisita10(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita10 v10) ON (v.idVisita = v10.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"		
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita10Bean.class));
	
		List<Visita10Bean> list = query.list();		
		
		return list;
		
	}
	
	
	private List<Visita11Bean> buscaVisita11(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita11 v11) ON (v.idVisita = v11.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"		
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita11Bean.class));
	
		List<Visita11Bean> list = query.list();		
		
		return list;
		
	}
	
	
	private List<Visita12Bean> buscaVisita12(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"		
		+ " 	,qvmm.flMudancaMedicamento mudancaMedicacao"
		+ " 	,qvmm.pcAdesaoMedicacao adesaoMedicamentosa"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita12 v12) ON (v.idVisita = v12.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaMudancaMedicacao qvmm) ON (v.idVisita = qvmm.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mudancaMedicacao", new StringType())
		.addScalar("adesaoMedicamentosa", new DoubleType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita12Bean.class));

		List<Visita12Bean> list = query.list();		
		
		return list;
		
	}

	
	private List<Visita13Bean> buscaVisita13(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"		
		+ " 	,qvmm.flMudancaMedicamento mudancaMedicacao"
		+ " 	,qvmm.pcAdesaoMedicacao adesaoMedicamentosa"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita13 v13) ON (v.idVisita = v13.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaMudancaMedicacao qvmm) ON (v.idVisita = qvmm.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mudancaMedicacao", new StringType())
		.addScalar("adesaoMedicamentosa", new DoubleType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita13Bean.class));

		List<Visita13Bean> list = query.list();		
		
		return list;
		
	}

	
	private List<Visita14Bean> buscaVisita14(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"		
		+ " 	,qvmm.flMudancaMedicamento mudancaMedicacao"
		+ " 	,qvmm.pcAdesaoMedicacao adesaoMedicamentosa"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita14 v14) ON (v.idVisita = v14.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaMudancaMedicacao qvmm) ON (v.idVisita = qvmm.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())		
		.addScalar("mudancaMedicacao", new StringType())
		.addScalar("adesaoMedicamentosa", new DoubleType())		
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())		
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita14Bean.class));

		List<Visita14Bean> list = query.list();		
		
		return list;
		
	}
	

	private List<Visita15Bean> buscaVisita15(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT"
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
		+ " 	,v.dtRealizacao dataVisita"
		+ " 	,qvmm.flMudancaMedicamento mudancaMedicacao"
		+ " 	,qvmm.pcAdesaoMedicacao adesaoMedicamentosa"
		+ " 	,qat.pcMediaCPAP mediaCPAP"
		+ " 	,qat.pcAdesaoDilatador adesaoDilatador"
		+ " 	,qpre.PER_PA00 braco"
		+ " 	,qpre.PER_PA01A pa01"
		+ " 	,qpre.PER_PA02A pa02"
		+ " 	,qpre.PER_PA03A pa03"
		+ " 	,qpre.PER_PA04A pa04"
		+ " 	,qpre.PER_PA05A pa05"
		+ " 	,qpre.PER_PA06 mediaPA"
		+ " 	,qpre.PER_PA01B fc01"
		+ " 	,qpre.PER_PA02B fc02"
		+ " 	,qpre.PER_PA03B fc03"
		+ " 	,qpre.PER_PA04B fc04"
		+ " 	,qpre.PER_PA05B fc05"
		+ " 	,qapl.PER_QA01 pergunta1Epworth" 
		+ " 	,qapl.PER_QA02 pergunta2Epworth"
		+ " 	,qapl.PER_QA03 pergunta3Epworth"
		+ " 	,qapl.PER_QA04 pergunta4Epworth"
		+ " 	,qapl.PER_QA05 pergunta5Epworth"
		+ " 	,qapl.PER_QA06 pergunta6Epworth"
		+ " 	,qapl.PER_QA07 pergunta7Epworth"
		+ " 	,qapl.PER_QA08 pergunta8Epworth"
		+ " 	,qapl.PER_QA09 sonolenciaExcessiva" 
		+ " 	,qapl.PER_QA10 escalaTotalEpworth"
		+ " 	,qapl.PER_QA11 qtdMediaDiariaSono" 
		+ " 	,qber.PER_QB01 pergunta1Berlim" 
		+ " 	,qber.PER_QB02 pergunta2Berlim"
		+ " 	,qber.PER_QB03 pergunta3Berlim"
		+ " 	,qber.PER_QB04 pergunta4Berlim"
		+ " 	,qber.PER_QB05 pergunta5Berlim"
		+ " 	,qber.PER_QB06 pergunta6Berlim"
		+ " 	,qber.PER_QB07 pergunta7Berlim"
		+ " 	,qber.PER_QB08 pergunta8Berlim"
		+ " 	,qber.PER_QB09A pergunta9Berlim"
		+ " 	,qber.PER_QB09B frequenciaPergunta9Berlim"
		+ " 	,qber.PER_QB10 pergunta10Berlim"
		+ " 	,qber.PER_QB11 pergunta11Berlim"
		+ " 	,qber.CAT_01 categoria1Berlim"
		+ " 	,qber.CAT_02 categoria2Berlim"
		+ " 	,qber.CAT_03 categoria3Berlim"
		+ " 	,qber.resultado finalBerlim"
		+ " 	,qcage.PER_QC01 pergunta1Cage"
		+ " 	,qcage.PER_QC02 pergunta2Cage"
		+ " 	,qcage.PER_QC03 pergunta3Cage"
		+ " 	,qcage.PER_QC04 pergunta4Cage"
		+ " 	,qcage.flPositivo positivo3Cage"
		+ " 	,qatf.PER_QI01 trabalhoRemunerado"
		+ " 	,qatf.PER_QI02 horasTrabalhadas" 
		+ " 	,qatf.PER_QI03 anosCompletosEstudo" 
		+ " 	,qatf.PER_QI04 estadoGeralSaude" 
		+ " 	,qatf.PER_QIS1A pergunta1aAtvf" 
		+ " 	,qatf.PER_QIS1B pergunta1bAtvf" 
		+ " 	,if(qatf.PER_QIS1CH  != null, qatf.PER_QIS1CH, qatf.PER_QIS1CM) pergunta1cAtvf"       
		+ " 	,qatf.PER_QIS1D pergunta1dAtvf" 
		+ " 	,if(qatf.PER_QIS1EH !=null, qatf.PER_QIS1EH, qatf.PER_QIS1EM) pergunta1eAtvf"  
		+ " 	,qatf.PER_QIS1F pergunta1fAtvf" 
		+ " 	,if(qatf.PER_QIS1GH != null, qatf.PER_QIS1GH, qatf.PER_QIS1GM) pergunta1gAtvf" 
		+ " 	,qatf.PER_QIS2A pergunta2aAtvf"  
		+ " 	,if(qatf.PER_QIS2BH != null, qatf.PER_QIS2BH, qatf.PER_QIS2BM) pergunta2bAtvf" 
		+ " 	,qatf.PER_QIS2C pergunta2cAtvf" 
		+ " 	,if(qatf.PER_QIS2DH != null, qatf.PER_QIS2DH, qatf.PER_QIS2DM) pergunta2dAtvf" 
		+ " 	,qatf.PER_QIS2E pergunta2eAtvf" 
		+ " 	,if(qatf.PER_QIS2FH != null, qatf.PER_QIS2FH, qatf.PER_QIS2FM) pergunta2fAtvf" 
		+ " 	,qatf.PER_QIS3A pergunta3aAtvf"  
		+ " 	,if(qatf.PER_QIS3BH != null,qatf.PER_QIS3BH, qatf.PER_QIS3BM) pergunta3bAtvf" 
		+ " 	,qatf.PER_QIS3C pergunta3cAtvf" 
		+ " 	,if(qatf.PER_QIS3DH != null,qatf.PER_QIS3DH, qatf.PER_QIS3DM) pergunta3dAtvf"
		+ " 	,qatf.PER_QIS3E pergunta3eAtvf"  
		+ " 	,if(qatf.PER_QIS3FH != null, qatf.PER_QIS3FH, qatf.PER_QIS3FM) pergunta3fAtvf"
		+ " 	,qatf.PER_QIS4A pergunta4aAtvf" 
		+ " 	,if(qatf.PER_QIS4BH != null, qatf.PER_QIS4BH, qatf.PER_QIS4BM) pergunta4bAtvf"
		+ " 	,qatf.PER_QIS4C pergunta4cAtvf"
		+ " 	,if(qatf.PER_QIS4DH != null, qatf.PER_QIS4DH, qatf.PER_QIS4DM) pergunta4dAtvf"
		+ " 	,qatf.PER_QIS4E pergunta4eAtvf"
		+ " 	,if(qatf.PER_QIS4FH != null, qatf.PER_QIS4FH, qatf.PER_QIS4FM) pergunta4fAtvf" 
		+ " 	,if(qatf.PER_QIS5AH != null, qatf.PER_QIS5AH, qatf.PER_QIS5AM) pergunta5aAtvf" 
		+ " 	,if(qatf.PER_QIS5BH != null, qatf.PER_QIS5BH, qatf.PER_QIS5BM) pergunta5bAtvf"
		+ "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
		+ " 	FROM" 
		+ " 	estudomorpheos.TbVisita v"
		+ " 	JOIN (estudomorpheos.TbVisita15 v15) ON (v.idVisita = v15.idVisita)"
		+ " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaMudancaMedicacao qvmm) ON (v.idVisita = qvmm.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbVisitaAdesaoTratamento qat) ON (v.idVisita = qat.idVisita)"				
		+ " 	LEFT JOIN (estudomorpheos.TbQuestPressaoArterial qpre) ON (v.idVisita = qpre.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestAplicacao qapl) ON (v.idVisita = qapl.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestBerlim qber) ON (v.idVisita = qber.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestCAGE qcage) ON (v.idVisita = qcage.idVisita)"
		+ " 	LEFT JOIN (estudomorpheos.TbQuestAtividadeFisica qatf) ON (v.idVisita = qatf.idVisita)"				
		+ "") 
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("mudancaMedicacao", new StringType())
		.addScalar("adesaoMedicamentosa", new DoubleType())
		.addScalar("mediaCPAP", new DoubleType())
		.addScalar("adesaoDilatador", new DoubleType())
		.addScalar("braco", new StringType())
		.addScalar("pa01", new StringType())
		.addScalar("pa02", new StringType())
		.addScalar("pa03", new StringType())
		.addScalar("pa04", new StringType())
		.addScalar("pa05", new StringType())
		.addScalar("mediaPA", new StringType())
		.addScalar("fc01", new LongType())
		.addScalar("fc02", new LongType())
		.addScalar("fc03", new LongType())
		.addScalar("fc04", new LongType())
		.addScalar("fc05", new LongType())
		.addScalar("pergunta1Epworth", new LongType())
		.addScalar("pergunta2Epworth", new LongType())
		.addScalar("pergunta3Epworth", new LongType())
		.addScalar("pergunta4Epworth", new LongType())
		.addScalar("pergunta5Epworth", new LongType())
		.addScalar("pergunta6Epworth", new LongType())
		.addScalar("pergunta7Epworth", new LongType())
		.addScalar("pergunta8Epworth", new LongType())
		.addScalar("sonolenciaExcessiva", new StringType())
		.addScalar("escalaTotalEpworth", new StringType())
		.addScalar("qtdMediaDiariaSono", new LongType())
		.addScalar("pergunta1Berlim", new LongType())
		.addScalar("pergunta2Berlim", new LongType())
		.addScalar("pergunta3Berlim", new LongType())
		.addScalar("pergunta4Berlim", new LongType())
		.addScalar("pergunta5Berlim", new StringType())
		.addScalar("pergunta6Berlim", new LongType())
		.addScalar("pergunta7Berlim", new LongType())
		.addScalar("pergunta8Berlim", new LongType())
		.addScalar("pergunta9Berlim", new LongType())
		.addScalar("frequenciaPergunta9Berlim", new LongType())
		.addScalar("pergunta10Berlim", new LongType())
		.addScalar("pergunta11Berlim", new StringType())
		.addScalar("categoria1Berlim", new StringType())
		.addScalar("categoria2Berlim", new StringType())
		.addScalar("categoria3Berlim", new StringType())
		.addScalar("finalBerlim", new LongType())
		.addScalar("pergunta1Cage", new StringType())
		.addScalar("pergunta2Cage", new StringType())
		.addScalar("pergunta3Cage", new StringType())
		.addScalar("pergunta4Cage", new StringType())
		.addScalar("positivo3Cage", new StringType())
		.addScalar("trabalhoRemunerado", new StringType())
		.addScalar("horasTrabalhadas", new StringType())
		.addScalar("anosCompletosEstudo", new LongType())
		.addScalar("estadoGeralSaude", new LongType())
		.addScalar("pergunta1aAtvf", new StringType())
		.addScalar("pergunta1bAtvf", new LongType())
		.addScalar("pergunta1cAtvf", new LongType())
		.addScalar("pergunta1dAtvf", new LongType())
		.addScalar("pergunta1eAtvf", new LongType())
		.addScalar("pergunta1fAtvf", new LongType())
		.addScalar("pergunta1gAtvf", new LongType())
		.addScalar("pergunta2aAtvf", new LongType())
		.addScalar("pergunta2bAtvf", new LongType())
		.addScalar("pergunta2cAtvf", new LongType())
		.addScalar("pergunta2dAtvf", new LongType())
		.addScalar("pergunta2eAtvf", new LongType())
		.addScalar("pergunta2fAtvf", new LongType())
		.addScalar("pergunta3aAtvf", new LongType())
		.addScalar("pergunta3bAtvf", new LongType())
		.addScalar("pergunta3cAtvf", new LongType())
		.addScalar("pergunta3dAtvf", new LongType())
		.addScalar("pergunta3eAtvf", new LongType())
		.addScalar("pergunta3fAtvf", new LongType())
		.addScalar("pergunta4aAtvf", new LongType())
		.addScalar("pergunta4bAtvf", new LongType())
		.addScalar("pergunta4cAtvf", new LongType())
		.addScalar("pergunta4dAtvf", new LongType())
		.addScalar("pergunta4eAtvf", new LongType())
		.addScalar("pergunta4fAtvf", new LongType())
		.addScalar("pergunta5aAtvf", new LongType())
		.addScalar("pergunta5bAtvf", new LongType())
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita15Bean.class));

		List<Visita15Bean> list = query.list();		
		
		return list;
		
	}


	private List<Visita16Bean> buscaVisita16(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
	    + " 	,v.dtRealizacao dataVisita" 
		+ " 	,qmapa.PER_QM01 pas24" 
		+ " 	,qmapa.PER_QM06 pad24"
		+ " 	,qmapa.PER_QM11 pam24"
	    + " 	,qmapa.PER_QM16 fc24"
	    + " 	,qmapa.PER_QM02 pasVigilia" 
	    + " 	,qmapa.PER_QM07 padVigilia"
	    + " 	,qmapa.PER_QM12 pamVigilia"
	    + " 	,qmapa.PER_QM17 fcVigilia" 
	    + " 	,qmapa.PER_QM03 pasSono" 
	    + " 	,qmapa.PER_QM08 padSono" 
	    + " 	,qmapa.PER_QM13 pamSono"
	    + " 	,qmapa.PER_QM18 fcSono"
	    + " 	,qmapa.PER_QM04 pasMinSono" 
	    + " 	,qmapa.PER_QM09 padMinSono" 
	    + " 	,qmapa.PER_QM14 pamMinSono" 
	    + " 	,qmapa.PER_QM05 pas2Acordar" 
	    + " 	,qmapa.PER_QM10 pad2Acordar"
	    + " 	,qmapa.PER_QM15 pam2Acordar"
	    + " 	,qmapa.hrInicio horaInicio" 
	    + " 	,qmapa.hrTermino horaTermino"	    
		+ " 	,qeco.PER_CT01 ddv"
	    + " 	,qeco.PER_CT02 dsve"
	    + " 	,qeco.PER_CT03 espSeptal"
	    + " 	,qeco.PER_CT04 espParedePosterior"
	    + " 	,qeco.PER_CT05 espRelativaParede"
	    + " 	,qeco.PER_CT06 massaVe"
	    + " 	,qeco.PER_CT07 indiceMassaGM2"
	    + " 	,qeco.PER_CT08 indicaMassaGM"
	    + " 	,qeco.PER_CT09 triv"
	    + " 	,qeco.PER_CT10 tempoDesaceleracao"
	    + " 	,qeco.PER_CT11 velOndaEMitral"
	    + " 	,qeco.PER_CT12 velOndaAMitral"
	    + " 	,qeco.PER_CT13 relacaoEA"
	    + " 	,qeco.PER_CT14 fracaoEjecao"
	    + " 	,qeco.PER_CT15 fracaoEncurtamento"
	    + " 	,qeco.PER_CT16 indiceEsfericidadeVE"
	    + " 	,qeco.PER_CT17 diametroAorta"
	    + " 	,qeco.PER_CT18 diametroAtrioEsquerdo"
	    + " 	,qeco.PER_CT19 medDopplerMitralSE"
	    + " 	,qeco.PER_CT20 medDopplerMitralSA"
	    + " 	,qeco.PER_CT21 medDopplerMitralLE"
	    + " 	,qeco.PER_CT22 medDopplerMitralLA"
	    + " 	,qeco.PER_CT23 relacaoOndaEAS"
	    + " 	,qeco.PER_CT24 relacaoOndaEASL"
	    + " 	,qeco.PER_CT25 medRelacaoOndaEASL"
	    + " 	,qeco.PER_CT26 ondaSVD"
	    + " 	,qeco.PER_CT27 tapse"
	    + " 	,qeco.PER_CT28 diametroTVDAnel"
	    + " 	,qeco.PER_CT29 diametroTVDMedio"
	    + " 	,qeco.PER_CT30 diametroLongVD"
	    + " 	,qeco.PER_CT31 insuficienciaT"
	    + " 	,qeco.PER_CT32 psvd"
	    + " 	,qeco.PER_CT33 velMaximaVSVD"
	    + " 	,qeco.PER_CT34 insuficienciaM"
	    + " 	,qeco.PER_CT35 insuficienciaA"
	    + " 	,qeco.PER_CT36 insuficienciaP"
	    + " 	,qeco.PER_CT37 estenoseMitral"
	    + " 	,qeco.PER_CT38 gradTransMitralMed"
	    + " 	,qeco.PER_CT39 gradTransMitralMax"
	    + " 	,qeco.PER_CT40 areaMitral"
	    + " 	,qeco.PER_CT41 estenoseAortica"
	    + " 	,qeco.PER_CT42 gradTransAMed"
	    + " 	,qeco.PER_CT43 gradTransAMax"
	    + " 	,qeco.PER_CT44 areaAortica"
	    + " 	,qeco.PER_CT45 velMaxVSVE"
	    + " 	,qeco.observacao obsEco"
	    + " 	,qbio.dtProcessamentoSoro dataProcessamentoSoro"
	    + " 	,qbio.dtColeta dataColeta"
	    + " 	,qbio.PER_B01 glicemia"
	    + " 	,qbio.PER_B02 colesterol"
	    + " 	,qbio.PER_B03 ldl"
	    + " 	,qbio.PER_B04 hdl"
	    + " 	,qbio.PER_B05 trigliceridios"
	    + " 	,qbio.PER_B06 naoHDL"
	    + " 	,qbio.PER_B07 acidoUrico"
	    + " 	,qbio.PER_B08 renina"
	    + " 	,qbio.PER_B09 aldosterona"
	    + " 	,qbio.PER_B10 microalbuminuria"
	    + " 	,qbio.PER_B11 pcrUltraSensivel"    
	    + " 	,qsph.PAS pasCentral"
	    + " 	,qsph.PAD padCentral"
	    + " 	,qsph.PPC pressaoPulso"
	    + " 	,qsph.ALX augmentarion"
	    + " 	,qsph.ALX75 aix75"
	    + " 	,qsph.observacao obsSph"
	    + "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
	    + "	FROM"
	    + " 	estudomorpheos.TbVisita v"
	    + " 	JOIN (estudomorpheos.TbVisita16 v16) ON (v.idVisita = v16.idVisita)"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestMAPA qmapa) ON (v.idVisita = qmapa.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestEcocardiograma qeco) ON (v.idVisita = qeco.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestBioquimica qbio) ON (v.idVisita = qbio.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestSphygmocor qsph) ON (v.idVisita = qsph.idVisita)"				
	    + "")
		.addScalar("numeroPaciente", new StringType())
		.addScalar("iniciaisNome", new StringType())
		.addScalar("dataVisita", new DateType())
		.addScalar("pas24", new StringType())
		.addScalar("pad24", new StringType())
		.addScalar("pam24", new StringType())
		.addScalar("fc24", new StringType())
		.addScalar("pasVigilia", new StringType())
		.addScalar("padVigilia", new StringType())
		.addScalar("pamVigilia", new StringType())
		.addScalar("fcVigilia", new StringType())
		.addScalar("pasSono", new StringType())
		.addScalar("padSono", new StringType())
		.addScalar("pamSono", new StringType())
		.addScalar("fcSono", new StringType())
		.addScalar("pasMinSono", new StringType())
		.addScalar("padMinSono", new StringType())
		.addScalar("pamMinSono", new StringType())
		.addScalar("pas2Acordar", new StringType())
		.addScalar("pad2Acordar", new StringType())
		.addScalar("pam2Acordar", new StringType())
		.addScalar("horaInicio", new StringType())
		.addScalar("horaTermino", new StringType())
		.addScalar("ddv", new StringType())
		.addScalar("dsve", new StringType())
		.addScalar("espSeptal", new StringType())
		.addScalar("espParedePosterior", new StringType())
		.addScalar("espRelativaParede", new StringType())
		.addScalar("massaVe", new StringType())
		.addScalar("indiceMassaGM2", new StringType())
		.addScalar("indicaMassaGM", new StringType())
		.addScalar("triv", new StringType())
		.addScalar("tempoDesaceleracao", new StringType())
		.addScalar("velOndaEMitral", new StringType())
		.addScalar("velOndaAMitral", new StringType())
		.addScalar("relacaoEA", new StringType())
		.addScalar("fracaoEjecao", new StringType())
		.addScalar("fracaoEncurtamento", new StringType())
		.addScalar("indiceEsfericidadeVE", new StringType())
		.addScalar("diametroAorta", new StringType())
		.addScalar("diametroAtrioEsquerdo", new StringType())
		.addScalar("medDopplerMitralSE", new StringType())
		.addScalar("medDopplerMitralSA", new StringType())
		.addScalar("medDopplerMitralLE", new StringType())
		.addScalar("medDopplerMitralLA", new StringType())
		.addScalar("relacaoOndaEAS", new StringType())
		.addScalar("relacaoOndaEASL", new StringType())
		.addScalar("medRelacaoOndaEASL", new StringType())
		.addScalar("ondaSVD", new StringType())
		.addScalar("tapse", new StringType())
		.addScalar("diametroTVDAnel", new StringType())
		.addScalar("diametroTVDMedio", new StringType())
		.addScalar("diametroLongVD", new StringType())
		.addScalar("insuficienciaT", new StringType())
		.addScalar("psvd", new StringType())
		.addScalar("velMaximaVSVD", new StringType())
		.addScalar("insuficienciaM", new StringType())
		.addScalar("insuficienciaA", new StringType())
		.addScalar("insuficienciaP", new StringType())
		.addScalar("estenoseMitral", new StringType())
		.addScalar("gradTransMitralMed", new StringType())
		.addScalar("gradTransMitralMax", new StringType())
		.addScalar("areaMitral", new StringType())
		.addScalar("estenoseAortica", new StringType())
		.addScalar("gradTransAMed", new StringType())
		.addScalar("gradTransAMax", new StringType())
		.addScalar("areaAortica", new StringType())
		.addScalar("velMaxVSVE", new StringType())
		.addScalar("obsEco", new StringType())
		.addScalar("dataProcessamentoSoro", new StringType())
		.addScalar("dataColeta", new StringType())
		.addScalar("glicemia", new StringType())
		.addScalar("colesterol", new StringType())
		.addScalar("ldl", new StringType())
		.addScalar("hdl", new StringType())
		.addScalar("trigliceridios", new StringType())
		.addScalar("naoHDL", new StringType())
		.addScalar("acidoUrico", new StringType())
		.addScalar("renina", new StringType())
		.addScalar("aldosterona", new StringType())
		.addScalar("microalbuminuria", new StringType())
		.addScalar("pcrUltraSensivel", new StringType())
		.addScalar("pasCentral", new StringType())
		.addScalar("padCentral", new StringType())
		.addScalar("pressaoPulso", new StringType())
		.addScalar("augmentarion", new StringType())
		.addScalar("aix75", new StringType())
		.addScalar("obsSph", new StringType())		
		.addScalar("gruporandomizacao", new LongType())
		.setResultTransformer(Transformers.aliasToBean(Visita16Bean.class));		
		List<Visita16Bean> list = query.list();
			
		return list;
		
	}


	private List<Visita17Bean> buscaVisita17(){
		
		Query query = this.session.createSQLQuery(""
		+ " SELECT" 
		+ " 	p.nuRegistroProtocolo numeroPaciente"
		+ " 	,p.iniciaisNome iniciaisNome"
	    + " 	,v.dtRealizacao dataVisita"
	    + " 	,qpolig.local local"
	    + " 	,qpolig.IAH iah"
	    + " 	,qpolig.SatBasal satO2Basal"
	    + " 	,qpolig.SatMedia satO2Media"
	    + " 	,qpolig.SatMinimo satO2Minima"
	    + " 	,qpolig.TSMenor90 tsMenor90"
	    + "     ,qpolis.qtdEventos"
	    + " 	,qpolis.latencia latencia"
	    + " 	,qpolis.TST tst"
	    + " 	,qpolis.pcS1 pcs1"
	    + " 	,qpolis.pcS2 pcs2"
	    + " 	,qpolis.pcS3 pcs3"
	    + " 	,qpolis.pcREM pcsRem"
	    + " 	,qpolis.IAH iahPolis"
	    + " 	,qpolis.SatBasal sat02BasalPolis"
	    + " 	,qpolis.SatMedia satO2MediaPolis"
	    + " 	,qpolis.SatMinima satO2MinimaPolis"
	    + " 	,qpolis.TSMenor90 tsMenor90Polis"
	    + " 	,qpolis.Arousals arousals"
	    + "     ,(select tpGrupoRandomizacao from estudomorpheos.TbVisita04 a, estudomorpheos.TbVisita b where a.idVisita = b.idVisita and b.idPaciente = v.idPaciente and b.nuVisita = 4) as gruporandomizacao"
	    + " 	FROM" 
	    + " 	estudomorpheos.TbVisita v"
	    + " 	JOIN (estudomorpheos.TbVisita17 v17) ON (v.idVisita = v17.idVisita)"
	    + " 	JOIN (estudomorpheos.TbPaciente p) ON (v.idPaciente = p.idPaciente)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestPoligrafia qpolig) ON (v.idVisita = qpolig.idVisita)"
	    + " 	LEFT JOIN (estudomorpheos.TbQuestPolissonografia qpolis) ON (v.idVisita = qpolis.idVisita)"
		+ "") 
	    .addScalar("numeroPaciente", new StringType())
	    .addScalar("iniciaisNome", new StringType())
	    .addScalar("dataVisita", new DateType())
	    .addScalar("local", new StringType())
	    .addScalar("iah", new StringType())
	    .addScalar("satO2Basal", new StringType())
	    .addScalar("satO2Media", new StringType())
	    .addScalar("satO2Minima", new StringType())
	    .addScalar("tsMenor90", new StringType())
	    .addScalar("qtdEventos", new IntegerType())
	    .addScalar("latencia", new StringType())
	    .addScalar("tst", new StringType())
	    .addScalar("pcs1", new StringType())
	    .addScalar("pcs2", new StringType())
	    .addScalar("pcs3", new StringType())
	    .addScalar("pcsRem", new StringType())
	    .addScalar("iahPolis", new StringType())
	    .addScalar("sat02BasalPolis", new StringType())
	    .addScalar("satO2MediaPolis", new StringType())
	    .addScalar("satO2MinimaPolis", new StringType())
	    .addScalar("tsMenor90Polis", new StringType())
	    .addScalar("arousals", new StringType())
	    .addScalar("gruporandomizacao", new LongType())
	    .setResultTransformer(Transformers.aliasToBean(Visita17Bean.class));
		
		List<Visita17Bean> list = query.list();		
		
		return list;
	}
	
}
