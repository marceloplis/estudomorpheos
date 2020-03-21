package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita17Entity;

public class Visita17Dao extends GenericDao<Visita17Entity>{

	public Visita17Dao(Session session){
		super(session);
	}

}
