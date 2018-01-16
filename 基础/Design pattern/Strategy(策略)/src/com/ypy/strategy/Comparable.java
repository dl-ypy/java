package com.ypy.strategy;

//用于比较的接口，使得要比较的类统一调用实现这个接口
public interface Comparable {
	public int compareTo(Object o);
}
