package com.ypy.iterator;

import com.ypy.iterator.Iterator;

//�ýӿڶ��÷�������ArrayList��LinkedListʵ������ӿ�
//ǿ���䷽����һ�£���ʹ�ø�����������ʱֻ���ĺ���һ���ִ���
public interface Collection {
	void add(Object o);
	int size();
	Iterator iterator();
}
