//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW72 -- QuickSort
//2022-03-09w
//time spent: 1.5 hr + class time

/**
DISCO
- Using a median index as a pivot fixes a bug with encountering duplicates while the pivot index is 0.
- QuickSort's time complexity depends on the values of the pivot. If the values of the pivot are around the center, then it can run just as fast as mergesort.
QCC
- What other positions in the array can you use as a pivot index?
- Why use QuickSort over MergeSort if MergeSort's worst case is an order of magnitude quicker than QuickSort?
**/

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * qsort(arr): calls qsortHelper with loPos = 0 and hiPos = largest possible index (arr.length -1)
 * qsortHelper(): calls partition() (with the middle index being the initial pivot) and then makes a recursive call on the values before the final pivot position and the values after the final pivot position.
 *                after partition() is called, if the subarray holds 2 or less indices, the subarray is deemed sorted and returns.
 * 2a. Worst pivot choice and associated run time:
 * Worst pivot choice is the highest/lowest value in the unsorted region eachtime.
 * This would be n^2 since you are essentially sorting through without creating sections that are less than the pivot and sections that are greater than the pivot.
 *
 * 2b. Best pivot choice and associated run time:
 * Best pivot choice would be the median value.
 * This would have a runtime of nlogn since we would be splitting the array into two halves and that has a runtime of log n
 * We multiply log(n) by n (the runtime of partition) to get nlogn
 *
 * 3. Approach to handling duplicate values in array:
 * Our pivot is the median index in the array. With partition(), if we come across a value equal to the pivot value, we still increment s by 1 until iterating to hiPos.
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsortHelper(d, 0, d.length - 1);
  }

  // helper method so we can split the array
  public static void qsortHelper(int[] d, int loPos, int hiPos){
    if (loPos < hiPos){ // avoid errors (stackoverflow & out of bounds)
      int pvtIndex = Partition.partition(d, loPos, hiPos); // element at pvtIndex already in right position

      // if partition is done on an array of size 2, we know both elements sorted
      if (d.length <= 2){ // base case
        return;
      }
      else{ // recursive reduction
        // sorts unsorted elements
        // why -1 and +1?
        // because the element at pvtIndex is already known to be in its final pos after running partition()
        qsortHelper(d, loPos, pvtIndex - 1); // sorts one half
        qsortHelper(d, pvtIndex + 1, hiPos); // sorts other half
      }
    }
  }

  //you may need a helper method...

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    // worst case
    int[] worstCase = {4,1,2,0,3,1,5};
    System.out.println("\narrMatey init'd to: " );
    printArr(worstCase);

    qsort( worstCase );
    System.out.println("arrMatey after sort: " );
    printArr(worstCase);

    // best case
    int[] bestCase = {1,2,3,4,5,6,7};
    System.out.println("\narrMatey init'd to: " );
    printArr(bestCase);

    qsort( bestCase );
    System.out.println("arrMatey after sort: " );
    printArr(bestCase);

  }//end main

}//end class QuickSort
