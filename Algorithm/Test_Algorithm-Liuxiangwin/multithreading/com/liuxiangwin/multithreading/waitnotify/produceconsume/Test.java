package com.liuxiangwin.multithreading.waitnotify.produceconsume;

public class Test {
	public static void main(String ags[]) {

		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);

		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);

		thread2.start();
		thread1.start();

	}
}
