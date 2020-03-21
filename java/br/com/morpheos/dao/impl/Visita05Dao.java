package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita05Entity;

public class Visita05Dao extends GenericDao<Visita05Entity>{

	public Visita05Dao(Session session){
		super(session);
	}


}
