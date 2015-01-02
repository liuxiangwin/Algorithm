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

	//������ҪO(n)�Ķ���ռ䣬������ҪO(log(n))�Ķ���ռ䣬ʱ�临�Ӷ�ΪO(nlog(n))��
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
		int third = low; // third ��¼��ʱ���������  
		int center = middle + 1;		
		int tmp = low; // �����������һ��Ԫ�ص�����  
		
		while (low <= middle && center <= high) {
			if (data[third] <= data[center]) {
				helper[third++] = data[low++];
			} else {
				helper[third++] = data[center++];
			}			
		}
		//// ʣ�ಿ�����η�����ʱ����
		//��ʵ��������whileֻ��ִ������һ����  
		while (center <= high) {
			helper[third++] = data[center++];
		}
		
		while (low <= middle) {
			helper[third++] = data[low++];
		}
		// ����ʱ�����е����ݿ�����ԭ������  
        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩  
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
 * ���Ӷȷ����� 
 * ���ڲ����˵ݹ飬��������Ϊn��������Ҫ��ʱ��ΪT(n)����ֽ����������Ϊn/2���� 
 * �������Ҫ��ʱ��ΪT(n/2)���ϲ���Ҫʱ�䦨(n)�������е�n>1ʱ��T(n)=2T(n/2)+��(n), 
 * ��n=1ʱ��T(1)=��(1) 
 * ������ݹ�ʽ���覨(1)=c,(cΪ����)����(n)=cn�� 
 * ����ʽ�ɵ�T(n/2)=2T(n/4)+��(n/2),T(n/4)=2T(n/8)+��(n/4)....���δ���ɵ� 
 * ���Կ�����T(n)=nT(1)+��(n)+2��(n/2)+4��(n/4)...+(2^lgn)��(n/(2^lgn)),���й���lgn����(n)��ӡ� 
 * ��T(n)=cn+cnlgn 
 * ���ԣ�ʱ�临�Ӷ�Ϊ����(nlgn) 
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
