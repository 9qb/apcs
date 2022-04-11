import java.util.LinkedList;

public class LLQueue<QUASAR> implements Queue<QUASAR>{
  private LinkedList<QUASAR> ll;

  public LLQueue(){
    ll = new LinkedList<QUASAR>();
  }

  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue(){
    return ll.remove();
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ){
    ll.addLast(x);
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
    return ll.size() != 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront(){
    return ll.peekFirst();
  }
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~
}
