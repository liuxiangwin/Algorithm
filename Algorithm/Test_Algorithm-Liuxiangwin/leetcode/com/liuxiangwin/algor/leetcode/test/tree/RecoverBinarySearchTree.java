package com.liuxiangwin.algor.leetcode.test.tree;

import com.liuxiangwin.algor.leetcode.uitl.*;

public class RecoverBinarySearchTree {

	private TreeNode mistake1, mistake2;;
	private TreeNode pre;

	public void recursive_traversal(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			recursive_traversal(root.left);
		}
		if (pre != null && root.val < pre.val) {
			if (mistake1 == null) {
				mistake1 = pre;
				mistake2 = root;
			} else {
				mistake2 = root;
			}
		}
		pre = root;
		if (root.right != null) {
			recursive_traversal(root.right);
		}
	}

	public void recoverTree(TreeNode root) {
		// pre必须设为null，通过遍历的时候设进去。因为是中序遍历，所以pre应该是深层叶子左子树的父节点。
		recursive_traversal(root);
		if (mistake1 != null && mistake2 != null) {
			int tmp = mistake1.val;
			mistake1.val = mistake2.val;
			mistake2.val = tmp;
		}
	}
	
	


}


class Solution2 {
	
	private TreeNode p, q;
	private TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		getWrong(root);
		int tmp = p.val;
		p.val = q.val;
		q.val = tmp;
	}
	//中序遍历。p为最左边的错误节点，q为最右边的错误节点。
	public void getWrong(TreeNode root) {
		getWrong(root.left);
		if (pre != null && root.val < pre.val) {
			if (p == null) {
				p = pre;
				q = root;
			} else {
				q =root;
			}
		}
		pre = root;
		getWrong(root.right);
	}
}