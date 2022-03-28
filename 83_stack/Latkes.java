//(P)BNJ -- Brian Li, Jefford Shau, Nakib Abedin
//APCS pd07
//HW83 - Stacks on Stacks
//2022-03-28r
//time spent: class time

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO
      - We thought of the end of the array as the top of the stack and this helped us implement the methods.
      - The array and its size are encapsulated/hidden, while the methods are not.
    QCC
      - How is this activiy different from all of the other array activities we have been doing?
 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    _stackSize = 0;
    _stack = new String[initCapacity];
  }// O(1)


  //means of insertion
  public void push( String s )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    if(!isFull()){
      _stack[_stackSize] = s;
      _stackSize ++;
    }
  }// O(1)


  //means of removal
  public String pop( )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    if(!isEmpty()){
      String temp = _stack[_stackSize - 1];
      _stack[_stackSize - 1] = null;
      _stackSize --;
      return temp;
    }
    return null;
  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    return _stackSize == 0;
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    return _stackSize == _stack.length;
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {

    Latkes tastyStack = new Latkes(12);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)

    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
