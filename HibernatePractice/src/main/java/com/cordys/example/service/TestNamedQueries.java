package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;

public class TestNamedQueries {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		// Named parameters. Mention named parameters at entity level with @NamedParameters and @NamedParameter.
		TypedQuery<Passport> passport = manager.createNamedQuery("Passport.findById", Passport.class);
		passport.setParameter("id", 11);
		System.out.println(passport.getSingleResult().getPassportNo());

		transaction.commit();
		
		manager.close();
		factory.close();
	}

}
