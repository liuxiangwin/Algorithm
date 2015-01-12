package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			String content = "A Product, �����̣߳�"+ Thread.currentThread().getName();
			System.out.println("I have made a product:"	+ Thread.currentThread().getName());
			queue.put(content);//������������Ļ�����������ǰ�߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


