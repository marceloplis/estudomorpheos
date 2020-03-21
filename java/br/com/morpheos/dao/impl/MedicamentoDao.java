package br.com.morpheos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.MedicamentoEntity;

public class MedicamentoDao extends GenericDao<MedicamentoEntity>{

	public MedicamentoDao(Session session){
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicamentoEntity> buscaMedicamentosByGrupo(Long idGrupo){
		return this.session.createCriteria(MedicamentoEntity.class).createAlias("grpMedicamento", "g").add(Restrictions.eq("g.idGrupoMedicamento", idGrupo)).list();
	}
	
	public Integer countMedicamentoByGrupo(Long idGrupoMedicamento){
		Criteria criteria = this.session.createCriteria(MedicamentoEntity.class).createAlias("grpMedicamento","g").add(Restrictions.eq("g.idGrupoMedicamento", idGrupoMedicamento));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

}
