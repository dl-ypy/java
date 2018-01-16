package com.ypy.db.command;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	private String name;
	private List<Command> commands = new ArrayList<Command>();

	public Boy(String name) {
		super();
		this.name = name;
	}

	public void addCommand(Command c1) {
		this.commands.add(c1);
	}

	public void executeComands() {
		for (Command c : commands) {
			c.execute();
		}
	}
	
	public void undoCommands() {
		//这里不实现了
	}
}
