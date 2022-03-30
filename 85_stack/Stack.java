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
 * interface Stack
 * Specifies actions a stack must be able to perform.
 * Allows for generic typing.
 **/

public interface Stack<PANCAKE>
{
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty();

    //Return top element of stack without popping it.
    public PANCAKE peekTop();

    //Pop and return top element of stack.
    public PANCAKE pop();

    //Push an element onto top of this stack.
    public void push( PANCAKE x );

}//end interface
