package com.liuxiangwin.DesignPattern04.Observer.test;

public class Boss implements IObserver {

	public void update(String operation, String record) {
		System.out.println("The Boss says a  " +operation+
				"was performed on"+record);
	}

}
