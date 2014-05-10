package com.liuxiangwin.Algorithm.Stack.test;

import java.util.ArrayList;
import java.util.Stack;


public class TestMinInStack<T> {
	
	public ArrayList<T> stack = new ArrayList<T>();
	
	// Record the Min elements in the stack
	//MinStack is used to record the min element position
	public ArrayList<Integer> minStack = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TestMinInStack<Integer> stackTest = new TestMinInStack<Integer>();
		stackTest.push(4);
		stackTest.push(6);
		stackTest.push(2);
		stackTest.push(5);
		System.out.println(stackTest.minStack);
		System.out.println(5 == stackTest.peek());

		System.out.println(stackTest.stack);
		
		System.out.println("After push the element "+stackTest.getMinElement());

		stackTest.pop();
		stackTest.pop();
		stackTest.push(1);
		System.out.println(stackTest.getMinElement());
		
		Stack<Integer> stacIntegers  = new Stack<Integer>();
		stacIntegers.push(5);
		stacIntegers.push(7);
		stacIntegers.push(0);
		stacIntegers.push(9);
		
		System.out.println("Find min value in the stack "+findMinInStack(stacIntegers));
	}

	private static int  findMinInStack(Stack<Integer> stack){
		int minValue =0;
		while (!stack.isEmpty())
		{
			Integer current = stack.pop();
			
			if(current.intValue() < minValue){
				minValue= current.intValue();
			}
			
		}
		
		return minValue;
	}
	

	public T pop() {
		int size = stack.size();
		minStack.remove(size - 1);
		return stack.remove(size - 1);
	}

	public void push(T newItem) {
		int stackSize = stack.size();

		if (stackSize == 0) {
			minStack.add(0);
		} else {
			int minPosition = minStack.get(stackSize - 1);
			T minData = stack.get(minPosition);

			if (min(newItem,minData)) {
				//1.The new element is smaller than previous element,so 
				//it should store the current element position in Minstack
				//it is the current stack.size===position
				//2.before the stack push the current element size
				int position=stackSize;
				minStack.add(position);
			} else {
				//The min element is still,so it still keep  
				//min element postion
				minStack.add(minPosition);
			}
		}

		stack.add(newItem);
	}

	public T peek() {
		int size = stack.size();
		return stack.get(size - 1);
	}

	public T getMinElement() {
		//int size = minStack.size();		
		int size=stack.size();
		// get minstatck last element .it is min element position in the stack
		return stack.get(minStack.get(size - 1));
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	
	private boolean min(T item,T minData ) {
		// 这儿不同的泛型类型可以用不同的方式实现
		int a = (Integer) item;
		int b = (Integer) minData;
		
		return a < b ? true : false;

	}
}
