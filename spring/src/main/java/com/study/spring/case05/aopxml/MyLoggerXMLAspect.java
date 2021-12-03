package com.study.spring.case05.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyLoggerXMLAspect {

	public void before(JoinPoint joinPoint) {
		System.out.print("AOP XML 版 - 前置通知");
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.printf(" 方法名稱 : %s 方法參數 : %s\n", methodName, Arrays.toString(args));
	}

	

	public void afterReturning(Object result) {
		System.out.println("AOP XML 版 - 返回通知 "+result);
	}

	public void afterThrowing(Throwable e) {
		System.out.println("AOP XML 版 - 異常通知 "+e);
	}

	public void after() {
		System.out.println("AOP XML 版 - 後置通知");
	}
	
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result=null;
		try {
			//1 前置通知
			System.out.println("環繞通知 XML 版  - 前置通知");
			result=joinPoint.proceed();//執行業務邏輯方法
			//2 返回通知
			System.out.println("環繞通知 XML 版  - 返回通知");
			
		} catch (Throwable e) {
			//3 異常通知
			System.out.println("環繞通知 XML 版  - 異常通知 : "+e);
			
		}finally {
			//4 後置通知
			System.out.println("環繞通知 XML 版  - 後置通知");
			
		}
		return result;
		
	}
}
