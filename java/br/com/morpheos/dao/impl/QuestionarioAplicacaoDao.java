package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.QuestAplicacaoEntity;

public class QuestionarioAplicacaoDao extends GenericDao<QuestAplicacaoEntity>{

	public QuestionarioAplicacaoDao(Session session){
		super(session);
	}

}
