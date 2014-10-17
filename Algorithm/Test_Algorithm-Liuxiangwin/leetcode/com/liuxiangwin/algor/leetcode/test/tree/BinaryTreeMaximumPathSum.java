package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class BinaryTreeMaximumPathSum {
/**
 * For example:
Given the below binary tree,
	  1
      / \
     2   3
  Return 6.
  
  DFS Ëã·¨ Maximum Subarray,Maximum Depth of Binary Tree
 */
	
	
	private int max;

	public int maxPath(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftValue = maxPath(root.left);
			int rigthValue = maxPath(root.right);
			int value = root.val;

			value += leftValue > 0 ? leftValue : 0;
			value += rigthValue > 0 ? rigthValue : 0;

			if (value > max) {
				max = value;
			}
			if (leftValue > rigthValue && leftValue > 0) {
				return root.val + leftValue;
			}
			if (rigthValue > leftValue && rigthValue > 0) {
				return root.val + rigthValue;
			}
			return root.val;
		}
	}

}
