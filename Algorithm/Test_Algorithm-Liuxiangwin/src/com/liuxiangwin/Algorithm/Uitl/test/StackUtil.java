package com.liuxiangwin.Algorithm.Uitl.test;

import java.util.Stack;

public class StackUtil {
	public static void reverse(Stack<Integer> stack) {
		int floor = stack.size();
		while (floor > 0) {
			int top = stack.pop();
			down(stack, top, floor - 1);
			floor--;
		}
	}

	public static void down(Stack<Integer> stack, int element, int floor) {
		if (floor > 0) {
			int top = stack.pop();
			down(stack, element, floor - 1);
			stack.push(top);
		} else {
			stack.push(element);
		}
	}

}
