package com.liuxiangwin.algor.leetcode.tree;
import com.liuxiangwin.algor.leetcode.uitl.BinaryTreeUtil;
import com.liuxiangwin.algor.leetcode.uitl.TreeNode;
import com.liuxiangwin.multithreading.lock.AssortedMethods;

public class TreeContainSubTree {
	//O(logm+longn)
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true; // The empty tree is a subtree of every tree.
		else
			return subTree(t1, t2);
	}

	/*
	 * Checks if the binary tree rooted at r1 contains the binary tree rooted at
	 * r2 as a subtree somewhere within it.
	 */
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null)
			return false; // big tree empty & subtree still not found.
		if (r1.val== r2.val) {
			if (matchTree(r1, r2))
				return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	/*
	 * Checks if the binary tree rooted at r1 contains the binary tree rooted at
	 * r2 as a subtree starting at r1.
	 */
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null)
			return true; // nothing left in the subtree
		if (r1 == null || r2 == null)
			return false; // big tree empty & subtree still not found
		if (r1.val != r2.val)
			return false; // data doesn'tmatch
		return (matchTree(r1.left, r2.left) 
				&& matchTree(r1.right, r2.right));
	}

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] array2 = { 2, 4, 5, 8, 9, 10, 11 };

		TreeNode t1 = BinaryTreeUtil.createTreeFromArray(array1);
		TreeNode t2 = BinaryTreeUtil.createTreeFromArray(array2);

		if (containsTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = { 1, 2, 3 };
		TreeNode t3 = BinaryTreeUtil.createTreeFromArray(array1);
		TreeNode t4 = BinaryTreeUtil.createTreeFromArray(array3);

		if (containsTree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}

}
