// NBJ: Nafiz Labib, Brian Li, Jefford Shau
// APCS
// HW27 -- for loops + recursion
// 2021-10-28
// time spent: 0.7 hours

/*
DISCO
0. When you want to use double quotation marks within a string, you must use \ before it to indicate to Java that it is not a part of the syntax.
1. The String.substring() method is overloaded: it can either take a single integer indicating its index and returns a String from that point to the end of the String, inclusive.
   It can also take two integers, determining the start and end index of the String to be returned, inclusive and exclusive, respectively.

QCC
0. Why did Java decide to make the second int parameter of String.substring() exclusive?
1. In what scenario would you want to use a while loop instead of a for loop?
*/

public class Rof{

  public static String fenceF(int posts){
    String post = "|";
    if (posts == 0){
      return "";
    }
    for(int i = 1; i < posts; i++){
      post += "--|";
    }
    return post;
  }

  public static String reverseF(String s){
    String reverse = "";
    for (int count = s.length() - 1; count >= 0; count--){
      reverse += s.substring(count, count + 1);
    }
    return reverse;
  }

  public static String reverseR(String s){
    if (s.length() == 1){ // base case
      return s;
    }
    else{ // recursive reduction
      return s.substring(s.length() - 1, s.length()) + reverseR(s.substring(0, s.length() - 1));
    }
  }

  public static void main(String[] args){
    System.out.println("Testing fenceF: ");
    System.out.println("fenceF(0): " + fenceF(0));
    System.out.println("fenceF(1): " + fenceF(1));
    System.out.println("fenceF(5): " + fenceF(5));
    System.out.println();

    System.out.println("Testing reverseF: ");
    System.out.println("reverseF(\"stressed\"): " + reverseF("stressed"));
    System.out.println("reverseF(\"qwertyuiop\"): " + reverseF("qwertyuiop"));
    System.out.println("reverseF(\"01134\"): " + reverseF("01134"));
    System.out.println();

    System.out.println("Testing reverseR: ");
    System.out.println("reverseR(\"stressed\"): " + reverseR("stressed"));
    System.out.println("reverseR(\"qwertyuiop\"): " + reverseR("qwertyuiop"));
    System.out.println("reverseR(\"01134\"): " + reverseR("01134"));
    System.out.println();
  }

}
