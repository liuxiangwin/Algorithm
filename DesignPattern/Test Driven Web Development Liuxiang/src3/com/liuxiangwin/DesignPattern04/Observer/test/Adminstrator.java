package com.liuxiangwin.DesignPattern04.Observer.test;

public class Adminstrator implements IObserver {

	public void update(String operation, String record) {
		System.out.println("The Adminstrator says a  " +operation+
				"was performed on"+record);
	}

}
