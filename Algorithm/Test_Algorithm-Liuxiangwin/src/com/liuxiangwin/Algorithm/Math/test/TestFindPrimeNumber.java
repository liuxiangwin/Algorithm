package com.liuxiangwin.Algorithm.Math.test;

public class TestFindPrimeNumber {

	public static void main(String[] args) {
		// But the prime number is not definitely odd
		// it should include 2 it could divide by itself
		// findPrimeNumber(100);
		System.out.println("100 Math.sqrt "+Math.sqrt(100));
		int range = 100;
		//findPrimeNumberRight(range);
		
		isPrimeNumber(97);

	}

	// Find prime number
	private static void findPrimeNumberRight(int range) {
		for (int i = 0; i <= range; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}

		}

	}

	private static boolean isPrimeNumber(int number) {
		boolean prime = true;
		int squr = (int) Math.sqrt(number);
		for (int i = 2; i < squr; i++) {
			if (number % i == 0) {
				prime = false;
				break;
			}

		}
		return prime;

	}
	
	private static boolean isPrimeNumber_2(int number) {
		for(int i=2; 2*i<number;i++) {
	        if(number%i==0)
	            return false;
	    }
	    return true;
	}
	
	

}
