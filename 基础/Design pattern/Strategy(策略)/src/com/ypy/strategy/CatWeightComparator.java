package com.ypy.strategy;

public class CatWeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Cat c = (Cat)o1;
		Cat c0 = (Cat)o2;
		if (c.getWeight() > c0.getWeight()) return 1;
		else if (c.getWeight() < c0.getWeight()) return -1;
		else return 0;
	}

}
