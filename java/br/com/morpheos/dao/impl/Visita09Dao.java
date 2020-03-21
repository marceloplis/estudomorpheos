package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita09Entity;

public class Visita09Dao extends GenericDao<Visita09Entity>{

	public Visita09Dao(Session session){
		super(session);
	}


}
