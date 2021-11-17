// https://codingbat.com/prob/p121853

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,2};
      int[] test2 = {1,2,1,2};
      int[] test3 = {2,1,2};

      System.out.println(has22(test1)); // true
      System.out.println(has22(test2)); // false
      System.out.println(has22(test3)); // false
    }

    /*
    Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
    */

    public static boolean has22(int[] nums) {
      for (int counter = 0; counter < nums.length; counter++){
        if (nums[counter] == 2 && counter + 1 < nums.length && nums[counter + 1] == 2){
          return true;
        }
      }
      return false;
    }

  }
