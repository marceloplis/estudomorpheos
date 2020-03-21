package br.com.morpheos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestMedicamentoUsoEntity;

public class MedicamentoUsoDao extends GenericDao<QuestMedicamentoUsoEntity>{

	public MedicamentoUsoDao(Session session){
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestMedicamentoUsoEntity> buscaMedicamentosUsoByVisita(Long idVisita){
		return this.session.createCriteria(QuestMedicamentoUsoEntity.class).createAlias("visita", "v").add(Restrictions.eq("v.idVisita", idVisita)).list();
	}
	
	public Integer countUsoByMedicamento(Long idMedicamento){
		Criteria criteria = this.session.createCriteria(QuestMedicamentoUsoEntity.class).createAlias("medicamento","m").add(Restrictions.eq("m.idMedicamento", idMedicamento));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

}
