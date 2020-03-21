package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestBerlimEntity;

public class QuestionarioBerlimDao extends GenericDao<QuestBerlimEntity>{

	public QuestionarioBerlimDao(Session session){
		super(session);
	}

}
