package com.liuxiangwin.datastruture.impl;


// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of package DataStructures

public class BinaryNode
{
    // Friendly data; accessible by other package routines
	public Comparable element;      // The data in the node
	public BinaryNode left;         // Left child
	public BinaryNode right;        // Right child
	
	private BinaryNode parent;     //Parent reference
	
	
	// Constructors
	public BinaryNode(Comparable theElement )
    {
        this(theElement, null, null );
    }

	public BinaryNode(Comparable theElement, BinaryNode left, BinaryNode right )
    {
        this.element  = theElement;
        this.left     = left;
        this.right    = right;
    }

	public Comparable getElement() {
		return element;
	}

	public void setElement(Comparable element) {
		this.element = element;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public BinaryNode getParent() {
		return parent;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}


}
