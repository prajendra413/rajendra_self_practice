package com.cordys.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;

public class TestRunningQueries {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		//manager.find(Passport.class, 10); // Transaction is optional.
		
		/**
		 * If name attribute of Entity annotation is exists then value of name attribute can be mentioned here.
		 * or fully qualified name of entity class can be mentioned.
		 * If name attribute is not mentioned then class name can be mentioned.
		 */
		TypedQuery<Passport> p = manager.createQuery("Select p from  com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport p", Passport.class); // Transaction and select p are optional.
		// Flush will be happened at query execution time. If it is commit then flush will be happened at commit.
		p.setFlushMode(FlushModeType.AUTO);
		// Retrieves first 5 records.
		p.setFirstResult(0);
		p.setMaxResults(5);
		
		List<Passport> results = p.getResultList();
		for(Passport passport : results) {
			System.out.println(passport.getPassportId());
			System.out.println(passport.getPassportNo());
		}
		
		p.setFirstResult(6);
		p.setMaxResults(10);
		
		results = p.getResultList();
		for(Passport passport : results) {
			System.out.println(passport.getPassportId());
			System.out.println(passport.getPassportNo());
		}
		
		
		TypedQuery<Long> count = manager.createQuery("Select count(p) from Passport_EM p", Long.class); // Transaction is optional. // 
		System.out.println(count.getSingleResult());
		
		/*TypedQuery<Integer> passportIdQuery = manager.createQuery("Select p.passportId from Passport_EM p", Integer.class); // Transaction is optional.
		
		for(Integer id : passportIdQuery.getResultList()) {
			System.out.println(id);
		}*/
		
		System.out.println(manager.createQuery("Delete from Passport_EM p where p.passportId = 10").executeUpdate());
		transaction.commit();
		manager.close();
		factory.close();
		
		// TODO Auto-generated method stub
	}

}
