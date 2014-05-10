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
            if( node == null )
                return null;
            else if( node.left == null )
                return node;
            return findMin( node.left );
        }

        /**
         * Internal method to find the largest item in a subtree.
         * @param node the node that roots the tree.
         * @return node containing the largest item.
         */
        private BinaryNode findMax( BinaryNode node )
        {
            if( node != null )
                while( node.right != null )
                    node = node.right;

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
            // Test program
        public static void main( String [ ] args )
        {
            BinarySearchTree t = new BinarySearchTree( );
            final int NUMS = 4000;
            final int GAP  =   37;

            System.out.println( "Checking... (no more output means success)" );

            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                t.insert( new MyInteger( i ) );

            for( int i = 1; i < NUMS; i+= 2 )
                t.remove( new MyInteger( i ) );

           
            	t.printTree( );
          
                
            if( ((MyInteger)(t.findMin( ))).intValue( ) != 2 ||
                ((MyInteger)(t.findMax( ))).intValue( ) != NUMS - 2 )
                System.out.println( "FindMin or FindMax error!" );

            for( int i = 2; i < NUMS; i+=2 )
                 if( ((MyInteger)(t.find( new MyInteger( i ) ))).intValue( ) != i )
                     System.out.println( "Find error1!" );

            for( int i = 1; i < NUMS; i+=2 )
            {
                if( t.find( new MyInteger( i ) ) != null )
                    System.out.println( "Find error2!" );
            }
        }
    }