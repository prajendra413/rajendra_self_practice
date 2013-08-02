package com.spring.controller.di.instrument;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.di.instrument.InstrumentsList;

public class TestInstrumentsListService {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("instrumentApplicationContext.xml");
		InstrumentsList insturmentsList = appCtx.getBean("kenny", InstrumentsList.class);
		//InstrumentsList insturmentsList = appCtx.getBean("car1", InstrumentsList.class);
		insturmentsList.perform();
		System.out.println("-------------------------------------");
		insturmentsList.performAll();
		((ConfigurableApplicationContext)appCtx).close();
    }
	
}
