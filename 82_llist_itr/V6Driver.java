//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW82 - Roll Your Own Iterator
//2022-03-26r
//time spent: 0.6 hrs + class time

/*
DISCO
- The iterator() method simply returns a new object of MyIterator.

QCC
- What is the point of _okToRemove?
- How does the foreach function work within classes implementing Iterator?
- How can an inner class call the function of an outer class?
*/

/***
 * class V6Driver
 * ...for testing implementation of Iterable interface
 *    (ability to run a FOREACH loop over your LList)
 *
 * Assumes local version of List.java, overriding Java standard library interface
 **/

public class V6Driver
{
  public static void main( String[] args )
  {
    List<String> wu = new LList<String>();

    System.out.println(wu);
    wu.add("RZA");
    wu.add("GZA");
    wu.add("ODB");
    wu.add("Inspectah Deck");
    wu.add("Raekwon the Chef");
    wu.add("U-God");
    wu.add("Ghostface");
    wu.add("Method Man");
    System.out.println(wu);

    for( String s : wu ) {
      System.out.println( s + " raps for the Wu");
    }
  }//end main()

}//end class
