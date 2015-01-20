package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BufferQueue {

	// ����������
	private static final int CAPACITY = 1;

	// ��LinkedList����FIFO����
	private LinkedList<String> queue = new LinkedList<String>();

	// ���廥����
	private static Lock lock;

	public BufferQueue() {
		lock = new ReentrantLock();
	}

	public BufferQueue(boolean fair) {
		lock =  new ReentrantLock(fair);		
	}

	// �������������ǿ�
	private static Condition empty = lock.newCondition();
	// ����������������
	private static Condition full = lock.newCondition();

	// �ӻ�������ȡ����
	public void put(String value) {
		lock.lock();
		try {
			while (queue.size() == CAPACITY) {
				System.out.println("���������ģ������������...");
				full.await();
			}
			// ������δ������������֮����������
			queue.offer(value);
			// �򻺴����ǿ����������ź�
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
			// ��������Ϊ��ʱ�򣺵ȴ��ǿ�����
			while (queue.isEmpty()) {
				System.out.println("�����ǿյģ�������ٳ�...");
				empty.await();
			}
			// ��ȡ��ɾ������
			value = queue.remove();
			// �򻺴���δ�����������ź�
			full.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
			return value;
		}
	}
}
