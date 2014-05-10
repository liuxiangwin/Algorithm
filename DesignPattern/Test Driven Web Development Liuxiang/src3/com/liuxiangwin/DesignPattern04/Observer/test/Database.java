package com.liuxiangwin.DesignPattern04.Observer.test;

import java.util.List;
import java.util.Vector;

public class Database implements ISubject {

	private Vector<IObserver> _observerList;

	private String _operation;

	private String _record;

	public Database() {
		_observerList = new Vector<IObserver>();
	}

	public void registerObserver(IObserver observer) {

		if (!_observerList.contains(observer)) {
			_observerList.add(observer);
		}

	}

	public void removeObserver(IObserver observer) {

		if (_observerList.contains(observer)) {
			_observerList.remove(observer);
		}

	}

	// Operation By Database ,Tell the Nofiy
	public void editRecord(String operation, String record) {
		this._operation = operation;
		this._record = record;
		if (_observerList.size() != 0) {
			notifyObservers();
		}

	}

	public void notifyObservers() {
		for (int loopIndex = 0; loopIndex < _observerList.size(); loopIndex++) {
			IObserver observer = _observerList.get(loopIndex);
			observer.update(_operation, _record);

		}

	}
}
