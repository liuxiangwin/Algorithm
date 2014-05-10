package com.liuxiangwin.DesignPattern16.Command.test;

public class PrinterCommand implements ICommand {
	private IReceiver reciever;
	
	public PrinterCommand(IReceiver reciever) {

		this.reciever = reciever;
	}


	public void taskPeform() {
		reciever.scan();

	}

	public void taskUndo() {
		// TODO Auto-generated method stub

	}

}
