package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BufferQueue {

	// 缓存区容量
	private static final int CAPACITY = 1;

	// 用LinkedList定义FIFO链队
	private LinkedList<String> queue = new LinkedList<String>();

	// 定义互斥锁
	private static Lock lock;

	public BufferQueue() {
		lock = new ReentrantLock();
	}

	public BufferQueue(boolean fair) {
		lock =  new ReentrantLock(fair);		
	}

	// 条件：缓存区非空
	private static Condition empty = lock.newCondition();
	// 条件：缓存区已满
	private static Condition full = lock.newCondition();

	// 从缓存区读取整数
	public void put(String value) {
		lock.lock();
		try {
			while (queue.size() == CAPACITY) {
				System.out.println("篮子是满的，待会儿再生产...");
				full.await();
			}
			// 缓存区未满条件被唤醒之后，向队列添加
			queue.offer(value);
			// 向缓存区非空条件发送信号
			empty.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String take() {
		String value = "";
		lock.lock();
		try {
			// 当缓存区为空时候：等待非空条件
			while (queue.isEmpty()) {
				System.out.println("篮子是空的，待会儿再吃...");
				empty.await();
			}
			// 读取并删除数据
			value = queue.remove();
			// 向缓存区未满条件发送信号
			full.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
			return value;
		}
	}
}
