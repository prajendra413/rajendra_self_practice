package com.spring.jpa.controller;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;
import com.spring.jpa.service.IJPAService;

public class TestJPA {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("jpa/jpaApplicationContext.xml");
		IJPAService jpaService = appContext.getBean("jpaService", IJPAService.class);
		
		//try {
			Passport p = new Passport();
			p.setPassportId(14);
			p.setPassportNo("1234");
			jpaService.createPassport(p);
		/*}
		catch(DataAccessException e) {
			System.out.println("DataAccessException");
		}
		catch(PersistenceException e) {
			System.out.println("Persistence Exception");
		}*/
		
		/*Passport p1 = jpaService.findPassport(1);
		p1.setPassportNo("12345");
		
		jpaService.updatePassport(p1);*/
		
		//jpaService.update(1, "12");
		
		((ConfigurableApplicationContext)appContext).close();
	}
}
