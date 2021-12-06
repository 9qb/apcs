// Peanut Butter and Nutella - Prattay Dey + Winnie, Brian Li + Robert, Nafiz Labib + Martha
// APCS pd6
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-07
// time spent: 0.4 hours

/*
DISCO
- You can reassign an array variable to another array entirely.
- You can invoke a method that returns a value without ever using the returned value.
QCC
- What happens to the original array when a variable is reassigned away from it? Does it get deleted?
*/


/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String stringified = "[";
    for (int i = 0; i < _data.length; i++){
      stringified += _data[i] + ",";
    }
    stringified = stringified.substring(0, stringified.length() - 1) + "]"; // removes last comma, appends closing bracket
    return stringified;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[_data.length * 2];
    for (int i = 0; i < _data.length; i++){ // populate new array
      temp[i] = _data[i];
    }
    _data = temp; // reassign _data
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
