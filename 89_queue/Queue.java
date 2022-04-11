/*
(P)BNJ -- Nakib Abedin + Jefford Shau + Brian Li
APCS pd07
HW89 --  Queue Two Ways
2022-04-11
time spent: 0.1 hr + class time

DISCO
1) Passing through the functionality of ArrayList and LinkedList to Queue makes coding the Wrapper Class for ArrayList and LinkedList much easier.
2) The encapsulation diagram helped us identify the time complexity of each method.

QCC:
1) How can we make AlQueue have constant runtime for both enqueue and dequeue?
*/

/***
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 **/

public interface Queue<QUASAR>
{
  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public QUASAR dequeue();

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x );

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty();

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront();
  //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

}//end interface Queue
