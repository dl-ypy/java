package com.ypy.strategy;

public class Cat implements Comparable{
	private int weight;
	private int height;
	private Comparator comparator = new CatHeightComparator();   //默认为按高度比较

	public Cat(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}
	
	public Comparator getComparator() {
		return comparator;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "猫:" + weight + "|" + height;
	}

	@Override
	public int compareTo(Object o) {
		return comparator.compare(this, o);
	}

}
