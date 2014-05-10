package com.liuxiangwin.Algorithm.Tree.test;

public class TestIsBinaryTree {

	private TestIsBinaryTree leftSon;
	private TestIsBinaryTree rightSon;
	private String value;

	public TestIsBinaryTree(String value, TestIsBinaryTree leftSon,
			TestIsBinaryTree rightSon) {
		this.leftSon = leftSon;
		this.rightSon = rightSon;
		this.value = value;
	}

	public static boolean IfCompletedTree(TestIsBinaryTree rootNode) {
		int depth = DepthCount(rootNode);

		if (rootNode == null) {
			return false;
		} else {
			return IfCompletedTree(rootNode.leftSon, 2, depth)
					& IfCompletedTree(rootNode.rightSon, 2, depth);
		}

	}

	static int DepthCount(TestIsBinaryTree rootNode) {
		if (rootNode == null) {
			return 0;
		} else if (rootNode.leftSon == null && rootNode.rightSon == null) {
			return 1;
		} else {
			int leftDepth = DepthCount(rootNode.leftSon);
			int rightDepth = DepthCount(rootNode.rightSon);
			return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
		}

	}

	static boolean IfCompletedTree(TestIsBinaryTree rootNode,
			int currentDepth, int depth) {

		if (rootNode == null) {
			if (currentDepth >= depth) {
				return true;
			} else {
				return false;
			}
		} else {
			return IfCompletedTree(rootNode.leftSon, currentDepth + 1, depth)
					& IfCompletedTree(rootNode.rightSon, currentDepth + 1,
							depth);
		}

	}
	
	
	
	public TestIsBinaryTree getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(TestIsBinaryTree leftSon) {
		this.leftSon = leftSon;
	}

	public TestIsBinaryTree getRightSon() {
		return rightSon;
	}

	public void setRightSon(TestIsBinaryTree rightSon) {
		this.rightSon = rightSon;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
