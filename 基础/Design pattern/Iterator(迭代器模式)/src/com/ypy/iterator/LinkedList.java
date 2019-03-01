package com.ypy.iterator;

import com.ypy.iterator.Iterator;
import com.ypy.iterator.Collection;

//链表形式
public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;
	
	//添加
	public void add(Object o){
		Node n = new Node(o, null);
		if (head == null) {//如果原来链表中没有数据
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
		size++;
	}
	
	//返回个数
	public int size(){
		return size;
	}
	
	//遍历
	public Iterator iterator(){
		return new LinkedListIterator();
	}
	
	class LinkedListIterator implements Iterator {
		
		@Override
		public boolean hasNext() {
			if (head == null) return false;
			else return true;
		}

		@Override
		public Object next() {
			Object o = head.getData();
			head = head.getNext();
			return o;
		}
		
	}
}























