package com.study.spring.case05.aop_dancer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//使用java配置替代aop-config.xml
@Configuration // 取代配置檔aop-config.xml
//相當於xml這個設定<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
//相當於xml這個設定 <context:component-scan base-package="com.study.spring.case05.aop_dancer"></context:component-scan>
@ComponentScan//會Scan class內所配置的
public class AOPConfig {
	
	
	// <bean id="dancer" class="com.study.spring.case05.aop_dancer.Performance"></bean>
	@Bean(name = "dancer")
	public Performance dancer() {
		return new Dancer();
	}
	
	// <bean id="audience" class="com.study.spring.case05.aop_dancer.Audience"></bean>
	@Bean(name = "audience")
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	Introducter getIntroducter() {
		return new Introducter();
	}
}
