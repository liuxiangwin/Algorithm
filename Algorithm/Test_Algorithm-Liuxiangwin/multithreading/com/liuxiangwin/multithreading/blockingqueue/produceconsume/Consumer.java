package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			//�������Ϊ�գ���������ǰ�߳�
			String content = queue.take();
			System.out.println(content);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}