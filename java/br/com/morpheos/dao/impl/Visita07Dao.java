package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita07Entity;

public class Visita07Dao extends GenericDao<Visita07Entity>{

	public Visita07Dao(Session session){
		super(session);
	}


}
