package com.liuxiangwin.Algorithm.Sort.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * O(n\log n)
 * 
 * @author liuxiangwin
 *
 */
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
		N = numbers.length - 1;
		for (int index = N / 2; index >= 0; index--) {
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

	/**
	 * Standard heapsort.
	 * 
	 * @param number
	 *            an array of Comparable items.
	 */
	public static void heapsort(Comparable[] number) {
		for (int index = number.length / 2; index >= 0; index--) {
			/* buildHeap */
			percDown(number, index, number.length);
		}
		for (int i = number.length - 1; i > 0; i--) {
			swapReferences(number, 0, i); /* deleteMax */
			percDown(number, 0, i);
		}
	}
	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap.
	 * 
	 * @param number
	 *            an array of Comparable items.
	 * @index i the position from which to percolate down.
	 * @int n the logical size of the binary heap.
	 */
	private static void percDown(Comparable[] number, int i, int n) {
		int child;
		Comparable tmp;

		for (tmp = number[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && number[child].compareTo(number[child + 1]) < 0)
				child++;
			if (tmp.compareTo(number[child]) < 0)
				number[i] = number[child];
			else
				break;
		}
		number[i] = tmp;
	}
    

	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	/**
	 * Method to swap to elements in an array.
	 * 
	 * @param a
	 *            an array of objects.
	 * @param index1
	 *            the index of the first object.
	 * @param index2
	 *            the index of the second object.
	 */
	public static final void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	public static void main(String[] args) {
		 int[] number = { 99, 88, 77, 66, 33};

		//Integer[] number = { 99, 88, 77, 66, 33 };
		System.out.println(Arrays.toString(number));

		/* Call method sort */
		 heapSort(number);

		//heapsort(number);
		System.out.println(Arrays.toString(number));

		System.out.println(3 / 2);
	}

}
