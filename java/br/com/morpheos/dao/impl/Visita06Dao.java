package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita06Entity;

public class Visita06Dao extends GenericDao<Visita06Entity>{

	public Visita06Dao(Session session){
		super(session);
	}


}
