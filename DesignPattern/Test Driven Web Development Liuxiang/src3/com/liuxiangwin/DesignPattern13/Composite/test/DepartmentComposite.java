package com.liuxiangwin.DesignPattern13.Composite.test;

import java.util.ArrayList;
import java.util.Iterator;

public class DepartmentComposite implements IComponent {
	ArrayList<IComponent> _iComponentList = new ArrayList<IComponent>();

	public void addComponent(IComponent component) {
		// TODO Auto-generated method stub
		_iComponentList.add(component);

	}

	@SuppressWarnings("unchecked")
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return _iComponentList.iterator();
	}

	public void operation(String name) {

		// TODO Auto-generated method stub
		for (IComponent icomponent : _iComponentList) {
			icomponent.operation(name);
		}

	}

	public void removeComponet(IComponent component) {
		// TODO Auto-generated method stub

	}

}
