package com.liuxiangwin.algor.leetcode.list;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 17, 2014
// Source:   http://oj.leetcode.com/problems/linked-list-cycle/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20073231

//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class IsCycleLinkedList {
	
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast,slow; 
		fast = slow = head;
        //ֻҪ�л��ͻ�������ѭ��
		while (fast!=null && fast.next != null) {			
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		IsCycleLinkedList slt = new IsCycleLinkedList();
	}
}