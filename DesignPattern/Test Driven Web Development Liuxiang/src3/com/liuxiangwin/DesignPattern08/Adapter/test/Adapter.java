package com.liuxiangwin.DesignPattern08.Adapter.test;

public class Adapter {
	/**
	 * 
	 * 
	 * Adapter Pattern: The gang of four definition is "Convert the interface of
	 * a class into another interface clients expect. Adpater lets the classes
	 * work together that couldn't otherwise because of incompatible
	 * interfaces".
	 * 
	 * Facade Pattern: The gang of four definition is "Provide a unified
	 * interface to a set of interfaces in a subsystem. Facade defines a
	 * higher-level interface that makes the subsystem easier to use."
	 */
	
	private Adaptee _adaptee;//This scenario use the aggregation way
	
	public Adapter(Adaptee adaptee)
	{
		this._adaptee=adaptee;
	}
    
	public String getBIOS() {
		return "The BIOS is "+_adaptee.getARM();
	}

	public String getVersion() {
		return "The Version is "+_adaptee.getARMVersion();
	}
	
}
