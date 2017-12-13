package com.kossine.ims.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kossine.ims.models.Inventory;

@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericRepo<T extends Inventory> implements IGenericRepo<T> {

	private static final Logger log = LoggerFactory.getLogger(GenericRepo.class);

	protected Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;
 
	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(long id){
//		log.debug("*******trying to fetch enitity ***** "+ clazz.getSimpleName() );
		T t;
		t=entityManager.find(clazz, id);
//		log.debug("Entity fetched "+ t);
	 return t; 
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		
		entityManager.remove(entity);
	}

	public void deleteById(long entityId){
		T entity = findOne(entityId);

		delete(entity);
	}
}