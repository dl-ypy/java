package com.ypy.proxy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ypy.proxy.InvocationHandler;

public class TransactionHandler implements InvocationHandler{

	private Object target;
	
	public TransactionHandler(Object target) {
		super();
		this.target = target;
	}
	
	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Transaction Start");
		try {
			m.invoke(target);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("Transaction Commit");
	}

}
