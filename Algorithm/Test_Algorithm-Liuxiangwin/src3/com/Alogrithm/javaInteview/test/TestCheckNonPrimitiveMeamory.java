package com.Alogrithm.javaInteview.test;

public class TestCheckNonPrimitiveMeamory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long l1 = Runtime.getRuntime().freeMemory();
		//obj.clone();
		long l2 = Runtime.getRuntime().freeMemory();
		System.out.println((l1 - l2) + " bytes");
		

	}

}
