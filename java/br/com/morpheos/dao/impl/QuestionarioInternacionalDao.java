package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestAtividadeFisicaEntity;

public class QuestionarioInternacionalDao extends GenericDao<QuestAtividadeFisicaEntity>{

	public QuestionarioInternacionalDao(Session session){
		super(session);
	}

}
