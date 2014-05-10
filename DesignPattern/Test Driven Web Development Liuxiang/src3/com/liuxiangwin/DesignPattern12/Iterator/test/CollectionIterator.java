package com.liuxiangwin.DesignPattern12.Iterator.test;

import java.util.Iterator;

public class CollectionIterator implements Iterator {
	private Count[] _countArray;
	private int _index = 0;

	public CollectionIterator(Count[] countArray) {

		this._countArray = countArray;
		// TODO Auto-generated constructor stub
	}

	public boolean hasNext() {
		if (_index < _countArray.length && _countArray[_index] != null) {
			return true;
		}
		return false;
	}

	public Object next() {

		return _countArray[_index++];
	}

	public void remove() {
		// TODO Auto-generated method stub

	}

}
