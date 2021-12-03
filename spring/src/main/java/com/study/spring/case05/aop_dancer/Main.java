package com.study.spring.case05.aop_dancer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		//java配置
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance performance=ctx.getBean("dancer",Performance.class);
		
		try {
			performance.perform();
		} catch (Exception e) {
			System.out.println(e);
			//轉換跑道
			//舞者轉唱歌
			Singer singer= (Singer) performance;
			singer.sing();
			
			Actor actor=(Actor) performance;
			actor.show();
		}
	}
}
