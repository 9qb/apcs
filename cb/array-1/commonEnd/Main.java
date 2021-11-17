// https://codingbat.com/prob/p191991

public class Main {
    public static void main(String[] args) {
      int[] test1_A = {1,2,3}; int[] test1_B = {7,3};
      int[] test2_A = {1,2,3}; int[] test2_B = {7,3,2};
      int[] test3_A = {1,2,3}; int[] test3_B = {1,3};

      System.out.println(commonEnd(test1_A, test1_B)); // true
      System.out.println(commonEnd(test2_A, test2_B)); // false
      System.out.println(commonEnd(test3_A, test3_B)); // true
    }

    /*
      Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.
    */

    public static boolean commonEnd(int[] a, int[] b) {
      if (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]){
        return true;
      }
      return false;
    }

  }
