package com.Alogrithm.javaInteview.test;


public class TestDeadLock extends Thread{
	private String s1;
	private String s2;
	
	public static void main(String[] args) throws Exception {
		
		//WeakReference<TestDeadLock> weakWidget = new WeakReference<TestDeadLock>(weakWidget);

		String s1 = "dead";
		String s2 = "lock";
		TestDeadLock t = new TestDeadLock(s1, s2);
		new Thread(t).start();
		t.printTwo();
	}

	public TestDeadLock(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void printOne() throws Exception {
		synchronized (s1) {
			Thread.sleep(10000);
			synchronized (s2) {
				System.out.println(s1 + s2);
			}
		}
	}

	public void printTwo() throws Exception {
		synchronized (s2) {
			Thread.sleep(10000);
			synchronized (s1) {
				System.out.println(s1 + s2);
			}
		}
	}

	public void run() {
		try {
			printOne();
		} catch (Exception e) {
		}
	}

	

}
