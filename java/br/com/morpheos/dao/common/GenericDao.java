package br.com.morpheos.dao.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDao <T>{  
    
	protected 	final Session 	session;
	private 	final Class<T> 	classe;
	
	@SuppressWarnings("unchecked")
	public GenericDao(Session session){
		this.session = session;
		this.classe  = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void adiciona(T u){
		this.session.save(u);
		this.session.flush();
		this.session.clear();
	}
	
	public void altera(T u){
		this.session.flush();
		this.session.clear();
		this.session.update(u);
	}
	
	public void remove(T u){
		this.session.delete(u);
		this.session.flush();
		this.session.clear();
	}
	
	public void atualiza(T u){
		this.session.merge(u);
		this.session.flush();
		this.session.clear();
	}
	
	public void SaveOrUpdate(T u){
		this.session.saveOrUpdate(u);
		this.session.flush();
		this.session.clear();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaTudo(){
		return this.session.createCriteria(this.classe).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	@SuppressWarnings("unchecked")
	public T procura(Long id){
		return (T) session.get(this.classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> FiltrarPorComlumn(String column , Object value){  
		return (List<T>) this.session.createCriteria(this.classe).add(Restrictions.eq(column , value)).list();  
	}	
	
	@SuppressWarnings("unchecked")
	public T buscaVisitaByPaciente(Long idPaciente, Integer nuVisita){
		return (T) this.session.createCriteria(this.classe).createAlias("visita", "v").createAlias("visita.paciente", "p").add(Restrictions.eq("p.idPaciente", idPaciente)).add(Restrictions.eq("v.nuVisita", nuVisita)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public T buscaQuestionarioByVisita(Long idVisita){
		return (T) this.session.createCriteria(this.classe).createAlias("visita", "v").add(Restrictions.eq("v.idVisita", idVisita)).uniqueResult();
	}
	
	protected Session getSession(){
		return session;
	}

  
}  
