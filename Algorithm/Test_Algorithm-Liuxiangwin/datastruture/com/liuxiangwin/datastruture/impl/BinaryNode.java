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


}
