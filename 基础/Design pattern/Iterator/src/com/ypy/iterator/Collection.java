package com.ypy.iterator;

import com.ypy.iterator.Iterator;

//用接口定好方法名，ArrayList和LinkedList实现这个接口
//强迫其方法名一致，就使得更换容器类型时只更改很少一部分代码
public interface Collection {
	void add(Object o);
	int size();
	Iterator iterator();
}
