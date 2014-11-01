package com.liuxiangwin.algor.leetcode.list;

public class MergeTwoLinkedLists {

	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

		ListNode fakeHead = new ListNode(0);
		ListNode current =fakeHead;        

		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				current.next = head1;
				head1 = head1.next;
			} else {
				current.next = head2;
				head2 = head2.next;
			}
			current = current.next;
		}
		
		if (head1 != null)
			current.next = head1;
		if (head2 != null)
			current.next = head2;

		return fakeHead.next;
	}
	
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {

		ListNode head1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(6);
		head1.next = n2;
		n2.next = n3;

		ListNode head2 = new ListNode(3);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(5);
		head2.next = n4;
		n4.next = n5;
		
		MergeTwoLinkedLists mergeTwo = new MergeTwoLinkedLists();
		mergeTwo.printList(head1);
		mergeTwo.printList(head2);
		
		ListNode  sortHead = mergeTwo.mergeTwoLists(head1, head2);
		mergeTwo.printList(sortHead);

	}

}
