package com.liuxiangwin.multithreading.waitnotify.produceconsume;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String ags[]) {

		EventStorage only_storage = new EventStorage();
		Producer producer = new Producer(only_storage);
		Thread thread1 = new Thread(producer);

		Consumer consumer = new Consumer(only_storage);
		Thread thread2 = new Thread(consumer);

		thread2.start();
		thread1.start();
		
		List<String> list = new ArrayList<String>();
		for(String elem:list)
		{
			
		}

	}
}
