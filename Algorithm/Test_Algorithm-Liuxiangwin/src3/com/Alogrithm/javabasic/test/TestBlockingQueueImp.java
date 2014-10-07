package com.Alogrithm.javabasic.test;

import java.util.LinkedList;
import java.util.List;

public class TestBlockingQueueImp {
	private List queue = new LinkedList();
	private int limit = 10;

	public TestBlockingQueueImp(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException  {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	
	}
	
	//Different between wait and sleep
	
	//A wait can be "woken up" by another process 
	//calling notify on the monitor which is 
	//being waited on whereas a sleep cannot. 
	//Also a wait (and notify) must happen in a 
	//block synchronized on the monitor object whereas sleep does not
	
	Object LOCK = null;
	public void diffSleepAndWait() throws InterruptedException{
		Thread.sleep(1000); // LOCK is held
		
		synchronized (LOCK) {
			Thread.sleep(1000); // LOCK is held
		}

		synchronized (LOCK) {
			LOCK.wait(); // LOCK is not held
		}
		LOCK.wait();
	}
}
