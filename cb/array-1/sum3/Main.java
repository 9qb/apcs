// https://codingbat.com/prob/p175763

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,3};
      int[] test2 = {5,11,2};
      int[] test3 = {7,0,0};

      System.out.println(sum3(test1)); // 6
      System.out.println(sum3(test2)); // 18
      System.out.println(sum3(test3)); // 7
    }

    /*
    Given an array of ints length 3, return the sum of all the elements.
    */

    public static int sum3(int[] nums) {
      return nums[0] + nums[1] + nums[2];
    }

  }
