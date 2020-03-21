package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestEcocardiogramaEntity;

public class EcocardiogramaDao extends GenericDao<QuestEcocardiogramaEntity>{

	public EcocardiogramaDao(Session session){
		super(session);
	}

}
