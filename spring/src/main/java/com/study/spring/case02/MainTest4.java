package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
		Car c1= (Car) ctx.getBean("carFactory");
		Car c2= (Car) ctx.getBean("carFactory");
		System.out.println(c1);
		System.out.println(c2);
	}
}
