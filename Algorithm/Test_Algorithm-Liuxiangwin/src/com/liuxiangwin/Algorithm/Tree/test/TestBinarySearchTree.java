package com.liuxiangwin.Algorithm.Tree.test;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss
 */
public class TestBinarySearchTree {

	/** The tree root. */
	private BinaryNode root;

	/**
	 * Construct the tree.
	 */
	public TestBinarySearchTree() {
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	public void insert(Comparable x) {
		root = insert(x, root);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * 
	 * @param x
	 *            the item to remove.
	 */
	public void remove(Comparable x) {
		root = remove(x, root);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public Comparable findMin() {
		return elementAt(findMin(root));
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item of null if empty.
	 */
	public Comparable findMax() {
		return elementAt(findMax(root));
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find(Comparable x) {
		return elementAt(find(x, root));
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	/**
	 * Internal method to get element field.
	 * 
	 * @param t
	 *            the node.
	 * @return the element field or null if t is null.
	 */
	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @param root
	 *            the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode insert(Comparable x, BinaryNode root) {
		if (root == null)
			root = new BinaryNode(x, null, null);

		else if (x.compareTo(root.element) < 0)
			root.left = insert(x, root.left);
		else if (x.compareTo(root.element) > 0)
			root.right = insert(x, root.right);
		else
			; // Duplicate; do nothing
		return root;
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x
	 *            the item to remove.
	 * @param root
	 *            the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode remove(Comparable x, BinaryNode root) {
		if (root == null)
			return root; // Item not found; do nothing
		if (x.compareTo(root.element) < 0)
			root.left = remove(x, root.left);
		else if (x.compareTo(root.element) > 0)
			root.right = remove(x, root.right);
		else if (root.left != null && root.right != null) // Two children
		{
			root.element = findMin(root.right).element;
			root.right = remove(root.element, root.right);
		} else
			root = (root.left != null) ? root.left : root.right;
		return root;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param root
	 *            the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	private BinaryNode findMin(BinaryNode root) {
		if (root == null)
			return null;
		else if (root.left == null)
			return root;
		return findMin(root.left);
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param root
	 *            the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private BinaryNode findMax(BinaryNode root) {
		if (root != null)
			while (root.right != null)
				root = root.right;

		return root;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x
	 *            is item to search for.
	 * @param root
	 *            the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BinaryNode find(Comparable x, BinaryNode root) {
		if (root == null)
			return null;
		if (x.compareTo(root.element) < 0)
			return find(x, root.left);
		else if (x.compareTo(root.element) > 0)
			return find(x, root.right);
		else
			return root; // Match
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param root
	 *            the node that roots the tree.
	 */
	private void printTree(BinaryNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.println(root.element);
			printTree(root.right);
		}
	}

	public boolean isBalanced(BinaryNode root) {
		if (root == null) {
			return true; // tree is empty
		} else {
			int lh = root.left.height;
			int rh = root.right.height;
			if (lh - rh > 1 || rh - lh > 1) {
				return false;
			}

			return true;
		}
	}

}

class BinaryNode {

	public Comparable element;

	public BinaryNode left;

	public BinaryNode right;

	public int height;

	public BinaryNode(Comparable element, BinaryNode left, BinaryNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

}