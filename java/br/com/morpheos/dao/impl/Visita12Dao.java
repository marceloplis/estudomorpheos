package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita12Entity;

public class Visita12Dao extends GenericDao<Visita12Entity>{

	public Visita12Dao(Session session){
		super(session);
	}

}
