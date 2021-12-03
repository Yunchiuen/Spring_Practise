package com.study.spring.case05.proxy.sts;

public class ProxyDemo {
	public static void main(String[] args) {

		Person p1 = new PersonProxy(new Man());
		p1.work();
		
		Person p2 = new PersonProxy(new Woman());
		p2.work();
		
	}
}
