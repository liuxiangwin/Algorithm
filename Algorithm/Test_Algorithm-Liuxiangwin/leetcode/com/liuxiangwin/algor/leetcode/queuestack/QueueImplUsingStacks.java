package com.liuxiangwin.algor.leetcode.queuestack;

import java.util.Stack;


public class QueueImplUsingStacks<E>
{

    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    public void enqueue(E item) {
        inbox.push(item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
    public static void main(String[] args) {
    	QueueImplUsingStacks<Integer> queue = new QueueImplUsingStacks<Integer>();
    	queue.enqueue(1);
    	queue.enqueue(2);
    	queue.enqueue(3);
    	queue.enqueue(4);
    	
    	System.out.println(queue.dequeue());
    	System.out.println(queue.dequeue());
    	System.out.println(queue.dequeue());
    	System.out.println(queue.dequeue());
    }
}