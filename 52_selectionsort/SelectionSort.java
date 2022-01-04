// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent: 0.7 hrs

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 * Find the largest value within the dataset and swap its place with the largest
 * index of the dataset. Find the next largest value within the dataset and swap
 * its place with the next largest index of the dataset. This is repeated until
 * the next largest value and the next largest index are at the same position.
 *
 * DISCO
 * A method that returns a value can serve as an argument, while additionally
 * performing everything else instructed inside that method's invocation.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes (starting count from 1)
 * q1: What do you know after pass p?
 * a1: The element p-1 indices from the right is in its correct place.
 *     (assuming p starts count from 1)
 * q2: How do you know if sorted?
 * a2: maxPos is equal to the largest index in the dataset.
 * q3: What does a pass boil down to?
 * a3: A pass boils down to searching for the index possessing the highest value
 *     and swapping that with the next available index from the right.
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
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
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    // iterates until pass is 0
    for(int pass = data.size() - 1; pass > 0; pass--) {
      // System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
      maxPos = 0;

      // iterates until i <= pass, because the value at index pass+1 will already
      // have the correct value in it, as a result of the previous iteration of the
      // above for loop.
      for(int i = 0; i <= pass; i++) {

        // if the value at index maxPos < value at index i, update maxPos
        if ((data.get(maxPos)).compareTo(data.get(i)) < 0){
          maxPos = i;
        }

        // System.out.println( "maxPos: " + maxPos );//diag
        // System.out.println( data );//diag

      }

      // swap
      Comparable temp = data.get(pass);
      data.set(pass, data.get(maxPos));
      data.set(maxPos, temp);

      // System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args )
  {

    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
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
      ArrayList glen2Sorted = selectionSort( glen2 );
      System.out.println( "sorted version of ArrayList glen2:\n"
      + glen2Sorted );
      System.out.println( "ArrayList glen2 after sorting:\n" + glen2 );

      ArrayList coco2 = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
      ArrayList coco2Sorted = selectionSort( coco2 );
      System.out.println( "sorted version of ArrayList coco2:\n"
      + coco2Sorted );
      System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
      /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class SelectionSort
