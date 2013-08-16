package com.spring.controller.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.annotation.AccountAnnotateService;

public class TestAccountAnnotateService {
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationAnnotateContext.xml");
		AccountAnnotateService accountService = appCtx.getBean("accountService", AccountAnnotateService.class);
		System.out.println(accountService.getAccountBalance("Rajendra"));
		((ConfigurableApplicationContext)appCtx).close();
    }
	
}
