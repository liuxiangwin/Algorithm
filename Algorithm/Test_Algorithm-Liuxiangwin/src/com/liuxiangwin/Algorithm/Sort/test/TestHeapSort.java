package com.liuxiangwin.Algorithm.Sort.test;

import java.util.Arrays;
import java.util.Scanner;

public class TestHeapSort {

	private static int N;

	/* Sort Function */
	public static void heapSort(int[] numbers) {
		buildHeap(numbers);
		
		for (int i = numbers.length - 1; i > 0; i--) {
			swap(numbers, 0, i);
			N = N - 1;
			maxheap(numbers, 0);
		}
	}

	/* Function to build a heap */
	public static void buildHeap(int[] numbers) {
		N = numbers.length-1;
		for (int index = N / 2; index >= 0; index--){
			maxheap(numbers, index);
		}
			
	}

	/* Function to swap largest element in heap */
	public static void maxheap(int[] numbers, int index) {
		int left = 2 * index;
		int right = 2 * index + 1;
		int max = index;
		if (left <= N && numbers[left] > numbers[index])
			max = left;
		if (right <= N && numbers[right] > numbers[max])
			max = right;

		if (max != index) {
			swap(numbers, index, max);
			maxheap(numbers, max);
		}
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] number = { 99, 88, 77, 66, 33, 45, 12, 100, 67 };
		System.out.println(Arrays.toString(number));  
		
		/* Call method sort */
		heapSort(number);
		
		System.out.println(Arrays.toString(number));           
		
		
		System.out.println(3/2); 
	}    
              
}
