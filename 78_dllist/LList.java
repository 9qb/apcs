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
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _head, null );
    _head = tmp;
    if (tmp.getNext() != null){
      tmp.getNext().setPrev(tmp);
    }
    else{
      _tail = tmp;
    }
    _size++;
    return true;
  }

  public void add( int index, String newVal)
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    DLLNode temp = _head;
    // if empty, place newVal in first spot
    if (_size == 0){ add(newVal); }
    else {
      for (int i = 0; i < index; i++)
      {
        temp = temp.getNext(); // traverse
      }
      // clones current node, but prevNode points to original
      DLLNode n = new DLLNode(temp.getCargo(), temp.getNext(), temp);
      // overwrites original
      temp.setCargo(newVal);
      temp.setNext(n);
    }
    _size++;
  }


  public String remove( int index ) {
    String retStr;
		if(index == 0){ // optimization
			retStr = _head.getCargo();
			_head = _head.getNext();
			_size--;
      return retStr;
		}

		DLLNode temp = _head;
		for( int i=0; i < index-1; i++ ) {
			temp = temp.getNext(); // traverse
		}
    // temp.getNext() is the address of node to be removed

		retStr = (temp.getNext()).getCargo();
		temp.setNext((temp.getNext()).getNext());
    // temp.getNext().setPrev(temp); // changing prevNode breaks code? why?

    _size--;
		return retStr;
	}

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

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

    DLLNode tmp = _head; //create alias to head

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
    DLLNode tmp = _head; //init tr
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
