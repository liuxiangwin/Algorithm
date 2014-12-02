package com.liuxiangwin.algor.leetcode.tree;

import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

//For example,

	//   1
	//  / \
	// 2   3

//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Return the sum = 12 + 13 = 25.


public class SumRootToLeafIntegerNumbers {

	private int ans;

	private void sum(TreeNode root, int cur) {
		if (root != null) {
			return;
		}
		if (root.left != null || root.right != null) {
			sum(root.left, cur * 10 + root.val);
			sum(root.right, cur * 10 + root.val);
		} else {
			ans += cur * 10 + root.val;
		}
	}

	private int sumNumbers(TreeNode root) {
		ans = 0;
		sum(root, 0);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
