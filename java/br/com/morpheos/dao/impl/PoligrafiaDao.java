package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestPoligrafiaEntity;

public class PoligrafiaDao extends GenericDao<QuestPoligrafiaEntity>{

	public PoligrafiaDao(Session session){
		super(session);
	}

}
