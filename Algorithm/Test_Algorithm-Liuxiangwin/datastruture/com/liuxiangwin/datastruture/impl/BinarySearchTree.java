package com.liuxiangwin.datastruture.impl;

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
    // The     	Average	   Worst case
    // Space	O(n)	    O(n)
     //Search	O(log n)	O(n)
     //Insert	O(log n)	O(n)
     //Delete	O(log n)	O(n)

    /**
     * Implements an unbalanced binary search tree.
     * Note that all "matching" is based on the compareTo method.
     * @author Mark Allen Weiss
     */
    public class BinarySearchTree
    {
        /** The tree root. */
        private BinaryNode rootNode;
    	
    	/**
         * Construct the tree.
         */
        public BinarySearchTree( )
        {
            rootNode = null;
        }

        /**
         * Insert into the tree; duplicates are ignored.
         * @param element the item to insert.
         */
        public void insert(Comparable element )
        {
            rootNode = insert(element, rootNode );
        }

        /**
         * Remove from the tree. Nothing is done if x is not found.
         * @param element the item to remove.
         */
        public void remove( Comparable element )
        {
            rootNode = remove( element, rootNode );
        }

        /**
         * Find the smallest item in the tree.
         * @return smallest item or null if empty.
         */
        public Comparable findMin( )
        {
            return elementAt( findMin( rootNode ) );
        }

        /**
         * Find the largest item in the tree.
         * @return the largest item of null if empty.
         */
        public Comparable findMax( )
        {
            return elementAt( findMax( rootNode ) );
        }

        /**
         * Find an item in the tree.
         * @param element the item to search for.
         * @return the matching item or null if not found.
         */
        public Comparable find( Comparable element )
        {
            return elementAt( find( element, rootNode ) );
        }
        /**
         * Print the tree contents in sorted order.
         */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Empty tree" );
            else
                printTree( rootNode );
        }

        /**
         * Internal method to get element field.
         * @param node the node.
         * @return the element field or null if t is null.
         */
        private Comparable elementAt( BinaryNode node )
        {
            return node == null ? null : node.element;
        }

        /**
         * Internal method to insert into a subtree.
         * @param element the item to insert.
         * @param node the node that roots the tree.
         * @return the new root.
         */
        private BinaryNode insert( Comparable element, BinaryNode node )
        {
             //The node would be pass into with rootNode 
/* 1*/      if( node == null )
/* 2*/          node = new BinaryNode( element, null, null );
/* 3*/      else if( element.compareTo( node.element ) < 0 )
/* 4*/          node.left = insert( element, node.left );
/* 5*/      else if( element.compareTo( node.element ) > 0 )
/* 6*/          node.right = insert( element, node.right );
/* 7*/      else
/* 8*/          ;  // Duplicate; do nothing
/* 9*/      return node;
        }

		/**
		 * Internal method to remove from a subtree.
		 * 
		 * @param element
		 *            the item to remove.
		 * @param node
		 *            the node that roots the tree.
		 * @return the new root.
		 */
	    private BinaryNode remove(Comparable element, BinaryNode node) {
		if (node == null)
			return node; // Item not found; do nothing
		if (element.compareTo(node.element) < 0)
			node.left = remove(element, node.left);
		else if (element.compareTo(node.element) > 0)
			node.right = remove(element, node.right);
		else if (node.left != null && node.right != null) // Two children
		{
			node.element = findMin(node.right).element;
			node.right = remove(node.element, node.right);
		} else
			node = (node.left != null) ? node.left : node.right;
		return node;
	}

        /**
         * Internal method to find the smallest item in a subtree.
         * @param node the node that roots the tree.
         * @return node containing the smallest item.
         */
        private BinaryNode findMin( BinaryNode node )
        {
            /*if( node == null )
            {
            	return null;
            }                
            else if( node.left == null )
            {
            	return node;
            }                
            return findMin( node.left );*/
            
            
            if( node != null ){
            	while( node.left != null )
                    node = node.left;
            }
            return node;
            
        }

        /**
         * Internal method to find the largest item in a subtree.
         * @param node the node that roots the tree.
         * @return node containing the largest item.
         */
        private BinaryNode findMax( BinaryNode node )
        {
            if( node != null ){
            	while( node.right != null )
                    node = node.right;
            }
            return node;
        }

        /**
         * Internal method to find an item in a subtree.
         * @param element is item to search for.
         * @param node the node that roots the tree.
         * @return node containing the matched item.
         */
        private BinaryNode find( Comparable element, BinaryNode node )
        {
            if( node == null )
                return null;
            if( element.compareTo( node.element ) < 0 )
                return find( element, node.left );
            else if( element.compareTo( node.element ) > 0 )
                return find( element, node.right );
            else
                return node;    // Match
        }

        /**
         * Internal method to print a subtree in sorted order.
         * @param t the node that roots the tree.
         */
        private void printTree( BinaryNode t )
        {
            if( t != null )
            {
                printTree( t.left );
                System.out.println( t.element );
                printTree( t.right );
            }
        }
        
         /**
         * Make the tree logically empty.
         */
        public void makeEmpty( )
        {
            rootNode = null;
        }

        /**
         * Test if the tree is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return rootNode == null;
        }
               
            // Test program
        public static void main( String [ ] args )
        {
            BinarySearchTree binarySearchTree = new BinarySearchTree( );
            
            binarySearchTree.insert(new Integer(8));
            binarySearchTree.insert(new Integer(3));
            binarySearchTree.insert(new Integer(10));
            binarySearchTree.insert(new Integer(1));
            binarySearchTree.insert(new Integer(6));
            binarySearchTree.insert(new Integer(4));
            binarySearchTree.insert(new Integer(7));            
            binarySearchTree.insert(new Integer(14));
            binarySearchTree.insert(new Integer(13));
            
            System.out.println("The Min element is "+binarySearchTree.findMin());
            
            System.out.println("The Max element is "+binarySearchTree.findMax());
            
            System.out.println("The print tree is " );
            binarySearchTree.printTree();
            
            
            binarySearchTree.remove(new Integer(13));
           
        }
    }