// https://codingbat.com/prob/p199612

public class Main {
    public static void main(String[] args) {
      int[] test1 = {2,3,2,2,4,2};
      int[] test2 = {2,3,2,2,4,2,2};
      int[] test3 = {1,2,3,4};

      System.out.println(sum28(test1)); // true
      System.out.println(sum28(test2)); // false
      System.out.println(sum28(test3)); // false
    }

    /*
    Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
    */

    public static boolean sum28(int[] nums) {
      int accumulatorOf2 = 0;
      for (int counter = 0; counter < nums.length; counter++){
        if (nums[counter] == 2){
          accumulatorOf2 += 2;
        }
      }
      return accumulatorOf2 == 8;
    }

  }
