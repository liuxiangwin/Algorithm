package com.liuxiangwin.Algorithm.Stack.test;

import java.util.Arrays;

public class TestMaxInQueue {

	private MaxInQueue stackA;
	private MaxInQueue stackB;

	public TestMaxInQueue(int capacity) {
		stackA = new MaxInQueue(capacity);
		stackB = new MaxInQueue(capacity);
	}

	public void enqueue(int item) {
		stackB.push(item);
	}

	public int dequeue() {
		if (stackA.isEmpty()) {
			while (!stackB.isEmpty())
				stackA.push(stackB.pop());
		}
		return stackA.pop();
	}

	public int getMax() {
		return Math.max(stackA.getMaxElemenInArray(),
				stackB.getMaxElemenInArray());
	}
	//elements_Array [1, 4, 2, 8, 0, 0, 0, 0, 0, 0]
	//suplyEle_Array [0, 1, -1, 3, 0, 0, 0, 0, 0, 0](Position)
	public static void main(String[] args) {
		MaxInQueue mxt = new MaxInQueue(10);
		mxt.push(1);
		mxt.push(4);
		mxt.push(2);
		mxt.push(8);
		System.out.println("elements_Array "+Arrays.toString(mxt.elements));
		System.out.println("suplyElements_Array "+Arrays.toString(mxt.suplyElements));
		
		
		for (int i = 0; i < 4; i++) {
			System.out.println("The pop MaxInQueue " + mxt.pop());
			System.out.println("The Max int MaxInQueue "
					+ mxt.getMaxElemenInArray());
		}
		TestMaxInQueue maxInQueue = new TestMaxInQueue(10);
		maxInQueue.enqueue(8);
		maxInQueue.enqueue(4);
		maxInQueue.enqueue(2);
		maxInQueue.enqueue(1);
		for (int i = 0; i < 4; i++) {
			System.out.println("The  DeQueue " + maxInQueue.dequeue());
			System.out.println("The Max int MaxInQueue " + maxInQueue.getMax());
		}
	}

}

class MaxInQueue {
	private int capacity;
	public int[] elements;
	private int maxElementsIndex;
	private int elementStart;
	public int[] suplyElements;

	public MaxInQueue(int size) {
		capacity = size;
		elementStart = -1;
		maxElementsIndex = -1;
		elements = new int[size];
		suplyElements = new int[size];

	}

	public void push(int item) {
		elementStart++;
		if (elementStart >= capacity) {
			throw new IndexOutOfBoundsException("");
		} else {
			elements[elementStart] = item;
			if (item > getMaxElemenInArray()) {
				maxElementsIndex = elementStart;
				suplyElements[elementStart] = maxElementsIndex;
			} else {
				suplyElements[elementStart] = -1;
			}
		}
	}

	public int pop() {
		int rt = 0;
		if (elementStart < 0) {
			// throw new Exception("Queue is null");
		}
		rt = elements[elementStart];
		if (elementStart == maxElementsIndex) {
			maxElementsIndex = suplyElements[elementStart];
		}
		elementStart--;
		return rt;
	}

	public int getMaxElemenInArray() {
		if (maxElementsIndex >= 0)
			return elements[maxElementsIndex];
		else
			return -1;
	}

	public boolean isEmpty() {
		return elementStart == -1;
	}

}