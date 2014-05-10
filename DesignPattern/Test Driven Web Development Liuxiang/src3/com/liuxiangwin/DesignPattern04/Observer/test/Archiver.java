package com.liuxiangwin.DesignPattern04.Observer.test;

public class Archiver implements IObserver {

	public void update(String operation, String record) {
		System.out.println("The Archiver says a  " +operation+
				"was performed on"+record);
	}

}
