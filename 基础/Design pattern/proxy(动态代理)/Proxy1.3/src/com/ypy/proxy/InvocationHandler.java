package com.ypy.proxy;

import java.lang.reflect.Method;

//�������Ľӿ�
public interface InvocationHandler {
	public void invoke(Object o, Method m);   //��һ��������ʾ�����õ���
}
