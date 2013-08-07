package com.cordys.apna.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private String persistenceUniteName;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public JPAUtil(String persistenceUnitName)
	{
		this.persistenceUniteName = persistenceUnitName;
	}
	
	/**
	 * Begins transaction
	 */
	public void beginTransaction()
	{
		entityTransaction = getEntityManager().getTransaction();
		entityTransaction.begin();
	}
	
	/**
	 * Inserts object
	 * @param t
	 */
	public <T extends Object>void persist(T t)
	{
		getEntityManager().persist(t);
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
	
	private EntityManager getEntityManager()
	{
		if(entityManager == null)
		{
			entityManager =  Persistence.createEntityManagerFactory(persistenceUniteName).createEntityManager();
		}
		return entityManager;
	}

}
