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
 The pivot is chosen as the median index between the loPos and hiPos.
 **/


public class Partition
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
   * int partition(int[],int,int)
   * Partitions an int array into two subarrays.
   * Elements to the left of splitIndex are less than splitValue.
   * Elements to the right of splitIndex are greater than splitValue.
   * Adjusts the splitValue to the index that satisfies the above.
   *
   * @param arr input array of ints
   * @param loPos
   * @param hiPos
   * The pivot is chosen as the median index between the loPos and hiPos.
   * @return int position of pvt
   *
   */
  public static int partition( int arr[], int loPos, int hiPos)
  {
    int v = arr[(loPos + hiPos) / 2];

    swap( (loPos + hiPos) / 2, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;
      }
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition


  //main method for testing
  // public static void main( String[] args )
  // {
  //
  //   //init test arrays of magic numbers
  //   int[] arr1 = {8,21,17,69,343};
  //   int[] arr3 = {1,28,33,4982,37};
  //   int[] arr4 = {5,4,17,9000,6};
  //   int[] arr5 = {3,0,16,599,1024};
  //
  //
  //   // run partition on each array,
  //   // holding loPos & hiPos fixed, varying pvtPos...
  //   for( int testPIVOT = 0; testPIVOT < 5; testPIVOT++ ) {
  //     System.out.println("arr1: ");
  //     printArr(arr1);
  //     partition(arr1,0,4,testPIVOT);
  //     System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
  //                        + testPIVOT +"...");
  //     printArr(arr1);
  //     System.out.println("-----------------------");
  //
  //     System.out.println("arr3:");
  //     printArr(arr3);
  //     partition(arr3,0,4,testPIVOT);
  //     System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
  //                        + testPIVOT +"...");
  //     printArr(arr3);
  //     System.out.println("-----------------------");
  //
  //     System.out.println("arr4:");
  //     printArr(arr4);
  //     partition(arr4,0,4,testPIVOT);
  //     System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
  //                        + testPIVOT +"...");
  //     printArr(arr4);
  //     System.out.println("-----------------------");
  //
  //     System.out.println("arr5:");
  //     printArr(arr5);
  //     partition(arr5,0,4,testPIVOT);
  //     System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
  //                        + testPIVOT +"...");
  //     printArr(arr5);
  //     System.out.println("-----------------------");
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  //   }
  // }//end main

}//end class Partition
