package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita16Entity;

public class Visita16Dao extends GenericDao<Visita16Entity>{

	public Visita16Dao(Session session){
		super(session);
	}

}
