//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW84 - Stack: What Is It Good For?
//2022-03-29r
//time spent: class time + 1.0 hrs

/*
DISCO:
  - peek() will show you the item at the top of the stack without removing it
  - stacks can be useful for String reversal and matching brackets
  - _stackSize---1 decreases _stackSize by 1 while also subtracting 1
QCC:
  - why did we need to use peek() in our code? wouldn't the code work fine without it?
  */

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());
    String output = "";
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.substring(i, i+1));
    }
    for (int j = 0; j < s.length(); j++) {
      output += stack.pop();
    }
    return output;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    /*
    1) add s.substring(j,j+1) to stack if its an opening.
    2) if you encounter a closing, then peek the stack and the item should match the closing
    3) if it doesn't match, then its automatically false. else, pop stack.
    4) if it goes the whole way without a single mismatch and the stack is empty, then all the brackets match
    */

    final String opening = "{([";

    Latkes stackOpenings = new Latkes(s.length());

    for(int j = 0; j < s.length(); j++){ // populate the stack with the String
      String paren = s.substring(j, j+1);
      if (opening.indexOf(paren) > -1 ){ // checks if the character is an opening bracket
        stackOpenings.push(paren);
      }
      else if (stackOpenings.isEmpty()) { return false; } // checks for if ending brackets more than opening brackets
      else if ( ((paren.equals(")") && stackOpenings.peek().equals("("))) ||
                ((paren.equals("]") && stackOpenings.peek().equals("["))) ||
                ((paren.equals("}") && stackOpenings.peek().equals("{"))) ){
        stackOpenings.pop(); // remove matching opening brackets
      }
      else { return false; }
    } // close for loop
    if (!stackOpenings.isEmpty()){ return false; } // extra check for if opening brackets more than ending brackets
    return true;
  } // close allMatched



  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
