package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita10Entity;

public class Visita10Dao extends GenericDao<Visita10Entity>{

	public Visita10Dao(Session session){
		super(session);
	}


}
