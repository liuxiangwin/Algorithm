package com.Alogrithm.javabasic.test;

public class TestStringBufferToStringBuilder {
	 /**
	  * Simply use StringBuilder unless you really are trying to share a buffer between threads. 
	  * StringBuilder is the unsynchronized (less overhead = more efficient) 
	  * younger brother of the original synchronized StringBuffer class.

		StringBuffer came first. Sun was concerned with correctness under all conditions,
		 so they made it synchronized to make it thread-safe just in case.

		StringBuilder came later. Most of the uses of 
		StringBuffer were single-thread and unnecessarily paying the cost of the synchronization.
	  */
	private static void compareStringBufferToStringBuilder() {
		int N = 77777777;
		long t;

		StringBuffer stringBuffer = new StringBuffer();
		t = System.currentTimeMillis();
		for (int i = N; i-- > 0;) {
			stringBuffer.append("");
		}
		System.out.println(System.currentTimeMillis() - t);

		StringBuilder stringBuilder = new StringBuilder();
		t = System.currentTimeMillis();
		for (int i = N; i-- > 0;) {
			stringBuilder.append("");
		}
		System.out.println(System.currentTimeMillis() - t);
	}
	 
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compareStringBufferToStringBuilder();

	}

}
