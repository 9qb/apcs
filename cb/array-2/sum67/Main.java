// https://codingbat.com/prob/p111327

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,2};
      int[] test2 = {1,2,2,6,99,99,7};
      int[] test3 = {1,1,6,7,2};

      System.out.println(sum67(test1)); // 5
      System.out.println(sum67(test2)); // 5
      System.out.println(sum67(test3)); // 4
    }

    /*
    Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
    */

    public static int sum67(int[] nums) {
      int sum = 0;
      for (int counter = 0; counter < nums.length; counter++){
        sum += nums[counter];
        if (nums[counter] == 6){
          for (int post6Counter = counter; nums[post6Counter] != 7; post6Counter++){
            if (nums[post6Counter + 1] == 7){
              counter = post6Counter + 1;
            }
          }
          sum -= 6;
        }
      }
      return sum;
    }
  }
