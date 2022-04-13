// Team (P)BNJ - Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// HW91 -- Deque the Halls
// 2022-04-13
// time spent: 0.1 hrs + class time

public interface Deque<E>{
  // add methods
  public boolean add(E e); // equivalent to addLast()
  public void addFirst(E e);
  public void addLast(E e);

  // remove methods
  public E remove(); // equivalent to removeFirst()
  public boolean remove(Object o);
  public E removeFirst();
  public E removeLast();

  // peek methods
  public E peek(); // equivalent to peekFirst()
  public E peekFirst();
  public E peekLast();

  // others
  public boolean isEmpty();
  public int size();
  public void clear();
  public boolean contains(Object o);
}
