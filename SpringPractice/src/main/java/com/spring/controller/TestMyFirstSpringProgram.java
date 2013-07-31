package com.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.MyFirstSpringService;

public class TestMyFirstSpringProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyFirstSpringService serviceObj = context.getBean("fistBean", MyFirstSpringService.class);
		System.out.println(serviceObj.getName());
		
		serviceObj.setName("Bye to Spring World");
		
		System.out.println(serviceObj.getName());
		
		((ConfigurableApplicationContext)context).close();
	}
}
