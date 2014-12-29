package com.liuxiangwin.algor.leetcode.stackuse;



public class CircularArrayStack  {
	private final int DEFAULT_CAPACITY = 2;
	private int front, rear, count, minIndex;
	private Integer[] stack;


	public CircularArrayStack() {
		front = rear = count = minIndex= 0;
		stack = new Integer[DEFAULT_CAPACITY];		
		stack[minIndex]= Integer.MAX_VALUE;
	}

	
	public CircularArrayStack(int initialCapacity) {
		front = rear = count = 0;
		stack = new Integer[initialCapacity];
	}


	public void pushstack(Integer element) {
		if (size() == stack.length)
		{
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
		Integer[] larger = new Integer[stack.length * 2];

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
