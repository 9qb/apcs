// https://codingbat.com/prob/p127384

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,2,1};
      int[] test2 = {1,1};
      int[] test3 = {1,2,2,1,13};

      System.out.println(sum13(test1)); // 6
      System.out.println(sum13(test2)); // 2
      System.out.println(sum13(test3)); // 6
    }

    /*
    Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
    */

    public static int sum13(int[] nums) {
      int sum = 0;
      for (int counter = 0; counter < nums.length; counter++){
        sum += nums[counter];
        if (nums[counter] == 13){
          sum -= 13;
          if (counter + 1 < nums.length && nums[counter + 1] != 13){
            sum -= nums[counter + 1];
          }
        }
      }
      return sum;
    }

  }
