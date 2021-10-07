// BestDuo -- Brian Li, Kaitlin Ho, Robert, Apple
// APCS
// HW13 -- Where do BigSibs Come From?
// 2021-10-06

/*
DISCO
 0. When assigning new <ClassName>() to the same variable again, it resets the class instance to its original state. 
 1. A constructor can accept arguments, similar to a method. The arguments can be supplied when initializing an instance of a class within the parentheses.
    
QCC
 0. Why is it necessary for the constructor to be public? And why does it have to be the same name of the class?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;
    BigSib richard = new BigSib();
    BigSib grizz = new BigSib();
    BigSib dotCom = new BigSib();
    BigSib tracy = new BigSib();
    greeting = richard.greet("freshman");
    System.out.println(greeting);
    greeting = tracy.greet("Dr. Spaceman");
    System.out.println(greeting);
    greeting = grizz.greet("King Fooey");
    System.out.println(greeting);
    greeting = dotCom.greet("mom");
    System.out.println(greeting);
  } //end main()
} //end Greet

