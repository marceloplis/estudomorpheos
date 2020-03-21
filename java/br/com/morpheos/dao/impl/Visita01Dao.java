package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita01Entity;

public class Visita01Dao extends GenericDao<Visita01Entity>{

	public Visita01Dao(Session session){
		super(session);
	}


}
