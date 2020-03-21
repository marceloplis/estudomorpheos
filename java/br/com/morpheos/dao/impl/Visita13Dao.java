package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita13Entity;

public class Visita13Dao extends GenericDao<Visita13Entity>{

	public Visita13Dao(Session session){
		super(session);
	}

}
