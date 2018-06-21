package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;

public class JpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Appconfig.class);
		EmpDao dao = (EmpDao)ctx.getBean("emplDaoJPAImpl");
		//String s = dao.save(new Emp(704,"Shafee","Chennai",55000));
		//System.out.println(s);
		List<Emp> emplist = dao.getAll();
		for (Emp emp : emplist) {

			System.out.println(emp.getEmpId() + " " + emp.getName());

		}
		System.out.println("------------");
		String s  =dao.delete(601);
		System.out.println(s);
	}

}
