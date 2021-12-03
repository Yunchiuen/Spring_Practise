package com.study.spring.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest2 {
	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		Husband husband= (Husband) ctx.getBean("husband");
		Wife wife= (Wife) ctx.getBean("wife");
		System.out.println(husband);
		System.out.println(wife);
	}
}
