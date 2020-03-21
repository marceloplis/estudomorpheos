package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.Visita02Entity;

public class Visita02Dao extends GenericDao<Visita02Entity>{

	public Visita02Dao(Session session){
		super(session);
	}


}
