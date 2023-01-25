package com.cts.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	
//	@Before
//	@AfterReturning - Success
//	@AfterThrowing - Failure
//	@After - Success/Failure
//	@Around - Both before and after at the same time
	
	@Before("execution(* com.cts.services.*Service.fetchCourse*(..))")
	public void doLogging(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println("Before invoking: " + jp.getSignature());
		
		System.out.println("Printing all input params: ");
		for(Object arg: args){
			System.out.println(arg);
		}
	}
	
	@AfterReturning("execution(* com.cts.services.*Service.fetchCourse*(..))")
	public void doLogging2(JoinPoint jp){
		System.out.println("After returning invoking: " + jp.getSignature());
		
	}
	
	@AfterThrowing(value="execution(* com.cts.services.*Service.fetchCourse*(..))", throwing="re")
	public void handleException(JoinPoint jp, Exception re) throws Exception{
		re.printStackTrace();
		if(re != null){
			throw new Exception("Wrapper exception",re);
		}
		System.out.println("Handling of Exception goess here....");
	}
	


}
