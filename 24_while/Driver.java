// Snowball - Brian Li + Robert, Jun Hong Wang + Bob
// APCS
// HW24 -- while loops
// 2021-10-25
// time spent: 1.0 hours

/*
DISCO
0. In order to access the value of a private instance variable belonging to another class, you must use a public method provided that returns the variable. You cannot access it directly.
1. Using a while loop requires a terminating condition, otherwise your loop will go on forever. 
QCC
0. When flipping until "x heads have come up", is that referring to heads coming up from both yours and wayne? Or only from yours/wayne?
POST-v0 MODS
0. changed constructors to refer to itself via this()
1. made use of assignValue() in constructor
*/

public class Driver {
  public static void main( String[] args ) {
    
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
      // prints within while loop are omitted to reduce clutter
      int x, y; // x = threshold of total heads wanted; y = threshold of total matches wanted
      int matchCtr = 0;
      x = 10000;
      y = 20000;
      
      while (x > yours.getHeadsCtr() + wayne.getHeadsCtr() || y > matchCtr || !(matchCtr >= 65536 && matchCtr % 2005 == 0)){
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
      System.out.println("Total sets of flips: " + yours.getFlipCtr() + "\nTotal matches: " + matchCtr);
      System.out.println("\nTotal heads: " + (yours.getHeadsCtr() + wayne.getHeadsCtr()) + "\nTotal tails: " + (yours.getTailsCtr() + wayne.getTailsCtr()));
      System.out.println("\nTotal heads from yours: " + yours.getHeadsCtr() + "\nTotal tails from yours: " + yours.getTailsCtr());
      System.out.println("\nTotal heads from wayne: " + wayne.getHeadsCtr() + "\nTotal tails from wayne: " + wayne.getTailsCtr());
      
  }//end main()

}//end class
