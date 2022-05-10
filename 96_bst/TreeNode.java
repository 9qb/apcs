// (P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// HW96 -- BSTs is the Perfect Place for Shade
// 2022-05-11w
// Time Spent: 1.0 hrs

/*
  DISCOS
  1. We can code the method for search both recursively and iteratively. Both mehtods yield O(logn)

  QCC
  1. Were we meant to do the search method recursively or iteratively?
  2. What are binary search trees useful for?

*/

/**
 * class TreeNode
 * SKELETON
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 */

public class TreeNode
{

  //instance variables / attributes of a TreeNode:
  int _cargo;        //this node's data
  TreeNode _lt, _rt; //pointers to left, right subtrees


  /**
   * default constructor
   * Construct a tree node with specified value,
   * with null left and right subtrees.
   */
  TreeNode( int initValue )
  {
    _cargo = initValue;
  }


  /**
   * overloaded constructor
   * Construct tree node w specified value, left, and right subtrees.
   */
  TreeNode( int initValue, TreeNode initLeft, TreeNode initRight )
  {
    this(initValue);
    _lt = initLeft;
    _rt = initRight;
  }


  /**
   * Returns the left subtree of this node.
   */
  TreeNode getLeft()
  {
    return _lt;
  }


  /**
   * Returns the right subtree of this node.
   */
  TreeNode getRight()
  {
    return _rt;
  }


  /**
   * Returns the value stored in this tree node.
   */
  int getValue()
  {
    return _cargo;
  }


  /**
   * Sets the value of the left subtree of this node.
   */
  void setLeft( TreeNode theNewLeft )
  {
    _lt = theNewLeft;
  }


  /**
   * Sets the value of the right subtree of this node.
   */
  void setRight( TreeNode theNewRight )
  {
    _rt = theNewRight;
  }


  /**
   * Sets the value of this tree node.
   */
  void setValue( int theNewValue ) 
  {
    _cargo = theNewValue;
  }

}//end class
