package com.liuxiangwin.DesignPattern13.Composite.test;

import java.util.Iterator;

public class TeamIterator implements Iterator {
	private IComponent[] _iComponentArray;

	private int index = 0;

	public TeamIterator(IComponent[] iComponentArray) {
		_iComponentArray = iComponentArray;

	}

	public boolean hasNext() {
		if (index < _iComponentArray.length && _iComponentArray[index] != null) {
			return true;
		} else {
			return false;
		}

	}

	public Object next() {
		// TODO Auto-generated method stub
		return _iComponentArray[index++];
	}

	public void remove() {
		// TODO Auto-generated method stub

	}

}
