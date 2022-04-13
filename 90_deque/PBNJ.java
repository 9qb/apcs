// Team (P)BNJ - Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// HW91 -- Deque the Halls
// 2022-04-13
// time spent: 0.1 hrs + class time

import java.util.LinkedList;

public class PBNJ<E> implements Deque<E>{
  private LinkedList<E> ll;

  public PBNJ(){
    ll = new LinkedList<E>();
  }

  // adds
  public boolean add(E e){
    addLast(e);
    return true;
  }

  public void addFirst(E e){
    ll.addFirst(e);
  }

  public void addLast(E e){
    ll.addLast(e);
  }

  // removes
  public E remove(){
    return removeFirst();
  }

  public boolean remove(Object o){
    return ll.remove(o);
  }

  public E removeFirst(){
    return ll.removeFirst();
  }

  public E removeLast(){
    return ll.removeLast();
  }

  // peeks
  public E peek(){
    return peekFirst();
  }

  public E peekFirst(){
    if (!isEmpty()){ return ll.getFirst(); }
    else { return null; }
  }

  public E peekLast(){
    if (!isEmpty()){ return ll.getLast(); }
    else { return null; }
  }

  // others
  public boolean isEmpty(){
    return size() == 0;
  }

  public int size(){
    return ll.size();
  }

  public void clear(){
    ll = new LinkedList<E>();
  }

  public boolean contains(Object o){
    return ll.contains(o);
  }

  public String toString(){
    return ll.toString();
  }
}
