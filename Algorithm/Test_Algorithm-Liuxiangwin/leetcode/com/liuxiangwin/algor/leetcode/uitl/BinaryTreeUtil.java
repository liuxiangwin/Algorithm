package com.liuxiangwin.algor.leetcode.uitl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinaryTreeUtil {

	public static <T extends Comparable<?>> void printNode(TreeNode root) {
		int maxLevel = BinaryTreeUtil.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	
	
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length)
					done = true;
			}
			return root;
		} else {
			return null;
		}
	}
	
	
	private static <T extends Comparable<?>> void printNodeInternal(
			List<TreeNode> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BinaryTreeUtil.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BinaryTreeUtil.printWhitespaces(firstSpaces);

		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeNode node : nodes) {
			if (node != null) {
				System.out.print(node.val);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BinaryTreeUtil.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BinaryTreeUtil.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BinaryTreeUtil.printWhitespaces(endgeLines + endgeLines + i
							+ 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BinaryTreeUtil.printWhitespaces(1);

				BinaryTreeUtil.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BinaryTreeUtil.printWhitespaces(1);

				BinaryTreeUtil.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(TreeNode node) {
		if (node == null)
			return 0;

		return Math.max(BinaryTreeUtil.maxLevel(node.left),
				BinaryTreeUtil.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
}
