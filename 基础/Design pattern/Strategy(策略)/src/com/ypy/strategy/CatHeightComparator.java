package com.ypy.strategy;

public class CatHeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Cat c = (Cat)o1;
		Cat c0 = (Cat)o2;
		if (c.getHeight() > c0.getHeight()) return 1;
		else if (c.getHeight() < c0.getHeight()) return -1;
		else return 0;
	}

}
