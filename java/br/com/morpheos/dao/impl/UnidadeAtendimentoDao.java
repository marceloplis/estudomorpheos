package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class UnidadeAtendimentoDao extends GenericDao<UnidadeAtendimentoEntity>{

	public UnidadeAtendimentoDao(Session session){
		super(session);
	}
	
}
