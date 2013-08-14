package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;

public class TestQueryParameters {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		// Named Parameters
		TypedQuery<Passport> namedPassport = manager
						.createQuery(
								"from Passport_EM p where p.passportId =:Id and p.passportNo = :No",
								Passport.class);
		namedPassport.setParameter("Id", 11)
				.setParameter("No", "5678")
				.getSingleResult().getPassportId();

		// Ordinal Parameters
		
		TypedQuery<Passport> ordinalParameter = manager
				.createQuery(
						"from Passport_EM p where p.passportId =?1 and p.passportNo = ?2",
						Passport.class);
		ordinalParameter.setParameter(1, 11)
						.setParameter(2, "5678")
						.getSingleResult().getPassportId();
		
		transaction.commit();
		
		manager.close();
		factory.close();
		
		
	}

}
