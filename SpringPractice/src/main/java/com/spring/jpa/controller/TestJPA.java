package com.spring.jpa.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;
import com.spring.jpa.service.IJPAService;

public class TestJPA {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("jpa/jpaApplicationContext.xml");
		IJPAService jpaService = appContext.getBean("jpaService", IJPAService.class);
		
		Passport p = new Passport();
		p.setPassportId(2);
		p.setPassportNo("1234");
		jpaService.createPassport(p);
		
		((ConfigurableApplicationContext)appContext).close();
	}
}
