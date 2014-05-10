package com.liuxiangwin.DesignPattern15.Proxy.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ISubject subject=new ProxySubject();
		
		subject.request();

	}

}
