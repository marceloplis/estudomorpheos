package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita08Entity;

public class Visita08Dao extends GenericDao<Visita08Entity>{

	public Visita08Dao(Session session){
		super(session);
	}


}
