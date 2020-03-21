package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.AdesaoTratamentoEntity;

public class AdesaoTratamentoDao extends GenericDao<AdesaoTratamentoEntity>{

	public AdesaoTratamentoDao(Session session){
		super(session);
	}
	
}
