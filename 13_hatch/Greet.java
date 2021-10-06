// BestDuo -- Brian Li, Kaitlin Ho, Robert, Apple
// APCS
// HW13 -- Where do BigSibs Come From?
// 2021-10-06

/*
DISCO
 0. When we create variable richard of type BigSib, richard is able to use all of the methods associated with the class BigSib, such as setHelloMsg and greet, in the form variableName/className.method().
 1. A static method is unable to reference instance variables. That is, the method is incapable of referencing variables outside of its own class. To remedy this, remove static from the class construction.
    
QCC
 0. When creating a variable of a class type, what happens if you put something within the parentheses of the class (e.g. BigSib richard = new BigSib();)? What does that affect?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    // Word up freshman
    BigSib richard = new BigSib("Word up");
   
    greeting = richard.greet("freshman");
    System.out.println(greeting);
   
    // Salutations Dr. Spaceman
    richard = BigSib("Salutations");
   
    greeting = richard.greet("Dr. Spaceman");
    System.out.println(greeting);
   
    // Hey ya King Fooey
    richard = BigSib("Hey ya");
   
    greeting = richard.greet("King Fooey");
    System.out.println(greeting);
   
    // Sup mom
    richard = BigSib("Sup");
   
    greeting = richard.greet("mom");
    System.out.println(greeting);

  } //end main()
} //end Greet
