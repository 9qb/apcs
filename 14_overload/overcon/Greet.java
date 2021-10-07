// Tiger -- Brian Li, Josiah Moltz, Jing Feng, Robert, Hedwig, Biscuit
// APCS
// HW14 -- Customize Your Creation
// 2021-10-07

/*
DISCO
 0. When we overload a method/constructor, we are able to supply different datatypes and/or a different number of arguments to methods of the same name. The method that is invoked depends on which method's parameters are satisfied by the arguments.
    
QCC
 0. Is it possible to overload main()? What would happen in that scenario?
*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;
    BigSib richard = new BigSib("Word up");
    BigSib grizz = new BigSib("Salutations");
    BigSib dotCom = new BigSib("Hey ya");
    BigSib tracy = new BigSib("Sup");
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

