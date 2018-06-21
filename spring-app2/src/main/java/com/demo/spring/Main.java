package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		EmpService service =(EmpService)context.getBean("service");
		System.out.println(service.RegisterEmployee(100, "muyeen", "chennai", 5500));
		
	}

}
