package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita00Entity;

public class Visita00Dao extends GenericDao<Visita00Entity>{

	public Visita00Dao(Session session){
		super(session);
	}

}
