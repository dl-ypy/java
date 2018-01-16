package com.ypy.iterator;

//此接口用来将两种容器的遍历方法也保持一致
public interface Iterator {
	boolean hasNext();
	Object next();
}
