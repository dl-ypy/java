package com.ypy.proxy;

import java.lang.reflect.Method;

//代理方法的接口
public interface InvocationHandler {
	public void invoke(Object o, Method m);   //第一个参数表示所调用的类
}
