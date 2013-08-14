package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cordys.example.domain.onetomanymanytoone.bidirection.joincolumn.Department;

public class TestCreteriaQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		printDepartments(manager);
		// Non-Entity Query
		printDepartmentNames(manager);
		
		// Multi-select Query
		printDepartmentNamesAndIDs(manager);
		
		transaction.commit();
		manager.close();
		factory.close();
	}
	
	public static void printDepartmentNamesAndIDs(EntityManager manager) {
		{
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Object[]> qDef = builder.createQuery(Object[].class);
			Root<Department> root = qDef.from(Department.class);
			qDef.select(builder.array(root.get("deptName"), root.get("id")));
			System.out.println(manager.createQuery(qDef).getResultList().get(0));
		}
    }

	public static void printDepartments(EntityManager manager) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Department> qdef = builder.createQuery(Department.class);
		Root<Department> root = qdef.from(Department.class);
		qdef.select(root);
		System.out.println(manager.createQuery(qdef).getResultList());
	}
	
	
	public static void printDepartmentNames(EntityManager manager) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> qDef = builder.createQuery(String.class);
		Root<Department> root = qDef.from(Department.class);
		qDef.select(root.<String>get("deptName"));
		System.out.println(manager.createQuery(qDef).getResultList().get(0));
	}

}
