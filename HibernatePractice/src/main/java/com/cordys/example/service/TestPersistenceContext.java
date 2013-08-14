package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;

public class TestPersistenceContext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Passport passport = new Passport(); // Object state is transient
		
		passport.setPassportId(10);
		passport.setPassportNo("80809");
		
		/*
		 * Transient state to persist state
		 */
		manager.persist(passport); // Object state is persistent
		
		//manager.persist(passport);  // No impact
		/*
		 * Insert / Update / Delete wil be executed.
		 */
		manager.flush(); // Insert will be fired.
		
		passport.setPassportNo("1234");
		
		manager.flush(); // Update will be fired
		
		/*
		 * Entity will be synchronized to database
		 * SQL Command will be executed.
		 * Insert / Update / Delete wil be executed if flush is not invoked on EntityManager.
		 * Transaction commit will be triggered.
		 */
		transaction.commit(); // Commit will be fired
		//transaction.commit(); // Transaction not active error will come.
		
		transaction.begin();

		manager.remove(passport); // Object state is removed.
		
		manager.flush(); // Delete will be executed
		
		passport.setPassportNo("5678"); 
		
		manager.persist(passport); // Object state is persistent
		manager.flush(); // Insert will be fired.
		transaction.commit(); // Commit will be fired.
		
		manager.close();
		
		/*manager.remove(passport); // EntityManager is close error will come.
		manager.flush();*/
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(passport); // Select will be fired to get the load the persistence entity from database and merge the detached entity with persistence entity.
		manager.flush(); // No SQL statement will be fired as there is no changes to persistence entity
		transaction.commit();*/
		
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		passport.setPassportNo("9012");
		transaction.begin();
		manager.merge(passport); // Select will be fired to get the load the persistence entity from database and merge the detached entity with persistence entity if record exists in database.
		manager.flush(); // Update will be fired as there is no changes to persistence entity
		transaction.commit();*/
		
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(passport);
		manager.remove(passport); // Removing detached instance error will come.
		manager.flush();
		transaction.commit();
		manager.close();*/
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(passport); // Select will be fired to get the load the persistence entity from database and merge the detached entity with persistence entity.
		manager.flush(); // Insert will be fired if select query returns nothing.
		transaction.commit();
		manager.close();*/
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		Passport passport1 = new Passport();
		passport1.setPassportId(11);
		passport1.setPassportNo("1234");
		manager.merge(passport1); // Select will be fired.
		manager.flush();  // Insert will be fired if select returns null.
		transaction.commit();
		manager.close();*/
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		Passport passport1 = new Passport(); //Object state is transient
		passport1.setPassportId(11);
		passport1.setPassportNo("1234");
		manager.persist(passport1); Object state is persist
		manager.flush();
		manager.remove(passport1); // Object state will be removed 
		manager.flush();  // delete will be fired.
		transaction.commit();
		manager.close();
		*/
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(passport1); // Select will be fired
		manager.flush();  // insert will be fired
		transaction.commit();
		manager.close();*/
		
		/*manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		Passport passport1 = new Passport();
		passport1.setPassportId(11);
		passport1.setPassportNo("1234");
		manager.flush();	// Nothing will be fired as passort1 is transient object
		transaction.commit();
		manager.close();*/
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		Passport passport1 = new Passport(); //Object state is transient.
		passport1.setPassportId(11);
		passport1.setPassportNo("1234");
		manager.persist(passport1); // Object state is persistent.
		manager.flush();	//insert will be fired. 
		transaction.commit();
		manager.close();
		
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		
		manager.find(Passport.class, 11);
		passport1.setPassportNo("5678");
		
		/*Passport passport3 = */ manager.merge(passport1);
		//manager.persist(passport3); // Optional
		manager.flush();	//Update will be fired.
		transaction.commit();
		manager.close();
		
		
		
	}
}