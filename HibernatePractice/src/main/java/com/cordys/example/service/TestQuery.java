package com.cordys.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cordys.example.domain.onetoone.unidirection.joincolumn.Passport;
import com.cordys.example.domain.onetoone.unidirection.joincolumn.Person;

public class TestQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		/*TypedQuery<OrderDetail> orderDetail = manager.createQuery("from OrderDetail od where od.amount > ?1", OrderDetail.class);
		orderDetail.setParameter(1, 50);*/
		
		/*TypedQuery<OrderDetail> orderDetail = manager.createQuery("from OrderDetail od where od.amount between ?1 and ?2", OrderDetail.class);
		orderDetail.setParameter(1, 50);
		orderDetail.setParameter(2, 800);*/
		
		/*TypedQuery<OrderDetail> orderDetail = manager.createQuery("from OrderDetail od where od.amount not in (?1, ?2)", OrderDetail.class);
		orderDetail.setParameter(1, 100);
		orderDetail.setParameter(2, 78);
		
		for(OrderDetail detail :orderDetail.getResultList())
		{
			System.out.println(detail.getOrderDetailId());
			System.out.println(detail.getAmount());
		}*/
		
		/*TypedQuery<Order> orders = manager.createQuery("from Order o where size(o.orderDetails) > ?1", Order.class);
		orders.setParameter(1, 2);
		for(Order order :orders.getResultList())
		{
			System.out.println(order.getOrderid());
			System.out.println(order.getOrderName());
			System.out.println(order.getOrderDetails().get(0).getAmount());
		}*/
		
		// Implicit association joins
		
		/*TypedQuery<Employee> employees = manager.createQuery("from Employee emp where emp.department.deptName like 'En%'",Employee.class);
		for(Employee employee :employees.getResultList())
		{
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getStudentName());
		}*/
		
		// Joins expressed in the FROM clause
		
		/*TypedQuery<Object[]> pairs = manager.createQuery("from Department dept join dept.students emp  where dept.deptName like 'En%' and emp.studentName = 'Rajendra'",Object[].class);
		for(Object[] pair :pairs.getResultList())
		{
			Department dept = (Department)pair[0];
			
			System.out.println(dept.getDeptName());
			System.out.println(dept.getId());
			System.out.println(dept.getStudents().get(0).getStudentName());
		}*/
		
		// Theta-style joins
		
		/*// All queries results the same.
		TypedQuery<Object[]> personDetails = manager.createQuery("from Person per, Passport passport", Object[].class);
		TypedQuery<Object[]> personDetails = manager.createQuery("from Person per, Passport pass where per.passport = pass", Object[].class);
		TypedQuery<Object[]> personDetails = manager.createQuery("from Person per join per.passport pass", Object[].class);
		
		for(Object[] pair :personDetails.getResultList())
		{
			Person per = (Person)pair[0];
			
			System.out.println(per.getPersonId());
			System.out.println("-------------------------");
			Passport pass = (Passport)pair[1];
			System.out.println(pass.getPassportId());
			System.out.println(pass.getPassportNo());
		}*/
		
		// Reporting queries
		
		/*TypedQuery<String> personDetails = manager.createQuery("Select per.name, per from Person per group by per.name", String.class);
		
		for(String pair :personDetails.getResultList())
		{
			System.out.println(pair);
		}*/
		
		TypedQuery<Object[]> personDetails = manager.createQuery("Select per.name, per from Person per group by per.name", Object[].class);
		
		for(Object[] pair :personDetails.getResultList())
		{
			System.out.println((String)pair[0]);
			System.out.println((Person)pair[1]);
		}
		
		transaction.commit();
		manager.close();
		factory.close();

	}

}

