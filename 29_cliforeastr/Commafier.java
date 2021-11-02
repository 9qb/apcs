// Geese - Brian Li + Robert, Anthony Sun + Corn, Weichen Liu + Blueface
// APCS
// HW29 -- Recursion, For, and Foreach
// 2021-11-01
// time spent: 0.7 hours

/*
DISCO
- You can use a foreach loop to loop through all the elements of an array.
- On top of basic primitives, such as int, there are larger classes, such as Integer.

QCC
- What is the point of having both int and Integer? Is there ever a point where we should create an instance of Integer over using int?
- Upon testing, it seems like 2147483647 is the largest argument we can provide within String[] args before returning a java.lang.NumberFormatException error. Why?
*/


public class Commafier {
    public static String commafyR(int input){
      String stringInput = Integer.toString(input);
      if (stringInput.length() <= 3){ // base case
        return stringInput;
      }
      else{ // recursive reduction
        return commafyR(Integer.parseInt(stringInput.substring(0, stringInput.length() - 3))) + "," + stringInput.substring(stringInput.length() - 3, stringInput.length());
      }
    }

    public static String commafyF(int input){
      String stringInput = Integer.toString(input);
      for (int counter = 3; counter < stringInput.length(); counter += 4){ // changes by 4 to account for extra comma character
        stringInput = stringInput.substring(0, stringInput.length() - counter) + "," + stringInput.substring(stringInput.length() - counter, stringInput.length());
      }
      return stringInput;
    }

    public static void main(String[] args) {
      // foreach loop
      for (String arg : args){
        int intArg = Integer.parseInt(arg);
        System.out.println(commafyR(intArg));
      }

      // Testing commafyR
      // System.out.println(commafyR(1));
      // System.out.println(commafyR(10));
      // System.out.println(commafyR(101));
      // System.out.println(commafyR(1000));
      // System.out.println(commafyR(12345));
      // System.out.println(commafyR(100000000));
      //
      // Testing commafyF
      // System.out.println(commafyF(1));
      // System.out.println(commafyF(10));
      // System.out.println(commafyF(101));
      // System.out.println(commafyF(1000));
      // System.out.println(commafyF(12345));
      // System.out.println(commafyF(100000000));
    }
}
