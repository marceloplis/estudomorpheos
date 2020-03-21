package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestPressaoArterialEntity;

public class PressaoArterialDao extends GenericDao<QuestPressaoArterialEntity>{

	public PressaoArterialDao(Session session){
		super(session);
	}

}
