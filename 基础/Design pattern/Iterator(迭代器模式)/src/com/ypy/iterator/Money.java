package com.ypy.iterator;

//²âÊÔµÄobjectÀà
public class Money {
	public Money(int id) {
		super();
		this.id = id;
	}

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "Moeny" + (id+1);
	}
}
