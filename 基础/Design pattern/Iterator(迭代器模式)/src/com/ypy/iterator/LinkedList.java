package com.ypy.iterator;

import com.ypy.iterator.Iterator;
import com.ypy.iterator.Collection;

//������ʽ
public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;
	
	//���
	public void add(Object o){
		Node n = new Node(o, null);
		if (head == null) {//���ԭ��������û������
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
		size++;
	}
	
	//���ظ���
	public int size(){
		return size;
	}
	
	//����
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























