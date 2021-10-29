// Snowball - Brian Li + Robert, Jun Hong Wang + Bob
// APCS
// HW24 -- while loops
// 2021-10-25
// time spent: 1.0 hours

/*
DISCO
0. In order to access the value of a private instance variable belonging to another class, you must use a public method provided that returns the variable. You cannot access it directly.
1. Using a while loop requires a terminating condition, otherwise your loop will go on forever. 
QCC
0. When flipping until "x heads have come up", is that referring to heads coming up from both yours and wayne? Or only from yours/wayne?
POST-v0 MODS
0. changed constructors to refer to itself via this()
1. made use of assignValue() in constructor
*/

// skeleton taken from closet

public class Coin {

  //attributes aka instance vars
  private double value;
  private String upFace;
  private String name;
  private int flipCtr;
  private int headsCtr;
  private int tailsCtr;
  private double bias = 0.5; // set to no bias by default

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    reset("heads", 0.5);
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    this();
    name = s;
    assignValue(s);
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    this(s);
    upFace = nowFace;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (s == "penny"){
      value = 0.01;
    }
    else if (s == "nickel"){
      value = 0.05;
    }
    else if (s == "dime"){
      value = 0.10;
    }
    else if (s == "quarter"){
      value = 0.25;
    }
    else if (s == "half dollar"){
      value = 0.50;
    }
    else if (s == "dollar"){
      value = 1.00;
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) { // initial coin name and value are kept the same
    upFace = s;
    bias = d;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/

  public String flip() {
    if (bias < Math.random()){
      upFace = "tails";
      tailsCtr++;
    }
    else {
      upFace = "heads";
      headsCtr++;
    }
    flipCtr++;
    return upFace;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    return this.upFace == other.upFace;
  }

  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/

  public String toString() {
    return name + " -- " + upFace;
  }

}//end class
