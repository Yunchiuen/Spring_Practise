package com.study.spring.case05.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyUtil {
	private Object object;

	public ProxyUtil(Object object) {
		this.object = object;
	}

	public Object getProxy() {
		//類別載入器
		ClassLoader loader=getClass().getClassLoader();
		//目標所實作介面
		Class<?>[] interfaces=object.getClass().getInterfaces();
		//處裡代理的實現
		InvocationHandler handler=(Object proxy, Method method, Object[] args)->{
			Object result=null;
			try {
				//前置通知
				MyLogger.before(object.getClass(),method.getName(),args);
				//System.out.println("前置 Log: "+object.getClass()+" "+method.getName()+" "+Arrays.toString(args));
				//代理呼叫方法
				//method 方法 add() div() 
				//args 傳入參數 int x, int y
				result= method.invoke(object, args);
				return result;
			} catch (Exception e) {
				//e.printStackTrace(System.out);
				//例外異常通知
				MyLogger.throwing(getClass(), e.getMessage());
				//System.out.println("例外異常 Log: "+object.getClass()+e);
			}finally {
				//後置通知
				MyLogger.end(getClass(), method.getName(), result);;
				//System.out.println("後置 Log: "+object.getClass()+" "+method.getName()+" "+result);
			}
			
			return result;
		};
		
		//回傳代理物件
		Object object= java.lang.reflect.Proxy.newProxyInstance(loader, interfaces, handler);
		return object;
	}

}
