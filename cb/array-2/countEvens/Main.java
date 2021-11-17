// https://codingbat.com/prob/p162010

public class Main {
    public static void main(String[] args) {
      int[] test1 = {2,1,2,3,4};
      int[] test2 = {2,2,0};
      int[] test3 = {1,3,5};

      System.out.println(countEvens(test1)); // 3
      System.out.println(countEvens(test2)); // 3
      System.out.println(countEvens(test3)); // 0
    }

    /*
    Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
    */

    public static int countEvens(int[] nums) {
      int accumulator = 0;
      for (int counter = 0; counter < nums.length; counter++){
        if (nums[counter] % 2 == 0){
          accumulator += 1;
        }
      }
      return accumulator;
    }

  }
