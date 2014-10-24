package com.liuxiangwin.algor.leetcode.list;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/linked-list-cycle-ii/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20074373

// Given a linked list, return the node where the cycle begins. 
//If there is no cycle, return null.
//
// Follow up:
////使用快慢指针。若链表存在环，两指针必在环中相遇，此时将慢指针移回头结点，
//两指针以相同的速度移动，在环开始的节点处再次相遇。（证明略）

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
			fast = fast.next.next;

			if (fast == null) {
				return null;
			}

			slow = slow.next;

			if (fast == slow) {
				slow = head;

				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				
				return fast;
			}
		}

		return null;
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
		n5.next = n2;

		LinkedListCycleII slt = new LinkedListCycleII();
		ListNode result = slt.detectCycle(n1);
		System.out.println(result.val);
	}
}