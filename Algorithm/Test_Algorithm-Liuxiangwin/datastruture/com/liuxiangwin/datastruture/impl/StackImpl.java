package com.liuxiangwin.datastruture.impl;

import java.util.ArrayList;
import java.util.Arrays;

public class StackImpl<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public StackImpl() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	public void push(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;

	}
	@SuppressWarnings("unchecked")
	public E pop() {
		E e = (E) elements[--size];
		elements[size] = null;
		return e;
	}
	
	public static void main(String args[])
	{
		StackImpl<Integer> stack=new StackImpl<Integer>();
		stack.push(2011);
		stack.push(2012);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("1 << 30  "+(1 << 30));
		
		
		
		
	}
}

class StackImplByList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;

	public E pop() {
		E e = get(size() - 1);
		remove(size() - 1);
		return e;
	}

	public void push(E e) {
		add(e);
	}

}

