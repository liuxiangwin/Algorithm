package com.liuxiangwin.DesignPattern08.Adapter.test;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adaptee adaptee=new Adaptee("ARM-69","90-12");
		
		Adapter adapter=new Adapter(adaptee);
		
		System.out.println(adapter.getBIOS());
		
		System.out.println(adapter.getVersion());
	}

}
