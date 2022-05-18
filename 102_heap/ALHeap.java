/*
(P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW102 -- Heap On Heapin' On
2022-05-18w
Time Spent: 1.2 hrs + classtime

DISCO:
1) A heap can be represented in the form of an ArrayList
2) The index of the parent can be represented as (pos - 1)/2 and the index of the left and right child is 2pos+1 and 2pos+2 respectively.
QCC:
1) In order to have it so that a level order traversal can produce a unique heap by itself, we think it is neccessary that it is a given that the heap is balanced.

*/
import java.util.ArrayList;

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

//import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String output = "";
    for(int i : _heap) {
      output = output + i + " ";
    }
    return output;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * 1) Add addVal to _heap
   * 2) Compare addVal, with the item at index (pos-1)/2
   * 3) If lesser, swap and go back to step 3
   * 4) If greater, then the ArrayList will once again be a heap
   */
  public void add( Integer addVal )
  {
    int curr = _heap.size(); // current position of addVal
    _heap.add(addVal);
    while(curr > -1){
      if(addVal >= _heap.get((curr-1)/2)){ // the equal takes care of the case in which _heap is empty
        break;
      }else{
        swap(curr, (curr-1)/2); // swap parent and addVal
        curr = (curr-1)/2;
      }
    }
  }//O(log n)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * 0) Use a curr to keep track of position.
   * 1) Swap the values at the first and last indices
   * 2) Store and remove the last element in _heap
   * 3) If the root isn't less than both its children, swap it with the lesser valued child.
   * 4) Repeat until root node is either less than all its children or has no children at all
   */
  public Integer removeMin()
  {
    int output;
    int curr = 0;

    swap(0,_heap.size()-1);
    output = _heap.remove(_heap.size()-1);

    while(curr < _heap.size()){
      if(2 * curr + 1 < _heap.size() && 2 * curr + 2 < _heap.size()){
        if(_heap.get(curr) < _heap.get(2*curr +1) && _heap.get(curr) < _heap.get(2*curr +2)){
          return output;
        }else{
          int temp = minChildPos(curr);
          swap(curr, minChildPos(curr));
          curr = temp;
        }
      }else if(2 * curr + 1 < _heap.size()){
        if(_heap.get(curr) < _heap.get(2*curr +1)){
          return output;
        }else{
          swap(curr, 2*curr +1);
          curr = 2*curr+1;
        }
      }else if(2 * curr + 2 < _heap.size()){
        if(_heap.get(curr) < _heap.get(2*curr +2)){
          return output;
        }else{
          swap(curr, 2*curr +2);
          curr = 2*curr+2;
        }
      }else
        return output;

    }

    return output;
  }//O(log n)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    if (2 * pos + 1 < _heap.size() && 2 * pos + 2 < _heap.size()){
      if (_heap.get(2* pos + 1) > _heap.get(2 * pos + 2))
        return 2* pos + 2;
      else
        return 2 * pos + 1;
    }else if (2 * pos + 1 < _heap.size()){
      return 2* pos + 1;
    }else if (2 * pos + 2 < _heap.size()){
      return 2 * pos + 2;
    }else{
      return -1;
    }


  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
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
      ALHeap pile = new ALHeap();


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


      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
