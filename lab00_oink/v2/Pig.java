/***
 * Aliens - Weichen Liu + Blueface, Brian Li + Robert, Lior Polischouk + Toothless)
 * APCS
 * Lab v0 -- Pig Latin Work
 * 2021-11-09
 * time spent: 0.9 hrs
 *
 * DISCO
 * - Scanner.next() checks for the next word in the input.
 * - Scanner.nextLine() returns the entire input.
 *
 * QCC
 * - What is the most efficient loop that goes through every word in the input that we give Scanner?
 *
 * HOW WE UTILIZED SCANNER DEMO (v2)
 * - We used the while loop with the .hasNext(), but instead of using .next(), we used .nextLine() to check the entirety of the input on the line. We did this to consider inputs that have more than one word.
 *
 * WHAT CAUSES THE RUNTIME ERROR IN THE SCANNER DEMO
 * - The scanner runs .next() twice on an input that only has one word on one line.
 * 
 * NEW IN v2
 * - actual implementation of ScannerDemo
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/


import java.util.Scanner;

public class Pig {

  private static final String VOWELS = "aeiouy";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";


  /**
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p") -> false
  **/
  public static boolean hasA( String w, String letter ) {

    return w.indexOf(letter) != -1;

    /* equiv code, wo using indexOf()...
       boolean ans = false;

       for( int i = 0; i < w.length(); i++ ) {

       if ( w.substring(i,i+1).equals(letter) ) {
       ans = true;
       //Q: is there a more efficient way?
       }
       }
       return ans;
    */
  }//end hasA()


  /**
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    **/
  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }


  /**
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    **/
  public static int countVowels( String w ) {

    return allVowels(w).length();

    /* long version using for
       int numVowels = 0; //init vowels counter var
       //must touch each letter in word, so use FOR
       for( int i = 0; i < w.length(); i++ ) {

       if ( isAVowel( w.substring(i,i+1) ) )
       numVowels++;
       }
       return numVowels;
    */
  }


  /**
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz") -> false
    **/
  public static boolean hasAVowel( String w ) {
    return countVowels(w) != 0;
  }


  /**
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    **/
  public static String allVowels( String w ) {

    String ans = ""; //init return String

    for( int i = 0; i < w.length(); i++ ) {

      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }


  /**
    String firstVowel(String) -- returns first vowel in a String
    pre:  w != null
    post: firstVowel("") --> ""
    firstVowel("zzz") --> ""
    firstVowel("meatball") --> "e"
    **/
  public static String firstVowel( String w ) {

    String ans = "";

    if ( hasAVowel(w) ) //Q: Why this necess?
      ans = allVowels(w).substring(0,1);

    return ans;
  }


  /**
    boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
    pre:  w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
    **/
  public static boolean beginsWithVowel( String w ) {
    return VOWELS.indexOf( w.substring(0,1) ) != -1;
  }

  /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
			return PUNCS.indexOf( symbol ) != -1;
    }


    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/
    public static boolean isUpperCase( String letter ) {
      return CAPS.indexOf(letter) != -1;
    }


    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc("cat.") -> true
            hasPunc("cat") -> false
      =====================================*/
    public static boolean hasPunc( String w ) {
      for (int counter = 0; counter < w.length(); counter++){
          if ((PUNCS.indexOf(w.substring(counter, counter + 1))) > -1){
            return true;
          }
      }
      return false;
    }



    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/
    public static boolean beginsWithUpper( String w ) {
	     return isUpperCase(w.substring(0,1) );
    }

    /**
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      **/
    public static String engToPig( String w ) {

      String ans = "";

      if ( beginsWithVowel(w) && (!(w.substring(0,1).equals("y"))) )
        ans = w + "way";

      else {
        int vPos = w.indexOf( firstVowel(w.substring(1)) ); // finds first vowel, skips over y if y is the first character
        ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
      }

      return ans;
    }

    public static String newEngToPig( String w) {
    String end = "";
    String ans = "";

    if (PUNCS.indexOf(w.substring( w.length() - 1, w.length() ) ) > -1){ // checks for presence of punctuation
      end = w.substring(w.length() - 1, w.length());
      w = w.substring(0, w.length() - 1);
    }

    if (beginsWithUpper(w)) {
      String lowerW = w.toLowerCase();
      ans = engToPig(lowerW).substring(0,1).toUpperCase() + engToPig(lowerW).substring(1);
    } else {
      ans = engToPig(w);
    }

    return ans + end;
    }

    public static String pigifyScan(String input){
      String reduction = input;
      if (!(hasA(reduction, " "))){ // base case, checks if it is only one word
        return newEngToPig(reduction);
      }
      else{ // recursive reduction
        return newEngToPig(reduction.substring(0, reduction.indexOf(" "))) + " " + pigifyScan(reduction.substring(reduction.indexOf(" ") + 1));
      }
    }

    public static void main( String[] args ) {
      String input = "";
      Scanner scan = new Scanner(System.in);
      // System.out.println("Please give an input in English that you want to translate to Pig Latin.");
      // input = scan.nextLine();
      // System.out.println(pigifyScan(input));
      while (scan.hasNext()){
        input = scan.nextLine();
        System.out.println(pigifyScan(input));
      }

  }//end main()

}//end class Pig
