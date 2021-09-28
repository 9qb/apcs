/**
Brian Li
APCS
HW05 -- Summer Prework
2021-09-27
*/

public class Methods{

  // Chapter 6, Exercise 2
  public static boolean isDivisible(int n, int m){
    return (n % m == 0);
  }

  // Chapter 6, Exercise 3
  public static boolean isTriangle(int leg1, int leg2, int leg3){
    return (leg1 + leg2 > leg3 && leg1 + leg3 > leg2 && leg2 + leg3 > leg1);
  }

  // Chapter 6, Exercise 8
  public static int ack(int m, int n){
    if (m < 0 || n < 0){
      System.err.println("Both m and n must be non-negative.");
      return -1;
    } else {
      if (m == 0){ // Base case
        return (n + 1);
      }
      else {
        if (m > 0 && n == 0){
          return ack(m - 1, 1);
        }
        else {
            return ack(m - 1, ack(m, n - 1));
        }
      }
    }
  }

  public static void main(String[] args){
    // TESTING EXERCISE 2
    System.out.println(isDivisible(8, 4)); // expecting true
    System.out.println(isDivisible(4, 3)); // expecting false

    // TESTING EXERCISE 3
    System.out.println(isTriangle(3, 4, 5)); // expecting true
    System.out.println(isTriangle(20, 2, 3)); // expecting false

    // TESTING EXERCISE 6
    System.out.println(ack(0, 1)); // expecting 2
    System.out.println(ack(3, 2)); // expcting 29
  }
}
