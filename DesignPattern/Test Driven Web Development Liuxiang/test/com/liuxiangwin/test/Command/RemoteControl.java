package com.liuxiangwin.test.Command;

//Invoker
public class RemoteControl {

	private ICommand icommand;

	public void setCommand(ICommand command) {
		this.icommand = command;
	}

	public void pressButton()

	{
		icommand.execute();
	}

}
