package com.liuxiangwin.algor.leetcode.queuestack;

import java.util.EmptyStackException;

public class ArrayImpThreeStack {
	private static int stackSize = 10;//每个小区域存10个元素
	private static int[] buffer = new int[stackSize * 3];

	// 3 stack pointers to keep track of the index of the top element
	static int[] stackPointer = { -1, -1, -1 };

	public static void push(int stackNum, int value) throws Exception {
		/* Check that we have space for the next element */
		if (stackPointer[stackNum] + 1 >= stackSize) {
			throw new Exception();
		}
		/* Increment stack pointer and then update top value */
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	public static int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int value = buffer[absTopOfStack(stackNum)]; // Get top
		buffer[absTopOfStack(stackNum)] = 0; // Clear index
		stackPointer[stackNum]--; // Decrement pointer
		return value;
	}

	private static int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return buffer[absTopOfStack(stackNum)];
	}

	private static boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	/* returns index of the top of the stack "stackNum", in absolute terms */
	private static int absTopOfStack(int stackNum) {
		return stackNum * stackSize + stackPointer[stackNum];
	}
	
	public static void main(String[] args) throws Exception {
		push(2, 4);
		System.out.println("Peek 2: " + peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
	}

}
