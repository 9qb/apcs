/**
Brian Li
APCS
HW05 -- Summer Prework
2021-09-27
*/

import java.util.Random;

public class Arrays{

  /** CHAPTER 8, EXERCISE 1 */
  // code taken and adapted from 8.6
  public static double[] powArray(double[] a, double power){
    double[] b = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = Math.pow(a[i], power);
    }
    return b;
  }

  // code taken and adapted from 8.10
  public static int[] histogram(int[] scores, int counterRange){
    int[] counts = new int[counterRange];
    for (int score : scores) {
      counts[score]++;
    }
    return counts;
  }

  // random array made for testing purposes, taken from 8.7 and tweaked
  public static int[] randomArray(int size) {
    Random random = new Random();
    int[] a = new int[size];
    for (int i = 0; i < a.length; i++) {
        a[i] = random.nextInt(size);
    }
    return a;
  }

  /** CHAPTER 8, EXERCISE 4 */
  public static int indexOfMax(int[] a){
    int currentIndexOfMax = 0;
    for (int index = 0; index < a.length; index++){
      if (a[currentIndexOfMax] < a[index]){
        currentIndexOfMax = index;
      }
    }
    return currentIndexOfMax;
  }

  /** CHAPTER 8, EXERCISE 5 */
  public static boolean[] sieve(int n){
    boolean[] sequence = new boolean[n];
    for (int initializer = 2; initializer < n; initializer++){
      sequence[initializer] = true;
    }
    for (int composite = 2; composite < n; composite++){
      if (sequence[composite]){
        for (int compositeMultiples = composite * 2; compositeMultiples < n;
        compositeMultiples += composite){
          sequence[compositeMultiples] = false;
        }
      }
    }
    return sequence;
  }

  // ==============================================================================

  public static void main(String[] args){
    double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // array for testing purposes
    int[] b = {3, 5, 1, 2, 8, 9, 11, 4, 21, 6, 0}; // array for testing purposes

    // Testing powArray
    System.out.println(java.util.Arrays.toString(powArray(a, 2)));
    System.out.println(java.util.Arrays.toString(powArray(a, 3)));

    System.out.println();

    // Testing histogram
    System.out.println(java.util.Arrays.toString(histogram(randomArray(100), 100)));
    System.out.println(java.util.Arrays.toString(histogram(randomArray(10), 10)));

    System.out.println();

    // Testing indexOfMax
    System.out.println(indexOfMax(b));
    /** An enhanced for loop cannot be used for this method because this method
    requires knowing which index an element is in, compared to other elements.
    An enhanced for loop is incapable of referring to the index. */

    System.out.println();

    // Testing sieve
    System.out.println(java.util.Arrays.toString(sieve(20)));
  }

}
