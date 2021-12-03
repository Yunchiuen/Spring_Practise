package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest5 {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext2.xml");
		Paper paper= (Paper) ctx.getBean("paper");
		System.out.println(paper);
		
		Paper2 paper2= (Paper2) ctx.getBean("paper2");
		System.out.println(paper2);
		
		Paper3 paper3= (Paper3) ctx.getBean("paper3");
		System.out.println(paper3);
		
		Paper paper4= (Paper) ctx.getBean("paper4");
		System.out.println(paper4);
	}
}
