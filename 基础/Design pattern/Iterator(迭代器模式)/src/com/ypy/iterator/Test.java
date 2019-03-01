package com.ypy.iterator;

import com.ypy.iterator.Iterator;
import com.ypy.iterator.Collection;

public class Test {

	public static void main(String[] args) {
		//ArrayList al = new ArrayList();
		//LinkedList al = new LinkedList();
		Collection c = new LinkedList();
		
		for (int i=0; i<22; i++) {
			c.add(new Money(i));
		}
		System.out.println(c.size());
		
		Iterator it = c.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.print(o + " ");
		}
	}

}
