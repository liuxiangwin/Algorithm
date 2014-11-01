package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.ListNode;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

/**
 * 
 * //Time Complexity: O(n) T(n) = 2T(n/2) + C T(n) --> Time taken for an array
 * of size n C --> Constant (Finding middle of array and linking root to left
 * and right subtrees take constant time)
 */

public class ConvertSortListToBuildBinaryTree {

	public TreeNode sortedListToBST(ListNode head) {
		ListNode mid = getMiddle(head);
		ListNode last = getLast(head);

		TreeNode node = new TreeNode(mid.val);

		node.left = sortedListToBST(head);
		node.right = sortedListToBST(mid.next);
		return node;

	}

	public ListNode getLast(ListNode head) {
		if (head == null) {
			return head;
		}
		while (head.next != null) {
			head = head.next;
		}
		return head;
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

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(9);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
	}
}
