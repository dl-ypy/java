package com.ypy.iterator;

import com.ypy.iterator.Iterator;

import com.ypy.iterator.Collection;

//������ʽ
public class ArrayList implements Collection{
	Object[] objects = new Object[10];
	int index = 0;
	
	//���
	public void add(Object o){
		if (index == objects.length) {//����������ˣ�����������Ϊԭ����2��������ԭ��������ݸ���������
			Object[] newobjects = new Object[objects.length*2];
			System.arraycopy(objects, 0, newobjects, 0, objects.length);
			objects = newobjects;
		}
		
		objects[index] = o;
		index++;
	}
	
	//���ظ���
	public int size(){
		return index;
	}
	
	//����
	public Iterator iterator(){
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator {
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			if (currentIndex >= index) return false;
			else return true;
		}

		@Override
		public Object next() {
			Object o = objects[currentIndex];
			currentIndex++;
			return o;
		}
		
	}
}
