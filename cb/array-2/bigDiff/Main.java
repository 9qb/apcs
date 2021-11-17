// https://codingbat.com/prob/p196640

public class Main {
    public static void main(String[] args) {
      int[] test1 = {10,3,5,6};
      int[] test2 = {7,2,10,9};
      int[] test3 = {2,10,7,2};

      System.out.println(bigDiff(test1)); // 7
      System.out.println(bigDiff(test2)); // 8
      System.out.println(bigDiff(test3)); // 8
    }

    /*
    Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
    */

    public static int bigDiff(int[] nums) {
      int largest = 0;
      int smallest = nums[0];
      for (int counter = 0; counter < nums.length; counter++){
        largest = Math.max(nums[counter], largest);
        smallest = Math.min(nums[counter], smallest);
      }
      return largest - smallest;
    }

  }
