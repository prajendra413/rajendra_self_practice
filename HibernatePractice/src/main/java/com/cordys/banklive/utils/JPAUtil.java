package com.cordys.banklive.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "JPA";
	private static EntityManagerFactory  transactionManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public JPAUtil()
	{
		entityManager = transactionManagerFactory.createEntityManager();
	}
	
	/**
	 * Begins transaction
	 */
	public void beginTransaction()
	{
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	
	/**
	 * Inserts object
	 * @param t
	 */
	public <T> void persist(T t)
	{
		entityManager.persist(t);
	}
	
	public <T> T find(Class<T> clazz, Object primaryKey)
	{
		return entityManager.find(clazz, primaryKey);
	}
	
	public <T> void remove(T t)
	{
		entityManager.remove(t);
	}
	
	/**
	 * Commits transaction
	 */
	public void commitTransaction()
	{
		if(entityTransaction == null)
		{
			throw new RuntimeException("It seems transaction is not started. start transaction first");
		}
		entityTransaction.commit();
	}
	
	/**
	 * Rollback transaction.
	 */
	public void rollbackTransaction()
	{
		if(entityTransaction == null)
		{
			throw new RuntimeException("It seems transaction is not started. start transaction first");
		}
		entityTransaction.rollback();
	}
	
	/**
	 *  Close / Clear the Entity manager configurations.
	 */
	public void shutDown()
	{
		if(entityManager != null)
		{
			entityManager.close();
		}
	}

}
