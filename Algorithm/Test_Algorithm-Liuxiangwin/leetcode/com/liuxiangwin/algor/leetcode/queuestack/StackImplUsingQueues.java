package com.liuxiangwin.algor.leetcode.queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingQueues {
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();

	public int pop() {
		if (queue1.peek() == null) {
			System.out.println("The stack is empty, nothing to return");
			int i = 0;
			return i;
		} else {
			int pop = queue1.remove();
			return pop;
		}
	}

	public void push(int data) {

		if (queue1.peek() == null) {
			queue1.add(data);
		} else {
			for (int i = queue1.size(); i > 0; i--) {
				queue2.add(queue1.remove());
			}
			queue1.add(data);
			for (int j = queue2.size(); j > 0; j--) {
				queue1.add(queue2.remove());
			}

		}
	}

	public static void main(String[] args) {
		StackImplUsingQueues s1 = new StackImplUsingQueues();
		// Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		s1.push(3);
	/*	s1.push(4);
		s1.push(5);
		s1.push(6);
		s1.push(7);
		s1.push(8);
		s1.push(9);
		s1.push(10);*/
		// s1.push(6);
		System.out.println("1st = " + s1.pop());
		System.out.println("2nd = " + s1.pop());
		System.out.println("3rd = " + s1.pop());
		System.out.println("4th = " + s1.pop());	
		System.out.println("5th = " + s1.pop());
		System.out.println("6th = " + s1.pop());
		System.out.println("7th = " + s1.pop());
		System.out.println("8th = " + s1.pop());
		System.out.println("9th = " + s1.pop());
		System.out.println("10th= " + s1.pop());
	}
}
