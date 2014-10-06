package com.liuxiangwin.algor.leetcode.test;

// Analysis: http://blog.csdn.net/lilong_dream/article/details/19544995

// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class AddTwoNumbersWithLinkList {

	public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
	       int sum =0;
	 
	        ListNode newHead = new ListNode(0);
	        ListNode node1 = listNode1, 
	        node2 = listNode2, 
	        ressultNode = newHead;
	 
	        while(node1 != null || node2 != null){
	        	//Move to next node in list team one
	            if(node1 != null){
	                sum += node1.val;
	                node1 = node1.next;
	            }
	            //Move to next node in list team two
	            if(node2 != null){
	                sum += node2.val;
	                node2 = node2.next;
	            }
	 
	            ressultNode.next = new ListNode(sum%10);
	            ressultNode = ressultNode.next;
	            sum /= 10;//如果不到10 sum为加和值，如果为10保留1
	        }
	 
	        if(sum==1) 
	            ressultNode.next=new ListNode(1);
	 
	        return newHead.next;
	    }
	
	
	public void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}
    
	public static void main(String args[]) {
		ListNode l1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);

		l1.next = n2;
		n2.next = n3;

		ListNode l2 = new ListNode(5);
		ListNode n4 = new ListNode(6);
		ListNode n5 = new ListNode(4);
		l2.next = n4;
		n4.next = n5;

		AddTwoNumbersWithLinkList slt = new AddTwoNumbersWithLinkList();
		ListNode result = slt.addTwoNumbers(l1, l2);
		slt.print(result);
	}
}