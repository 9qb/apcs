//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW78 - Double Up
//2022-03-16r
//time spent: 2.5 hr + class time
// KTS consumed: 2 keys

/*
DISCO:
 - We can use _tail to quickly indentify the last node in the LList.
QCC:
  - Why are Doubly-Linked Lists useful?
  - Why did our code remove 2 or 3 items during our first attmept?
  - Why does attempting to set a prevNode break our remove() algo?
ALGO ADD:
  - If size 0, create a new DLLNode and point _head to that node
  - Else, traverse to the given index
  - Clone the DLLNode at the index. The clone's prevNode points to the original node.
  - Set the cargo of the original node to the newVal and set its nextNode to the clone.
ALGO REM:
  - If index is 0, move the _head pointer over one place to the right
  - Else, traverse index-1
  - Store the cargo in the node of index-1
  - Set the nextNode of the node of index-1 to 2 nodes over.
  - Housekeeping
  - Return stored cargo
*/

/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
  //instance vars
  private String _cargo;
  private DLLNode _nextNode;
  private DLLNode _prevNode;

  // constructor
  public DLLNode( String value, DLLNode next, DLLNode prev )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }

  public DLLNode getPrev()
  {
    return _prevNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev( DLLNode newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null, null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null, first.getPrev() ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null, first.getNext().getPrev() ) );

    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: garbage collector reclaims that memory

    //  so, better: (w/o moving first)
    /*
    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
    */

  }//end main

}//end class DLLNode
