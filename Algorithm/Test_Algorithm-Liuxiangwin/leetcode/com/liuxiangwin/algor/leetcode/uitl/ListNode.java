package com.liuxiangwin.algor.leetcode.uitl;




public class ListNode {

		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
		
		public void print(ListNode head) {
			while (head != null) {
				System.out.print(head.val + "->");
				head = head.next;
			}
			System.out.println();
		}


}
