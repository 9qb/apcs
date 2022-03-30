//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW84 - Leon Leonwood Stack
//2022-03-30r
//time spent: 0.4 hrs + class time

/*
DISCO
- LLStack and ALStack can function by using the same methods for their respective classes.
- implementing Stack without parameters does not implement our local Stack, which IS parameterized.

QCC
- What is the benefit of using the built-in LinkedList over ArrayList, and vice-versa?
*/

/***
 * class ALStack
 * v1
 * Implements a stack of PANCAKES using an encapsulated ArrayList
 **/

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>
{
  private ArrayList<PANCAKE> _stack;
  private int _stackSize;


  //constructor
  public ALStack(  )
  {
    _stack = new ArrayList();
    _stackSize = 0;
  }


  //means of insertion
  public void push( PANCAKE s )
  {
    _stack.add(s);
    _stackSize++;
  }


  //means of removal
  public PANCAKE pop()
  {
    if ( isEmpty() )  return null;
    return _stack.remove(_stackSize---1);
  }

  //look at top of stack
  public PANCAKE peekTop()
  {
    if ( isEmpty() )  return null;
    return _stack.get(_stackSize-1);
  }


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }

}
