package com.study.spring.case05.proxy.dyn;

public class TestCalc {
	public static void main(String[] args) {
		Calc calc =(Calc) new ProxyUtil(new CalcImpl()).getProxy();
		calc.add(10, 20);
		System.out.println();
		try {
			calc.div(10, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
