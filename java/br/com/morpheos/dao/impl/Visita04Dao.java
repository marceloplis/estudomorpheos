package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita04Entity;

public class Visita04Dao extends GenericDao<Visita04Entity>{

	public Visita04Dao(Session session){
		super(session);
	}


}
