package com.study.spring.case05.aop_dancerxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aopdancerxml-config.xml");
		Performance performance=ctx.getBean("dancer",Performance.class);
		performance.perform();
		
	}
}
