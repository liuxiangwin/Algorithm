package com.liuxiangwin.DesignPattern08.Adapter.test;

public class SeaBirdAdapter extends Seacraft implements IAircraft {
    //Use the  Implement the target interface to give the clien interface
	//Meanwhile use the inheritance to adpater the Adaptee
	public boolean airBorne() {
		// TODO Auto-generated method stub
		return false;
	}

	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void takeOff() {
		// TODO Auto-generated method stub
		
	}
	public void IncreaseRevs() {
		// TODO Auto-generated method stub

	}

}
