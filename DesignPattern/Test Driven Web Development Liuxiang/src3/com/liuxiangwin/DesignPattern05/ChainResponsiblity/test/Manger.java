package com.liuxiangwin.DesignPattern05.ChainResponsiblity.test;

public class Manger implements IPermit {

	public IPermit _permit;
    //Set success next handle
	public Manger(IPermit permit) {
		this._permit = permit;
	}

	public void singnatureWithMoney(int value) {
		if (value == Level.Manager.getLimit()) {
			System.out.println("Manager Approve the Badget with " + value);
		} else if (value < Level.Manager.getLimit()) {
			_permit.singnatureWithMoney(value);
		} else {
			try {
				throw new Exception("Throw by Manger");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
