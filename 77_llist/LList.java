//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW77 - Insert|Remove
//2022-03-15w
//time spent: 1.0 hr + class time
// KTS consumed: 2 keys

/*
DISCO:
  - Using the "new" keyword allows us to create a copy of the object. Without using the new keyword when defining a variable, we modify the original object when modifying the new variable
QCC:
  - Why are Linked Lists useful?
ALGO ADD:
  - If LList empty, place newVal as the first cargo
  - Else, traverse to the specified index with a temp LLNode.
  - Create a new object node that contains temp's cargo and nextVal as its cargo and nextVal respectively
  - Set the cargo of the temp LLNode to newVal
  - Point the nextNode of the original node to the copy of the node created earlier
ALGO REM:
  - Traverse to the node at index.
  - Set node's cargo to the next node's cargo
  - Set node's nextNode to the node after next.
  - Return original cargo of node.
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
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add( int index, String newVal)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    LLNode temp = _head;
    // if empty, place newVal in first spot
    if (_size == 0){ add(newVal); }
    else {
      for (int i = 0; i < index; i++)
      {
        temp = temp.getNext(); // traverse
      }
      LLNode n = new LLNode(temp.getCargo(),temp.getNext());
      temp.setCargo(newVal);
      temp.setNext(n);
    }
    _size++;
  }


  public String remove( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    LLNode end = _head;
    String retVal;
    //walk to desired node
    for( int i=0; i < index; i++ ){
      end = end.getNext();
    }
    retVal = end.getCargo();
    end.setCargo(end.getNext().getCargo());
    end.setNext(end.getNext().getNext());
    _size--;
    return retVal;
  }



  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
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

    james.remove( 2 );
    System.out.println("After removal:\n" + james);

    james.add( 1, "help" );
    System.out.println("After add with index:\n" + james);
  }

}//end class LList
