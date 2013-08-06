package com.hibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.domain.Customer;

public class CustomerService {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Customer cust = new Customer();
		cust.setName("Rajendra");
		cust.setEmail("prajendra@cordys.com");
		
		em.persist(cust);
		
		tx.commit();
		em.close();
	}

}
