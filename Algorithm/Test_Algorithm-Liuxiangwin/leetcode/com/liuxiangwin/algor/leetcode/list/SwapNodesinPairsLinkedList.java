package com.liuxiangwin.algor.leetcode.list;


public class SwapNodesinPairsLinkedList {
	
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		else if (head.next == null) {
			return head;
		} else {
			ListNode nextPair = head.next.next;  
			ListNode newHead = head.next;
			newHead.next = head;
			newHead.next.next = swapPairs(nextPair);
			return newHead;
			
		}
	}
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		SwapNodesinPairsLinkedList slt = new SwapNodesinPairsLinkedList();
		slt.printList(head);
		ListNode res = slt.swapPairs(head);
		slt.printList(res);

	}

}
