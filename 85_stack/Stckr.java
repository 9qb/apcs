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
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    Stack<Comparable> cakes = new ALStack<Comparable>();
    // Stack<Comparable> cakes = new LLStack<Comparable>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //...

    cakes.push("tatum");
    cakes.push(0.0);
    cakes.push("smart");
    cakes.push(36);
    cakes.push("brown");
    cakes.push(7);
    cakes.push("timelord");
    cakes.push(44);
    cakes.push("horford");
    cakes.push(42.0);

    System.out.println("Is cakes empty? " + cakes.isEmpty());
    while(!cakes.isEmpty()){
      System.out.println("peek: " + cakes.peekTop());
      System.out.println("pop: " + cakes.pop());
    }
    System.out.println("Is cakes empty? " + cakes.isEmpty());

  }//end main

}//end class
