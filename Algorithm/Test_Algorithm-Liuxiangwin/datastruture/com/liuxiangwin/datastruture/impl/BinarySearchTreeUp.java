package com.liuxiangwin.datastruture.impl;


import java.util.Comparator;

/**
 * A binary search tree class with insertion, removal and lookup.
 * A comparator is used to order the items in the tree.  All tree
 * items must be distinct according to the comparator.  If no comparator
 * is supplied the natural order of tree elements is used.
 */
public class BinarySearchTreeUp<E> {

    /**
     * Root of the tree.
     */
    protected BinarySearchTreeUp<E> root = null;

    /**
     * Comparator used to order the items in the tree.  If null,
     * the natural order of the items will be used.
     */
    private Comparator<E> comparator;

    /**
     * Constructs an empty BST that can only accept Comparables
     * as items.
     */
    public BinarySearchTreeUp() {
        this(null);
    }

    /**
     * Constructs a BST that orders its items according to the
     * given comparator.
     */
    public BinarySearchTreeUp(Comparator<E> c) {
        comparator = c;
    }

    /**
     * Returns whether or not the tree contains an object with
     * the given value.
     */
    public boolean contains(E data) {
        return nodeContaining(data) != null;
    }




    /**
     * Rotates right around the given node.
     */
    protected void rotateRight(BinaryTreeNode<E> n) {
        if (n.getLeft() == null) {
            return;
        }
        BinaryTreeNode<E> oldLeft = n.getLeft();
        n.setLeft(oldLeft.getRight());
        if (n.getParent() == null) {
            root = oldLeft;
        } else if (n.getParent().getLeft() == n) {
            n.getParent().setLeft(oldLeft);
        } else {
            n.getParent().setRight(oldLeft);
        }
        oldLeft.setRight(n);
    }

 
}


	
	
}