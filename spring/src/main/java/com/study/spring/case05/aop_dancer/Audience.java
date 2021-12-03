package com.study.spring.case05.aop_dancer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect // 切面程式
@Order(value = 1)
public class Audience {
	
	// 切面表達式可以指向interface
	@Before("execution(* com.study.spring.case05.aop_dancer.Performance.perform(..))")
	public void slienceCellPhone() {
		System.out.println("關掉手機");
		System.out.println("找到座位");
	}

	@AfterReturning("execution(* com.study.spring.case05.aop_dancer.Performance.perform(..))")
	public void applause() {
		System.out.println("拍手鼓掌");
	}

	@AfterThrowing("execution(* com.study.spring.case05.aop_dancer.Performance.perform(..))")
	public void demandRefund() {
		System.out.println("退票!");
	}

	@After("execution(* com.study.spring.case05.aop_dancer.Performance.perform(..))")
	public void exit() {
		System.out.println("離開表演場");
	}
	
	/*
	//環繞通知
	@Around("execution(* com.study.spring.case05.aop_dancer.Performance.perform(..))")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			//前置通知
			System.out.println("關掉手機");
			System.out.println("找到座位");
			result = joinPoint.proceed();//執行業務邏輯方法
			//返回通知
			System.out.println("拍手鼓掌");
		} catch (Throwable e) {
			//例外通知
			System.out.println("退票! " +e);
		} finally {
			//後製通知
			System.out.println("離開表演場");
		}

		return result;
	}
	*/
}
