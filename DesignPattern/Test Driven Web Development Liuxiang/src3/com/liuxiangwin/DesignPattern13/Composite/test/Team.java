package com.liuxiangwin.DesignPattern13.Composite.test;

import java.util.Iterator;

public class Team implements IComponent {

	private IComponent[] _iComponentArray = new IComponent[100];
	
	private int _index=0;
	private String _name;

	public Team(String name) {
		this._name = name;

	}

	public void addComponent(IComponent component) {
		// TODO Auto-generated method stub
		_iComponentArray[_index++]=component;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new TeamIterator(_iComponentArray);
	}

	public void operation(String name) {
		Iterator itetor=this.iterator();
		while(itetor.hasNext())
		{
			IComponent icomponent=(IComponent)itetor.next();
			//System.out.println(_name);
			icomponent.operation(this._name);
			
		}

	}

	public void removeComponet(IComponent component) {
		// TODO Auto-generated method stub

	}

}
