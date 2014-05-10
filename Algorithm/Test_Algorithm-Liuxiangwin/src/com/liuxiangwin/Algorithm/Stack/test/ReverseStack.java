package com.liuxiangwin.Algorithm.Stack.test;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {

	/**
	 * @param args
	 */
	private static Stack<Integer> stack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3, 4, 5 };
		stack = new Stack<Integer>();
		
		
		
		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);	}
		
		System.out.println("Before reverse the stack is: " + stack);
		new ReverseStack().reverseStack(stack);
		System.out.println("After reverse the stack is: " + stack);
	}

	private void reverseStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			Integer top = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, top);
		}
	}
     /**
      * The Elemen should push on the bottom bottom of the Stack!!
      * @param stack
      * @param topElement
      */
	private void insertAtBottom(Stack<Integer> stack, Integer topElement) {
		if (stack.isEmpty()) {
			stack.push(topElement);
			//Put the top element to the bottom of the stack
			//System.out.println("After push :: " + stack);
		} else {
			// Keep pop the element in the stack with first element
			Integer currentElement = stack.pop();
			//Recurive try to put the  frist element in the bottom of stack
			
			/* Hold all items in Function Call Stack until we reach end of 
		       the stack. When the stack becomes empty, the isEmpty(*top_ref) 
		       becomes true, the above if part is executed and the item is 
		       inserted at the bottom */
			
			insertAtBottom(stack, topElement);
			//Then push the currentElement
			
			/* Once the item is inserted at the bottom, push all the
	          items held in Function Call Stack */
			stack.push(currentElement);
			//System.out.println("After push :: " + stack);
		}

	}

}
