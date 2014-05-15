package com.liuxiangwin.DesignPattern16.Command.test;

import java.util.Iterator;
import java.util.Vector;

public class Invoker {
	private Vector<ICommand> taskList = new Vector<ICommand>();

	public void setCommand(ICommand command) {
		taskList.add(command);

	}

	public void run() {

		for (Iterator<ICommand> iter = taskList.iterator(); iter.hasNext();)
		{
			ICommand icommand=iter.next();
			
			//It would trigger the related receiver to do the real perform
			icommand.taskPeform();

		}
	}
	
	public void runUndo() {

		for (Iterator<ICommand> iter = taskList.iterator(); iter.hasNext();)
		{
			ICommand icommand=iter.next();
			
			icommand.taskUndo();

		}
	}

}
