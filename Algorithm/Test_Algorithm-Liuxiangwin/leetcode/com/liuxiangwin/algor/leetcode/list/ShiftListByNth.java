package com.liuxiangwin.algor.leetcode.list;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/rotate-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/19848277

// Given a list, rotate the list to the right by k places, where k is non-negative.
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

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

public class ShiftListByNth {
	public ListNode rotateRight(ListNode head, int kth) {
		if (head == null || kth == 0) {
			return head;
		}

		int length = 1;
		ListNode node = head;
		while (node.next != null) {
			++length;
			node = node.next;
		}

		node.next = head;

		int m = kth % length;

		for (int i = 0; i < length - m; ++i) {
			node = node.next;
		}

		head = node.next;

		node.next = null;

		return head;
	}
	
	private ListNode rotateRight2(ListNode head, int kth) {
	   ListNode fast,slow, tmp;
	   fast = slow =tmp = head;
	   
	   while(tmp.next!=null)
	   {
		   tmp =tmp.next; 
	   }
	   for(int i=0;i< kth;i++) {
		   fast = fast.next;		   
	   }
	   head = fast.next;
	   fast.next=null;
	   tmp.next=slow;
		
	   return head;
	}


	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ShiftListByNth slt = new ShiftListByNth();
		slt.printList(head);
		ListNode res = slt.rotateRight2(head, 2);
		slt.printList(res);
	}
}