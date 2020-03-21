package br.com.morpheos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.morpheos.dao.common.GenericDao;
import br.com.morpheos.dto.EstatisticasDTO;
import br.com.morpheos.entity.PacienteEntity;
import br.com.morpheos.entity.UnidadeAtendimentoEntity;

public class PacienteDao extends GenericDao<PacienteEntity> {

	public PacienteDao(Session session){
		super(session);
	}

	@SuppressWarnings("unchecked")
	public List<PacienteEntity> busca(String termo){
		List<PacienteEntity> pacientes = session.createCriteria(PacienteEntity.class)
			   .add(  
					   Restrictions.or(   
							   Restrictions.or(  
									   Restrictions.ilike("nome", "%" + termo.toLowerCase() + "%"),  
                                       Restrictions.ilike("iniciaisNome","%" + termo.toLowerCase() + "%")  
                               ),  
                               Restrictions.or(  
                            		   Restrictions.eq("cpf", termo.trim().replaceAll("[.-]", "")),  
                            		   Restrictions.eq("numRegistro", termo.trim()) 
                               )                            
                        )  
                    ) 
               .list();
		return pacientes;
	}
	
	public PacienteEntity buscaPorCpf(String cpf){
		PacienteEntity paciente = (PacienteEntity)session.createCriteria(PacienteEntity.class)
			   .add(Restrictions.eq("cpf", cpf.trim().replaceAll("[.-]", ""))) 
               .uniqueResult();
		return paciente;
	}
	
	@SuppressWarnings("unchecked")
	public List<PacienteEntity> buscaPorUnidade(String termo, Long idUnidade){
		
		Criteria criteria = session.createCriteria(PacienteEntity.class).createAlias("unidade", "u");
				if(termo != null){
					criteria.add(  
						Restrictions.or(   
								Restrictions.or(  
										Restrictions.ilike("nome", "%" + termo.toLowerCase() + "%"),  
										Restrictions.ilike("iniciaisNome","%" + termo.toLowerCase() + "%")  
								),  
								Restrictions.or(  
										Restrictions.eq("cpf", termo.trim().replaceAll("[.-]", "")),  
										Restrictions.eq("numRegistro", termo.trim()) 
                                )                            
                        )  
                    ); 
				}
				criteria.add( Restrictions.eq("u.idUnidadePesquisa", idUnidade))
			.list();

		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countPacientesGroupByStatus(){
		 List<Object[]> rows = session.createCriteria(PacienteEntity.class)
			.setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.groupProperty("ativo") )
			).list();
		 
		 List<EstatisticasDTO> retorno = new ArrayList<EstatisticasDTO>();
		 
		 for (Object[] row : rows) {
			 EstatisticasDTO reg = new EstatisticasDTO();
			 reg.setCount((Integer) row[0]);
			 reg.setValor((String) row[1]);
			 retorno.add(reg);			 
		 }
		 
		 return retorno;
		 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EstatisticasDTO> countPacientesGroupByUnidade(){
		 List<Object[]> rows = session.createCriteria(PacienteEntity.class)
			.setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.groupProperty("unidade") )
			).list();
		 
		 List<EstatisticasDTO> retorno = new ArrayList<EstatisticasDTO>();
		 
		 for (Object[] row : rows) {
			 EstatisticasDTO reg = new EstatisticasDTO();
			 reg.setCount((Integer) row[0]);
			 reg.setValor(((UnidadeAtendimentoEntity) row[1]).getDsUnidade());
			 retorno.add(reg);			 
		 }
		 
		 return retorno;
		 
	}
	
}
