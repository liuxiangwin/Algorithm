package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test{

	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		// BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		//不设置的话，LinkedBlockingQueue默认大小为Integer.MAX_VALUE
		
		// BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		for (int i = 0; i < 5; i++) {
			new Thread(producer, "Producer" + (i + 1)).start();

			new Thread(consumer, "Consumer" + (i + 1)).start();
		}
		
		System.out.println("--------------------------");
		
		BlockingQueue<String> queue2 = new LinkedBlockingQueue<String>(2);	
		 ExecutorService executor = Executors.newFixedThreadPool(2);
		 executor.execute(new Producer(queue2));
		 executor.execute(new Consumer(queue2));
		 executor.shutdown();
	}
}