package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.BinaryTreePrinter;
import com.liuxiangwin.algor.leetcode.uitl.ListNode;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class SortListToBuildBinaryTree {
	/*private static ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}*/
	
	
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode c = head;
        while(c != null) {
             c = c.next;
             len++;
        }
        c = head;
        int[] num = new int[len];
        for(int i = 0; i < len; i++) {
            num[i] = c.val;
            c = c.next;
        }
        return helper(num, 0, len-1);
    }
    public TreeNode helper(int[] num, int l, int r) {
        if(l > r) return null;
        int m = (l+r) / 2;
        TreeNode root = new TreeNode(num[m]);
        root.left = helper(num, l, m-1);
        root.right = helper(num, m+1, r);
        return root;
    }
	
	
	public static void main(String args[]) {
		int[] number = { 9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
		SortListToBuildBinaryTree buildBinaryTree = new SortListToBuildBinaryTree();
		ListNode node = new ListNode(6);
		TreeNode root =buildBinaryTree.sortedListToBST(node);
		BinaryTreePrinter.printNode(root);
	}
}
