package com.cordys.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cordys.example.domain.onetomanymanytoone.bidirection.joincolumn.Department;

public class TestNativeQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Query nativeQuery = manager.createNativeQuery("Select dept.* from department dept", Department.class);

		@SuppressWarnings("unchecked")
		List<Department> departments = nativeQuery.getResultList();
		for(Department department : departments) {
			System.out.println(department.getDeptName());
		}
		
		transaction.commit();
		manager.close();
		factory.close();

	}

}
