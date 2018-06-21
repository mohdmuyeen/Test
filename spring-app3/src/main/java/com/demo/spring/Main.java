package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpService service =(EmpService)context.getBean("empService");
		System.out.println(service.RegisterEmployee(100, "muyeen", "chennai", 5500));
		
	}

}
