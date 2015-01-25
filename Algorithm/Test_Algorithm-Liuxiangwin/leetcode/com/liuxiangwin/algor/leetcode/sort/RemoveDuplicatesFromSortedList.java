package com.liuxiangwin.algor.leetcode.sort;

import com.liuxiangwin.algor.leetcode.uitl.ListNode;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/22752179

// Given a sorted linked list, delete all duplicates such that each element appear only once.
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3. 

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

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {
			//没有重复元素
			if (fast.val != slow.val) {
				slow = fast;
				fast = fast.next;
				continue;
			}
           //出现重复元素,only move the current pointer
			while (fast.next != null && fast.next.val == slow.val) {
				fast = fast.next;
			}
            //1----->1------>2
			//   P.next
			// Current.next
			slow.next = fast.next;
			fast = slow.next;
		}

		return head;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast.next!=null){
			if(slow.val!=fast.val){					
				slow= slow.next;
				slow.val= fast.val;						
			}
			fast =fast.next;
		}
		return head;
	}
	
	public void printList(ListNode res){
		while(res != null) {
			System.out.print(res.val + " ->");
			res = res.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList slt = new RemoveDuplicatesFromSortedList();
		// Given 1->1->2->3->3, return 1->2->3. 
		ListNode n1 = buildList();
		
		slt.printList(n1);
		ListNode res = slt.deleteDuplicates(n1);
		slt.printList(res);
	    System.out.println("---------------");
	    n1 = buildList();
		slt.printList(n1);
		ListNode res2 = slt.deleteDuplicates2(n1);
		slt.printList(res2);
		
	}

	private static ListNode buildList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		return n1;
	}
}