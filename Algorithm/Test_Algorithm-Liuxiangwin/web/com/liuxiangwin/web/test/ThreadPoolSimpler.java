package com.liuxiangwin.web.test;

import java.util.LinkedList;

public class ThreadPoolSimpler {
	private final int threadNumber;
	private final PoolWorker[] workers;
	private final LinkedList queue;

	public ThreadPoolSimpler(int threadNumber) {
		this.threadNumber = threadNumber;
		//Allocate TaskQueue;
		queue = new LinkedList();
		//Allocate Poolworker Array
		workers = new PoolWorker[threadNumber];

		for (int i = 0; i < threadNumber; i++) {
			workers[i] = new PoolWorker();
			workers[i].start();
		}
	}

	public void execute(Runnable runnable) {
		synchronized (queue) {
			//Appends the specified element to the end of this list.
			queue.addLast(runnable);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {
		public void run() {
			Runnable runnable;

			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException ignored) {
						}
					}
					// return the frist task
					runnable = (Runnable) queue.removeFirst();
				}

				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					System.out.println("The poolworker run "+Thread.currentThread().getName());
					runnable.run();
				} catch (RuntimeException e) {
					// You might want to log something here
				}
			}
		}
	}

	public static void main(String args[]) {
		ThreadPoolSimpler wq = new ThreadPoolSimpler(3);
		wq.execute(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
					System.out.println("this is a thread"+Thread.currentThread().getName());
				}
			}
		});
	}

}





