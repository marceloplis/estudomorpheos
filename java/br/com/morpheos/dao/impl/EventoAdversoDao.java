package br.com.morpheos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.EventoAdversoEntity;

public class EventoAdversoDao extends GenericDao<EventoAdversoEntity>{

	public EventoAdversoDao(Session session){
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<EventoAdversoEntity> buscaEventosByPaciente(Object value){
		List<EventoAdversoEntity> listEventos = this.session.createCriteria(EventoAdversoEntity.class).createAlias("paciente", "p").add(Restrictions.eq("p.idPaciente", value)).list();
		return listEventos;
	}
	
	@SuppressWarnings("unchecked")
	public List<EventoAdversoEntity> buscaEventosPendentes(Integer idUnidade){
		
		List<EventoAdversoEntity> retorno = new ArrayList<EventoAdversoEntity>();
		
		if(idUnidade == 0){
			retorno = this.session.createCriteria(EventoAdversoEntity.class).createAlias("paciente", "p").add(Restrictions.or(Restrictions.isNull("p.ativo"), Restrictions.eq("p.ativo", "S"))).add(Restrictions.or(Restrictions.eq("stAprovacao", "P"), Restrictions.isNull("stAprovacao"))).list();
		}else{
			retorno = this.session.createCriteria(EventoAdversoEntity.class).createAlias("paciente", "p").add(Restrictions.and(Restrictions.eq("p.unidade.idUnidadePesquisa", idUnidade.longValue()), Restrictions.or(Restrictions.isNull("p.ativo"), Restrictions.eq("p.ativo", "S")))).list();
		}
		
		return retorno;
	}
	
	public Integer countEventosByDoenca(Long idDoencaEvento){
		Criteria criteria = this.session.createCriteria(EventoAdversoEntity.class).createAlias("doenca","d").add(Restrictions.eq("d.idDoencaEvento", idDoencaEvento));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countEventosGroupByStatus(){
		 List<Object[]> rows = session.createCriteria(EventoAdversoEntity.class)
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
