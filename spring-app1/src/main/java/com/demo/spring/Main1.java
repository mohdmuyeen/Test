package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Mail mail = (Mail)context.getBean("mail");
		
		System.out.println(mail.getMessage().getBody());
		
		mail.getMessage().setBody("Let's Break for lunch");
		
		Mail mail1 = (Mail)context.getBean("mail");
		
		System.out.println(mail1.getMessage().getBody());
	}
	
		
	
}
