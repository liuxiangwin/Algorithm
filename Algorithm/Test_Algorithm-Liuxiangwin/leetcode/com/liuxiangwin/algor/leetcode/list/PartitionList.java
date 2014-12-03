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
 * 
 * 这道题就是说给定一个x的值，小于x都放在大于等于x的前面，
 * 并且不改变链表之间node原始的相对位置。每次看这道题我老是绕晕，
 * 纠结为什么4在3的前面。。其实还是得理解题意，4->3->5都是大于等3的数，
 * 而且这保持了他们原来的相对位置 。

     所以，这道题是不需要任何排序操作的，题解方法很巧妙。
 * 
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
				tmps = tmps.next;
			} else {
				tmpb.next = head;
				tmpb = tmpb.next;
			}
			head = head.next;
		}
		
		System.out.println("Smaller ");
		print(tmps);
		System.out.println("Bigger ");
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
