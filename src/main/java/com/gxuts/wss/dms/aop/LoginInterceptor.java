package com.gxuts.wss.dms.aop;

import org.aopalliance.intercept.Interceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginInterceptor implements Interceptor{
	
	
	@Before("execution(* com.gxuts.wss.drug.dao.*.*(..))")
	public void beforeM(JoinPoint joinPoint) {
		System.out.println("Interceptor");
	}

}
