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
 * class LLStack
 * v1
 * Implements a stack of PANCAKES using an encapsulated LList
 **/

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> //interface def must be in this dir
{

  //instance vars
  private LinkedList<PANCAKE> _stack;
  private int _stackSize;

  // constructor -- initializes instance vars
  public LLStack( )
  {
    _stack = new LinkedList<PANCAKE>(); //at birth, a list has no elements
    _stackSize = 0;
  }

  //--------------v  List interface methods  v--------------

  public void push( PANCAKE newVal )
  {
    _stack.add(newVal);
    _stackSize++;
  }

  public PANCAKE pop(  )
  {
    if (isEmpty()) return null;
    return _stack.remove(_stackSize---1);
  }

  //look at top of stack
  public PANCAKE peekTop()
  {
    if ( isEmpty() )  return null;
    return _stack.get(_stackSize - 1);
  }

  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }
}
