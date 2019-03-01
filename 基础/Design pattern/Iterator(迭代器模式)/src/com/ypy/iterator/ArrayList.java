package com.ypy.iterator;

import com.ypy.iterator.Iterator;

import com.ypy.iterator.Collection;

//数组形式
public class ArrayList implements Collection{
	Object[] objects = new Object[10];
	int index = 0;
	
	//添加
	public void add(Object o){
		if (index == objects.length) {//如果数组满了，将数组扩充为原来的2倍，并将原数组的内容赋给新数组
			Object[] newobjects = new Object[objects.length*2];
			System.arraycopy(objects, 0, newobjects, 0, objects.length);
			objects = newobjects;
		}
		
		objects[index] = o;
		index++;
	}
	
	//返回个数
	public int size(){
		return index;
	}
	
	//遍历
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
