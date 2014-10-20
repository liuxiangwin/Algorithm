package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.TreeNode;

public class ConstructTree {

	TreeNode BuildTreePI(int[] preorder, int[] inorder, int p_s, int p_e,
			int i_s, int i_e) {
		if (p_s > p_e)
			return null;
		int pivot = preorder[p_s];
		int i = i_s;
		for (; i < i_e; i++) {
			if (inorder[i] == pivot)
				break;
		}
		int length1 = i - i_s - 1;
		int length2 = i_e - i - 1;
		TreeNode node = new TreeNode(pivot);
		node.left = BuildTreePI(preorder, inorder, p_s + 1, length1 + p_s + 1,
				i_s, i - 1);
		node.right = BuildTreePI(preorder, inorder, p_e - length2, p_e, i + 1,
				i_e);
		return node;
	}

	TreeNode buildTree(int[] preorder, int[] inorder) {
		return BuildTreePI(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

}
