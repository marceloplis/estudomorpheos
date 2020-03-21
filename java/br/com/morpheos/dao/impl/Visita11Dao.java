package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita11Entity;

public class Visita11Dao extends GenericDao<Visita11Entity>{

	public Visita11Dao(Session session){
		super(session);
	}

}
