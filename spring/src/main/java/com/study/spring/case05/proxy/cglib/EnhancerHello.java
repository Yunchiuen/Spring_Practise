package com.study.spring.case05.proxy.cglib;

//Enhancer 增強的 Hello
public class EnhancerHello extends Hello {

	@Override // Interceptor 攔截
	public String sayHello(String str) {
		return super.sayHello(str) + " 麻煩請出示實聯制";
	}
	
}
