//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW75 - Nodal Recall
//2022-03-11w
//time spent: 0.5 hr + class time

/*
DISCO
- By using a method call inside a method call, we are allowed to access the next node of a linked list.

QCC
- What makes a linked list better than an array?
*/

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _cargo;
  private LLNode _nextNode;

  // constructor
  public LLNode( String value, LLNode next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public LLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String temp = getCargo();
    _cargo = newCargo;
    return temp;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode temp = getNext();
    _nextNode = newNext;
    return temp;
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
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    // A naive list traversal, has side effects.... ??
       // while( first != null ) {
       // System.out.println( first );
       // first = first.getNext();
       // }

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: the node it was originally on is no longer assigned to first.

    //...so better: ?
    String nextCargo = first.getCargo();
    LLNode nextNode = first.getNext();
    System.out.println(nextCargo);
    while(nextNode != null){
      nextCargo = nextNode.getCargo();
      nextNode = nextNode.getNext();
      System.out.println(nextCargo);
    }

  }//end main

}//end class LLNode
