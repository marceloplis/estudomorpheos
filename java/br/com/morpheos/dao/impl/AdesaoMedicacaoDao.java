package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.AdesaoMedicacaoEntity;

public class AdesaoMedicacaoDao extends GenericDao<AdesaoMedicacaoEntity>{

	public AdesaoMedicacaoDao(Session session){
		super(session);
	}

}
