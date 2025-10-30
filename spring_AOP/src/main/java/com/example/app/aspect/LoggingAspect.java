package com.example.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution (* com.example.app.service.CalculatorService.cong(..))")
	public void beforeCong(JoinPoint joinPoint) {
		System.out.println("chuan bi cong");
	}

	@After("execution (* com.example.app.service.CalculatorService.cong(..))")
	public void AfterCong(JoinPoint joinPoint) {
		System.out.println("xong");
	}

	@AfterThrowing("execution (* com.example.app.service.CalculatorService.chia(..))")
	public void AfterThrowingChia(JoinPoint joinPoint) {
		System.out.println("khong chi cho khong");
	}

	@Pointcut("execution (* com.example.app.service.*.*(..))")
	public void myPointCut() {
	}

//	@After("myPointCut()")
//	public void afterTinh(JoinPoint joinPoint) {
//		System.out.println("sau" + joinPoint.getSignature().getName());
//	}
//
//	@Before("myPointCut()")
//	public void beforeTinh(JoinPoint joinPoint) {
//		System.out.println("dau" + joinPoint.getSignature().getName());
//	}

	@Around("myPointCut()")
	public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String methodName = proceedingJoinPoint.getSignature().getName();
		long startTime = System.currentTimeMillis();

		Object result = proceedingJoinPoint.proceed();

		long endTime = System.currentTimeMillis();
		long execution = endTime - startTime;
		System.out.println("result " + result);
		System.out.println("time " + execution);
		return result;
	}
}
