package br.com.morpheos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.SaidaEstudoEntity;

public class SaidaEstudoDao extends GenericDao<SaidaEstudoEntity>{

	public SaidaEstudoDao(Session session){
		super(session);
	}
	
	public SaidaEstudoEntity buscaByPaciente(Long idPaciente){
		return (SaidaEstudoEntity) this.session.createCriteria(SaidaEstudoEntity.class).createAlias("paciente", "p").add(Restrictions.eq("p.idPaciente", idPaciente)).uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SaidaEstudoEntity> buscaSaidasPendentes(Integer idUnidade){
		
		List<SaidaEstudoEntity> retorno = new ArrayList<SaidaEstudoEntity>();
		
		if(idUnidade == 0){
			retorno = this.session.createCriteria(SaidaEstudoEntity.class).add(Restrictions.or(Restrictions.eq("stAprovacao", "P"), Restrictions.isNull("stAprovacao"))).list();
		}else{
			retorno = this.session.createCriteria(SaidaEstudoEntity.class).createAlias("paciente", "p").add(Restrictions.eq("p.unidade.idUnidadePesquisa", idUnidade.longValue())).list();
		}
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countSaidasGroupByStatus(){
		 List<Object[]> rows = session.createCriteria(SaidaEstudoEntity.class)
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
