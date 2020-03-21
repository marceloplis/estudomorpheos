package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.DoencaEventoEntity;

public class DoencaEventoDao extends GenericDao<DoencaEventoEntity>{

	public DoencaEventoDao(Session session){
		super(session);
	}
	
}
