package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestCageEntity;

public class QuestionarioCageDao extends GenericDao<QuestCageEntity>{

	public QuestionarioCageDao(Session session){
		super(session);
	}

}
