package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAspect {

	@Pointcut("execution(* com.demo.spring.Singer.perform(..))")
	private void pcut() {}

	@Before("execution(* com.demo.spring.Singer.perform(..))")
	public void takeSeat() {
		System.out.println("Audience takes seat..");
	}

	@AfterReturning("execution(* com.demo.spring.Singer.perform(..))")
	public void applaud() {

		System.out.println("clap.....");
		System.out.println("Switch off");
	}
}
