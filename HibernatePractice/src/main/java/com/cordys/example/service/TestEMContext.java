package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;

public class TestEMContext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Passport passport = new Passport();
		
		passport.setPassportId(8);
		passport.setPassportNo("80809");
		
		/*
		 * Transient state to persist state
		 */
		manager.persist(passport); 
		//manager.persist(passport);  // No impact
		/*
		 * Insert / Update / Delete wil be executed.
		 */
		manager.flush(); // Insert will be fired.
		//manager.persist(passport); // No Impact
		passport.setPassportNo("1234");
		manager.flush(); // Update will be fired
		
		/*
		 * Entity will be synchronized to database
		 * SQL Command will be executed.
		 * Insert / Update / Delete wil be executed if flush is not invoked on EntityManager.
		 * Transaction commit will be triggered.
		 */
		transaction.commit(); // Commit will be fired
		transaction.commit(); // Transaction not active error will come.
		manager.close();
	}
}