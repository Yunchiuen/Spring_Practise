package com.study.spring.case05.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class HelloTest {

	public static void main(String[] args) {
		//使用子類別(加強)來代理
		Hello hello=new Hello();
		System.out.println(hello.sayHello("Yun"));
		
		System.out.println();
		//使用cglib
		Enhancer enhancer=new Enhancer();//增強
		enhancer.setSuperclass(Hello.class);//目標
		enhancer.setCallback(new MyMethodInterceptor());//攔截
		
		Hello hello2=(Hello)enhancer.create();
		System.out.println(hello2.sayHello("Helen"));
	}

}
