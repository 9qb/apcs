//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW76 - We Got a Little Ol' Convoy
//2022-03-14w
//time spent: 0.5 hr + class time

/*
DISCO
- We can have an LLNode whose cargo and nextNode are null, but the LLNode will not be null itself.

QCC
- Is there a better way of doing size() so that it isn't O(n)?
*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    _head = new LLNode(null, null);
    _size = size();
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode temp = _head;
    // if empty node, put cargo here.
    if (temp.getCargo() == null){
      temp.setCargo(newVal);
    }
    // else, add newVal to cargo of new node
    else{
      for (int i = 1; i < size(); i++){
        temp = temp.getNext();
      }
      temp.setNext(new LLNode(newVal, null));
    }
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    // traverses to right index
    for (int i = 0; i < index; i++){
      temp = temp.getNext();
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    // traverses to right index
    for (int i = 0; i < index; i++){
      temp = temp.getNext();
    }
    return temp.setCargo(newVal);
  }


  //return number of nodes in list
  public int size()
  {
    int i = 0;
    LLNode temp = _head;
    while (_head.getCargo() != null){ // makes sure theres stuff
      i += 1;
      if (temp.getNext() != null){ // checks if we can go to next node
        temp = temp.getNext();
      }
      else{ break; }
    }
    return i;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String stringified = "";
    LLNode temp = _head;
    for (int i = 0; i < size() && _head != null; i++){ // an empty node doesnt count
      stringified += temp.getCargo() + ", ";
      temp = temp.getNext();
    }
    return stringified;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
