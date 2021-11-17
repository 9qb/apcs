// https://codingbat.com/prob/p190968

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,3};
      int[] test2 = {1,1};
      int[] test3 = {1,1,1,1};

      System.out.println(sum2(test1)); // 3
      System.out.println(sum2(test2)); // 2
      System.out.println(sum2(test3)); // 2
    }

    /*
    Given an array of ints, return the sum of the first 2 elements in the array. If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.
    */

    public static int sum2(int[] nums) {
      if (nums.length >= 2){
        return nums[0] + nums[1];
      }
      else{
        if (nums.length == 0){
          return 0;
        }
        else{
          return nums[0];
        }
      }
    }

  }
