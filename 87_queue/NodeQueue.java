/*
TNPG (P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW87 -- Queues
2022-04-01
Time Spent: .5 hrs + classtime
DISCO:
1) Queues are Stacks but FIFO instead of FILO
QCC:
1) What types of problems are Nodes useful for?
2) Could we have made our dequeue method constant runtime with a _tail pointer?
*/
public class NodeQueue<QUASAR> implements Queue<QUASAR>{

QNode<QUASAR> _front;
int _size = 0;

public NodeQueue(){
    _front = null;
    _size = 0;
}
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    if (_size == 0) {
      return null;
    }
    else if (_size == 1) {
      _size --;
      return _front.setCargo(null);
    }
    else{
      QNode<QUASAR> tmp = _front;
      QUASAR retVal;
      for(int i = 0; i < _size-2; i++){ //traverse to second to first node
          tmp = tmp.getNext();
        }
        retVal = tmp.getNext().getCargo();
        tmp.setNext(null);
        _size--;
      return retVal;
    }
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
      QNode<QUASAR> tmp = new QNode<QUASAR>(x, _front);
      _front = tmp;
      _size++;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
      return _size == 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){
      return _front.getCargo();
  }
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~


  public String toString()
    {
    String stringified = "";
    QNode<QUASAR> temp = _front;
    for (int i = 0; i < _size && _front != null; i++){ // an empty node doesnt count
      stringified += temp.getCargo() + ", ";
      temp = temp.getNext();
    }
    return stringified;
    }




    /*****************************************************
 * class QNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a QUASAR
 *****************************************************/

private class QNode<QUASAR>
{
    //instance vars
    private QUASAR _cargo;    //cargo may only be of type QUASAR
    private QNode<QUASAR> _nextNode; //pointer to next QNode

    // constructor -- initializes instance vars
    public QNode( QUASAR value, QNode<QUASAR> next ) {
	_cargo = value;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo() { return _cargo; }

    public QNode<QUASAR> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public QUASAR setCargo( QUASAR newCargo ) {
	QUASAR foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public QNode<QUASAR> setNext( QNode<QUASAR> newNext ) {
	QNode<QUASAR> foo = getNext();
	_nextNode = newNext;
	return foo;
    }

}//end class QNode


public static void main(String[] args) { // for testing
    NodeQueue<String> test = new NodeQueue<String>();
    test.enqueue("hi");
    System.out.println(test);
    test.enqueue("bye");
    System.out.println(test);
    test.enqueue("hola");
    System.out.println(test);
    test.enqueue("adios");
    System.out.println(test);
    test.dequeue();
    System.out.println(test);
    test.dequeue();
    System.out.println(test);
    test.dequeue();
    System.out.println(test);
}
}
