package br.com.morpheos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.LogAuditoriaEstudoEntity;

public class LogAuditoriaVisitaDao extends GenericDao<LogAuditoriaEstudoEntity>{

	public LogAuditoriaVisitaDao(Session session){
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<LogAuditoriaEstudoEntity> buscaLogs(String idPaciente, String tpEntidade, String tpModificaocao){
		
		List<LogAuditoriaEstudoEntity> retorno = new ArrayList<LogAuditoriaEstudoEntity>();
		
		Criteria criteria = this.session.createCriteria(LogAuditoriaEstudoEntity.class).createAlias("paciente", "p");
		addRestrictionIfNotNull(criteria, "p.idPaciente", idPaciente);
		addRestrictionIfNotNull(criteria, "tpModificacao", tpModificaocao);
		addRestrictionIfNotNull(criteria, "tpEntidade", tpEntidade);
		retorno = criteria.list();
		
		return retorno;
	}

	private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
	    if (value != null && !value.equals("")) {
	        criteria.add(Restrictions.eq(propertyName, value));
	    }
	}
	
}
