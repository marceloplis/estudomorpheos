package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestSphygmocorEntity;

public class SphygmocorDao extends GenericDao<QuestSphygmocorEntity>{

	public SphygmocorDao(Session session){
		super(session);
	}

}
