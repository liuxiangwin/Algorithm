package com.liuxiangwin.DesignPattern16.Command.test;

public class DiskScanCommand implements ICommand {

	private IReceiver reciever;

	public DiskScanCommand(IReceiver reciever) {

		this.reciever = reciever;
	}

	public void taskPeform() {
		reciever.scan();

	}

	public void taskUndo() {
		// TODO Auto-generated method stub

	}

}
