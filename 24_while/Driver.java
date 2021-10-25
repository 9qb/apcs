// Snowball - Brian Li + Robert, Jun Hong Wang + Bob
// APCS
// HW23 -- Coin and Driver
// 2021-10-22
// time spent: 1.0 hours

/*
DISCO
0. Math.random() is capable of producing a random double within the range of [0,1). 
1. Using this means that the object is referring to itself. It is used to clarify what object a method or variable belongs to.
2. By supplying an instance of a class as an argument in a method, you are able to access its instance variables, private or not.  
QCC
0. If you overwrite a method, such as toString(), is there a way to still use the original method associated with the method name that is overwritten?
1. What is the difference between null and an empty String? 
*/

/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {
  public static void main( String[] args ) {
    
      int x, y; // x = threshold of total heads wanted; y = threshold of total matches wanted
      int matchCtr = 0;
    
      //build Objects from blueprint specified by class Coin
      //test default constructor
      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      
      System.out.println();
      
      // test equals() method WITH WHILE LOOP
      // prints are omitted to reduce clutter
      x = 100;
      y = 20;
      
      while (x < yours.getFlipCtr() && y < matchCtr && y >= 65536 && y % 2005 == 0){
        if ( yours.equals(wayne) ) {
          // System.out.println( "Matchee matchee!" );
          matchCtr++;
        }
        else {
        //   System.out.println( "No match. Firestarter you can not be." )
        }
        yours.flip();
        wayne.flip();
      }
      System.out.println("Total flips: " + yours.getFlipCtr() + "\nTotal matches: " + matchCtr);
      
  }//end main()

}//end class
