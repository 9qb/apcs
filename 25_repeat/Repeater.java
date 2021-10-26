// Geese: Brian Li + Robert, Anthony Sun + Corn, Weichen Liu + Blueface
// APCS
// HW25 -- while and recursion
// 2021-10=26
// time spent: 0.4 hours

/*
DISCO
0. Recursion requires a base case and recursive reduction. In the recursive reduction, there has to be a means of getting to the base case and ending the recursive loop.
1. Our while loop requires an initialization, test (boolean expression), and increment.
QCC
0. Is it conventional to have two base cases? For example, for fenceR, we technically have two base cases: 0 and 1. Is this appropriate? Is there a better way to go about this?

*/

public class Repeater{
  // while loop method
  public static String fenceW(int numPosts){
    String output = "|";
    int counter = 1;
    if (numPosts == 0){
      output = "";
      return output;
    }
    while (counter < numPosts){
      counter++;
      output += "--|";
    }
    return output;
  }

  // recursive method
  public static String fenceR(int numPosts){
    if (numPosts == 1){
      return "|";
    }
    else if (numPosts == 0){
      return "";
    }
    else {
      return "|--" + fenceR(numPosts - 1);
    }
  }

  public static void main(String[] args){
    System.out.println("Testing fenceW()");
    System.out.println("Testing fenceW(0): " + fenceW(0));
    System.out.println("Testing fenceW(1): " + fenceW(1));
    System.out.println("Testing fenceW(5): " + fenceW(5));

    System.out.println();

    System.out.println("Testing fenceR()");
    System.out.println("Testing fenceR(0): " + fenceR(0));
    System.out.println("Testing fenceR(1): " + fenceR(1));
    System.out.println("Testing fenceR(5): " + fenceR(5));
  }
}
