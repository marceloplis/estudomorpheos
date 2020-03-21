package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestMapaEntity;

public class QuestionarioMapaDao extends GenericDao<QuestMapaEntity>{

	public QuestionarioMapaDao(Session session){
		super(session);
	}

}
