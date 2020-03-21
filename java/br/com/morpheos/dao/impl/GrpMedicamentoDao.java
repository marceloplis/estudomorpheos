package br.com.morpheos.dao.impl;

import org.hibernate.Session;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.entity.GrupoMedicamentoEntity;

public class GrpMedicamentoDao extends GenericDao<GrupoMedicamentoEntity>{

	public GrpMedicamentoDao(Session session){
		super(session);
	}

}
