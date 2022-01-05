// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: 0.4 hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * With a partition within the dataset, beginning from the left, all values
 * to the left of the partition are to be sorted. After sorting, the partition
 * shifts one value right and the new inserted value is to be sorted accordingly
 * with the other values to the left of the partition. This process repeats until
 * there are no more values to the right of the partition.
 *
 * DISCO
 * Insertion Sort has a very similar nested for loop as Bubble Sort.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes
 * q1: What do you know after pass p?
 * a1: The first p+1 elements are sorted relative to each other.
 *     (assuming that the first element by itself does not count as a pass)
 * q2: How will you know when sorted?
 * a2: There are no elements to the right of the partition.
 * q3: What constitues a pass?
 * a3: The shift of the partition one element right and the sorting of all
 *     elements to the left of that partition.
 * q4: What must you track?
 * a4: The position of the partition.
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
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
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for(int partition = 0; partition < data.size(); partition++) {
      //partition marks first item in unsorted region

      // System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      // System.out.println( data );

      //traverse sorted region from right to left
      for(int i = partition; i > 0; i--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items

        // if index i < index i-1, swap
        if ((data.get(i)).compareTo(data.get(i-1)) < 0) {

          // System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag

          // swap
          Comparable temp = data.get(i);
          data.set(i, data.get(i-1));
          data.set(i-1, temp);

        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      /*===============for VOID methods=============
      ============================================*/

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen2 = new ArrayList<Integer>();
      glen2.add(7);
      glen2.add(1);
      glen2.add(5);
      glen2.add(12);
      glen2.add(3);
      System.out.println( "\nArrayList glen2 before sorting:\n" + glen2 );
      ArrayList glen2Sorted = insertionSort( glen2 );
      System.out.println( "\nsorted version of ArrayList glen2:\n"
      + glen2Sorted );
      System.out.println( "\nArrayList glen2 after sorting:\n" + glen2 );

      ArrayList coco2 = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco2 before sorting:\n" + coco2 );
      ArrayList coco2Sorted = insertionSort( coco2 );
      System.out.println( "\nsorted version of ArrayList coco2:\n"
      + coco2Sorted );
      System.out.println( "\nArrayList coco2 after sorting:\n" + coco2 );
      /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class InsertionSort
