package com.liuxiangwin.algor.leetcode.list;

public class MergeSortLinkedList {

	/**
	 * merge_sort(list) { split list into two halfs, say first and second ;
	 * merge_sort(firstHalf); merge_sort(secondHalf);
	 * merge(firstHalf,secondHalf); } A working implementation in Java :
	 */

	public ListNode merge_sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMiddle(head); // get the middle of the list
		ListNode sHalf = middle.next;
		middle.next = null; // split the list into two halfs ¶Ï¿ªÁ´±í
		
		//Another way to implement
		//head = merge_sort(head);
		//sHalf = merge_sort(sHalf);
		//return merge(head, sHalf);
		
		return merge(merge_sort(head), merge_sort(sHalf)); // recurse on that
	}


	public ListNode merge(ListNode head_one, ListNode head_two) {
		ListNode head_three;

		if (head_one == null)
			return head_two;

		if (head_two == null)
			return head_one;

		if (head_one.val < head_two.val) {
			head_three = head_one;
			head_three.next = merge(head_one.next, head_two);
		} else {
			head_three = head_two;
			head_three.next = merge(head_one, head_two.next);
		}
		return head_three;
	}

	public ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow, fast;
		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
		mergeSortLinkedList.printList(head);
		ListNode resultNode = mergeSortLinkedList.merge_sort(head);
		mergeSortLinkedList.printList(resultNode);
	}
}
