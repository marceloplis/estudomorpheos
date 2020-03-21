package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita03Entity;

public class Visita03Dao extends GenericDao<Visita03Entity>{

	public Visita03Dao(Session session){
		super(session);
	}


}
