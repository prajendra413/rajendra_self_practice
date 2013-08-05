package com.hibernate.service;

import org.hibernate.Session;
import com.hibernate.domain.Student;

public class StudentService {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Student s = new Student();
		s.setId(3);	
		s.setName("Rajendra");
		s.setMobileNo(1234);
		
		session.save(s);
		session.flush();
		
		tx.commit();
		
		session.close();
		
		HibernateUtil.shutDown();
		
	}
	
}
