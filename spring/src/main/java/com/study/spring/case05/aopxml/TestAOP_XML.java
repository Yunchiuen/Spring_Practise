package com.study.spring.case05.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP_XML {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopxml-config.xml");
		Calc calc = ctx.getBean("calcImpl", Calc.class);
		System.out.println(calc.add(2, 1));
		System.out.println();
		try {
			System.out.println(calc.div(10, 0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
