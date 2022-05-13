/*
(P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW97 - Prune Your Tree
2022-05-11
Time Spent: 1.0 hrs + classtime

DISCO
  * We simplified our remove method into three main cases: leaf nodes, nodes with 1 subtree, and nodes with 2 subtrees.
  * We used recursion for the case where the node had 2 subtrees.
QCC
  * How can we do remove() more recursively? Can this be optimized?

ALGO
Go to the node preceding the target we plan to remove.
CASE 1:
If we are removing a leaf, set the piggyback's left/right node to null.
  - If the target is the root, set the root to null.
CASE 2:
If we are removing a node with only one subtree, the set the piggyback's
left/right child to the target's left/right child.
  - If the target is the root, set the root to the target's left/right child.
CASE 3:
If we are removing a node with two subtrees, store the value of the rightmost
leaf of the subtree's left branch and remove that leaf.
Then, replace the value of the target node with the stored value.
*/

/**
 * class BST
 * v2:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()

  /**
   * void remove( int )
   * removes a node from the tree
   * ALGO:
   * Go to the node preceding the target we plan to remove.
   * CASE 1:
   * If we are removing a leaf, set the piggyback's left/right node to null.
   *    If the target is the root, set the root to null.
   * CASE 2:
   * If we are removing a node with only one subtree, the set the piggyback's
   * left/right child to the target's left/right child.
   *    If the target is the root, set the root to the target's left/right child.
   * CASE 3:
   * If we are removing a node with two subtrees, store the value of the rightmost
   * leaf of the subtree's left branch and remove that leaf.
   * Then, replace the value of the target node with the stored value.
   */
  public void remove(int target){
    // trail piggybacks off the blazer
    TreeNode trail = null;
    TreeNode blazer = _root;

    // go to target
    while (blazer.getValue() != target){
      trail = blazer; // trail goes to blazer
      if (blazer.getValue() > target){ // blazer moves to new node
        blazer = blazer.getLeft();
      }
      else {
        blazer = blazer.getRight();
      }
    }

    // if target is a leaf
    if (isLeaf(blazer)){
      if (blazer == _root){ // if blazer is the root
        _root = null;
      }
      else if (trail.getLeft() == blazer){ // if blazer is on the left
        trail.setLeft(null);
      }
      else{ // if blazer is on the right
        trail.setRight(null);
      }
    }

    // target has a left subtree ONLY
    else if (blazer.getRight() == null){
      if (blazer == _root){ // if target is the root
        _root = blazer.getLeft();
      }
      // trail finds blazer
      else if (trail.getLeft() == blazer){ // if blazer is on a left subtree
        trail.setLeft(blazer.getLeft()); // skip over blazer
      }
      else{ // if blazer is on a right subtree
        trail.setRight(blazer.getLeft()); // skip over blazer
      }
    }

    // target has a right subtree ONLY
    else if (blazer.getLeft() == null){
      if (blazer == _root){ // if target is the root
        _root = blazer.getRight();
      }
      // trail finds blazer
      else if (trail.getLeft() == blazer){ // if blazer is on a left subtree
        trail.setLeft(blazer.getRight()); // skip over blazer
      }
      else{ // if blazer is on a right subtree
        trail.setRight(blazer.getRight()); // skip over blazer
      }
    }

    // target has 2 subtrees
    else{
      // Get the rightmost element of the left branch of blazer
      TreeNode greatestLeft = blazer.getLeft();
      while(greatestLeft.getRight() != null){
        greatestLeft = greatestLeft.getRight();
      }
      int greatestLeftVal = greatestLeft.getValue();

      // Remove the rightmost element from the subtree.
      // This is a leaf so we just apply the leaf algo here
      remove(greatestLeft.getValue());

      // update value of node
      blazer.setValue(greatestLeftVal);
    }

  } // end remove()


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  public String inOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += inOrderTravStr( currNode.getLeft() );
    retStr += " " + currNode.getValue();
    retStr += inOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String preOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += " " + currNode.getValue();
    retStr += preOrderTravStr( currNode.getLeft() );
    retStr += preOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String postOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += postOrderTravStr( currNode.getLeft() );
    retStr += postOrderTravStr( currNode.getRight() );
    retStr += " " + currNode.getValue();
    return retStr;
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //~~~~~~~~~~~~~v~~MISC.HELPERS~~v~~~~~~~~~~~~~~~~~~~
  public boolean isLeaf( TreeNode node )
  {
    return ( node.getLeft() == null
             &&
             node.getRight() == null );
  }
  //~~~~~~~~~~~~~^~~MISC.HELPERS~~^~~~~~~~~~~~~~~~~~~~


  //overridden toString
  public String toString()
  {
    return
      " pre-order trav:" + preOrderTravStr( _root ) + '\n' +
      "  in-order trav:" + inOrderTravStr( _root ) + '\n' +
      "post-order trav:" + postOrderTravStr( _root ) + '\n' +
      "         height: " + height() + '\n' +
      "     num leaves: " + numLeaves()
      ;
  }


  /**
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   */
  TreeNode search( int target )
  {
    return search( target, _root );
  }
  TreeNode search( int target, TreeNode currNode )
  {
    if ( currNode==null || currNode.getValue()==target )
      return currNode;
    else if ( target < currNode.getValue() )
      return search( target, currNode.getLeft() );
    else if ( target > currNode.getValue() )
      return search( target, currNode.getRight() );
    else
      return null; //to get past compiler
  }


  /**
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 0
   */
  public int height()
  {
    return height( _root );
  }
  //recursive helper for height()
  public int height( TreeNode currNode )
  {
    if ( currNode==null ) //Q: Why cannot use .equals() ?
      return 0;
    if ( isLeaf(currNode) )
      return 0;
    else //height is 1 for this node + height of deepest subtree
      return 1 + Math.max( height(currNode.getLeft()),
                           height(currNode.getRight()) );
  }


  /**
   * int numLeaves()
   * returns number of leaves in tree
   */
  public int numLeaves()
  {
    return numLeaves( _root );
  }
  public int numLeaves( TreeNode currNode ) {
    int foo = 0;
    if ( currNode == null )
      return 0;
    foo += numLeaves( currNode.getLeft() );
    if ( isLeaf(currNode) )
      foo++;
    foo += numLeaves( currNode.getRight() );
    return foo;
  }




  //main method for testing
  public static void main( String[] args )
  {

    BST arbol = new BST();

    System.out.println( "tree init'd: " + arbol );

	  //inserting in this order will build a perfect tree
	  arbol.insert( 3 );
	  arbol.insert( 1 );
    arbol.insert( 0 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 4 );
    arbol.insert( 6 );

	//insering in this order will build a linked list to left

	// arbol.insert( 6 );
	// arbol.insert( 5 );
	// arbol.insert( 3 );
	// arbol.insert( 4 );
	// arbol.insert( 2 );
	// arbol.insert( 1 );
	// arbol.insert( 0 );
  /*
	*/

	System.out.println( "tree after insertions:\n" + arbol );
	System.out.println();

	System.out.println();
	for( int i=-1; i<8; i++ ) {
	    System.out.println(" searching for "+i+": " + arbol.search(i) );
	}

	System.out.println();
	System.out.println( arbol );

	arbol.remove(6);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(5);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(4);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(3);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(2);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(1);
	System.out.println();
	System.out.println( arbol );

	arbol.remove(0);
	System.out.println();
	System.out.println( arbol );

  }

}//end class
