package com.liuxiangwin.datastruture.impl;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class QueueImpl {
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	private int currentSize;
	private int front;
	private int back;

	public QueueImpl(int capacity) {
		elements = new Object[capacity];
		currentSize = 0;
		front = 0;
		back = 0;
	}

	public Object getFront() {
		if (isEmpty())
			return null;
		return elements[front];
	}

	public void enqueue(Object object) throws Exception {
		if (isFull()) {
			throw new Exception();
		}
		elements[back++] = object;
		//back = incrementIndex(back);
		//elements[back] = object;
		currentSize++;
	}

	public Object dequeue() {
		if (isEmpty())
			return null;
		currentSize--;

		Object frontItem = elements[front];
		// or it can be replaced by
		 elements[front++] = null;
		//elements[front] = null;
		//front = incrementIndex(front);
		return frontItem;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return currentSize == elements.length;
	}

	public void clear() {
		Arrays.fill(elements, null);
		front = 0;
		back = 0;
	}
	
	// increment the index
	private int incrementIndex(int index) {
		if (++index == elements.length) {
			index = 0;
		}
		return index;
	}
	public static void main(String[] args) {
		SoftReference<Object> softReference= new SoftReference(new Object());
		
		WeakReference<String> weakReference=new WeakReference("Ala_Liu");
		QueueImpl queue = new QueueImpl(10);
		try {
			queue.enqueue("2011");
			queue.enqueue("2012");

			System.out.println(queue.getFront());
			queue.dequeue();
			System.out.println(queue.getFront());

			// System.out.println(queue.);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try
		// {
		// for( int i = 0; i < 10; i++ )
		// q.enqueue( new Integer( i ) );
		// }
		// catch( Exception e ) { System.out.println( "Unexpected overflow" ); }
		//
		// while( !q.isEmpty( ) )
		// System.out.println( q.dequeue( ) );
	}

}
