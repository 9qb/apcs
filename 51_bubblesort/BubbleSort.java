// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 0.6 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * In each pass, if the value at an index, n, is less than its preceding index, we swap places.
 * Each pass continues until reaching the index corresponding with the pass number.
 * This is repeated one less than the total elements in the dataset times.
 *
 * DISCO
 * Nested if statements can efficiently run through an algorithm multiple times.
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: The dataset is sorted.
 * q1: After pass p, what do you know?
 * a1: The value in index p is in its correct sorted position.
 * q2: How many passes are necessary to completely sort?
 * a2: One less than the total number of elements in the dataset allows for
 *     a complete sort.
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    // outside for loop allowing for maximum traversal in ascending order
    // (a value at index 0 can move all the way to the largest index in the dataset)
    for (int i = 0; i < data.size(); i++){

      // from the last index, sorts until reaching index i in descending order
      // (because after pass 0, the value at index 0 will be correct.
      // it becomes pointless to search for a potential sort at that index again.)
      for (int n = data.size() - 1; n > i; n--){

        // if the value at index n is less than the value at index n-1, swap
        if ((data.get(n)).compareTo(data.get(n-1)) < 0){
          Comparable temp = data.get(n);
          data.set(n, data.get(n-1));
          data.set(n-1, temp);
        }
      }
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    // makes new cloned dataset, sorts it, and returns it
    ArrayList temp = new ArrayList<Comparable>();
    for (Comparable element : input){
      temp.add(element);
    }
    bubbleSortV(temp);
    return temp;
  }


  public static void main( String [] args )
  {

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*===============for VOID methods=============
      ============================================*/

      ArrayList glen2 = new ArrayList<Integer>();
      glen2.add(7);
      glen2.add(1);
      glen2.add(5);
      glen2.add(12);
      glen2.add(3);
      System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
      ArrayList glen2Sorted = bubbleSort( glen2 );
      System.out.println( "sorted version of ArrayList glen2:\n"
      + glen2Sorted );
      System.out.println( "ArrayList glen2 after sorting:\n" + glen2 );

      ArrayList coco2 = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
      ArrayList coco2Sorted = bubbleSort( coco2 );
      System.out.println( "sorted version of ArrayList coco2:\n"
      + coco2Sorted );
      System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
      /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class BubbleSort
