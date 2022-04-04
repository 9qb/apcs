/*
(P)BNJ -- Nakib Abedin + Jefford Shau + Brian Li
APCS pd07
HW88 --  BPC Kiddies Do Not Wait in Line Either
2022-04-04
time spent: 0.3 hr + class time

DISCO
1) You can have O(1) enqueue and dequeue methods (when adding to the back and removing from the front) if you strcuture your queue properly

QCC:
1) Should we have kept our dequeue O(1) and altered our sample to be O(n)?

*/

/*
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    if ( isEmpty() ) {
      _front = _end = new LLNode<SWASHBUCKLE>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<SWASHBUCKLE>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);
  }//O(1)


  // remove and return random thing
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    SWASHBUCKLE retVal;
    if (_size == 1) {
      retVal = _front.setCargo(null);
      _size--;
    }
    else {
      int random = (int) (Math.random() * _size);
      // _front = _front.getNext();
      LLNode<SWASHBUCKLE> _tmp = _front;
      for (int i = 0; i < random -1; i++) {
        _tmp = _tmp.getNext();
      }
      retVal = _tmp.getNext().getCargo();
      _tmp.setNext(_tmp.getNext().getNext());
      _size--;
    }
    return retVal;
  }//O(n)


  public SWASHBUCKLE peekFront()
  {
    return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   For each iteration _size-1 times:
   *     - Dequeue a random item
   *     - Enqueue the returned value from the dequeue
   **/
  public void sample ()
  {
    for (int i = 0; i < _size; i++) {
      this.enqueue( this.dequeue() );
    }
    System.out.println( this.peekFront() );
  }//O(n^2) because dequeue() is O(n)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<SWASHBUCKLE> tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());
    System.out.println( PirateQueue.dequeue() );
    // System.out.println( PirateQueue.toString());

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
