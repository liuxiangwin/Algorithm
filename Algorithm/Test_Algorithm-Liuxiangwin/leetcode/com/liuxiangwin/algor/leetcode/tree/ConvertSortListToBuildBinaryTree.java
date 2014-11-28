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
		int len = 0;
		ListNode dummy = head;
		while (dummy != null) {
			len++;
			dummy = dummy.next;
		}
		ListNode[] curr = new ListNode[1];
		curr[0] = head;
		return convert(curr, 0, len - 1);
	}

	private TreeNode convert(ListNode[] curr, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode left = convert(curr, start, mid - 1);
		TreeNode root = new TreeNode(curr[0].val);
		curr[0] = curr[0].next;
		TreeNode right = convert(curr, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
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
