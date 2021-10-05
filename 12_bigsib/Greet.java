// Dynamic Duo of Destiny -- Brian Li, Kaitlin Ho, Robert, Apple
// APCS
// HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
// 2021-10-05

/*
DISCOVERIES
 0. When we create variable richard of type BigSib, rihard is able to use all of the methods associated with the class BigSib, such as setHelloMsg and greet, in the form variableName/className.method().
 1. A static method is unable to reference instance variables. That is, the method is incapable of referencing variables outside of its own class. To remedy this, remove static from the class construction.
    
UNRESOLVED QUESTIONS
 0. When creating a variable of a class type, what happens if you put something within the parentheses of the class (e.g. BigSib richard = new BigSib();)? What does that affect?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    // Word up freshman
    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);
   
    // Salutations Dr. Spaceman
    BigSib bezos = new BigSib();
    bezos.setHelloMsg("Salutations");
   
    greeting = bezos.greet("Dr. Spaceman");
    System.out.println(greeting);
   
    // Hey ya King Fooey
    BigSib royalty = new BigSib();
    royalty.setHelloMsg("Hey ya");
   
    greeting = royalty.greet("King Fooey");
    System.out.println(greeting);
   
    // Sup mom
    BigSib momma = new BigSib();
    momma.setHelloMsg("Sup");
   
    greeting = momma.greet("mom");
    System.out.println(greeting);

  } //end main()
} //end Greet
