package com.liuxiangwin.multithreading.test;

public class TestWorker implements Runnable {

	

	@Override
	public void run() {
		System.out.println("This is currently running on a separate thread, "
				+ "the id is: " + Thread.currentThread().getId());

	}
	
	public static void main(String[] args) {
		System.out.println("This is currently running on the main thread, "
				+ "the id is: " + Thread.currentThread().getId());
		TestWorker testwoker = new TestWorker();
		
		for (int i=0; i< 100; i++)
		{
			Thread thread = new Thread(testwoker);
			thread.start();	
			
		}
		
	}
}
