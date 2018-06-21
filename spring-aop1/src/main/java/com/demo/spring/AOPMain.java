package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMain {

	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Test before perform");
		Performer p = (Performer) ctx.getBean("singer");
		
		p.perform();
		System.out.println("Test after perform");
	}
	
}
