package com.study.spring.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		Person person=new Person();
		person.setId(1);
		person.setName("hi");
		System.out.println(person);
		
		ApplicationContext ctx=  new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person2=(Person) ctx.getBean("person");
		person2.setId(2);
		person2.setName("helen");
		System.out.println(person2);
	}

}
