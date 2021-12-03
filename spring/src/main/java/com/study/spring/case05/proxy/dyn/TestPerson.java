package com.study.spring.case05.proxy.dyn;

import com.study.spring.case05.proxy.sts.Man;
import com.study.spring.case05.proxy.sts.Person;
import com.study.spring.case05.proxy.sts.Woman;

public class TestPerson {

	public static void main(String[] args) {
		Person p1= (Person) new ProxyUtil(new Man()).getProxy();
		p1.work();
		System.out.println();
		Person p2= (Person) new ProxyUtil(new Woman()).getProxy();
		p2.work();
	}

}
