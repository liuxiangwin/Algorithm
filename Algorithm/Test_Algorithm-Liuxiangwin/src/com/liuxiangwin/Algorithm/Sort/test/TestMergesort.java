package com.liuxiangwin.Algorithm.Sort.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestMergesort {
	//http://www.geeksforgeeks.org/forums/topic/google-interview-question-for-software-engineerdeveloper-fresher-about-strings/
	//http://www.geeksforgeeks.org/forums/forum/algorithms/
	
  //why is quick sort is better than Merge sort in practice
	//http://stackoverflow.com/questions/70402/why-is-quicksort-better-than-mergesort
	//http://stackoverflow.com/questions/680541/quick-sort-vs-merge-sort

	//数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，
	public void sort(int[] values) {		
		mergesort(values,0, values.length - 1);
	}

	private void mergesort(int[] data,int low, int high) {
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (low + high) / 2;
			// Sort the left side of the array
			mergesort(data,low, middle);
			// Sort the right side of the array
			mergesort(data,middle + 1, high);
			// Combine them both
			merge(data,low, middle, high);
		}
	}

	private void merge(int[] data, int low, int middle, int high) {			
		int[] helper = new int[data.length];		
		int third = low; // third 记录临时数组的索引  
		int center = middle + 1;		
		int tmp = low; // 缓存左数组第一个元素的索引  
		
		while (low <= middle && center <= high) {
			if (data[third] <= data[center]) {
				helper[third++] = data[low++];
			} else {
				helper[third++] = data[center++];
			}			
		}
		//// 剩余部分依次放入临时数组
		//（实际上两个while只会执行其中一个）  
		while (center <= high) {
			helper[third++] = data[center++];
		}
		
		while (low <= middle) {
			helper[third++] = data[low++];
		}
		// 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）  
        while (tmp <= high) {  
            data[tmp] = helper[tmp++];  
        }  
	}
	public static void main(String args[])
	{
		int[] data ={14 ,12, 15, 13, 11, 16};
		System.out.println(Arrays.toString(data));
		new TestMergesort().sort(data);
		System.out.println(Arrays.toString(data));
	}
}
//http://www.cnblogs.com/shudonghe/p/3302888.html
//http://blog.csdn.net/apei830/article/details/6591632
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

		TestMergesort sorter = new TestMergesort();
		sorter.sort(numbers);

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
			TestMergesort sorter = new TestMergesort();
			sorter.sort(numbers);
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
