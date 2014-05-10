package com.liuxiangwin.DesignPattern05.ChainResponsiblity.test;

import com.liuxiangwin.DesignPattern05.ChainResponsiblity.test.IPermit.Level;

public class Clerk implements IPermit {
	
	public IPermit _permit;
	public Clerk(IPermit permit)
	{
	  this._permit=permit;
	}

	
	public void singnatureWithMoney(int value) {
		if (value == Level.Clerk.getLimit()) {
			System.out.println("Clerk Approve the Badget with " + value);
		} else if (value < Level.Clerk.getLimit()) {
			_permit.singnatureWithMoney(value);
		} else {
			try {
				throw new Exception("Throw by Clerk");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
