package com.spring.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository(value = "jpaDao")
public class JPADao implements IJPADao {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public <T> void createEntity(T t) {
		//EntityTransaction transaction = entityManager.getTransaction();
		//transaction.begin();
		entityManager.persist(t);
		//transaction.commit();
		
	}

	@Override
	public <T> void updateEntity(T t) {
		entityManager.merge(t);
	}

	@Override
	public <T> void deleteEntity(T t) {
		entityManager.remove(t);
	}

}
