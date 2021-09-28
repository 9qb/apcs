/**
Brian Li
APCS
HW05 -- Summer Prework
2021-09-27
*/

public class Loops{
  // Chapter 7, Exercise 3
  public static double power(double x, int n){
    int counter;
    double num = 1;
    for (counter = 0; counter < n; counter++){
      num *= x;
    }
    return num;
  }

  // Chapter 7, Exercise 4
  public static int factorial(int n){
    int numToMultiplyBy;
    for (numToMultiplyBy = n - 1; numToMultiplyBy > 0; numToMultiplyBy--){
      n *= numToMultiplyBy;
    }
    return n;
  }

  // Chapter 7, Exercise 5
  public static double myexp(double x, int n){
    int counter;
    double numerator = 1;
    double denominator = 1;
    double nextTerm;
    double eToTheX = 1;
    for (counter = 0; counter < n; counter++){
      numerator *= x;
      denominator *= counter + 1;
      nextTerm = numerator / denominator;
      eToTheX += nextTerm;
    }
    return eToTheX;
  }

  public static String check(double x){
    String displayRow = x + "\t" + myexp(x, 17) + "\t" + Math.exp(x);
    return displayRow;
  }

  public static void main(String[] args){
    // TESTING power
    System.out.println(power(3, 4)); // expecting 81
    System.out.println(power(1.5, 2)); // expecting 2.25

    // TESTing factorial
    System.out.println(factorial(6)); // expecting 720
    System.out.println(factorial(10)); // expecting 3628800

    // TESTING myexp AND check
    // Exercise 5, Step 5
    int termCount;
    double termCheck = 0.1;
    for (termCount = 0; termCount < 4; termCount++){
      System.out.println(check(termCheck));
      termCheck *= 10;
    }
    /**
    The result becomes less accurate as the value of x moves further away from 1.
    With 0.1 and 1, there are 16 digits of agreement. With 10, there is only
    one digit of agreement. With 100, there are no digits of agreement.
    */

    // Exercise 5, Step 6
    termCheck = -0.1;
    for (termCount = 0; termCount < 4; termCount++){
      System.out.println(check(termCheck));
      termCheck *= 10;
    }
    /**
    The results for -0.1 and -1 are as accurate as their inverse counterparts.
    With -10 and -100, there are no digits of agreement.
    */

  }
}
