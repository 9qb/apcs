/*
(P)BNJ -- Brian Li, Nakib Abedin, Jefford Shau
APCS pd07
HW99 - Some Are More Equal Than Others, Codified
2022-05-13
Time Spent: 0.2 hrs + classtime

DISCO
  * If two elements of an ArrayPriorityQueue have the same priority value, we peek and remove the lower-indexed element.
QCC
  * How can we improve the time complexity of the remove() method?
*/

import java.util.ArrayList;
import java.lang.RuntimeException;


public class ArrayPriorityQueue implements PriorityQueue {
  private ArrayList<Integer> _data;

  public ArrayPriorityQueue() {
    _data = new ArrayList();
  }

  /*
    Big O Classification: O(1)
  */
  public void add( int x ) {
    _data.add(x);
  }

  /*
    Big O Classification: O(1)
  */
  public boolean isEmpty() {
    return _data.size() == 0;
  }

  /*
    Big O Classification: O(n)
  */
  public int peekMin(){
    if (isEmpty()) throw new java.lang.RuntimeException("empty queue");
    int min = 0;
    for (int i = 1; i < _data.size(); i++){
      if (_data.get(i) < _data.get(min)){ min = i; }
    }
    return _data.get(min);
  }

  /*
    Big O Classification: O(n)
  */
  public int removeMin(){
    if (isEmpty()) throw new java.lang.RuntimeException("empty queue");
    int min = 0;
    for (int i = 1; i < _data.size(); i++){
      if (_data.get(i) < _data.get(min)){ min = i; }
    }
    return _data.remove(min);
  }

  public static void main(String[] args) {
    ArrayPriorityQueue tester = new ArrayPriorityQueue();
    tester.add(7);
    tester.add(1);
    tester.add(5);
    tester.add(12);
    tester.add(3);
    tester.add(7);
    System.out.println(tester.isEmpty());  // should be false
    System.out.println(tester.peekMin()); // should be 1
    System.out.println(tester.removeMin()); // should return 1
    System.out.println(tester.peekMin()); // should be 3
    System.out.println(tester.removeMin()); // should return 3
    System.out.println(tester.peekMin()); // should be 5
    System.out.println(tester.removeMin()); // should return 5
    System.out.println(tester.peekMin()); // should be 7
    System.out.println(tester.removeMin()); // should return 7
    System.out.println(tester.peekMin()); // should be 7
    System.out.println(tester.removeMin()); // should return 7
    System.out.println(tester.peekMin()); // should be 12
    System.out.println(tester.removeMin()); // should return 12
    System.out.println(tester.peekMin()); // should be error

  }


}
