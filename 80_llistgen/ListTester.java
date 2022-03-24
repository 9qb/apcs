//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW80 - Generically Speaking
//2022-03-23r
//time spent: 0.6 hrs + class time

/*
DISCO
- You cannot use a primitive to parameterize an object.
- Include <name> in the header of a class to parameterize it.
- A class that is parameterized can still be instantiated when the
  variable type is not parameterized.

QCC
- Why can we not use primitives to parameterize an object?
*/

/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args )
  {

    //instantiate... var type List, obj type LList
    List wu = new LList();

    System.out.println(wu);
    wu.add("RZA");

    System.out.println(wu);
    wu.add("GZA");

    System.out.println(wu);
    wu.add("ODB");

    System.out.println(wu);
    wu.add("Inspectah Deck");

    System.out.println(wu);
    wu.add("Raekwon the Chef");

    System.out.println(wu);
    wu.add("U-God");

    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println(wu);
    wu.add("Method Man");

    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
      int n = (int)( wu.size() * Math.random() );
      String imposter = "@";
      System.out.println("adding imposter at index " + n + "...");
      wu.add( n, imposter );
      System.out.println("Updated list: " + wu);
    }

    while( wu.size() > 0 ) {
      int n = (int)( wu.size() * Math.random() );
      System.out.println("deleting node "+ n + "...");
      wu.remove(n);
      System.out.println("Updated list: " + wu);
    }

    System.out.println();

    // instantiate new LList of ints
    LList<Integer> intList = new LList();
    intList.add(23);
    intList.add(30);
    intList.add(77);
    intList.add(15);
    intList.add(8);
    System.out.println(intList);

    for( int i=0; i<4; i++ ) {
      int n = (int)( intList.size() * Math.random() );
      Integer imposter = -1;
      System.out.println("adding imposter at index " + n + "...");
      intList.add( n, imposter );
      System.out.println("Updated list: " + intList);
    }

    while( intList.size() > 0 ) {
      int n = (int)( intList.size() * Math.random() );
      System.out.println("deleting node "+ n + "...");
      intList.remove(n);
      System.out.println("Updated list: " + intList);
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
