package com.ypy.db.command;

public class ShoppingCommand implements Command{

	@Override
	public void execute() {
		System.out.println("shopping");
	}

	@Override
	public void unDo() {
		System.out.println("undo shopping");
	}

}
