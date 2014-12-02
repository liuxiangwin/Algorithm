package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
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
		return sortedListToBST(head, null);
	}

	private TreeNode sortedListToBST(ListNode head, ListNode end) {
		if (head == end) {
			return null;
		} else if (head.next == end) {
			return new TreeNode(head.val);
		} else {
			ListNode fast = head, slow = head;
			while (fast.next != end && fast.next.next != end) {
				fast = fast.next.next;
				slow = slow.next;
			}
			TreeNode left = sortedListToBST(head, slow);
			TreeNode right = sortedListToBST(slow.next, end);
			TreeNode root = new TreeNode(slow.val);
			root.left = left;
			root.right = right;
			return root;
		}
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

		ConvertSortListToBuildBinaryTree binaryTree = new ConvertSortListToBuildBinaryTree();
		binaryTree.printList(head);
		TreeNode treeNode = binaryTree.sortedListToBST(head);
		BinaryTreePrinter.printNode(treeNode);
	}
}
