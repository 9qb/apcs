// https://codingbat.com/prob/p112409

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,3};
      int[] test2 = {5,11,9};
      int[] test3 = {7,0,0};

      System.out.println(reverse3(test1)); // [3, 2, 1]
      System.out.println(reverse3(test2)); // [9, 11, 5]
      System.out.println(reverse3(test3)); // [0, 0, 7]
    }

    /*
      Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.
        */

  public static int[] reverse3(int[] nums) {
    int[] newA = new int[3];
    newA[0] = nums[2];
    newA[1] = nums[1];
    newA[2] = nums[0];
    return newA;
  }

  }
