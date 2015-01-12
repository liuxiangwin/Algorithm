package com.liuxiangwin.multithreading.blockingqueue.produceconsume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferQueue {

	// ����������
	private static final int CAPACITY = 1;

	// ��LinkedList����FIFO����
	private LinkedList<Integer> queue = new LinkedList<Integer>();

	// ���廥����
	private static Lock lock = new ReentrantLock();

	// �������������ǿ�
	private static Condition notEmpty = lock.newCondition();
	// ����������������
	private static Condition notFull = lock.newCondition();

	// �ӻ�������ȡ����
	public void put(int value) {
		lock.lock();
		try {
			while (queue.size() == CAPACITY) {
				System.out.println("�ȴ�������δ��");
				notFull.await();
			}

			// ������δ������������֮����������
			queue.offer(value);
			// �򻺴����ǿ����������ź�
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
			// ��������Ϊ��ʱ�򣺵ȴ��ǿ�����
			while (queue.isEmpty()) {
				System.out.println("\t\t\t�ȴ����ѷǿ�����");
				notEmpty.await();
			}

			// ��ȡ��ɾ������
			value = queue.remove();
			// �򻺴���δ�����������ź�
			notFull.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
			return value;
		}
	}
}
