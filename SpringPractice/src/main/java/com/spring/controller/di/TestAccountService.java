package com.spring.controller.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.di.AccountService;

public class TestAccountService {
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountService accountService = appCtx.getBean("accountService", AccountService.class);
		System.out.println(accountService.getAccountBalance("Rajendra"));
		((ConfigurableApplicationContext)appCtx).close();
    }
	
}
