//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW81 - Thank You, Next
//2022-03-24r
//time spent: 0.1 hrs + class time

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO:
    1) the remove method in the iterator removes the most recently returned item.
    2) you have to typecast when you use <iterator>,next()

    QCC:
    1) why did the API say that remove() removes the "last" returned item? Isn't it misleading?

    SUMMARY THE FIRST:
    hasNext() --> checks if there is a value after this index
    next() --> returns the next element in the list
    renmove() --> removes the last item in the list.

    SUMMARY THE SECOND:
    hasNext() --> checks if there is a item after this index
    next() --> returns the next element in the list
    remove() --> removes the most recently returned item from the collection. It then calls next()
**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    for(int e: L){
      if(e == key){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/

    Iterator it = L.iterator();
    while(it.hasNext()){
      int value = (int) it.next();

      if(value == key){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> odds = new ArrayList<>();

    for(Integer i : L){
      if(i % 2 == 1){
        odds.add(i);
      }
    }
    return odds;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> odds = new ArrayList<>();

    Iterator it = L.iterator();

    while(it.hasNext()){
      int value = (int) it.next();
      if(value % 2 == 1){
        odds.add(value);
      }
    }
    return odds;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {

    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while(it.hasNext()){
      int value = (int) it.next();
      if(value % 2 == 0){
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop

    for(Integer k : L){
      System.out.println(k);
    }

    System.out.println("\n");
    // b) explicitly using an iterator

    Iterator it = L.iterator();
    while(it.hasNext()){
      int value = (int) it.next();
      System.out.println(value);
    }

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);

    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
