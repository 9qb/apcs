/*
(P)BNJ (Jefford Shau, Nakib Abedin, Brian Li)
APCS pd07
HW72 -- So So Fast
2022-03-08
time spent: 1.5hr + class time

ALGO:
Use partition() on the array, with the pivot index being an arbitrary index (in our case, the middle index)
  If the adjusted index of the pivot is equal to the index y-1, you have the yth largest value.
  If the adjusted index of the pivot is > index y-1, run partition() again with the pivot index as the hiBound.
  Otherwise, the adjusted index of the pivot is < index y-1, so run partition() with the pivot index as the loBound.

BEST CASE SCENARIO:
O(n) --> if you get lucky with the selection of the pivot, then you will complete the process in one pass so the runtime is the runtime of the partition ( which is n) * 1 so O(n)
WORST CASE SCENARIO:
O(n^2) --> if you get unlucky with the partition, then you will have iterated through the entire array before finding the yth smallest value. The runtime would be the runtime of the partition (n) * (n) so O(n^2). We think this only happens if the adjusted pivot index is the lowest/highest values at one of the ends at each pass.
DISCO:
1) We found that recursion was the best way to solve this problem.
2) Instead of adding a splitter as a parameter, we used a newPivotIndex.
3) The closer a value would be to the middle in a sorted array, the quicker the algorithm will be.
QCC:
1) Why didn't our algorithm work with a randomly selected newPivotIndex(Math.random())? We thought that the number didn't matter?

*/

public class FastSelect{
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
      System.out.print( o + ", " );
    System.out.println();
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int mysterion(int[],int,int,int)
   * Partitions an int array into two subarrays.
   * Elements to the left of splitIndex are less than splitValue.
   * Elements to the right of splitIndex are greater than splitValue.
   * Adjusts the splitValue to the index that satisfies the above.
   *
   * @param arr
   * @param a = loBound, beginning bound to consider partitioning
   * @param b = hiBound, end bound to consider partitioning
   * @param c = splitIndex, index of the val that all elements in bounds are placed relative to
   * @return int = # of elements before splitIndex
   *
   */
  public static int partition( int arr[], int loBound, int hiBound, int pivotIndex)
  {
    int pivotVal = arr[pivotIndex];
    swap(pivotIndex, hiBound, arr); // moves splitVal to the end
    int s = loBound;
    for (int i = loBound; i < hiBound; i++){
      if (arr[i] < pivotVal){ // moves values < splitVal to next spot where a swap hasn't already happened
        swap(s, i, arr);
        s += 1;
      }
    }
    swap(hiBound, s, arr); // moves splitVal to the correct index
    return s; // returns new index of pivotVal
  }//end mysterion

  // find yth smallest value in array
  // y starts at 1 (i.e. smallest value is when y == 1)
  public static int findSmallest(int[] arr, int loBound, int hiBound, int y){

    int newPivotIndex = partition(arr, loBound, hiBound, (loBound + hiBound) / 2);

    if (newPivotIndex == y - 1){
      return arr[newPivotIndex];
    }
    else if (newPivotIndex > y - 1){
      return findSmallest(arr, loBound, newPivotIndex, y);
    }
    else{
      return findSmallest(arr, newPivotIndex, hiBound, y);
    }
  }

  public static void main(String[] args) {
    // lowest
    int[] test1 = {6,4,15,8,19,12,11,7,2,0,5,3,20};
    printArr(test1);
    System.out.println("Value of 1st smallest (smallest value): " + findSmallest(test1, 0, 12, 1));

    // highest
    int[] test2 = {6,4,15,8,19,12,11,7,2,0,5,3,20};
    printArr(test2);
    System.out.println("Value of 13th smallest (largest value): " + findSmallest(test2, 0, 12, 13));

    int[] test3 = {6,4,15,8,19,12,11,7,2,0,5,3,20};
    printArr(test3);
    System.out.println("Value of 6th smallest: " + findSmallest(test3, 0, 12, 6));

    int[] test4 = {6,4,15,8,19,12,11,7,2,0,5,3,20};
    printArr(test4);
    System.out.println("Value of 8th smallest: " + findSmallest(test4, 0, 12, 8));

    // BEST case
    // desired value is directly in the middle
    int[] bestCase = {1,0,2};
    printArr(bestCase);
    System.out.println("Value of 1st smallest: " + findSmallest(bestCase, 0, 2, 1));

    // WORST case
    // desired value is at the extremes at each pass
    int[] worstCase = {1,2,0};
    printArr(worstCase);
    System.out.println("Value of 1st smallest: " + findSmallest(worstCase, 0, 2, 1));


  }
}
