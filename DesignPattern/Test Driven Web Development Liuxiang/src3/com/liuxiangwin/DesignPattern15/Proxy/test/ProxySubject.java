package com.liuxiangwin.DesignPattern15.Proxy.test;

public class ProxySubject implements ISubject{
	private Subject _subject;

	public void Add() {
		// TODO Auto-generated method stub
		
	}

	public void Add(String friend, String message) {
		// TODO Auto-generated method stub
		
	}

	public String request() {
		_subject=new Subject();
		System.out.println("Proxy: Call to "+_subject.request());
		return "Proxy request";
	}

}
