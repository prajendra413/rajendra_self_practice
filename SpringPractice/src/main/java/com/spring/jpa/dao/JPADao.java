package com.spring.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "jpaDao")
@Transactional(propagation= Propagation.REQUIRED)
public class JPADao implements IJPADao {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public <T> void createEntity(T t) {
		entityManager.persist(t);
		flushToDatabase();
	}

	@Override
	public <T> void updateEntity(T t) {
		entityManager.merge(t);
		flushToDatabase();
	}

	@Override
	public <T> void deleteEntity(T t) {
		entityManager.remove(t);
		flushToDatabase();
	}

	@Override
    public <T> T findEntity(Class<T> entityClass, int id) {
	   return entityManager.find(entityClass, id);
    }
	
	private void flushToDatabase() {
		entityManager.flush();
	}

}
