package com.liuxiangwin.algor.leetcode.list;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * 思路
 * 
 * 题意：这道题目就是在不改变链表原来顺序的情况下，将大于x的节点移到后面，小于x的节点移到前面
 * 解法：我们可以构建两个链表，一个链表存放所有小于x的节点，另一个链表存放所有大于x的节点，然后连接两个链表即可
 * 
 * @author liuxiangwin
 * //For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode smaller, bigger, tmps, tmpb;

		smaller = new ListNode(0);
		tmps = smaller;

		bigger = new ListNode(0);
		tmpb = bigger;

		while (head != null) {
			if (head.val < x) {
				tmps.next = head;
				tmps = head;
			} else {
				tmpb.next = head;
				tmpb = head;
			}

			head = head.next;
		}
		print(tmps);
		print(tmpb);
		
		tmpb.next = null;
		tmps.next = bigger.next;

		return smaller.next;
	}
	
	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//For example,
		//Given 1->4->3->2->5->2 and x = 3,
		//return 1->2->2->4->3->5.
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;

		PartitionList slt = new PartitionList();
		slt.print(a1);

		ListNode res = slt.partition(a1, 3);
		slt.print(res);
	}
}
