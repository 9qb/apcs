//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW86 - What a Racket
//2022-03-31r
//time spent: 1.7 hrs + class time

/*
DISCO
- .split() makes it much easier to eliminate whitespace.
- You can use multiple stacks to track different things.

QCC
- Is there a better way to do subtraction with a stack?
*/

/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the string into an array of strings, without the whitespace
     2. Push strings into corresponding stack (operation, everything else)
     3. If the string is a closing paren, evaluate all values before the next
        open paren.
          Your operation is popped from the operation stack.
          Your values are popped from the arr stack.
          Pop the opening paren in the arr stack, and then push the evaluated
          value to the arr stack.
     4. Repeat until you have iterated thru the entire expression.
     5. Return the popped value of the arr stack, which is your final answer.
 *
 * STACK OF CHOICE: Stack by java.util.Stack
 * b/c ... An imported library eliminates clutter, and there is no limitation
           on the length of the Stack.
 **/

import java.util.Stack;

public class Scheme
{

  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] temp = expr.split("\\s+");
    Stack<String> arr = new Stack<String>();
    Stack<Integer> ops = new Stack<Integer>();

    // separates into operations and everything else
    for (int i = 0; i < temp.length; i++){
      // checks for operation
      if (temp[i].equals("+")){ ops.push(1); }
      else if (temp[i].equals("-")){ ops.push(2); }
      else if (temp[i].equals("*")){ ops.push(3); }

      // checks for everything else
      else if (temp[i].equals("(") || isNumber(temp[i])){ arr.push(temp[i]); }
      else{ // temp[i] = ), marks the end of some arithmetic to be performed
        String placeholder = unload(ops.pop(), arr);
        arr.pop(); // pops opening paren
        arr.push(placeholder); // pushes evaluated value
      }
    }

    return arr.pop(); // returns the only thing left in the stack, the final value
  }//end evaluate()

  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int val = 0;
    if (op == 1){
      while (!numbers.peek().equals("(")){
        val += Integer.parseInt(numbers.pop());
      }
    }
    else if (op == 2){ // in subtraction, we must go in the reverse order of the stack
      int x = 0;
	    while(!numbers.peek().equals("(")){
		    x = Integer.parseInt(numbers.pop());
		    val -= x;
	    }
	    val = val + x + x;
    }
    else{ // else, op == 3
      val = 1;
      while (!numbers.peek().equals("(")){
        val *= Integer.parseInt(numbers.pop());
      }
    }
    return val + "";
  }//end unload()


  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
