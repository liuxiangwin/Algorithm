package com.liuxiangwin.web.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
	private static ThreadPoolManager tpm = new ThreadPoolManager();

	// �̳߳�ά���̵߳���������

	private final static int CORE_POOL_SIZE = 4;

	// �̳߳�ά���̵߳��������

	private final static int MAX_POOL_SIZE = 10;

	// �̳߳�ά���߳�������Ŀ���ʱ��

	private final static int KEEP_ALIVE_TIME = 0;

	// �̳߳���ʹ�õĻ�����д�С

	private final static int WORK_QUEUE_SIZE = 10;

	// ��Ϣ�������

	Queue msgQueue = new LinkedList();

	public static ThreadPoolManager newInstance() {
		return tpm;
	}

	private ThreadPoolManager() {
	}

	// ������Ϣ����ĵ����߳�

	final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

			System.out.println(((AccessDBThread) r).getMsg() + "��Ϣ������������µȴ�ִ��");
			msgQueue.offer(((AccessDBThread) r).getMsg());

		}

	};
	// �������ݿ���ʵ��̳߳�
    //This is JDK concurrent threadpool
	final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
			CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
			new ArrayBlockingQueue(WORK_QUEUE_SIZE), this.handler);
	// �����̳߳�
	final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	final Runnable accessBufferThread = new Runnable() {

		@Override
		public void run() {
			// �鿴�Ƿ��д�����������У��򴴽�һ���µ�AccessDBThread������ӵ��̳߳���
			// if( hasMoreAcquire())
			if (!msgQueue.isEmpty()) {
				String msg = (String) msgQueue.poll();
				Runnable task = new AccessDBThread(msg);
				threadPool.execute(task);
			}

		}

	};

	final ScheduledFuture taskHandler = scheduler.scheduleAtFixedRate(
			accessBufferThread, 0, 1, TimeUnit.SECONDS);

	public void addLogMsg(String msg)

	{

		Runnable task = new AccessDBThread(msg);

		threadPool.execute(task);

	}

}
