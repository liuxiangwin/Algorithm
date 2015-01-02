package com.liuxiangwin.Algorithm.Sort.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TesMergesort {
	//http://www.geeksforgeeks.org/forums/topic/google-interview-question-for-software-engineerdeveloper-fresher-about-strings/
	//http://www.geeksforgeeks.org/forums/forum/algorithms/
	
  //why is quick sort is better than Merge sort in practice
	//http://stackoverflow.com/questions/70402/why-is-quicksort-better-than-mergesort
	//http://stackoverflow.com/questions/680541/quick-sort-vs-merge-sort
	private int[] numbers;
	private int[] helper;
	private int length;

	// 归并排序 N
	public static void main(String[] args) {

	}

	public void mergeSort(int[] values) {
		numbers = values;
		length = values.length;
		helper = new int[length];
		mergesort(0, length - 1);
	}

	private void mergesort(int low, int high) {
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (low + high) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of 
		//the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

}
//http://www.cnblogs.com/shudonghe/p/3302888.html
/* 
 * 复杂度分析： 
 * 由于采用了递归，设解决长度为n的数组需要的时间为T(n)，则分解成两个长度为n/2的子 
 * 数组后，需要的时间为T(n/2)，合并需要时间Θ(n)。所以有当n>1时，T(n)=2T(n/2)+Θ(n), 
 * 当n=1时，T(1)=Θ(1) 
 * 解这个递归式，设Θ(1)=c,(c为常量)，则Θ(n)=cn。 
 * 有上式可得T(n/2)=2T(n/4)+Θ(n/2),T(n/4)=2T(n/8)+Θ(n/4)....依次带入可得 
 * 所以可以有T(n)=nT(1)+Θ(n)+2Θ(n/2)+4Θ(n/4)...+(2^lgn)Θ(n/(2^lgn)),其中共有lgn个Θ(n)相加。 
 * 即T(n)=cn+cnlgn 
 * 所以，时间复杂度为：Θ(nlgn) 
 */ 

class MergesortTest {

	private int[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;

	public MergesortTest() {

	}

	@Before
	public void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testMergeSort() {
		long startTime = System.currentTimeMillis();

		TesMergesort sorter = new TesMergesort();
		sorter.mergeSort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Mergesort " + elapsedTime);

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				fail("Should not happen");
			}
		}
		assertTrue(true);

	}

	@Test
	public void itWorksRepeatably() {
		for (int i = 0; i < 200; i++) {
			numbers = new int[SIZE];
			Random generator = new Random();
			for (int a = 0; a < numbers.length; a++) {
				numbers[a] = generator.nextInt(MAX);
			}
			TesMergesort sorter = new TesMergesort();
			sorter.mergeSort(numbers);
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					fail("Should not happen");
				}
			}
			assertTrue(true);
		}
	}

	@Test
	public void testStandardSort() {
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Standard Java sort " + elapsedTime);

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				fail("Should not happen");
			}
		}
		assertTrue(true);
	}

}
