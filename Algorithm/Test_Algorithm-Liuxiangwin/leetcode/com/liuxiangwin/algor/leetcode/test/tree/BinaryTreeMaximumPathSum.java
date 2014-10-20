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

	public int maxPath(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int leftValue = maxPath(node.left);
			int rigthValue = maxPath(node.right);
			int value = node.val;

			value += leftValue > 0 ? leftValue : 0;
			value += rigthValue > 0 ? rigthValue : 0;

			if (value > max) {
				max = value;
			}
			if (leftValue > rigthValue && leftValue > 0) {
				return node.val + leftValue;
			}
			if (rigthValue > leftValue && rigthValue > 0) {
				return node.val + rigthValue;
			}
			return node.val;
		}
	}

}
