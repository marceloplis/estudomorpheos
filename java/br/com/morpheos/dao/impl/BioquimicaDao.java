package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestBioquimicaEntity;

public class BioquimicaDao extends GenericDao<QuestBioquimicaEntity>{

	public BioquimicaDao(Session session){
		super(session);
	}

}
