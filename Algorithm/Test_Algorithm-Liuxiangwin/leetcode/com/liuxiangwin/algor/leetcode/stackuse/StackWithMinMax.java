package com.liuxiangwin.algor.leetcode.stackuse;

import java.util.Stack;

public class StackWithMinMax extends Stack<Integer> {

	private Stack<Integer> minStack;
	private Stack<Integer> maxStack;

	public StackWithMinMax() {
		minStack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) { // Note the '=' sign here
			minStack.push(value);
		}
		if (value >= max()) {
			maxStack.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();

		if (value == min()) {
			minStack.pop();
		}
		if (value == max()) {
			maxStack.pop();
		}
		return value;
	}

	public int min() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			//Looks at the object at the top of 
			//this stack without removing it
			return minStack.peek();//
		}
	}

	public int max() {
		if (maxStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return maxStack.peek();
		}
	}
	
	public static void main(String args[])
	{
		StackWithMinMax min = new StackWithMinMax();
		min.push(4);
		min.push(5);
		min.push(3);
		min.push(2);
		System.out.println("the  max element is "+ min.max());
		System.out.println("the  min element is "+ min.min());
		
	}
}


class MinCircularArrayStack  {
	private final int DEFAULT_CAPACITY = 2;
	private int front, rear, count, minIndex;
	private Integer[] stack;
	
	public MinCircularArrayStack() {
		front = rear = count = minIndex= 0;
		stack = new Integer[DEFAULT_CAPACITY];		
		stack[minIndex]= Integer.MAX_VALUE;
	}

	public void pushstack(Integer element) {
		if (size() == stack.length){
			expandCapacity();
		}
		stack[rear] = element;		
		if((stack[rear]).compareTo((stack[minIndex]))<0)
		{
		   minIndex =rear;	
		}		
		rear = (rear + 1) % stack.length;
		count++;
	}
    

	public Integer popstack() throws Exception {
		if (isEmpty())
			throw new Exception("queue");
		
		rear=  rear == 0?stack.length-1:rear - 1;		
		Integer result = (Integer)stack[rear];
		stack[rear] = null;
		count--;
		return result;
	}
   
	
	public Integer min()
	{
		return stack[minIndex];
	}
	
	public Integer first() throws Exception {
		if (isEmpty())
			throw new Exception("queue");
		return stack[front];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public int size() {
		return count;
	}

	public void expandCapacity() {
		Integer[] larger = new Integer[stack.length * 2];

		for (int scan = 0; scan < count; scan++) {
			larger[scan] = stack[front];		
			front = (front + 1) % stack.length;
		}
		front = 0;
		rear = count;
		stack = larger;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		CircularArrayStack stack = new CircularArrayStack();
		
		stack.pushstack(5);
		stack.pushstack(7);
		stack.pushstack(0);
		stack.pushstack(9);
		
		System.out.println(stack.toString());
		
		System.out.println("The min element is "+ stack.min());
		System.out.println("Pop myselft circular stack");
		
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		
	

		
	}
}

