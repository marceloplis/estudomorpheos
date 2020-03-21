package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestPolissonografiaEntity;

public class PolissonografiaDao extends GenericDao<QuestPolissonografiaEntity>{

	public PolissonografiaDao(Session session){
		super(session);
	}

}
