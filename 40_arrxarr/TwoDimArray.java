/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW40 -- 2D arrays
// 2021-11-30

/*
DISCO
- You can use a for loop within a for loop to iterate through the different "layers" of arrays when it comes to arrays of arrays.
- You can get the length of a subarray by doing array[row].length.
- Subarrays still hold all properties of normal arrays.

QCC
- Are enhanced for loops always better when it comes to working with arrays? In what cases would you prefer a normal for loop?
*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    String stringified;
    for (int arrCounter = 0; arrCounter < a.length; arrCounter++){
      stringified = "{";
      for (int i = 0; i < a[arrCounter].length; i++){
        stringified += a[arrCounter][i] + ", ";
      }
      stringified = stringified.substring(0, stringified.length() - 2) + "}";
      System.out.println(stringified);
    }
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    String foreachStringified;
    for(int[] subarray : a){
      foreachStringified = "{";
      for(int value : subarray){
        foreachStringified += value + ", ";
      }
      foreachStringified = foreachStringified.substring(0, foreachStringified.length() - 2) + "}";
      System.out.println(foreachStringified);
    }
  }


  // postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int accumulator = 0;
    for(int[] subarray : a){
      for(int value : subarray){
        accumulator += value;
      }
    }
    return accumulator;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int accumulator = 0;
    for (int i = 0; i < m.length; i++){
      accumulator += sumRow2(i, m);
    }
    return accumulator;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int accumulator = 0;
    for (int i = 0; i < a[r].length; i++){
      accumulator += a[r][i];
    }
    return accumulator;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int summer = 0;
    for(int value : m[r]){
      summer += value;
    }
    return summer;
  }


  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray
