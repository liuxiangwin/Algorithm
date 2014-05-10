package com.liuxiangwin.datastruture.impl;

public class ListImpl<T> {
	private final int DEFAULT_CAPACITY = 2;
	private int rear, count;
	private T[] list;

	public ListImpl() {
		rear = count = 0;
		list = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public ListImpl(int initialCapacity) {
		rear = count = 0;
		list = (T[]) (new Object[initialCapacity]);
	}

	public void add(T element) {
		if (this.size() == list.length) {
			expandCapacity();
		}
		list[rear++] = element;
		count++;
	}

	public T get(int index) throws Exception {
		if (index < 0 || index > list.length) {
			throw new Exception("out of index");
		}
		return list[index];
	}

	public void remove(int index) throws Exception {
		if (index < 0 || index > list.length) {
			throw new Exception("out of index");
		}
		T remove = list[index];
		list[index] = null;
		for (int i = 0; i < count - index - 2; i++) {
			list[index+i] = list[index+i + 1];
		}

	}

	public void expandCapacity() {
		T[] larger = (T[]) new Object[DEFAULT_CAPACITY * 2];

		for (int i = 0; i < count; i++) {
			larger[i] = list[i];
		}
		list = larger;
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
			if (list[scan] != null) {
				result += list[scan].toString() + "\n";
			}
			scan++;
		}

		return result;
	}

	public static void main(String args[]) throws Exception {
		ListImpl<Integer> list = new ListImpl<Integer>();

		list.add(5);

		list.add(7);

		list.add(0);

		list.add(9);

		System.out.println(list.toString());
		
		list.remove(1);
		
		System.out.println(list.toString());

		

	}
}
