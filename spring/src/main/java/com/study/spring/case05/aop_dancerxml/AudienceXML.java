package com.study.spring.case05.aop_dancerxml;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AudienceXML {
	// 切面表達式可以指向interface
	//Before
	public void slienceCellPhone() {
		System.out.println("關掉手機");
		System.out.println("找到座位");
	}

	//AfterReturning
	public void applause() {
		System.out.println("拍手鼓掌");
	}

	//AfterThrowing
	public void demandRefund() {
		System.out.println("退票!");
	}

	//After
	public void exit() {
		System.out.println("離開表演場");
	}
}
