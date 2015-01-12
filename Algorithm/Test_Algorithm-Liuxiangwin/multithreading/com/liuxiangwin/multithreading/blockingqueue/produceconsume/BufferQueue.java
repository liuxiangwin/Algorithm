package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferQueue {

	// 缓存区容量
	private static final int CAPACITY = 1;

	// 用LinkedList定义FIFO链队
	private LinkedList<Integer> queue = new LinkedList<Integer>();

	// 定义互斥锁
	private static Lock lock = new ReentrantLock();

	// 条件：缓存区非空
	private static Condition notEmpty = lock.newCondition();
	// 条件：缓存区已满
	private static Condition notFull = lock.newCondition();

	// 从缓存区读取整数
	public void put(int value) {
		lock.lock();
		try {
			while (queue.size() == CAPACITY) {
				System.out.println("等待缓存区未满");
				notFull.await();
			}

			// 缓存区未满条件被唤醒之后，向队列添加
			queue.offer(value);
			// 向缓存区非空条件发送信号
			notEmpty.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("finally")
	public int take() {
		int value = 0;
		lock.lock();
		try {
			// 当缓存区为空时候：等待非空条件
			while (queue.isEmpty()) {
				System.out.println("\t\t\t等待唤醒非空条件");
				notEmpty.await();
			}

			// 读取并删除数据
			value = queue.remove();
			// 向缓存区未满条件发送信号
			notFull.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
			return value;
		}
	}
}
