package br.com.morpheos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.VisitaEntity;

public class VisitaDao extends GenericDao<VisitaEntity>{

	public VisitaDao(Session session){
		super(session);
	}

	public VisitaEntity buscaVisita(Long idPaciente, Integer nuVisita){
		return (VisitaEntity) this.session.createCriteria(VisitaEntity.class).createAlias("paciente", "p").add(Restrictions.eq("p.idPaciente", idPaciente)).add(Restrictions.eq("nuVisita", nuVisita)).uniqueResult();
	}
	
	public VisitaEntity buscaVisita(Long idVisita){
		return (VisitaEntity) this.session.createCriteria(VisitaEntity.class).add(Restrictions.eq("idVisita", idVisita)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<VisitaEntity> buscaVisitasByPaciente(Long idPaciente){
		return this.session.createCriteria(VisitaEntity.class).createAlias("paciente", "p").add(Restrictions.eq("p.idPaciente", idPaciente)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<VisitaEntity> buscaVisitasPendentes(Integer idUnidade){
		
		List<VisitaEntity> retorno = new ArrayList<VisitaEntity>();
		
		if(idUnidade == 0){
			retorno = this.session.createCriteria(VisitaEntity.class).createAlias("paciente", "p").add(Restrictions.or(Restrictions.isNull("p.ativo"), Restrictions.eq("p.ativo", "S"))).add(Restrictions.or(Restrictions.eq("stAprovacao", "P"), Restrictions.isNull("stAprovacao"))).list();
		}else{
			retorno = this.session.createCriteria(VisitaEntity.class).createAlias("paciente", "p").add(Restrictions.and(Restrictions.eq("p.unidade.idUnidadePesquisa", idUnidade.longValue()), Restrictions.or(Restrictions.isNull("p.ativo"), Restrictions.eq("p.ativo", "S")))).list();
		}
		
		return retorno;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<VisitaEntity> buscaVisitasRelatorio(Long idUnidade, Long idPaciente){
		
		List<VisitaEntity> listRelatorio = new ArrayList<VisitaEntity>();
		
		StringBuffer hql = new StringBuffer();
		hql.append(" select u.dsUnidade, ");
		hql.append("		p.iniciaisNome, ");
		hql.append("		p.cpf, ");
		hql.append("		v.nuVisita, ");
		hql.append("		DATE_FORMAT(v.dtRealizacao,'%m/%d/%Y'), ");
		hql.append(" 		(select count(1) from TbQuestAplicacao qa 			where qa.idVisita = v.idVisita)  as has_questaplic, ");
		hql.append("	   	(select count(1) from TbQuestAtividadeFisica qaf	where qaf.idVisita = v.idVisita) as has_questaticfis, ");
		hql.append("   		(select count(1) from TbQuestBerlim qb 				where qb.idVisita = v.idVisita)  as has_questberl, ");
		hql.append(" 		(select count(1) from TbQuestBioquimica qbq 		where qbq.idVisita = v.idVisita) as has_questbioq, ");
		hql.append("		(select count(1) from TbQuestCAGE qc 				where qc.idVisita = v.idVisita)  as has_questcage, ");
		hql.append("		(select count(1) from TbQuestEcocardiograma qe 		where qe.idVisita = v.idVisita)  as has_questeco, ");
		hql.append("		(select count(1) from TbQuestMAPA qm 				where qm.idVisita = v.idVisita)  as has_questmapa, ");
		hql.append(" 		(select count(1) from TbQuestMedicamentoUso qmu 	where qmu.idVisita = v.idVisita) as has_questmedic, ");
		hql.append("		(select count(1) from TbQuestPoligrafia qp 			where qp.idVisita = v.idVisita)  as has_questpolig, ");
		hql.append(" 		(select count(1) from TbQuestPolissonografia qpg 	where qpg.idVisita = v.idVisita) as has_questpoliss, ");
		hql.append(" 		(select count(1) from TbQuestPressaoArterial qpa 	where qpa.idVisita = v.idVisita) as has_questpressao, ");
		hql.append("		(select count(1) from TbQuestSphygmocor qs 			where qs.idVisita = v.idVisita)  as has_questsphy ");      
		hql.append("   from TbPaciente p, ");
		hql.append("		TbVisita v, ");
		hql.append(" 		TbUnidadePesquisa u ");
		hql.append("  where p.idPaciente = v.idPaciente ");
		hql.append("	and p.idUnidadePesquisa = u.idUnidadePesquisa ");
		if(idPaciente != null && idPaciente > 0)
		hql.append("	and p.idPaciente = "+idPaciente);
		if(idUnidade != null && idUnidade > 0)
		hql.append("	and p.idUnidadePesquisa = "+ idUnidade);
		hql.append("  order by u.dsUnidade, p.iniciaisNome, v.nuVisita");
		 
		Query query = session.createSQLQuery(hql.toString());
		List<Object[]> listResult = query.list();
		 
		for (Object[] aRow : listResult) {
			VisitaEntity visita = new VisitaEntity();
			visita.getPaciente().getUnidade().setDsUnidade(aRow[0].toString());
			visita.getPaciente().setIniciaisNome(aRow[1].toString());
			visita.getPaciente().setCpf(aRow[2].toString());
			visita.setNuVisita(new Integer(aRow[3].toString()));
			visita.setDtRealizacaoParse(aRow[4].toString());
			visita.setHas_questaplic(new Integer(aRow[5].toString()));
			visita.setHas_questaticfis(new Integer(aRow[6].toString()));
			visita.setHas_questberl(new Integer(aRow[7].toString()));
			visita.setHas_questbioq(new Integer(aRow[8].toString()));
			visita.setHas_questcage(new Integer(aRow[9].toString()));
			visita.setHas_questeco(new Integer(aRow[10].toString()));
			visita.setHas_questmapa(new Integer(aRow[11].toString()));
			visita.setHas_questmedic(new Integer(aRow[12].toString()));
			visita.setHas_questpolig(new Integer(aRow[13].toString()));
			visita.setHas_questpoliss(new Integer(aRow[14].toString()));
			visita.setHas_questpressao(new Integer(aRow[15].toString()));
			visita.setHas_questsphy(new Integer(aRow[16].toString()));     

			listRelatorio.add(visita);
		}
		
		return listRelatorio;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countPacientesGroupByVisitas(){
		 List<Object[]> rows = session.createCriteria(VisitaEntity.class)
			.setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.groupProperty("nuVisita") )
			).list();
		 
		 List<EstatisticasDTO> retorno = new ArrayList<EstatisticasDTO>();
		 
		 for (Object[] row : rows) {
			 EstatisticasDTO reg = new EstatisticasDTO();
			 reg.setCount((Integer) row[0]);
			 reg.setValor(((Integer) row[1]).toString());
			 retorno.add(reg);			 
		 }
		 
		 return retorno;
		 
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countVisitasGroupByStatus(){
		 List<Object[]> rows = session.createCriteria(VisitaEntity.class)
			.setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.groupProperty("stAprovacao") )
			).list();
		 
		 List<EstatisticasDTO> retorno = new ArrayList<EstatisticasDTO>();
		 
		 for (Object[] row : rows) {
			 EstatisticasDTO reg = new EstatisticasDTO();
			 reg.setCount((Integer) row[0]);
			 reg.setValor((String) row[1]);
			 retorno.add(reg);			 
		 }
		 
		 return retorno;
		 
	}
	
	
}
