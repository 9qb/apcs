// https://codingbat.com/prob/p185139

public class Main {
    public static void main(String[] args) {
      int[] test1 = {1,2,3};
      int[] test2 = {5,11,9};
      int[] test3 = {7,0,0};

      System.out.println(rotateLeft3(test1)); // [2, 3, 1]
      System.out.println(rotateLeft3(test2)); // [11, 9, 5]
      System.out.println(rotateLeft3(test3)); // [0, 0, 7]
    }

    /*
    Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.
    */

  public static int[] rotateLeft3(int[] nums) {
    int[] newA = new int[3];
    newA[0] = nums[1];
    newA[1] = nums[2];
    newA[2] = nums[0];
    return newA;
  }


  }
