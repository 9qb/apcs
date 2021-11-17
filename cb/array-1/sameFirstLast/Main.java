// https://codingbat.com/prob/p118976

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,3};
      int[] test2 = {1,2,3,1};
      int[] test3 = {1,2,1};

      System.out.println(sameFirstLast(test1)); // false
      System.out.println(sameFirstLast(test2)); // true
      System.out.println(sameFirstLast(test3)); // true
    }

    /*
    Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.
    */

    public static boolean sameFirstLast(int[] nums) {
    if (nums.length >= 1 && nums[0] == nums[nums.length - 1]){
      return true;
    }
    return false;
  }

  }
