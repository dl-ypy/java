package com.ypy.strategy;

public class Dog implements Comparable{
	
	public Dog(int food) {
		super();
		this.food = food;
	}

	private int food;

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	
	@Override
	public String toString() {
		return "นท" + food;
	}

	@Override
	public int compareTo(Object o) {
		Dog c = (Dog)o;
		if (this.food > c.food) return 1;
		else if (this.food < c.food) return -1;
		else return 0;
	}
}
