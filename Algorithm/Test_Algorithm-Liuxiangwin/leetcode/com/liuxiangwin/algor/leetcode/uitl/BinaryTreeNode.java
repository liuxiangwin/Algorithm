package com.liuxiangwin.algor.leetcode.uitl;

public class BinaryTreeNode {
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode parent;

	public BinaryTreeNode(int x) {
		val = x;
		parent = null;
		left = right = this;
	}
	

	
	public void setLeft(BinaryTreeNode newLeft) {
		if (Integer.valueOf(val) == null) {
			return;
		}
		if (left != null && left.parent == this) {
			left.parent = null;
		}
		left = newLeft;
		left.parent = this;
	}
	
	
	public void setRight(BinaryTreeNode newRight) {
		if (Integer.valueOf(val) == null) {
			return;
		}
		if (right != null && right.parent == this) {
			right.parent = null;
		}
		right = newRight;
		right.parent = this;
	}

	

}
