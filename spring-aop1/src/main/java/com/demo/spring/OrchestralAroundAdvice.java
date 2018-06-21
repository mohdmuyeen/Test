package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrchestralAroundAdvice {

	
	@Pointcut("execution(* com.demo.spring.Singer.perform(..))")
	private void pcut() {}
	
	
	@Around("pcut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Musicians start playing");
		
		pjp.proceed();
		
		System.out.println("Musicians return...");
	}
}
