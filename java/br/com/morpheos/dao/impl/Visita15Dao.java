package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita15Entity;

public class Visita15Dao extends GenericDao<Visita15Entity>{

	public Visita15Dao(Session session){
		super(session);
	}

}
