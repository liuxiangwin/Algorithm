package com.liuxiangwin.datastruture.impl;

import java.util.Stack;

//********************************************************************
//CircularArrayQueue.java       Authors: Alan-Liu
//
//Represents an array implementation of a queue in which the
//indexes for the front and rear of the queue circle back to 0
//when they reach the end of the array.
//***********************************************************


public class CircularArrayStack<T>  {
	private final int DEFAULT_CAPACITY = 2;
	private int front, rear, count;
	private T[] stack;

	// -----------------------------------------------------------------
	// Creates an empty queue using the default capacity.
	// -----------------------------------------------------------------
	public CircularArrayStack() {
		front = rear = count = 0;
		stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	// -----------------------------------------------------------------
	// Creates an empty queue using the specified capacity.
	// -----------------------------------------------------------------
	public CircularArrayStack(int initialCapacity) {
		front = rear = count = 0;
		stack = (T[]) (new Object[initialCapacity]);
	}

	// -----------------------------------------------------------------
	// Adds the specified element to the rear of the queue, expanding
	// the capacity of the queue array if necessary.
	// -----------------------------------------------------------------
	public void pushstack(T element) {
		if (count == stack.length)
		{
			expandCapacity();
		}		

		stack[rear] = element;

		rear = (rear + 1) % stack.length;

		count++;
	}

	// -----------------------------------------------------------------
	// Removes the element at the front of the queue and returns a
	// reference to it. Throws an EmptyCollectionException if the
	// queue is empty.
	// -----------------------------------------------------------------
	public T popstack() throws Exception {
		if (count == 0)
			throw new Exception("queue");
		
		rear=  rear == 0?stack.length-1:rear - 1;
		
		T result = stack[rear];
		stack[rear] = null;	

		count--;

		return result;
	}

	// -----------------------------------------------------------------
	// Returns a reference to the element at the front of the queue.
	// The element is not removed from the queue. Throws an
	// EmptyCollectionException if the queue is empty.
	// -----------------------------------------------------------------
	public T first() throws Exception {
		if (count == 0)
			throw new Exception("queue");

		return stack[front];
	}

	// -----------------------------------------------------------------
	// Returns true if this queue is empty and false otherwise.
	// -----------------------------------------------------------------
	public boolean isEmpty() {
		return (count == 0);
	}

	// -----------------------------------------------------------------
	// Returns the number of elements currently in this queue.
	// -----------------------------------------------------------------
	public int size() {
		return count;
	}

	// -----------------------------------------------------------------
	// Returns a string representation of this queue.
	// -----------------------------------------------------------------
	public String toString() {
		String result = "";
		int scan = 0;

		while (scan < count) {
			if (stack[scan] != null) {
				result += stack[scan].toString() + "\n";
			}
			scan++;
		}

		return result;

	}

	// -----------------------------------------------------------------
	// Creates a new array to store the contents of the queue with
	// twice the capacity of the old one.
	// -----------------------------------------------------------------
	public void expandCapacity() {
		T[] larger = (T[]) (new Object[stack.length * 2]);

		for (int scan = 0; scan < count; scan++) {
			larger[scan] = stack[front];
			//in order to retrieve element from original element 
			//(front +1) in order to index ++ move to next element
			front = (front + 1) % stack.length;
		}

		front = 0;
		rear = count;
		stack = larger;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		CircularArrayStack<Integer> stack = new CircularArrayStack<Integer>();
		
		stack.pushstack(5);
		stack.pushstack(7);
		stack.pushstack(0);
		stack.pushstack(9);
		
		System.out.println(stack.toString());
		
		System.out.println("Pop myselft circular stack");
		
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		System.out.println(stack.popstack());
		
		
		System.out.println(stack.toString());
		
		stack.pushstack(1);
		stack.pushstack(9);
		stack.pushstack(8);
		stack.pushstack(2);
		System.out.println(stack.toString());
		
		System.out.println(stack.popstack());
		/*Stack<Integer> jdkStack = new Stack<Integer>();
		jdkStack.add(1);
		jdkStack.add(9);
		System.out.println(jdkStack.toString());
		jdkStack.add(8);
		jdkStack.add(2);
		
		System.out.println(jdkStack.pop());
		jdkStack.add(7);
		
		System.out.println(jdkStack.toString());*/
		
		
		
	}
}
