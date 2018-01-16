package com.ypy.proxy;
import java.lang.reflect.InvocationTargetException;
//时间代理的方法
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{

	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		long start = System.currentTimeMillis();   
		try {
			m.invoke(target);   //调用坦克自己的move方法
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}			
		long end = System.currentTimeMillis();     
		System.out.println("time:" + (end-start));
	}

}
