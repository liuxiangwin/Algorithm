package com.liuxiangwin.DesignPattern16.Command.test;

public class Client {

	public static void main(String args[]) {
		Invoker _invoker = new Invoker();

		IReceiver diskReceiver = new DiskReceiver();

		ICommand diskCommand = new DiskScanCommand(diskReceiver);

		IReceiver printerReceiver = new PrinterReceiver();

		ICommand printerCommand = new PrinterCommand(printerReceiver);

		_invoker.setCommand(diskCommand);

		_invoker.setCommand(printerCommand);

		_invoker.run();

	}

}
