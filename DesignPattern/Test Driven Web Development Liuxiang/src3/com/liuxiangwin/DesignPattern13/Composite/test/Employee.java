package com.liuxiangwin.DesignPattern13.Composite.test;

import java.util.Iterator;

public class Employee implements IComponent {
	private String _name;

	private int _employeeId;

	public Employee(String name, int employeeId) {
		this._name = name;
		this._employeeId = employeeId;
	}

	public void addComponent(IComponent component) {
		// TODO Auto-generated method stub

	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public void removeComponet(IComponent component) {
		// TODO Auto-generated method stub

	}

	public void operation(String name) {
		  System.out.println("This is "+name+"  "+_employeeId+" "+_name);
		
	}

}
