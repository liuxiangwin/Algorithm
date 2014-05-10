package com.liuxiangwin.DesignPattern15.Proxy.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Subject implements ISubject {
	
	HashMap<String,Subject> map=new HashMap<String,Subject>();

	public void Add() {
		// TODO Auto-generated method stub

	}

	public void Add(String friend, String message) {
		// TODO Auto-generated method stub

	}

	public String request() {
		// TODO Auto-generated method stub
		System.out.println("This is subjec request call");
		return "Subject proxy";
	}

}
