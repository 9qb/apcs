//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW80 - Generically Speaking
//2022-03-23r
//time spent: 0.6 hrs + class time

/*
DISCO
- You cannot use a primitive to parameterize an object.
- Include <name> in the header of a class to parameterize it.
- A class that is parameterized can still be instantiated when the
  variable type is not parameterized.

QCC
- Why can we not use primitives to parameterize an object?
*/

/***
 * class DLLNode v1
 * Implements a node, for use in lists and other container classes.
 * Stores a T  as cargo.
 **/

public class DLLNode<T>
{
  private T  _cargo;    //cargo may only be of type T
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes


  // constructor -- initializes instance vars
  public DLLNode( T  value, DLLNode prev, DLLNode next )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public T  getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }

  public DLLNode getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T  setCargo( T  newCargo )
  {
    T  foo = getCargo();
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
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {
    //Below is an exercise in creating a linked list...

 /*********************
    //Create a node
    DLLNode first = new DLLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null ) );

    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
   ***********************/
  }//end main

}//end class DLLNode
