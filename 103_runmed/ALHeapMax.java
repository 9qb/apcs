/*
(P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW103 -- Erica's Friends, Hugo, and The One in the Middle
2022-05-19r
Time Spent: 0.5 hrs + classtime

DISCO
1) Heaps can be used for keeping track of the median

QCC
1) Since heaps are good at keep track at min/max, could they potentially be useful in creating a sorted collection?

ALGO
(The same algo as the one on the board during class)

a. if next val < root of maxheap, add to maxheap
   else add to minheap

b. balance heaps (so that size difference < 2)
   (remove from larger heap, add to smaller heap)

c. at any time find med by:
    a) heap sizes equal: med is mean of roots
    b) heap sizes !equal: med is root of larger heap
*/

/**
 * class ALHeapMax
 * Implements a max heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeapMax
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeapMax()
  {
    _heap = new ArrayList<Integer>();
  }


  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    //simple version:
    //return _heap.toString();

    //prettier version:
    String lvlOrdTrav = "heap size " + _heap.size() + "\n";

    if ( _heap.size() == 0 ) return lvlOrdTrav;

    int h = 1; //init height to 1
    for( int i = 0; i < _heap.size(); i++ ) {
      lvlOrdTrav += i + ":" + _heap.get(i) + " ";
      if ( i >= Math.pow(2,h) - 2 ) {
        lvlOrdTrav += "\n";
        h++;
      }
    }
    return lvlOrdTrav;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty() { return _heap.isEmpty(); } //O(1)


  /**
   * Integer peekMax()
   * Returns max value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMax()
  {
    if ( _heap.size() < 1 )
      return null;
    else
      return _heap.get(0);
  } //O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * add val as last node
   * potentially swap until reaching root (if addVal > parent, swap)
   */
  public void add( Integer addVal )
  {

    //Add value as last node, to maintain balance, completeness of tree
    _heap.add( addVal );

    int addValPos = _heap.size() - 1;
    int parentPos;

    while( addValPos > 0 ) { //potentially swap until reach root

      //pinpoint parent
      parentPos = (addValPos-1) / 2;

      if ( addVal.compareTo(_heap.get(parentPos)) > 0 ) { //addVal > parent
        swap( addValPos, parentPos );
        addValPos = parentPos;
      }
      else
        break;
    }
  } //O(logn)


  /**
   * removeMax()  ---  means of removing an element from heap
   * Removes and returns greatest element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * store root value
   * store val about to be swapped into root
   * swap last (rightmost, deepest) leaf w/ root
   * remove the last leaf
   * float the root node down the tree
   * return stored root value
   */
  public Integer removeMax()
  {
    if ( _heap.size() == 0 )
      return null;

    //store root value for return at end of fxn
    Integer retVal = peekMax();

    //store val about to be swapped into root
    Integer foo = _heap.get( _heap.size() - 1);

    //swap last (rightmost, deepest) leaf with root
    swap( 0, _heap.size() - 1 );

    //lop off last leaf
    _heap.remove( _heap.size() - 1);

    // walk the now-out-of-place root node down the tree...
    int pos = 0;
    int maxChildPos;

    while( pos < _heap.size() ) {

      //choose child w/ max value, or check for child
      maxChildPos = maxChildPos(pos);

      //if no children, then i've walked far enough
      if ( maxChildPos == -1 )
        break;
      //if i am greater than my greatest child, then i've walked far enough
      else if ( foo.compareTo( _heap.get(maxChildPos) ) >= 0 )
        break;
      //if i am < greatest child, swap with that child
      else {
        swap( pos, maxChildPos );
        pos = maxChildPos;
      }
    }
    //return removed value
    return retVal;
  }//O(logn)


  /**
   * maxChildPos(int)  ---  helper fxn for removeMax()
   * Returns index of greatest child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int maxChildPos( int pos )
  {
    int retVal;
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() )
      retVal = -1;
    //if no right child, then left child is only option for max
    else if ( rc >= _heap.size() )
      retVal = lc;
    //have 2 children, so compare to find least
    else if ( _heap.get(lc).compareTo(_heap.get(rc)) < 0 )
      retVal = rc;
    else
      retVal = lc;
    return retVal;
  }//O(1)

  /**
   * size() -- returns size via passthru
   */
  public int size(){
    return _heap.size();
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer maxOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return b;
    else
      return a;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeapMax pile = new ALHeapMax();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
