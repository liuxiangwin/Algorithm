package com.liuxiangwin.DesignPattern05.ChainResponsiblity.test;

import com.liuxiangwin.DesignPattern05.ChainResponsiblity.test.IPermit.Level;

public class Supervisor implements IPermit {
	
	public IPermit _permit;
	public Supervisor(IPermit permit)
	{
	  this._permit=permit;
	}

	public void singnatureWithMoney(int value) {
		if (value == Level.Supervisor.getLimit()) {
			System.out.println("Supervisor Approve the Badget with " + value);
		} else if (value < Level.Supervisor.getLimit()) {
			_permit.singnatureWithMoney(value);
		} else {
			try {
				throw new Exception("Throw by Supervisor");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
