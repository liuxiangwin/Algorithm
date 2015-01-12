package com.liuxiangwin.multithreading.waitnotify.produceconsume;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

	private int maxSize;

	private List storage;

	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList();
	}

	public synchronized void put() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		storage.add(new Date());
		System.out.println("Set: %d" +storage.size());
		notifyAll();
	}

	public synchronized void take() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/* synchronized (obj) {
		      while (&lt;condition does not hold&gt;)
		     *             obj.wait();
		     *         ... // Perform action appropriate to condition
		     *     }*/

		System.out.println("Get: %d: %s" +storage.size()+
				((LinkedList) storage).poll());
		notifyAll();
	}

}
