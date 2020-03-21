package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita14Entity;

public class Visita14Dao extends GenericDao<Visita14Entity>{

	public Visita14Dao(Session session){
		super(session);
	}

}
