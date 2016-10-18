package ci.innovlabs.PoissonnerieCore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.core.GenericTypeResolver;

import ci.innovlabs.PoissonnerieCore.ConnectionManager;

public abstract class DAO<T> {

	public EntityManager entityManager = ConnectionManager.getInstance();
	private Class<T> genericType;
	
	@SuppressWarnings("unchecked")
	public DAO() {
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), DAO.class);
	}
	
	public List<T> findAll(){
		entityManager.getTransaction().begin();
		List<T> data = entityManager.createQuery("from " + genericType.getName(), genericType).getResultList();
		entityManager.getTransaction().commit();
		
		return data;
	}
	
	public T find(long id){
		entityManager.getTransaction().begin();
		T data = entityManager.find(genericType, id);
		entityManager.getTransaction().commit();
		
		return data;
	}
	
	public T createOrUpdate(T entity){
		entityManager.getTransaction().begin();	
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return entity;
	}
	
	public void delete(T entity){
		entityManager.getTransaction().begin();	
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}
	
}
